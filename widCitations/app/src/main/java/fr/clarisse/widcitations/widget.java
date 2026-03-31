package fr.clarisse.widcitations;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.widget.RemoteViews;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.PendingIntent;
import android.content.Intent;

public class widget extends AppWidgetProvider{
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

        for (int appWidgetId : appWidgetIds) {
            updateWidget(context, appWidgetManager, appWidgetId);
        }
    }

    public static void updateWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {

        SharedPreferences prefs = context.getSharedPreferences("widget_prefs", Context.MODE_PRIVATE);
        String bgColor=prefs.getString("bg_color" + appWidgetId, "#9C27B0");
        String titleColor = prefs.getString("title_color" + appWidgetId, "#000000");
        String textColor = prefs.getString("text_color" + appWidgetId, "#000000");

        // On pointe vers le layout XML
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_app);

        views.setInt(R.id.widget_layout, "setBackgroundColor", Color.parseColor(bgColor));
        views.setTextColor(R.id.widget_title, Color.parseColor(titleColor));
        views.setTextColor(R.id.widget_text, Color.parseColor(textColor));

        Intent configIntent = new Intent(context, ConfigActivity.class);
        configIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
        configIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                context, appWidgetId, configIntent,
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
        );
        views.setOnClickPendingIntent(R.id.widget_layout, pendingIntent);

        RetrofitClient.getService().getCitations().enqueue(new Callback<List<Citation>>() {
            @Override
            public void onResponse(Call<List<Citation>> call, Response<List<Citation>> response) {
                if (response.isSuccessful() && response.body() != null && !response.body().isEmpty()) {
                    Citation citation = response.body().get(0);
                    views.setTextViewText(R.id.widget_title, citation.getTexte());
                    views.setTextViewText(R.id.widget_text, citation.getAuteur());
                } else {
                    views.setTextViewText(R.id.widget_title, "Aucune citation");
                    views.setTextViewText(R.id.widget_text, "Ajoute des citations");
                }
                appWidgetManager.updateAppWidget(appWidgetId, views);
            }

            // On modifie les textes via les IDs du XML


            @Override
            public void onFailure(Call<List<Citation>> call, Throwable t) {
                views.setTextViewText(R.id.widget_title, "Erreur");
                views.setTextViewText(R.id.widget_text, "Impossible de contacter le serveur");
                appWidgetManager.updateAppWidget(appWidgetId, views);
            }
        });


    }
}






