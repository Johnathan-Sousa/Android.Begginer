package com.example.john.validationapplication.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.john.validationapplication.R;

public class BemVindoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bem_vindo);

        Intent intent = getIntent();

        if(intent != null){
            Bundle params = intent.getExtras();

            if(params != null){
                String nome = params.getString("nome");
                String email = params.getString("email");

                TextView NomeView = (TextView) findViewById(R.id.textNome);
                NomeView.setText("Nome: " + nome);

                TextView EmailView = (TextView) findViewById(R.id.textMail);
                EmailView.setText("E-Mail: " + email);
            }
        }
    }
}
