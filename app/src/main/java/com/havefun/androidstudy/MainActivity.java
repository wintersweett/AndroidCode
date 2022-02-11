package com.havefun.androidstudy;


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

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.havefun.androidstudy.bean.BannerBean;
import com.havefun.androidstudy.databinding.ActivityMainBinding;

import com.havefun.androidstudy.net.RequestManager;
import com.havefun.common.Constants;


@Route(path = "/app/activity")
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "AAABBCC";

    private ActivityMainBinding binding;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.tvLaunchShortCodePage.setOnClickListener(this);
        binding.tvLaunchWidget.setOnClickListener(this);
        binding.tvLaunchThirdParty.setOnClickListener(this);
        binding.tvNetRequest.setOnClickListener(this);

        String url = "http://guolin.tech/book.png";
        Glide.with(this).load(url).into(binding.imageView);




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
        } else if (v == binding.tvNetRequest) {
            ApiService apiService = RequestManager.sInstance().create(ApiService.class);
            apiService.getBanner().enqueue(new Callback<BannerBean>() {
                @Override
                public void onResponse(Call<BannerBean> call, Response<BannerBean> response) {

                }

                @Override
                public void onFailure(Call<BannerBean> call, Throwable t) {

                }
            });
            new Thread(new Runnable() {
                @Override
                public void run() {
                    apiService.getComments()
                            .subscribe(bannerBean -> {
                                int a = 8;
                                Log.d(TAG, "onCreate: " + bannerBean.toString());
                            }, throwable -> {
                                int b = 9;
                            });
                }
            }).start();


        }
    }
}