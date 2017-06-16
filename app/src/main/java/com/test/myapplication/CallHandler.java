package com.test.myapplication;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.Date;

/**
 * Created by ivan on 14.06.2017.
 */
public class CallHandler extends PhonecallReceiver {
    final String TAG = "CallHandler";

    MediaPlayer mPlayer;

    // Когда подняли трубку, запускается этот обработчик.
    @Override
    protected void onOutgoingCallStarted(Context ctx, String number, Date start) {
        super.onOutgoingCallStarted(ctx, number, start);
        Log.i(TAG, "outgoing call started");
        Toast toast = Toast.makeText(ctx, "Outgoing call started..", Toast.LENGTH_LONG);
        toast.show();
        // Здесь можешь запускать плеер. Эта ф-ция вызывается когда начинается звонок.
        initPlayer(ctx);
    }

    void initPlayer(Context ctx) {
        mPlayer = MediaPlayer.create(ctx, R.raw.audio1);
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopPlay();
            }
        });
        mPlayer.start();
    }

    private void stopPlay() {
        mPlayer.stop();
        //pauseButton.setEnabled(false);
        //stopButton.setEnabled(false);
        try {
            mPlayer.prepare();
            mPlayer.seekTo(0);
            //startButton.setEnabled(true);
        } catch (Throwable t) {
            /// Toast.makeText(ctx, t.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void play(View view) {

        mPlayer.start();
        //startButton.setEnabled(false);
        //pauseButton.setEnabled(true);
        //stopButton.setEnabled(true);
    }

    public void pause(View view) {

        mPlayer.pause();
        //startButton.setEnabled(true);
        //pauseButton.setEnabled(false);
        //stopButton.setEnabled(true);
    }

    public void stop(View view) {
        stopPlay();
    }

}

