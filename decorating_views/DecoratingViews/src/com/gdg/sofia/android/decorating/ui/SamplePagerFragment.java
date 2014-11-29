package com.gdg.sofia.android.decorating.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gdg.sofia.android.decorating.R;
import com.gdg.sofia.android.decorating.adapters.SamplePagerAdapter;
import com.gdg.sofia.android.decorating.widgets.NotifyOutOfBoundsViewPager;
import com.gdg.sofia.android.decorating.widgets.NotifyOutOfBoundsViewPager.OnSwipeOutListener;

public class SamplePagerFragment extends Fragment implements OnSwipeOutListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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
