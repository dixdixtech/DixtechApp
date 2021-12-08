package com.example.dixtechapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class AddServ extends AppCompatActivity {
  
    EditText txtnomeserv, txtdescserv;
    Button btnaddserv ;
         
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formservico);
        getSupportActionBar().hide();
        iniciarComponentes();
        
        btnaddserv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              DBHelper db = new DBHelper(AddServ.this);
              db.addServico(txtnomeserv.getText().toString().trim(),
                           txtdescserv.getText().toString().trim());
            }
        });
        

    }
    
    private void iniciarComponentes(){
        txtnomeserv = findViewById(R.id.edittextnomeserv);
        txtdescserv = findViewById(R.id.edittextdescserv);
        btnaddserv = findViewById(R.id.btnaddserv);
        }
}
