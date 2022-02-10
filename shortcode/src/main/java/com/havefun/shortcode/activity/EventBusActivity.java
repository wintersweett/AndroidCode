package com.havefun.shortcode.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.havefun.shortcode.databinding.ShortcodeActivityEventBusBinding;
import com.havefun.shortcode.manager.BaseEvent;
import com.havefun.shortcode.manager.IListener;
import com.havefun.shortcode.manager.ListenerManager;



import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.lang.reflect.Field;
import java.util.Map;

public class EventBusActivity extends AppCompatActivity {
    private static final String TAG = "SBSBSB";
    private ShortcodeActivityEventBusBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ShortcodeActivityEventBusBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Event1 event = EventBus.getDefault().getStickyEvent(Event1.class);


        try {
            Class<? extends EventBus> aClass = EventBus.getDefault().getClass();
            Field stickyEvents = aClass.getDeclaredField("stickyEvents");
            stickyEvents.setAccessible(true);
            Map<Class<?>, Object> map = (Map<Class<?>, Object>) stickyEvents.get(EventBus.getDefault());
            Log.d(TAG, "onCreate: " + map.size());
        } catch (Exception e) {
            e.printStackTrace();
        }


        InnerEvent innerEvent = new InnerEvent("hello world");
        binding.tvRegister.setOnClickListener(v -> {
            EventBus.getDefault().register(this);
            EventBus.getDefault().postSticky(innerEvent);

            try {
                Class<? extends EventBus> aClass = EventBus.getDefault().getClass();
                Field stickyEvents = aClass.getDeclaredField("stickyEvents");
                stickyEvents.setAccessible(true);
                Map<Class<?>, Object> map = (Map<Class<?>, Object>) stickyEvents.get(EventBus.getDefault());
                Log.d(TAG, "onCreate: " + map.size());
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        binding.tvUnregister.setOnClickListener(v -> {
            EventBus.getDefault().removeStickyEvent(Event1.class);
            EventBus.getDefault().removeStickyEvent(Event2.class);
            try {
                Class<? extends EventBus> aClass = EventBus.getDefault().getClass();
                Field stickyEvents = aClass.getDeclaredField("stickyEvents");
                stickyEvents.setAccessible(true);
                Map<Class<?>, Object> map = (Map<Class<?>, Object>) stickyEvents.get(EventBus.getDefault());
                Log.d(TAG, "onCreate: " + map.size());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        binding.tvSendEvent.setOnClickListener(v -> EventBus.getDefault().post(innerEvent));
        binding.tvStickEvent.setOnClickListener(v -> EventBus.getDefault().postSticky(innerEvent));

        //EventBus.getDefault().post(innerEvent);

    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void receiveEvent0(Event1 event) {
        Log.d(TAG, "receiveEvent1: " + event);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void receiveEvent0(Event2 event) {
        Log.d(TAG, "receiveEvent0: " + event.toString());
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void receiveEvent0(Event3 event) {
        Log.d(TAG, "receiveEvent0: " + event);
    }


    @Subscribe(threadMode = ThreadMode.MAIN,  priority = 2)
    public void receiveEvent0(InnerEvent event) {
        Log.d(TAG, "receiveEvent0: " + event.msg);
    }

    @Subscribe(threadMode = ThreadMode.MAIN,  priority = 3)
    public void receiveEvent1(InnerEvent event) {
        Log.d(TAG, "receiveEvent1: " + event.msg);
    }

    @Subscribe(threadMode = ThreadMode.MAIN,  priority = 4)
    public void receiveEvent2(InnerEvent event) {
        Log.d(TAG, "receiveEvent2: " + event.msg);
    }


    public static class InnerEvent extends BaseEvent{
        public String msg;
        public InnerEvent(String msg) {
            this.msg = msg;
        }
    }

    public static class Event1 {

    }
    public static class Event2 {

    }

    public static class Event3 {

    }
}
