package com.example.dixtechapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Usuario extends AppCompatActivity {

ImageButton btnhome, btnmap, btninfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        getSupportActionBar().hide();

        IniciarComponentes();

        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent home = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(home);
            }
        });

        btnmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent map = new Intent(getApplicationContext(), Mapa.class);
                startActivity(map);
            }
        });

        btninfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent info = new Intent(getApplicationContext(), Sobre.class);
                startActivity(info);
            }
        });
    }

    private void IniciarComponentes() {
        btnhome = findViewById(R.id.btnhomeuser);
        btnmap = findViewById(R.id.btnmapuser);
        btninfo = findViewById(R.id.btninfouser);
    }
}