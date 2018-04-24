package com.example.administrator.traveldiary.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.traveldiary.R;
import com.example.administrator.traveldiary.bean.MovieDetail;
import com.example.administrator.traveldiary.bean.Subject;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.OnClick;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by NewHT on 2016/10/6.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static final int TYPE_NORMAL_ITEM = 0;  //普通Item
    private static final int TYPE_FOOTER_ITEM = 1;  //底部FooterView

    //上拉加载更多
    public static final int PULLUP_LOAD_MORE = 1;
    //正在加载中
    public static final int LOADING_MORE = 2;
    //默认为0
    private int load_more_status = 1;
    public List<Subject> list;
    public Context mContext;
    MyItemClickListener listener;

    public MyRecyclerViewAdapter(List<Subject> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    //创建view,被LayoutManager所调用
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_NORMAL_ITEM){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item, parent, false);
            ViewHolder vh = new ViewHolder(view, listener);
            return vh;
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_footer_view, parent, false);
            FooterViewHolder vh = new FooterViewHolder(view);
            return vh;
        }

    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder){
            Glide.with(mContext).load(list.get(position).getImages().getSmall().toString()).bitmapTransform(new RoundedCornersTransformation(mContext, 10, 0)).into(((ViewHolder)holder).pic);
            ((ViewHolder)holder).title.setText(list.get(position).getTitle());
//        Log.i("title", list.get(position).getTitle());
            if (list.get(position).getRating().getAverage() != 0){
                ((ViewHolder)holder).goal.setText("" + list.get(position).getRating().getAverage());
            }else {
                ((ViewHolder)holder).goal.setText("未评分");
            }
        }else if (holder instanceof FooterViewHolder){
            FooterViewHolder footerViewHolder = (FooterViewHolder)holder;
            switch (load_more_status){
                case PULLUP_LOAD_MORE:
                    footerViewHolder.foot_view_item_tv.setVisibility(View.VISIBLE);
                    footerViewHolder.foot_view_item_tv.setText("上拉更多");
                    footerViewHolder.pb.setVisibility(View.GONE);
                    break;
                case LOADING_MORE:
                    footerViewHolder.foot_view_item_tv.setVisibility(View.GONE);
                    footerViewHolder.pb.setVisibility(View.VISIBLE);
                    break;
            }
        }

    }

    public void setListener(MyItemClickListener listener) {
        this.listener = listener;
    }


    //获取数据的数量
    @Override
    public int getItemCount() {
        return list.size()+1;
    }

    public int getItemViewType(int position){
        if (position + 1 == getItemCount()){
            return TYPE_FOOTER_ITEM;
        }else {
            return TYPE_NORMAL_ITEM;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView title, goal;
        public ImageView pic;
        public ViewHolder(View itemView, final MyItemClickListener listener) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.movieTitle);
            goal = (TextView) itemView.findViewById(R.id.movieGoal);
            pic = (ImageView) itemView.findViewById(R.id.movieImg);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(view, getAdapterPosition());
                }
            });
        }

    }

    public static class FooterViewHolder extends RecyclerView.ViewHolder{

        public TextView foot_view_item_tv;
        public ProgressBar pb;

        public FooterViewHolder(View itemView) {
            super(itemView);
            pb = (ProgressBar) itemView.findViewById(R.id.progress_view);
            foot_view_item_tv = (TextView) itemView.findViewById(R.id.tv_content);
        }

    }

    public void setMoreStatus(int status){
        load_more_status = status;
        notifyDataSetChanged();
    }

}
