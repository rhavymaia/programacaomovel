package br.edu.ifpb.gsonapp.entidade;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Rhavy on 26/09/2016.
 */
public class Pessoa {

    private String nome;

    private Date nascimento;

    private String endereco;


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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
