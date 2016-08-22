package com.test.android;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.RemoteViews;

/**
 * Created by root on 11/8/16.
 */

public class AnalogClockWidget extends AppWidgetProvider {
    public AnalogClockWidget() {
        super();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        final int N = appWidgetIds.length;

        // Perform this loop procedure for each App Widget that belongs to this provider
        for (int i = 0; i < N; i++) {
            int appWidgetId = appWidgetIds[i];

            // Create an Intent to launch MainActivity
            Intent intent = new Intent(context, MainActivity.class);

            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);

            // This is needed to make this intent different from its previous intents
            intent.setData(Uri.parse("tel:/" + (int) System.currentTimeMillis()));

            // Creating a pending intent, which will be invoked when the user
            // clicks on the widget
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0,
                    intent, PendingIntent.FLAG_UPDATE_CURRENT);

            // Get the layout for the App Widget
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_layout);

            //  Attach an on-click listener to the clock
            views.setOnClickPendingIntent(R.id.widget_aclock, pendingIntent);

            // Tell the AppWidgetManager to perform an update on the current app widget
            appWidgetManager.updateAppWidget(appWidgetId, views);

        }
    }

    @Override
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int appWidgetId, Bundle newOptions) {
        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions);
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
    }

    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
    }

    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
    }

    @Override
    public void onRestored(Context context, int[] oldWidgetIds, int[] newWidgetIds) {
        super.onRestored(context, oldWidgetIds, newWidgetIds);
    }
}
