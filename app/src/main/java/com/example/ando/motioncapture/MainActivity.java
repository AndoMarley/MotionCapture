package com.example.ando.motioncapture;

import android.app.Service;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.*;
import android.widget.*;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    public Spinner spinner;
    public Spinner spinnerII;

    ArrayAdapter<CharSequence> adapter;

    private Sensor mAccelerometer;
    private SensorManager manager;
    //private boolean accelSupported;
    public TextView xText;
    public TextView yText;
    public TextView zText;
    public String sensorType;
    public String acm;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (SensorManager) getSystemService(Service.SENSOR_SERVICE);
        mAccelerometer = manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        xText = (TextView)findViewById(R.id.xlab);
        yText = (TextView)findViewById(R.id.ylab);
        zText = (TextView)findViewById(R.id.zlab);
        ToggleButton demarrer = (ToggleButton)findViewById(R.id.toggleButton);


        // Spinner1
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        adapter = ArrayAdapter.createFromResource(this,R.array.select_sensor,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0)
                {
                    sensorType=acm;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //Spinner2
        Spinner spinnerII = (Spinner) findViewById(R.id.spinner2);
        adapter = ArrayAdapter.createFromResource(this,R.array.mode,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerII.setAdapter(adapter);
        spinnerII.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void onResume (){
        super.onResume();
        manager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_GAME);

    }

    public void onPause(){
        super.onPause();
        //if (accelSupported)
        manager.unregisterListener(this, mAccelerometer);
    }




    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        xText.setText("X: " + sensorEvent.values[0]);
        yText.setText("X: " + sensorEvent.values[1]);
        zText.setText("X: " + sensorEvent.values[2]);


    }


}
