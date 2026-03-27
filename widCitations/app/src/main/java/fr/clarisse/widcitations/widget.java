package fr.clarisse.widcitations;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

public class widget extends AppWidgetProvider{
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

        // Pour chaque instance du widget sur l'écran d'accueil
        for (int appWidgetId : appWidgetIds) {

            // On pointe vers le layout XML
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_app);

            // On modifie les textes via les IDs du XML
            views.setTextViewText(R.id.widget_title, "Mon Widget");
            views.setTextViewText(R.id.widget_text, "Bonjour !");

            // On applique les changements
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }
}


