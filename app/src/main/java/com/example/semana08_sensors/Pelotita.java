package com.example.semana08_sensors;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

public class Pelotita extends View implements SensorEventListener {
    Paint pincel = new Paint();
    int alto, ancho, tamano=55, borde=12;
    float ejeX=0, ejeY=0, ejeZ=0;
    String X, Y , Z;

    public Pelotita(Context interfaz){
        super(interfaz);
        SensorManager smAdministrador=(SensorManager) getContext().getSystemService(Context.SENSOR_SERVICE);
        Sensor snsRotacion = smAdministrador.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        smAdministrador.registerListener(this, snsRotacion, SensorManager.SENSOR_DELAY_GAME);
        Display pantalla = ((WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        ancho=pantalla.getWidth();
        alto=pantalla.getHeight();
    }


    @Override
    public void onSensorChanged(SensorEvent cambio) {
        ejeX-=cambio.values[0];
        X=Float.toString(ejeX);
        if(ejeX<(tamano+borde)){
            ejeX=tamano+borde;
        }
        else if(ejeX>(ancho-(tamano+borde))){
            ejeX=ancho-(tamano+borde);
        }
        ejeY+=cambio.values[1];
        Y=Float.toString(ejeY);
        if(ejeY<(tamano+borde)){
            ejeY=(tamano+borde);
        }
        else if(ejeY>(alto-tamano-170)){
            ejeY=alto-tamano-170;
        }
        ejeZ=cambio.values[2];
        Z=String.format("%.2f", ejeZ);
        invalidate();

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}

    @Override
    public void onDraw(Canvas lienzo) {
        pincel.setColor((Color.RED));
        lienzo.drawCircle(ejeX, ejeY, ejeZ+tamano, pincel);
        pincel.setColor(Color.WHITE);
        pincel.setTextSize(25);
        lienzo.drawText("EEEE", ejeX-35, ejeY+3,pincel);
    }

}
