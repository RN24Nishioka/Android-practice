package com.example.cybaryhelloapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonHappy = findViewById(R.id.btn_happy);
        Button buttonNeutral = findViewById(R.id.btn_neutral);
        Button buttonSad = findViewById(R.id.btn_sad);
        final ImageView myImageView = findViewById(R.id.imageView);

        buttonHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myImageView.setImageResource(R.drawable.ic_baseline_sentiment_very_satisfied_96);
            }
        });

        buttonNeutral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myImageView.setImageResource(R.drawable.ic_baseline_sentiment_satisfied_96);

            }
        });

        buttonSad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myImageView.setImageResource(R.drawable.ic_baseline_sentiment_very_dissatisfied_96);

            }
        });

    }
}