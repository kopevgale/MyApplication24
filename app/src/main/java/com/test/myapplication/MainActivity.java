package com.test.myapplication;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import static com.test.myapplication.CallHandler.mApp;


class MainActivity extends AppCompatActivity {

    MediaPlayer mPlayer;
    Button startButton, pauseButton, stopButton;

    MainActivity() {
        super.onCreate(null);

        initPlayer();
    }

    void initPlayer() {
        mPlayer = MediaPlayer.create(this, R.raw.audio1);
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopPlay();
            }
        });
        startButton = (Button) findViewById(R.id.start);

        Log.i(String.valueOf(startButton), "btnstart new text: " + startButton.getText());

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
            Toast.makeText(mApp, t.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void play() {

        mPlayer.start();
        startButton.setEnabled(false);
        pauseButton.setEnabled(true);
        stopButton.setEnabled(true);
    }

    public void pause() {

        mPlayer.pause();
        startButton.setEnabled(true);
        pauseButton.setEnabled(false);
        stopButton.setEnabled(true);
    }

    public void stop() {
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


//public class MainActivity extends AppCompatActivity {
//
//    final String TAG = "PavelActivity";
//    String mSetData = "some const";
//    String mNumber = "23454568678";
//    // Intent intent = new Intent(Intent.ACTION_CALL);
//
//
////    this is call working block
//
//    Button btnCall;
//    private Bundle savedInstanceState;
//
//
//    //    this is end of call block
//    boolean textVisible = true;
//
//
//    // Конструктор приложения
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        btnCall = (Button) findViewById(R.id.btn);
//
//        // пример дебага
//        Log.i(TAG, "btnCall old text: " + btnCall.getText());
//        btnCall.setText("new btnCall text");
//        Log.i(TAG, "btnCall new text: " + btnCall.getText());
//
//
//        // Запускаем звонок
//        btnCall.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent;
//                switch (v.getId()) {
//
//                    case R.id.btn:
//                        intent = new Intent(Intent.ACTION_CALL);
//                        intent.setData(Uri.parse("tel:1234876587648347347376457855"));
//
//                        Context ctx = getApplicationContext();
//                        if (ActivityCompat.checkSelfPermission(ctx, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//                            Toast.makeText(ctx, "Don't have permissions to make a call.", Toast.LENGTH_LONG).show();
//                            return;
//                        }
//                        startActivity(intent);
//                        break;
//                }
//            }
//        });
//
//        // SET UP TOGGLE BUTTON
//        ToggleButton tb = (ToggleButton) findViewById(R.id.hideButton);
//
//        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                TextView tv = (TextView) findViewById(R.id.pavelText);
//                if (textVisible) {
//                    tv.setVisibility(View.INVISIBLE);
//                    textVisible = false; // text is not visible
//                } else {
//                    tv.setVisibility(View.VISIBLE);
//                    textVisible = true; // text is now visible
//
//
//                    Context context = getApplicationContext();
//                    Toast toast = Toast.makeText(context, "Looo message", Toast.LENGTH_LONG);
//                    toast.show();
//                }
//            }
//        });

//        // SET UP NORMAL BUTTON
//        Button b = (Button) findViewById(R.id.btn);
//        Log.i(TAG, "onCreate: " + b);
//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                TextView tv = (TextView) findViewById(R.id.pavelText);
//                tv.setText("Button clicked!");
//
//                Context context = getApplicationContext();
//                Toast toast = Toast.makeText(context, "Looo message", Toast.LENGTH_LONG);
//                toast.show();
//                // Log.i(TAG, "onClick (1): " + R.id.pavelText);
//                // Log.i(TAG, "onClick (2): " + R.id.btn);
//            }
//        });






