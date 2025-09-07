package com.example.libothero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    private View signmeup;
    private EditText email, username, phone, bday, password, confirmpass;
    private CheckBox eula;
    private View textView;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        email = findViewById(R.id.email);
        username = findViewById(R.id.username);
        phone = findViewById(R.id.phone);
        bday = findViewById(R.id.bday);
        password = findViewById(R.id.password);
        confirmpass = findViewById(R.id.confirmpass);
        eula = findViewById(R.id.eula);
        signmeup = findViewById(R.id.SignMeUp);
        textView = findViewById(R.id.toLogin);
        db = new DatabaseHelper(this);

        signmeup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the OtherActivity
                String emaill = email.getText().toString();
                String user = username.getText().toString();
                String pw = password.getText().toString();
                String cpw = confirmpass.getText().toString();
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);

                /*if (emaill.equals("")||user.equals("")||pw.equals("")||cpw.equals("")){
                    Toast.makeText(SignUpActivity.this, "Please fill the form.", Toast.LENGTH_SHORT).show();
                }else {
                    if (pw.equals(cpw)){
                        Boolean checkuser = db.checkUser(user);
                        if (checkuser==false){
                            Boolean add = db.addAccount(emaill,user,pw);
                            if (add==true){
                                Toast.makeText(SignUpActivity.this, "You're now Signed Up!", Toast.LENGTH_SHORT).show();
                        finish();*//*
                            }
                        }
                    }
                }*/


            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}