package com.example.administrator.traveldiary.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.administrator.traveldiary.R;
import com.example.administrator.traveldiary.bean.LoginInfo;
import com.example.administrator.traveldiary.subscribers.ProgressSubscriber;
import com.example.administrator.traveldiary.subscribers.SubscriberOnNextListener;
import com.example.administrator.traveldiary.util.LoginRequest;
import com.example.administrator.traveldiary.util.MyToast;
import com.example.administrator.traveldiary.util.SharePreferenceUtils;

public class EditDiscussActivity extends BaseActivity {

    EditText text;
    ImageView send;
//    RecyclerViewPresent present;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_discuss);
        Window window=getWindow();
        WindowManager.LayoutParams wl = window.getAttributes();
        wl.flags=WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
        //这句就是设置窗口里控件的透明度的．０.０全透明．１.０不透明．
        wl.alpha=0.6f;
        window.setAttributes(wl);
        text = (EditText) findViewById(R.id.edit);
        send = (ImageView) findViewById(R.id.send);
//        present = new RecyclerViewPresent(this);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(text.getText().toString())){
                    MyToast.showMyToast(EditDiscussActivity.this, "评价不可为空");
                }else {
//                    present.sendDiscuss(EditDiscuss.this, SharePreferenceUtils.getParam(EditDiscuss.this, "token", "").toString(), getIntent().getIntExtra("pid", 1),
//                            getIntent().getStringExtra("name"), getIntent().getStringExtra("image"), text.getText().toString(), TimeUtil.newInstance().getTime());
                    LoginRequest.newInstance().submitMovieComments(new ProgressSubscriber(new SubscriberOnNextListener<LoginInfo>() {
                        @Override
                        public void onNext(LoginInfo o) {
                            MyToast.showMyToast(EditDiscussActivity.this, o.getData());
                            if (o.isSuccess()){
                                finish();
                            }
                        }
                    }, EditDiscussActivity.this), SharePreferenceUtils.getParam(EditDiscussActivity.this, "id", "1").toString(),
                            getIntent().getStringExtra("info_id"), text.getText().toString());
                }
            }
        });
    }
}
