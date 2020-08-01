package com.example.cybaryhelloapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
//    Button btn_order = findViewById(R.id.button);
//    final CheckBox cbx_order = findViewById(R.id.cbx_order);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//        btn_order.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                boolean isSelected = cbx_order.isChecked();
//                if (isSelected){
//                    Toast.makeText(MainActivity.this, "I want some Pizza!", Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(MainActivity.this, "Nah", Toast.LENGTH_SHORT).show();
//                }
//
//
//            }
//        });

    }


    public  void onCheckeboxClicked(View view){
        boolean checked = ((CheckBox)view).isChecked();

    if(view.getId() == R.id.cbx_order){
        if(checked)
            Toast.makeText(this, "I wanna eat Pizza", Toast.LENGTH_SHORT).show();
        else {
            Toast.makeText(this, "I'm fine", Toast.LENGTH_SHORT).show();
        }
    }
    else if(view.getId() == R.id.cbx_icecream){
        if(checked)
            Toast.makeText(this, "I wanna take some cool IceCream", Toast.LENGTH_SHORT).show();
        else {
            Toast.makeText(this, "Nah", Toast.LENGTH_SHORT).show();
        }
    }
    }
}