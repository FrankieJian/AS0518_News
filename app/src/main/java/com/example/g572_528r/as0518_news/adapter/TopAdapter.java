package com.example.g572_528r.as0518_news.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by g572-528r on 2017/6/1.
 */
public class TopAdapter extends FragmentPagerAdapter{
    private List<Fragment> topFragmentList;

    public TopAdapter(FragmentManager fm, List<Fragment> topFragmentList) {
        super(fm);
        this.topFragmentList = topFragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return topFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return topFragmentList.size();
    }
}
