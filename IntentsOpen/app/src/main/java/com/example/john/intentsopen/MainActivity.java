package com.example.john.intentsopen;

import android.content.ComponentName;
import android.content.Intent;
import android.drm.DrmStore;
import android.net.Uri;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import android.widget.EditText;
import android.widget.Toast;

/**
 * Programa para testar Intents, abrindo outros programas
 */


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Método de Configurar alarme android
     *
     * @param view
     */
    public void alarmConfig(View view) {

        EditText alarmHora = (EditText) findViewById(R.id.hrEditText);
        EditText alarmMin = (EditText) findViewById(R.id.minEditText);
        EditText alarmMsg = (EditText) findViewById(R.id.msgEditText);

        String horaString = alarmHora.getText().toString();
        String minString = alarmMin.getText().toString();

        //Teste de Vazio para evitar erro de nulo - Equals(testa true) ! antes da frase negativa
        if (!horaString.equals("") && !minString.equals("")) {

            int hora = Integer.parseInt(alarmHora.getText().toString());
            int min = Integer.parseInt(alarmMin.getText().toString());

            String msg = alarmMsg.getText().toString();


            if (hora < 0 || hora > 23 || min < 0 || min > 59) {

                Toast toast = Toast.makeText(getApplicationContext(), "HORÁRIO INVÁLIDO", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 130);
                toast.show();


            } else {

                Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
                i.putExtra(AlarmClock.EXTRA_MESSAGE, msg);
                i.putExtra(AlarmClock.EXTRA_DAYS, 1);
                i.putExtra(AlarmClock.EXTRA_HOUR, hora);
                i.putExtra(AlarmClock.EXTRA_MINUTES, min);

                startActivity(i);
            }

        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "HORÁRIO INVÁLIDO", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 130);
            toast.show();
        }
    }

    /**
     * Método de Abrir Player de Música Padrão
     *
     * @param view
     */

    public void musicPlayer(View view) {

        ComponentName comp = new ComponentName("com.android.music",
                "com.android.music.MediaPlaybackActivity");

        Intent intent = new Intent();
        intent.setComponent(comp);
        intent.setAction(Intent.ACTION_RUN);

        startActivity(intent);
    }

    /**
     * Método de Abrir o Google Maps na localização atual.
     *
     * @param view
     */

    public void mapasOpen(View view) {

        Intent mapIntent = new Intent(Intent.ACTION_VIEW);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    /**
     * Métodos de Abrir SMS nativo do Android
     *
     * @param view
     */

    public void smsOpen(View view) {

        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
        sendIntent.setData(Uri.parse("sms:"));
        startActivity(sendIntent);
    }

    /**
     * Método de abrir as Configurações do Sistema
     *
     * @param view
     */
    public void configOpen(View view) {

        Intent intent = new Intent(android.provider.Settings.ACTION_SETTINGS);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
