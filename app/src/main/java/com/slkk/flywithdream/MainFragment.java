package com.slkk.flywithdream;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by dell on 2017/2/20.
 */

public class MainFragment extends Fragment {
    private ZhihuFragment zhihuFragment;
    private DoubanFragment doubanFragment;
    private GuokrFragment guokrFragment;
    private TabLayout tablayout;
    private ViewPager viewpager;
    private Context context;


    public MainFragment() {
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = getActivity();

        if (savedInstanceState != null) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            zhihuFragment = (ZhihuFragment) childFragmentManager.getFragment(savedInstanceState, "zhihu");
            guokrFragment = (GuokrFragment) childFragmentManager.getFragment(savedInstanceState, "guokr");
            doubanFragment = (DoubanFragment) childFragmentManager.getFragment(savedInstanceState, "douban");
        } else {
            zhihuFragment = ZhihuFragment.newInstance();
            guokrFragment = GuokrFragment.newInstance();
            doubanFragment = DoubanFragment.newInstance();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mainFragment = inflater.inflate(R.layout.main_fragmnt_layout, container, false);

        initView(mainFragment);
        setHasOptionsMenu(true);

        return mainFragment;
    }

    private void initView(View view) {
        tablayout = (TabLayout) view.findViewById(R.id.tab_layout);
        viewpager = (ViewPager) view.findViewById(R.id.view_pager);
        viewpager.setOffscreenPageLimit(3);

        MainPagerAdapter mainPagerAdapter = new MainPagerAdapter(getChildFragmentManager(), context,
                zhihuFragment, guokrFragment, doubanFragment);
        viewpager.setAdapter(mainPagerAdapter);
        tablayout.setupWithViewPager(viewpager);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        FragmentManager childFragmentManager = getChildFragmentManager();
        childFragmentManager.putFragment(outState, "zhihu", zhihuFragment);
        childFragmentManager.putFragment(outState, "guokr", guokrFragment);
        childFragmentManager.putFragment(outState, "douban", doubanFragment);

    }
}
