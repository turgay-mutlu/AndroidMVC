package com.example.turgay.androidmvc.network;


import com.example.turgay.androidmvc.model.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubService {
    @GET("users/{user}/repos")
    Call<List<Repo>> getUserRepos(@Path("user") String user);
}
