package com.example.turgay.androidmvc.database.dao;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.turgay.androidmvc.model.Repo;

import java.util.List;

@Dao
public interface RepoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Repo> repos);

    @Query("SELECT * FROM Repo")
    List<Repo> getAllRepos();
}
