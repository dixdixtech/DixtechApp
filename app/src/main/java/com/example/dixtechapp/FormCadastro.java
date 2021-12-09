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
    private EditText editTextCpf, editTextFone, editTextSenha, editTextNome, editTextCargo, editTextEmail;
    private Button botaocad;
    DBHelper db= new DBHelper(this);
    
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
                String tel= editTextFone.getText().toString();

                if(name.isEmpty() || cpf.isEmpty() || cargo.isEmpty() || senha.isEmpty() || email.isEmpty() || tel.isEmpty()){ 
                    //SE ALGUM CAMPO ESTIVER VAZIO, IRÁ MOSTRAR UM TOAST
                    Toast.makeText(FormCadastro.this, "Os campos são Obrigatoiros",Toast.LENGTH_SHORT).show();
                }else {
                    //SE NENHUM CAMPO ESTIVER VAZIO, IRÁ ADICIONAR O FUNCIONÁRIO
                    db.addFuncionario(new Funcionario(name, cpf, cargo, senha, email, tel));
                    //TOAST COM A MENSAGEM DE SUCESSO
                    Toast.makeText(FormCadastro.this, "Funcionario adicionado ", Toast.LENGTH_SHORT).show();
                    TelaInic();
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
        editTextSenha = findViewById(R.id.editsenha);
        editTextNome = findViewById(R.id.editnome);
        editTextCargo = findViewById(R.id.editcargo);
        editTextEmail = findViewById(R.id.editemail);
        botaocad = findViewById(R.id.btncadastro);
    }
    
    public void TelaInic(){
        Intent inic = new Intent(getApplicationContext(), MainActvity.class);
        startActivity(inic);
        finish();
    }
}
