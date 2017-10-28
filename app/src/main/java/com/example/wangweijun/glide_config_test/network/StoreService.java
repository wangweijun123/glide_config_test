package com.example.wangweijun.glide_config_test.network;

import com.example.wangweijun.glide_config_test.model.IResponse;
import com.example.wangweijun.glide_config_test.model.RankListModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by wangweijun on 2017/10/22.
 */

public interface StoreService {
    @GET("mapi/edit/recommend")
    Call<IResponse<RankListModel>> doGet(@Query("pagefrom") String pagefrom, @Query("pagesize") String pagesize, @Query("code") String code);

    @GET
    Call<IResponse<Void>> downloadImage();
}
