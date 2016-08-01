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



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void alarmConfig(View view) {



        EditText alarmHora = (EditText) findViewById(R.id.hrEditText);
        EditText alarmMin = (EditText) findViewById(R.id.minEditText);
        EditText alarmMsg = (EditText) findViewById(R.id.msgEditText);


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


    }

    public void musicPlayer(View view) {

     /*   Intent intent = new Intent("android.intent.action.MUSIC_PLAYER");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);   */



        Intent intent = new Intent();
        ComponentName comp = new ComponentName("com.android.music", "com.android.music.MediaPlaybackActivity");
        intent.setComponent(comp);
        intent.setAction(Intent.ACTION_RUN);
        startActivity(intent);


    }

    public void mapasOpen(View view) {

        /*Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194"); Se quiser uma localização por coordenadas para inicio*/
        Intent mapIntent = new Intent(Intent.ACTION_VIEW); /* , gmmIntentUri);  -- essa variavel ele abre na posição de coordenadas */
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }


    }


    public void smsOpen(View view) {

      /*  Intent intent = new Intent(Intent.ACTION_VIEW);
        /*intent.setData(Uri.parse("sms:"));
        intent.setPackage("sms");
        startActivity(intent); */

        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
        sendIntent.setData(Uri.parse("sms:"));
        startActivity(sendIntent);
    }

    public void configOpen(View view) {

        /*startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);*/

        Intent intent = new Intent(android.provider.Settings.ACTION_SETTINGS);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);


    }


}
