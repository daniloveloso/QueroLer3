package com.develop.daniloveloso.queroler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import java.io.IOException;

public class Principal extends AppCompatActivity {

    //Itens visualizacao
    Button lidos;
    Button ler;
    Button cadastro;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);

        //Encontrado Principal
        lidos = findViewById(R.id.lidos);
        ler = findViewById(R.id.pler);
        cadastro = findViewById(R.id.cadastrolivro);

    }

   public void onClickLidos(android.view.View view) throws IOException{
        Intent vrIntent= new Intent(this,ListaLidos.class);

        startActivity(vrIntent);
   }

    public void onClickLer(android.view.View view) throws IOException{
        Intent vrIntent= new Intent(this,TelaLogin.class);

        startActivity(vrIntent);
    }



    public void onClickCadastro(android.view.View view) {
        Intent vrIntent= new Intent(this,Cadastro_Livro.class);

        startActivity(vrIntent);
    }
}
