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

import de.greenrobot.event.EventBus;


//import org.greenrobot.eventbus.EventBus;
//import org.greenrobot.eventbus.Subscribe;
//import org.greenrobot.eventbus.ThreadMode;

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
//        binding.tvStickEvent.setOnClickListener(v -> ListenerManager.getInstance().sendBroadCast(innerEvent));
//        binding.tvRegister.setOnClickListener(v -> ListenerManager.getInstance().registerListener(innerView));
//        EventBus.getDefault().registerSticky();
        Bitmap bitmap = BitmapFactory.decodeResource();
        bitmap.compress()
    }

    public static class InnerView extends View implements IListener {

        public InnerView(Context context) {
            super(context);
        }

        public InnerView(Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);

            InnerEvent stickyEvent = EventBus.getDefault().getStickyEvent(InnerEvent.class);
        }

        @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
        public void receiveEvent(InnerEvent event) {
            Log.d(TAG, "receiveEvent: " + event.msg);
        }

        public void onEventMainThread(InnerEvent bean) {
            Toast.makeText(getContext(), "aaa", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "onEventMainThread: " + toString());
        }

        @Override
        public void notifyAllActivity(BaseEvent baseEvent) {
            Log.d(TAG, "notifyAllActivity: ");
            Toast.makeText(getContext(), "notifyAllActivity", Toast.LENGTH_SHORT).show();
        }
    }

    public static class InnerEvent extends BaseEvent{
        public String msg;

        public InnerEvent(String msg) {
            this.msg = msg;
        }
    }
}
