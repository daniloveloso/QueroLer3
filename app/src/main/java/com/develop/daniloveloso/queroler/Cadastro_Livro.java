package com.develop.daniloveloso.queroler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Cadastro_Livro extends AppCompatActivity {

    //Itens TelaCadastro
    EditText nome;
    EditText autor;
    EditText editora;
    Button buttonSave;
    Button voltar;
    Spinner situacao;
    String[] arraySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro__livro);


        //Encontrado cadastrar_livro
        nome = findViewById(R.id.nomeL);
        autor = findViewById(R.id.autor);
        editora = findViewById(R.id.editora);
        situacao = (Spinner) findViewById(R.id.spinner);
        buttonSave = findViewById(R.id.salvarL);
        voltar = findViewById(R.id.voltarP);

        this.arraySpinner = new String[]{"Lido","Para Ler"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
                arraySpinner);
        situacao.setAdapter(adapter);

    }

    public void inserirBancoBd(android.view.View view){

        Livro livro = new Livro();

        livro.setNome(nome.getText().toString());
        livro.setAutor(autor.getText().toString());
        livro.setEditora(editora.getText().toString());
        livro.setSituacao(situacao.toString());

        GerenciadorBanco gerenciadorBanco = new GerenciadorBanco(this);
        gerenciadorBanco.inserirLivro(livro);
    }

    public void voltaPrincipal(android.view.View view){
        Intent vrIntent= new Intent(this,Principal.class);

        startActivity(vrIntent);
    }

}
