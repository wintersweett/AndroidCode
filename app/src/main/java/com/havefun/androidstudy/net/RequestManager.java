package com.havefun.androidstudy.net;

import android.util.Log;

import com.havefun.base.BaseUrl;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RequestManager {
    private static Retrofit sInstance;
    public static Retrofit sInstance() {
        if (sInstance== null) {
            sInstance = createRetorfit();
        }
        return sInstance;
    }

    private static Retrofit createRetorfit() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("ZJP", message);
            }
        }).setLevel(HttpLoggingInterceptor.Level.BODY);

        Retrofit retrofit;
        OkHttpClient client;
        client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)//日志拦截
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit;
    }
}
