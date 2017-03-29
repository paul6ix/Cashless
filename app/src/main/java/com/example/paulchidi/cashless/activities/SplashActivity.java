package com.example.paulchidi.cashless.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.paulchidi.cashless.R;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread splash = new Thread(){
            public void run() {
                try {
                    sleep(3*1000);
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);


                }
                catch (Exception e){
                    //TODO
                }
            }
        };
        splash.start();


    }
}
