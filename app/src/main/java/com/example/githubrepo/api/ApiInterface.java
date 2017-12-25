package com.example.githubrepo.api;


import com.example.githubrepo.pojo.PullRequest;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;


public interface ApiInterface {

    @Headers({

            "Cache-max-age: 172800"
    })
    @GET("repos/{user}/{repo}/pulls")
    Observable<List<PullRequest>> getPullRequest(@Path("user") String user,@Path("repo") String repo, @Query("page") int page);
}
