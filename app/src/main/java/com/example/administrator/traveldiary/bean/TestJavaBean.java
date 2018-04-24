package com.example.administrator.traveldiary.bean;

/**
 * Created by NewHT on 2016/11/27.
 */
public class TestJavaBean {
    private int code;
    private String token;
    private String result;
    private String data;

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TestJavaBean{" +
                "code=" + code +
                ", token='" + token + '\'' +
                ", result='" + result + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
