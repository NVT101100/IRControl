package com.khoaluan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.khoaluan.Type.FanType;
import com.khoaluan.Type.TVType;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent TVTypeActivity = new Intent(this, TVType.class);
        final Intent FanTypeActivity = new Intent(this, FanType.class);

        final View Home = findViewById(R.id.Home);

        final LinearLayout TV = (LinearLayout) findViewById(R.id.TVTouch);
        final LinearLayout Fan = (LinearLayout) findViewById(R.id.FanTouch);

        TV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(TVTypeActivity);
            }
        });
        Fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(FanTypeActivity);
            }
        });
    }
}