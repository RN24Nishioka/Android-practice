package com.example.cybaryhelloapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int sum = 0;
    int currentIncrement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner mySpinner = findViewById(R.id.spinner);
        final TextView textViewSum = findViewById(R.id.txtSum);
        Button buttonSum = findViewById(R.id.btn_sum);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.increment_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mySpinner.setAdapter(adapter);
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedIncrement = parent.getItemAtPosition(position).toString();
                currentIncrement = Integer.valueOf(selectedIncrement);

                //Toast.makeText(MainActivity.this, selectedIncrement, Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        buttonSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sum = sum + currentIncrement;
                textViewSum.setText(String.valueOf(sum));
            }
        });


    }
}