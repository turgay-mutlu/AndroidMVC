package com.example.turgay.androidmvc;


import android.app.Application;

import com.example.turgay.androidmvc.database.AppDb;

public class App extends Application {
    @Override
    public void onCreate() {

        AppDb.init(this);
        super.onCreate();

    }
}
