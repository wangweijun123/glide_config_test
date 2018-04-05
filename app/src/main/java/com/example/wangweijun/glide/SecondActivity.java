package com.example.wangweijun.glide;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;


/**
 * Created by wangweijun1 on 2017/10/26.
 */

public class SecondActivity extends Activity implements View.OnClickListener {
    Button bt1, bt3, bt4, bt5, bt6,bt7;
    ImageView iv1, iv2, iv3,iv8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Log.i("wang", "SecondActivity");

        bt1 = (Button) findViewById(R.id.bt1);
        bt1.setOnClickListener(this);
        bt3 = (Button) findViewById(R.id.bt3);
        bt3.setOnClickListener(this);
        bt4 = (Button) findViewById(R.id.bt4);
        bt4.setOnClickListener(this);


        bt5 = (Button) findViewById(R.id.bt5);
        bt5.setOnClickListener(this);
        bt6 = (Button) findViewById(R.id.bt6);
        bt6.setOnClickListener(this);
        bt7 = (Button) findViewById(R.id.bt7);
        bt7.setOnClickListener(this);
        findViewById(R.id.bt8).setOnClickListener(this);

        iv1 = (ImageView) findViewById(R.id.iv1);

        iv2 = (ImageView) findViewById(R.id.iv2);

        iv3 = (ImageView) findViewById(R.id.iv3);
        iv8 = (ImageView) findViewById(R.id.iv8);
//        GlideApp.with(getApplicationContext())
//                .load("http://img1.dzwww.com:8080/tupian_pl/20150813/16/7858995348613407436ddddddd.jpg")
//                .placeholder(R.mipmap.ic_launcher)
//                .error(R.mipmap.error)
//                .centerCrop()
//                .into(iv1);

//        GlideApp.with(getApplicationContext()).load(url).thumbnail()

    }

    String url = "http://img1.dzwww.com:8080/tupian_pl/20150813/16/7858995348613407436.jpg";

    // 缩略图
    String thumbnailUrl = "http://i3.letvimg.com//lc03_iptv//201803//29//15//50//tmp21e5b0f0-d537-455d-9535-af05031bde53256.png";


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt1:
                GlideApp.with(this).load("http://img1.dzwww.com:8080/tupian_pl/20150813/16/7858995348613407436.jpg")
                        .placeholder(R.mipmap.ic_launcher)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(iv1);


                GlideApp.with(this).load("http://img1.dzwww.com:8080/tupian_pl/20150813/16/7858995348613407436.jpg")
                        .placeholder(R.mipmap.ic_launcher)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(iv2);
                break;
            case R.id.bt3:
                GlideApp.with(getApplicationContext()).load(url).preload();
                break;
            case R.id.bt4:
                GlideApp.with(getApplicationContext())
                        .load(url)
                        .into(iv3);
                break;
            case R.id.bt5:
                Log.i("wang", "width:" + bt5.getWidth() + ", height:" + bt5.getHeight());
                String gifUrl = "http://i2.mhimg.com/M00/0E/AE/CgAAilTPWJ2Aa_EIACcMxiZi5xE299.gif";
//                String gifUrl = "http://pic2.mahua.com/M00/0E/AE/CgAAilTPWJ2Aa_EIACcMxiZi5xE299.gif";
                GlideApp.with(getApplicationContext())
                        .asGif()
                        .load(gifUrl)
                        .placeholder(R.mipmap.ic_launcher)
                        .error(R.mipmap.error)
                        .into(iv3);
                break;
            case R.id.bt6:
//                GlideApp.with(getApplicationContext())
//                        .load(url)
//                        .centerCrop()
//                        .into(iv3);
                GlideApp.with(getApplicationContext())
                        .load(url)
                        .transform(new CircleCrop())
                        .into(iv3);
                break;
            case R.id.bt7:
                GlideApp.with(getApplicationContext())
                    .load(url)
                    .transform(new ToundedCornerTransformation())
                    .into(iv3);
                break;
            case R.id.bt8:
                GlideApp.with(getApplicationContext())
                        .load(url)
                        .thumbnail(GlideApp.with(getApplicationContext())
                                .load(thumbnailUrl)
                                .override(20))
                        .into(iv8);
                break;
            default:
                break;
        }
    }
}
