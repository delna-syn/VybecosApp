package com.example.vybecosapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vybecosapp.R;
import com.example.vybecosapp.Rest.PrefManager;

public class SplashActivity extends AppCompatActivity {
    Handler handler;
    PrefManager prefManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        prefManager = new PrefManager(SplashActivity.this);
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(prefManager.IsFirstLogin()){
                    Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(i);

                }
                else {
                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(i);
                }
                finish();
            }
        },3000);
    }
}
