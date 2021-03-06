package com.example.administrator.traveldiary.util;


import android.content.Context;
import android.util.Log;

import com.example.administrator.traveldiary.bean.Comment;
import com.example.administrator.traveldiary.bean.Data;
import com.example.administrator.traveldiary.bean.HttpResult;
import com.example.administrator.traveldiary.bean.MovieDetail;
import com.example.administrator.traveldiary.bean.PersonData;
import com.example.administrator.traveldiary.bean.ServerHttpMethod;
import com.example.administrator.traveldiary.bean.TestJavaBean;
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
 * Created by Administrator on 2016/10/28 0028.
 */
public class LoginRequest {

    private static final int DEFAULT_TIMEOUT = 5;

    private Retrofit retrofit;
    Context mContext;
    private MovieService movieService;

    public LoginRequest(Context mContext){
        this.mContext = mContext;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

//        retrofit = new Retrofit.Builder().client(builder.build())
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .baseUrl(TargetUrl.LOGIN_URL)
//                .build();
//
//        movieService = retrofit.create(MovieService.class);
    }

//    public static LoginRequest newInstance() {
//        return new LoginRequest();
//    }

    public void getLogin(Subscriber<PersonData> subscriber, String acc, String psd){
//        movieService.getLogin(acc, psd).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
        Observable observable = movieService.getLogin(acc, psd).map(new ServerHttpMethodFunc<PersonData>());
        toSubscribe(observable, subscriber);
    }

    /**
     * 获取数据库中的影评圈评论
     * @param subscriber    由调用者传过来的观察者对象
     * @param id     起始位置
     */
    public void getComment(Subscriber<List<Comment>> subscriber, String id){
        Observable observable = movieService.getComment(id).map(new ServerHttpMethodFunc<List<Comment>>());
        toSubscribe(observable, subscriber);
//        movieService.getComment(id).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
    }

    /**
     * 注册请求接口
     * @param subscriber    由调用者传过来的观察者对象
     * @param aco   昵称
     * @param psd   密码
     * @param num   手机号码
     */
    public void getRegister(Subscriber<ServerHttpMethod> subscriber, String num, String psd, String aco){
//        Observable observable = movieService.getRegister(aco, psd, num).map(new ServerHttpMethodFunc<PersonData>());
        movieService.getRegister(num, psd, aco).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        toSubscribe(observable, subscriber);
    }

    public void uploadComment(Subscriber<ServerHttpMethod> subscriber, String token, String author_name,
                              String author_level, String author_image, String essay_title,
                              String essay_content, String essay_image, String time){
        movieService.uploadComment(token, author_name, author_level, author_image, essay_title, essay_content, essay_image, time).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
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
    private class ServerHttpMethodFunc<T> implements Func1<ServerHttpMethod<T>, T> {

        @Override
        public T call(ServerHttpMethod<T> httpResult) {
            if (httpResult.getCode() == 202) {
                throw new ApiException(202);
            }else if (httpResult.getCode() == 201){
                throw new ApiException(201);
            }else {
//                SharePreferenceUtils.setParam(mContext, "token", httpResult.getToken());
                Log.i("token", httpResult.getCode()+"");
                return httpResult.getData();
            }
        }
    }
}
