package com.example.administrator.traveldiary.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.administrator.traveldiary.R;
import com.example.administrator.traveldiary.presenter.RecyclerViewPresent;
import com.example.administrator.traveldiary.util.MyToast;
import com.example.administrator.traveldiary.util.SharePreferenceUtils;
import com.example.administrator.traveldiary.util.TimeUtil;

import org.jsoup.Connection;

/**
 * Created by Administrator on 2016/12/13 0013.
 */
public class MessageActivity extends BaseActivity {

    EditText msg;
    RecyclerViewPresent present;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message);
        initBase();
        toolbar.setNavigationIcon(R.mipmap.back_ib);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    public void initBase(){
        msg = (EditText) findViewById(R.id.msg);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu_msg);
        toolbar.setOnMenuItemClickListener(listener);
        present = new RecyclerViewPresent(this);
    }

    private Toolbar.OnMenuItemClickListener listener = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()){
                case R.id.finish:
                    if (TextUtils.isEmpty(msg.getText())){
                        MyToast.showMyToast(MessageActivity.this, "不可空白留言");
//                        Log.i("tag", "empty");
                    }else {
//                        present.sendMessage(MessageActivity.this, SharePreferenceUtils.getParam(MessageActivity.this, "token", "123").toString(),
//                                msg.getText().toString(), getIntent().getIntExtra("id", 1));
                    }
                    break;
                default:
                    break;
            }
            return true;
        }
    };


}
