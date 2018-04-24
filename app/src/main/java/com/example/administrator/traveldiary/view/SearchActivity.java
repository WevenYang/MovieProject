package com.example.administrator.traveldiary.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.traveldiary.R;
import com.example.administrator.traveldiary.presenter.RecyclerViewPresent;
import com.example.administrator.traveldiary.util.MyToast;

/**
 * Created by Administrator on 2016/9/28 0028.
 */
public class SearchActivity extends BaseActivity implements SearchView.OnQueryTextListener{

    Toolbar toolbar;
    SearchView searchMenu;
    LinearLayoutManager manager;
    RecyclerView recyclerView;
    RecyclerViewPresent present;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initBase();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void initBase(){
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        present = new RecyclerViewPresent(this);
        toolbar.setNavigationIcon(R.mipmap.back_ib);
        toolbar.setTitle("搜索页面");
        toolbar.inflateMenu(R.menu.search_menu);
//        searchMenu.setFocusable(true);
//        searchMenu.setQueryHint(getResources().getString(R.string.input));
        searchMenu = (SearchView) findViewById(R.id.menu_search);
        searchMenu.setQueryHint(getResources().getString(R.string.input));
        searchMenu.setFocusable(true);
//        searchMenu.requestFocusFromTouch();
        searchMenu.setOnQueryTextListener(this);
        manager = new LinearLayoutManager(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        MyToast.showMyToast(this, "请选择下拉框的选项");
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (newText.equals("") || newText == null){
            recyclerView.setVisibility(View.INVISIBLE);
        }else{
            recyclerView.setVisibility(View.VISIBLE);
            recyclerView.setLayoutManager(manager);
            present.multiChoices(recyclerView, newText);
        }

        return true;
    }
}
