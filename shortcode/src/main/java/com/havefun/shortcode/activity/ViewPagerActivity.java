package com.havefun.shortcode.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;

import com.havefun.shortcode.adapter.PagerAdapter;
import com.havefun.shortcode.databinding.ShortcodeActivityViewPagerBinding;

public class ViewPagerActivity extends AppCompatActivity {

    private ShortcodeActivityViewPagerBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ShortcodeActivityViewPagerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT));
    }
}
