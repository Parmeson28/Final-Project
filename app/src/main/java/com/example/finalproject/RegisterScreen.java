package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterScreen extends AppCompatActivity {
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

        TextView tcp = findViewById(R.id.etPasswordConfirm);
        String confirmPassword = tcp.getText().toString();


        if(user.equals("") || email.equals("") || cpf.equals("") || password.equals("")){
            Toast.makeText(RegisterScreen.this, "Os campos não foram preenchidos corretamente", Toast.LENGTH_LONG).show();
        }else{
            if(confirmPassword.equals(password)){
                Boolean insert = db.insertData(email, password, user, cpf);

            }else {
                Toast.makeText(RegisterScreen.this, "Senha está incorreta", Toast.LENGTH_SHORT).show();
            }


        }

    }

}
