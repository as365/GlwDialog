package com.glh.glwdialog;

/**
 * <pre>
 *     author : 高磊华
 *     e-mail : 984992087@qq.com
 *     time   : 2018/08/10
 *     desc   : app一般性常量
 *     version: 1.0
 * </pre>
 */

public interface AppGlobal {

    /**
     * 使用dialogFragment形式的常量
     * <p>
     * int BTN_NUM_SINGLE = 1;  一个按钮,且为确认
     * int BTN_NUM_DOUBLE = 2;  两个按钮,左边取消,右边确认
     * <p>
     * int SHOW_GRAVITY_CENTER = 0; 弹窗显示位置.居中
     * int SHOW_GRAVITY_BOTTOM = 1; 底部
     * int SHOW_GRAVITY_TOP    = 2; 上边
     */
    int BTN_NUM_SINGLE = 1;
    int BTN_NUM_DOUBLE = 2;

    int SHOW_GRAVITY_CENTER = 0;
    int SHOW_GRAVITY_BOTTOM = 1;
    int SHOW_GRAVITY_TOP    = 2;

}
