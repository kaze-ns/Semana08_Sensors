package com.example.semana08_sensors;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnListaSensors;
    Button btnAproximaSensors;
    Button btnAcelerometroSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnListaSensors = (Button) findViewById(R.id.btnlistasensors);
        btnListaSensors.setOnClickListener(w -> implicito());

        btnAproximaSensors = (Button) findViewById(R.id.btnaproximasensor);
        btnAproximaSensors.setOnClickListener(w -> aproxima());

        btnAcelerometroSensor = (Button) findViewById(R.id.btnacelerometrosensor);
        btnAcelerometroSensor.setOnClickListener(w -> acelerometro());

    }

    public void implicito(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    public void aproxima(){
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }

    public void acelerometro(){
        Intent intent = new Intent(this, MainActivity4.class);
        startActivity(intent);
    }


  }