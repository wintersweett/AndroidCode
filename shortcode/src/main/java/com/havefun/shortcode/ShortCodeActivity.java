package com.havefun.shortcode;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.havefun.shortcode.activity.EventBusActivity;
import com.havefun.shortcode.databinding.ShortcodeActivityShortcodeBinding;

public class ShortCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ShortcodeActivityShortcodeBinding binding = ShortcodeActivityShortcodeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.tvEventBusPage.setOnClickListener(v -> startActivity(new Intent(this,
                EventBusActivity.class)));
    }
}
