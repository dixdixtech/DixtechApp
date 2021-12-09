package com.example.dixtechapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dixtechapp.Classes.Funcionario;

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

                if(cpf.isEmpty() ||senha.isEmpty()){
                    Toast.makeText(FormLogin.this, "Campos Obrigatorios", Toast.LENGTH_LONG).show();
                }

                else{
                    //valida o login e sneha
                    Funcionario funcionario= DB.ValidaFunc(cpf,senha);

                    //se for valido
                    if(funcionario !=null){
                        int codFunc=funcionario.getIdFunc();

                        //mandando o cod para tela de conta
                        Intent intent = new Intent(getApplicationContext(), Usuario.class);
                        intent.putExtra("codFunc",codFunc);
                        startActivity(intent);

                        //abre home
                        Intent home = new Intent(getApplicationContext(), Usuario.class);
                        startActivity(home);
                    }
                    else{
                        Toast.makeText(FormLogin.this, "Login E Senha não existe", Toast.LENGTH_LONG).show();
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