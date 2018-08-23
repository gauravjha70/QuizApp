package com.example.gauravjha.quizapp;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class UsersDatabaseHelper extends SQLiteOpenHelper {

    SQLiteDatabase db;

    private static final String Database_Name = "QuizDataBase.db";
    private static final String User_table = "UserInfo";
    private static final String HS_Table = "HighScore";

    private static final String Create_User_Table = "create table UserInfo (User_Name text, " +
            "Name text, Password text, s1 number, s2 number, s3 number);";
    private static final String Create_High_Score_Table = "create table HighScore (Score number , Name text, Username text, Category text);";

    public UsersDatabaseHelper(Context context) {
        super(context, Database_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Create_User_Table);
        db.execSQL(Create_High_Score_Table);
        this.db=db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("Drop table if exists "+User_table+";");
        db.execSQL("Drop table if exists " + HS_Table+";");
        this.onCreate(db);
    }

    public void insertUserData(UserInfo userInfo)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("User_Name",userInfo.getUsername());
        values.put("Name",userInfo.getName());
        values.put("Password",userInfo.getPassword());
        values.put("s1",userInfo.getScore1());
        values.put("s2",userInfo.getScore2());
        values.put("s3",userInfo.getScore3());

        db.insert(User_table,null,values);
        db.close();
    }

    public boolean searchUname(String Uname)
    {
        db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select User_Name from UserInfo ",null );

        if (cursor.moveToFirst())
        {
            do {
                if(cursor.getString(0).equals(Uname))
                {
                    return true;
                }
            }while(cursor.moveToNext());
        }
        db.close();
        return false;
    }

    public int searchLogin(String uname, String pass)
    {
        db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select User_Name, Password from UserInfo ",null);

        if(cursor.moveToFirst())
        {
            do {
                if(cursor.getString(0).equals(uname))
                {
                    if(cursor.getString(1).equals(pass))
                        return 2;
                    else
                        return 1;
                }
            }while(cursor.moveToNext());
        }
        db.close();
        return 0;
    }

    public UserInfo getProfile(String uname)
    {
        db = getReadableDatabase();
        UserInfo userInfo = new UserInfo();
        Cursor cursor = db.rawQuery("select User_Name, Name, Password, s1, s2, s3  from UserInfo ",null);

        if(cursor.moveToFirst())
        {
            do {
                if(cursor.getString(0).equals(uname))
                {
                    userInfo.setUsername(cursor.getString(0));
                    userInfo.setName(cursor.getString(1));
                    userInfo.setPassword(cursor.getString(2));
                    userInfo.setScore1(cursor.getInt(3));
                    userInfo.setScore2(cursor.getInt(4));
                    userInfo.setScore3(cursor.getInt(5));
                    break;

                }
            }while(cursor.moveToNext());
        }
        db.close();
        return userInfo ;
    }

    public UserInfo updateUserProfile(UserInfo userInfo, int s)
    {
        Integer[] score_Array = new Integer[4];
        score_Array[0] = userInfo.getScore1();
        score_Array[1] = userInfo.getScore2();
        score_Array[2] = userInfo.getScore3();
        score_Array[3] = s;
        Arrays.sort(score_Array, Collections.reverseOrder());
        userInfo.setScore1(score_Array[0]);
        userInfo.setScore2(score_Array[1]);
        userInfo.setScore3(score_Array[2]);
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("s1",score_Array[0]);
        values.put("s2",score_Array[1]);
        values.put("s3",score_Array[2]);

        db.update(User_table,values,"User_Name = ?",new String[] {userInfo.getUsername()});
        db.close();
        return userInfo;

    }

    public ArrayList<HighScoreClass> getHighScore()
    {
        HighScoreClass highScoreClass;
        ArrayList<HighScoreClass> arrayHighScore = new ArrayList<HighScoreClass>();
        db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select Score , Name, Username, Category from  "+HS_Table+" Order by Score DESC",null);
        if(cursor.moveToFirst())
        {
            do {
                highScoreClass = new HighScoreClass();
                highScoreClass.setScore(cursor.getInt(0));
                highScoreClass.setName(cursor.getString(1));
                highScoreClass.setUname(cursor.getString(2));
                highScoreClass.setCat(cursor.getString(3));
                arrayHighScore.add(highScoreClass);
            }while(cursor.moveToNext());
        }
        db.close();
        return arrayHighScore;
    }

    public void insertHighScore(int score , String username, String name, String cat)
    {
        ArrayList<HighScoreClass> arrayHighScore = new ArrayList<HighScoreClass>();
        HighScoreClass highScoreClass;
        int i=0;
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Score",score);
        values.put("Name",name);
        values.put("Username",username);
        values.put("Category",cat);
        db.insert(HS_Table,null,values);
        db.close();

        db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select Score , Name, Username, Category from  "+HS_Table+" Order by Score DESC",null);
        if(cursor.moveToFirst())
        {
            do {
                highScoreClass = new HighScoreClass();
                highScoreClass.setScore(cursor.getInt(0));
                highScoreClass.setName(cursor.getString(1));
                highScoreClass.setUname(cursor.getString(2));
                highScoreClass.setCat(cursor.getString(3));
                arrayHighScore.add(highScoreClass);
            }while(cursor.moveToNext());
        }
        Collections.sort(arrayHighScore);
        db.close();

        db = this.getWritableDatabase();
        db.execSQL("delete from "+ HS_Table);

        db=this.getWritableDatabase();
        while(i<arrayHighScore.size() && i<=10)
        {
            values = new ContentValues();
            values.put("Score",arrayHighScore.get(i).getScore());
            values.put("Name",arrayHighScore.get(i).getName());
            values.put("Username",arrayHighScore.get(i).getUname());
            values.put("Category",arrayHighScore.get(i).getCat());
            db.insert(HS_Table,null,values);
            i++;
        }
        db.close();
    }

}
