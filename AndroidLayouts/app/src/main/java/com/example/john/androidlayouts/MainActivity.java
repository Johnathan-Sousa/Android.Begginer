package com.example.john.androidlayouts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear_activity);
    }

    /**
     * Intent Trocar de tela
     */
    public void proximaTela1(View view) {

        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }
}
