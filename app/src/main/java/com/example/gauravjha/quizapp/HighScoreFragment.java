package com.example.gauravjha.quizapp;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HighScoreFragment extends Fragment {

    ListView listView;
    ArrayList<HighScoreClass> arrayList ;
    UsersDatabaseHelper usersDatabaseHelper;

    public HighScoreFragment()
    {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.high_score_layout,container,false);

        listView = rootview.findViewById(R.id.highscore_list);

        usersDatabaseHelper = new UsersDatabaseHelper(getActivity());
        final HighScoreAdapter highScoreAdapter = new HighScoreAdapter(getActivity(),R.layout.high_score_adapterview,usersDatabaseHelper.getHighScore());

        listView.setAdapter(highScoreAdapter);

        return rootview;
    }


}
