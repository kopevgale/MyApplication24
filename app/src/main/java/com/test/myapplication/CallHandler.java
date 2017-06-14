package com.test.myapplication;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Date;

/**
 * Created by ivan on 14.06.2017.
 */
public class CallHandler extends PhonecallReceiver {
    final String TAG = "CallHandler";

    // Когда подняли трубку, запускается этот обработчик.
    @Override
    protected void onOutgoingCallStarted(Context ctx, String number, Date start) {
        super.onOutgoingCallStarted(ctx, number, start);
        Log.i(TAG, "outgoing call started");
        Toast toast = Toast.makeText(ctx, "Outgoing call started..", Toast.LENGTH_LONG);
        toast.show();
        // Здесь можешь запускать плеер. Эта ф-ция вызывается когда начинается звонок.

        class MainActivity extends AppCompatActivity {

            MediaPlayer mPlayer;
            Button startButton, pauseButton, stopButton;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                mPlayer = MediaPlayer.create(this, R.raw.audio1);
                mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        stopPlay();
                    }
                });
                startButton = (Button) findViewById(R.id.start);
                pauseButton = (Button) findViewById(R.id.pause);
                stopButton = (Button) findViewById(R.id.stop);

                pauseButton.setEnabled(false);
                stopButton.setEnabled(false);
            }

            private void stopPlay() {
                mPlayer.stop();
                pauseButton.setEnabled(false);
                stopButton.setEnabled(false);
                try {
                    mPlayer.prepare();
                    mPlayer.seekTo(0);
                    startButton.setEnabled(true);
                } catch (Throwable t) {
                    Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            public void play(View view) {

                mPlayer.start();
                startButton.setEnabled(false);
                pauseButton.setEnabled(true);
                stopButton.setEnabled(true);
            }

            public void pause(View view) {

                mPlayer.pause();
                startButton.setEnabled(true);
                pauseButton.setEnabled(false);
                stopButton.setEnabled(true);
            }

            public void stop(View view) {
                stopPlay();
            }

            @Override
            public void onDestroy() {
                super.onDestroy();
                if (mPlayer.isPlaying()) {
                    stopPlay();
                }
            }
        }







    }
}
