package com.example.administrator.traveldiary.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.traveldiary.R;

/**
 * Created by NewHT on 2016/10/5.
 */
public class TopicFragment extends Fragment {

      public static TopicFragment newInstance(){
          TopicFragment mFragment = new TopicFragment();
          return mFragment;
      }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.topic, null);
        return view;
    }
}
