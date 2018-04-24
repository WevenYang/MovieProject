package com.example.administrator.traveldiary.view;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.traveldiary.R;
import com.example.administrator.traveldiary.presenter.RecyclerViewPresent;

/**
 * Created by Administrator on 2016/11/7 0007.
 */
public class IntroFragment extends Fragment {

    TextView summary, kind, area, year, title;
    RecyclerViewPresent present;
    View view;

    public static IntroFragment newInstance(){
            return new IntroFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.intro, null);
        initBase();
        present.getMovieSummary(summary, kind, area, year, title, getActivity().getIntent().getStringExtra("id"));
        return view;
    }

    public void initBase(){
        present = new RecyclerViewPresent(getContext());
        summary = (TextView) view.findViewById(R.id.content1);
        kind = (TextView) view.findViewById(R.id.content2);
        area = (TextView) view.findViewById(R.id.content3);
        year = (TextView) view.findViewById(R.id.content4);
        title = (TextView) view.findViewById(R.id.content5);
    }
}
