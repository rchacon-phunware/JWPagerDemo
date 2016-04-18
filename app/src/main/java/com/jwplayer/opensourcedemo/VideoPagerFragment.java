package com.jwplayer.opensourcedemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class VideoPagerFragment extends Fragment {
    public final static String TAG = VideoPagerFragment.class.getName();
    public final static String ARG_URLS = "ARG_URLS";

    private ViewPager mPager;

    public static VideoPagerFragment getInstance(ArrayList<String> urlsToPlay) {
        VideoPagerFragment fragment = new VideoPagerFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList(ARG_URLS, urlsToPlay);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video_pager, container, false);
        mPager = (ViewPager) view.findViewById(R.id.video_pager);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            ArrayList<String> urls = getArguments().getStringArrayList(ARG_URLS);

            CustomSwipeAdapter adapter = new CustomSwipeAdapter(getFragmentManager(), urls);
            mPager.setAdapter(adapter);
            mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//				WORK AROUND TO LIMIT PLAYBACK BUT DOESN'T OFFER THE STABILITY ONE WOULD WANT IN PRODUCTION
//				adapter.playerList.get(position).pause(true);
                }

                @Override
                public void onPageSelected(int position) {
//                    for (int i = 0; i < adapter.playerList.size(); i++) {
//                        JWPlayerView playerView = adapter.playerList.get(i);
//                        if (i != position) {
//                            if (playerView.getState() == PlayerState.PLAYING || playerView.getState() == PlayerState.BUFFERING) {
//                                Log.d("GEORGE", "PlayerState=" + playerView.getState().name());
//                                playerView.pause(true);
//                            }
//                        }
//                    }
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        }


    }
}
