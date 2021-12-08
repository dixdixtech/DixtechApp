package com.example.dixtechapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Servicos extends AppCompatActivity {

    RecyclerView recycler;
    FloatingActionButton btn_add;
    ImageButton btninfo,btnmap, btnuser, btnhome;
         
    
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
