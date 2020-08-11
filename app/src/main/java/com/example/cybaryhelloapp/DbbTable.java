package com.example.cybaryhelloapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class DbbTable {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String item;

    public int quantity;

}
