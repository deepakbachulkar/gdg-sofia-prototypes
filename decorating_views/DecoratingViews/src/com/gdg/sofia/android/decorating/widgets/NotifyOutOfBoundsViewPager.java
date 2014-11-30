package com.gdg.sofia.android.decorating.widgets;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * View pager that notifies when the final page is reached. Taken from <a
 * href="http://stackoverflow.com/questions/13346824/viewpager-detect-when-user-is-trying-to-swipe-out-of-bounds"> this
 * post</a>.
 *
 * @author Boris Strandjev
 *
 */
public class NotifyOutOfBoundsViewPager extends DecoratedViewPager {
    public interface OnSwipeOutListener {
        public void onSwipeOutAtStart();

        public void onSwipeOutAtEnd();
    }

    private float mStartDragX;
    private OnSwipeOutListener onSwipeOutListener;

    public NotifyOutOfBoundsViewPager(Context context, ViewPager viewPager) {
        super(context, viewPager);
    }

    public NotifyOutOfBoundsViewPager(Context context, AttributeSet attrs, ViewPager viewPager) {
        super(context, attrs, viewPager);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        float x = ev.getX();
        switch (ev.getAction()) {
        case MotionEvent.ACTION_DOWN:
            mStartDragX = x;
            break;
        case MotionEvent.ACTION_MOVE:
            if (mStartDragX < x && getCurrentItem() == 0) {
                onSwipeOutListener.onSwipeOutAtStart();
            } else if (mStartDragX > x && getCurrentItem() == getAdapter().getCount() - 1) {
                onSwipeOutListener.onSwipeOutAtEnd();
            }
            break;
        }
        return super.onInterceptTouchEvent(ev);
    }

    public void setOnSwipeOutListener(OnSwipeOutListener listener) {
        this.onSwipeOutListener = listener;
    }
}
