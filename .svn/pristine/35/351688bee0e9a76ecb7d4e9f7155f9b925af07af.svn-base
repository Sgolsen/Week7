package com.golsen.week7.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.golsen.week7.R;

/**
 * Created by Administrator on 2016/8/26 0026.
 */
public class TopBar extends RelativeLayout {

    private Button mBack;
    private TextView mTitle;

    public TopBar(Context context) {
        this(context,null);
    }

    public TopBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TopBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.top_bar, this, true);
        mBack = ((Button) view.findViewById(R.id.top_bar_back));
        mTitle = ((TextView) view.findViewById(R.id.top_bar_title));

    }

    public void setTitle(String title){
        mTitle.setVisibility(VISIBLE);
        mTitle.setText(title);
    }

    public void onBackClick(OnClickListener listener){
        mBack.setVisibility(VISIBLE);
        mBack.setOnClickListener(listener);
    }

}
