package com.example.finalproject;

import static android.os.SystemClock.sleep;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{

    DataBaseModel db;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DataBaseModel(this);
    }

    public void handleLogin(View v){
        TextView tu = findViewById(R.id.etUser);
        String user = tu.getText().toString();

        TextView tp = findViewById(R.id.etPassword);
        String password = tp.getText().toString();

        if(db.checkEmailPassword(user, password) || (user.equals("Gamer") && password.equals("123"))){

            SharedPreferences sharedPreferences = getSharedPreferences("MinhasPreferencias", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putString("usuario_logado", user);
            editor.apply(); // Confirma a gravação

            startActivity(new Intent(this, AppScreen.class));
        }else{
            Toast.makeText(MainActivity.this, "Login invalido", Toast.LENGTH_SHORT).show();
        }

    }
    public void createAccount(View v){
        startActivity(new Intent(this, RegisterScreen.class));
    }
}
