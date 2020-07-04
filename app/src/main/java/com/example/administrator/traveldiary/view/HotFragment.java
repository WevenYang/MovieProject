package com.example.administrator.traveldiary.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.traveldiary.R;
import com.example.administrator.traveldiary.presenter.RecyclerViewPresent;

/**
 * Created by NewHT on 2016/10/5.
 */
public class HotFragment extends Fragment {

    RecyclerView recycler;
    View view;
    RecyclerViewPresent present;
    SwipeRefreshLayout mSwipeRefresh;
//    SubscriberOnNextListener getTopMovieOnNext;

    public static HotFragment newInstance(){
        HotFragment mFragment = new HotFragment();
        return mFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.hot, null);
        present = new RecyclerViewPresent(this.getContext());
        initRecyclerView();
//        mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                present.getHotMovie(recycler);
//                mSwipeRefresh.setRefreshing(false);
//            }
//        });

        return view;
    }

    public void initRecyclerView(){
        recycler = (RecyclerView) view.findViewById(R.id.recycler);
        mSwipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.refresh);
//        present.getHotMovie(recycler);
    }

}
