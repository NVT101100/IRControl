package com.khoaluan.Type;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.khoaluan.Control.TVSamsungControl;
import com.khoaluan.MainActivity;
import com.khoaluan.R;

public class FanType extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fan_type);
        Intent Home = new Intent(this, MainActivity.class);
        Intent FanSamsungControl = new Intent(this, com.khoaluan.Control.FanSamsungControl.class);

        final TextView FanSamsung = (TextView) findViewById(R.id.FanSamsung);
        final TextView FanSony = (TextView) findViewById(R.id.FanSony);
        final TextView FanExit = (TextView) findViewById(R.id.FanExit);

        FanExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(Home);
            }
        });
        FanSamsung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(FanSamsungControl);
            }
        });
    }
}