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
import com.khoaluan.Type.FanType;

public class FanSamsungControl extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fan_samsung_controll);
        MyMqttMain mqttMain = new MyMqttMain("Fan/Samsung");
        FileReader fileReader = new FileReader(this,R.raw.samsungfan);

        Intent FanType = new Intent(this, FanType.class);

        Button ON = (Button) findViewById(R.id.FanSamsungOn);
        Button Exit = (Button) findViewById(R.id.FanSamsungExit);
        Button FanSwing = (Button) findViewById(R.id.FanSamsungSwing);
        Button FanSpeed = (Button) findViewById(R.id.FanSamsungSpeed);

        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(FanType);
            }
        });
        ON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mqttMain.sendMqttMessage(fileReader.keyboard.get("ON/OFF"));
            }
        });
    }
}