package com.test.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    final String TAG = "PavelActivity";
    String mSetData = "some const";
    String mNumber = "23454568678";
    // Intent intent = new Intent(Intent.ACTION_CALL);


    boolean textVisible = true;


    com.test.myapplication.PhonecallReceiver mRec = new PhonecallReceiver() {
        @Override
        protected void onOutgoingCallStarted(Context ctx, String number, Date start) {
            super.onOutgoingCallStarted(ctx, number, start);
            Log.i(TAG, "outgoing call started");
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(ctx, "Looo message", Toast.LENGTH_LONG);
            toast.show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSetData = "prolly right";


        // SET UP TOGGLE BUTTON
        ToggleButton tb = (ToggleButton) findViewById(R.id.hideButton);

        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                TextView tv = (TextView) findViewById(R.id.pavelText);
                if (textVisible) {
                    tv.setVisibility(View.INVISIBLE);
                    textVisible = false; // text is not visible
                } else {
                    tv.setVisibility(View.VISIBLE);
                    textVisible = true; // text is now visible


                    Context context = getApplicationContext();
                    Toast toast = Toast.makeText(context, "Looo message", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        // SET UP NORMAL BUTTON
        Button b = (Button) findViewById(R.id.btn);
        Log.i(TAG, "onCreate: " + b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = (TextView) findViewById(R.id.pavelText);
                tv.setText("Button clicked!");

                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, "Looo message", Toast.LENGTH_LONG);
                toast.show();
                // Log.i(TAG, "onClick (1): " + R.id.pavelText);
                // Log.i(TAG, "onClick (2): " + R.id.btn);
            }
        });


    }
}
