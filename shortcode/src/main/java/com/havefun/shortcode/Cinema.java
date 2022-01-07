package com.havefun.shortcode;

import com.havefun.shortcode.widget.Movie;

public class Cinema implements Movie {
    private Movie movie;
    public Cinema(Movie movie) {
        this.movie = movie;
    }
    @Override
    public void play() {
        doFirst();
        movie.play();
        doLast();
    }

    private void doFirst() {
        System.out.println(" 广告");
    }

    private void doLast() {
        System.out.println(" 彩蛋");
    }
}
