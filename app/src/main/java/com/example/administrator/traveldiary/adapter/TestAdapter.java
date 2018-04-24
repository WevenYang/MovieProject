package com.example.administrator.traveldiary.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.traveldiary.R;

/**
 * Created by Administrator on 2016/10/13 0013.
 */
public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.goal.setText("50");
        holder.title.setText("title");
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView title, goal;
        public ImageView pic;
        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.movieTitle);
            goal = (TextView) itemView.findViewById(R.id.movieGoal);
            pic = (ImageView) itemView.findViewById(R.id.movieImg);
        }
    }
}
