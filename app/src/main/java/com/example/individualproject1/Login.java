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

public class Login extends AppCompatActivity {
    EditText usernameet;
    EditText passwordet;
    TextView usernameerrormsg;
    TextView passworderrormsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameet=(EditText)findViewById(R.id.usernameEditText);
        passwordet=(EditText)findViewById(R.id.passwordEditText);
        usernameerrormsg=(TextView)findViewById(R.id.usererrormsg);
        passworderrormsg=(TextView)findViewById(R.id.passworderrormsg);
        usernameet.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()<10||s.length()>50)
                {
                    usernameerrormsg.setVisibility(View.VISIBLE);
                }
                else
                {
                    usernameerrormsg.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        passwordet.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() < 8) {
                    passworderrormsg.setVisibility(View.VISIBLE);
                }
                else {
                    passworderrormsg.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void GotoLoginActivity(View view) {
        if(TextUtils.isEmpty(usernameet.getText().toString()))
        {
            Toast.makeText(this, "login error fill in username", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(TextUtils.isEmpty(passwordet.getText().toString()))
        {
            Toast.makeText(this, "login error fill in password", Toast.LENGTH_SHORT).show();
            return;
        }
        
        String sampleemail="random@gmail.com";
        String samplepassword="123456789";
        String currentemail=usernameet.getText().toString();
        String currentpassword=passwordet.getText().toString();
        if(sampleemail.equals(currentemail) && samplepassword.equals(currentpassword))
        {
            Toast.makeText(this, "Login success", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,LoginComplete.class);
            startActivity(intent);
            finish();
        }
        else
        {
            Toast.makeText(this, "Invalid login", Toast.LENGTH_SHORT).show();
        }
        
    }
}