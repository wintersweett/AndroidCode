package com.havefun.shortcode;

import com.havefun.shortcode.widget.Movie;

public class RealMovie implements Movie {

    @Override
    public void play() {
        System.out.println("RealMovie 播放电影");
    }
}
