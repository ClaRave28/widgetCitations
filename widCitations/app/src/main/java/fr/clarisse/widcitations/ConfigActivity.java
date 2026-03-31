package fr.clarisse.widcitations;

import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;



public class ConfigActivity extends AppCompatActivity {

    private int appWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras !=null){
            appWidgetId = extras.getInt(
                    AppWidgetManager.EXTRA_APPWIDGET_ID,
                    AppWidgetManager.INVALID_APPWIDGET_ID
            );
        }

        if (appWidgetId == AppWidgetManager.INVALID_APPWIDGET_ID){
            finish();
            return;
        }

        setResult(RESULT_CANCELED);

        EditText inputBgColor = findViewById(R.id.input_bg_color);
        EditText inputTitleColor = findViewById(R.id.input_title_color);
        EditText inputTextColor = findViewById(R.id.input_text_color);
        Button btnSave = findViewById(R.id.btn_save);

        SharedPreferences prefs = getSharedPreferences("widget_prefs" , MODE_PRIVATE);
        inputBgColor.setText(prefs.getString("bg_color" + appWidgetId, "#9C27B0"));
        inputTitleColor.setText(prefs.getString("title_color" + appWidgetId, "#000000"));
        inputTextColor.setText(prefs.getString("text_color" + appWidgetId, "#000000"));

        btnSave.setOnClickListener(v ->{
            String bgColor = inputBgColor.getText().toString();
            String titleColor = inputTitleColor.getText().toString();
            String textColor = inputTextColor.getText().toString();

            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("bg_color" + appWidgetId, bgColor);
            editor.putString("title_color" + appWidgetId, titleColor);
            editor.putString("text_color" + appWidgetId, textColor);
            editor.apply();

            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
            widget.updateWidget(this, appWidgetManager, appWidgetId);

            Intent resultIntent = new Intent();
            resultIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}
