package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

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

    public void ImagensOnClick(View v){
        Intent intent = new Intent(this, PerguntaImagemActivity.class);
        startActivity(intent);
        System.out.println("stop");
    }

    public void DesportoOnClick(View v){
        Intent intent = new Intent(this, PerguntaActivity.class);
        startActivity(intent);
    }
}
