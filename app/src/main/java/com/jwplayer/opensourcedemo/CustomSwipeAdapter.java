package com.jwplayer.opensourcedemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class CustomSwipeAdapter extends FragmentPagerAdapter {

    ArrayList<String> mVideoUrls;

    public CustomSwipeAdapter(FragmentManager fm, ArrayList<String> playlist) {
        super(fm);
        this.mVideoUrls = playlist;
    }

    @Override
    public int getCount() {
        return mVideoUrls.size();
    }


    @Override
    public Fragment getItem(int position) {
        return VideoFragment.getInstance(mVideoUrls.get(position));
    }
}