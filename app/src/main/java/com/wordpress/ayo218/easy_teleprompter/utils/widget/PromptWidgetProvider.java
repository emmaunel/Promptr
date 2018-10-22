package com.wordpress.ayo218.easy_teleprompter.utils.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.wordpress.ayo218.easy_teleprompter.R;
import com.wordpress.ayo218.easy_teleprompter.ui.activities.MainActivity;

/**
 * Implementation of App Widget functionality.
 */
public class PromptWidgetProvider extends AppWidgetProvider {

    private void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId){
//        Intent intent = new Intent(context, WidgetService.class);
//        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetIds[appWidgetId]);
//        intent.setData(Uri.parse(intent.toUri(Intent.URI_INTENT_SCHEME)));

//        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.prompt_widget);
//        remoteViews.setRemoteAdapter(appWidgetIds[appWidgetId], R.id.script_widget_list, intent);
//        remoteViews.setEmptyView(R.id.script_widget_list, R.id.script_widget_txt);
//
//        Intent toastIntent = new Intent(context, PromptWidgetProvider.class);
//        toastIntent.setAction(TOAST_ACTION);
//        toastIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetIds[appWidgetId]);
//        intent.setData(Uri.parse(intent.toUri(Intent.URI_INTENT_SCHEME)));
//        PendingIntent toastPendingIntent = PendingIntent.getBroadcast(context, 0, toastIntent,
//                PendingIntent.FLAG_UPDATE_CURRENT);
//        remoteViews.setPendingIntentTemplate(R.id.script_widget_list, toastPendingIntent);
//
//        appWidgetManager.updateAppWidget(appWidgetIds[appWidgetId], remoteViews);

        PendingIntent intent = PendingIntent.getActivity(context, 0, new Intent(context, MainActivity.class), 0);
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.prompt_widget);
        views.setOnClickPendingIntent(R.id.script_widget_txt, intent);

        Intent intent1 = new Intent(context, WidgetService.class);
        intent1.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);

        views.setRemoteAdapter(R.id.script_widget_list, intent1);
        appWidgetManager.updateAppWidget(appWidgetId, views);
        appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetId, R.id.script_widget_list);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created

    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }



//    @Override
//    public void onReceive(Context context, Intent intent) {
//        AppWidgetManager mgr = AppWidgetManager.getInstance(context);
//        if (intent.getAction().equals(TOAST_ACTION)) {
//            int appWidgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,
//                    AppWidgetManager.INVALID_APPWIDGET_ID);
//            int viewIndex = intent.getIntExtra(EXTRA_ITEM, 0);
//            Toast.makeText(context, "Touched view " + viewIndex, Toast.LENGTH_SHORT).show();
//        }
//        super.onReceive(context, intent);
//    }
}
