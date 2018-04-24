package com.example.administrator.traveldiary.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.traveldiary.R;
import com.example.administrator.traveldiary.presenter.RecyclerViewPresent;

/**
 * Created by NewHT on 2016/10/11.
 */
public class ClassicFragment extends Fragment {

    RecyclerView recycler;
    View view;
    RecyclerViewPresent present;
    SwipeRefreshLayout mSwipeRefresh;

    public static ClassicFragment newInstance(){
        ClassicFragment fragment = new ClassicFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.classic, container, false);
        present = new RecyclerViewPresent(this.getContext());
        initRecyclerView();
        mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                present.getTopMovie(recycler);
                mSwipeRefresh.setRefreshing(false);
            }
        });
        return view;
    }



    public void initRecyclerView(){
        recycler = (RecyclerView) view.findViewById(R.id.recycler);
        mSwipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.refresh);
        LinearLayoutManager mLayout = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(mLayout);
        present.getTopMovie(recycler);
    }


}
