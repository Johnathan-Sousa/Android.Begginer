package com.example.john.androidlayouts;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;


public class Activity4 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_activity4);
    }

    /**
     * Intent Trocar de tela
     */
    public void proximaTela4(View view) {
        Intent intent = new Intent(this, Activity5.class);
        startActivity(intent);

    }

    /**
     * Metodo para ativar o Frame Layout que esta oculto
     */
    public void abrirFrame(View view) {

        FrameLayout frame = (FrameLayout) findViewById(R.id.frameLayout);
        frame.setVisibility(View.VISIBLE);


    }
}


