package com.test.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.widget.Toast;

/**
 * Created by root on 11/8/16.
 */

public class AlarmReceiver extends BroadcastReceiver {
    private Vibrator vibrate;

    @Override
    public void onReceive(Context context, Intent intent) {
        // For our recurring task, we'll just display a message
        Toast.makeText(context, "I'm running", Toast.LENGTH_SHORT).show();
        vibrate = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrate.vibrate(2000);
    }
}
