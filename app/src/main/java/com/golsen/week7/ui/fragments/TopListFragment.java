package com.golsen.week7.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import com.golsen.week7.R;
import com.golsen.week7.adapters.TopListLvAdapter;
import com.golsen.week7.constants.HttpConstant;
import com.golsen.week7.model.ProgrammeGroup;
import com.google.gson.Gson;
import com.rock.teachlibrary.ImageLoader;
import com.rock.teachlibrary.http.HttpUtil;

/**
 * Created by Administrator on 2016/8/22 0022.
 */
public class TopListFragment extends BaseFragment implements ExpandableListView.OnGroupClickListener {

    private static final String TAG = TopListFragment.class.getSimpleName();
    private ExpandableListView mELv;
    private ImageView mHeaderImg;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        layout = inflater.inflate(R.layout.fragment_toplist,container,false);

        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        setupView();



    }

    private void setupView() {
        //加载HeaderView数据
        loadHeaderViewData();
        //加载listView数据
        loadListViewData();
    }

    private void loadHeaderViewData() {
        HttpUtil.getStringAsync(HttpConstant.TOPLIST_LV_URL, new HttpUtil.RequestCallBack() {
            @Override
            public void onFailure() {

            }

            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                ProgrammeGroup programmeGroup = gson.fromJson(result, ProgrammeGroup.class);
                String pic = programmeGroup.getFocusImages().getList().get(0).getPic();
                Log.e(TAG, "onSuccess: "+pic);
                ImageLoader.display(mHeaderImg,pic);

            }

            @Override
            public void onFinish() {

            }
        });
    }


    private void loadListViewData() {
        HttpUtil.getStringAsync(HttpConstant.TOPLIST_LV_URL, new HttpUtil.RequestCallBack() {
            private TopListLvAdapter mAdapter;

            @Override
            public void onFailure() {
                Log.e(TAG, "onFailure: " );
            }

            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                ProgrammeGroup programmeGroup = gson.fromJson(result, ProgrammeGroup.class);
                mAdapter = new TopListLvAdapter(getActivity(),programmeGroup.getDatas());
                mELv.setAdapter(mAdapter);
                int size = programmeGroup.getDatas().size();
                for (int i = 0; i < size; i++) {
                    mELv.expandGroup(i);
                }

            }

            @Override
            public void onFinish() {

            }
        });
    }

    private void initView() {
        mELv = ((ExpandableListView) layout.findViewById(R.id.toplist_elv));

        View headerView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_toplist_header, null);
        mHeaderImg = ((ImageView) headerView.findViewById(R.id.toplist_header_img));

        View footerView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_toplist_footer, null);

        mELv.addHeaderView(headerView);
        mELv.addFooterView(footerView);
        mELv.setOnGroupClickListener(this);
    }

    @Override
    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
        return true;
    }
}
