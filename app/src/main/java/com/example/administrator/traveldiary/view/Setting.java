package com.example.administrator.traveldiary.view;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Notification;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.traveldiary.R;
import com.example.administrator.traveldiary.adapter.SettingRecyclerViewAdapter;
import com.example.administrator.traveldiary.bean.Comment;
import com.example.administrator.traveldiary.bean.PersonData;
import com.example.administrator.traveldiary.subscribers.ProgressSubscriber;
import com.example.administrator.traveldiary.subscribers.SubscriberOnNextListener;
import com.example.administrator.traveldiary.util.LoginRequest;
import com.example.administrator.traveldiary.util.SharePreferenceUtils;

import java.util.List;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
public class Setting extends Activity implements View.OnClickListener {

    Toolbar toolbar;
    TextView content1, personal_name, personal_phone, personal_intro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        init();
        initData();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    public void init(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        content1 = (TextView) findViewById(R.id.content1);
        personal_name = (TextView) findViewById(R.id.personal_name);
        personal_phone = (TextView) findViewById(R.id.personal_phone);
        personal_intro = (TextView) findViewById(R.id.personal_intro);
        content1.setOnClickListener(this);
        toolbar.setNavigationIcon(R.mipmap.back_ib);
        toolbar.setTitle(R.string.setting);
        toolbar.setTitleTextColor(Color.WHITE);
    }

    public void initData(){
        LoginRequest.newInstance().getPersonInfo(new ProgressSubscriber(new SubscriberOnNextListener<PersonData>() {
            @Override
            public void onNext(PersonData o) {
                personal_name.setText(o.getData().get(0).getNick_name());
                personal_phone.setText(o.getData().get(0).getCell_phone());
                personal_intro.setText(o.getData().get(0).getIntroduce());
            }
        }, Setting.this), SharePreferenceUtils.getParam(this, "id", "1").toString());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.content1:
                Intent i = new Intent(this, MessageActivity.class);
                i.putExtra("id", getIntent().getIntExtra("id", 1));
                startActivity(i);
                break;
            default:
                break;
        }
    }
}
