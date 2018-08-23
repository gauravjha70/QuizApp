package com.example.gauravjha.quizapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class HighScoreAdapter extends ArrayAdapter<HighScoreClass> {

    Context context;
    private ArrayList<HighScoreClass> obj_array;

    public HighScoreAdapter(Context context, int textViewResourceId, ArrayList<HighScoreClass> items) {
        super(context, textViewResourceId, items);
        this.context = context;
        this.obj_array = items;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.high_score_adapterview, null);
        }
        HighScoreClass o = obj_array.get(position);
        if (o != null) {
            TextView score = v.findViewById(R.id.score_text);
            TextView rank = v.findViewById(R.id.rank_text);
            TextView name = v.findViewById(R.id.name_text);
            TextView cat = v.findViewById(R.id.category_text);


            rank.setText(String.valueOf(position+1));
            score.setText(String.valueOf(o.getScore()));
            name.setText(o.getName());
            cat.setText(o.getCat());
        }
        return v;
    }
}
