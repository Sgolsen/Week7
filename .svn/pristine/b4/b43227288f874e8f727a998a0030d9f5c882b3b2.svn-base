package com.golsen.week7.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.golsen.week7.R;
import com.golsen.week7.ui.fragments.LocalRadioFragment;
import com.golsen.week7.ui.fragments.NationRadioFragment;
import com.golsen.week7.ui.fragments.NetRadioFragment;
import com.golsen.week7.ui.fragments.ProvinceRadioFragment;

public class BroadcastActivity extends BaseActivity {

    private static final int LOCAL = 0;
    private static final int NATIONAL = 1;
    private static final int PROVINCE = 2;
    private static final int NET = 3;
    private static final String TAG = BroadcastActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
        initView();

    }

    private void initView() {


        Intent intent = getIntent();
        int type = intent.getIntExtra("type", 0);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        switch (type) {
            case LOCAL:
                LocalRadioFragment localRadioFragment = new LocalRadioFragment();
                transaction.add(R.id.broadcast_container,localRadioFragment);
                break;
            case NATIONAL:
                NationRadioFragment nationRadioFragment = new NationRadioFragment();
                transaction.add(R.id.broadcast_container, nationRadioFragment);
                break;
            case PROVINCE:
                ProvinceRadioFragment provinceRadioFragment = new ProvinceRadioFragment();
                transaction.add(R.id.broadcast_container, provinceRadioFragment);

                break;
            case  NET:
                NetRadioFragment netRadioFragment = new NetRadioFragment();
                transaction.add(R.id.broadcast_container, netRadioFragment);
                break;
        }
        transaction.commit();

    }
}
