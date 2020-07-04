package com.example.administrator.traveldiary.bean;

public class LoginInfo {

    /**
     * code : 200
     * result : 登陆成功
     * data : 1
     * success : true
     */

    private int code;
    private String result;
    private String data;
    private boolean success;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
