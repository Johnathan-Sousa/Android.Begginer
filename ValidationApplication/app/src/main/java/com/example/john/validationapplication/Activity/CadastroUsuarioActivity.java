package com.example.john.validationapplication.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.john.validationapplication.Validate.CpfValidation;
import com.example.john.validationapplication.Validate.EmailValidate;
import com.example.john.validationapplication.R;

public class CadastroUsuarioActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);
    }

    public void cadastrar(View view) {

        int mail = 0;
        int pass = 0;
        int cpf = 0;
        int name = 0;

        //Captura do nome
        EditText editNome = (EditText) findViewById(R.id.nomeEdit);
        String nomeTest = editNome.getText().toString();

        if (nomeTest.isEmpty()) {
            editNome.setError("Campo Incompleto");

        } else{
            name = 1;
        }


        //captura do email
        EditText editMail = (EditText) findViewById(R.id.emailEdit);
        String mailTest = editMail.getText().toString();

        if (!EmailValidate.isValidEmail(mailTest)) {
            editMail.setError("E-mail inválido");
        } else {
            mail = 1;
        }

        //captura do CPF
        EditText editCpf = (EditText) findViewById(R.id.cpfEdit);
        String cpfTest = editCpf.getText().toString();

        // usando os metodos isCPF() e imprimeCPF() da classe "ValidaCPF"
        if (CpfValidation.isCPF(cpfTest) == true) {
            cpf = 1;
            Log.i("LOGS", "CPF: "+ cpfTest );
        }
        else{
            editCpf.setError("CPF INVÁLIDO");
    }



        //captura da senha
        EditText editSenha = (EditText) findViewById(R.id.senhaEdit);
        String senhaTest = editSenha.getText().toString();

        if (senhaTest == null
                || (senhaTest.length() == 0)
                || (senhaTest.length() > 5)
                || (senhaTest.length() < 5)) {

            editSenha.setError("Senha inválida");
        } else {
            pass = 1;
            Log.i("LOGS", "SENHA: "+ senhaTest );
        }

        //If para não entrar na Intent, a não ser que receba os valores 1
        // de cada teste que passar
        if (mail == 1 && pass == 1 && cpf == 1 && name == 1) {

            Bundle bundle = new Bundle();
            bundle.putString("nome", nomeTest);
            bundle.putString("email", mailTest);
            bundle.putString("cpfC", cpfTest);
            bundle.putString("senhaC", senhaTest);

            Intent intent = new Intent(this, BemVindoActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
}
