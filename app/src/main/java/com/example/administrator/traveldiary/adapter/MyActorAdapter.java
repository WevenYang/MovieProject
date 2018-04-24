package com.example.administrator.traveldiary.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.administrator.traveldiary.R;
import com.example.administrator.traveldiary.bean.Subject;


import java.util.List;

import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by Administrator on 2016/11/7 0007.
 */
public class MyActorAdapter extends RecyclerView.Adapter<MyActorAdapter.ViewHolder>{
    Context mContext;
    List<Subject.Cast> list;
    MyItemClickListener listener;

    public MyActorAdapter(List<Subject.Cast> list, Context mContext) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.actor_list_item, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(mContext).load(list.get(position).getAvatars().getSmall()).bitmapTransform(new CropCircleTransformation(mContext)).into(holder.view);
        holder.text.setText(list.get(position).getName());
//        Log.i("name", list.get(position).getName());
//        Log.i("img", list.get(position).getAvatars().getSmall());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setListener(MyItemClickListener listener){
        this.listener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView view;
        public TextView text;
        public ViewHolder(View itemView) {
            super(itemView);
            view = (ImageView) itemView.findViewById(R.id.actor_img);
            text = (TextView) itemView.findViewById(R.id.actor_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(view, getAdapterPosition());
                }
            });
        }
    }
}
