package com.example.administrator.traveldiary.view;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.administrator.traveldiary.R;

/**
 * Created by NewHT on 2016/11/17.
 */
public class MyData extends BaseActivity {

    EditText content2, content3, content4, content5;
    ImageView content1, content6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydata);

        //初始化部件
        initBase();
        toolbar.setNavigationIcon(R.mipmap.back_ib);
        toolbar.inflateMenu( R.menu.menu_edit);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        toolbar.setOnMenuItemClickListener(onMenuItemClick);
    }

    public void initBase(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        content2 = (EditText) findViewById(R.id.content2);
        content3 = (EditText) findViewById(R.id.content3);
        content4 = (EditText) findViewById(R.id.content4);
        content5 = (EditText) findViewById(R.id.content5);
        content1 = (ImageView) findViewById(R.id.content1);
        content6 = (ImageView) findViewById(R.id.content6);
    }

    //因为是在toolbar上的菜单，不是系统默认菜单，所以系统重写方法不奏效
    private Toolbar.OnMenuItemClickListener onMenuItemClick = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.edit:
                    if (menuItem.getTitle().equals("edit")){
                        menuItem.setIcon(getResources().getDrawable(R.mipmap.finish));
                        menuItem.setTitle("finish");
                        initWidget();
                    }else {
                        menuItem.setIcon(getResources().getDrawable(R.mipmap.edit));
                        menuItem.setTitle("edit");
                        dealWidget();
                    }
                    break;
                default:
                    break;
            }

            return true;
        }
    };

    public void initWidget(){
        content2.setEnabled(true);
        content3.setEnabled(true);
        content4.setEnabled(true);
        content5.setEnabled(true);
    }

    public void dealWidget(){
        content2.setEnabled(false);
        content3.setEnabled(false);
        content4.setEnabled(false);
        content5.setEnabled(false);
    }
}
