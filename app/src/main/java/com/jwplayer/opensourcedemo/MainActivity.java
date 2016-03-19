package com.jwplayer.opensourcedemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.longtailvideo.jwplayer.JWPlayerView;
import com.longtailvideo.jwplayer.core.PlayerState;
import com.longtailvideo.jwplayer.media.playlists.PlaylistItem;

import java.util.ArrayList;

public class MainActivity extends Activity {

    ViewPager viewPager;
    CustomSwipeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.view_pager);

        ArrayList<PlaylistItem> playlist = new ArrayList<>();
        playlist.add(new PlaylistItem("http://content.jwplatform.com/manifests/PxnoM5gE.m3u8"));
        playlist.add(new PlaylistItem("http://content.jwplatform.com/manifests/nJEIV3eJ.m3u8"));
        playlist.add(new PlaylistItem("http://content.jwplatform.com/manifests/s1BX6sJr.m3u8"));
        playlist.add(new PlaylistItem("http://content.jwplatform.com/manifests/X6p4tzJO.m3u8"));


        adapter = new CustomSwipeAdapter(this, playlist);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//				WORK AROUND TO LIMIT PLAYBACK BUT DOESN'T OFFER THE STABILITY ONE WOULD WANT IN PRODUCTION
//				adapter.playerList.get(position).pause(true);
            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < adapter.playerList.size(); i++) {
                    JWPlayerView playerView = adapter.playerList.get(i);
                    if (i != position) {
                        if (playerView.getState() == PlayerState.PLAYING || playerView.getState() == PlayerState.BUFFERING) {
                            Log.d("GEORGE","PlayerState="+playerView.getState().name());
                            playerView.pause(true);
                        }
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }


    @Override
    protected void onResume() {
        // Let JW Player know that the app has returned from the background
        adapter.onResume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        // Let JW Player know that the app is going to the background
        adapter.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        // Let JW Player know that the app is being destroyed
        adapter.onDestroy();
        super.onDestroy();
    }


}
