package com.example.john.validationapplication.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.john.validationapplication.Validate.EmailValidate;
import com.example.john.validationapplication.R;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    public void login(View view) {

        int pass = 0;
        int mail = 0;

        EditText editMail = (EditText) findViewById(R.id.EmailLoginEdit);
        String emailTest = editMail.getText().toString();

        if (!EmailValidate.isValidEmail(emailTest)) {
            editMail.setError("E-mail inválido");
        } else {
            if (!emailTest.equals("teste@mail.com")) {
                editMail.setError("Email Inválido ou Não Cadastrado");
            } else {
                mail = 1;
            }
        }

        EditText editSenha = (EditText) findViewById(R.id.SenhaLoginEdit);
        String senhaTest = editSenha.getText().toString();

        if (senhaTest == null
                || (senhaTest.length() == 0)
                || (senhaTest.length() > 5)
                || (senhaTest.length() < 5)) {

            editSenha.setError("Senha inválida");

        } else {
            if (!senhaTest.equals("12345")) {
                editSenha.setError("Senha Incorreta ou inválida");
            } else{
                pass = 1;
            }
        }

        if(mail == 1 && pass == 1){
            Bundle bundle = new Bundle();
            bundle.putString("nome", "Usuário Padrão");
            bundle.putString("email", emailTest);

            Intent intent = new Intent(this, BemVindoActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }


    }


    public void cadastro(View view) {

        Intent intent = new Intent(this, CadastroUsuarioActivity.class);
        startActivity(intent);
    }


}