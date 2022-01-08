package com.havefun.shortcode.mvp;

import android.util.Log;

public class JetpackPresenter implements MyObserver{
    private static final String TAG = "JetpackPresenter";
    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public void onStart() {
        Log.d(TAG, "onStart: ");
    }

    @Override
    public void onResume() {
        Log.e(TAG, "onResume: ");
    }

    @Override
    public void onPause() {
        Log.e(TAG, "onPause: ");
    }

    @Override
    public void onStop() {
        Log.e(TAG, "onStop: ");
    }

    @Override
    public void onDestroy() {
        Log.e(TAG, "onDestroy: ");
    }
}
