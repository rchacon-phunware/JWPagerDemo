package com.jwplayer.opensourcedemo;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.longtailvideo.jwplayer.JWPlayerView;
import com.longtailvideo.jwplayer.media.playlists.PlaylistItem;

import java.util.ArrayList;

/**
 * Created by gsyrimis on 1/25/16.
 */
public class CustomSwipeAdapter extends PagerAdapter {

    ArrayList<JWPlayerView> playerList;
    Context context;
    LayoutInflater layoutInflater;
    ArrayList<PlaylistItem> mediaList;

    public CustomSwipeAdapter(Context context, ArrayList<PlaylistItem> playlist) {
        this.context = context;
        this.mediaList = playlist;
        playerList = new ArrayList<>();
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        Log.d("GEORGE", "GetCount");
        return mediaList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        Log.d("GEORGE", "IsViewFromObject");
        return (view == (LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // Add linear layout that will serve as a container for the player
        Log.d("GEORGE", "InstantiateItem");
        View itemView = layoutInflater.inflate(R.layout.swipe_layout, container, false);
        JWPlayerView player = (JWPlayerView) itemView.findViewById(R.id.jwplayer);
        playerList.add(player);
        container.addView(itemView);
        player.load(mediaList.get(position));
        return itemView;
    }

    @Override
    public void finishUpdate(ViewGroup container) {
        super.finishUpdate(container);
        Log.d("GEORGE", "FinishUpdate");
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        Log.d("GEORGE","DestroyItem");
        LinearLayout jwPlayerContainer = (LinearLayout) object;
        JWPlayerView player = (JWPlayerView) jwPlayerContainer.findViewById(R.id.jwplayer);

        if (player != null) {
            player.onDestroy();
            jwPlayerContainer.removeView(player);
            player = null;
        }
        container.removeView(jwPlayerContainer);

    }


    public void onPause() {
        for (JWPlayerView currentView : playerList) {
            currentView.onPause();
        }
    }

    public void onResume() {
        for (JWPlayerView currentView : playerList) {
            currentView.onResume();
        }
    }

    public void onDestroy() {
        for (JWPlayerView currentView : playerList) {
            currentView.onDestroy();
        }
    }

}
