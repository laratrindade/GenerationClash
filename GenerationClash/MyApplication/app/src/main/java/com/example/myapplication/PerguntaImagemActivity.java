package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class PerguntaImagemActivity extends AppCompatActivity {

    private TextView questionLabel;
    private Button A;
    private Button B;
    private Button C;
    private Button D;
    private TextView score;
    private ImageQuestions questions;
    private ImageView image;
    public static int score_keeper;
    private int randomint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_pergunta_imagem);

        this.questions = new ImageQuestions();
        Random random = new Random();
        score_keeper = 0;

        randomint = random.nextInt(questions.questions.length);

        image = (ImageView) findViewById(R.id.question_image);
        questionLabel = (TextView)findViewById(R.id.question_text);
        score = (TextView)findViewById(R.id.list);
        A = (Button)findViewById(R.id.A);
        B = (Button)findViewById(R.id.B);
        C = (Button)findViewById(R.id.C);
        D = (Button)findViewById(R.id.D);


        questionLabel.setText(questions.getQuestion(randomint));
        A.setText(questions.getchoice1(randomint));
        B.setText(questions.getchoice2(randomint));
        C.setText(questions.getchoice3(randomint));
        D.setText(questions.getchoice4(randomint));
        switch (questions.getImage(randomint)){
            case 1:
                image.setImageResource(R.drawable.charrua);
                break;
            case 2:
                image.setImageResource(R.drawable.mota);
                break;
            default:
                break;
        }

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

    private void remove_image( int index) {
        if (this.questions.images == null || index < 0 || index >= this.questions.images.length) {
            return;
        }
        int[] result = new int[this.questions.images.length - 1];
        System.arraycopy(this.questions.images, 0, result, 0, index);
        System.arraycopy(this.questions.images, index + 1, result, index, this.questions.images.length - index - 1);
        this.questions.images = result;
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        getSupportActionBar().hide();

        remove_question(randomint);
        remove_answers(randomint);
        remove_correctAnswer(randomint);
        remove_image(randomint);
        if (questions.questions.length == 0) {
            setContentView(R.layout.activity_score);
            questionLabel = (TextView)findViewById(R.id.list);
            questionLabel.setText("Player: " + MainActivity.actual_player + "\nScore: " + Integer.toString(score_keeper));

        }
        else {
            Random random = new Random();
            randomint = random.nextInt(questions.questions.length);
            questionLabel = (TextView) findViewById(R.id.question_text);
            image = (ImageView) findViewById(R.id.question_image);
            score = (TextView) findViewById(R.id.list);
            A = (Button) findViewById(R.id.A);
            B = (Button) findViewById(R.id.B);
            C = (Button) findViewById(R.id.C);
            D = (Button) findViewById(R.id.D);

            score.setText("Score: " + Integer.toString(score_keeper));
            questionLabel.setText(questions.getQuestion(randomint));
            A.setText(questions.getchoice1(randomint));
            B.setText(questions.getchoice2(randomint));
            C.setText(questions.getchoice3(randomint));
            D.setText(questions.getchoice4(randomint));

            switch (questions.getImage(randomint)){
                case 1:
                    image.setImageResource(R.drawable.charrua);
                    break;
                case 2:
                    image.setImageResource(R.drawable.mota);
                    break;
                default:
                    break;
            }
        }

    }

    public void onClickMenu(View V){
        String str = MainActivity.actual_player;
        MainActivity.score = score_keeper;
        MainActivity.leaderboard.put(str,score_keeper);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onClickFinish(View V){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    public void onClickButtonA(View V){
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
