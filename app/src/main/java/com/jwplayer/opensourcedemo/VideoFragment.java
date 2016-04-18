package com.jwplayer.opensourcedemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.longtailvideo.jwplayer.JWPlayerView;
import com.longtailvideo.jwplayer.media.playlists.PlaylistItem;

public class VideoFragment extends Fragment {
    public final static String TAG = VideoFragment.class.getName();
    public final static String ARG_URL = "ARG_URL";

    private JWPlayerView mPlayerView;

    public static VideoFragment getInstance(String url){
        VideoFragment fragment =  new VideoFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_URL, url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video, container, false);
        mPlayerView = (JWPlayerView) view.findViewById(R.id.video_player);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getArguments() != null){
            mPlayerView.load(new PlaylistItem(getArguments().getString(ARG_URL)));
        }
    }
}
