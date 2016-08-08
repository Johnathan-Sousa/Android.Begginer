package com.example.john.androidlayouts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class Activity3 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_activity3);
    }

    /**
     * Intent Trocar de tela
     */
    public void proximaTela3(View view) {
        Intent intent = new Intent(this, Activity4.class);
        startActivity(intent);

    }
}


