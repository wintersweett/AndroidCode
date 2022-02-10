package com.havefun.androidstudy;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.text.Editable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.havefun.androidstudy.databinding.ActivityMainBinding;
import com.havefun.common.Constants;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

@Route(path = "/app/activity")
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "AAABBCC";

    private ActivityMainBinding binding;
    private TextView textView;

    @RequiresApi(api = Build.VERSION_CODES.O)
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

        int i = Color.parseColor("#0000FF");
        int i1 = Color.parseColor("#FFFFFF");
        int i2 = Color.parseColor("#00000000");
        int i3 = Color.parseColor("#FFFFFFFF");
        long color = Long.parseLong("0000FF", 16);

        Log.d(TAG, "onCreate: color: " + Color.parseColor("#00FF00"));
        Log.d(TAG, "onCreate: cast int color: " + Color.parseColor("#FF0000"));
        Log.d(TAG, "onCreate: " + i);
        Log.d(TAG, "onCreate: " + i1);
        Log.d(TAG, "onCreate: " + i2);
        Log.d(TAG, "onCreate: " + i3);
        Log.d(TAG, "onCreate: " + Color.argb(255, 255, 255, 255));
        Log.d(TAG, "onCreate: " + Color.argb(254, 255, 255, 255));
        Log.d(TAG, "onCreate: " + Color.argb(253, 255, 255, 255));
        Log.d(TAG, "onCreate: " + Color.argb(252, 255, 255, 255));


        //bindService(new Intent(), connection, Service.BIND_AUTO_CREATE);

    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };


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

    @Override
    public void onClick(View v) {
        if (v == binding.tvLaunchShortCodePage) {
            Intent it = new Intent();
            ARouter.getInstance().build(Constants.PATH_SHORT_CODE_ACTIVITY).withString("key", "value")
                    .navigation();
        }
    }
}