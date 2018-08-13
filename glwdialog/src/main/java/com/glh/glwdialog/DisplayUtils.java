package com.glh.glwdialog;

import android.content.Context;

/**
 * author : 高磊华
 * e-mail : 984992087@qq.com
 * time   : 2018\1\10
 * desc   : 与屏幕有关的工具类
 */

public class DisplayUtils {

    /**
     * 将dip和dp转化成px,保证尺寸大小不变。
     * @param dpValue
     * @return
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }



    /**
     * 将px值转换成dpi或者dp值，保持尺寸不变
     * @param context
     * @param pxValue
     * @return
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将px转化成sp,保证文字大小不变。
     *
     * @param content
     * @param pxValus
     * @return
     */
    public static int px2sp(Context content, float pxValus) {
        final float fontScale = content.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValus / fontScale + 0.5f);
    }

    /**
     * 将sp转化成px,保证文字大小不变。
     *
     * @param content
     * @param pxValus
     * @return
     */
    public static int sp2px(Context content, float pxValus) {
        final float fontScale = content.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValus * fontScale + 0.5f);
    }


    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

}
