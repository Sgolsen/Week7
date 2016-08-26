package com.golsen.week7.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.golsen.week7.R;
import com.golsen.week7.adapters.DiscoverPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/22 0022.
 */
public class DiscoverFragment extends BaseFragment {

    public static final String TAG=DiscoverFragment.class.getSimpleName();
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private DiscoverPagerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        layout = inflater.inflate(R.layout.fragment_discover,container,false);

        return layout;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        mTabLayout = (TabLayout) layout.findViewById(R.id.discover_tablayout);
        mViewPager = (ViewPager) layout.findViewById(R.id.discover_viewpager);
        List<Fragment> data = new ArrayList<>();
        data.add(new RecommendFragment());
        data.add(new ClassifyFragment());
        data.add(new BroadcastFragment());
        data.add(new TopListFragment());
        data.add(new AnchorFragment());
        /**
         * 当Fragment嵌套进行使用的时候,内部的Fragment加载要使用getChildFragmentManager
         * 进行获取碎片管理器
         */
        String[] titles = getResources().getStringArray(R.array.tabs);
        adapter = new DiscoverPagerAdapter(getChildFragmentManager(),data,titles);
        mViewPager.setAdapter(adapter);
        /**
         * ViewPager与TabLayout联动
         * ① 重写PagerAdapter中的getPageTitle
         * ② 时TabLayout与ViewPager进行绑定
         *
         */
        mTabLayout.setupWithViewPager(mViewPager);

    }
}
