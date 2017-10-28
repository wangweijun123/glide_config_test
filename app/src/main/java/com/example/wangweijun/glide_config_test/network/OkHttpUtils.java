package com.example.wangweijun.glide_config_test.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by wangweijun on 2017/10/22.
 */

public class OkHttpUtils {
    private static volatile OkHttpUtils sInstance;

    int cacheSize = 10 * 1024 * 1024; // 10 MiB
    // 测试超过缓存大小，删除文件与内存应用
//    int cacheSize = 9500;

    private OkHttpClient mOkHttpClient;

    private OkHttpUtils() {

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        mOkHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    public static OkHttpUtils getInstance() {
        if (sInstance == null) {
            synchronized (OkHttpUtils.class) {
                if (sInstance == null) {
                    sInstance = new OkHttpUtils();
                }
            }
        }
        return sInstance;
    }

    public OkHttpClient getOkHttpClient() {
        return mOkHttpClient;
    }
}
