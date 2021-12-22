package com.havefun.shortcode.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.havefun.common.Constants;
import com.havefun.shortcode.databinding.ThirdActivityThirdPartyBinding;

@Route(path = Constants.PATH_THIRD_PARTY_ACTIVITY)
public class ThirdPartyActivity extends AppCompatActivity {

    private ThirdActivityThirdPartyBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ThirdActivityThirdPartyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
