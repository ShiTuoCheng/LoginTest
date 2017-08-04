package com.shituocheng.stcdribbble.logintest;

import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shituocheng on 2017/8/4.
 */

public class TestActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Integer> list = new ArrayList<>();
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        viewPager = (ViewPager)findViewById(R.id.viewPager);

        initView();

        tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.ic_launcher).setText("测试1"));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.ic_launcher).setText("测试1"));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.ic_launcher).setText("测试1"));


        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        viewPagerAdapter.addFragment(new BlankFragment());
        viewPagerAdapter.addFragment(new BlankFragment());
        viewPagerAdapter.addFragment(new BlankFragment());

        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);


        viewPager.setOffscreenPageLimit(tabLayout.getTabCount() * 10);

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

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

                switch (state){
                    case ViewPager.SCROLL_STATE_IDLE:
                        break;
                    case ViewPager.SCROLL_STATE_DRAGGING:
                    case ViewPager.SCROLL_STATE_SETTLING:
                        break;
                }
            }
        });


    }

    private void initView(){

    }

    private class ViewPagerAdapter extends FragmentPagerAdapter{


        private final List<Fragment> mFragmentList = new ArrayList<>();
        private List<Integer> pageIndex = new ArrayList<>();
        private int num;

        public ViewPagerAdapter(FragmentManager manager, List indexList) {
            super(manager);
            this.pageIndex = indexList;
        }

        public ViewPagerAdapter(FragmentManager manager, int num) {
            super(manager);
            this.num = num;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment) {
            mFragmentList.add(fragment);
        }
    }
}
