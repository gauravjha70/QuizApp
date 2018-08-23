package com.example.gauravjha.quizapp;

import android.support.annotation.NonNull;

public class HighScoreClass implements Comparable<HighScoreClass>{
    String uname , name ,cat;
    int score;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    @Override
    public int compareTo(@NonNull HighScoreClass highScoreClass) {
        if (score > highScoreClass.score) {
            return -1;
        }
        else if (score <  highScoreClass.score) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
