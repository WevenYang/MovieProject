package com.example.administrator.traveldiary.view;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.traveldiary.R;
import com.example.administrator.traveldiary.bean.LoginInfo;
import com.example.administrator.traveldiary.bean.PersonData;
import com.example.administrator.traveldiary.presenter.MyPresent;
import com.example.administrator.traveldiary.presenter.RecyclerViewPresent;
import com.example.administrator.traveldiary.subscribers.ProgressSubscriber;
import com.example.administrator.traveldiary.subscribers.SubscriberOnNextListener;
import com.example.administrator.traveldiary.util.LoginRequest;
import com.example.administrator.traveldiary.util.MyToast;
import com.example.administrator.traveldiary.util.SharePreferenceUtils;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    EditText aco, pwd;
    Button login;
    FloatingActionButton register;
    TextView text1;
    LinearLayout layout;
    Context mContext;
    //    ImageView qq_icon, wechat_icon;
    boolean CHANGE = true;
    int width, height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        WindowManager manager = (WindowManager)this.getSystemService(Context.WINDOW_SERVICE);
        width = manager.getDefaultDisplay().getWidth();
        height = manager.getDefaultDisplay().getHeight();
        init();
        layout.setMinimumWidth(width * 3 / 4);
//        aco.setWidth(width * 3 / 4);
//        pwd.setWidth(width * 3 / 4);
    }

    public void init(){
        mContext = this;
        layout = (LinearLayout) findViewById(R.id.linear1);
//        qq_icon = (ImageView) findViewById(R.id.qq_icon);
//        wechat_icon = (ImageView) findViewById(R.id.wechat_icon);
        register = (FloatingActionButton)findViewById(R.id.register);
        text1 = (TextView) findViewById(R.id.text1);
        aco = (EditText)findViewById(R.id.aco);
        aco.setText(SharePreferenceUtils.getParam(this, "account", "123").toString());
        pwd = (EditText)findViewById(R.id.pwd);
        pwd.setText(SharePreferenceUtils.getParam(this, "password", "123").toString());
        login = (Button)findViewById(R.id.login);
        login.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login:
                if (TextUtils.isEmpty(aco.getText().toString()) || TextUtils.isEmpty(pwd.getText().toString()) ) {
                    MyToast.showMyToast(LoginActivity.this, "请填写完整信息");
                }else {
                    LoginRequest.newInstance().getLogin(new ProgressSubscriber(new SubscriberOnNextListener<PersonData>() {
                        @Override
                        public void onNext(PersonData o) {
                            if (o.isSuccess()){
                                MyToast.showMyToast(mContext, o.getResult());
                                SharePreferenceUtils.setParam(mContext, "id", o.getData().get(0).getP_id());
                                SharePreferenceUtils.setParam(mContext, "name", o.getData().get(0).getNick_name());
                                startActivity(new Intent(mContext, MainActivity.class));
                                finish();
                            }else {
                                MyToast.showMyToast(mContext, o.getResult());
                            }
                        }
                    }, mContext), aco.getText().toString(), pwd.getText().toString());
                }
                break;
            case R.id.register:
                MyToast.showMyToast(this, getString(R.string.register));
                startActivity(new Intent(this, RegisterActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
//            case R.id.qq_icon:
//                getString(R.string.not_ready);
//                break;
//            case R.id.wechat_icon:
//                getString(R.string.not_ready);
//                break;
            default:
                break;
        }
    }

    public void turnToRegister(){
//        text1.setText(getString(R.string.register));
        CHANGE = false;
    }

    public void turnToPrevious(){
//        text1.setText(getString(R.string.login));
        CHANGE = true;
    }
}
