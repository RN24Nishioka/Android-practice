package com.example.cybaryhelloapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);

        String[] languages = {"Java", "Python", "C++", "Ruby", "Javascript", "C#", "C", "Kotlin", "Swift", "Objective C", "Ruby", "Scale", "Clojure", "Rust", "PHP", "Go", "Groovy"};

        LanguageAdapter languageAdapter = new LanguageAdapter(languages);
        recyclerView.setAdapter(languageAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

    }
}