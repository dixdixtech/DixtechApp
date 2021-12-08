package com.example.dixtechapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FormLogin extends AppCompatActivity {

    private TextView txttelacadastro;
    private EditText editTextCpf, editTextSenha;
    private Button botaologin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);
        getSupportActionBar().hide();

        IniciarComponentes();

        botaologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String cpf = editTextCpf.getText().toString();
                String senha = editTextSenha.getText().toString();

                if(TextUtils.isEmpty(cpf) || TextUtils.isEmpty(senha))
                    Toast.makeText(FormLogin.this,"Todos os campos são requeridos",Toast.LENGTH_SHORT).show();
                else{
                    Boolean checar = DB.checkcpfsenha(cpf, senha);
                    if(checar==true){
                        Toast.makeText(FormLogin.this,"Login feito com sucesso!",Toast.LENGTH_SHORT).show();
                        Intent login = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(login);
                    }else{
                        Toast.makeText(FormLogin.this,"Falha ao logar",Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });

        txttelacadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cad = new Intent(FormLogin.this,FormCadastro.class);
                startActivity(cad);
            }
        });

        editTextCpf.addTextChangedListener(MaskEditUntil.mask(editTextCpf, MaskEditUntil.FORMAT_CPF));

    }

    private void IniciarComponentes(){
        txttelacadastro = findViewById(R.id.txttelacadastro);
        editTextCpf = findViewById(R.id.edittextcpflog);
        editTextSenha = findViewById(R.id.edittextsenhalog);
        botaologin = findViewById(R.id.btncadastro);
        DB = new DBHelper(this);
    }
}