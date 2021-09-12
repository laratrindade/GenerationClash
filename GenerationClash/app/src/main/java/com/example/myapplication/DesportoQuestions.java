package com.example.myapplication;

public class DesportoQuestions {

    public String questions[] = {
            "Quem ganhou o primeiro Mundial de Futebol?",
            "Como se chama esta pessoa?",
            "Em quantas edições do Campeonato do Mundo é que Cristiano Ronaldo já fez um golo?",
            "Quem foi eleito o melhor jogador da última edição da NBA?",
            "Qual dos seguintes não é considerado um eSport?"
    };
    public int images[] = {
            1,
            2,
            3,
            4,
            5
    };


    public static String answers[][] = {
            {"Argentina", "Portugal", "Uruguai", "França"},
            {"Maria Adelaide", "Cátia Aveiro", "Madalena Santos", "Rosa Mota"},
            {"4", "3", "2", "5"},
            {"Lebron James", "James Harden", "Stephen Curry", "Russell Westbrook"},
            {"Futebol", "FIFA", "League of Legends", "CS:GO"}

    };

    public static int correctAnswer[] = {
            3,
            4,
            1,
            2,
            1
    };


    public String getQuestion(int a){
        return questions[a];
    }

    public String getchoice1(int a){
        return answers[a][0];
    }

    public String getchoice2(int a){
        return answers[a][1];
    }

    public String getchoice3(int a){
        return answers[a][2];
    }

    public String getchoice4(int a){
        return answers[a][3];
    }

    public static int getCorrectAnswer(int a){
        return correctAnswer[a];
    }

    public int getImage(int a){ return images[a]; }

}
