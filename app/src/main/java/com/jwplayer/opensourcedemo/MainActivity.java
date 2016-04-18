package com.jwplayer.opensourcedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            ArrayList<String> urlsToPlay = new ArrayList<>();
            urlsToPlay.add("http://hls.video.lamusica.com/el-listado-030316_1457391487484/resources/example.m3u8?tlm=hls&streams=el-listado-030316_1457391487484_500.mp4.m3u8:500,el-listado-030316_1457391487484_750.mp4.m3u8:750,el-listado-030316_1457391487484_1200.mp4.m3u8:1200,el-listado-030316_1457391487484_2500.mp4.m3u8:2500");
            urlsToPlay.add("http://hls.video.lamusica.com/come-miercoles-con-pili_1457122770956/resources/example.m3u8?tlm=hls&streams=come-miercoles-con-pili_1457122770956_500.mp4.m3u8:500,come-miercoles-con-pili_1457122770956_750.mp4.m3u8:750,come-miercoles-con-pili_1457122770956_1200.mp4.m3u8:1200,come-miercoles-con-pili_1457122770956_2500.mp4.m3u8:2500");
            urlsToPlay.add("http://hls.video.lamusica.com/vertical-test-musinotas-1080x1920-h264_1456335298944/resources/example.m3u8?tlm=hls&streams=vertical-test-musinotas-1080x1920-h264_1456335298944_750.mp4.m3u8:750,vertical-test-musinotas-1080x1920-h264_1456335298944_2500.mp4.m3u8:2500,vertical-test-musinotas-1080x1920-h264_1456335298944_500.mp4.m3u8:500,vertical-test-musinotas-1080x1920-h264_1456335298944_1200.mp4.m3u8:1200");
            urlsToPlay.add("http://hls.video.lamusica.com/tres-notas-de-la-man--ana-con-andre--s-meji--a_1457118232054/resources/example.m3u8?tlm=hls&streams=tres-notas-de-la-man--ana-con-andre--s-meji--a_1457118232054_750.mp4.m3u8:750,tres-notas-de-la-man--ana-con-andre--s-meji--a_1457118232054_2500.mp4.m3u8:2500,tres-notas-de-la-man--ana-con-andre--s-meji--a_1457118232054_500.mp4.m3u8:500,tres-notas-de-la-man--ana-con-andre--s-meji--a_1457118232054_1200.mp4.m3u8:1200");

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.video_pager_container, VideoPagerFragment.getInstance(urlsToPlay), VideoPagerFragment.TAG)
                    .commit();
        }
    }
}
