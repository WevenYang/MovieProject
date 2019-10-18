package com.example.administrator.traveldiary.presenter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.traveldiary.adapter.MultiChoicesAdapter;
import com.example.administrator.traveldiary.adapter.MyActorAdapter;
import com.example.administrator.traveldiary.adapter.MyItemClickListener;
import com.example.administrator.traveldiary.adapter.MyRecyclerViewAdapter;
import com.example.administrator.traveldiary.adapter.WaterfallAdapter;
import com.example.administrator.traveldiary.bean.PersonData;
import com.example.administrator.traveldiary.bean.Subject;
import com.example.administrator.traveldiary.config.TargetUrl;
import com.example.administrator.traveldiary.subscribers.ProgressSubscriber;
import com.example.administrator.traveldiary.subscribers.SubscriberOnNextListener;
import com.example.administrator.traveldiary.util.HttpMethods;
import com.example.administrator.traveldiary.util.SharePreferenceUtils;
import com.example.administrator.traveldiary.view.MainActivity;
import com.example.administrator.traveldiary.view.MovieDetailActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NewHT on 2016/10/10.
 */
public class RecyclerViewPresent {

    Context mContext;
    SubscriberOnNextListener getTopMovieOnNext;
    MultiChoicesAdapter adapter;

    public RecyclerViewPresent(Context mContext) {
        this.mContext = mContext;
    }

    public void getTopMovie(final RecyclerView view){
        HttpMethods.getInstance().getTopMovie(new ProgressSubscriber(new SubscriberOnNextListener<List<Subject>>() {
            @Override
            public void onNext(final List<Subject> o) {
                MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(o, mContext);
                view.setAdapter(adapter);
                adapter.setListener(new MyItemClickListener() {
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
            }
        }, mContext), 0, 20, TargetUrl.API_KEY);

    }

    public void getHotMovie(final RecyclerView view){
        HttpMethods.getInstance().getHotMovie(new ProgressSubscriber(new SubscriberOnNextListener<List<Subject>>() {
            @Override
            public void onNext(final List<Subject> o) {
                final MyRecyclerViewAdapter aadapter = new MyRecyclerViewAdapter(o, mContext);
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
            }
        }, mContext), "北京", TargetUrl.API_KEY);
    }

    public void getLoadingMovie(final RecyclerView view){
        HttpMethods.getInstance().getLoadingMovie(new ProgressSubscriber(new SubscriberOnNextListener<List<Subject>>() {
            @Override
            public void onNext(final List<Subject> o) {
                WaterfallAdapter adapter = new WaterfallAdapter(o, mContext);
                view.setAdapter(adapter);
                adapter.setListener(new MyItemClickListener() {
                    @Override
                    public void onItemClick(View view, int postion) {
                        Intent i = new Intent(mContext, MovieDetailActivity.class);
                        i.putExtra("image", o.get(postion).getImages().getLarge());
                        i.putExtra("id", o.get(postion).getId());
                        i.putExtra("title", o.get(postion).getTitle());
                        mContext.startActivity(i);
                    }
                });
            }
        }, mContext), 0, 22, TargetUrl.API_KEY);
    }

    public void getNearbyHotMovie(final RecyclerView view, String city){
        HttpMethods.getInstance().getHotMovie(new ProgressSubscriber(new SubscriberOnNextListener<List<Subject>>() {
            @Override
            public void onNext(final List<Subject> o) {
                MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(o, mContext);
                view.setAdapter(adapter);
                adapter.setListener(new MyItemClickListener() {
                    @Override
                    public void onItemClick(View view, int postion) {
                        Intent i = new Intent(mContext, MovieDetailActivity.class);
                        i.putExtra("image", o.get(postion).getImages().getLarge());
                        i.putExtra("id", o.get(postion).getId());
                        i.putExtra("title", o.get(postion).getTitle());
                        mContext.startActivity(i);
                    }
                });
            }
        }, mContext), city, TargetUrl.API_KEY);
    }

//    public void getMovieComment(final RecyclerView view, String token){
//        Subscriber s = new Subscriber<List<Comment>>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(final List<Comment> o) {
//                CommentAdapter adapter = new CommentAdapter(mContext, o);
////                Log.i("title", o.get(0).getEssay_title());
//                view.setAdapter(adapter);
//                adapter.setOnItemClickListener(new MyItemClickListener() {
//                    @Override
//                    public void onItemClick(View view, int postion) {
//                        Intent i = new Intent(mContext, CommentDetailActivity.class);
//                        i.putExtra("id", o.get(postion).getId());
//                        i.putExtra("author_img", o.get(postion).getAuthor_image());
//                        i.putExtra("author_level", o.get(postion).getAuthor_level());
//                        i.putExtra("author_name", o.get(postion).getAuthor_name());
//                        i.putExtra("essay_content", o.get(postion).getEssay_content());
////                        Log.i("content", o.get(postion).getEssay_content());
//                        i.putExtra("essay_img", o.get(postion).getEssay_image());
//                        i.putExtra("essay_title", o.get(postion).getEssay_title());
//                        mContext.startActivity(i);
//                    }
//                });
//            }
//        };
//        new LoginRequest(mContext).getComment(s, token);
//    }

//    public void getLoginResult(final String aco, final String psd){
//
//        new LoginRequest(mContext).getLogin(new ProgressSubscriber(new SubscriberOnNextListener<PersonData>() {
//            @Override
//            public void onNext(PersonData o) {
////                if (o.getId().){
////                    MyToast.showMyToast(mContext, "登录失败，请确认账号密码");
//////                    Log.i("null", "false");
////                }else {
////                    MyToast.showMyToast(mContext, o.getId()+"");
//                    SharePreferenceUtils.setParam(mContext, "account", aco);
//                    SharePreferenceUtils.setParam(mContext, "password", psd);
//                    Intent i = new Intent(mContext, MainActivity.class);
//                    Bundle b = new Bundle();
////                    SharePreferenceUtils.setParam(mContext, "account", );
//                    b.putInt("id", o.getId());
//                    b.putString("nick", o.getNick());
//                    b.putString("img", o.getImage());
//                    i.putExtras(b);
//                    mContext.startActivity(i);
////                }
//            }
//        }, mContext), aco, psd);
//    }



    /**
     *搜索模块实现
     * @param recycler  搜索列表控件
     * @param s     搜索关键字
     */
    public void multiChoices(final RecyclerView recycler, final String s){
        ArrayList<String> list = new ArrayList<String>();
        list.add("搜索名字:"+s);
        list.add("搜索类型:"+s);
        adapter = new MultiChoicesAdapter(list);
        recycler.setAdapter(adapter);
        adapter.setmItemClickListener(new MyItemClickListener() {
            @Override
            public void onItemClick(View view, int postion) {
               if (postion == 0){
                   HttpMethods.getInstance().getResultByName(new ProgressSubscriber(new SubscriberOnNextListener<List<Subject>>() {
                       @Override
                       public void onNext(final List<Subject> o) {
                           MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(o, mContext);
                           recycler.setAdapter(adapter);
                           adapter.setListener(new MyItemClickListener() {
                               @Override
                               public void onItemClick(View view, int postion) {
                                   Intent i = new Intent(mContext, MovieDetailActivity.class);
                                   i.putExtra("image", o.get(postion).getImages().getLarge());
                                   i.putExtra("id", o.get(postion).getId());
                                   i.putExtra("title", o.get(postion).getTitle());
                                   mContext.startActivity(i);
                               }
                           });
                       }
                   }, mContext), s, 0, 10, TargetUrl.API_KEY);
               }else{
                   HttpMethods.getInstance().getResultByTag(new ProgressSubscriber(new SubscriberOnNextListener<List<Subject>>() {
                       @Override
                       public void onNext(final List<Subject> o) {
                           MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(o, mContext);
                           recycler.setAdapter(adapter);
                           adapter.setListener(new MyItemClickListener() {
                               @Override
                               public void onItemClick(View view, int postion) {
                                   Intent i = new Intent(mContext, MovieDetailActivity.class);
                                   i.putExtra("image", o.get(postion).getImages().getLarge());
                                   i.putExtra("id", o.get(postion).getId());
                                   i.putExtra("title", o.get(postion).getTitle());
                                   mContext.startActivity(i);
                               }
                           });
                       }
                   }, mContext), s, 0, 10, TargetUrl.API_KEY);
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
        HttpMethods.getInstance().getDetailMovie(new ProgressSubscriber(new SubscriberOnNextListener<Subject>() {
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

        HttpMethods.getInstance().getDetailMovie(new ProgressSubscriber(new SubscriberOnNextListener<Subject>() {
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




}
