package com.example.dixtechapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton btninfo, btnmap, btnuser;
    Button btnatividades, btnclientes, btnservicos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        IniciarComponentes();

        btninfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent info = new Intent(getApplicationContext(), Sobre.class);
                startActivity(info);
            }
        });

        btnmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent map = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(map);
            }
        });

        btnuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent user = new Intent(getApplicationContext(), Usuario.class);
                startActivity(user);
            }
        });

        btnatividades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent atvd = new Intent(getApplicationContext(), Atividades.class);
                startActivity(atvd);
            }
        });

        btnclientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent clt = new Intent(getApplicationContext(), Cliente.class);
                startActivity(clt);
            }
        });

        btnservicos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent srv = new Intent(getApplicationContext(), Servicos.class);
                startActivity(srv);
            }
        });

    }

    private void IniciarComponentes(){
        btninfo = findViewById(R.id.btninfohome);
        btnmap = findViewById(R.id.btnmaphome);
        btnuser = findViewById(R.id.btnuserhome);
        btnatividades = findViewById(R.id.btnatividade);
        btnclientes = findViewById(R.id.btncliente);
        btnservicos = findViewById(R.id.btnservicos);
    }

}