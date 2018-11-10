package com.example.turgay.androidmvc.database;


import android.arch.persistence.room.Room;
import android.content.Context;

public class AppDb {
    private static Database db;

    public static void init(Context context){
        db = Room.databaseBuilder(context,Database.class,"db").build();
    }

    public static Database getInstance(){
        return db;
    }
}
