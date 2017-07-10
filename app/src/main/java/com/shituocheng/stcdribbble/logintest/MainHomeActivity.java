package com.shituocheng.stcdribbble.logintest;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.bumptech.glide.util.Util;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import cn.lemon.view.RefreshRecyclerView;

public class MainHomeActivity extends AppCompatActivity {

    private RefreshRecyclerView recyclerView;
    private LinearLayout linearLayout;
//    private RefreshRecyclerView mainRecyclerView;
    private TabLayout tabLayout;
    private ViewPager viewPager;

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
        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        viewPager = (ViewPager)findViewById(R.id.viewPager);

        viewPager.getLayoutParams().height = (DensityUtil.dip2px(this, 212)) * (images.size()/2);

        CardViewActivity.CardAdapter cardAdapter = new CardViewActivity.CardAdapter(this, images);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(cardAdapter);

        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        banner.setBannerAnimation(Transformer.ForegroundToBackground);
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR);
        banner.setImages(images);
        banner.start();

        tabLayout.addTab(tabLayout.newTab().setText("test1"));
        tabLayout.addTab(tabLayout.newTab().setText("test2"));

        UserDetailPageAdapter userDetailPageAdapter = new UserDetailPageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(userDetailPageAdapter);
        userDetailPageAdapter.notifyDataSetChanged();


        viewPager.setOffscreenPageLimit(tabLayout.getTabCount() * 10);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

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

    private static class UserDetailPageAdapter extends FragmentStatePagerAdapter {

        int number;

        private UserDetailPageAdapter(FragmentManager fm, int number) {
            super(fm);
            this.number = number;
        }


        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    BlankFragment blankFragment = new BlankFragment();
                    return blankFragment;
                case 1:
                    BlankFragment blankFragment1 = new BlankFragment();
                    return blankFragment1;
                default:
                    return null;
            }
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

        @Override
        public int getCount() {
            return number;
        }
    }
}
