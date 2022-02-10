package com.havefun.androidstudy;

import com.havefun.androidstudy.bean.Comments;

import io.reactivex.Observable;
import io.reactivex.Observer;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @GET("comments/14500/json")
    Observable<Comments> getComments();
}
