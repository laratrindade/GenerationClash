package com.example.myapplication;

public class ImageQuestions {

    public String questions[] = {
            "Como se chama o objeto na imagem?",
            "Como se chama esta pessoa?",
            "Para que serve este objeto?",
            "Como se chama esta personagem?",
            "Como se chama este jogo?",
            "Como se chama habitualmente este local?",
            "Como se chama esta pessoa?",
            "O que está nesta imagem?",
            "Que fruto é este?",
            "Qual a profissão desta pessoa?"

    };
    public int images[] = {
            1,
            2,
            3,
            4,
            5,
            6,
            7,
            8,
            9,
            10
    };


    public static String answers[][] = {
            {"Charrua", "Trator", "Bidé", "Noz"},
            {"Maria Adelaide", "Cátia Aveiro", "Madalena Santos", "Rosa Mota"},
            {"Costurar", "Telefonar", "Jogar", "Cantar"},
            {"Dr Strange", "Dr José", "Capitão América", "Homem Aranha"},
            {"FIFA", "Dora Exploradora", "CS GO", "Homem Aranha"},
            {"Trincheira", "Jardim", "Calabouço", "Lisboa"},
            {"Maria", "Amália", "Manuela Ferreira Leite", "Padeira de Aljubarrota"},
            {"Televisão", "PS4", "GameBoy Advance", "Tostadeira"},
            {"Nêspera", "Tomate", "Diospiro", "Pêssego"},
            {"Músico", "Jogador de Basket", "Professor", "Escritor"}
    };

    public static int correctAnswer[] = {
            1,
            4,
            2,
            1,
            3,
            1,
            2,
            2,
            1,
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
