package com.exvy.hangdroid;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class GameOverActivity extends ActionBarActivity {

    int myPoints = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        int points = getIntent().getIntExtra("POINTS_IDENTIFIER", 0);

        TextView textViewPoints = (TextView) findViewById(R.id.textViewPoints);
        textViewPoints.setText(String.valueOf(points));

        myPoints = points;
    }

    //Method to when clicking Save button to save the scores from the view
    public void saveScores(View v) {
        SharedPreferences preferences = getSharedPreferences("MY SCORES", Context.MODE_PRIVATE);

        EditText editText = (EditText) findViewById(R.id.editTextName);

        String name = editText.getText().toString();

        SharedPreferences.Editor editor = preferences.edit();

        String previousScores = preferences.getString("SCORES","");

        editor.putString("SCORES",name + " " + myPoints + " POINTS\n" + previousScores);
        editor.commit();
        finish();

    }
}
