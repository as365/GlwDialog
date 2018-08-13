package com.glh.glwdialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;


/**
 * <p>
 *
 * @author :高磊华
 * @version :0.3.0
 * @date : 2018/08/13
 * desc    : 拍照功能 弹窗
 * </pre>
 */

public class TakePhotoDialog extends BaseNiceDialog {

    public static TakePhotoDialog newInstance() {
        Bundle bundle = new Bundle();
        TakePhotoDialog dialog = new TakePhotoDialog();
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

    }

    @Override
    public int intLayoutId() {
        return R.layout.dialog_take_photo;
    }

    private OnTakePhotoDialogLitener mOnTakePhotoDialogLitener;
    private int                  mPhotoType;

    public TakePhotoDialog setOnTakePhotoDialogLitener(OnTakePhotoDialogLitener mOnTakePhotoDialogLitener) {
        this.mOnTakePhotoDialogLitener = mOnTakePhotoDialogLitener;
        return this;
    }

    @Override
    public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {

        holder.setOnClickListener(R.id.dialog_photo, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareplatform(R.id.dialog_photo, dialog);
            }
        });

        holder.setOnClickListener(R.id.dialog_gallery, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareplatform(R.id.dialog_gallery, dialog);
            }
        });

        holder.setOnClickListener(R.id.dialog_cancel, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareplatform(R.id.dialog_cancel, dialog);
            }
        });

    }

    private void shareplatform(int viewId, BaseNiceDialog dialog) {
        dialog.dismiss();
        if (mOnTakePhotoDialogLitener != null) {
            if (viewId == R.id.dialog_photo) {
                mPhotoType = 0;
                mOnTakePhotoDialogLitener.onTakePhotoDialogTypeClick(0);
            } else if (viewId == R.id.dialog_gallery) {
                mPhotoType = 1;
                mOnTakePhotoDialogLitener.onTakePhotoDialogTypeClick(1);
            }
        }
    }
}
