package com.havefun.shortcode.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.havefun.shortcode.databinding.ShortcodeActivityEventBusBinding;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EventBusActivity extends AppCompatActivity {
    private static final String TAG = "EventBusActivity";
    private ShortcodeActivityEventBusBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ShortcodeActivityEventBusBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        InnerView innerView = new InnerView(this);
        InnerEvent innerEvent = new InnerEvent("hello world");
        binding.tvRegister.setOnClickListener(v -> EventBus.getDefault().register(innerView));
        binding.tvUnregister.setOnClickListener(v -> EventBus.getDefault().unregister(innerView));
        binding.tvSendEvent.setOnClickListener(v -> EventBus.getDefault().post(innerEvent));
        binding.tvStickEvent.setOnClickListener(v -> EventBus.getDefault().postSticky(innerEvent));
    }

    public static class InnerView extends View {

        public InnerView(Context context) {
            super(context);
        }

        public InnerView(Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);
        }

        @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
        public void receiveEvent(InnerEvent event) {
            Log.d(TAG, "receiveEvent: " + event.msg);
        }
    }

    public static class InnerEvent {
        public String msg;

        public InnerEvent(String msg) {
            this.msg = msg;
        }
    }
}
