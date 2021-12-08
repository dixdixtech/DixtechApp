package com.example.dixtechapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;



public class DBHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DB_NAME="DbDixtech.db";
    private static final int DB_VERSAO = 1;

    DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSAO);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String func = "CREATE TABLE tbl_func(id_func INTEGER primary key autoincrement, nome_func TEXT NOT NULL, cpf TEXT NOT NULL UNIQUE, cargo TEXT NOT NULL, senha TEXT NOT NULL," +
                "email_func TEXT NOT NULL UNIQUE, data_nasc_func TEXT NOT NULL, tel_func TEXT NOT NULL UNIQUE);";

        String cliente = "CREATE TABLE tbl_cliente(id_cli INTEGER primary key autoincrement, cnpj TEXT NOT NULL UNIQUE, nome_cli TEXT NOT NULL, tel_cli TEXT NOT NULL UNIQUE," +
                "email_cli TEXT NOT NULL UNIQUE, endereco TEXT NOT NULL);";

        String servico = "CREATE TABLE tbl_servico(id_serv INTERGER primary key autoincrement, nome_serv TEXT NOT NULL, desc_serv TEXT NOT NULL);";

        String atividade = "CREATE TABLE tbl_atividade(id_atv INTERGER primary key autoincrement, desc_atv TEXT NOT NULL, data_inicial TEXT NOT NULL, data_final TEXT NOT NULL," +
                "nomecli TEXT NOT NULL," +
                "nome_func TEXT NOT NULL," +
                "nome_serv TEXT NOT NULL," +
                "FOREIGN KEY (fk_nome_cli) references tbl_cliente (nome_cli)," +
                "FOREIGN KEY (fk_nome_func) references tbl_func (nome_func)," +
                "FOREIGN KEY (fk_nome_serv) references tbl_servico (nome_serv));"
                ;

        db.execSQL(func);
        db.execSQL(cliente);
        db.execSQL(servico);
        db.execSQL(atividade);

    }

    @Override
    public void onOpen(SQLiteDatabase db){
        super.onOpen(db);
        if(!db.isReadOnly()){
            db.execSQL("PRAGMA foreign_keys=ON;");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS tbl_func");
        db.execSQL("DROP TABLE IF EXISTS tbl_cliente");
        db.execSQL("DROP TABLE IF EXISTS tbl_servico");
        db.execSQL("DROP TABLE IF EXISTS tbl_atividade");
        onCreate(db);

    }
    //MÉTODOS PARA A TABELA SERVICO
    void addServico(String nome, String desc){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        
        cv.put("nome_serv", nome);
        cv.put("desc_serv", desc);
        long resultado= db.insert("tbl_servico", null, cv);
        if(resultado==-1){
            Toast.makeText(context, "Falha ao adicionar", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(context, "Sucesso ao adicionar", Toast.LENGTH_SHORT).show();
        }
    }
    
    Cursor readAllData(){
        String query = "SELECT * FROM tbl_servico";
        SQLiteDatabase db = this.getReadableDatabase();
        
        Cursor cursor = null;
        if(db != null){
            db.rawQuery(query, null);
        }
        return cursor;
    }
    
    void updateData(String row_id, String nome, String desc){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nome_serv", nome);
        cv.put("desc_serv", desc);

        long result = db.update("tbl_servico", cv, "id_serv=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Falha ao alterar", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Alteração feita com sucesso!", Toast.LENGTH_SHORT).show();
        }

    }

    void deleteOneRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete("tbl_servico", "id_serv=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Falha ao deletar.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Exclusão feita com sucesso.", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + "tbl_servico");
    }
    //
    
    //MÉTODOS PARA A TABELA CLIENTE
    void addCliente(String cnpj, String nomecli, String telcli, String emailcli, String endereco){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        
        cv.put("cnpj", cnpj);
        cv.put("nome_cli", nomecli);
        cv.put("tel_cli", telcli);
        cv.put("email_cli", emailcli);
        cv.put("endereco", endereco);
        long resultado= db.insert("tbl_cliente", null, cv);
        if(resultado==-1){
            Toast.makeText(context, "Falha ao adicionar", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(context, "Sucesso ao adicionar", Toast.LENGTH_SHORT).show();
        }
    }
    
    Cursor readAllDataCli(){
        String query = "SELECT * FROM tbl_cliente";
        SQLiteDatabase db = this.getReadableDatabase();
        
        Cursor cursor = null;
        if(db != null){
            db.rawQuery(query, null);
        }
        return cursor;
    }
    
    void updateDataCli(String row_id, String cnpj, String nomecli, String telcli, String emailcli, String endereco){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("cnpj", cnpj);
        cv.put("nome_cli", nomecli);
        cv.put("tel_cli", telcli);
        cv.put("email_cli", emailcli);
        cv.put("endereco", endereco);

        long result = db.update("tbl_cliente", cv, "id_cli=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Falha ao alterar", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Alteração feita com sucesso!", Toast.LENGTH_SHORT).show();
        }

    }

    void deleteOneRowCli(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete("tbl_cliente", "id_cli=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Falha ao deletar.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Exclusão feita com sucesso.", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteAllDataCli(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + "tbl_cliente");
    }
    //
    
    //MÉTODOS PARA A TABELA ATIVIDADE
    void addAtividade(String desc, String dtinic, String dtfinal, String nmcli, String nmfunc, String nmserv){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
       
        cv.put("desc_atv", desc);
        cv.put("data_inicial", dtinic);
        cv.put("data_final", dtfinal);
        cv.put("nomecli", nmcli);
        cv.put("nome_func", nmfunc);
        cv.put("nome_serv", nmserv);
        long resultado= db.insert("tbl_atividade", null, cv);
        if(resultado==-1){
            Toast.makeText(context, "Falha ao adicionar", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(context, "Sucesso ao adicionar", Toast.LENGTH_SHORT).show();
        }
    }
    
    Cursor readAllDataAtv(){
        String query = "SELECT * FROM tbl_atividade";
        SQLiteDatabase db = this.getReadableDatabase();
        
        Cursor cursor = null;
        if(db != null){
            db.rawQuery(query, null);
        }
        return cursor;
    }
    
    void updateDataAtv(String row_id, String desc, String dtinic, String dtfinal, String nmcli, String nmfunc, String nmserv){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("desc_atv", desc);
        cv.put("data_inicial", dtinic);
        cv.put("data_final", dtfinal);
        cv.put("nomecli", nmcli);
        cv.put("nome_func", nmfunc);
        cv.put("nome_serv", nmserv);
        long result = db.update("tbl_atividade", cv, "id_atv=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Falha ao alterar", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Alteração feita com sucesso!", Toast.LENGTH_SHORT).show();
        }

    }

    void deleteOneRowAtv(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete("tbl_atividade", "id_atv=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Falha ao deletar.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Exclusão feita com sucesso.", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteAllDataAtv(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + "tbl_atividade");
    }
    //
    
    // MÉTODOS PARA A TABELA FUNCIONARIO
    public Boolean insertFunc(String nome_func, String cpf, String cargo, String senha, String email_func, String data_nasc_func, String tel_func){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues v = new ContentValues();

        v.put("nome_func", nome_func);
        v.put("cpf", cpf);
        v.put("cargo", cargo);
        v.put("senha", senha);
        v.put("email_func", email_func);
        v.put("data_nasc_func", data_nasc_func);
        v.put("tel_func", tel_func);

        long resultado= db.insert("tbl_func", null, v);
        if(resultado==-1) return false;
        else
            return true;
    }

    public Boolean checkcpf(String cpf){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from tbl_func where cpf=?", new String[] {cpf});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkcpfsenha(String cpf, String senha){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from tbl_func where cpf=? and senha=?", new String[] {cpf,senha});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    //
}
