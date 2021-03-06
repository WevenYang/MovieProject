package com.example.administrator.traveldiary.util;

/**
 * Created by liukun on 16/3/10.
 */
public class ApiException extends RuntimeException {

    public static final int USER_NOT_EXIST = 100;
    public static final int WRONG_PASSWORD = 101;
    public static final int LOGIN_WRONG_FAILD = 202;
    public static final int REGISTER_REPEATE = 201;

    public ApiException(int resultCode) {
        this(getApiExceptionMessage(resultCode));
    }

    public ApiException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * 由于服务器传递过来的错误信息直接给用户看的话，用户未必能够理解
     * 需要根据错误码对错误信息进行一个转换，在显示给用户
     * @param code
     * @return
     */
    private static String getApiExceptionMessage(int code){
        String message = "";
        switch (code) {
            case USER_NOT_EXIST:
                message = "该用户不存在";
                break;
            case WRONG_PASSWORD:
                message = "密码错误";
                break;
            case LOGIN_WRONG_FAILD:
                message = "登陆失败，请确认账号密码";
                break;
            case REGISTER_REPEATE:
                message = "该账户名已存在";
            default:
                message = "未知错误";

        }
        return message;
    }
}

