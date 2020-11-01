package com.example.individualproject1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Register extends AppCompatActivity {
    EditText firstEt;
    EditText lastEt;
    EditText dobEt;
    EditText emailEt;
    EditText passEt;
    TextView Passworderrormessage;
    TextView firstnameerrormsg;
    TextView lastnameerrormsg;
    TextView doberrormsg;
    TextView emailerrormsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        firstEt=(EditText)findViewById(R.id.firstEditText);
        lastEt=(EditText)findViewById(R.id.lastEditText);
        dobEt=(EditText)findViewById(R.id.dobEditText);
        emailEt=(EditText)findViewById(R.id.emailEditText);
        passEt=(EditText)findViewById(R.id.passwordEditText);
        Passworderrormessage=(TextView)findViewById(R.id.errormessage);
        firstnameerrormsg=(TextView)findViewById(R.id.firstnameerrormsg);
        lastnameerrormsg=(TextView)findViewById(R.id.lastnameerrormsg);
        doberrormsg=(TextView)findViewById(R.id.doberrormsg);
        emailerrormsg=(TextView)findViewById(R.id.emaileerrormsg);
        firstEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()<3||s.length()>30)
                {
                    firstnameerrormsg.setVisibility(View.VISIBLE);
                }
                else
                {
                    firstnameerrormsg.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        lastEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()<3||s.length()>30)
                {
                    lastnameerrormsg.setVisibility(View.VISIBLE);
                }
                else
                {
                    lastnameerrormsg.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        dobEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(s.length()!=10)
            {
                doberrormsg.setVisibility(View.VISIBLE);
            }
            else
            {
                doberrormsg.setVisibility(View.INVISIBLE);
            }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        emailEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(s.length()<10||s.length()>50)
                {
                    emailerrormsg.setVisibility(View.VISIBLE);
                }
                else
                {
                    emailerrormsg.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        passEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() < 8) {
                    Passworderrormessage.setVisibility(View.VISIBLE);
                }
                else {
                    Passworderrormessage.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    public void GotoRegisterActivity(View view) {
        if(TextUtils.isEmpty(firstEt.getText().toString()))
        {
            Toast.makeText(this, "fill in first name", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(TextUtils.isEmpty(lastEt.getText().toString()))
        {
            Toast.makeText(this, "fill in last name", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(TextUtils.isEmpty(dobEt.getText().toString()))
        {
            Toast.makeText(this, "fill in date of birth", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(TextUtils.isEmpty(emailEt.getText().toString()))
        {
            Toast.makeText(this, "fill in email", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(TextUtils.isEmpty(passEt.getText().toString()))
        {
            Toast.makeText(this, "fill in password", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this,"Registration complete",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}