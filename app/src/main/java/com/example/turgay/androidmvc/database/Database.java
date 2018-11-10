package com.example.turgay.androidmvc.database;



import android.arch.persistence.room.RoomDatabase;

import com.example.turgay.androidmvc.database.dao.RepoDao;
import com.example.turgay.androidmvc.model.Repo;

@android.arch.persistence.room.Database(entities = {
        Repo.class
}, version = 1)
public abstract class Database extends RoomDatabase {
    public abstract RepoDao repoDao();
}
