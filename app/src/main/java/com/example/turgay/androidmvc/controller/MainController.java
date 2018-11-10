package com.example.turgay.androidmvc.controller;


import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.turgay.androidmvc.database.AppDb;
import com.example.turgay.androidmvc.database.Database;
import com.example.turgay.androidmvc.model.Repo;
import com.example.turgay.androidmvc.network.APIClient;
import com.example.turgay.androidmvc.network.GitHubService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainController{

    Database database;

    public MainController() {
        database = AppDb.getInstance();
    }

    public void insertRepos(List<Repo> repos){
        database.repoDao().insertAll(repos);
    }

    public List<Repo> getRepos(){
        return database.repoDao().getAllRepos();
    }
}
