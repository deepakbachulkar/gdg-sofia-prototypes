package com.gdg.sofia.android.decorating.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gdg.sofia.android.decorating.R;
import com.gdg.sofia.android.decorating.adapters.SamplePagerAdapter;
import com.gdg.sofia.android.decorating.helpers.SampleCountDownTimer;
import com.gdg.sofia.android.decorating.widgets.DecoratedViewPager;
import com.gdg.sofia.android.decorating.widgets.ViewPagerDecorationNotifyOutOfBounds;
import com.gdg.sofia.android.decorating.widgets.ViewPagerDecorationNotifyOutOfBounds.OnSwipeOutListener;
import com.gdg.sofia.android.decorating.widgets.ViewPagerDecorationTimer;

public class SamplePagerFragment extends Fragment implements OnSwipeOutListener {
    private static String LOG_TAG = SamplePagerFragment.class.getSimpleName();
    private static int DURATION = 10 * 60 * 1000; // 10 minutes

    static private SampleCountDownTimer countDownTimer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // we define the timer to be static so that we do nto restart counting every time we are brought to front.
        if (countDownTimer == null) {
            countDownTimer = new SampleCountDownTimer(DURATION) {

                @Override
                public void onFinish() {
                    Toast.makeText(getActivity(), R.string.times_up, Toast.LENGTH_SHORT).show();
                }
            };
            countDownTimer.start();
        }
        return inflater.inflate(R.layout.sample_pager_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        DecoratedViewPager viewPager = (DecoratedViewPager) getView().findViewById(R.id.samplePager);
        Log.v(LOG_TAG, "Adding the pager decorations");
        ViewPagerDecorationTimer timerDecoration = new ViewPagerDecorationTimer(R.id.timer_text, countDownTimer);
        countDownTimer.setTimerTickListener(timerDecoration);
        ViewPagerDecorationNotifyOutOfBounds outOfBoundsDecoration = new ViewPagerDecorationNotifyOutOfBounds(
                timerDecoration, this);
        viewPager.setDecoration(outOfBoundsDecoration);
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
