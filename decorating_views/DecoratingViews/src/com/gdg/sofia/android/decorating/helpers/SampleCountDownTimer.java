package com.gdg.sofia.android.decorating.helpers;

import android.os.CountDownTimer;

abstract public class SampleCountDownTimer extends CountDownTimer {
    private static final int TIMER_UPDATE_INTERVAL_MILLIS = 500;

    public static interface OnTimerTickListener {
        void onTimerTick(long remainingMillis);
    }

    private OnTimerTickListener timerTickListener;
    private long remainingMillis;

    public SampleCountDownTimer(long millisInFuture) {
        super(millisInFuture, TIMER_UPDATE_INTERVAL_MILLIS);
        remainingMillis = millisInFuture;
    }

    public void setTimerTickListener(OnTimerTickListener timerTickListener) {
        this.timerTickListener = timerTickListener;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        remainingMillis = millisUntilFinished;
        timerTickListener.onTimerTick(remainingMillis);
    }

    public long getRemainingMillis() {
        return remainingMillis;
    }
}
