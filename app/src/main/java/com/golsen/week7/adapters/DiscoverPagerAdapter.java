package com.golsen.week7.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/8/22 0022.
 */
public class DiscoverPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> data;

    private String[] titles;
    public DiscoverPagerAdapter(FragmentManager fm,List<Fragment> data,String[] titles) {
        super(fm);
        this.data = data;
        this.titles = titles;

    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
