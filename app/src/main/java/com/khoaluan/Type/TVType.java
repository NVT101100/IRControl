package com.khoaluan.Type;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.khoaluan.Control.TVSamsungControl;
import com.khoaluan.MainActivity;
import com.khoaluan.R;

public class TVType extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tvtype);
        Intent Home = new Intent(this, MainActivity.class);
        Intent TVSamsungControl = new Intent(this, TVSamsungControl.class);

        final TextView Samsung = (TextView) findViewById(R.id.TVSamsung);
        final TextView Sony = (TextView) findViewById(R.id.TVSony);
        final TextView TVExit = (TextView) findViewById(R.id.TVExit);

        TVExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(Home);
            }
        });
        Samsung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(TVSamsungControl);
            }
        });
    }
}