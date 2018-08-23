package com.example.gauravjha.quizapp;

public class UserInfo {

    String name;
    String username;
    String password;
    int score1;
    int score2;
    int score3;

    public UserInfo()
    {

    }

    public UserInfo(UserInfo u)
    {
        name = u.getName();
        username = u.getUsername();
        password = u.getPassword();
        score1 = u.getScore1();
        score2 = u.getScore2();
        score3 = u.getScore3();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public int getScore3() {
        return score3;
    }

    public void setScore3(int score3) {
        this.score3 = score3;
    }


}
