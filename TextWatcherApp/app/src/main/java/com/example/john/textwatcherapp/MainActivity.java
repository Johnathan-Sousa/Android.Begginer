package com.example.john.textwatcherapp;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;


public class MainActivity extends Activity implements TextWatcher {


    List<String> nomesAdd; //criação da lista de strings
    List<String> nomesBusca;

    ArrayAdapter<String> nomesAdapter;  // cria o adapter com array

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomesAdd = new ArrayList<String>();
        nomesBusca = new ArrayList<String>();

        nomesAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, nomesBusca);

        ListView nomesListView = (ListView) findViewById(R.id.nomesListView);
        nomesListView.setAdapter(nomesAdapter);

        EditText nomeBuscaEditText = (EditText) findViewById(R.id.buscaEditText);
        nomeBuscaEditText.addTextChangedListener(this);
    }

    public void OnClick(View view) {

        EditText nomeEdit = (EditText) findViewById(R.id.nomeEditText);
        String nome = nomeEdit.getText().toString();
        nomesAdd.add(nome);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {


    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        //nomesBusca. remove
        Log.i("MainActivity", "onTextChanged");
        nomesBusca.clear();

        //nomesadd . procura o char "S" os itens da lista
        for (String nome : nomesAdd) {
            // teste de V ou F -- add Busca

            String busca = s.toString();
            if (nome.indexOf(busca) >= 0) {
                Log.i("MainActivity", "encontrou");
                nomesBusca.add(nome);
            }
        }
        //change notifiy
        nomesAdapter.notifyDataSetChanged();
    }

    @Override
    public void afterTextChanged(Editable s) {


    }
}