package com.example.dixtechapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Sobre extends AppCompatActivity {
    
    ImageButton botaoFace, botaoLinkedin, botaoInsta;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);
        IniciarComponentes();
        
            
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
    }
    
    private void IniciarComponentes(){
        botaoFace = findViewById(R.id.btnface);
        botaoLinkedin = findViewById(R.id.btnlinkedin);
        botaoInsta = findViewById(R.id.btninsta);
    }
    
    public void GravarI(View view) {
        Intent it = new Intent(this, Gravar.class);
        it.putExtra(Armazenamentos.STORAGE_TYPE, Armazenamentos.Type.INTERNAL);
        startActivity(it);
    }

    public void LerI(View view) {
        Intent it = new Intent(this, Ler.class);
        it.putExtra(Armazenamentos.STORAGE_TYPE, Armazenamentos.Type.INTERNAL);
        startActivity(it);

    }


    public void GravarE(View view) {
        Intent it = new Intent(this, Gravar.class);
        it.putExtra(Armazenamentos.STORAGE_TYPE, Armazenamentos.Type.EXTERNAL);
        startActivity(it);

    }


    public void LerE(View view) {
        Intent it = new Intent(this, Ler.class);
        it.putExtra(Armazenamentos.STORAGE_TYPE, Armazenamentos.Type.EXTERNAL);
        startActivity(it);

    }

}
