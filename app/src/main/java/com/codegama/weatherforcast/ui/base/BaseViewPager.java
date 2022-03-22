package com.codegama.weatherforcast.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.viewpager.widget.ViewPager;

public class BaseViewPager extends ViewPager {
    private Boolean disable = true;

    public BaseViewPager(Context context) {
        super(context);
    }

    public BaseViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return !disable && super.onInterceptTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return !disable && super.onTouchEvent(event);
    }

    public void disableScroll(Boolean disable) {
        //When disable = true not work the scroll and when disble = false work the scroll
        this.disable = disable;
    }
}
