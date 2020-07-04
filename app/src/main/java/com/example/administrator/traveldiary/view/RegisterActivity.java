package com.example.administrator.traveldiary.view;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.administrator.traveldiary.R;
import com.example.administrator.traveldiary.bean.LoginInfo;
import com.example.administrator.traveldiary.bean.ServerHttpMethod;
import com.example.administrator.traveldiary.presenter.RecyclerViewPresent;
import com.example.administrator.traveldiary.subscribers.ProgressSubscriber;
import com.example.administrator.traveldiary.subscribers.SubscriberOnNextListener;
import com.example.administrator.traveldiary.util.BmobMessage;
import com.example.administrator.traveldiary.util.LoginRequest;
import com.example.administrator.traveldiary.util.MyToast;
import com.example.administrator.traveldiary.util.SharePreferenceUtils;

import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;

public class RegisterActivity extends BaseActivity {

    int width, height;
    EditText aco, psd, sure, nick, code;
    Button send, register;
    FloatingActionButton back;
    LinearLayout layout;
    RecyclerViewPresent present;
    BmobMessage bmob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final WindowManager manager = (WindowManager)this.getSystemService(Context.WINDOW_SERVICE);
        width = manager.getDefaultDisplay().getWidth();
        height = manager.getDefaultDisplay().getHeight();
        init();
        layout.setMinimumWidth(width * 3 / 4);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(nick.getText()) || TextUtils.isEmpty(psd.getText()) || TextUtils.isEmpty(aco.getText())) {
                    MyToast.showMyToast(RegisterActivity.this, "请把注册信息填写完整");
                } else {
//                    bmob.requestSMS();
//                    bmob.vertify(RegisterActivity.this, num.getText().toString(),
//                            psd.getText().toString(), aco.getText().toString());
//                    present.getRegisterResult(RegisterActivity.this, num.getText().toString(),
//                            psd.getText().toString(), aco.getText().toString());
//                    LoginRequest.newInstance().getRegister();
                    LoginRequest.newInstance().getRegister(new ProgressSubscriber(new SubscriberOnNextListener<LoginInfo>() {
                        @Override
                        public void onNext(LoginInfo o) {
                            if (o.isSuccess()){
                                MyToast.showMyToast(RegisterActivity.this, o.getResult());
                                SharePreferenceUtils.setParam(RegisterActivity.this, "id", o.getData());
                                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                                finish();
                            }else {
                                MyToast.showMyToast(RegisterActivity.this, o.getResult());
                            }
                        }
                    }, RegisterActivity.this), aco.getText().toString(), psd.getText().toString(), nick.getText().toString());
                }
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(aco.getText().toString()) && aco.getText().toString().trim().length() == 11){
                    BmobSMS.requestSMSCode(aco.getText().toString(), "电影信息共享系统", new QueryListener<Integer>() {
                        @Override
                        public void done(Integer smsId, BmobException e) {
                            if (e == null) {
                                MyToast.showMyToast(RegisterActivity.this, "发送验证码成功");
                            } else {
                                MyToast.showMyToast(RegisterActivity.this, "发送验证码失败：" + e.getErrorCode() + "-" + e.getMessage() + "\n");
                            }
                        }
                    });
                    CountTime();
                }else {
                    MyToast.showMyToast(RegisterActivity.this, "请填写好手机号码");
                }

            }
        });

    }

    public void CountTime(){
        CountDownTimer timer = new CountDownTimer(60000, 1) {
            @Override
            public void onTick(long l) {
                send.setEnabled(false);
                send.setText("剩余" + l/1000 + "秒");
            }

            @Override
            public void onFinish() {
                send.setEnabled(true);
                send.setText("重新获取验证码");
            }
        };
        timer.start();
    }

    public void init(){
        layout = (LinearLayout) findViewById(R.id.linear1);
        aco = (EditText) findViewById(R.id.account);
        psd = (EditText) findViewById(R.id.password);
        sure = (EditText) findViewById(R.id.sure);
        nick = (EditText) findViewById(R.id.nick);
        code = (EditText) findViewById(R.id.code);
        send = (Button) findViewById(R.id.send);
        back = (FloatingActionButton) findViewById(R.id.back);
        register = (Button) findViewById(R.id.register);
        present = new RecyclerViewPresent(this);
//        bmob = new BmobMessage(this, code, num.getText().toString());
    }
}
