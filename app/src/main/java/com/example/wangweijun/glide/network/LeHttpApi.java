package com.example.wangweijun.glide.network;

import android.util.Log;

import com.example.wangweijun.glide.model.IResponse;
import com.example.wangweijun.glide.model.RankListModel;
import com.example.wangweijun.glide.model.Repo;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wangweijun on 2017/10/22.
 */

public class LeHttpApi {

    public static final String TAG = LeHttpApi.class.getSimpleName();

    public static final String URL_BASIC_SERVICE_TEST = "http://mapi.letvstore.com/";

    /**
     * api 测试
     */
    public static void listRepos() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpUtils.getInstance().getOkHttpClient())
                .build();
        GitHubService service = retrofit.create(GitHubService.class);
        Call<List<Repo>> call = service.listRepos("octocat");
        call.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                List<Repo> list = response.body();
                Log.i(TAG, response.message() + ", list size :" + list.size());
                for (Repo repo : list) {
                    Log.i(TAG,repo.toString());
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                t.printStackTrace();
                Log.i(TAG, "error");
            }
        });
    }

    /**
     * 异步请求
     * @throws IOException
     */
    public static void doGetAsync(Callback<IResponse<RankListModel>> callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASIC_SERVICE_TEST)
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpUtils.getInstance().getOkHttpClient())
                .build();
        // 使用retrofit创建一个api接口对象(retrofit newProxyInstance)
        StoreService service = retrofit.create(StoreService.class);
        // pagefrom=1&pagesize=1&code=RANK_HOT";
        // retrofit (代理对象调用doget方法，返回ExecutorCallbackCall(其实就是OkhttpCall对象)))
        Call<IResponse<RankListModel>> call = service.doGet("1", "50", "RANK_HOT");



        Log.i(TAG, "id callback:"+callback);
        call.enqueue(callback);
    }
}
