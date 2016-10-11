package com.example.john.appgson;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.john.appgson.entity.Pessoa;
import com.google.gson.Gson;

import java.util.Date;


public class MainActivity extends Activity {

    /**
     * Este App pega os dados da setados abaixo atribuidos a
     * Classe Pessoa e exibe no LOG.D ... depois da conversão
     * do Gson para Json...
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Joao");
        pessoa.setNascimento(new Date());
        pessoa.setEndereco("Rua Qualquer Coisa");


        Gson gson = new Gson();
        String pessoas = gson.toJson(pessoa);

        Log.d("Gson", "user JSON String: "+pessoas);


    }


}
