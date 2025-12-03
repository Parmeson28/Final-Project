package com.example.finalproject;

import static android.os.SystemClock.sleep;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handleLogin(View v){
        TextView tu = findViewById(R.id.etUser);
        String user = tu.getText().toString();

        TextView tp = findViewById(R.id.etPassword);
        String password = tp.getText().toString();

        if(user.equals("Gamer") && password.equals("123")){
            startActivity(new Intent(this, AppScreen.class));
        }
    }
    public void createAccount(View v){
        startActivity(new Intent(this, RegisterScreen.class));
    }
}
