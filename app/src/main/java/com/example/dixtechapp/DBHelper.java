package com.example.dixtechapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;



public class DBHelper extends SQLiteOpenHelper {

    
    
    //servico
    public static final String SERVICO_TABLE_NAME = "tbl_servico";
    public static final String COLUMN_ID_SERV = "id_serv";
    public static final String COLUMN_NOME_SERV = "nome_serv";


    //funcionario
    public static final String FUNCIONARIO_TABLE_NAME = "tbl_func";
    public static final String COLUMN_ID_FUNC = "id_func";
    public static final String COLUMN_NOME_FUNC = "nome_func";
    public static final String COLUMN_CPF_FUNC = "cpf";
    public static final String COLUMN_CARGO_FUNC = "cargo";
    public static final String COLUMN_SENHA_FUNC = "senha";
    public static final String COLUMN_EMAIL_FUNC = "email_func";
    public static final String COLUMN_TEL_FUNC = "tel_func";
    
    //cliente
    public static final String CLIENTE_TABLE_NAME = "tbl_cliente";
    public static final String COLUMN_ID_CLIENTE = "id_cli";
    public static final String COLUMN_CNPJ_CLIENTE = "cnpj";
    public static final String COLUMN_NOME_CLIENTE = "nome_cli";
    public static final String COLUMN_TEL_CLIENTE = "tel_cli";
    public static final String COLUMN_EMAIL_CLIENTE = "email_cli";
    public static final String COLUMN_END_CLIENTE = "endereco";
    
    //atividade
    public static final String ATIVIDADE_TABLE_NAME = "tbl_atividade";
    public static final String COLUMN_ID_ATV = "id_atv";
    public static final String COLUMN_DESC_ATV = "desc_atv";
    public static final String COLUMN_DTINIC_ATV = "data_inicial";
    public static final String COLUMN_DTFINAL_ATV = "data_final";

    //nome e versão do db
    private static final String DB_NAME="DbDixtech.db";
    private static final int DB_VERSAO = 1;

    DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSAO);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String func = "CREATE TABLE " + FUNCIONARIO_TABLE_NAME + "(" +
            COLUMN_ID_FUNC + "INTEGER primary key," +
            COLUMN_NOME_FUNC + "TEXT NOT NULL," + 
            COLUMN_CPF_FUNC + "TEXT NOT NULL UNIQUE," +
            COLUMN_CARGO_FUNC + "TEXT NOT NULL," + 
            COLUMN_SENHA_FUNC + "TEXT NOT NULL," +
            COLUMN_EMAIL_FUNC + "TEXT NOT NULL UNIQUE," +
            COLUMN_TEL_FUNC + "TEXT NOT NULL UNIQUE"+
            ");";

        String cliente = "CREATE TABLE " + CLIENTE_TABLE_NAME + "(" +
            COLUMN_ID_CLIENTE + "INTEGER primary key," +
            COLUMN_CNPJ_CLIENTE + "TEXT NOT NULL UNIQUE," +
            COLUMN_NOME_CLIENTE + "TEXT NOT NULL," +
            COLUMN_TEL_CLIENTE + "TEXT NOT NULL UNIQUE," +
            COLUMN_EMAIL_CLIENTE + "TEXT NOT NULL UNIQUE," +
            COLUMN_END_CLIENTE + "TEXT NOT NULL" + 
            ");";

        String servico = "CREATE TABLE " + SERVICO_TABLE_NAME + "(" +
            COLUMN_ID_SERV + "INTEGER primary key," +
            COLUMN_NOME_SERV + "TEXT NOT NULL" +
            ");";

        String atividade = "CREATE TABLE " + ATIVIDADE_TABLE_NAME + "(" +
            COLUMN_ID_ATV + "INTEGER primary key," +
            COLUMN_DESC_ATV + "TEXT NOT NULL," +
            COLUMN_DTINIC_ATV + "DATE NOT NULL," +
            COLUMN_DTFINAL_ATV + "DATE NOT NULL," +
            COLUMN_NOME_SERV + "TEXT NOT NULL" +
            ");";


        db.execSQL(func);
        db.execSQL(cliente);
        db.execSQL(servico);
        db.execSQL(atividade);

    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {



    }
    
    // ------------------MÉTODOS PARA A TABELA FUNCIONARIO----------------------------
    
    //VALIDAÇÃO DE FUNCIONARIO
    public Funcionario ValidaFunc(String email, String senha){

        SQLiteDatabase db=this.getWritableDatabase();

        Cursor cursor=db.query(FUNCIONARIO_TABLE_NAME,
                new String[]{(COLUMN_ID_FUNC)},
                COLUMN_CPF_FUNC+"=? AND "+ COLUMN_SENHA_FUNC+ "=?" ,new String[]{email,senha},null, null, null, String.valueOf(1));
        if(cursor!=null && cursor.getCount()>0){
            cursor.moveToFirst();
        }

        return new Funcionario(Integer.parseInt(cursor.getString(0)));
    }
    
    //SELECT DO FUNCIONÁRIO
    Funcionario selectFuncio(int codFunc){
        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=db.query(FUNCIONARIO_TABLE_NAME,
                new String[]{COLUMN_ID_FUNC, COLUMN_NOME_FUNC, COLUMN_CPF_FUNC, COLUMN_CARGO_FUNC, COLUMN_SENHA_FUNC, COLUMN_EMAIL_FUNC, COLUMN_TEL_FUNC},
                COLUMN_ID_FUNC+"=?",new String[]{String.valueOf(codFunc)},null, null, null, null);
        if(cursor!=null){
            cursor.moveToFirst();
        }

        return new Funcionario(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2),
                cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6));
    }

    //INSERT DE FUNCIONÁRIO
    void addFuncionario(Funcionario funcionario){
        SQLiteDatabase db=this.getWritableDatabase();
            
        ContentValues values= new ContentValues();
        values.put(COLUMN_NOME_FUNC, funcionario.getNomeFunc());
        values.put(COLUMN_TEL_FUNC, funcionario.getTelFunc());
        values.put(COLUMN_CPF_FUNC, funcionario.getCpfFunc());
        values.put(COLUMN_CARGO_FUNC, funcionario.getCargoFunc());
        values.put(COLUMN_EMAIL_FUNC, funcionario.getEmailFunc());
        values.put(COLUMN_SENHA_FUNC, funcionario.getSenhaFunc());
        
        db.insert(FUNCIONARIO_TABLE_NAME, null, values);
        db.close();
    }

    //UPDATE DE FUNCIONÁRIOS
    void updateFuncio(Funcionario funcionario){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values= new ContentValues();

        values.put(COLUMN_NOME_FUNC, funcionario.getNomeFunc());
        values.put(COLUMN_TEL_FUNC, funcionario.getTelFunc());
        values.put(COLUMN_CPF_FUNC, funcionario.getCpfFunc());
        values.put(COLUMN_CARGO_FUNC, funcionario.getCargoFunc());
        values.put(COLUMN_EMAIL_FUNC, funcionario.getEmailFunc());
        values.put(COLUMN_SENHA_FUNC, funcionario.getSenhaFunc());

        db.update(FUNCIONARIO_TABLE_NAME, values, COLUMN_ID_FUNC + "= ?",
                new String[]{String.valueOf(funcionario.getIdFunc()) });
    }
    //
    
    //MÉTODOS PARA A TABELA SERVICO
    
    //

    //MÉTODOS PARA A TABELA CLIENTE
    
    //

    //MÉTODOS PARA A TABELA ATIVIDADE
    
    //

    
}
