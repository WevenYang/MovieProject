package com.example.administrator.traveldiary.view;

import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.traveldiary.R;
import com.example.administrator.traveldiary.presenter.RecyclerViewPresent;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener{

    Toolbar toolbar;
    DrawerLayout drawer;
    RecyclerView recycler;
    TabLayout mTablayout;
    ViewPager mViewPager;
    RecyclerViewPresent present;
    SwipeRefreshLayout mSwipeRefresh;
    FloatingActionButton floatingBtn;       //悬浮按钮
    boolean floatingBtnOpened = false;      //判断按钮是否运行中
    View mask;
    int startIndex = 0;
    int count = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        StatusBarUtil.setTranslucent(MainActivity.this, StatusBarUtil.DEFAULT_STATUS_BAR_ALPHA);
//        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT){
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        }
        initBase();     //初始化基本控件，包括标题栏和侧栏
        initAccount();      //设置侧栏头像区
    }

    public void initAccount(){
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View HeaderView = navigationView.inflateHeaderView(R.layout.header_layout);
        TextView account = (TextView) HeaderView.findViewById(R.id.account);
        ImageView image = (ImageView) HeaderView.findViewById(R.id.head_iv);

    }

    public void initBase(){
        mask = (View) findViewById(R.id.mask);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer);
        recycler = (RecyclerView) findViewById(R.id.recycler);
        mSwipeRefresh = (SwipeRefreshLayout) findViewById(R.id.refresh);
        present = new RecyclerViewPresent(this);
        toolbar.setTitle("首页");
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.app_name, R.string.app_name);
        toggle.syncState();
        drawer.addDrawerListener(toggle);
//        present.getHotMovie(recycler, startIndex, count);
        //设置悬浮按钮
        floatingBtn = (FloatingActionButton) findViewById(R.id.floating);
        floatingBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
//                if(!floatingBtnOpened){
//                    openMenu(view);
//                }else{
//                    closeMenu(view);
//                }
                Intent i = new Intent(MainActivity.this, WriteActivity.class);
                i.putExtra("nick", getIntent().getStringExtra("nick"));
                i.putExtra("img", getIntent().getStringExtra("img"));
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
//        toolbar.inflateMenu(R.menu.toolbar_menu);
//        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                switch (item.getItemId()){
//                    case R.id.action_search:
////                        startActivity(new Intent(MainActivity.this, SearchActivity.class));
////                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
//                        break;
//                    default:
//                        break;
//                }
//                return true;
//            }
//        });
        mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSwipeRefresh.setRefreshing(false);
                present.getMovieComment(recycler, "1");
            }
        });
        present.getMovieComment(recycler, "1");
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.nav_home:
                break;
            case R.id.nav_hot:
                Intent intent = new Intent(this, CommonActivity.class);
                intent.putExtra("type", "0");
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.nav_loading:
                Intent inten = new Intent(this, CommonActivity.class);
                inten.putExtra("type", "1");
                startActivity(inten);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.nav_best:
                Intent in = new Intent(this, CommonActivity.class);
                in.putExtra("type", "2");
                startActivity(in);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.nav_setting:
                Intent inte = new Intent(this, Setting.class);
                inte.putExtra("id", getIntent().getIntExtra("id", 1));
                startActivity(inte);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.nav_loginout:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.setMessage("确定退出吗");
                builder.show();
                break;
            default:
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //打开悬浮按钮
    public void openMenu(View view){
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "rotation", 0, -155, -135);
        animator.setDuration(500);
        animator.start();
        mask.setVisibility(View.VISIBLE);
        AlphaAnimation alpha = new AlphaAnimation(0, 0.7f);
        alpha.setDuration(500);
        alpha.setFillAfter(true);
        mask.startAnimation(alpha);
        floatingBtnOpened = true;
    }

    //关闭悬浮按钮
    public void closeMenu(View view){
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "rotation", -135, 20, 0);
        animator.setDuration(500);
        animator.start();
        mask.setVisibility(View.INVISIBLE);
        AlphaAnimation alpha = new AlphaAnimation(0.7f, 0);
        alpha.setDuration(500);
        alpha.setFillAfter(true);
        mask.startAnimation(alpha);
        floatingBtnOpened = false;
    }

}
