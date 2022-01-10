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
import com.bumptech.glide.Glide;
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
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.tvLaunchShortCodePage.setOnClickListener(this);
        binding.tvLaunchWidget.setOnClickListener(this);
        binding.tvLaunchThirdParty.setOnClickListener(this);

        //startActivity(new Intent(this, JetpackActivity.class));

        String url = "http://guolin.tech/book.png";
        Glide.with(this).load(url).into(binding.imageView);
    }


    private void setInputLength(Editable s) {
        int color = s.length() > 0 ? Color.GREEN : Color.RED;
        String content = s.length() + "/200";
        SpannableString spannableString = new SpannableString(content);
        spannableString.setSpan(new ForegroundColorSpan(color), 0, content.indexOf("/"), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
    }





    @Override
    protected void onResume() {
        super.onResume();
    }
}