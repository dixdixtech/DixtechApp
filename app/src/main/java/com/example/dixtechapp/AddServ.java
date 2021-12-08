package com.example.dixtechapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;

public class AddServ extends AppCompatActivity {
  
    EditText txtnomeserv, txtdescserv;
    Button btnaddserv ;
         
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formservico);
        getSupportActionBar().hide();
        iniciarComponentes():
        
        

    }
    
    private void iniciarComponentes(){
        txtnomeserv = findViewById(R.id.edittextnomeserv);
        txtdescserv = findViewById(R.id.edittextdescserv);
        btnaddserv = findViewById(R.id.btnaddserv);
        }
}
