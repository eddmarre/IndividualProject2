package com.example.individualproject1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LoginComplete extends AppCompatActivity {
    private static final int REQUEST_CODE_QUIZ=1;

    public static final String SHARED_PREFS="sharedPrefs";
    public static final String KEY_HIGHSCORE= "keyHighscore";


TextView textViewHighscore;
ImageView instructionsImageView;
TextView instructionsTextView;
TextView instructionsDescription;
Button understandButton;
Button playButton;
Button histroyButton;
Button backButton;

private int highscore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_complete);
        textViewHighscore=(TextView)findViewById(R.id.highscoreTextView);
        textViewHighscore.setVisibility(View.INVISIBLE);
        backButton=(Button)findViewById(R.id.BackButton);
        backButton.setVisibility(View.INVISIBLE);
        instructionsImageView=(ImageView)findViewById(R.id.instructionsBackGround);
        instructionsTextView=(TextView)findViewById(R.id.instructionsTextView);
        instructionsDescription=(TextView)findViewById(R.id.instructionsDescription);
        understandButton=(Button)findViewById(R.id.understandButton);
        playButton=(Button)findViewById(R.id.PlayButton);
        histroyButton=(Button)findViewById(R.id.historyButton);
        instructionsImageView.setVisibility(View.INVISIBLE);
        instructionsTextView.setVisibility(View.INVISIBLE);
        instructionsDescription.setVisibility(View.INVISIBLE);
        understandButton.setVisibility(View.INVISIBLE);
    }

    public void startGame(View view) {
        instructionsImageView.setVisibility(View.VISIBLE);
        instructionsTextView.setVisibility(View.VISIBLE);
        instructionsDescription.setVisibility(View.VISIBLE);
        understandButton.setVisibility(View.VISIBLE);
        playButton.setVisibility(View.INVISIBLE);
        histroyButton.setVisibility(View.INVISIBLE);
    }

    public void closeInstructionsMenu(View view) {
        Intent intent = new Intent(this,GameStarter.class);
        startActivityForResult(intent,REQUEST_CODE_QUIZ);
        instructionsImageView.setVisibility(View.INVISIBLE);
        instructionsTextView.setVisibility(View.INVISIBLE);
        instructionsDescription.setVisibility(View.INVISIBLE);
        understandButton.setVisibility(View.INVISIBLE);
        playButton.setVisibility(View.VISIBLE);
        histroyButton.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQUEST_CODE_QUIZ)
        {
            if(resultCode==RESULT_OK)
            {
                int score = data.getIntExtra(GameStarter.EXTRA_SCORE,0);
                if(score>highscore)
                {
                    updateHighscore(score);
                }
            }
        }
    }
    private void loadHighscore()
    {
        SharedPreferences prefs=getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        highscore=prefs.getInt(KEY_HIGHSCORE,0);
        textViewHighscore.setText("Highscore: "+ highscore);
    }
    private void updateHighscore(int highscoreNew)
    {
        highscore=highscoreNew;
        textViewHighscore.setText("Highscore: " +highscore);
        SharedPreferences prefs=getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE,highscore);
        editor.apply();
    }

    public void showHistory(View view) {
        playButton.setVisibility(View.INVISIBLE);
        histroyButton.setVisibility(View.INVISIBLE);
        instructionsImageView.setVisibility(View.VISIBLE);
        textViewHighscore.setVisibility(View.VISIBLE);
        backButton.setVisibility(View.VISIBLE);
        loadHighscore();
    }

    public void backButton(View view) {
        playButton.setVisibility(View.VISIBLE);
        histroyButton.setVisibility(View.VISIBLE);
        instructionsImageView.setVisibility(View.INVISIBLE);
        textViewHighscore.setVisibility(View.INVISIBLE);
        backButton.setVisibility(View.INVISIBLE);
    }
}