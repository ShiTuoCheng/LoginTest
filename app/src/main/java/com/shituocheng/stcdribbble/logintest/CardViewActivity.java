package com.shituocheng.stcdribbble.logintest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import cn.lemon.view.RefreshRecyclerView;
import cn.lemon.view.adapter.BaseViewHolder;
import cn.lemon.view.adapter.RecyclerAdapter;

public class CardViewActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private RefreshRecyclerView cardRecyclerView;

    private List<Integer> images = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        images.add(R.mipmap.demon_big);
        images.add(R.mipmap.com_jingdong_app_mall_icon);
        images.add(R.mipmap.demon_big);
        images.add(R.mipmap.com_jingdong_app_mall_icon);
        images.add(R.mipmap.demon_big);
        images.add(R.mipmap.com_jingdong_app_mall_icon);
        images.add(R.mipmap.demon_big);
        images.add(R.mipmap.com_jingdong_app_mall_icon);
        images.add(R.mipmap.demon_big);
        images.add(R.mipmap.com_jingdong_app_mall_icon);
        images.add(R.mipmap.demon_big);
        images.add(R.mipmap.com_jingdong_app_mall_icon);
        images.add(R.mipmap.demon_big);
        images.add(R.mipmap.com_jingdong_app_mall_icon);

        initView();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            this.finish();
        }
        return true;
    }

    private void initView(){

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        CardAdapter cardAdapter = new CardAdapter(this, images);
        cardRecyclerView = (RefreshRecyclerView)findViewById(R.id.recycler_view);
        cardRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        cardRecyclerView.setAdapter(cardAdapter);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    public static class CardAdapter extends RecyclerAdapter<Integer> {

        public CardAdapter(Context context) {
            super(context);
        }

        public CardAdapter(Context context, Integer[] data) {
            super(context, data);
        }

        public CardAdapter(Context context, List<Integer> data) {
            super(context, data);
        }

        @Override
        public BaseViewHolder<Integer> onCreateBaseViewHolder(ViewGroup parent, int viewType) {
            return new CardRecordHolder(parent);
        }

        class CardRecordHolder extends BaseViewHolder<Integer> {

            private ImageView cardView;

            //当使用MultiTypeAdapter时，务必加上此构造方法
            public CardRecordHolder(ViewGroup parent) {
                super(parent, R.layout.card_item);
            }

            @Override
            public void setData(Integer object) {
                super.setData(object);
                cardView.setImageBitmap(id2Bitmap(getContext(), object));
                //UI绑定数据
            }

            @Override
            public void onInitializeView() {
                super.onInitializeView();
                cardView = findViewById(R.id.imageView);
                //初始化View
            }

            @Override
            public void onItemViewClick(Integer object) {
                super.onItemViewClick(object);
                //点击事件
            }
        }

        public Bitmap id2Bitmap(Context context, int id) {
            return BitmapFactory.decodeResource(context.getResources(), id);
        }
    }
}
