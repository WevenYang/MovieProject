package com.example.administrator.traveldiary.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.traveldiary.R;
import com.example.administrator.traveldiary.presenter.RecyclerViewPresent;

/**
 * Created by Administrator on 2016/11/7 0007.
 */
public class ActorFragment extends Fragment {

    RecyclerView dir, act;
    View view;
    RecyclerViewPresent present;

    public static ActorFragment newInstance(){
        return new ActorFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.actor_list, null);
        present = new RecyclerViewPresent(getContext());
        initRecyclerView();
        return view;
    }

    public void initRecyclerView(){
        dir = (RecyclerView) view.findViewById(R.id.directors);
        act = (RecyclerView) view.findViewById(R.id.actors);
        RecyclerView.LayoutManager mLayout = new LinearLayoutManager(getContext());
        RecyclerView.LayoutManager mLayout1 = new LinearLayoutManager(getContext());
        dir.setLayoutManager(mLayout);
        act.setLayoutManager(mLayout1);
        present.getDetailMovie(dir, act, getActivity().getIntent().getStringExtra("id"));
    }
}
