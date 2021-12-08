package com.example.dixtechapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Usuario extends AppCompatActivity {

ImageButton btnhome, btnmap, btninfo;
Button btnbio, btnlogout;

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

                Intent map = new Intent(getApplicationContext(), MapsActivity.class);
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

        btnbio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent bio = new Intent(getApplicationContext(), Bio.class);
                startActivity(bio);
            }
        });



    }



    private void IniciarComponentes() {
        btnhome = findViewById(R.id.btnhomeuser);
        btnmap = findViewById(R.id.btnmapuser);
        btninfo = findViewById(R.id.btninfouser);
        btnbio = findViewById(R.id.btnbio);
        btnlogout = findViewById(R.id.btnlogoff);
    }


}