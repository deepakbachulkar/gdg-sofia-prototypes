package com.gdg.sofia.android.decorating.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gdg.sofia.android.decorating.R;
import com.gdg.sofia.android.decorating.helpers.IOHelper;

/**
 * Loads the hardcoded pages in a view pager.
 *
 * @author Boris Strandjev
 */
public class SamplePagerAdapter extends PagerAdapter {
    private static final String LOG_TAG = SamplePagerAdapter.class.getSimpleName();
    // For the purposes of demonstration this is being hardcoded
    private static final int PAGE_COUNT = 5;
    /** The string format to use to construct the name of the file of a given page. */
    private static final String PAGE_FILE_FORMAT = "pages/page_%02d.txt";

    private Context context;

    public SamplePagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Log.v(LOG_TAG, "Instantiating the item");
        View itemLayout = ViewGroup.inflate(context, R.layout.page_layout, null);
        TextView pageText = (TextView) itemLayout.findViewById(R.id.page_text);
        String pageFileName = String.format(PAGE_FILE_FORMAT, position + 1);
        pageText.setText(IOHelper.getAssetFileContents(context.getAssets(), pageFileName));
        ((ViewPager) container).addView(itemLayout, 0);
        return itemLayout;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }
}
