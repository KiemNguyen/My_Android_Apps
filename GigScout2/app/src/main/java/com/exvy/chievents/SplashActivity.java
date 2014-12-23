package com.exvy.chievents;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import com.exvy.chievents.R;
import com.parse.Parse;

public class SplashActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "V7OMSnyT3oXVS1Ta4M2yKBd2h1zzKx0fOVhvpJko", "mtbPZE0Jyg8aXdRHa8QXI78aJvWlThu3g6cHsdcV");

        //Thread to wait 3 second before going to MainActivity
        Runnable runnable3secs = new Runnable() {
            @Override
            public void run() {
                goToMainActivity();
                finish();
            }
        };

        Handler myHandler = new Handler();
        myHandler.postDelayed(runnable3secs, 3000);
    }


    public void goToMainActivity() {
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }
}