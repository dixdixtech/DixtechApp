package com.example.dixtechapp;

public class DBHelper {
    private Context context;
    private static final String DB_NAME="DbDixtech.db";
    private static final int DB_VERSAO = 1;
    
    public DBHelper(@Nullable Context context) {
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
            "FOREIGN KEY (fk_nome_cli) references tbl_cliente (nome_cli)," +
            "nome_func TEXT NOT NULL," + 
            "FOREIGN KEY (fk_nome_func) references tbl_func (nome_func)," +
            "nome_serv TEXT NOT NULL," + 
            "FOREIGN KEY (fk_nome_serv) references tbl_servico (nome_serv));" ;
        
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
}
