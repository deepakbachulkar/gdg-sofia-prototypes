package com.gdg.sofia.android.decorating.widgets;

import android.view.MotionEvent;

/**
 * View pager decoration based on <a
 * href="http://stackoverflow.com/questions/13346824/viewpager-detect-when-user-is-trying-to-swipe-out-of-bounds"> this
 * post</a>.
 * 
 * @author Boris Strandjev
 */
public class ViewPagerDecorationNotifyOutOfBounds extends ViewPagerDecoration {

    public ViewPagerDecorationNotifyOutOfBounds(OnSwipeOutListener listener) {
        super();
        this.listener = listener;
    }

    public ViewPagerDecorationNotifyOutOfBounds(ViewPagerDecoration decoration, OnSwipeOutListener listener) {
        super(decoration);
        this.listener = listener;
    }

    private float mStartDragX;
    private OnSwipeOutListener listener;

    @Override
    public void decorateOnInterceptTouchEvent(MotionEvent ev) {
        float x = ev.getX();
        switch (ev.getAction()) {
        case MotionEvent.ACTION_DOWN:
            mStartDragX = x;
            break;
        case MotionEvent.ACTION_MOVE:
            if (mStartDragX < x && getCurrentItem() == 0) {
                listener.onSwipeOutAtStart();
            } else if (mStartDragX > x && getCurrentItem() == getAdapter().getCount() - 1) {
                listener.onSwipeOutAtEnd();
            }
            break;
        }
        super.decorateOnInterceptTouchEvent(ev);
    }

    public interface OnSwipeOutListener {
        public void onSwipeOutAtStart();

        public void onSwipeOutAtEnd();
    }

}