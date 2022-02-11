package com.havefun.androidstudy;

import com.havefun.androidstudy.bean.BannerBean;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("banner/json")
    Observable<BannerBean> getComments();

    @GET("banner/json")
    Call<BannerBean> getBanner();
}
