package com.example.john.intentapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;

/**
 * Created by John on 02/07/2016.
 */
public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        Intent intent = getIntent();

        if(intent != null){
            Bundle params = intent.getExtras();

            if(params != null){
                String campo = params.getString("campo");

                TextView campoView = (TextView) findViewById(R.id.mensagemTextView);

                campoView.setText(campo);
            }
        }


    }



    public void mudarTelaInicio(View view) {

        Intent outraTela = new Intent(this,PrimeiraActivity.class);
        startActivity(outraTela);
    }




}
