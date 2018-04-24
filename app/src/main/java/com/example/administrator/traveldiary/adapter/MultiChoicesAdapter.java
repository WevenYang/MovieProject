package com.example.administrator.traveldiary.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.traveldiary.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by NewHT on 2016/11/1.
 */
public class MultiChoicesAdapter extends RecyclerView.Adapter<MultiChoicesAdapter.ViewHolder>{

    ArrayList<String> data;
//    Context mContext;
    MyItemClickListener mItemClickListener;

    public MultiChoicesAdapter(ArrayList<String> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.multi_choices_item, null);
        ViewHolder holder = new ViewHolder(view, mItemClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.text.setText(data.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setmItemClickListener(MyItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView search;
        TextView text;
        MyItemClickListener mMyItemClickListener;

        public ViewHolder(View itemView, MyItemClickListener listener) {
            super(itemView);
            search = (ImageView) itemView.findViewById(R.id.search);
            text = (TextView) itemView.findViewById(R.id.text);
            mMyItemClickListener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mMyItemClickListener != null)
                mMyItemClickListener.onItemClick(view, getPosition());
        }
    }
}
