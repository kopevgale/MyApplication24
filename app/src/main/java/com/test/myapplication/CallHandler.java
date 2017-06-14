package com.test.myapplication;

import android.content.Context;
import android.util.Log;
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
    }
}
