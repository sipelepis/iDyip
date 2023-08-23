package com.example.idyip_mobilebasedfarecollectionsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class splash_page extends AppCompatActivity {
    Timer splash_timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_page2_layout);

        splash_timer = new Timer();
        splash_timer.schedule(new TimerTask(){
            @Override
            public void run(){
                Intent intent=  new Intent(splash_page.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

        }, 5000);
    }
}