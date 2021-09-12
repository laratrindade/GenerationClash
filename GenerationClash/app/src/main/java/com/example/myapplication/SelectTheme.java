package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SelectTheme extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_theme);
        getSupportActionBar().hide();
    }

    public void PalavrasOnClick(View v){
        Intent intent = new Intent(this, PerguntaActivity.class);
        startActivity(intent);
    }

    public void ImagesOnClick(View v){
        Intent intent = new Intent(this, PerguntaImagemActivity.class);
        startActivity(intent);
    }

    public void DesportoOnClick(View v){
        Intent intent = new Intent(this, PerguntaDesportoActivity.class);
        startActivity(intent);
    }

    public void ProverbiosOnClick(View v){
        Intent intent = new Intent(this, PerguntaProverbioActivity.class);
        startActivity(intent);
    }
}
