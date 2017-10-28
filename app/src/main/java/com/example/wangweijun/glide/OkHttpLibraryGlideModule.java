package com.example.wangweijun.glide;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.LibraryGlideModule;
import com.example.wangweijun.glide.network.OkHttpUtils;

import java.io.InputStream;

/**
 * Created by wangweijun on 2017/10/28.
 */

@GlideModule
public final class OkHttpLibraryGlideModule extends LibraryGlideModule {
    @Override
    public void registerComponents(Context context, Glide glide, Registry registry) {
        registry.replace(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(OkHttpUtils.getInstance().getOkHttpClient()));
    }
}
