package com.glh.glwdialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_button);

        findViewById(R.id.btn0).setOnClickListener(this);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn0:
                showDialog0();
                break;
            case R.id.btn1:
                showDialog1();
                break;
            case R.id.btn2:
                showDialog2();
                break;
            case R.id.btn3:
                showDialog3();
                break;
            case R.id.btn4:
                showDialog4();
                break;
            case R.id.btn5:
                showDialog5();
                break;
            default:
                break;
        }
    }


    private void showDialog0() {
        ConfirmDialog.newInstance("测试数据测试测试测试")
                .setOnDialogSureLitener(new OnConfirmDialogLitener() {
                    @Override
                    public void onConfirmDialogSureClick() {
                        Toast.makeText(MainActivity.this, "被点击了..00", Toast.LENGTH_SHORT).show();
                    }
                })
                .setMargin(30)
                .setOutCancel(false)
                .show(getSupportFragmentManager());

    }

    private void showDialog1() {
        ConfirmDialog.newInstance("测试数据测试测试测试", false)
                .setOnDialogSureLitener(new OnConfirmDialogLitener() {
                    @Override
                    public void onConfirmDialogSureClick() {
                        Toast.makeText(MainActivity.this, "被点击了..111", Toast.LENGTH_SHORT).show();
                    }
                })
                .setMargin(30)
                .setOutCancel(false)
                .show(getSupportFragmentManager());

    }

    private void showDialog2() {
        ConfirmDialog.newInstance("测试数据测试测试测试", 1)
                .setOnDialogSureLitener(new OnConfirmDialogLitener() {
                    @Override
                    public void onConfirmDialogSureClick() {
                        Toast.makeText(MainActivity.this, "被点击了..222", Toast.LENGTH_SHORT).show();
                    }
                })
                .setMargin(30)
                .setOutCancel(true)
                .show(getSupportFragmentManager());

    }

    /**
     * 分享
     */
    private void showDialog3() {

        ShareDialog.newInstance(1).setOnShareDialogLitener(new OnShareDialogLitener() {
            @Override
            public void onShareDialogTypeClick(int mPlatform) {
                Toast.makeText(MainActivity.this, mPlatform + "....", Toast.LENGTH_SHORT).show();
            }
        }).setOutCancel(true)
                .show(getSupportFragmentManager());
    }

    private void showDialog4() {

        TakePhotoDialog.newInstance().setOnTakePhotoDialogLitener(new OnTakePhotoDialogLitener() {
            @Override
            public void onTakePhotoDialogTypeClick(int mPlatform) {
                Toast.makeText(MainActivity.this, mPlatform + "....", Toast.LENGTH_SHORT).show();
            }
        })
                .setMargin(30)
                .setShowGrivity(AppGlobal.SHOW_GRAVITY_BOTTOM)
                .show(getSupportFragmentManager());
    }

    private void showDialog5() {

        UpVisionDialog.newInstance("优化bug", false).setOnUpVisionDialogLitener(new OnUpVisionDialogLitener() {

            @Override
            public void onUpVisionDialogTypeClick() {
                Toast.makeText(MainActivity.this, "升级中", Toast.LENGTH_SHORT).show();
            }
        })
                .setOutCancel(false).show(getSupportFragmentManager());
    }
}
