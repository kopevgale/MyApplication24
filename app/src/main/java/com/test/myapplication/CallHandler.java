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


    // Ссылка на главное приложение.
    public static MainActivity mApp;

    // Вызови эту ф-цию в MainActivity::onCreate()
    public static void setActivity(MainActivity a) {
        mApp = a;
    }

    // Когда подняли трубку, запускается этот обработчик.
    @Override
    protected void onOutgoingCallStarted(Context ctx, String number, Date start) {
        super.onOutgoingCallStarted(ctx, number, start);
        Log.i(TAG, "outgoing call started");
        Toast toast = Toast.makeText(ctx, "Outgoing call started..", Toast.LENGTH_LONG);
        toast.show();
        // Здесь можешь запускать плеер. Эта ф-ция вызывается когда начинается звонок.

        if (mApp != null) {
            mApp.play();
        }

    }
}

