package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Hashtable;



public class MainActivity extends AppCompatActivity {
    Bundle data = new Bundle();
    public static int mute=0;
    public static Hashtable<String,Integer> leaderboard = new Hashtable<String,Integer>();
    public static int score = 0;
    public static String actual_player = new String();

    public static int aux = 0;
    public static TextView jogadores;
    public static String players = "null";
    public static Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState != null) {
            this.onRestoreInstanceState(data);
        }

        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        if(players != "null"){
            jogadores = (TextView) findViewById(R.id.pla);
            jogadores.setText(players);
        }

    }


    public void btnJogarOnClick(View v){
        if(players == "null")
            setContentView(R.layout.activity_register);
        else{
            Intent intent = new Intent(this, SelectTheme.class);
            startActivity(intent);
        }

    }

    public void btnInstructionsOnClick(View v){
        this.onSaveInstanceState(data);
        Intent intent = new Intent(this, InstructionsActivity.class);
        startActivity(intent);
    }

    public void btnGOTORegisterOnClick(View view) {
        if(players == "null") {//se ainda niguem se registou
            aux = 1;
            setContentView(R.layout.activity_register);
        }
        else{
            System.out.println("ACABAR!!!!");
            setContentView(R.layout.activity_already_register);
        }
    }

    public void onClickMudar_Sessao(View view) {
        aux = 1;
        setContentView(R.layout.activity_register);
    }

    public void btnRegisterOnClick(View view) {

        EditText neto = (EditText) findViewById(R.id.avo);
        EditText avo= (EditText) findViewById(R.id.neto);
        actual_player = (String)avo.getText().toString() + " & " + (String)neto.getText().toString();
        System.out.println(actual_player);
        players = actual_player;
        System.out.println("\n-->" + players);


        if(aux==1){//registou-se apenas
            this.onSaveInstanceState(data);
            setContentView(R.layout.activity_main);

            if(players != "null"){
                jogadores = (TextView) findViewById(R.id.pla);
                jogadores.setText(players);
            }
            aux=0;

        }
        else{
            this.onSaveInstanceState(data);
            Intent intent = new Intent(this, SelectTheme.class);
            startActivity(intent);
        }
    }

    public void btnLeaderboardOnClick(View v){
        setContentView(R.layout.activity_leaderboard);
        String str = new String();
        HashMap<String, Integer> clone = new HashMap<>();
        clone.putAll(leaderboard);

        if(leaderboard.size()!=0) {

            int max = 0;
            for (int i = 1; i < 6; i++) {
                String aux = new String();
                max = 0;

                for (String key : clone.keySet()) {
                    System.out.println("/n------->key:" + key + " = " + clone.get(key));
                    if (clone.get(key) >= max) {
                        aux = key;
                        max = clone.get(key);
                    }

                }
                if (clone.get(aux) != null)
                    str += i + ". " + aux + ": " + clone.get(aux) + "\n";
                clone.remove(aux);
                System.out.println(str);
            }
        }
        TextView text = (TextView) findViewById(R.id.list);
        text.setText(str);
        System.out.println("----** " + leaderboard.size());;

    }

    public void onClickMenu(View V){
        setContentView(R.layout.activity_main);
        if(players != "null"){
            jogadores = (TextView) findViewById(R.id.pla);
            jogadores.setText(players);
        }
    }

    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putSerializable("data", leaderboard);
        super.onSaveInstanceState(savedInstanceState);
    }


    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        leaderboard = (Hashtable<String, Integer>) savedInstanceState.getSerializable("data");
    }

    public void btnMuteOnClick(View view) {
        Context context = getApplicationContext();
        CharSequence text="";
        int duration = Toast.LENGTH_SHORT;
        if(mute == 0) {//som ligado, vou desligar
            mute = 1;
            text =  "Som Desligado!";
            //btn = (Button) view.findViewById(R.id.mute);
            //btn.setBackgroundColor(getResources().getColor(R.color.Red));
        }
        else{//som desligar, vou ligar
            mute = 0;
            text =  "Som Ligado!";
        }
        Toast.makeText(context, text, duration).show();
    }

}
