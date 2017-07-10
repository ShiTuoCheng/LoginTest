package com.shituocheng.stcdribbble.logintest;


import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.lemon.view.RefreshRecyclerView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    private RefreshRecyclerView mainRecyclerView;

    private List<Integer> images = new ArrayList<>();

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        initData();

        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        mainRecyclerView = (RefreshRecyclerView)view.findViewById(R.id.main_recyclerView);

        CardViewActivity.CardAdapter cardAdapter1 = new CardViewActivity.CardAdapter(getActivity().getApplicationContext(), images);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity().getApplicationContext(), 2);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mainRecyclerView.setLayoutManager(gridLayoutManager);
        mainRecyclerView.setAdapter(cardAdapter1);

        return view;
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

}
