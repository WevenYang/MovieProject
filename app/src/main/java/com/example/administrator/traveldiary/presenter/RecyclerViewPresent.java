package com.example.administrator.traveldiary.presenter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.traveldiary.R;
import com.example.administrator.traveldiary.adapter.CommonAdapter;
import com.example.administrator.traveldiary.adapter.MultiChoicesAdapter;
import com.example.administrator.traveldiary.adapter.MyActorAdapter;
import com.example.administrator.traveldiary.adapter.MyItemClickListener;
import com.example.administrator.traveldiary.adapter.MyRecyclerViewAdapter;
import com.example.administrator.traveldiary.adapter.TestAdapter;
import com.example.administrator.traveldiary.adapter.ViewHolder;
import com.example.administrator.traveldiary.adapter.WaterfallAdapter;
import com.example.administrator.traveldiary.bean.MovieC;
import com.example.administrator.traveldiary.bean.PersonData;
import com.example.administrator.traveldiary.bean.Subject;
import com.example.administrator.traveldiary.config.TargetUrl;
import com.example.administrator.traveldiary.subscribers.ProgressSubscriber;
import com.example.administrator.traveldiary.subscribers.SubscriberOnNextListener;
import com.example.administrator.traveldiary.util.HttpMethods;
import com.example.administrator.traveldiary.util.MyToast;
import com.example.administrator.traveldiary.util.SharePreferenceUtils;
import com.example.administrator.traveldiary.view.MainActivity;
import com.example.administrator.traveldiary.view.MovieCommentActivity;
import com.example.administrator.traveldiary.view.MovieDetailActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by NewHT on 2016/10/10.
 */
public class RecyclerViewPresent {

    Context mContext;
    SubscriberOnNextListener getTopMovieOnNext;
    MultiChoicesAdapter adapter;
    MyRecyclerViewAdapter aadapter;
    List<Subject> arrayList;

    public RecyclerViewPresent(Context mContext) {
        this.mContext = mContext;
    }

    public void getTopMovie(final RecyclerView view, final int index, int count){
        HttpMethods.getInstance(0).getTopMovie(new ProgressSubscriber(new SubscriberOnNextListener<List<Subject>>() {
            @Override
            public void onNext(final List<Subject> o) {
                if (aadapter == null){
                    arrayList = new ArrayList<>();
                    arrayList.addAll(o);
                    aadapter = new MyRecyclerViewAdapter(arrayList, mContext);
                    final LinearLayoutManager mLayout = new LinearLayoutManager(mContext);
                    view.setLayoutManager(mLayout);
                    view.setAdapter(aadapter);
                    aadapter.setListener(new MyItemClickListener() {
                        @Override
                        public void onItemClick(View view, int postion) {
                            Intent i = new Intent(mContext, MovieDetailActivity.class);
                            i.putExtra("image", o.get(postion).getImages().getLarge());
                            i.putExtra("id", o.get(postion).getId());
                            i.putExtra("title", o.get(postion).getTitle());
                            i.putExtra("link", o.get(postion).getAlt());
                            mContext.startActivity(i);
                        }
                    });
                }else{
                    //当加载后下拉刷新时，index会恢复为0，需清空数组元素
                    if (index == 0){
                        arrayList.clear();
                    }
                    arrayList.addAll(o);
                    aadapter.notifyDataSetChanged();
                }
//                TestAdapter adapter = new TestAdapter(o, mContext);
//                view.setAdapter(adapter);
//                adapter.setListener(new MyItemClickListener() {
//                    @Override
//                    public void onItemClick(View view, int postion) {
//                        Intent i = new Intent(mContext, MovieDetailActivity.class);
//                        i.putExtra("image", o.get(postion).getImages().getLarge());
//                        i.putExtra("id", o.get(postion).getId());
//                        i.putExtra("title", o.get(postion).getTitle());
//                        i.putExtra("link", o.get(postion).getAlt());
//                        mContext.startActivity(i);
//                    }
//                });

            }
        }, mContext), index, count, TargetUrl.API_KEY);

    }

    public void getHotMovie(final RecyclerView view, final int index, int count){
        Log.i("nice", "index is " + index + " and count is " + count);
        HttpMethods.getInstance(0).getHotMovie(new ProgressSubscriber(new SubscriberOnNextListener<List<Subject>>() {
            @Override
            public void onNext(final List<Subject> o) {
                if (aadapter == null){
                    arrayList = new ArrayList<>();
                    arrayList.addAll(o);
                    aadapter = new MyRecyclerViewAdapter(arrayList, mContext);
                    final LinearLayoutManager mLayout = new LinearLayoutManager(mContext);
                    view.setLayoutManager(mLayout);
                    view.setAdapter(aadapter);
                    aadapter.setListener(new MyItemClickListener() {
                        @Override
                        public void onItemClick(View view, int postion) {
                            Intent i = new Intent(mContext, MovieDetailActivity.class);
                            i.putExtra("image", o.get(postion).getImages().getLarge());
                            i.putExtra("id", o.get(postion).getId());
                            i.putExtra("title", o.get(postion).getTitle());
                            mContext.startActivity(i);
                        }
                    });
                }else{
                    //当加载后下拉刷新时，index会恢复为0，需清空数组元素
                    if (index == 0){
                        arrayList.clear();
                    }
                    arrayList.addAll(o);
                    aadapter.notifyDataSetChanged();
                }
            }
        }, mContext), "北京", index, count, TargetUrl.API_KEY);
    }

    public void getLoadingMovie(final RecyclerView view, final int index, int count){
        HttpMethods.getInstance(0).getLoadingMovie(new ProgressSubscriber(new SubscriberOnNextListener<List<Subject>>() {
            @Override
            public void onNext(final List<Subject> o) {
                if (aadapter == null){
                    arrayList = new ArrayList<>();
                    arrayList.addAll(o);
                    aadapter = new MyRecyclerViewAdapter(arrayList, mContext);
                    final LinearLayoutManager mLayout = new LinearLayoutManager(mContext);
                    view.setLayoutManager(mLayout);
                    view.setAdapter(aadapter);
                    aadapter.setListener(new MyItemClickListener() {
                        @Override
                        public void onItemClick(View view, int postion) {
                            Intent i = new Intent(mContext, MovieDetailActivity.class);
                            i.putExtra("image", o.get(postion).getImages().getLarge());
                            i.putExtra("id", o.get(postion).getId());
                            i.putExtra("title", o.get(postion).getTitle());
                            mContext.startActivity(i);
                        }
                    });
                }else{
                    //当加载后下拉刷新时，index会恢复为0，需清空数组元素
                    if (index == 0){
                        arrayList.clear();
                    }
                    arrayList.addAll(o);
                    aadapter.notifyDataSetChanged();
                }
//                WaterfallAdapter adapter = new WaterfallAdapter(o, mContext);
//                view.setAdapter(adapter);
//                adapter.setListener(new MyItemClickListener() {
//                    @Override
//                    public void onItemClick(View view, int postion) {
//                        Intent i = new Intent(mContext, MovieDetailActivity.class);
//                        i.putExtra("image", o.get(postion).getImages().getLarge());
//                        i.putExtra("id", o.get(postion).getId());
//                        i.putExtra("title", o.get(postion).getTitle());
//                        mContext.startActivity(i);
//                    }
//                });
            }
        }, mContext), index, count, TargetUrl.API_KEY);
    }


    /**
     *搜索模块实现
     * @param recycler  搜索列表控件
     * @param s     搜索关键字
     */
    public void multiChoices(final RecyclerView recycler, final String s, final int index, final int count){
        ArrayList<String> list = new ArrayList<String>();
        list.add("搜索名字:"+s);
        list.add("搜索类型:"+s);
        adapter = new MultiChoicesAdapter(list);
        recycler.setAdapter(adapter);
        adapter.setmItemClickListener(new MyItemClickListener() {
            @Override
            public void onItemClick(View view, int postion) {
               if (postion == 0){
                   HttpMethods.getInstance(0).getResultByName(new ProgressSubscriber(new SubscriberOnNextListener<List<Subject>>() {
                       @Override
                       public void onNext(final List<Subject> o) {
                           if (aadapter == null){
                               arrayList = new ArrayList<>();
                               arrayList.addAll(o);
                               aadapter = new MyRecyclerViewAdapter(arrayList, mContext);
                               final LinearLayoutManager mLayout = new LinearLayoutManager(mContext);
                               recycler.setLayoutManager(mLayout);
                               recycler.setAdapter(aadapter);
                               aadapter.setListener(new MyItemClickListener() {
                                   @Override
                                   public void onItemClick(View view, int postion) {
                                       Intent i = new Intent(mContext, MovieDetailActivity.class);
                                       i.putExtra("image", o.get(postion).getImages().getLarge());
                                       i.putExtra("id", o.get(postion).getId());
                                       i.putExtra("title", o.get(postion).getTitle());
                                       mContext.startActivity(i);
                                   }
                               });
                           }else{
                               //当加载后下拉刷新时，index会恢复为0，需清空数组元素
                               if (index == 0){
                                   arrayList.clear();
                               }
                               arrayList.addAll(o);
                               aadapter.notifyDataSetChanged();
                           }
//                           MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(o, mContext);
//                           recycler.setAdapter(adapter);
//                           adapter.setListener(new MyItemClickListener() {
//                               @Override
//                               public void onItemClick(View view, int postion) {
//                                   Intent i = new Intent(mContext, MovieDetailActivity.class);
//                                   i.putExtra("image", o.get(postion).getImages().getLarge());
//                                   i.putExtra("id", o.get(postion).getId());
//                                   i.putExtra("title", o.get(postion).getTitle());
//                                   mContext.startActivity(i);
//                               }
//                           });
                       }
                   }, mContext), s, index, count, TargetUrl.API_KEY);
               }else{
                   HttpMethods.getInstance(0).getResultByTag(new ProgressSubscriber(new SubscriberOnNextListener<List<Subject>>() {
                       @Override
                       public void onNext(final List<Subject> o) {
                           if (aadapter == null){
                               arrayList = new ArrayList<>();
                               arrayList.addAll(o);
                               aadapter = new MyRecyclerViewAdapter(arrayList, mContext);
                               final LinearLayoutManager mLayout = new LinearLayoutManager(mContext);
                               recycler.setLayoutManager(mLayout);
                               recycler.setAdapter(aadapter);
                               aadapter.setListener(new MyItemClickListener() {
                                   @Override
                                   public void onItemClick(View view, int postion) {
                                       Intent i = new Intent(mContext, MovieDetailActivity.class);
                                       i.putExtra("image", o.get(postion).getImages().getLarge());
                                       i.putExtra("id", o.get(postion).getId());
                                       i.putExtra("title", o.get(postion).getTitle());
                                       mContext.startActivity(i);
                                   }
                               });
                           }else{
                               //当加载后下拉刷新时，index会恢复为0，需清空数组元素
                               if (index == 0){
                                   arrayList.clear();
                               }
                               arrayList.addAll(o);
                               aadapter.notifyDataSetChanged();
                           }
//                           MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(o, mContext);
//                           recycler.setAdapter(adapter);
//                           adapter.setListener(new MyItemClickListener() {
//                               @Override
//                               public void onItemClick(View view, int postion) {
//                                   Intent i = new Intent(mContext, MovieDetailActivity.class);
//                                   i.putExtra("image", o.get(postion).getImages().getLarge());
//                                   i.putExtra("id", o.get(postion).getId());
//                                   i.putExtra("title", o.get(postion).getTitle());
//                                   mContext.startActivity(i);
//                               }
//                           });
                       }
                   }, mContext), s, index, count, TargetUrl.API_KEY);
               }
            }
        });
    }

    /**
     * 获取详细页中，导演和演员信息并可点击跳转
     * @param recyclerView1     导演列表
     * @param recyclerView2     演员列表
     * @param id    电影id
     */
    public void getDetailMovie(final RecyclerView recyclerView1, final RecyclerView recyclerView2, String id){
        HttpMethods.getInstance(0).getDetailMovie(new ProgressSubscriber(new SubscriberOnNextListener<Subject>() {
                @Override
                public void onNext(final Subject o) {
                    MyActorAdapter director = new MyActorAdapter(o.getDirectors(), mContext);
                    MyActorAdapter actor = new MyActorAdapter(o.getCasts(), mContext);
                    recyclerView1.setAdapter(director);
                    recyclerView2.setAdapter(actor);
                    director.setListener(new MyItemClickListener() {
                        @Override
                        public void onItemClick(View view, int postion) {
                            Uri uri = Uri.parse(o.getDirectors().get(postion).getAlt());
                            mContext.startActivity(new Intent(Intent.ACTION_VIEW, uri));
                        }
                    });
                    actor.setListener(new MyItemClickListener() {
                        @Override
                        public void onItemClick(View view, int postion) {
                            Uri uri = Uri.parse(o.getCasts().get(postion).getAlt());
                            mContext.startActivity(new Intent(Intent.ACTION_VIEW, uri));
                        }
                    });
                }
            }, mContext), id, TargetUrl.API_KEY);
    }

    /**
     * 获取电影详细信息
     * @param summary   简介
     * @param kind      类型
     * @param area      地区
     * @param year      日期
     * @param title     名字
     * @param id        电影id
     */
    public void getMovieSummary(final TextView summary, final TextView kind, final TextView area, final TextView year, final TextView title, String id){

        HttpMethods.getInstance(0).getDetailMovie(new ProgressSubscriber(new SubscriberOnNextListener<Subject>() {
            @Override
            public void onNext(Subject o) {
                StringBuffer s = new StringBuffer();
                summary.setText(o.getSummary());
                for (int i = 0; i < o.getGenres().size(); i++)
                    s.append(o.getGenres().get(i)+" ");
                kind.setText(s);
                area.setText(o.getCountries().get(0));
                year.setText(o.getYear().toString());
                title.setText(o.getOriginal_title().toString());
            }
        }, mContext), id, TargetUrl.API_KEY);
    }

    /**
     * 获取影评列表
     * @param view      RecyclerView控件列表
     * @param userId    用户id
     */
    public void getMovieComment(final RecyclerView view, String userId){
        HttpMethods.getInstance(1).getMovieCommentsList(new ProgressSubscriber(new SubscriberOnNextListener<MovieC>() {
            @Override
            public void onNext(MovieC o) {
                view.setLayoutManager(new LinearLayoutManager(mContext));
                CommonAdapter<MovieC.DataBean> adapter = new CommonAdapter<MovieC.DataBean>(mContext, R.layout.comment_item, o.getData()) {
                    @Override
                    public void convert(ViewHolder holder, final MovieC.DataBean o) {
                        CardView cv_item = (CardView) holder.getView(R.id.cv_item);
                        ImageView movieImg = (ImageView) holder.getView(R.id.movieImg);
                        TextView title = (TextView) holder.getView(R.id.title);
                        TextView author_name = (TextView) holder.getView(R.id.authorName);
                        ImageView author_img = (ImageView) holder.getView(R.id.authorImg);
                        if (o.getM_pass().equals("1")){
                            Glide.with(mContext).load(o.getImg()).into(movieImg);
                            Glide.with(mContext).load(o.getPic()).bitmapTransform(new RoundedCornersTransformation(mContext, 20, 0)).into(author_img);
                            title.setText(o.getTitle());
                            author_name.setText(o.getNick_name());
                            cv_item.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i = new Intent(mContext, MovieCommentActivity.class);
                                    Bundle bundle = new Bundle();
                                    bundle.putString("id", o.getId());
                                    bundle.putString("img", o.getImg());
                                    bundle.putString("pic", o.getPic());
                                    bundle.putString("content", o.getContent());
                                    bundle.putString("title", o.getTitle());
                                    i.putExtra("Bundle", bundle);
                                    mContext.startActivity(i);
                                }
                            });
                        }else {
                            cv_item.setVisibility(View.GONE);
                        }

                    }
                };
                view.setAdapter(adapter);

            }
        }, mContext), userId);
    }

    public void getMovieCommentDatail(){

    }
}
