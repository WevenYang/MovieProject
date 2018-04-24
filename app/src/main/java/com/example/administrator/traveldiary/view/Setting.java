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

/**
 * Created by Administrator on 2016/9/22 0022.
 */
public class Setting extends Activity implements View.OnClickListener {

    Toolbar toolbar;
    TextView content1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        init();
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
        content1.setOnClickListener(this);
        toolbar.setNavigationIcon(R.mipmap.back_ib);
        toolbar.setTitle(R.string.setting);
        toolbar.setTitleTextColor(Color.WHITE);
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
