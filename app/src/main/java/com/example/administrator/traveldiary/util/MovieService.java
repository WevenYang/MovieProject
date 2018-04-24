package com.example.administrator.traveldiary.util;

import com.example.administrator.traveldiary.bean.Comment;
import com.example.administrator.traveldiary.bean.Data;
import com.example.administrator.traveldiary.bean.Discuss;
import com.example.administrator.traveldiary.bean.HttpResult;
import com.example.administrator.traveldiary.bean.PersonData;
import com.example.administrator.traveldiary.bean.ServerHttpMethod;
import com.example.administrator.traveldiary.bean.Subject;
import com.example.administrator.traveldiary.bean.TestJavaBean;

import java.util.List;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by liukun on 16/3/9.
 */
public interface MovieService {

//    @GET("top250")
//    Call<MovieEntity> getTopMovie(@Query("start") int start, @Query("count") int count);

//    @GET("top250")
//    Observable<MovieEntity> getTopMovie(@Query("start") int start, @Query("count") int count);

//    @GET("top250")
//    Observable<HttpResult<List<Subject>>> getTopMovie(@Query("start") int start, @Query("count") int count);

    @GET("top250")
    Observable<HttpResult<List<Subject>>> getTopMovie(@Query("start") int start, @Query("count") int count);
    @GET("in_theaters")
    Observable<HttpResult<List<Subject>>> getHotMovie(@Query("city") String city);
    @GET("coming_soon")
    Observable<HttpResult<List<Subject>>> getLoadingMovie(@Query("start") int start, @Query("count") int count);
    @FormUrlEncoded
    @POST("login")
    Observable<ServerHttpMethod<PersonData>> getLogin(@Field("account") String acc, @Field("password") String psd);
    @POST("register")
    Observable<ServerHttpMethod> getRegister(@Query("account") String num, @Query("password") String psd, @Query("nick") String nick);
    @GET("person")
    Observable<ServerHttpMethod<PersonData>> getPersonData(@Query("token") String token, @Query("id") int id);
    @GET("comment")
    Observable<ServerHttpMethod<List<Comment>>> getComment(@Query("token") String token);
    @GET("getPublic")
    Observable<ServerHttpMethod<List<Comment>>> getPublicComment(@Query("token") String token, @Query("name") String name);
    @GET("getClientComment")
    Observable<ServerHttpMethod> uploadComment(@Query("token") String token, @Query("author_name") String author_name,
                                               @Query("author_level") String author_level, @Query("author_image") String author_image,
                                                @Query("essay_title") String essay_title, @Query("essay_content") String essay_content,
                                               @Query("essay_image") String essay_image, @Query("time") String time);
    @GET("getMessage")
    Observable<ServerHttpMethod> sendMessage(@Query("token") String token, @Query("message") String msg, @Query("id") int id);
    @GET("search")
    Observable<HttpResult<List<Subject>>> getResultByName(@Query("q") String text, @Query("start") int start, @Query("count") int count);
    @GET("search")
    Observable<HttpResult<List<Subject>>> getResultByTag(@Query("tag") String tag, @Query("start") int start, @Query("count") int count);
    @GET("subject/{id}")
    Observable<Subject> getDetailMovie(@Path("id") String id);
    @POST("reset")
    Observable<ServerHttpMethod> resetPwd(@Query("id") int id, @Query("former") String former, @Query("now") String now);
    @GET("discuss")
    Observable<ServerHttpMethod<List<Discuss>>> getDiscuss(@Query("token") String token, @Query("id") int id);
    @GET("click_like")
    Observable<ServerHttpMethod> click_once(@Query("token") String token, @Query("id") int id, @Query("first") boolean first);
    @GET("sendDiscuss")
    Observable<ServerHttpMethod> sendDiscuss(@Query("token") String token, @Query("pid") int pid,
                                             @Query("name") String nick, @Query("image") String img,
                                             @Query("content") String content, @Query("time") String time);
}
