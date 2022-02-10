package com.havefun.androidstudy;

import android.content.ComponentName;
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

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.havefun.androidstudy.databinding.ActivityMain2Binding;
import com.havefun.androidstudy.databinding.ActivityMainBinding;
import com.havefun.common.Constants;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

@Route(path = "/app/activity2", group = "app")
public class Main2Activity extends AppCompatActivity {
    private static final String TAG = "AAABBCC";

    private ActivityMain2Binding binding;
    private TextView textView;

    @Autowired
    public String mName;
    @Autowired
    public int mAge;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ARouter.getInstance().inject(this);

    }
}