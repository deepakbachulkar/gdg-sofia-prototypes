package com.gdg.sofia.android.decorating.widgets;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.MotionEvent;
import android.view.View;

/**
 * A class that should allow for decorating view pagers
 * 
 * @author boris.strandjev
 */
public class ViewPagerDecoration {
    private ViewPagerDecoration viewPagerDecoration;
    protected DecoratedViewPager viewPager;

    /** Decoration for {@link OnPageChangeListener} that can be extended in the further extending classes. */
    protected class DecoratedOnPageChangeListener implements OnPageChangeListener {
        private OnPageChangeListener pageChangeListener;

        public DecoratedOnPageChangeListener(OnPageChangeListener pageChangeListener) {
            this.pageChangeListener = pageChangeListener;
        }

        @Override
        public void onPageSelected(int position) {
            if (pageChangeListener != null) {
                pageChangeListener.onPageSelected(position);
            }
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if (pageChangeListener != null) {
                pageChangeListener.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            if (pageChangeListener != null) {
                pageChangeListener.onPageScrollStateChanged(state);
            }
        }
    }

    public ViewPagerDecoration() {
    }

    public ViewPagerDecoration(ViewPagerDecoration viewPagerDecoration) {
        this.viewPagerDecoration = viewPagerDecoration;
    }

    /** Method that can be used to add logic to the constructor of the decorated view pager. */
    public void decorateConstructor(ViewPager viewPager) {
        if (viewPagerDecoration != null) {
            viewPagerDecoration.decorateConstructor(viewPager);
        }
    }

    /**
     * Decorates the given listener
     * 
     * @param listener The on page change listener to decorate.
     * @return The decorate on page listener
     */
    public OnPageChangeListener decorateOnPageChangeListener(OnPageChangeListener listener) {
        if (viewPagerDecoration != null) {
            return viewPagerDecoration.decorateOnPageChangeListener(listener);
        } else {
            return listener;
        }
    }

    /**
     * Adds logic to the on intercept touch event of the view pager.
     * 
     * @param event the event that was intercepted.
     */
    public void decorateOnInterceptTouchEvent(MotionEvent event) {
        if (viewPagerDecoration != null) {
            viewPagerDecoration.decorateOnInterceptTouchEvent(event);
        }
    }

    // this method is deliberately package protected. */
    void setViewPager(DecoratedViewPager viewPager) {
        this.viewPager = viewPager;
        if (viewPagerDecoration != null) {
            viewPagerDecoration.setViewPager(viewPager);
        }
    }

    /** Returns the index'th child of the decorated {@link ViewPager} */
    protected View getCurrentView() {
        DecoratedPagerAdapter pagerAdapter = viewPager.getDecoratedPagerAdapter();
        return pagerAdapter.getViewAtPosition(getCurrentItem());
    }

    /** Returns the index of the current item in the decorated {@link ViewPager} */
    protected int getCurrentItem() {
        return viewPager.getCurrentItem();
    }

    /** Returns the adapter of the decorated {@link ViewPager} */
    protected PagerAdapter getAdapter() {
        return viewPager.getAdapter();
    }
}
