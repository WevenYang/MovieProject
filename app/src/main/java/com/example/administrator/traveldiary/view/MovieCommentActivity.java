package com.example.administrator.traveldiary.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.traveldiary.R;
import com.example.administrator.traveldiary.adapter.CommonAdapter;
import com.example.administrator.traveldiary.adapter.ViewHolder;
import com.example.administrator.traveldiary.bean.LoginInfo;
import com.example.administrator.traveldiary.bean.PeopleCommentInfo;
import com.example.administrator.traveldiary.subscribers.ProgressSubscriber;
import com.example.administrator.traveldiary.subscribers.SubscriberOnNextListener;
import com.example.administrator.traveldiary.util.LoginRequest;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class MovieCommentActivity extends BaseActivity{

    private LinearLayout mTitleContainer;
    private TextView mTitle, title, author_level, essay_content;
    private AppBarLayout mAppBarLayout;
    private Toolbar mToolbar;
    private ImageView essay_img, author_img, discuss_icon;
    private RecyclerView discuss;
//    private RecyclerViewPresent present;
    public static boolean likeOrNot = false;

    private static final float PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR  = 0.9f;
    private static final float PERCENTAGE_TO_HIDE_TITLE_DETAILS     = 0.3f;
    private static final int ALPHA_ANIMATIONS_DURATION              = 200;

    private boolean mIsTheTitleVisible          = false;
    private boolean mIsTheTitleContainerVisible = true;
    private String id;
    private Bundle b;

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
        setContentView(R.layout.activity_comment_detail);

        initActivity();

//        mAppBarLayout.addOnOffsetChangedListener(this);

        mToolbar.inflateMenu(R.menu.menu_comment);
//        startAlphaAnimation(mTitle, 0, View.INVISIBLE);
        mToolbar.setNavigationIcon(R.mipmap.back_ib);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mTitle.setText(b.getString("title"));
        essay_content.setText(b.getString("content"));
//        author_level.setText(getIntent().getStringExtra("author_name"));
//        Glide.with(this).load(getIntent().getStringExtra("img")).into(essay_img);
//        Glide.with(this).load(getIntent().getStringExtra("pic")).into(author_img);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.like:
                        if (likeOrNot){
//                            present.clickForLike(SharePreferenceUtils.getParam(CommentDetailActivity.this, "token", "123").toString(),
//                                    getIntent().getIntExtra("id", 1), false);
                            item.setIcon(getResources().getDrawable(R.mipmap.like));
                            likeOrNot = false;
                        }else {
//                            present.clickForLike(SharePreferenceUtils.getParam(CommentDetailActivity.this, "token", "123").toString(),
//                                    getIntent().getIntExtra("id", 1), false);
                            item.setIcon(getResources().getDrawable(R.mipmap.like2));
                            likeOrNot = true;
                        }

                        break;
                }
                return true;
            }
        });
        //进行评论
        discuss_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MovieCommentActivity.this, EditDiscussActivity.class);
                in.putExtra("info_id", getIntent().getStringExtra("id"));
                startActivity(in);
            }
        });
//        present.getDiscuss(discuss, SharePreferenceUtils.getParam(this, "token", "123").toString(), getIntent().getIntExtra("id", 1));
        LoginRequest.newInstance().getPeopleComments(new ProgressSubscriber(new SubscriberOnNextListener<PeopleCommentInfo>() {
            @Override
            public void onNext(PeopleCommentInfo o) {
                //获取评论
                LinearLayoutManager manager = new LinearLayoutManager(MovieCommentActivity.this);
                discuss.setLayoutManager(manager);
                discuss.setAdapter(new CommonAdapter<PeopleCommentInfo.DataBean>(MovieCommentActivity.this, R.layout.item_comment, o.getData()) {
                    @Override
                    public void convert(ViewHolder holder, PeopleCommentInfo.DataBean o) {
                        ImageView image = (ImageView) holder.getView(R.id.image);
                        TextView name = (TextView) holder.getView(R.id.name);
                        TextView content = (TextView) holder.getView(R.id.content);
                        TextView date = (TextView) holder.getView(R.id.date);
                        name.setText(o.getNick_name());
                        content.setText(o.getComment());
                        date.setText(o.getC_date());
                        Glide.with(MovieCommentActivity.this).load(o.getPic()).bitmapTransform(new RoundedCornersTransformation(mContext, 15, 0)).into(image);
                    }

                });
            }
        }, MovieCommentActivity.this), id);
    }

    private void initActivity() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mTitle = (TextView) findViewById(R.id.main_textview_title);
        essay_content = (TextView) findViewById(R.id.essay_content);
//        author_level = (TextView) findViewById(R.id.author_level);
//        mTitleContainer = (LinearLayout) findViewById(R.id.main_linearlayout_title);
//        mAppBarLayout   = (AppBarLayout) findViewById(R.id.main_appbar);
//        essay_img = (ImageView)findViewById(R.id.main_imageview_placeholder);
//        author_img = (ImageView)findViewById(R.id.author_img);
        discuss = (RecyclerView) findViewById(R.id.discuss);
        discuss_icon = (ImageView) findViewById(R.id.icon3);
//        present = new RecyclerViewPresent(this);
        b = getIntent().getBundleExtra("Bundle");
        id = b.getString("id");
    }

//    @Override
//    public void onOffsetChanged(AppBarLayout appBarLayout, int offset) {
//        int maxScroll = appBarLayout.getTotalScrollRange();
//        float percentage = (float) Math.abs(offset) / (float) maxScroll;
//
//        handleAlphaOnTitle(percentage);
//        handleToolbarTitleVisibility(percentage);
//    }
//
//    private void handleToolbarTitleVisibility(float percentage) {
//        if (percentage >= PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR) {
//
//            if(!mIsTheTitleVisible) {
//                startAlphaAnimation(mTitle, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
//                mIsTheTitleVisible = true;
//            }
//
//        } else {
//
//            if (mIsTheTitleVisible) {
//                startAlphaAnimation(mTitle, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
//                mIsTheTitleVisible = false;
//            }
//        }
//    }
//
//    private void handleAlphaOnTitle(float percentage) {
//        if (percentage >= PERCENTAGE_TO_HIDE_TITLE_DETAILS) {
//            if(mIsTheTitleContainerVisible) {
//                startAlphaAnimation(mTitleContainer, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
//                mIsTheTitleContainerVisible = false;
//            }
//
//        } else {
//
//            if (!mIsTheTitleContainerVisible) {
//                startAlphaAnimation(mTitleContainer, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
//                mIsTheTitleContainerVisible = true;
//            }
//        }
//    }
//
//    public static void startAlphaAnimation (View v, long duration, int visibility) {
//        AlphaAnimation alphaAnimation = (visibility == View.VISIBLE)
//                ? new AlphaAnimation(0f, 1f)
//                : new AlphaAnimation(1f, 0f);
//
//        alphaAnimation.setDuration(duration);
//        alphaAnimation.setFillAfter(true);
//        v.startAnimation(alphaAnimation);
//    }
}
