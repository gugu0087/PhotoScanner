package com.xyc.gugu.picturescanner;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Created by hasee on 2018/5/22.
 */

public class NoInterceptView extends RelativeLayout {
    public NoInterceptView(Context context) {
        super(context);
    }

    public NoInterceptView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

}
