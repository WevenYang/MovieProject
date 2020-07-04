package com.example.administrator.traveldiary.view;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.example.administrator.traveldiary.R;
import com.example.administrator.traveldiary.presenter.RecyclerViewPresent;

/**
 * Created by NewHT on 2016/10/15.
 */
public class NearbyActivity extends BaseActivity {

    RecyclerView recycler;
    RecyclerViewPresent present;
    SwipeRefreshLayout mSwipeRefresh;
    String map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby);
        initBase();
//        mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                present.getNearbyHotMovie(recycler, map);
//                mSwipeRefresh.setRefreshing(false);
//            }
//        });
    }

    public void initBase(){
        map = getIntent().getStringExtra("map");
        present = new RecyclerViewPresent(this);
        recycler = (RecyclerView) findViewById(R.id.recycler);
        mSwipeRefresh = (SwipeRefreshLayout) findViewById(R.id.refresh);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.mipmap.back_ib);
        toolbar.setTitle(map);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recycler.setLayoutManager(manager);
//        present.getNearbyHotMovie(recycler, map);
    }
}
