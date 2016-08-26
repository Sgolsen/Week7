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
public class ColumnsFragmentTwo extends BaseFragment {

    private ImageView mImgOne;
    private ImageView mImgTwo;
    private ImageView mImgFour;
    private ImageView mImgThree;
    private TextView mTxtOne;
    private TextView mTxtTwo;
    private TextView mTxtThree;
    private TextView mTxtFour;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_columns_two,container,false);
        initView();
        setupView();
        return layout;
    }

    private void setupView() {
        Bundle arguments = getArguments();
        Columns columnOne = ((Columns) arguments.getSerializable("columnOne"));
        Columns columnTwo = ((Columns) arguments.getSerializable("columnTwo"));
        Columns columnThree = ((Columns) arguments.getSerializable("columnThree"));
        Columns columnFour = ((Columns) arguments.getSerializable("columnFour"));

        mTxtOne.setText(columnOne.getTitle());
        mTxtTwo.setText(columnTwo.getTitle());
        mTxtThree.setText(columnThree.getTitle());
        mTxtFour.setText(columnFour.getTitle());


        ImageLoader.display(mImgOne,columnOne.getCoverPath());
        ImageLoader.display(mImgTwo,columnTwo.getCoverPath());
        ImageLoader.display(mImgThree,columnThree.getCoverPath());
        ImageLoader.display(mImgFour,columnFour.getCoverPath());

    }

    private void initView() {
        mImgOne = ((ImageView) layout.findViewById(R.id.columns_two_img_one));
        mImgTwo = ((ImageView) layout.findViewById(R.id.columns_two_img_two));
        mImgThree = ((ImageView) layout.findViewById(R.id.columns_two_img_three));
        mImgFour = ((ImageView) layout.findViewById(R.id.columns_two_img_four));

        mTxtOne = ((TextView) layout.findViewById(R.id.columns_two_text_one));
        mTxtTwo = ((TextView) layout.findViewById(R.id.columns_two_text_two));
        mTxtThree = ((TextView) layout.findViewById(R.id.columns_two_text_three));
        mTxtFour = ((TextView) layout.findViewById(R.id.columns_two_text_four));
    }
}
