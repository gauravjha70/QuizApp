package com.example.gauravjha.quizapp;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.prefs.Preferences;

public class ProfileFragment extends Fragment {

    TextView n, s1,s2,s3;
    String name ;
    int ss1,ss2,ss3;
    SharedPreferences sp;

    public ProfileFragment()
    {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.profile_layout,container,false);

        n = rootview.findViewById(R.id.name);
        s1 = rootview.findViewById(R.id.s1);
        s2 = rootview.findViewById(R.id.s2);
        s3 = rootview.findViewById(R.id.s3);

        n.setText(name);
        s1.setText(String.valueOf(ss1));
        s2.setText(String.valueOf(ss2));
        s3.setText(String.valueOf(ss3));

        return rootview;
    }

    public void setProfileData(UserInfo userInfo)
    {
        name = userInfo.getName();
        ss1 = userInfo.getScore1();
        ss2 = userInfo.getScore2();
        ss3 = userInfo.getScore3();
    }

}
