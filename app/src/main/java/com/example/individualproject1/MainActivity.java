package com.example.individualproject1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void GotoRegisterActivity(View view) {
        Intent intent = new Intent(this,Register.class);
        startActivity(intent);

    }

    public void GotoLoginActivity(View view) {
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);

    }
}