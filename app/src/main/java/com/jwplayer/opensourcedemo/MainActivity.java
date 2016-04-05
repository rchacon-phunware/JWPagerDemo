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
        playlist.add(new PlaylistItem("http://hls.video.lamusica.com/el-listado-030316_1457391487484/resources/example.m3u8?tlm=hls&streams=el-listado-030316_1457391487484_500.mp4.m3u8:500,el-listado-030316_1457391487484_750.mp4.m3u8:750,el-listado-030316_1457391487484_1200.mp4.m3u8:1200,el-listado-030316_1457391487484_2500.mp4.m3u8:2500"));
        playlist.add(new PlaylistItem("http://hls.video.lamusica.com/come-miercoles-con-pili_1457122770956/resources/example.m3u8?tlm=hls&streams=come-miercoles-con-pili_1457122770956_500.mp4.m3u8:500,come-miercoles-con-pili_1457122770956_750.mp4.m3u8:750,come-miercoles-con-pili_1457122770956_1200.mp4.m3u8:1200,come-miercoles-con-pili_1457122770956_2500.mp4.m3u8:2500"));
        playlist.add(new PlaylistItem("http://hls.video.lamusica.com/vertical-test-musinotas-1080x1920-h264_1456335298944/resources/example.m3u8?tlm=hls&streams=vertical-test-musinotas-1080x1920-h264_1456335298944_750.mp4.m3u8:750,vertical-test-musinotas-1080x1920-h264_1456335298944_2500.mp4.m3u8:2500,vertical-test-musinotas-1080x1920-h264_1456335298944_500.mp4.m3u8:500,vertical-test-musinotas-1080x1920-h264_1456335298944_1200.mp4.m3u8:1200"));
        playlist.add(new PlaylistItem("http://hls.video.lamusica.com/tres-notas-de-la-man--ana-con-andre--s-meji--a_1457118232054/resources/example.m3u8?tlm=hls&streams=tres-notas-de-la-man--ana-con-andre--s-meji--a_1457118232054_750.mp4.m3u8:750,tres-notas-de-la-man--ana-con-andre--s-meji--a_1457118232054_2500.mp4.m3u8:2500,tres-notas-de-la-man--ana-con-andre--s-meji--a_1457118232054_500.mp4.m3u8:500,tres-notas-de-la-man--ana-con-andre--s-meji--a_1457118232054_1200.mp4.m3u8:1200"));


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
