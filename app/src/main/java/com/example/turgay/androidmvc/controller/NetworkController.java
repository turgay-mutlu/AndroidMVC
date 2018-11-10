package com.example.turgay.androidmvc.controller;


import com.example.turgay.androidmvc.model.Repo;
import com.example.turgay.androidmvc.network.APIClient;
import com.example.turgay.androidmvc.network.GitHubService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class NetworkController {

    GitHubService gitHubService;

    public void getUserReposWithNetworkCallback(String username, Callback<List<Repo>> callback){
        gitHubService = APIClient.getClient().create(GitHubService.class);
        Call<List<Repo>> call = gitHubService.getUserRepos(username);
        call.enqueue(callback);
    }
}
