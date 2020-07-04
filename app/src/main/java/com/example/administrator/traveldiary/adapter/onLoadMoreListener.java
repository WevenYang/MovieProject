package com.example.administrator.traveldiary.adapter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import static android.support.v7.widget.RecyclerView.SCROLL_STATE_DRAGGING;
import static android.support.v7.widget.RecyclerView.SCROLL_STATE_SETTLING;

public abstract class onLoadMoreListener extends RecyclerView.OnScrollListener {
    private int countItem;
    private int lastItem;
    private boolean isScrolled = false;
    private RecyclerView.LayoutManager layoutManager;

    /**
     * 加载回调方法
     * @param countItem 总数量
     * @param lastItem  最后显示的position
     */
    protected abstract void onLoading(int countItem, int lastItem);

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        if (newState == SCROLL_STATE_DRAGGING || newState == SCROLL_STATE_SETTLING){
            isScrolled = true;
        }else {
            isScrolled = false;
        }
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager){
            layoutManager = recyclerView.getLayoutManager();
            countItem = layoutManager.getItemCount();
            lastItem = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
        }
        if (isScrolled && countItem != lastItem && lastItem == countItem - 1){
            onLoading(countItem, lastItem);
        }
    }
}
