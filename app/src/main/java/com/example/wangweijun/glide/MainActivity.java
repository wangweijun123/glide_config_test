package com.example.wangweijun.glide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.wangweijun.glide.model.IResponse;
import com.example.wangweijun.glide.model.RankListModel;
import com.example.wangweijun.glide.model.RecommendModel;
import com.example.wangweijun.glide.network.LeHttpApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ImageView iv;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("wang", "xxxx");
        Log.i("wang", "xxxx");
        Log.i("wang", "xxxx");

        iv = (ImageView)findViewById(R.id.iv);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SecondActivity.class));
            }
        });
        listView  = (ListView)findViewById(R.id.lv);
//        GlideApp.with(getApplicationContext())
//                .load("http://img1.dzwww.com:8080/tupian_pl/20150813/16/7858995348613407436.jpg")
//                .placeholder(R.mipmap.ic_launcher)
//                .override(600, 600)
//                .error(R.mipmap.error)
//                .into(iv);

        Callback<IResponse<RankListModel>> callback = new Callback<IResponse<RankListModel>>() {
            @Override
            public void onResponse(Call<IResponse<RankListModel>> call, Response<IResponse<RankListModel>> response) {
                IResponse<RankListModel> model = response.body();
                RankListModel rankListModel = model.getEntity();
                Log.i(LeHttpApi.TAG, response.headers().toString());
                Log.i(LeHttpApi.TAG,  response.code()+", "+response.message());
                List<RecommendModel.RankRecommedModel> list = rankListModel.ranklist.get(0).items;
                for(RecommendModel.RankRecommedModel model1 : list) {
                    Log.i(LeHttpApi.TAG, model1.toString());
                }
                listView.setAdapter(new Mydapter(list));
            }

            @Override
            public void onFailure(Call<IResponse<RankListModel>> call, Throwable t) {
                t.printStackTrace();
                Log.i(LeHttpApi.TAG, "onFailure status");
            }
        };
        LeHttpApi.doGetAsync(callback);
    }


    class Mydapter extends BaseAdapter {
        List<RecommendModel.RankRecommedModel> list;

        Mydapter(List<RecommendModel.RankRecommedModel> list) {
            this.list = list;
        }

        @Override
        public int getCount() {
            return list == null ? 0 : list.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = LayoutInflater.from(getApplicationContext())
                        .inflate(R.layout.flickr_photo_list_item, null);
                viewHolder = new ViewHolder();
                viewHolder.photo_view = (ImageView)convertView.findViewById(R.id.photo_view);
                viewHolder.title_view = (TextView)convertView.findViewById(R.id.title_view);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder)convertView.getTag();
            }
            setValue(viewHolder, list.get(i));
            return convertView;
        }
    }

    private void setValue(ViewHolder viewHolder, RecommendModel.RankRecommedModel model) {
        viewHolder.title_view.setText(model.name);
        GlideApp.with(getApplicationContext()).load(model.icon.url)
//                .transition(new DrawableTransitionOptions().crossFade(200))
                .placeholder(R.mipmap.ic_launcher)
                .into(viewHolder.photo_view);
    }

    class ViewHolder {
        ImageView photo_view;
        TextView title_view;
    }
}
