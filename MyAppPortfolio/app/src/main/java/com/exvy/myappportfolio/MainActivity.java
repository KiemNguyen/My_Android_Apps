package com.exvy.myappportfolio;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int duration = Toast.LENGTH_SHORT;
        final Context context = getApplicationContext();
        final CharSequence spotifyStreamerButtonToast = "This button will load my Spotify Streamer app!";
        final CharSequence footballScoresButtonToast = "This button will load my Scores app!";
        final CharSequence libraryButtonToast = "This button will load my Library app!";
        final CharSequence buildItBiggerButtonToast = "This button will load my Build It Bigger app!";
        final CharSequence xYZReaderButtonToast = "This button will load my XYZ Reader app!";
        final CharSequence capstoneButtonToast = "This button will load my Capstone app!";

        Button spotifyStreamerButton = (Button) findViewById(R.id.spotifyStreamerButton);
        spotifyStreamerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, spotifyStreamerButtonToast, duration).show();
            }
        });

        Button footballScoreButton = (Button) findViewById(R.id.footballScoresButton);
        footballScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, footballScoresButtonToast, duration).show();
            }
        });

        Button libraryButton = (Button) findViewById(R.id.libraryButton);
        libraryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, libraryButtonToast, duration).show();
            }
        });

        Button buildItBiggerButton = (Button) findViewById(R.id.buildItBiggerButton);
        buildItBiggerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, buildItBiggerButtonToast, duration).show();
            }
        });

        Button xYZReaderButton = (Button) findViewById(R.id.xYZReaderButton);
        xYZReaderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, xYZReaderButtonToast, duration).show();
            }
        });

        Button capstoneButton = (Button) findViewById(R.id.capstoneButton);
        capstoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, capstoneButtonToast, duration).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
