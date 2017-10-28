package com.example.wangweijun.glide_config_test;

import android.content.Context;

import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.module.AppGlideModule;

/**
 * Created by wangweijun1 on 2017/10/26.
 */
@GlideModule
public class MyAppGlideModule extends AppGlideModule {

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        // 内存缓存
        int memoryCacheSizeBytes = 1024 * 1024 * 20; // 20mb
        builder.setMemoryCache(new LruResourceCache(memoryCacheSizeBytes));

        // 磁盘缓存,默认磁盘大小为250 MB

        int diskCacheSizeBytes = 1024 * 1024 * 100;  //100 MB
        String diskCacheName = "image_cache";
        // 外部存取sdcard
        builder.setDiskCache(new ExternalCacheDiskCacheFactory(context,diskCacheName, diskCacheSizeBytes));
        // 内部存取 data/data/包名/cache/xxxxx
//        builder.setDiskCache(new InternalCacheDiskCacheFactory(context, diskCacheSizeBytes));

        // 设置日志级别
//        builder.setLogLevel(Log.DEBUG);
    }
}
