package com.havefun.view;

import android.os.Bundle;
import android.view.RoundedCorner;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.havefun.common.Constants;

@Route(path = Constants.PATH_WIDGET_ACTIVITY)
public class WidgetActivity extends AppCompatActivity {

    private Button btnChangeSize;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_activity_show);
        ImageView imageView = findViewById(R.id.imageView);
        String url = "https://cn.bing.com/sa/simg/hpb/LaDigue_EN-CA1115245085_1920x1080.jpg";

        Glide.with(this).load(url).apply(RequestOptions.bitmapTransform(new RoundedCorners(50))).into(imageView);
    }
}
