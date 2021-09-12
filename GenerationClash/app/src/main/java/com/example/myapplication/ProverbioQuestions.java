package com.example.myapplication;

public class ProverbioQuestions {


    public static String questions[] = {
            "A união faz...",
            "Devagar se vai...",
            "Dizei-me com quem andas e eu te direi...",
            "Gato escaldado de água fria... ",
            "O barato sai...",
            "Saco vazio não fica...",
            "O perguiçoso trabalha...",
            "Apressado...",
            "Ninguém é profeta...",
            "Quem fala muito, dá bom dia..."
    };

    public static String answers[][] = {
            {"a força", "a diferença", "a fome", "o impossível"},
            {"de mansinho", "a lado nenhum", "ao longe", "alto"},
            {"quem ves","quem levas","quem ouves","quem és"},
            {"gosta","tem medo","foge", "toma banho"},
            {"torto","do bolso","bom","caro"},
            {"de lado","de pé","cheio","pesado"},
            {"devagar","deitado","dobrado","à noite"},
            {"chega em último","tropeça","vai à frente","come cru"},
            {"na sua terra","sem ler","sem trabalhar","no mar"},
            {"aos peixinhos","aos vizinhos","a cavalo","aos cães"}
    };

    public static int correctAnswer[] = {
            1,
            3,
            4,
            2,
            4,
            2,
            3,
            4,
            1,
            3
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


}
