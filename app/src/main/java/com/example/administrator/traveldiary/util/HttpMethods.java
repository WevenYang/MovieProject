package com.example.administrator.traveldiary.util;

import com.example.administrator.traveldiary.bean.HttpResult;
import com.example.administrator.traveldiary.bean.ServerHttpMethod;
import com.example.administrator.traveldiary.bean.Subject;
import com.example.administrator.traveldiary.config.TargetUrl;


import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by liukun on 16/3/9.
 */
public class HttpMethods {

    private static final int DEFAULT_TIMEOUT = 5;

    private Retrofit retrofit;
    private MovieService movieService;

    //构造方法私有
    private HttpMethods() {
        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(TargetUrl.DOUBAN_BASE_URL)
                .build();

        movieService = retrofit.create(MovieService.class);
    }

    //在访问HttpMethods时创建单例
//    private static class SingletonHolder{
//        private static final HttpMethods INSTANCE = new HttpMethods();
//    }

    //获取单例
    public static HttpMethods getInstance(){
//        return SingletonHolder.INSTANCE;
        return new HttpMethods();
    }

    /**
     * 用于获取豆瓣电影Top250的数据
     * @param subscriber  由调用者传过来的观察者对象
     * @param start 起始位置
     * @param count 获取长度
     */
    public void getTopMovie(Subscriber<List<Subject>> subscriber, int start, int count){

//        movieService.getTopMovie(start, count)
//                .map(new HttpResultFunc<List<Subject>>())
//                .subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(subscriber);

        Observable observable = movieService.getTopMovie(start, count)
                .map(new HttpResultFunc<List<Subject>>());

        toSubscribe(observable, subscriber);
    }

    /**
     * 获取豆瓣热映电影
     * @param subscriber    由调用者传过来的观察者对象
     * @param city  城市
     */
    public void getHotMovie(Subscriber<List<Subject>> subscriber, String city){
        Observable observable = movieService.getHotMovie(city)
                .map(new HttpResultFunc<List<Subject>>());
        toSubscribe(observable, subscriber);
    }

    /**
     * 获取待映电影
     * @param subscriber    由调用者传过来的观察者对象
     * @param start     起始位置
     * @param count     获取长度
     */
    public void getLoadingMovie(Subscriber<List<Subject>> subscriber, int start, int count){
        Observable observable = movieService.getLoadingMovie(start, count)
                .map(new HttpResultFunc<List<Subject>>());
        toSubscribe(observable, subscriber);
    }

    /**
     * 通过名字获取搜索结果
     * @param subscriber        由调用者传过来的观察者对象
     * @param name      搜索名字
     * @param start     起始位置
     * @param count     获取长度
     */
    public void getResultByName(Subscriber<List<Subject>> subscriber, String name, int start, int count){
        Observable observable = movieService.getResultByName(name, start, count).map(new HttpResultFunc<List<Subject>>());
        toSubscribe(observable, subscriber);
    }


    /**
     * 通过类型获取搜索结果
     * @param subscriber        由调用者传过来的观察者对象
     * @param tag       搜索名字
     * @param start     起始位置
     * @param count     获取长度
     */
    public void getResultByTag(Subscriber<List<Subject>> subscriber, String tag, int start, int count){
        Observable observable = movieService.getResultByTag(tag, start, count).map(new HttpResultFunc<List<Subject>>());
        toSubscribe(observable, subscriber);
    }

    /**
     * @param subscriber        由调用者传过来的观察者对象
     * @param id         电影id
     */
    public void getDetailMovie(Subscriber<Subject> subscriber, String id){
        Observable observable = movieService.getDetailMovie(id);
        toSubscribe(observable, subscriber);
    }

    private <T> void toSubscribe(Observable<T> o, Subscriber<T> s){
         o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }

    /**
     * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
     *
     * @param <T>   Subscriber真正需要的数据类型，也就是Data部分的数据类型
     */
    private class HttpResultFunc<T> implements Func1<HttpResult<T>, T>{

        @Override
        public T call(HttpResult<T> httpResult) {
            if (httpResult.getCount() == 0) {
                throw new ApiException(100);
            }
            return httpResult.getSubjects();
        }
    }


}
