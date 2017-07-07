package com.shituocheng.stcdribbble.logintest;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.Image;
import android.os.Build;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;

public class MainActivity extends AppCompatActivity{

    private ImageView imageView;
    private Button loginButton;
    private Button closeButton;
    private EditText userInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                jumpToActivity(MainActivity.this, MainHomeActivity.class);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                jumpToActivity(MainActivity.this, CardViewActivity.class);
            }
        });

        userInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b){
                    InputMethodManager imm = (InputMethodManager)
                            getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(userInput.getWindowToken(), 0);
                }
            }
        });

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumpToActivity(MainActivity.this, MainHomeActivity.class);
            }
        });

    }


    private void initView(){
        steepStatusBar();
        imageView = (ImageView)findViewById(R.id.jdIcon);
        loginButton = (Button)findViewById(R.id.loginButton);
        closeButton = (Button)findViewById(R.id.closeButton);

        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), id2Bitmap(this, R.mipmap.com_jingdong_app_mall_icon));
        roundedBitmapDrawable.setCircular(true);
        imageView.setImageDrawable(roundedBitmapDrawable);

        userInput = (EditText) findViewById(R.id.userInput);
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

    //图片id转成bitmap方法/
    public static Bitmap id2Bitmap(Context context, int id) {
        return BitmapFactory.decodeResource(context.getResources(), id);
    }

    //不带值跳转activity
    public static void jumpToActivity(Context context, Class destinationActivity){
        Intent intent = new Intent(context, destinationActivity);
        context.startActivity(intent);
    }

    //重载跳转activity方法
    public static void jumpToActivity(Context context, Class destinationActivity, Bundle bundle, String dataName){
        Intent intent = new Intent(context, destinationActivity);
        intent.putExtra(dataName, bundle);
        context.startActivity(intent);
    }
}
