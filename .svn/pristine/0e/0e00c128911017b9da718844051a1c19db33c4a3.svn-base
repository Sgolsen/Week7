package com.golsen.week7.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.golsen.week7.R;
import com.golsen.week7.adapters.AnchorAdapter;
import com.golsen.week7.constants.HttpConstant;
import com.golsen.week7.model.AnchorData;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshExpandableListView;
import com.rock.teachlibrary.http.HttpUtil;

/**
 * Created by Administrator on 2016/8/22 0022.
 */
public class AnchorFragment extends BaseFragment implements PullToRefreshBase.OnRefreshListener2, ExpandableListView.OnGroupClickListener {
    private int pageIndex=1;
    private int dataSize;
    private static final String TAG = AnchorFragment.class.getSimpleName();
    private ExpandableListView mELv;
    private AnchorAdapter mAdapter;
    PullToRefreshExpandableListView mRefresh;

    //-------------------------------listView 监听--------------------------------------------
    @Override
    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
        return true;
    }

    enum State{
        UP,DOWN
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_anchor,container,false);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        setupView(State.DOWN);
    }


    private void setupView(final State state) {
        HttpUtil.getStringAsync(HttpConstant.ANCHOR_DATA_URL + pageIndex, new HttpUtil.RequestCallBack() {
            @Override
            public void onFailure() {
                Log.e(TAG, "onFailure: 网络请求失败" );
            }

            @Override
            public void onSuccess(String result) {

                Gson gson = new Gson();
                AnchorData anchorData = gson.fromJson(result, AnchorData.class);
                dataSize=anchorData.getList().size();
                switch (state) {
                    case DOWN:
                        mAdapter.updateRes(anchorData.getList());
                        break;
                    case UP:
                        mAdapter.addRes(anchorData.getList());
                        break;

                }

            }

            @Override
            public void onFinish() {
                mRefresh.onRefreshComplete();
                for (int i = 0; i < dataSize; i++) {
                    mELv.expandGroup(i);
                }
            }
        });
    }

    private void initView() {
        mRefresh = (PullToRefreshExpandableListView) layout.findViewById(R.id.anchor_expandable_listview);
        mRefresh.setOnRefreshListener(this);
        mRefresh.setMode(PullToRefreshBase.Mode.BOTH);

        mELv = mRefresh.getRefreshableView();
        mAdapter = new AnchorAdapter(getActivity(),null);
        mELv.setAdapter(mAdapter);
        mELv.setOnGroupClickListener(this);

    }


    //------------------------- 刷新和加载的监听 --------------------------------------------
    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        pageIndex=1;
        setupView(State.DOWN);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        pageIndex++;
        setupView(State.UP);
    }
}
