package com.example.administrator.traveldiary.view;

import android.support.v4.widget.SwipeRefreshLayout;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.administrator.traveldiary.R;
import com.example.administrator.traveldiary.adapter.onLoadMoreListener;
import com.example.administrator.traveldiary.presenter.RecyclerViewPresent;

public class CommonActivity extends BaseActivity {

    RecyclerView recycler;
    View view;
    RecyclerViewPresent present;
    SwipeRefreshLayout mSwipeRefresh;
    String movieType = "";
    int startIndex = 0;
    int count = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);
        movieType = getIntent().getStringExtra("type");
        present = new RecyclerViewPresent(this);
        initRecyclerView();
        mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                startIndex = 0;
                mSwipeRefresh.setRefreshing(false);
                switch (movieType){
                    case "0":
                        present.getHotMovie(recycler, startIndex, count);
                        break;
                    case "1":
                        present.getLoadingMovie(recycler, startIndex, count);
                        break;
                    case "2":
                        present.getTopMovie(recycler, startIndex, count);
                        break;
                }
            }
        });
        recycler.addOnScrollListener(new onLoadMoreListener(){
            @Override
            protected void onLoading(int countItem, int lastItem) {
                startIndex = startIndex + count;
                switch (movieType){
                    case "0":
                        present.getHotMovie(recycler, startIndex, count);
                        break;
                    case "1":
                        present.getLoadingMovie(recycler, startIndex, count);
                        break;
                    case "2":
                        present.getTopMovie(recycler, startIndex, count);
                        break;
                }
            }
        });

    }

    public void initRecyclerView(){
        recycler = (RecyclerView) findViewById(R.id.recycler);
        mSwipeRefresh = (SwipeRefreshLayout) findViewById(R.id.refresh);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.mipmap.back_ib);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        switch (movieType){
            //0为热门电影，1为待映电影，2为经典电影
            case "0":
                present.getHotMovie(recycler, startIndex, count);
                toolbar.setTitle("热门电影");
                break;
            case "1":
                present.getLoadingMovie(recycler, startIndex, count);
                toolbar.setTitle("待映电影");
                break;
            case "2":
                present.getTopMovie(recycler, startIndex, count);
                toolbar.setTitle("经典电影");
                break;
            default:
                break;
        }


    }

}
