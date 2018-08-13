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
 * desc    : 分享 弹窗
 * </pre>
 */

public class ShareDialog extends BaseNiceDialog {

    /**
     * 默认是 内部、外部均分享
     */
    private int mShareType = AppGlobal.SHARE_WITH_INTSIDE;

    public static ShareDialog newInstance(int mShareType) {

        Bundle bundle = new Bundle();
        if (mShareType == AppGlobal.SHARE_ONLY_OUTSIDE || mShareType == AppGlobal.SHARE_WITH_INTSIDE) {
            bundle.putInt("mShareType", mShareType);
        } else {
            throw new IllegalArgumentException("分享类型不符合要求,要么是只分享到外部,要么内外均有");
        }

        ShareDialog dialog = new ShareDialog();
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

        mShareType = bundle.getInt("mShareType");
    }

    @Override
    public int intLayoutId() {
        return R.layout.dialog_share;
    }

    private OnShareDialogLitener mOnShareDialogLitener;
    private int                  mPlatform;

    public ShareDialog setOnOnShareDialogLitener(OnShareDialogLitener mOnShareDialogLitener) {
        this.mOnShareDialogLitener = mOnShareDialogLitener;
        return this;
    }

    @Override
    public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {

        if (mShareType == AppGlobal.SHARE_ONLY_OUTSIDE) {
            holder.setViewVisible(R.id.chatRoom, View.GONE);
            holder.setViewVisible(R.id.ll_silkbag, View.GONE);

            holder.setOnClickListener(R.id.wechat, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    shareplatform(R.id.wechat, dialog);
                }
            });



        } else if (mShareType == AppGlobal.SHARE_WITH_INTSIDE) {
            holder.setViewVisible(R.id.chatRoom, View.VISIBLE);
            holder.setViewVisible(R.id.ll_silkbag, View.VISIBLE);

            holder.setOnClickListener(R.id.wechat, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    shareplatform(R.id.wechat, dialog);
                }
            });

            holder.setOnClickListener(R.id.chatRoom, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    shareplatform(R.id.chatRoom, dialog);
                }
            });

        }
    }

    private void shareplatform(int viewId, BaseNiceDialog dialog) {
        dialog.dismiss();
        if (mOnShareDialogLitener != null) {
            if (viewId == R.id.wechat) {
                mPlatform = 0;
                mOnShareDialogLitener.onShareDialogTypeClick(0);
            } else if (viewId == R.id.chatRoom) {
                mPlatform = 1;
                mOnShareDialogLitener.onShareDialogTypeClick(1);
            }
        }
    }
}
