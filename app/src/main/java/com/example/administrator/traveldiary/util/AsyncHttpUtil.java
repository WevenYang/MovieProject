package com.example.administrator.traveldiary.util;

import android.content.Context;
import android.util.Log;
import android.widget.ProgressBar;

import com.bumptech.glide.request.Request;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.io.File;

import cz.msebera.android.httpclient.Header;

/**
 * Created by NewHT on 2016/12/27.
 */
public class AsyncHttpUtil {
    Context mContext;
    ProgressBar progress;

    public AsyncHttpUtil(Context mContext) {
        this.mContext = mContext;
        progress = new ProgressBar(mContext);
    }

    public void upload(String url, File file) throws Exception{
//        File file = new File(essay_img);
        if (file.exists() && file.length() > 0){
            AsyncHttpClient client = new AsyncHttpClient();
            RequestParams params = new RequestParams();
            params.put("uploadfile", file);
//            params.put("");

            client.post(url, params, new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    MyToast.showMyToast(mContext, "发表成功"+responseBody.toString());
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                }

                @Override
                public void onProgress(long bytesWritten, long totalSize) {
                    super.onProgress(bytesWritten, totalSize);
                    int count = (int) ((bytesWritten * 1.0 / totalSize) * 100);
                    // 上传进度显示
                    progress.setProgress(count);
                    Log.e("上传 Progress>>>>>", bytesWritten + " / " + totalSize);
                }
            });
        }else {
            MyToast.showMyToast(mContext, "文件不存在");
        }
    }
}
