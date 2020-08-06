package com.example.cybaryhelloapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnSend;
    EditText eTxtInput;
    TextView txtOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSend = findViewById(R.id.btn_send);
        eTxtInput = findViewById(R.id.etxt_input);
        txtOutput = findViewById(R.id.txt_output);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = eTxtInput.getText().toString();
                new GetOutputInBackground().execute(message);
                //performOperation(message);
            }
        });

    }

    public void performOperation(String message) {
        String name = getName();
        String output = name + ":" + message;
        txtOutput.setText(output);
    }

    public String getName(){
      try {
          Thread.sleep(5000);
      }catch (InterruptedException e){
          e.printStackTrace();
      }

      return "Jhon";
    }

    private class GetOutputInBackground extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {
            String message = strings[0];
            String name = getName();
            String output = name + ":" + message;
            return output;
        }

        @Override
        protected void onPostExecute(String s) {
            txtOutput.setText(s);

        }
    }


}