package com.example.cybaryhelloapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

class MainActivityViewModel extends AndroidViewModel {

    private ItemRepository itemRepository;
    private LiveData<List<DbbTable>> items;
    private LiveData<Integer> itemCount;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        itemRepository = new ItemRepository(application.getApplicationContext());
        items = itemRepository.getItems();
        itemCount = itemRepository.getItemCount();

    }

    public void insertNewItem(DbbTable dbbTable){
        itemRepository.addNewItem(dbbTable);
    }

    public void deleteItem(DbbTable dbbTable){
        itemRepository.deleteItem(dbbTable);
    }

    public LiveData<Integer> getItemCount(){
        return itemCount;
    }

    public LiveData<List<DbbTable>> getItems(){
        return items;
    }


}
