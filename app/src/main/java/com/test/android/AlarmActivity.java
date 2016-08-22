package com.test.android;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by root on 11/8/16.
 */

public class AlarmActivity extends AppCompatActivity {
    private PendingIntent pendingIntent;
    private Vibrator vibrator;
    private Vibrator vibrate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_layout);

        /* Retrieve a PendingIntent that will perform a broadcast */
        Intent alarmIntent = new Intent(AlarmActivity.this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(AlarmActivity.this, 0, alarmIntent, 0);

        findViewById(R.id.startAlarm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start();
            }
        });

        findViewById(R.id.stopAlarm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });

        findViewById(R.id.stopAlarmAt10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAt10();
            }
        });
    }

    private void start() {
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        int interval = 8000;

        vibrate = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
        vibrate.vibrate(2000);
        manager.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), interval, pendingIntent);
        Toast.makeText(this, "Alarm Set", Toast.LENGTH_SHORT).show();
    }

    private void cancel() {
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        manager.cancel(pendingIntent);
        Toast.makeText(this, "Alarm Canceled", Toast.LENGTH_SHORT).show();
    }

    private void startAt10() {
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        int interval = 1000 * 60 * 20;
        vibrate = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
        vibrate.vibrate(2000);
        /* Set the alarm to start at 10:30 AM */
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 10);
        calendar.set(Calendar.MINUTE, 30);

        /* Repeating on every 20 minutes interval */
        manager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                1000 * 60 * 20, pendingIntent);
    }
}
