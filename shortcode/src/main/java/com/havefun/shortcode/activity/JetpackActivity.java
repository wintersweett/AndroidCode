package com.havefun.shortcode.activity;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.havefun.shortcode.databinding.ShortcodeActivityJetpackBinding;
import com.havefun.shortcode.mvp.JetpackPresenter;
import com.havefun.shortcode.mvp.MyObserver;

public class JetpackActivity extends AppCompatActivity {

    private ShortcodeActivityJetpackBinding mBinding;
    private MyObserver mObserver;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ShortcodeActivityJetpackBinding.inflate(LayoutInflater.from(this));
        setContentView(mBinding.getRoot());
        mObserver = new JetpackPresenter();
        getLifecycle().addObserver(mObserver);
    }


}
