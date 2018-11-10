package com.example.turgay.androidmvc.controller;


import com.example.turgay.androidmvc.model.Repo;
import com.example.turgay.androidmvc.network.APIClient;
import com.example.turgay.androidmvc.network.GitHubService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainController{

    GitHubService gitHubService;
    List<Repo> repos;

    public List<Repo> getUserReposWithId(String username){
        gitHubService = APIClient.getClient().create(GitHubService.class);
        Call<List<Repo>> call = gitHubService.getUserRepos(username);
        call.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                repos = response.body();
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                repos = new ArrayList<>();
            }
        });

        return repos;
    }
}
