package com.codegama.weatherforcast.util;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.DisplayMetrics;
import android.view.WindowManager;


public class DisplayUtils {

    public static int getCasinoColor(int color) {
        return color;
    }


    public static int getScreenWidth(Context context) {
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    public static int getScreenHeight(Context context) {
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;
    }

    public static int getActionBarHeightInPx(Context context) {
        final TypedArray styledAttributes = context.getTheme().obtainStyledAttributes(
                new int[]{android.R.attr.actionBarSize});
        int mActionBarSize = (int) styledAttributes.getDimension(0, 0);
        styledAttributes.recycle();
        return mActionBarSize;
    }

    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources()
                .getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public static float pxToDp(float px) {
        float densityDpi = Resources.getSystem().getDisplayMetrics().densityDpi;
        return px / (densityDpi / 160f);
    }

    public static int dpToPx(float dp) {
        float density = Resources.getSystem().getDisplayMetrics().density;
        return Math.round(dp * density);
    }

//    public static String getStaticPageUrl(StaticPage staticPage) {
//        switch (staticPage) {
//            case STATIC_PAGE_HELP:
//                return Urls.HELP;
//            case STATIC_PAGE_ABOUT:
//                return Urls.ABOUT;
//            case STATIC_PAGE_TERMS:
//                return Urls.TERMS;
//            case STATIC_PAGE_LEGALITY:
//                return Urls.LEGALITY;
//            case STATIC_PAGE_PRIVACY:
//                return Urls.PRIVACY;
//        }
//        return Urls.BASE_URL;
//    }
}
