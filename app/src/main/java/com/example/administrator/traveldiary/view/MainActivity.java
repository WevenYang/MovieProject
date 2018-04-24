package com.example.administrator.traveldiary.view;

import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.FeatureInfo;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.internal.NavigationMenuItemView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.traveldiary.R;
import com.example.administrator.traveldiary.adapter.MyRecyclerViewAdapter;
import com.example.administrator.traveldiary.adapter.MyViewPagerAdapter;
import com.example.administrator.traveldiary.util.GaodeMap;
import com.example.administrator.traveldiary.util.MyToast;
import com.example.administrator.traveldiary.util.SharePreferenceUtils;
import com.example.administrator.traveldiary.view.BaseActivity;
import com.jaeger.library.StatusBarUtil;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener{

    Toolbar toolbar;
    DrawerLayout drawer;
    RecyclerView recycler;
    TabLayout mTablayout;
    ViewPager mViewPager;

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
        initTab();

    }

    public void initAccount(){
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View HeaderView = navigationView.inflateHeaderView(R.layout.header_layout);
        TextView account = (TextView) HeaderView.findViewById(R.id.account);
        ImageView image = (ImageView) HeaderView.findViewById(R.id.head_iv);

    }



    public void initTab(){
        mTablayout = (TabLayout)findViewById(R.id.tab);
        mTablayout.addTab(mTablayout.newTab().setText("tab1"));
        mTablayout.addTab(mTablayout.newTab().setText("tab2"));
        mTablayout.addTab(mTablayout.newTab().setText("tab3"));
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(HotFragment.newInstance(), getResources().getString(R.string.hot));
        adapter.addFragment(LoadingFragment.newInstance(), getResources().getString(R.string.loading));
        adapter.addFragment(ClassicFragment.newInstance(), getResources().getString(R.string.classic));
        mViewPager.setAdapter(adapter);
        mTablayout.setupWithViewPager(mViewPager);
//        saveFragmentData(mTablayout);
    }

    public void initBase(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer);
        GaodeMap map = new GaodeMap(this);
        toolbar.setTitle("首页");
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.app_name, R.string.app_name);
        toggle.syncState();
        drawer.addDrawerListener(toggle);
        toolbar.inflateMenu(R.menu.toolbar_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_search:
                        startActivity(new Intent(MainActivity.this, SearchActivity.class));
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }

    public void saveFragmentData(TabLayout mTablayout){
        switch (mTablayout.getSelectedTabPosition()){
            case 0:

                mTablayout.getChildAt(1).setVisibility(View.GONE);
                mTablayout.getChildAt(2).setVisibility(View.GONE);
                break;
            case 1:
                mTablayout.getChildAt(1).setVisibility(View.VISIBLE);
                mTablayout.getChildAt(0).setVisibility(View.GONE);
                mTablayout.getChildAt(2).setVisibility(View.GONE);
                break;
            case 2:
                mTablayout.getChildAt(2).setVisibility(View.VISIBLE);
                mTablayout.getChildAt(0).setVisibility(View.GONE);
                mTablayout.getChildAt(1).setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.nav_home:
                break;
            case R.id.nav_nearby:
                Intent inten = new Intent(this, NearbyActivity.class);
                inten.putExtra("map", SharePreferenceUtils.getParam(this, "map", "广州").toString());
                startActivity(inten);
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



}
