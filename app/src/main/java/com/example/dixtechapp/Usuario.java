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
ImageView imgviewfoto;
Button btnbio, btnlogout, btnfoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        getSupportActionBar().hide();

        IniciarComponentes();

        btnfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
                    String[] permissao = {Manifest.permission.READ_EXTERNAL_STORAGE};
                    requestPermissions(permissao, 1001);
                }else{
                    escolherImagem();
                }    
            }
        });
            
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

    private void  escolherImagem(){
        Intent i = new Intent(Intent.ACTION_PICK);
        I.setType("image/*");
        startActivityForResult(intent, 1000);
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        if(resultCode == RESULT_OK && requestCode == 1000){
            imgviewfoto.setImageURI(data.getData());
        }
    }
    
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(request){
            case 1001:{
                if(grantResult.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    escolherImagem()
                }else{
                    Toast.makeText(this, "Permissão negada", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private void IniciarComponentes() {
        btnhome = findViewById(R.id.btnhomeuser);
        btnmap = findViewById(R.id.btnmapuser);
        btninfo = findViewById(R.id.btninfouser);
        btnbio = findViewById(R.id.btnbio);
        btnlogout = findViewById(R.id.btnlogoff);
        btnfoto = findViewById(R.id.btnfotouser);
        imgviewfoto = findViewById(R.id.imageView);
    }


}
