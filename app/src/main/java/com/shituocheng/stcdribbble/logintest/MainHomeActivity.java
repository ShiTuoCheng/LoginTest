package com.shituocheng.stcdribbble.logintest;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import cn.lemon.view.RefreshRecyclerView;

public class MainHomeActivity extends AppCompatActivity {

    private RefreshRecyclerView recyclerView;
    private LinearLayout linearLayout;
    private RefreshRecyclerView mainRecyclerView;

    private List<Integer> images = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);
        initData();
        initView();

    }

    private void initData(){

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

    }

    private void initView(){
        steepStatusBar();

        Banner banner = (Banner) findViewById(R.id.banner);
        recyclerView = (RefreshRecyclerView)findViewById(R.id.recycler_view);
        mainRecyclerView = (RefreshRecyclerView)findViewById(R.id.main_recyclerView);
        mainRecyclerView.getLayoutParams().height = 280 * images.size();

        CardViewActivity.CardAdapter cardAdapter = new CardViewActivity.CardAdapter(this, images);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(cardAdapter);

        CardViewActivity.CardAdapter cardAdapter1 = new CardViewActivity.CardAdapter(this, images);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mainRecyclerView.setLayoutManager(gridLayoutManager);
        mainRecyclerView.setAdapter(cardAdapter1);
        mainRecyclerView.setNestedScrollingEnabled(false);

        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        banner.setBannerAnimation(Transformer.ForegroundToBackground);
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR);
        banner.setImages(images);
        banner.start();

    }

    //设置沉浸式状态栏
    private void steepStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // 透明状态栏
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);

        }
    }


}
