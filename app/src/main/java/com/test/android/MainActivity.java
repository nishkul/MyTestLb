package com.test.android;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppWidgetProvider {

    private int number;

    public MainActivity() {
        super();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
//automatically upading ui
        Log.w("aaaa", "onUpdate method called");
        // Get all ids
        ComponentName thisWidget = new ComponentName(context,
                MainActivity.class);
        int[] allWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget);

        // Build the intent to call the service
        Intent intent = new Intent(context.getApplicationContext(),
                UpdateWidgetService.class);
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, allWidgetIds);

        // Update the widgets via the service
        context.startService(intent);

//        ComponentName thisWidget = new ComponentName( getContext(), <ProviderClass> );
//        AppWidgetManager.getInstance( getContext() ).updateAppWidget( thisWidget, rempoteViews );

//        ComponentName thisWidget = new ComponentName(context,
//                MainActivity.class);
//        int[] allWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget);
//        for (int widgetId : allWidgetIds) {
//            // create some random data
//            number = (new Random().nextInt(100));
//            RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
//                    R.layout.widget_layout);
//            Log.w("WidgetExample", String.valueOf(number));
//            // Set the text
//            remoteViews.setTextViewText(R.id.update, String.valueOf(number));
//
//            // Register an onClickListener
//            Intent intent = new Intent(context, MainActivity.class);
//
//            intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
//            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);
//
//            PendingIntent pendingIntent = PendingIntent.getBroadcast(context,
//                    0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//            //remoteViews.setOnClickPendingIntent(R.id.update, pendingIntent);
//            appWidgetManager.updateAppWidget(widgetId, remoteViews);
//        }
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
