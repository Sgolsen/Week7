package com.golsen.week7.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.golsen.week7.R;
import com.rock.teachlibrary.ImageLoader;

/**
 * Created by Administrator on 2016/8/24 0024.
 */
public class ImageFragmentNigh extends BaseFragment{
    private ImageView mImg;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_img_nigh,container,false);
        initView();
        setupView();
        return layout;
    }

    private void setupView() {
        Bundle arguments = getArguments();
        String imgUrl = arguments.getString("imgUrl", null);
        ImageLoader.display(mImg,imgUrl,R.mipmap.rec_logo);
    }

    private void initView() {
        mImg = ((ImageView) layout.findViewById(R.id.fragment_image_img_nigh));
    }
}
