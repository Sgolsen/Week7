package com.golsen.week7.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.golsen.week7.R;

public class SplashActivity extends BaseActivity implements Handler.Callback{


    private static final int GO_MAIN = 100;
    private static final long DELAY_TIME = 3 * 1000;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
    }

    private void initView() {
        mHandler = new Handler(this);

        //发送延迟3秒的消息,跳转到主页面
        mHandler.sendEmptyMessageDelayed(GO_MAIN,DELAY_TIME);

    }



    @Override
    public boolean handleMessage(Message msg) {

        switch (msg.what){
            case GO_MAIN:
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                finish();

                break;
        }
        return false;
    }
}
