package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.TextView;

public class Errou extends AppCompatActivity {
    MediaPlayer musica;
    public static TextView resp_correta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_errou);
        getSupportActionBar().hide();
        if(MainActivity.mute == 0){
            musica = MediaPlayer.create(Errou.this, R.raw.res_errada);
            musica.start();
        }

        System.out.println("\nerrou activity : "+ TextQuestions.getCorrectAnswer(PerguntaActivity.randomint));
        System.out.println("\n????????? "+TextQuestions.answers[PerguntaActivity.randomint]);
        resp_correta = (TextView) findViewById(R.id.resp);
        resp_correta.setText(TextQuestions.answers[PerguntaActivity.randomint][TextQuestions.getCorrectAnswer(PerguntaActivity.randomint)-1]);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finish();
            }
        });
        thread.start();


    }
}
