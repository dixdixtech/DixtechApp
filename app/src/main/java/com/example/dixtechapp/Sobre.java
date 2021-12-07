package com.example.dixtechapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Sobre extends AppCompatActivity implements SensorEventListener{
    
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
    }

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

                Intent map = new Intent(getApplicationContext(), Mapa.class);
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

                if (preferences.getBoolean("Automatic", false) && luminosidade < 20000) {
                    editor.putBoolean("Preto", true).apply();

                    Intent intent = new Intent(Sobre.this, Sobre.class);
                    startActivity(intent);
                    this.overridePendingTransition(0, 0);
                    finish();
                } else if (preferences.getBoolean("Automatic", false) && luminosidade >= 20000) {
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
        Text View txtversao = (TextView) findViewById(R.id.txtversao);
        Text View txtsobre = (TextView) findViewById(R.id.txtsobre);
        Toolbar toolbar3 = (Toolbar) findViewById(R.id.toolbar3); 
        ImageButton btnlinkedin = (ImageButton) findViewById(R.id.btnlinkedin); 
        ImageButton btninsta = (ImageButton) findViewById(R.id.btninsta); 
        ImageButton btnface = (ImageButton) findViewById(R.id.btnface); 
        ImageButton btngithub = (ImageButton) findViewById(R.id.btngithub); 
        
            
        toolbar3.setBackgroundResource(R.color.black);
        txtversao.setTextColor(getResources().getColor(R.color.black));
        txtsobre.setTextColor(getResources().getColor(R.color.black));
        btnlinkedin.setImageResource(R.drawable.linkedin_dark);
        btninsta.setImageResource(R.drawable.instagram_dark);
        btnface.setImageResource(R.drawable.facebook_dark);
        btngithub.setImageResource(R.drawable.github_dark);
        
    }

}
