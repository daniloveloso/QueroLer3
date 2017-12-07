package com.develop.daniloveloso.queroler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.*;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by DaniloVeloso on 07/12/2017.
 */

public class LivroAdapter extends BaseAdapter {
    private ArrayList<Livro> livros;
    private Activity activity;

    public LivroAdapter(ArrayList<Livro> livro, Activity activity) {
        // Livros que preencheram o listView
        this.livros = livro;
        //O Activity é resposavel por pegar o layout do item livro
        this.activity = activity;
    }
    // Retorna a quantidade de itens
    @Override
    public int getCount() {
        return livros.size();
    }

    //Retorna o item de acordo com a posicao dele na tela
    @Override
    public Object getItem(int position) {
        return livros.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public android.view.View getView(final int position, android.view.View view, ViewGroup parent) {
        if(view == null){
            //infla o layout para poder preencher os dados
            view = this.activity.getLayoutInflater().inflate(R.layout.view, null);
            //Pega o item de acordo com a sua posicao
            final Livro livro = livros.get(position);

            //Atravez do layout pego pela layoutInflater, pegamos cada id relacionado ao item
            //e definimos as informacoes
            TextView nome = view.findViewById(R.id.nome_livro);
            nome.setText(livro.getNome());

            TextView autor = view.findViewById(R.id.autor);
            autor.setText(livro.getAutor());

            Button delete = view.findViewById(R.id.excluir);
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Remove do Array
                    livros.remove(livro);
                    GerenciadorBanco gerenciadorBanco = new GerenciadorBanco(activity);
                    gerenciadorBanco.removeLivro(livro);
                    notifyDataSetChanged();

                }
            });


        }
        return view;

    }


//    public void deletarBancoBd(android.view.View view){
//
//        Livro livro = new Livro();
//
//
//        livro.setId(situacao.toString());
//
//        GerenciadorBanco gerenciadorBanco = new GerenciadorBanco(this);
//        gerenciadorBanco.inserirLivro(livro);
//    }


}
