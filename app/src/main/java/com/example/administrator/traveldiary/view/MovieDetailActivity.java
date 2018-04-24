package com.example.administrator.traveldiary.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.example.administrator.traveldiary.R;
import com.example.administrator.traveldiary.adapter.MyViewPagerAdapter;
import com.example.administrator.traveldiary.bean.MovieDetail;
import com.example.administrator.traveldiary.util.MyToast;
import com.jaeger.library.StatusBarUtil;

import jp.wasabeef.glide.transformations.BlurTransformation;

/**
 * Created by NewHT on 2016/10/8.
 */
public class MovieDetailActivity extends BaseActivity {

    AppBarLayout layout_app_bar;
    CollapsingToolbarLayout layout_collapsing;
    LinearLayout head_layout;
    CoordinatorLayout root_layout;
    TabLayout toolbar_tab;
    ViewPager main_viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //设置沉浸式状态栏（要去除xml文件的fitsSystemWindow属性）
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_movie);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            //取消状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        //初始化部件
        initBase();
//        toolbar.setPadding(0, getStatusBarHeight(this), 0, 0);
        toolbar.setNavigationIcon(R.mipmap.back_ib);
        toolbar.inflateMenu( R.menu.menu_movie);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        toolbar_tab.addTab(toolbar_tab.newTab().setText("tab1"));
        toolbar_tab.addTab(toolbar_tab.newTab().setText("tab2"));
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(IntroFragment.newInstance(), getString(R.string.introduce));
        adapter.addFragment(ActorFragment.newInstance(), getString(R.string.actor));
        main_viewpager.setAdapter(adapter);
        toolbar_tab.setupWithViewPager(main_viewpager);

        layout_app_bar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset <= -head_layout.getHeight() / 2){
                    layout_collapsing.setTitle(getIntent().getStringExtra("title"));
                }else {
                    layout_collapsing.setTitle("");
                }
            }
        });
//        layout_collapsing.setTitle("title");
        layout_collapsing.setCollapsedTitleTextColor(getResources().getColor(R.color.white));
        layout_collapsing.setContentScrimColor(getResources().getColor(R.color.colorPrimary));
        loadBlurAndSetStatusBar();
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.share:
                        Intent share = new Intent();
                        share.setAction(Intent.ACTION_SEND);
                        share.setType("text/plain");
                        share.putExtra(Intent.EXTRA_SUBJECT, "share");
                        share.putExtra(Intent.EXTRA_TEXT, "weven作品：电影信息分享页:"+getIntent().getStringExtra("link"));
                        share = Intent.createChooser(share, "分享");
                        startActivity(share);
                        break;
                }
                return true;
            }
        });
    }

    public void initBase(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar_tab = (TabLayout) findViewById(R.id.toolbar_tab);
        layout_app_bar = (AppBarLayout) findViewById(R.id.appbar);
        layout_collapsing = (CollapsingToolbarLayout) findViewById(R.id.collapsing);
        head_layout = (LinearLayout) findViewById(R.id.head_layout);
        root_layout = (CoordinatorLayout) findViewById(R.id.root_layout);
        main_viewpager = (ViewPager) findViewById(R.id.viewpager);

    }
    private void loadBlurAndSetStatusBar(){
        StatusBarUtil.setTranslucent(MovieDetailActivity.this, StatusBarUtil.DEFAULT_STATUS_BAR_ALPHA);
//        Glide.with(this).load("https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2380677316.jpg").bitmapTransform(new BlurTransformation(this, 1)).into(new SimpleTarget<GlideDrawable>() {
//            @Override
//            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
//                head_layout.setBackground(resource);
//            }
//        });
        Glide.with(this).load(getIntent().getStringExtra("image")).into(new SimpleTarget<GlideDrawable>() {
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                head_layout.setBackground(resource);
            }
        });
    }

    /**
     * 用于获取状态栏的高度。 使用Resource对象获取（推荐这种方式）
     *
     * @return 返回状态栏高度的像素值。
     */
    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen",
                "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
