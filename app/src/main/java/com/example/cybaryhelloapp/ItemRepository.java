package com.example.cybaryhelloapp;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

class ItemRepository {

    private Context context;

    public ItemRepository(Context context) {
        this.context = context.getApplicationContext();
    }

    public void addNewItem(DbbTable dbbTable) {
        AsyncTask.execute(() -> DbbDatabase.getInstance(context).dbbDAO().insertItem(dbbTable));
    }

//    public void addNewItem(DbbTable dbbTable) {
//        AsyncTask.execute(new Runnable() {
//            @Override
//            public void run() {
//                DbbDatabase.getInstance(context).dbbDAO().insertItem(dbbTable);
//            }
//        });
//    }

    public LiveData<List<DbbTable>> getItems() {
        return DbbDatabase.getInstance(context).dbbDAO().getAllItems();
    }

    public LiveData<Integer> getItemCount() {
        return DbbDatabase.getInstance(context).dbbDAO().countItems();
    }

    public void deleteItem(DbbTable dbbTable) {
        AsyncTask.execute(() -> DbbDatabase.getInstance(context).dbbDAO().deleteItem(dbbTable));
    }

}
