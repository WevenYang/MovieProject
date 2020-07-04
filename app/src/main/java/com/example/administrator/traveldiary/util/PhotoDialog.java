package com.example.administrator.traveldiary.util;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.administrator.traveldiary.BuildConfig;
import com.example.administrator.traveldiary.R;
import com.example.administrator.traveldiary.util.MyToast;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/28 0028.
 */
public class PhotoDialog extends Dialog {

    ListView list;
    SimpleAdapter adapter;
    int[] icon = {R.mipmap.photo_one, R.mipmap.photo_two};
    String[] content = {"拍照", "本地照片"};
    List<Map<String, Object>> data;
    Activity mActivity;
    public static final String IMAGE_NAME = "file_public.png";
    public static final int TAKE_PHOTO_WITH_DATA = 1;
    public static final int GET_PHOTO_WITH_DATA = 2;    //打开图片标记

    public PhotoDialog(Activity mActivity) {
        super(mActivity);
        this.mActivity = mActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_dialog);
        list = (ListView) findViewById(R.id.listview);
        adapter = new SimpleAdapter(mActivity, getData(), R.layout.photo_dialog_item, new String[]{"icon", "content"}, new int[]{R.id.icon, R.id.icon_content});
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    if (hasSdcard()){
                        Uri photoOutputUri = FileProvider.getUriForFile(
                                getContext(),
                                BuildConfig.APPLICATION_ID + ".fileprovider",
                                new File(Environment.getExternalStorageDirectory(), IMAGE_NAME));
                        intent.putExtra(MediaStore.EXTRA_OUTPUT,
                                photoOutputUri);
                    }
                    mActivity.startActivityForResult(intent,TAKE_PHOTO_WITH_DATA);
                }else {
                    Intent intent = new Intent(Intent.ACTION_GET_CONTENT,
                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent.setType("image/*");
                    mActivity.startActivityForResult(intent,GET_PHOTO_WITH_DATA);
                }
                hide();
            }
        });
    }

    //判断是否有SDcard,是否可用
    public static boolean hasSdcard() {
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            return true;
        } else {
            return false;
        }
    }

    public List<Map<String, Object>> getData(){
        data = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < icon.length; i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("icon", icon[i]);
            map.put("content", content[i]);
            data.add(map);
        }
        return data;
    }


}
