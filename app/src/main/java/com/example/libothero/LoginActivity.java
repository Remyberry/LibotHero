package com.example.libothero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private View btnContinueGuest, btnlogin;
    private EditText username, password;
    DatabaseHelper db;
    private View textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnContinueGuest = findViewById(R.id.buttonContinueAsGuest);
        btnlogin = findViewById(R.id.buttonLogin);
        textView = findViewById(R.id.toSignup);
        username = findViewById(R.id.Username);
        password = findViewById(R.id.Password);
        db = new DatabaseHelper(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the OtherActivity
                String user = username.getText().toString();
                String pw = password.getText().toString();
                Intent intent = new Intent(LoginActivity.this, LandingActivity.class);
                startActivity(intent);
                finish();

                /*if (user.equals("")||password.equals("")){
                    Toast.makeText(LoginActivity.this, "Invalid Info", Toast.LENGTH_SHORT).show();
                }else {
                    Boolean checklogin = db.checklogin(user,pw);
                    if (checklogin==true){

                    }else {
                        Toast.makeText(LoginActivity.this, "Invalid User or Password", Toast.LENGTH_SHORT).show();
                    }
                }*/
            }
        });

        btnContinueGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the OtherActivity
                String user = username.getText().toString();
                String pw = password.getText().toString();
                Intent intent = new Intent(LoginActivity.this, LandingActivity.class);
                startActivity(intent);
                finish();

                /*if (user.equals("")||password.equals("")){
                    Toast.makeText(LoginActivity.this, "Invalid Info", Toast.LENGTH_SHORT).show();
                }else {
                    Boolean checklogin = db.checklogin(user,pw);
                    if (checklogin==true){

                    }else {
                        Toast.makeText(LoginActivity.this, "Invalid User or Password", Toast.LENGTH_SHORT).show();
                    }
                }*/
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}