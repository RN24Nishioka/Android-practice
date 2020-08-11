package com.example.cybaryhelloapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = DbbTable.class, version = 1)
public abstract class DbbDatabase extends RoomDatabase {
    private static DbbDatabase dbbDatabaseInstance;

    public static synchronized DbbDatabase getInstance(Context context)
    {
     if(dbbDatabaseInstance==null)
     {
         dbbDatabaseInstance = Room.databaseBuilder(context.getApplicationContext(),DbbDatabase.class, "cybraryShopDb").build();
     }

     return  dbbDatabaseInstance;
    }

    public abstract DbbDAO dbbDAO();
}
