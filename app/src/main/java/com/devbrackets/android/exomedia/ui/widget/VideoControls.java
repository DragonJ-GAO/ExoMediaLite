package com.devbrackets.android.exomedia.ui.widget;

import android.support.annotation.IntRange;
import android.support.annotation.LayoutRes;

/**
 * Created by gaobojiao on 2018/9/6.
 */

public interface VideoControls {

    void showLoading(boolean initialLoad);

    void finishLoading();

    void setDuration(@IntRange(from = 0) long duration);

    void setPosition(@IntRange(from = 0) long position);

    void updateProgress(@IntRange(from = 0) long position, @IntRange(from = 0) long duration, @IntRange(from = 0, to = 100) int bufferPercent);

    boolean isVisible();

    void hideDelayed();

    void hide();

    void show();

    void updatePlaybackState(boolean isPlaying);
}
