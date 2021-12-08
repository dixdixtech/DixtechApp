package com.example.dixtechapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dixtechapp.Armazenamentos.Type;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Gravar extends AppCompatActivity {
    
    private static final int EXTERNAL_STORAGE_PERMISSION_CODE = 30;
    private Type type;
    private EditText edTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gravar);
        getSupportActionBar().hide();

        edTexto = (EditText) findViewById(R.id.edittextgravacao);
        type = (Type) getIntent().getSerializableExtra(Armazenamentos.STORAGE_TYPE);
    }
    
     @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void SalvarTxt(View view) {

        String txt = edTexto.getText().toString();
        String caminho;

        try {
            if (type == Type.INTERNAL) {
                caminho = gravarInterno(txt);
            } else {
                caminho = gravarExterno(txt);
            }

            Toast.makeText(this, "Arquivo gravado em" + caminho,Toast.LENGTH_SHORT).show();
            finish();
        } catch (IOException e) {
            Toast.makeText(this, "Erro: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

    }

    private String gravarInterno(String text) throws IOException {


        FileOutputStream out = openFileOutput(Armazenamentos.FILE_NAME,	MODE_PRIVATE);
        PrintWriter pw = new PrintWriter(out);

        try {
            pw.print(text);
            return getFilesDir().getPath() + File.separator
                    + Armazenamentos.FILE_NAME;
        } finally {
            pw.close();
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private String gravarExterno(String text) throws IOException {

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                EXTERNAL_STORAGE_PERMISSION_CODE);

        String status = Environment.getExternalStorageState();

        if( !status.equals(Environment.MEDIA_MOUNTED)){
            throw new IOException("O SD Card não montado ou nãoo disponível");
        }
        File dir = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        File file = new File(dir, Armazenamentos.FILE_NAME);
        PrintWriter pw = new PrintWriter(file);

        try{
            pw.print(text);
            return file.getPath();
        }finally {
            pw.close();
        }


    }

}
