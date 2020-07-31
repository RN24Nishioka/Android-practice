package com.example.cybaryhelloapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.app.ProgressDialog.show;

public class MainActivity extends AppCompatActivity {

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editTextFirstValue = findViewById(R.id.et_first_number);
        final EditText editTextSecondValue = findViewById(R.id.et_second_number);
        Button button = findViewById(R.id.btn_add);
        final TextView textViewSolution = findViewById(R.id.txt_solution);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstValue = editTextFirstValue.getText().toString();
                String secondValue = editTextSecondValue.getText().toString();

                int solution = Integer.valueOf(firstValue) + Integer.valueOf(secondValue);
                textViewSolution.setText(String.valueOf(solution));

            }
        });






    }
}