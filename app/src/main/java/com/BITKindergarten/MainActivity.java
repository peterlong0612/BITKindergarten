package com.BITKindergarten;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.BITKindergarten.activity.ActivityChangeFilter;
import com.BITKindergarten.activity.ActivityChangeHue;
import com.BITKindergarten.activity.ActivityChangeRGBA;
import com.BITKindergarten.activity.ActivityColorMatrix;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_One).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ActivityColorMatrix.class));
            }
        });

        findViewById(R.id.btn_Two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ActivityChangeHue.class));
            }
        });

        findViewById(R.id.btn_Three).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ActivityChangeRGBA.class));
            }
        });

        findViewById(R.id.btn_Four).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ActivityChangeFilter.class));
            }
        });
    }
}
