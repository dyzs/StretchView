package com.dyzs.card.stretchview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.NestedScrollingChild2;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/**
 * Created by dyzs on 2019/7/11.
 */
public class StretchViewChildViewPager extends ViewPager{
    private static final String TAG = StretchViewChildViewPager.class.getSimpleName();

    public StretchViewChildViewPager(@NonNull Context context) {
        super(context);
    }

    public StretchViewChildViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean parentIntercept=interceptListener==null?false:interceptListener.isIntercepted();
        return !parentIntercept&&super.onInterceptTouchEvent(ev);
    }

    private ParentInterceptListener interceptListener;
    public void setParentInterceptListener(ParentInterceptListener listener){
        this.interceptListener=listener;
    }
}
