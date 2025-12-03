package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterScreen extends AppCompatActivity {

    EditText etName, etEmail, etCpf, etPassword, etRepassword;
    DataBaseModel db;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void handleRegister(View v){
        TextView tu = findViewById(R.id.etFullName);
        String user = tu.getText().toString();

        TextView te = findViewById(R.id.etEmail);
        String email = te.getText().toString();

        TextView tcpf = findViewById(R.id.etCpf);
        String cpf = tcpf.getText().toString();

        TextView tp = findViewById(R.id.etPassword);
        String password = tp.getText().toString();

        TextView tcp = findViewById(R.id.etPassword);
        String confirmPassword = tp.getText().toString();

        if(confirmPassword.equals(password)){
            password = confirmPassword;
        }else {
            Log.d("Senha errada", "Senha errada");
        }

    }

}
