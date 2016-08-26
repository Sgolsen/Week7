package com.golsen.week7.test;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.golsen.week7.R;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private ViewPager mViewPager;
    private List<ImageView> data;
    private LinearLayout mLayout;
    private View mView;
    private int diatance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initView();
        initData();
        initEvent();
    }

    private void initEvent() {
        /**
         * 当底部红色小圆点加载完成时测出两个小灰点的距离，便于计算后面小红点动态移动的距离
         */
        mView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                diatance = mLayout.getChildAt(1).getLeft() - mLayout.getChildAt(0).getLeft();
                Log.d("两点间距",diatance + "测出来了");
            }
        });
        mViewPager.setOnPageChangeListener(this);

    }

    private void initData() {
        data = new ArrayList<>();
        ImageView img1 = new ImageView(this);
        img1.setBackgroundColor(Color.parseColor("#ff0000"));

        ImageView img2 = new ImageView(this);
        img2.setBackgroundColor(Color.parseColor("#00ff00"));
        ImageView img3 = new ImageView(this);
        img3.setBackgroundColor(Color.parseColor("#0000ff"));
        ImageView img4 = new ImageView(this);
        img4.setBackgroundColor(Color.parseColor("#fff000"));
        data.add(img1);
        data.add(img2);
        data.add(img3);
        data.add(img4);


        for (int i = 0; i < data.size(); i++) {
            View view = new View(this);
            view.setBackgroundResource(R.mipmap.rec_add_bg_pressed);
            //指定其大小
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20,20);
            if (i != 0)
                params.leftMargin = 20;
            view.setLayoutParams(params);
            mLayout.addView(view);
        }

        ImgAdapter adapter = new ImgAdapter(data);
        mViewPager.setAdapter(adapter);
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mLayout = (LinearLayout) findViewById(R.id.ll_points);
        mView = findViewById(R.id.v_redpoint);

    }


    //----------------------------------------------------------------------------------------
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        //position = position % data.size();
        float leftMargin = diatance * (position + positionOffset);
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mView.getLayoutParams();
        params.leftMargin = Math.round(leftMargin);
        mView.setLayoutParams(params);
        Log.e("红点在这",leftMargin + "----position"+position+"------positionoffset"+positionOffset);
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
