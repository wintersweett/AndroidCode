package com.havefun.androidstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.havefun.androidstudy.databinding.ActivityMainBinding;
import com.havefun.common.Constants;
import com.havefun.shortcode.ShortCodeActivity;
import com.havefun.view.WidgetActivity;

@Route(path = "/test/activity")
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.tvLaunchShortCodePage.setOnClickListener(this);
        binding.tvLaunchWidget.setOnClickListener(this);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvLaunchShortCodePage:
                //startActivity(new Intent(MainActivity.this, ShortCodeActivity.class));
                ValueAnimator valueAnimator = ObjectAnimator.ofFloat(0.0f, 1.0f);
                valueAnimator.setDuration(2000);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float progress = (float) animation.getAnimatedValue();
                        binding.colorTrackTextView.setCurrentProgress(progress);
                    }
                });
                valueAnimator.start();
                break;
            case R.id.tvLaunchWidget:
                startActivity(new Intent(MainActivity.this, WidgetActivity.class));
                break;
            default:

        }
    }
}