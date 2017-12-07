package com.develop.daniloveloso.queroler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by DaniloVeloso on 16/11/2017.
 */


public class GerenciadorBanco extends SQLiteOpenHelper {
    //informacoes do banco
    static final String name = "bd";
    static final int version = 2;

    //Aqui fica o script para a criacao das tabelas do banco de dados
    //No meu caso, terá apenas uma tabela chamada livro
    String[]scriptCriaBanco = {"create table livro(_id integer primary key autoincrement, nome text not null, autor text not null, editora text not null, situacao);"};


    public final String scriptApagaBD = "DROP TABLE IF EXISTS livro";




    public GerenciadorBanco(Context context) {
        //Aqui abre o banco de Dados já existente
        super(context, name, null, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        for(int iIndex=0; iIndex<scriptCriaBanco.length; iIndex++){
            db.execSQL(scriptCriaBanco[iIndex]);
        }

    }

    public void insereLivro(ContentValues dados){
        SQLiteDatabase bancoDados = this.getWritableDatabase();
        bancoDados.insert("livro", null, dados);
    }
    //Para salvar os dados no banco
    //Ele terá que pegar os dados da tela Cadastro_livro e salvar no banco com esse metodo
    public void inserirLivro(Livro livro){

        SQLiteDatabase db = getWritableDatabase();
        try{
            ContentValues values = new ContentValues();
            //Abaixo vai as variaveis da classe livro que irá receber os
            // dados para serem salvos no banco
            values.put("nome", livro.getNome());
            values.put("autor", livro.getAutor());
            values.put("editora", livro.getEditora());
            values.put("situacao", livro.getSituacao());

            //insere os dados no banco
            db.insert("livro", null, values);

        }catch (Exception e){

        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(scriptApagaBD);


        for (String sql: scriptCriaBanco){
            db.execSQL(sql);
        }


    }

    public int removeLivro(Livro livro){
        SQLiteDatabase db = getWritableDatabase();
        try{
            int count = db.delete("livro", "_id=?", new String[]{String.valueOf(livro.id)});
            Log.i(TAG, "Deletou["+count+"] registro.");
            return count;
        }finally {
            db.close();
        }
    }


    public List<Livro>findAllBySituacao(){
        SQLiteDatabase db = getReadableDatabase();
        try{
            Cursor c = db.query("livro", new String[]{"nome", "autor"},new String("situacao=lido"), null, null, null,null);
            return toList(c);
        }finally {
            db.close();
        }
    }



    public List<Livro>toList(Cursor c){
        List<Livro> livros = new ArrayList<Livro>();
        if (c.moveToFirst()){
            do{
                Livro livro = new Livro();
                livros.add(livro);
                //Recupera os atributos do livro
                livro.setNome(c.getString(1));
                livro.setAutor(c.getString(2));
                livro.setEditora(c.getString(3));

            }while(c.moveToNext());
        }
        return livros;
    }

    //Aqui ele pega os dados salvos no banco e coloca em uma ArrayList
    //para poder ser acessado futuramente pela aplicacao
    public ArrayList<Livro> listaLivros(){
        ArrayList<Livro> lista = new ArrayList<Livro>();
        SQLiteDatabase bancoDados = this.getReadableDatabase();
        // O script para o select no banco com as colunas desejadas
        // com o nome da tabela desejada
        Cursor cursor = bancoDados.query("livro", new String[]{"nome", "autor"}, null, null, null, null, null);

        while(cursor.moveToNext()){
            Livro livro = new Livro();
            livro.setNome(cursor.getString(0));
            livro.setAutor(cursor.getString(1));
            lista.add(livro);
        }
        return lista;
    }

}
