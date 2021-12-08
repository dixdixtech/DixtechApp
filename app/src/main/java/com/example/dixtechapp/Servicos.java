package com.example.dixtechapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Servicos extends AppCompatActivity {

    RecyclerView recycler;
    FloatingActionButton btn_add;
    ImageButton btninfo,btnmap, btnuser, btnhome;
    DBHelper meudb;
    ArrayList<String> id_servico, nome_servico, desc_servico;
    CustomAdapter customAdapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicos);
        getSupportActionBar().hide();
        iniciarComponentes():
        
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent add = new Intent(Servicos.this, AddServ.class);
                startActivity(add);
            }
        });
        
        meudb = new.DBHelper(Servicos.this);
        id_servico = new ArrayList<>();
        nome_servico = new ArrayList<>();
        desc_servico = new ArrayList<>();
        
        guardarDadosEmArrays();
        
        customAdapter = new CustomAdapter(Servicos.this, this, id_servico, nome_servico, 
                                          desc_servico);
        recycler.setAdapter(customAdapter);
        recycler.setLayoutManager(new LinearLayoutManager(Servicos.this));
    }
    
     @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }
    
    void guardarDadosEmArrays(){
        Cursor cursor = meudb.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "Não há dados").show();
        }else{
            while(cursor.moveToNext()){
                id_servico.add(cursor.getString(0));
                nome_servico.add(cursor.getString(1));
                desc_servico.add(cursor.getString(2));
                
                
            }
        }
    }
    
    private void iniciarComponentes(){
        recycler = findViewById(R.id.recyclerServ);
        btn_add = findViewById(R.id.add_serv);
        btninfo = findViewById(R.id.btninfoserv);
        btnmap = findViewById(R.id.btnmapserv);
        btnuser = findViewById(R.id.btnuserserv);
        btnhome = = findViewById(R.id.btnhomeserv);
        }
}
