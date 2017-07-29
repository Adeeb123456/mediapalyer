package com.gameofthrones100.telltalegames.season7.gameofthrones.mediaplayer;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements MediaPlayer.OnPreparedListener,SurfaceHolder.Callback {
    private SurfaceView mSurfaceView;
    private MediaPlayer mMediaPlayer;
    private SurfaceHolder mSurfaceHolder;
    private static final String VIDEO_PATH = "https://inducesmile.com/wp-content/uploads/2016/05/small.mp4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSurfaceView=(SurfaceView)findViewById(R.id.surface_view);

        mSurfaceHolder=mSurfaceView.getHolder();
        mSurfaceHolder.addCallback(MainActivity.this);


    }

    @Override
    public void onPrepared(MediaPlayer mp) {
mMediaPlayer.start();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
mMediaPlayer=new MediaPlayer();
        mMediaPlayer.setDisplay(mSurfaceHolder);

        try{
            mMediaPlayer.setDataSource(VIDEO_PATH);
            mMediaPlayer.prepare();
            mMediaPlayer.setOnPreparedListener(this);
            mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        }catch (IOException e){
e.printStackTrace();
        }


    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
