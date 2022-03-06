package com.khoaluan.Control;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.khoaluan.FileReader;
import com.khoaluan.MyMqttMain;
import com.khoaluan.R;
import com.khoaluan.Type.TVType;

public class TVSamsungControl extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_samsung_control);
        MyMqttMain mqttMain = new MyMqttMain("TV/Samsung");
        FileReader fileReader = new FileReader(this,R.raw.samsungtv);

        Intent TVtype = new Intent(this, TVType.class);

        Button ON = (Button) findViewById(R.id.TVSamsungOn);
        Button Source = (Button) findViewById(R.id.TVSamsungSource);
        Button Exit = (Button) findViewById(R.id.TVSamsungExit);
        Button N1 = (Button) findViewById(R.id.TVSamsung1);
        Button N2 = (Button) findViewById(R.id.TVSamsung2);
        Button N3 = (Button) findViewById(R.id.TVSamsung3);
        Button N4 = (Button) findViewById(R.id.TVSamsung4);
        Button N5 = (Button) findViewById(R.id.TVSamsung5);
        Button N6 = (Button) findViewById(R.id.TVSamsung6);
        Button N7 = (Button) findViewById(R.id.TVSamsung7);
        Button N8 = (Button) findViewById(R.id.TVSamsung8);
        Button N9 = (Button) findViewById(R.id.TVSamsung9);
        Button Up = (Button) findViewById(R.id.TVSamsungUp);
        Button Down = (Button) findViewById(R.id.TVSamsungDown);
        Button Left = (Button) findViewById(R.id.TVSamsungLeft);
        Button Right = (Button) findViewById(R.id.TVSamsungRight);
        Button VolumeUp = (Button) findViewById(R.id.TVSamsungVolumeUp);
        Button VolumeDown = (Button) findViewById(R.id.TVSamsungVolumeDown);

        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                mqttMain.mqttDisconnect();
                startActivity(TVtype);
            }
        });
        ON.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                try {
                    mqttMain.sendMqttMessage(fileReader.keyboard.get("ON/OFF"));
                }catch (Exception e){
                    System.out.print(e);
                }
            }
        });
        Source.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                try {
                    mqttMain.sendMqttMessage(fileReader.keyboard.get("SOURCE"));
                }catch (Exception e){
                    System.out.print(e);
                }
            }
        });
    }
}