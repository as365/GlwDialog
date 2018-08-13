package com.glh.glwdialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;


/**
 * <p>
 *
 * @author :高磊华
 * @version :0.4.0
 * @date : 2018/08/13
 * desc    : 版本升级 弹窗
 * </pre>
 */

public class UpVisionDialog extends BaseNiceDialog {

    /**
     * 默认是 强制升级
     * 只有一个按钮
     */
    private int btnNum = AppGlobal.BTN_NUM_SINGLE;

    /**
     * 是否是强制升级.
     * 默认强制升级
     */
    private boolean isForceUp = true;


    private String contentStr;

    public static UpVisionDialog newInstance(String contentStr) {
        return newInstance(contentStr, true);
    }

    public static UpVisionDialog newInstance(String contentStr, boolean isForceUp) {

        Bundle bundle = new Bundle();
        bundle.putBoolean("isForceUp", isForceUp);
        bundle.putString("contentStr", contentStr);
        UpVisionDialog dialog = new UpVisionDialog();
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

        isForceUp = bundle.getBoolean("isForceUp");
        contentStr = bundle.getString("contentStr", contentStr);
    }

    @Override
    public int intLayoutId() {
        return R.layout.dialog_double_upversion;
    }

    private OnUpVisionDialogLitener mOnUpVisionDialogLitener;
    private boolean                 mUpVisionType;

    public UpVisionDialog setOnUpVisionDialogLitener(OnUpVisionDialogLitener
                                                          mOnUpVisionDialogLitener) {
        this.mOnUpVisionDialogLitener = mOnUpVisionDialogLitener;
        return this;
    }

    @Override
    public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {

        if (isForceUp) {
            holder.setViewVisible(R.id.tv_cancel, View.GONE);
        } else {
            holder.setViewVisible(R.id.tv_cancel, View.VISIBLE);
        }

        holder.setText(R.id.tv_content, contentStr);

        holder.setOnClickListener(R.id.tv_sure, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareplatform(R.id.tv_sure, dialog);
            }
        });

        holder.setOnClickListener(R.id.tv_cancel, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareplatform(R.id.tv_cancel, dialog);
            }
        });


    }

    private void shareplatform(int viewId, BaseNiceDialog dialog) {
        dialog.dismiss();
        if (mOnUpVisionDialogLitener != null) {
            if (viewId == R.id.tv_sure) {
                mOnUpVisionDialogLitener.onUpVisionDialogTypeClick();
            }
        }
    }
}
