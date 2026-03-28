package fr.clarisse.widcitations;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class widget extends AppWidgetProvider{
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

        // Pour chaque instance du widget sur l'écran d'accueil
        for (int appWidgetId : appWidgetIds) {

            // On pointe vers le layout XML
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_app);

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
}






