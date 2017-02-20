package com.slkk.flywithdream;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by dell on 2017/2/20.
 */

public class ZhihuFragment extends Fragment {

    private SwipeRefreshLayout refreshLayout;
    private RecyclerView resyclerView;

    public ZhihuFragment() {

    }

    public static ZhihuFragment newInstance() {
        return new ZhihuFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.zhihu_fragment_layout, container, false);
        initView(view);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });
        return view;
    }

    private void initView(View view) {

        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refreshLayout);
        refreshLayout.setColorSchemeResources(R.color.colorPrimary);

        resyclerView = (RecyclerView) view.findViewById(R.id.resyclerView);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        resyclerView.setHasFixedSize(true);
        resyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void loadPost(long date, boolean clearing) {

    }

}
