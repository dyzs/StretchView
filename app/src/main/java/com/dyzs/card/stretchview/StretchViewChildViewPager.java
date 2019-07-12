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
public class StretchViewChildViewPager extends ViewPager implements NestedScrollingChild2 {
    private static final String TAG = StretchViewChildViewPager.class.getSimpleName();
    private int mTouchSlop;

    public StretchViewChildViewPager(@NonNull Context context) {
        super(context);
        mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public StretchViewChildViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private float xDistance, yDistance, xLast, yLast;

    private ViewDragHelper mViewDragHelper;
    public void injectViewDragHelper(ViewDragHelper helper) {
        this.mViewDragHelper = helper;
    }
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        LogUtils.v(TAG, "消费事件....：" + ev.getAction());
        /*switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                xDistance = yDistance = 0f;
                xLast = ev.getX();
                yLast = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                final float curX = ev.getX();
                final float curY = ev.getY();

                xDistance += Math.abs(curX - xLast);
                yDistance += Math.abs(curY - yLast);
                xLast = curX;
                yLast = curY;
                if (xDistance > yDistance) {
                    return super.onTouchEvent(ev);
                } else {
                    LogUtils.v("onTouchEvent", "不拦截事件....");
                    getParent().requestDisallowInterceptTouchEvent(false);
                    return false;
                }
        }
        boolean superReturn=super.onTouchEvent(ev);
        return !isDownForIntercept&&superReturn;*/
        // return super.onTouchEvent(ev);
        return super.onTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        LogUtils.v(TAG, "拦截事件....：" + ev.getAction());
        /*switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                xDistance = yDistance = 0f;
                xLast = ev.getX();
                yLast = ev.getY();
                isDownForIntercept = true;
                break;
            case MotionEvent.ACTION_MOVE:
                final float curX = ev.getX();
                final float curY = ev.getY();

                if (isDownForIntercept) {
                    xDistance += Math.abs(curX - xLast);
                    yDistance += Math.abs(curY - yLast);
                    xLast = curX;
                    yLast = curY;
                    isDownForIntercept= xDistance>yDistance ;
                    LogUtils.v("onInterceptTouchEvent", "xDistance....：" + xDistance+"   yDistance:"+yDistance);
                }
        }
        LogUtils.v("onInterceptTouchEvent", "分发事件....：" + isDownForIntercept);
        return isDownForIntercept||super.onInterceptTouchEvent(ev);*/
        // return super.onInterceptTouchEvent(ev);
        return super.onInterceptTouchEvent(ev);
    }

    private boolean isDownForIntercept = true;

    @Override
    public boolean startNestedScroll(int i, int i1) {
        return false;
    }

    @Override
    public void stopNestedScroll(int i) {

    }

    @Override
    public boolean hasNestedScrollingParent(int i) {
        return false;
    }

    @Override
    public boolean dispatchNestedScroll(int i, int i1, int i2, int i3, @Nullable int[] ints, int i4) {
        return false;
    }

    @Override
    public boolean dispatchNestedPreScroll(int i, int i1, @Nullable int[] ints, @Nullable int[] ints1, int i2) {
        return false;
    }
}
