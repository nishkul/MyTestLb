package com.test.android;

import android.app.PendingIntent;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViews;

import java.util.Random;

/**
 * Created by root on 10/8/16.
 */

public class UpdateWidgetService extends Service {


    private static final String LOG = "de.vogella.android.widget.example";
    int wid;
    private AppWidgetManager appWidgetManager;
    private RemoteViews remoteViews;

    @Override
    public void onStart(Intent intent, int startId) {
        appWidgetManager = AppWidgetManager.getInstance(this
                .getApplicationContext());

        int[] allWidgetIds = intent
                .getIntArrayExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS);

//                ComponentName thisWidget = new ComponentName(getApplicationContext(),
//                                MyWidgetProvider.class);
//                int[] allWidgetIds2 = appWidgetManager.getAppWidgetIds(thisWidget);

        for (int widgetId : allWidgetIds) {
            // create some random data
            int number = (new Random().nextInt(100));

            remoteViews = new RemoteViews(this
                    .getApplicationContext().getPackageName(),
                    R.layout.widget_layout);
            Log.w("WidgetExample", String.valueOf(number));
            // Set the text
            remoteViews.setTextViewText(R.id.update,
                    "Random: " + String.valueOf(number));

            // Register an onClickListener
            Intent clickIntent = new Intent(this.getApplicationContext(),
                    MainActivity.class);

            clickIntent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            clickIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS,
                    allWidgetIds);

            PendingIntent pendingIntent = PendingIntent.getBroadcast(
                    getApplicationContext(), 0, clickIntent,
                    PendingIntent.FLAG_UPDATE_CURRENT);
            remoteViews.setOnClickPendingIntent(R.id.update, pendingIntent);
            wid = widgetId;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    appWidgetManager.updateAppWidget(wid, remoteViews);
                }
            }, 1000);


            //AppWidgetManager.getInstance( getContext() ).updateAppWidget( widgetId, remoteViews );
        }
        stopSelf();

        super.onStart(intent, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
