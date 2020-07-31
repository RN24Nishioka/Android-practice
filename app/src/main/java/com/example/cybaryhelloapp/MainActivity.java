package com.example.cybaryhelloapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.app.ProgressDialog.show;

public class MainActivity extends AppCompatActivity {

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TextView textView = findViewById(R.id.txtValue);
        Button button = findViewById(R.id.btn_add);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                count += 1;
                textView.setText(String.valueOf(count));

            }
        });
    }
}