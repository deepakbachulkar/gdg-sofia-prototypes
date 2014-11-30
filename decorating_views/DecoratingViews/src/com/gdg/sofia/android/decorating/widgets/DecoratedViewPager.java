package com.gdg.sofia.android.decorating.widgets;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * An extended {@link ViewPager} that allows decorations to be added to it.
 * 
 * @author Boris Strandjev
 */
public class DecoratedViewPager extends ViewPager {
    private ViewPagerDecoration decoration;

    public DecoratedViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DecoratedViewPager(Context context) {
        super(context);
    }

    public void setDecoration(ViewPagerDecoration decoration) {
        this.decoration = decoration;
        decoration.setViewPager(this);
        decoration.decorateConstructor(this);
    }

    @Override
    public void setOnPageChangeListener(OnPageChangeListener listener) {
        if (decoration != null) {
            super.setOnPageChangeListener(decoration.decorateOnPageChangeListener(listener));
        } else {
            super.setOnPageChangeListener(listener);
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (decoration != null) {
            decoration.decorateOnInterceptTouchEvent(event);
        }
        return super.onInterceptTouchEvent(event);
    }

    @Override
    public void setAdapter(PagerAdapter adapter) {
        super.setAdapter(new DecoratedPagerAdapter(this, adapter));
    }

    @Override
    public PagerAdapter getAdapter() {
        DecoratedPagerAdapter adapter = getDecoratedPagerAdapter();
        return adapter.getPagerAdapter();
    }

    /**
     * This method is deliberately package protected.
     * 
     * @return the decorating pager adapter that adds tracking of the current view.
     */
    DecoratedPagerAdapter getDecoratedPagerAdapter() {
        return (DecoratedPagerAdapter) super.getAdapter();
    }
}
