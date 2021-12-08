package com.example.dixtechapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateServico extends AppCompatActivity {

    EditText nm_serv_updt, desc_serv_updt;
    Button btn_update, btn_delete;

    String id, nome, desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateservico);

        nm_serv_updt = findViewById(R.id.edittxt_nm_serv_updt);
        desc_serv_updt = findViewById(R.id.edittxt_desc_serv_updt);
        btn_update = findViewById(R.id.btnupdateserv);
        btn_delete = findViewById(R.id.btndeleteserv);

        //Chamando o método
        getAndSetIntentData();

        //Setando a actionbar com o title depois do método getSupportActionBar  
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(title);
        }

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Nesta parte é chamado o db para fazer um update nos campos 
                de acordo com as EditTexts*/
                DBHelper db = new DBHelper(UpdateServico.this);
                nome = nm_serv_updt.getText().toString().trim();
                desc = desc_serv_updt.getText().toString().trim();
                db.updateData(id, nome, desc);
            }
        });
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmaDialogo();
            }
        });

    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("nome") &&
                getIntent().hasExtra("desc")){
            //Pegando dados da intent
            id = getIntent().getStringExtra("id");
            nome = getIntent().getStringExtra("nome");
            desc = getIntent().getStringExtra("desc");
            

            //Setando dados na intent
            title_input.setText(nome);
            author_input.setText(desc);
            Log.d("stev", nome+" "+desc);
        }else{
            Toast.makeText(this, "Não há dados.", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmaDialogo(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Deletar " + nome + " ?");
        builder.setMessage("Você quer deletar " + nome + " ?");
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DBHelper db = new DBHelper(UpdateServico.this);
                db.deleteOneRow(id);
                finish();
            }
        });
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}
