package com.slkk.flywithdream;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by dell on 2017/2/20.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {
    private ZhihuFragment zhihuFragment;
    private GuokrFragment guokrFragment;
    private DoubanFragment doubanFragment;
    private String[] titles;

    public MainPagerAdapter(FragmentManager fm, Context context, ZhihuFragment zhihuFragment,
                            GuokrFragment guokrFragment, DoubanFragment doubanFragment) {
        super(fm);
        this.zhihuFragment = zhihuFragment;
        this.guokrFragment = guokrFragment;
        this.doubanFragment = doubanFragment;

        titles = new String[]{"知乎", "果壳", "豆瓣"};

    }


    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return zhihuFragment;
        } else if (position == 1) {
            return guokrFragment;
        }
        return doubanFragment;

    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return titles[position];
    }
}
