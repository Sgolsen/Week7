package com.golsen.week7.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.golsen.week7.R;
import com.golsen.week7.ui.fragments.BookFragment;
import com.golsen.week7.ui.fragments.DiscoverFragment;
import com.golsen.week7.ui.fragments.DownloadFragment;
import com.golsen.week7.ui.fragments.MineFragment;

import java.lang.reflect.InvocationTargetException;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    private RadioGroup mController;
    private ImageView mPlay;
    private Fragment mShowFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mController = (RadioGroup) findViewById(R.id.main_controller);
        mController.setOnCheckedChangeListener(this);
        mPlay = (ImageView) findViewById(R.id.main_play);
        mPlay.setOnClickListener(this);
        /**
         * 动态添加碎片
         * ① 获取碎片管理器
         * ② 开启碎片事务
         * ③ 在事务中中添加动作
         * ④ 提交
         */

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        mShowFragment = new DiscoverFragment();
        //将碎片添加到容器中,并且为碎片添加了一个TAG ,  对应findFragmentByTag
        transaction.add(R.id.main_container, mShowFragment,DiscoverFragment.TAG);
        transaction.commit();
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.main_controller_discover:
                switchPages(DiscoverFragment.TAG,DiscoverFragment.class);
                break;
            case R.id.main_controller_book:
               switchPages(BookFragment.TAG,BookFragment.class);
                break;
            case R.id.main_controller_download:
                switchPages(DownloadFragment.TAG,DownloadFragment.class);
                break;
            case R.id.main_controller_mine:
                switchPages(MineFragment.TAG,MineFragment.class);
                break;
        }
    }

    /**
     * 切换页面的封装
     * @param tag 添加碎片的标记
     * @param cls 添加碎片的class
     */

    private void switchPages(String tag,Class<? extends Fragment> cls){
        /**
         * 将当前显示的碎片进行隐藏,之后将要显示的页面显示出来
         */
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        //隐藏显示的页面
        transaction.hide(mShowFragment);
        // 根据TAG去FragmentMa中进行查找碎片
        mShowFragment = fm.findFragmentByTag(tag);
        if (mShowFragment!=null) {
            //如果找到了,直接进行显示
            transaction.show(mShowFragment);

        }else{
            // 如果没找到,添加到容器中并且设置了一个标记
            try {
                //使用反射进行对象的实例化
                mShowFragment = cls.getConstructor().newInstance();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            transaction.add(R.id.main_container, mShowFragment,tag);

        }
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_play:

                break;
        }
    }
}
