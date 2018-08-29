package br.edu.ifpb.gerenciadoreslayout.entidade;

import java.io.Serializable;

public class Pessoa implements Serializable{

    private String nome;

    private float altura;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }
}
