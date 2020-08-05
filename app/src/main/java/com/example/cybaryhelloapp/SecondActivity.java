package com.example.cybaryhelloapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String type = intent.getType();
        String action = intent.getAction();

        if(Intent.ACTION_SEND.equals(action)&& type != null){
            if("text/plain".equals(type)){
                String message = intent.getStringExtra(Intent.EXTRA_TEXT);
                Toast.makeText(this, "Hey!: "+message, Toast.LENGTH_SHORT).show();
            }
        }
    }
}