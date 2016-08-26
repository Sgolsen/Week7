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
public class LocalRadioFragment extends BaseFragment implements View.OnClickListener {

    private static final String TAG = LocalRadioFragment.class.getSimpleName();
    private TopBar mTopBar;
    private ListView mListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_local_radio,container,false);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        setupView();
    }

    private void setupView() {
        HttpUtil.getStringAsync(HttpConstant.LOCAL_RADIO_URL, new HttpUtil.RequestCallBack() {
            private LocalRadioAdapter mAdapter;

            @Override
            public void onFailure() {
                Log.e(TAG, "onFailure: 网络请求失败" );
            }

            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                RadiosList localRadios = gson.fromJson(result, RadiosList.class);
                mAdapter = new LocalRadioAdapter(getActivity(),localRadios.getResult(), R.layout.radio_item);
                mListView.setAdapter(mAdapter);
            }

            @Override
            public void onFinish() {

            }
        });
    }

    private void initView() {
        mTopBar = (TopBar) layout.findViewById(R.id.local_top_bar);
        mListView = ((ListView) layout.findViewById(R.id.local_lv));

        mTopBar.setTitle("本地台");
        mTopBar.onBackClick(this);

    }
//--------------------------- 返回按钮监听 ------------------------------------------
    @Override
    public void onClick(View v) {
        getActivity().finish();
    }
}
