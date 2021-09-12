package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class PerguntaActivity extends AppCompatActivity {

    private TextView questionLabel;
    private Button A;
    private Button B;
    private Button C;
    private Button D;
    private TextView score;
    private TextView perg;
    public static TextQuestions questions;
    public static int score_keeper;
    public static int pergunta_keeper;
    public static int randomint;

    public static int aux;
    public static String [] q = new String [7];
    public static String [][] an = new String [7][];
    public static int [] ca = new int [7];


    public String getQuestion(int a){
        return q[a];
    }

    public String getchoice1(int a){
        return an[a][0];
    }

    public String getchoice2(int a){
        return an[a][1];
    }

    public String getchoice3(int a){
        return an[a][2];
    }

    public String getchoice4(int a){
        return an[a][3];
    }

    public static int getCorrectAnswer(int a){
        return ca[a];
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_pergunta);
        this.questions = new TextQuestions();

        q = questions.questions.clone();
        an = questions.answers.clone();
        ca = questions.correctAnswer.clone();

        Random random = new Random();
        score_keeper = 0;
        pergunta_keeper=1;
        aux=1;

        System.out.println(" entrei no onCreate........." + q.length);

        randomint = random.nextInt(q.length);
        questionLabel = (TextView)findViewById(R.id.question_text);
        score = (TextView)findViewById(R.id.list);
        perg = (TextView)findViewById(R.id.pergunta);
        A = (Button)findViewById(R.id.A);
        B = (Button)findViewById(R.id.B);
        C = (Button)findViewById(R.id.C);
        D = (Button)findViewById(R.id.D);

        score.setText("Pontuação: " +Integer.toString(score_keeper));
        perg.setText(pergunta_keeper + "\\5");

        questionLabel.setText(getQuestion(randomint));
        A.setText(getchoice1(randomint));
        B.setText(getchoice2(randomint));
        C.setText(getchoice3(randomint));
        D.setText(getchoice4(randomint));
    }

    private void remove_question( int index) {
        if (this.q == null || index < 0 || index >= this.q.length) {
            return;
        }
        String[] result = new String[this.q.length - 1];
        System.arraycopy(this.q, 0, result, 0, index);
        System.arraycopy(this.q, index + 1, result, index, this.q.length - index - 1);
        this.q = result;
    }

    private void remove_answers( int index) {
        if (this.an == null || index < 0 || index >= this.an.length) {
            return;
        }
        String[][] result = new String[this.an.length - 1][];
        System.arraycopy(this.an, 0, result, 0, index);
        System.arraycopy(this.an, index + 1, result, index, this.an.length - index - 1);
        this.an = result;
    }

    private void remove_correctAnswer( int index) {
        if (this.ca == null || index < 0 || index >= this.ca.length) {
            return;
        }
        int[] result = new int[this.ca.length - 1];
        System.arraycopy(this.ca, 0, result, 0, index);
        System.arraycopy(this.ca, index + 1, result, index, this.ca.length - index - 1);
        this.ca = result;
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        getSupportActionBar().hide();

        remove_question(randomint);
        remove_answers(randomint);
        remove_correctAnswer(randomint);
        System.out.println("/n---->aux: "+ aux);
        // if (q.length == 0) {
        if (aux==5) {
            setContentView(R.layout.activity_score);
            questionLabel = (TextView)findViewById(R.id.list);
            questionLabel.setText("Jogadores:\n\n" + MainActivity.actual_player + "\n\nPontuação: " + Integer.toString(score_keeper));
        }
        else {
            Random random = new Random();
            randomint = random.nextInt(q.length);
            System.out.println("randomint Pergunta activity: "+ randomint);
            questionLabel = (TextView) findViewById(R.id.question_text);

            A = (Button) findViewById(R.id.A);
            B = (Button) findViewById(R.id.B);
            C = (Button) findViewById(R.id.C);
            D = (Button) findViewById(R.id.D);

            score = (TextView) findViewById(R.id.list);
            score.setText("Pontuação: " + Integer.toString(score_keeper));
            perg = (TextView)findViewById(R.id.pergunta);
            perg.setText(pergunta_keeper + "\\5");

            questionLabel.setText(getQuestion(randomint));
            A.setText(getchoice1(randomint));
            B.setText(getchoice2(randomint));
            C.setText(getchoice3(randomint));
            D.setText(getchoice4(randomint));
            aux++;
        }
    }

    public void onClickMenu(View V){
        String str = MainActivity.actual_player;
        MainActivity.score = score_keeper;

        if(MainActivity.leaderboard.get(str)!=null) {//se ja existir esse player
            if (score_keeper > MainActivity.leaderboard.get(str))//novo score > antigo atualizamos
                MainActivity.leaderboard.put(str, score_keeper);
        }
        else
            MainActivity.leaderboard.put(str, score_keeper);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onClickFinish(View V){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    public void onClickButtonA(View V){
        pergunta_keeper++;
        if(getCorrectAnswer(randomint) == 1){
            score_keeper++;
            Intent intent = new Intent(this, Acertou.class);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(this, Errou.class);
            startActivity(intent);
        }
    }

    public void onClickButtonB(View V){
        pergunta_keeper++;
        if(getCorrectAnswer(randomint) == 2){
            score_keeper++;
            Intent intent = new Intent(this, Acertou.class);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(this, Errou.class);
            startActivity(intent);
        }
    }

    public void onClickButtonC(View V){
        pergunta_keeper++;
        if(getCorrectAnswer(randomint) == 3){
            score_keeper++;
            Intent intent = new Intent(this, Acertou.class);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(this, Errou.class);
            startActivity(intent);
        }
    }

    public void onClickButtonD(View V){
        pergunta_keeper++;
        if(getCorrectAnswer(randomint) == 4){
            score_keeper++;
            Intent intent = new Intent(this, Acertou.class);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(this, Errou.class);
            startActivity(intent);
        }
    }
}