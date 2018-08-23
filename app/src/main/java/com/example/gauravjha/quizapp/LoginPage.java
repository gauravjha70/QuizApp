package com.example.gauravjha.quizapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static java.security.AccessController.getContext;

public class LoginPage extends AppCompatActivity {

    EditText username, password;
    Button login,signup;
    SharedPreferences sp;
    String loginStatus;
    SignUpPage signUpPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        sp = getSharedPreferences("key", 0);
        loginStatus = sp.getString("Login","");

        username = findViewById(R.id.usernameedit);
        password = findViewById(R.id.passwordedit);

        try {
            if (loginStatus.equals("true")) {
                Intent intent = new Intent(LoginPage.this, MainActivity.class);
                String uname = sp.getString("Username", "");
                intent.putExtra("Username", uname);
                startActivity(intent);
            }
            else
            {
                String u;
                u = sp.getString("Username","");
                username.setText(u);
                String p = sp.getString("Password","");
                password.setText(p);
            }
        }
        catch(Exception e){}

        login = findViewById(R.id.login_button);
        signup = findViewById(R.id.signup_button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = username.getText().toString();
                String pass = password.getText().toString();
                UsersDatabaseHelper usersDatabaseHelper = new UsersDatabaseHelper(LoginPage.this );

                if(usersDatabaseHelper.searchLogin(uname, pass)==2)
                {

                    Intent intent = new Intent(LoginPage.this,MainActivity.class);
                    intent.putExtra("Username", uname);

                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("Login","true");
                    editor.putString("Username",uname);
                    editor.putString("Password",pass);
                    editor.apply();

                    startActivity(intent);

                    finish();

                }
                else if (usersDatabaseHelper.searchLogin(uname,pass)==1)
                {
                    Toast.makeText(LoginPage.this, "Password Incorrect !!", Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(LoginPage.this, "Username does not exists !!", Toast.LENGTH_LONG).show();

            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUpPage = new SignUpPage();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.login_frag_container,signUpPage);
                fragmentTransaction.commit();

                findViewById(R.id.login_frag_container).setClickable(true);
            }
        });

    }

    public void accountCreated(String un,String pw)
    {
        getFragmentManager().beginTransaction().remove(signUpPage).commit();
        findViewById(R.id.login_frag_container).setClickable(false);
        username.setText(un);
        password.setText(pw);
    }
}
