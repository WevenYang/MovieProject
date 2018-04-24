package com.example.administrator.traveldiary.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;

/**
 * Created by Administrator on 2016/9/19 0019.
 */
public class BaseActivity extends AppCompatActivity {

    Toolbar toolbar;
    float startX, startY, endX, endY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(getWindow().FEATURE_NO_TITLE);
    }


    public void hideToolbar(){
        Animator animator = ObjectAnimator.ofFloat(toolbar, "translationY", toolbar.getTranslationY(), -toolbar.getHeight());
        animator.setDuration(300);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.setTarget(toolbar);
        animator.start();
    }

    public void showToolbar(){
        Animator animator = ObjectAnimator.ofFloat(toolbar, "translationY", toolbar.getTranslationY(), 0);
        animator.setDuration(300);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.setTarget(toolbar);
        animator.start();
    }
}
