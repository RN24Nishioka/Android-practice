package com.example.cybaryhelloapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);//getSharedPreferences("cybraryAppSetting", Context.MODE_PRIVATE);

        String check = sharedPreferences.getString("firstRun", "true");

        if(check.equals("true")) {

            sayWelcome();

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("firstRun", "false");
            editor.apply();
        }else {
            Toast.makeText(this, "Welcome back!", Toast.LENGTH_LONG).show();
        }



    }

    public void sayWelcome(){
        Toast.makeText(this, "Welcom New user!", Toast.LENGTH_LONG).show();
    }
}