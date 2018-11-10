package com.example.turgay.androidmvc.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.turgay.androidmvc.R;
import com.example.turgay.androidmvc.controller.MainController;
import com.example.turgay.androidmvc.model.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    MainController controller;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller = new MainController();
        button = findViewById(R.id.btn_give_me);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.getUserReposWithId("turgay-mutlu", new Callback<List<Repo>>() {
                    @Override
                    public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                        List<Repo> repos = response.body();
                        for (Repo repo : repos) {
                            Log.i(TAG, "Repo Name: " + repo.getName());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Repo>> call, Throwable t) {

                    }
                });

            }
        });
    }
}
