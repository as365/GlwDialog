package com.glh.glwdialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;


/**
 * <p>
 *
 * @author :高磊华
 * @version :0.2.0
 * @date : 2018/08/09
 * desc    : 确认 弹窗
 * </pre>
 */

public class ConfirmDialog extends BaseNiceDialog {

    private String contentStr;

    /**
     * 默认右上角的× 是显示的
     * true: 显示
     * false:不显示
     */
    private boolean isShowIvClose = true;

    /**
     * 默认是两个按钮
     */
    private int btnNum = AppGlobal.BTN_NUM_DOUBLE;

    public static ConfirmDialog newInstance(String contentStr) {
        return newInstance(contentStr, true);
    }

    public static ConfirmDialog newInstance(String contentStr, boolean isShowIvClose) {
        return newInstance(contentStr, isShowIvClose, AppGlobal.BTN_NUM_DOUBLE);
    }

    public static ConfirmDialog newInstance(String contentStr, int btnNum) {
        return newInstance(contentStr, true, btnNum);
    }

    public static ConfirmDialog newInstance(String contentStr, boolean isShowIvClose, int btnNum) {

        Bundle bundle = new Bundle();
        bundle.putString("contentStr", contentStr);
        bundle.putBoolean("isShowIvClose", isShowIvClose);
        if (btnNum == AppGlobal.BTN_NUM_DOUBLE || btnNum == AppGlobal.BTN_NUM_SINGLE) {
            bundle.putInt("btnNum", btnNum);
        } else {
            throw new IllegalArgumentException("按钮数量不符合要求,必须为1或2个");
        }

        ConfirmDialog dialog = new ConfirmDialog();
        dialog.setArguments(bundle);
        return dialog;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle == null) {
            return;
        }
        contentStr = bundle.getString("contentStr");
        isShowIvClose = bundle.getBoolean("isShowIvClose");
        btnNum = bundle.getInt("btnNum");
    }

    @Override
    public int intLayoutId() {
        return R.layout.dialog_confirm;
    }

    private OnConfirmDialogLitener mOnDialogSureLitener;

    public ConfirmDialog setOnDialogSureLitener(OnConfirmDialogLitener mOnDialogSureLitener) {
        this.mOnDialogSureLitener = mOnDialogSureLitener;
        return this;
    }

    @Override
    public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {

        holder.setText(R.id.tv_content, contentStr);
        holder.setViewVisible(R.id.iv_close, isShowIvClose ? View.VISIBLE : View.GONE);

        holder.setOnClickListener(R.id.tv_sure, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                if (mOnDialogSureLitener != null) {
                    mOnDialogSureLitener.onConfirmDialogSureClick();
                }
            }
        });

        if (btnNum == AppGlobal.BTN_NUM_DOUBLE) {
            holder.setViewVisible(R.id.tv_negative, View.VISIBLE);
            holder.setOnClickListener(R.id.tv_negative, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
        } else if (btnNum == AppGlobal.BTN_NUM_SINGLE) {
            holder.setViewVisible(R.id.tv_negative, View.GONE);
        }


        if (isShowIvClose) {
            holder.setOnClickListener(R.id.iv_close, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
        }
    }
}
