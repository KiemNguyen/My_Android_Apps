package com.exvy.hangdroid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startSinglePlayerGame(View v) {
        Intent myIntent = new Intent(this, GameActivity.class);
        startActivity(myIntent);
    }

    public void startMultiPlayerGame(View v) {
        Intent myIntent = new Intent(this, MultiPlayerActivity.class);
        startActivity(myIntent);
    }

    public void openScores(View v) {
        Intent myIntent = new Intent(this, ScoreActivity.class);
        startActivity(myIntent);
    }

    public void displayScore(View v) {

    }

}
