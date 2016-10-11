package com.example.john.appgson.entity;

import java.util.Date;

/**
 * Created by John on 27/09/2016.
 */

public class Pessoa {

    private String Nome;
    private Date nascimento;
    private String endereco;


    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
