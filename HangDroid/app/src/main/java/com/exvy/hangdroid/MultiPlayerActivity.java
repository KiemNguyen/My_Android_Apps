package com.exvy.hangdroid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MultiPlayerActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_player);
    }

    //Method for the Play button
    public void startMultiGame(View v) {
        EditText editText = (EditText) findViewById(R.id.editTextWord);
        String userInput = editText.getText().toString();

        editText.setText("");

        Intent myIntent = new Intent(this, GameMultiActivity.class);

        //Send data between Activites using putExtra
        myIntent.putExtra("INPUT_WORD", userInput);

        startActivity(myIntent);
    }

}
