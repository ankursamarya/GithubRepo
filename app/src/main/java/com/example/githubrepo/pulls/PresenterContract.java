package com.example.githubrepo.pulls;


public interface PresenterContract {

     void fetchPullRequests(String user, String repo);
     void loadMorePullRequests(String user, String repo, int page);
}
