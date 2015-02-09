package com.exvy.hangdroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class GameMultiActivity extends ActionBarActivity {
    String myWord;

    int failCounter = 0;

    //Variable to count how many time user guess a letter
    int guessLetters = 0;

    //Variable to keep track of points
    int myPoints = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_game);

        String wordSent = getIntent().getStringExtra("INPUT_WORD");

        Log.d("MYLOG", "The word is: " + wordSent);

        myWord = wordSent.toLowerCase();

        createTextViews(wordSent);
    }

    //Method to get letter in the editText
    public void introduceLetter(View v) {
        EditText myEditText = (EditText) findViewById(R.id.editTextLetter);
        String letter = myEditText.getText().toString();

        myEditText.setText("");

        Log.d("MYLOG", "Letter is: " + letter);

        if (letter.length() == 1) {
            checkLetter(letter.toLowerCase());
        } else {
            Toast.makeText(this, "Please type in a letter", Toast.LENGTH_SHORT).show();
        }

    }

    //Method to check if the letter is matched
    public void checkLetter(String introducedLetter) {
        char charIntroduced = introducedLetter.charAt(0);

        boolean letterGuessed = false;

        for (int i = 0; i < myWord.length(); i++) {
            char charFromTheWord = myWord.charAt(i);

            Log.d("MYLOG", "The letter we're checking is: " + charFromTheWord);

            if (charFromTheWord == charIntroduced) {
                Log.d("MYLOG", "There is a match");
                letterGuessed = true;
                showLetter(i, myWord.charAt(i));

                //Increase guess counter
                guessLetters++;
            }
        }

        if (letterGuessed == false) {
            letterFailed(Character.toString(charIntroduced));
        }

        if (guessLetters == myWord.length()) {
            finish();
        }
    }

    public void createTextViews(String word) {

        LinearLayout layoutLetters = (LinearLayout) findViewById(R.id.layoutLetters);

        //Create dynamic TextView for every single word
        for (int i = 0; i < word.length(); i++) {
            TextView dynamicTextView = (TextView) getLayoutInflater().inflate(R.layout.dynamictextview, null);

            layoutLetters.addView(dynamicTextView);
        }

    }

    public void clearScreen() {
        TextView textViewOnLeft = (TextView) findViewById(R.id.textViewOnLeft);
        textViewOnLeft.setText("");

        guessLetters = 0;
        failCounter = 0;

        //Clear the letter in textView in layoutLetter
        LinearLayout layoutLetters = (LinearLayout) findViewById(R.id.layoutLetters);
        for (int i = 0; i < layoutLetters.getChildCount(); i++) {
            TextView currentTextView = (TextView) layoutLetters.getChildAt(i);
            currentTextView.setText("_");
        }

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.hangdroid_0);
    }

    //When guessing the wrong letter
    public void letterFailed(String letterFailed){
        //Display failed letter on the left

        TextView textViewOnLeft = (TextView) findViewById(R.id.textViewOnLeft);

        String previousFail = textViewOnLeft.getText().toString();

        textViewOnLeft.setText(previousFail+letterFailed);


        failCounter++;
        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        if (failCounter == 1) {
            imageView.setImageResource(R.drawable.hangdroid_1);
        } else if (failCounter == 2) {
            imageView.setImageResource(R.drawable.hangdroid_2);
        } else if (failCounter == 3) {
            imageView.setImageResource(R.drawable.hangdroid_3);
        } else if (failCounter == 4) {
            imageView.setImageResource(R.drawable.hangdroid_4);
        } else if (failCounter == 5) {
            imageView.setImageResource(R.drawable.hangdroid_5);
        } else if (failCounter == 6) {
            //Go to GameOverActivity
            Intent gameOverIntent = new Intent(this, GameOverActivity.class);

            //Send over value of myPoints to GameOverActivity
            gameOverIntent.putExtra("POINTS_IDENTIFIER", myPoints);

            startActivity(gameOverIntent);
        }

    }

    //Displayed the guessed letter
    public void showLetter(int position, char letterGuessed) {
        LinearLayout  layoutLetter = (LinearLayout) findViewById(R.id.layoutLetters);
        TextView textView = (TextView) layoutLetter.getChildAt(position);
        textView.setText(Character.toString(letterGuessed));
    }
}