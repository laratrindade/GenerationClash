package com.example.myapplication;

public class ImageQuestions {

    public String questions[] = {
            "Como se chama o objeto na imagem?",
            "Como se chama esta pessoa?"
    };
    public int images[] = {
            1,
            2
    };


    public String answers[][] = {
            {"Charrua", "Trator", "Bidé", "Noz"},
            {"Maria Adelaide", "Cária Aveiro", "Madalena Santos", "Rosa Mota"}
    };

    public int correctAnswer[] = {
            1,
            4
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

    public int getCorrectAnswer(int a){
        return correctAnswer[a];
    }

    public int getImage(int a){ return images[a]; }

}
