package com.golsen.week7;

import android.app.Application;

import com.rock.teachlibrary.ImageLoader;

/**
 * 创建自己的Application
 * ① 创建一个类,继承自Application
 * ② 重写onCreate方法,在onCreate做全局工具类的初始化
 * ③ 在AndroidManifest中注册
 */
public class XimaApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoader.init(this);
    }
}
