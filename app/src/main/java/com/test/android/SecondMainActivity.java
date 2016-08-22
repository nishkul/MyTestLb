package com.test.android;

import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.test.com.mytestlb.MySampleTest;
import android.view.View;
import android.widget.Button;

/**
 * Created by root on 11/8/16.
 */

public class SecondMainActivity extends AppCompatActivity {
    private int mAppWidgetId;
    private int color = 252;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ssecond_main_layout);

        // Gettng the reference to the "Set Color" button
        Button btnSetColor = (Button) findViewById(R.id.btn_set_color);

        // Defining a click event listener for the button "Set Color"
        View.OnClickListener setColorClickedListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                colorPicker();
            }
        };

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        if (extras != null) {
            mAppWidgetId = extras.getInt(
                    AppWidgetManager.EXTRA_APPWIDGET_ID,
                    AppWidgetManager.INVALID_APPWIDGET_ID);
        } else {
            // Making the "Set Color" button invisible when
            // the application is launched directly
            btnSetColor.setVisibility(View.INVISIBLE);
        }

        // Setting the click listener on the "Set Color" button
        btnSetColor.setOnClickListener(setColorClickedListener);
    }

    public void colorPicker() {
        //      initialColor is the initially-selected color to be shown in the rectangle on the left of the arrow.
        //      for example, 0xff000000 is black, 0xff0000ff is blue. Please be aware of the initial 0xff which is the alpha.
//
//        AlertDialog dialog = new AlertDialog(this, 0x440000ff, new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(getBaseContext());
//
//                // Instantiating the class RemoteViews with widget_layout
//                RemoteViews views = new RemoteViews(getBaseContext().getPackageName(), R.layout.widget_layout);
//
//                // Setting the background color of the widget
//                views.setInt(R.id.widget_aclock, "setBackgroundColor", color);
//
//                // Tell the AppWidgetManager to perform an update on the app widget
//                appWidgetManager.updateAppWidget(mAppWidgetId, views);
//            }

        // Executes, when user click Cancel button


        // Executes, when user click OK button

        // });
        //dialog.show();
    }
}
