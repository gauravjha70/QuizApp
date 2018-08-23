package com.example.gauravjha.quizapp;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class QuizClass {
    public String question;
    public String opt1;
    public String opt2;
    public String opt3;
    public String opt4;
    public String correct;

    public QuizClass(String ques, String op1, String op2, String op3,String op4,String cor)
    {
        this.setQuestion(ques);
        this.setOpt1(op1);
        this.setOpt2(op2);
        this.setOpt3(op3);
        this.setOpt4(op4);
        this.setCorrect(cor);

    }

    public QuizClass(){}

    public ArrayList<QuizClass> SportsQuiz()
    {
        ArrayList<QuizClass> sports = new ArrayList<QuizClass>();
        QuizClass obj;
        obj = new QuizClass("Which was the 1st non Test playing country to beat India in an international match?","Canada","Sri Lanka","Zimbabwe","East Africa","Sri Lanka");
        sports.add(obj);
        obj = new QuizClass( "Track and field star Carl Lewis won how many gold medals at the 1984 Olympic games?","2","3","4","8","4");
        sports.add(obj);
        obj = new QuizClass("Which county did Ravi Shastri play for?","Glamorgan","Leicestershire","Gloucestershire","Lancashire","Glamorgan");
        sports.add(obj);
        obj = new QuizClass("Who is the first Indian woman to win an Asian Games gold in 400m run?","M.L.Valsamma","P.T.Usha","Kamaljit Sandhu","K.Malleshwari","Kamaljit Sandhu");
        sports.add(obj);
        return sports;
    }

    public ArrayList<QuizClass> GkQuiz()
    {
        ArrayList<QuizClass> gk = new ArrayList<QuizClass>();
        QuizClass obj;
        obj = new QuizClass("Which of the following canals is considered to be an important link between the developed countries and the developing countries?","Panama Canal ","Suez Canal","Kiel Canal ","Grand Canal ","Suez Canal");
        gk.add(obj);
        obj = new QuizClass( "Which of the following is NOT a petrochemical centre of India?","Koyali ","Jamnagar","Mangalore ","Rourkela","Rourkela");
        gk.add(obj);
        obj = new QuizClass( "Myanmar does not share its international boundary with__?","Laos","Thailand ","Vietnam","India","Vietnam");
        gk.add(obj);
        obj = new QuizClass( "Which of the following countries is not a part of Melanesia region in the pacific ocean?","Vanatu","Solomon Islands","Fiji","Kiribati","Kiribati");
        gk.add(obj);
        return gk;
    }

    public ArrayList<QuizClass> ScienceQuiz()
    {
        ArrayList<QuizClass> science = new ArrayList<QuizClass>();
        QuizClass obj;
        obj = new QuizClass("When did dinosaurs and humans exist at the same time?","The Jurassic ","The Cretaceous ","The Iron Age","Never","Never");
        science.add(obj);
        obj = new QuizClass("What are the oldest fossils on earth?","Trilobytes ","Kilobytes","Veloceraptors ","Bacteria","Bacteria");
        science.add(obj);
        obj = new QuizClass("What kind of energy does an unlit match have?","Kinetic","Thermal","Chemical","Elastic","Chemical");
        science.add(obj);
        obj = new QuizClass("How many ounces are in a pound?","12","8","16","24","16");
        science.add(obj);
        return science;
    }
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOpt1() {
        return opt1;
    }

    public void setOpt1(String opt1) {
        this.opt1 = opt1;
    }

    public String getOpt2() {
        return opt2;
    }

    public void setOpt2(String opt2) {
        this.opt2 = opt2;
    }

    public String getOpt3() {
        return opt3;
    }

    public void setOpt3(String opt3) {
        this.opt3 = opt3;
    }

    public String getOpt4() {
        return opt4;
    }

    public void setOpt4(String opt4) {
        this.opt4 = opt4;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }


}
