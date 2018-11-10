package com.example.turgay.androidmvc.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.turgay.androidmvc.R;
import com.example.turgay.androidmvc.controller.MainController;
import com.example.turgay.androidmvc.controller.NetworkController;
import com.example.turgay.androidmvc.model.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    MainController controller;
    NetworkController networkController;
    Button giveMeButton,showMeButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller = new MainController();
        networkController = new NetworkController();
        giveMeButton = findViewById(R.id.btn_give_me);
        showMeButton = findViewById(R.id.btn_show_me);

        giveMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                networkController.getUserReposWithNetworkCallback("turgay-mutlu", new Callback<List<Repo>>() {
                    @Override
                    public void onResponse(Call<List<Repo>> call, final Response<List<Repo>> response) {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                controller.insertRepos(response.body());
                            }
                        });
                        thread.start();
                    }

                    @Override
                    public void onFailure(Call<List<Repo>> call, Throwable t) {
                        Log.e(TAG, "onFailure: " + t.getMessage());
                    }
                });

            }
        });

        showMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        List<Repo> list = controller.getRepos();
                        for (Repo repo : list) {
                            Log.i(TAG, "Repo Name: " + repo.getName());
                        }
                    }
                });
                thread.start();
            }
        });
    }
}
