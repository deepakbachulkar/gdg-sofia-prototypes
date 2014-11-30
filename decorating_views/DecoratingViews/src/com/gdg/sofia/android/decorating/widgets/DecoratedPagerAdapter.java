package com.gdg.sofia.android.decorating.widgets;

import android.database.DataSetObserver;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

/**
 * Decoration of {@link PagerAdapter} that should allow for tracking the item's positions.
 * 
 * @author Boris Strandjev
 */
class DecoratedPagerAdapter extends PagerAdapter {
    private PagerAdapter pagerAdapter;
    /** Stores the views in the actual position of the adapter. */
    private SparseArray<View> instantiatedViewsSparsedArray;
    private ViewPager viewPager;

    public DecoratedPagerAdapter(ViewPager viewPager, PagerAdapter decoratedPagerAdapter) {
        this.pagerAdapter = decoratedPagerAdapter;
        decoratedPagerAdapter.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                notifyDataSetChanged();
            }
        });
        this.viewPager = viewPager;
        this.instantiatedViewsSparsedArray = new SparseArray<View>();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Object object = pagerAdapter.instantiateItem(container, position);
        ViewPager viewPager = (ViewPager) container;
        int childCount = viewPager.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = viewPager.getChildAt(i);
            if (isViewFromObject(child, object)) {
                instantiatedViewsSparsedArray.put(position, child);
                break;
            }
        }
        return object;
    }

    @Override
    public int getItemPosition(Object object) {
        int childCount = viewPager.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = viewPager.getChildAt(i);
            if (isViewFromObject(child, object)) {
                return i;
            }
        }
        return POSITION_NONE;
    }

    /**
     * @param position the position in the adapter of the view we are interested in.
     * @return The view at position {@code position} in the adapter or null if it has not been initialized.
     */
    View getViewAtPosition(int position) {
        return instantiatedViewsSparsedArray.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
        instantiatedViewsSparsedArray.remove(position);
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return pagerAdapter.isViewFromObject(arg0, arg1);
    }

    @Override
    public int getCount() {
        return pagerAdapter.getCount();
    }

    /**
     * The method is deliberately package-protected.
     * 
     * @return The pager adapter that is wrapped with current view tracking pager adapter.
     */
    PagerAdapter getPagerAdapter() {
        return pagerAdapter;
    }
}
