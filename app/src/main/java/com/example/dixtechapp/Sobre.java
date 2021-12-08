package com.example.dixtechapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Service;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toolbar;

import org.w3c.dom.Text;

public class Sobre extends AppCompatActivity implements SensorEventListener {
    
    ImageButton botaoFace, botaoLinkedin, botaoInsta, btnhome, btnmap, btnuser;
    
    private static final String PREFERENCIAS = "Preferencia";
    
    SensorManager sensorManager;
    Sensor sensor;
    Float luminosidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);
        IniciarComponentes();

        getSupportActionBar().hide();

        SharedPreferences preferences = getSharedPreferences(PREFERENCIAS, 0);
        SharedPreferences.Editor editor = preferences.edit();

        if (preferences.getBoolean("Automatic", false)) {
            if (preferences.getBoolean("Preto", false)){
                modoPreto();
            }
        } else if (preferences.getBoolean("Preto", false)) {
            modoPreto();
        }

        sensorManager = (SensorManager) getSystemService(Service.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);


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
    }
    
    private void IniciarComponentes(){
        botaoFace = findViewById(R.id.btnface);
        botaoLinkedin = findViewById(R.id.btnlinkedin);
        botaoInsta = findViewById(R.id.btninsta);
        btnhome = findViewById(R.id.btnhomeinfo);
        btnmap = findViewById(R.id.btnmapinfo);
        btnuser = findViewById(R.id.btnuserinfo);
    }
    


    //configurações do sensor
    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        SharedPreferences preferences = getSharedPreferences(PREFERENCIAS, 0);
        SharedPreferences.Editor editor = preferences.edit();

        if (preferences.getBoolean("Automatic", false)) {
            if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
                luminosidade = event.values[0];

                if (preferences.getBoolean("Automatic", false) && luminosidade < 5000) {
                    editor.putBoolean("Preto", true).apply();

                    Intent intent = new Intent(Sobre.this, Sobre.class);
                    startActivity(intent);
                    this.overridePendingTransition(0, 0);
                    finish();
                } else if (preferences.getBoolean("Automatic", false) && luminosidade >= 5000) {
                    editor.putBoolean("Preto", false).apply();

                    Intent intent = new Intent(Sobre.this, Sobre.class);
                    startActivity(intent);
                    this.overridePendingTransition(0, 0);
                    finish();
                }
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void modoPreto() {
        //LinearLayout linearCabecalho = (LinearLayout) findViewById(R.id.linearCabecalho);
        TextView txtversao = (TextView) findViewById(R.id.txtversao);
        TextView txtsobre = (TextView) findViewById(R.id.txtsobre);
        Toolbar toolbar3 = (Toolbar) findViewById(R.id.toolbar3);
        /*ImageButton btnlinkedin = (ImageButton) findViewById(R.id.btnlinkedin); 
        ImageButton btninsta = (ImageButton) findViewById(R.id.btninsta); 
        ImageButton btnface = (ImageButton) findViewById(R.id.btnface); 
        ImageButton btngithub = (ImageButton) findViewById(R.id.btngithub);*/ 
        ConstraintLayout constraintback = (ConstraintLayout) findViewById(R.id.constraintback);
            
        constraintback.setBackgroundResource(R.color.black);
        toolbar3.setBackgroundResource(R.color.black);
        txtversao.setTextColor(getResources().getColor(R.color.white));
        txtsobre.setTextColor(getResources().getColor(R.color.white));
        /*
        btnlinkedin.setImageResource(R.drawable.linkedin_dark);
        btninsta.setImageResource(R.drawable.instagram_dark);
        btnface.setImageResource(R.drawable.facebook_dark);
        btngithub.setImageResource(R.drawable.github_dark);
        */
    }

}
