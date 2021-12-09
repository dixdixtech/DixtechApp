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


        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }



}
