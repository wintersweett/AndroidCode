package com.havefun.shortcode.util;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.IOException;
import java.lang.ref.WeakReference;

/***
 **************************
 *@Author WinterSweett
 *@Date 2021/7/12 21:42
 *@Description
 *
 **************************
 */
public class MediaPlayerUtil {
    private Context context;
    private MediaPlayer player;
    private PlayerListener listener;

    public MediaPlayerUtil(Context context) {
        this.context = context.getApplicationContext();
        player = new MediaPlayer();
        initListener();
    }



    public void play(String path) throws IOException {
        player.setDataSource(path);
        prepare();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void play(AssetFileDescriptor fd) throws IOException {
        player.setDataSource(fd);
        prepare();
    }

    public void pause(){

    }

    public void stop() {

    }

    private void initListener() {
        listener = new PlayerListener(this);
        player.setOnPreparedListener(listener);
        player.setOnCompletionListener(listener);
        player.setOnErrorListener(listener);

    }

    private void prepare() {
        player.prepareAsync();
    }

    private void complete() {

    }


    private static class PlayerListener implements MediaPlayer.OnPreparedListener,MediaPlayer.OnCompletionListener,MediaPlayer.OnErrorListener {
        private WeakReference<MediaPlayerUtil> ref;
        public PlayerListener(MediaPlayerUtil own) {
            ref = new WeakReference<>(own);
        }

        @Override
        public void onPrepared(MediaPlayer mediaPlayer) {
            mediaPlayer.start();
        }

        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {

        }

        @Override
        public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
            return false;
        }
    }
}
