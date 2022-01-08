package com.havefun.shortcode.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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


        FragmentManager supportFragmentManager = getSupportFragmentManager();
        ReportFragment.inject(supportFragmentManager);

    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onResume() {
        super.onResume();
        getLifecycle().addObserver(mObserver);
    }

    public static class ReportFragment extends Fragment{
        private static final String TAG = "ReportFragment";

        public static void inject(FragmentManager supportFragmentManager) {
            FragmentTransaction transaction = supportFragmentManager.beginTransaction();
            transaction.add(new ReportFragment(), TAG);
            transaction.commitNow();
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Log.d(TAG, "onCreate: " );
        }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            Log.d(TAG, "onViewCreated: ");
        }

        @Override
        public void onStart() {
            super.onStart();
            Log.d(TAG, "onStart: ");
        }

        @Override
        public void onResume() {
            super.onResume();
            Log.d(TAG, "onResume: ");
        }


        @Override
        public void onPause() {
            super.onPause();
            Log.d(TAG, "onPause: ");
        }


        @Override
        public void onStop() {
            super.onStop();
            Log.d(TAG, "onStop: ");
        }

        @Override
        public void onDestroyView() {
            super.onDestroyView();
            Log.d(TAG, "onDestroyView: ");
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            Log.d(TAG, "onDestroy: ");
        }
    }


}
