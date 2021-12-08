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

public class FormCadastro extends AppCompatActivity {

    private TextView txttelalogin;
    private EditText editTextCpf, editTextFone, editTextDataN, editTextSenha, editTextRepeatSenha, editTextNome, editTextCargo, editTextEmail;
    private Button botaocad;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cadastro);
        getSupportActionBar().hide();

        IniciarComponentes();

        botaocad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name= editTextNome.getText().toString();
                String cpf= editTextCpf.getText().toString();
                String cargo= editTextCargo.getText().toString();
                String senha= editTextSenha.getText().toString();
                String email= editTextEmail.getText().toString();
                String dtnasc= editTextDataN.getText().toString();
                String tel= editTextFone.getText().toString();

                String repeat = editTextRepeatSenha.getText().toString();

                if(TextUtils.isEmpty(cpf) || TextUtils.isEmpty(tel) || TextUtils.isEmpty(dtnasc) || TextUtils.isEmpty(senha) || TextUtils.isEmpty(name)
                        || TextUtils.isEmpty(cargo) || TextUtils.isEmpty(email))
                    Toast.makeText(FormCadastro.this, "Todos os campos são requeridos", Toast.LENGTH_SHORT).show();
                else{
                    if(senha.equals(repeat)){
                        Boolean checarcpf = DB.checkcpf(cpf);
                        if(checarcpf==false){
                            Boolean insert = DB.insertFunc(name, cpf, cargo, senha, email, dtnasc, tel);
                            if(insert==true){
                                Toast.makeText(FormCadastro.this,"Cadastrado com Sucesso!",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(FormCadastro.this,"Falha ao cadastrar",Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(FormCadastro.this,"Sócio já cadastrado",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(FormCadastro.this,"As senhas não combinam entre si",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        txttelalogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent log = new Intent(FormCadastro.this,FormLogin.class);
                startActivity(log);
            }
        });

        editTextCpf.addTextChangedListener(MaskEditUntil.mask(editTextCpf, MaskEditUntil.FORMAT_CPF));
        editTextFone.addTextChangedListener(MaskEditUntil.mask(editTextFone, MaskEditUntil.FORMAT_FONE));
        editTextDataN.addTextChangedListener(MaskEditUntil.mask(editTextDataN, MaskEditUntil.FORMAT_DATE));
    }

    private void IniciarComponentes(){
        txttelalogin = findViewById(R.id.txttelalogin);

        editTextCpf = findViewById(R.id.editcpf);
        editTextFone = findViewById(R.id.edittelefone);
        editTextDataN = findViewById(R.id.editdatanasc);
        editTextSenha = findViewById(R.id.editsenha);
        editTextNome = findViewById(R.id.editnome);
        editTextCargo = findViewById(R.id.editcargo);
        editTextEmail = findViewById(R.id.editemail);
        editTextRepeatSenha = findViewById(R.id.editrepeatsenha);
        botaocad = findViewById(R.id.btncadastro);

        DB = new DBHelper(this);
    }
}
