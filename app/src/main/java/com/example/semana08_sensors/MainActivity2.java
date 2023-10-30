package com.example.semana08_sensors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private TextView textview;
    private SensorManager sensorManager;
    private List<Sensor> deviceSensors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textview =findViewById(R.id.textView2);
        sensorManager= (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        deviceSensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        printSensors();
    }

    private void printSensors() {
        for (Sensor sensor : deviceSensors){
            textview.setText(textview.getText() + "\n" +sensor.getName());
        }

    }



}