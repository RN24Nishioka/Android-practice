package com.example.cybaryhelloapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DbbDAO {
    @Insert
    void insertItem(DbbTable...dbbTables);

    @Query("SELECT * from DbbTable")
    LiveData<List<DbbTable>> getAllItems();

    @Query("SELECT COUNT(*) from DbbTable")
    LiveData<Integer> countItems();

    @Delete
    void deleteItem(DbbTable dbbTable);
}
