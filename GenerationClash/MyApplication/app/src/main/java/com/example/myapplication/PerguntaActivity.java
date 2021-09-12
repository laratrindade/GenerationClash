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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_pergunta);

        this.questions = new TextQuestions();
        Random random = new Random();
        score_keeper = 0;
        pergunta_keeper=1;
        randomint = random.nextInt(questions.questions.length);
        questionLabel = (TextView)findViewById(R.id.question_text);
        score = (TextView)findViewById(R.id.list);
        perg = (TextView)findViewById(R.id.pergunta);
        A = (Button)findViewById(R.id.A);
        B = (Button)findViewById(R.id.B);
        C = (Button)findViewById(R.id.C);
        D = (Button)findViewById(R.id.D);

        score.setText("Pontuação:" +Integer.toString(score_keeper));
        perg.setText(pergunta_keeper + "\\10");

        questionLabel.setText(questions.getQuestion(randomint));
        A.setText(questions.getchoice1(randomint));
        B.setText(questions.getchoice2(randomint));
        C.setText(questions.getchoice3(randomint));
        D.setText(questions.getchoice4(randomint));
    }

    private void remove_question( int index) {
        if (this.questions.questions == null || index < 0 || index >= this.questions.questions.length) {
            return;
        }
        String[] result = new String[this.questions.questions.length - 1];
        System.arraycopy(this.questions.questions, 0, result, 0, index);
        System.arraycopy(this.questions.questions, index + 1, result, index, this.questions.questions.length - index - 1);
        this.questions.questions = result;
    }

    private void remove_answers( int index) {
        if (this.questions.answers == null || index < 0 || index >= this.questions.answers.length) {
            return;
        }
        String[][] result = new String[this.questions.answers.length - 1][];
        System.arraycopy(this.questions.answers, 0, result, 0, index);
        System.arraycopy(this.questions.answers, index + 1, result, index, this.questions.answers.length - index - 1);
        this.questions.answers = result;
    }

    private void remove_correctAnswer( int index) {
        if (this.questions.correctAnswer == null || index < 0 || index >= this.questions.correctAnswer.length) {
            return;
        }
        int[] result = new int[this.questions.correctAnswer.length - 1];
        System.arraycopy(this.questions.correctAnswer, 0, result, 0, index);
        System.arraycopy(this.questions.correctAnswer, index + 1, result, index, this.questions.correctAnswer.length - index - 1);
        this.questions.correctAnswer = result;
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        getSupportActionBar().hide();

        remove_question(randomint);
        remove_answers(randomint);
        remove_correctAnswer(randomint);

        if (questions.questions.length == 0) {
            setContentView(R.layout.activity_score);
            questionLabel = (TextView)findViewById(R.id.list);
            questionLabel.setText("Jogadores:\n\n" + MainActivity.actual_player + "\n\nPontuação: " + Integer.toString(score_keeper));
        }
        else {
            Random random = new Random();
            randomint = random.nextInt(questions.questions.length);
            System.out.println("randomint Pergunta activity: "+ randomint);
            questionLabel = (TextView) findViewById(R.id.question_text);
            score = (TextView) findViewById(R.id.list);
            A = (Button) findViewById(R.id.A);
            B = (Button) findViewById(R.id.B);
            C = (Button) findViewById(R.id.C);
            D = (Button) findViewById(R.id.D);

            score.setText("Pontuação: " + Integer.toString(score_keeper));
            perg = (TextView)findViewById(R.id.pergunta);
            perg.setText(pergunta_keeper + "\\10");



            questionLabel.setText(questions.getQuestion(randomint));
            A.setText(questions.getchoice1(randomint));
            B.setText(questions.getchoice2(randomint));
            C.setText(questions.getchoice3(randomint));
            D.setText(questions.getchoice4(randomint));
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
        if(questions.getCorrectAnswer(randomint) == 1){
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
        if(questions.getCorrectAnswer(randomint) == 2){
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
        if(questions.getCorrectAnswer(randomint) == 3){
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
        if(questions.getCorrectAnswer(randomint) == 4){
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