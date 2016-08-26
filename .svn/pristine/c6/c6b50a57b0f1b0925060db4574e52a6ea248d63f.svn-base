package com.golsen.week7.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.golsen.week7.R;
import com.golsen.week7.adapters.LocalRadioAdapter;
import com.golsen.week7.constants.HttpConstant;
import com.golsen.week7.model.RadiosList;
import com.golsen.week7.ui.view.TopBar;
import com.google.gson.Gson;
import com.rock.teachlibrary.http.HttpUtil;

/**
 * Created by Administrator on 2016/8/26 0026.
 */
public class NetRadioFragment extends BaseFragment implements View.OnClickListener {

    private static final String TAG = NetRadioFragment.class.getSimpleName();
    private TopBar mTopBar;
    private ListView mListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_net_radio,container,false);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        setupView();
    }

    private void setupView() {
        HttpUtil.getStringAsync(HttpConstant.NET_RADIO_URL, new HttpUtil.RequestCallBack() {
            private LocalRadioAdapter mAdapter;

            @Override
            public void onFailure() {
                Log.e(TAG, "onFailure: 网络请求失败" );
            }

            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                RadiosList netRadios = gson.fromJson(result, RadiosList.class);
                mAdapter = new LocalRadioAdapter(getActivity(),netRadios.getResult(), R.layout.radio_item);
                mListView.setAdapter(mAdapter);
            }

            @Override
            public void onFinish() {

            }
        });
    }

    private void initView() {
        mTopBar = ((TopBar) layout.findViewById(R.id.net_top_bar));
        mListView = ((ListView) layout.findViewById(R.id.net_lv));

        mTopBar.setTitle("网络台");
        mTopBar.onBackClick(this);
    }

    @Override
    public void onClick(View v) {
        getActivity().finish();
    }
}
