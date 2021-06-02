package com.example.validationform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText email,pwd;
    Button login;
    boolean isEmailValid, isPasswordValid;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private static final Pattern pwdPattern =
            Pattern.compile("^" +
                    "(?=.*[@#$%^&+=])" +     // at least 1 special character
                    "(?=\\S+$)" +            // no white spaces
                    ".{4,}" +                // at least 4 characters
                    "$");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login= findViewById(R.id.login);
        email = findViewById(R.id.email);
        pwd=findViewById(R.id.password);
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(email.getText().toString().isEmpty()) {
                        email.setError("Field can't be empty");
                        isEmailValid=false;
                    }else {
                        if (email.getText().toString().trim().matches(emailPattern)) {
                            email.setError("Enter valid Email address");
                            email.setError(null);
                            isEmailValid=true;
                        } else {
                            email.setError("Invalid Email address");
                            isEmailValid=false;
                        }
                    }
                    if(pwd.getText().toString().isEmpty()){
                        pwd.setError("Field can't ne empty");
                        isPasswordValid=false;
                    }
                    else if(!pwdPattern.matcher(pwd.getText().toString()).matches()) {
                        pwd.setError(" Atleast use 4 characters and one special character  ");
                        isPasswordValid=false;
                    } else {

                        pwd.setError(null);
                        isPasswordValid=true;
                    }
                    if (isEmailValid && isPasswordValid) {
                        Toast.makeText(getApplicationContext(), "Successfully LOGIN", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(), "Invalid", Toast.LENGTH_SHORT).show();
                    }
                    }


            }
            );



    }

    }



