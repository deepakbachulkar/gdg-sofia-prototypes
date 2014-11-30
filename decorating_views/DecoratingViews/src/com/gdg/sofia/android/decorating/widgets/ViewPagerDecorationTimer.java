package com.gdg.sofia.android.decorating.widgets;

import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.TextView;

import com.gdg.sofia.android.decorating.helpers.SampleCountDownTimer;
import com.gdg.sofia.android.decorating.helpers.SampleCountDownTimer.OnTimerTickListener;

/**
 * View pager decoration that adds logic for working timer visualized on the view pager.
 * <p>
 * The timer is displayed in the format HH:MM:SS with seconds added in the case of last minute countdown.
 *
 * @author Boris Strandjev
 */
public class ViewPagerDecorationTimer extends ViewPagerDecoration implements OnTimerTickListener {
    private static final int MILLIS_IN_MINUTE = 60 * 1000;
    private static final int MILLIS_IN_HOUR = 60 * 60 * 1000;

    private int timerTextFieldId;
    private SampleCountDownTimer timer;

    private class TimerViewOnPageChangeListener extends DecoratedOnPageChangeListener {

        public TimerViewOnPageChangeListener(OnPageChangeListener pageChangeListener) {
            super(pageChangeListener);
        }

        @Override
        public void onPageSelected(int position) {
            updateTimeRemainingUI(timer.getRemainingMillis());
            super.onPageSelected(position);
        }
    }

    public ViewPagerDecorationTimer(int timerTextFieldId, SampleCountDownTimer timer) {
        super();
        this.timerTextFieldId = timerTextFieldId;
        this.timer = timer;
    }

    public ViewPagerDecorationTimer(ViewPagerDecoration decoration, int timerTextFieldId, SampleCountDownTimer timer) {
        super(decoration);
        this.timerTextFieldId = timerTextFieldId;
        this.timer = timer;
    }

    @Override
    public OnPageChangeListener decorateOnPageChangeListener(OnPageChangeListener listener) {
        return super.decorateOnPageChangeListener(new TimerViewOnPageChangeListener(listener));
    }

    @Override
    public void decorateConstructor(ViewPager viewPager) {
        viewPager.setOnPageChangeListener(decorateOnPageChangeListener(null));
        super.decorateConstructor(viewPager);
    }

    @Override
    public void onTimerTick(long remainingMillis) {
        updateTimeRemainingUI(remainingMillis);
    }

    private void updateTimeRemainingUI(long timerCountdownMillis) {
        View currentView = getCurrentView();
        if (currentView == null) {
            return;
        }
        int hours = (int) timerCountdownMillis / MILLIS_IN_HOUR;
        int minutes = ((int) timerCountdownMillis % MILLIS_IN_HOUR) / MILLIS_IN_MINUTE;
        int seconds = (((int) timerCountdownMillis) % MILLIS_IN_MINUTE) / 1000;
        TextView timerTextView = (TextView) currentView.findViewById(timerTextFieldId);
        timerTextView.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
    }
}
