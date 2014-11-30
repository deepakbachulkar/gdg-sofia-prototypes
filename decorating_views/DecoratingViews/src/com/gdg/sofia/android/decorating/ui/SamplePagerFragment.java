package com.gdg.sofia.android.decorating.ui;

import java.lang.reflect.Field;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gdg.sofia.android.decorating.R;
import com.gdg.sofia.android.decorating.adapters.SamplePagerAdapter;
import com.gdg.sofia.android.decorating.widgets.NotifyOutOfBoundsViewPager;
import com.gdg.sofia.android.decorating.widgets.NotifyOutOfBoundsViewPager.OnSwipeOutListener;

public class SamplePagerFragment extends Fragment implements OnSwipeOutListener {
    private static String LOG_TAG = SamplePagerFragment.class.getSimpleName();

    private class ViewPagerFactory implements Factory {
        private static final String VIEW_PAGER = "android.support.v4.view.ViewPager";

        private Factory mBaseFactory;

        public ViewPagerFactory(Factory factory) {
            this.mBaseFactory = factory;
        }

        @Override
        public View onCreateView(String name, Context context, AttributeSet attrs) {
            if (name.equals(VIEW_PAGER)) {
                ViewPager viewPager = new ViewPager(context, attrs);
                return new NotifyOutOfBoundsViewPager(context, attrs, viewPager);
            } else {
                if (mBaseFactory != null) {
                    return mBaseFactory.onCreateView(name, context, attrs);
                } else {
                    return null;
                }
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        try {
            Field field = LayoutInflater.class.getDeclaredField("mFactorySet");
            field.setAccessible(true);
            field.setBoolean(inflater, false);
            inflater.setFactory(new ViewPagerFactory(this.getActivity()));
        } catch (IllegalAccessException e) {
            Log.e(LOG_TAG, "Error while tweaking the inflator factory");
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e) {
            Log.e(LOG_TAG, "Error while tweaking the inflator factory");
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            Log.e(LOG_TAG, "Error while tweaking the inflator factory");
            throw new RuntimeException(e);
        }
        return inflater.inflate(R.layout.sample_pager_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        NotifyOutOfBoundsViewPager viewPager = (NotifyOutOfBoundsViewPager) getView().findViewById(R.id.samplePager);
        viewPager.setOnSwipeOutListener(this);
        viewPager.setAdapter(new SamplePagerAdapter(getActivity()));
    }

    @Override
    public void onSwipeOutAtStart() {
        Toast.makeText(getActivity(), R.string.pages_finished, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSwipeOutAtEnd() {
        Toast.makeText(getActivity(), R.string.pages_finished, Toast.LENGTH_SHORT).show();
    }
}
