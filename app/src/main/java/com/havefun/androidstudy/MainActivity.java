package com.havefun.androidstudy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.havefun.androidstudy.databinding.ActivityMainBinding;
import com.havefun.common.Constants;
import com.havefun.shortcode.Cinema;
import com.havefun.shortcode.RealMovie;
import com.havefun.shortcode.ShortCodeActivity;
import com.havefun.shortcode.activity.JetpackActivity;
import com.havefun.view.WidgetActivity;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Route(path = "/test/activity")
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.tvLaunchShortCodePage.setOnClickListener(this);
        binding.tvLaunchWidget.setOnClickListener(this);
        binding.tvLaunchThirdParty.setOnClickListener(this);

        startActivity(new Intent(this, JetpackActivity.class));
    }

    private void setInputLength(Editable s) {
        int color = s.length() > 0 ? Color.GREEN : Color.RED;
        String content = s.length() + "/200";
        SpannableString spannableString = new SpannableString(content);
        spannableString.setSpan(new ForegroundColorSpan(color), 0, content.indexOf("/"), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        binding.tvCounts.setText(spannableString);
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
                RealMovie realMovie = new RealMovie();
                Cinema cinema = new Cinema(realMovie);
                cinema.play();
                break;
            default:

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void test() {
        // 初始化textView显示
        setInputLength(new SpannableStringBuilder(""));
        binding.editText.setTextColor(Color.RED);
        int currentHintTextColor = binding.editText.getCurrentTextColor();
        System.out.println("AABBCC:" + (currentHintTextColor == Color.RED) + " " + Color.RED + " cu: " + currentHintTextColor);
        System.out.println("AABBCC:" + Integer.toHexString(currentHintTextColor));
        textView = new TextView(this);
//        binding.editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(6)}); //最大输入长度

        //binding.editText.setMaxLines(1);
        //binding.editText.setInputType(EditorInfo.TYPE_CLASS_TEXT);
        binding.editText.setMovementMethod(LinkMovementMethod.getInstance());
        binding.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                setInputLength(s);
                if (s.length() < 1) {
                    binding.tvLaunchShortCodePage.setTextColor(Color.GRAY);  // 灰色
                    binding.tvLaunchShortCodePage.setClickable(false);   // 不可点击
                } else {
                    binding.tvLaunchShortCodePage.setTextColor(Color.RED);   // 红色
                    binding.tvLaunchShortCodePage.setClickable(true);    // 可点击
                }
            }
        });
        String rightDisableColor = getResources().getColor(R.color.base_color_00BCD4) + "";
        Log.d("ZHANG", "onCreate: " + rightDisableColor);
    }
}