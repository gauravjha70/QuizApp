package com.example.gauravjha.quizapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements QuizFragment.FinalScore{

    Button sportButton,scienceButton,gkButton,highscore,profile;
    int score;
    UserInfo thisUser;
    QuizFragment quizFragment;
    UsersDatabaseHelper usersDatabaseHelper;
    HighScoreFragment highScoreFragment;
    ProfileFragment profileFragment;
    QuizOver quizOver;
    String category , username;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = getIntent().getStringExtra("Username");
        thisUser = new UserInfo();
        usersDatabaseHelper = new UsersDatabaseHelper(this);
        thisUser = usersDatabaseHelper.getProfile(username);

        sportButton = findViewById(R.id.sports_button);
        gkButton = findViewById(R.id.gk_button);
        scienceButton = findViewById(R.id.science_button);
        highscore = findViewById(R.id.highscore_button);
        profile = findViewById(R.id.profile_button);

        sportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quizFragment = new QuizFragment();

                category = "sports";
                Bundle bundle = new Bundle();
                bundle.putString("category",category);
                quizFragment.setArguments(bundle);
                RelativeLayout quizContainer = findViewById(R.id.quiz_container);
                quizContainer.setClickable(true);

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.quiz_container,quizFragment);
                fragmentTransaction.commit();


            }
        });
        scienceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quizFragment = new QuizFragment();

                category = "science";
                Bundle bundle = new Bundle();
                bundle.putString("category",category);
                quizFragment.setArguments(bundle);
                RelativeLayout quizContainer = findViewById(R.id.quiz_container);
                quizContainer.setClickable(true);

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.quiz_container,quizFragment);
                fragmentTransaction.commit();


            }
        });
        gkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quizFragment = new QuizFragment();

                category = "gk";
                Bundle bundle = new Bundle();
                bundle.putString("category",category);
                quizFragment.setArguments(bundle);
                RelativeLayout quizContainer = findViewById(R.id.quiz_container);
                quizContainer.setClickable(true);

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.quiz_container,quizFragment);
                fragmentTransaction.commit();


            }
        });

        highscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                highScoreFragment = new HighScoreFragment();
                getFragmentManager().beginTransaction().add(R.id.quiz_container,highScoreFragment).commit();

            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profileFragment = new ProfileFragment();
                profileFragment.setProfileData(thisUser);
                getFragmentManager().beginTransaction().add(R.id.quiz_container,profileFragment).commit();

            }
        });


    }


    @Override
    public void getFinalScore(int s) {
        score = s;
        UsersDatabaseHelper usersDatabaseHelper = new UsersDatabaseHelper(this);
        thisUser = new UserInfo(usersDatabaseHelper.updateUserProfile(thisUser,s));
        usersDatabaseHelper.insertHighScore(s,thisUser.getUsername(),thisUser.getName(),category);
        quizOver = new QuizOver();
        Bundle bundle = new Bundle();
        bundle.putString("Score",String.valueOf(score));
        quizOver.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.quiz_container,quizOver,null).commit();
    }


    public void overMainMenu(View view)
    {
        getFragmentManager().beginTransaction().remove(quizOver).commit();

    }

    public void back_HighScore(View view)
    {
        getFragmentManager().beginTransaction().remove(highScoreFragment).commit();

    }

/*    public void SetUserProfile(UserInfo userInfo)
    {
        thisUser = new UserInfo(userInfo);
    }*/


    public void profile_back(View view)
    {
        getFragmentManager().beginTransaction().remove(profileFragment).commit();

    }

    public void LOGOUT(View view)
    {
        sp = getSharedPreferences("key",0);
        SharedPreferences.Editor editor= sp.edit();
        editor.remove("Login").commit();
        startActivity(new Intent(MainActivity.this,LoginPage.class));
    }
}
