package com.devbrackets.android.exomedia.ui.animation;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;

public class AlphaHideShowAnimation extends AnimationSet {
    private View animationView;
    private boolean toVisible;

    public AlphaHideShowAnimation(View view, boolean toVisible, long duration) {
        super(false);
        this.toVisible = toVisible;
        this.animationView = view;
        float startAlpha = toVisible ? 0.0F : 1.0F;
        float endAlpha = toVisible ? 1.0F : 0.0F;
        AlphaAnimation alphaAnimation = new AlphaAnimation(startAlpha, endAlpha);
        alphaAnimation.setDuration(duration);
        this.addAnimation(alphaAnimation);
        this.setAnimationListener(new AlphaHideShowAnimation.Listener());
    }

    private int getHideShowDelta(View view) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display display = ((WindowManager) view.getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        display.getMetrics(displayMetrics);
        int screenHeight = displayMetrics.heightPixels;
        return screenHeight - view.getTop();
    }

    private class Listener implements AnimationListener {
        private Listener() {
        }

        public void onAnimationStart(Animation animation) {
            AlphaHideShowAnimation.this.animationView.setVisibility(0);
        }

        public void onAnimationEnd(Animation animation) {
            AlphaHideShowAnimation.this.animationView.setVisibility(AlphaHideShowAnimation.this.toVisible ? View.VISIBLE : View.GONE);
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }
}