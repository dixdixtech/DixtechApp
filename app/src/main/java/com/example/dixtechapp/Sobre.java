package com.example.dixtechapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Sobre extends AppCompatActivity {
    
    ImageButton botaoFace, botaoLinkedin, botaoInsta, botaoGit, btnhome, btnmap, btnuser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);
        IniciarComponentes();

        getSupportActionBar().hide();


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

        btnuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent user = new Intent(getApplicationContext(), Usuario.class);
                startActivity(user);
            }
        });
            
        botaoFace.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.facebook.com/Dix-Tech-Corporation-116487190215728");
                Intent it = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(Intent.createChooser(it, getString(R.string.chNav)));

            }
        });
        
        botaoLinkedin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.linkedin.com/in/dix-tech-corporation-b83a961b8/");
                Intent it = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(Intent.createChooser(it, getString(R.string.chNav)));

            }
        });
        
        botaoInsta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.instagram.com/dix_tech/");
                Intent it = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(Intent.createChooser(it, getString(R.string.chNav)));

            }
        });

        botaoGit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://github.com/dixdixtech");
                Intent it = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(Intent.createChooser(it, getString(R.string.chNav)));

            }
        });
    }
    
    private void IniciarComponentes(){
        botaoFace = findViewById(R.id.btnface);
        botaoLinkedin = findViewById(R.id.btnlinkedin);
        botaoInsta = findViewById(R.id.btninsta);
        botaoGit = findViewById(R.id.btngithub);
        btnhome = findViewById(R.id.btnhomeinfo);
        btnmap = findViewById(R.id.btnmapinfo);
        btnuser = findViewById(R.id.btnuserinfo);
    }
    


}
