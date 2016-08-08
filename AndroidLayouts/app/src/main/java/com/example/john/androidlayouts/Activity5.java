package com.example.john.androidlayouts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by ShAdE on 07/08/2016.
 */
public class Activity5 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scroll_activity5);
    }

    /**
     * Intent Trocar de tela
     */
    public void proximaTela5(View view) {

        Intent intent = new Intent(this, Activity6.class);
        startActivity(intent);


    }


}
