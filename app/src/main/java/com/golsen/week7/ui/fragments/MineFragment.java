package com.golsen.week7.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.golsen.week7.R;

/**
 * Created by Administrator on 2016/8/22 0022.
 */
public class MineFragment extends BaseFragment {

    public static final String TAG=MineFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        layout = inflater.inflate(R.layout.fragment_mine,container,false);

        return layout;
    }
}
