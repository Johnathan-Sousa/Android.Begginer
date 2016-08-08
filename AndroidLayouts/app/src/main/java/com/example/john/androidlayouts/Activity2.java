package com.example.john.androidlayouts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class Activity2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear_activity2);
    }

    /**
     * Intent Trocar de tela
     */
    public void proximaTela2(View view) {

        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);


    }
}
