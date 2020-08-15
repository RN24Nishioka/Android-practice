package com.example.cybaryhelloapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

//import androidx.lifecycle.ViewModelProviders;非推奨
import static androidx.lifecycle.ViewModelProvider.*;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel mainActivityViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.item_count_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        TextView txtCount = findViewById(R.id.txt_count);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        EditText eTxtItem = findViewById(R.id.etxe_new_item);
        Button button = findViewById(R.id.btn_add);

        mainActivityViewModel = new ViewModelProvider(this, new ViewModelProvider.Factory(){

            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new MainActivityViewModel(getApplication());
            }
        }).get(MainActivityViewModel.class);

        List<DbbTable> dbbTables = new ArrayList<>();
        ItemAdapter itemAdapter = new ItemAdapter(dbbTables);

        recyclerView.setAdapter(itemAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = eTxtItem.getText().toString();
                String amount = spinner.getSelectedItem().toString();
                DbbTable dbbTable = new DbbTable();
                dbbTable.item = name;
                dbbTable.quantity = Integer.valueOf(amount);
                mainActivityViewModel.insertNewItem(dbbTable);
                eTxtItem.getText().clear();


            }
        });

        mainActivityViewModel.getItems().observe(this, dbbTables1 -> {
            itemAdapter.setDate(dbbTables1);
            itemAdapter.notifyDataSetChanged();
        });
//        mainActivityViewModel.getItems().observe(this, new Observer<List<DbbTable>>() {
//            @Override
//            public void onChanged(List<DbbTable> dbbTables) {
//                itemAdapter.setDate(dbbTables);
//                itemAdapter.notifyDataSetChanged();
//            }
//        });


        mainActivityViewModel.getItemCount().observe(this, integer -> txtCount.setText(String.valueOf(integer)));

//        mainActivityViewModel.getItemCount().observe(this, new Observer<Integer>() {
//            @Override
//            public void onChanged(Integer integer) {
//                txtCount.setText(String.valueOf(integer));
//
//            }
//        });


    }


}