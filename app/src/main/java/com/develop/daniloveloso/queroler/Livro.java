package com.develop.daniloveloso.queroler;

/**
 * Created by DaniloVeloso on 07/12/2017.
 */

public class Livro {
    int id;
    String nome;
    String autor;
    String editora;
    String situacao;

    public Livro() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Livro(String nome, String autor, String editora, String situacao, int id) {

        this.nome = nome;
        this.autor = autor;
        this.editora = editora;
        this.situacao = situacao;
        this.id = id;

    }
}
