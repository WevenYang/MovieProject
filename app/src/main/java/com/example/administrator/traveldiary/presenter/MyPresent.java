package com.example.administrator.traveldiary.presenter;

import com.example.administrator.traveldiary.view.IView;
/**
 * Created by Administrator on 2016/8/22 0022.
 */
public class MyPresent {
    IView view;

    public MyPresent(IView view) {
        this.view = view;
    }

    public void load(){
        view.requestForData();
    }
}
