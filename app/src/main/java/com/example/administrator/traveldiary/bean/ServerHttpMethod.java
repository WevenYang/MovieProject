package com.example.administrator.traveldiary.bean;

/**
 * Created by NewHT on 2016/11/16.
 */
public class ServerHttpMethod<T> {
    private int code;
    private String token;
    private String result;  private T data;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
