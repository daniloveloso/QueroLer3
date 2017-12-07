package com.develop.daniloveloso.queroler;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListaLidos extends AppCompatActivity {

    ArrayList<Livro> livros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Carrega o layout onde contem o ListView
        setContentView(R.layout.lista);
        //pega a referencia do ListView
        ListView listLivros = findViewById(R.id.listview);
        GerenciadorBanco gerenciadorBanco = new GerenciadorBanco(this);
        livros = gerenciadorBanco.listaLivros();
        //Cria o adapter
        final LivroAdapter adapter = new LivroAdapter(livros, this);
        listLivros.setAdapter(adapter);




    }


}