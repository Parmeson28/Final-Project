package com.example.finalproject;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.ViewAnimator;

import androidx.appcompat.app.AppCompatActivity;

public class AppScreen extends AppCompatActivity {

    MainActivity main = new MainActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences sharedPreferences = getSharedPreferences("MinhasPreferencias", MODE_PRIVATE);

        // Recupera o dado. O segundo parâmetro ("") é o valor padrão se não encontrar nada.
        String usuarioLogado = sharedPreferences.getString("usuario_logado", "");


        Log.d("Nome", usuarioLogado);
        TextView userName = findViewById(R.id.tvUsername);
        userName.setText(usuarioLogado);

    }


}
