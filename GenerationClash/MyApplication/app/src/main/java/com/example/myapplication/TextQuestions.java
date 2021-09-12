package com.example.myapplication;

public class TextQuestions {

    public static String questions[] = {
            "O que é uma charrua?",
            "Qual o sinonimo de brunir?",
            "Qual o sinónimo de dar flex?",
            "Qual o significado de jorna?",
            "Qual o significado de YOLO?",
            "Qual o sinónimo de bué?",
            "O que é a macaca?"
    };

    public static String answers[][] = {
            {"Instrumento Agricola", "Brinquedo", "Material Escolar", "Alimento"},
            {"Varrer", "Passar a ferro", "Escova de dentes", "Jogo"},
            {"Gabar", "Discutir", "Cantar", "Tomar banho"},
            {"Dia de descanso", "Dia de ferias", "Dia de passear", "Dia de trabalho"},
            {"You Only Love Once", "You Only Love One", "You Only Live Once", "You Only Live Ok"},
            {"Muito", "Pouco", "Pequeno", "Alto"},
            {"Animal", "Peça de roupa", "Celebridade", "Jogo"}
    };

    public static int correctAnswer[] = {
            1,
            2,
            1,
            4,
            3,
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

    public static int getCorrectAnswer(int a){
        return correctAnswer[a];
    }

}
