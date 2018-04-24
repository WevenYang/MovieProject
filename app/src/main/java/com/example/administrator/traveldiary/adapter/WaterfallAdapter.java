package com.example.administrator.traveldiary.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.traveldiary.R;
import com.example.administrator.traveldiary.bean.Subject;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by NewHT on 2016/10/15.
 */
public class WaterfallAdapter extends RecyclerView.Adapter<WaterfallAdapter.ViewHolder> {

    public List<Subject> list;
    public Context mContext;
    public MyItemClickListener listener;

    public WaterfallAdapter(List<Subject> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.waterfall_item, null);
        ViewHolder holder = new ViewHolder(view, listener);
        return holder;
    }

    public void setListener(MyItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(mContext).load(list.get(position).getImages().getSmall().toString()).bitmapTransform(new RoundedCornersTransformation(mContext, 10, 0)).into(holder.imgUrl);
        holder.movie.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgUrl;
        TextView movie;
        MyItemClickListener listener;

        public ViewHolder(View itemView, final MyItemClickListener listener) {
            super(itemView);
            imgUrl = (ImageView)itemView.findViewById(R.id.movieImg);
            movie = (TextView)itemView.findViewById(R.id.movieTitle);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(view, getAdapterPosition());
                }
            });
        }
    }

}
