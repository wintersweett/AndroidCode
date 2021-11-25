package com.havefun.shortcode.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.havefun.shortcode.databinding.ShortcodeActivitySpannableStringBinding;

public class SpannableStringActivity extends AppCompatActivity {

    private ShortcodeActivitySpannableStringBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ShortcodeActivitySpannableStringBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.textView.setMovementMethod(LinkMovementMethod.getInstance());
        binding.textView.setHighlightColor(Color.WHITE); // 点击过后的背景色
        binding.textView.setHighlightColor(Color.WHITE);
        String prefix = "我已阅读并同意";
        String protocol = "《猎聘用户服务协议》 《个人信息保护\n政策》";
        SpannableStringBuilder stringBuilder = new SpannableStringBuilder();
        stringBuilder.append(prefix);
        stringBuilder.append(protocol);
        stringBuilder.append("，未注册的手机号将自动完成账号注册");
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Toast.makeText(SpannableStringActivity.this, "点击了用户协议", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                ds.setColor(Color.RED);
                ds.setUnderlineText(false);
            }
        };
        binding.textView.setMovementMethod(LinkMovementMethod.getInstance());
        stringBuilder.setSpan(clickableSpan,prefix.length(),prefix.length() + protocol.length(),
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        binding.textView.setText(stringBuilder);
    }
}
