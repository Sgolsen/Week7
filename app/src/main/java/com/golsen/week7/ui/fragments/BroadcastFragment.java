package com.golsen.week7.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.golsen.week7.R;
import com.golsen.week7.adapters.BroadcastAdapter;
import com.golsen.week7.constants.HttpConstant;
import com.golsen.week7.model.Radio;
import com.golsen.week7.ui.BroadcastActivity;
import com.google.gson.Gson;
import com.rock.teachlibrary.http.HttpUtil;

/**
 * Created by Administrator on 2016/8/22 0022.
 */
public class BroadcastFragment extends BaseFragment implements View.OnClickListener {

    private static final String TAG = BroadcastFragment.class.getSimpleName();

    private static final int LOCAL = 0;
    private static final int NATIONAL = 1;
    private static final int PROVINCE = 2;
    private static final int NET = 3;

    private ListView mListView;
    private BroadcastAdapter mAdapter;
    private Button mLocalBtn;
    private Button mNationBtn;
    private View mProvinceBtn;
    private View mNetBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        layout = inflater.inflate(R.layout.fragment_broadcast,container,false);

        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();
        setupView();
    }

    private void setupView() {
        HttpUtil.getStringAsync(HttpConstant.BROADCAST_LIST_URL, new HttpUtil.RequestCallBack() {
            @Override
            public void onFailure() {
                Log.e(TAG, "onFailure: 请求异常" );
            }

            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                Radio radio = gson.fromJson(result, Radio.class);

                mAdapter.updateRes(radio.getResult().getRecommandRadioList(),radio.getResult().getTopRadioList());
            }

            @Override
            public void onFinish() {
            }
        });
    }

    private void initView() {
        mListView = ((ListView) layout.findViewById(R.id.broadcast_lv));

        View headerView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_broadcast_header, null);

        mLocalBtn = ((Button) headerView.findViewById(R.id.broadcast_local_btn));
        mNationBtn = ((Button) headerView.findViewById(R.id.broadcast_national_btn));
        mProvinceBtn = headerView.findViewById(R.id.broadcast_province_btn);
        mNetBtn = headerView.findViewById(R.id.broadcast_net_btn);

        mLocalBtn.setOnClickListener(this);
        mNationBtn.setOnClickListener(this);
        mProvinceBtn.setOnClickListener(this);
        mNetBtn.setOnClickListener(this);

        mListView.addHeaderView(headerView);
        View footerView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_broadcast_footer,null);
        mListView.addFooterView(footerView);
        mAdapter = new BroadcastAdapter(getActivity(),null,null);
        mListView.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.broadcast_local_btn:
                Intent loIntent = new Intent(getActivity(), BroadcastActivity.class);
                loIntent.putExtra("type",LOCAL);
                startActivity(loIntent);
                break;
            case R.id.broadcast_national_btn:
                Intent naIntent = new Intent(getActivity(), BroadcastActivity.class);
                naIntent.putExtra("type",NATIONAL);
                startActivity(naIntent);
                break;
            case R.id.broadcast_province_btn:
                Intent proIntent = new Intent(getActivity(), BroadcastActivity.class);
                proIntent.putExtra("type",PROVINCE);
                startActivity(proIntent);
                break;
            case R.id.broadcast_net_btn:
                Intent netIntent = new Intent(getActivity(), BroadcastActivity.class);
                netIntent.putExtra("type",NET);
                startActivity(netIntent);
                break;
        }
    }
}
