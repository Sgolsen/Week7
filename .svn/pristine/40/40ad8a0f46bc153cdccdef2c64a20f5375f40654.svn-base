package com.golsen.week7.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.golsen.week7.R;
import com.golsen.week7.model.Columns;
import com.rock.teachlibrary.ImageLoader;

/**
 * Created by Administrator on 2016/8/24 0024.
 */
public class ColumnsFragmentThree extends BaseFragment {

    private ImageView mImgOne;
    private ImageView mImgTwo;
    private TextView mTxtOne;
    private TextView mTxtTwo;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_columns_three,container,false);
        initView();
        setupView();
        return layout;
    }

    private void setupView() {
        Bundle arguments = getArguments();
        Columns columnOne = ((Columns) arguments.getSerializable("columnOne"));
        Columns columnTwo = ((Columns) arguments.getSerializable("columnTwo"));

        mTxtOne.setText(columnOne.getTitle());
        mTxtTwo.setText(columnTwo.getTitle());

        ImageLoader.display(mImgOne,columnOne.getCoverPath());
        ImageLoader.display(mImgTwo,columnTwo.getCoverPath());
        
    }

    private void initView() {
        mImgOne = ((ImageView) layout.findViewById(R.id.columns_three_img_one));
        mImgTwo = ((ImageView) layout.findViewById(R.id.columns_three_img_two));

        mTxtOne = ((TextView) layout.findViewById(R.id.columns_three_text_one));
        mTxtTwo = ((TextView) layout.findViewById(R.id.columns_three_text_two));
    }
}
