package com.example.githubrepo.pulls;

/**
 * Created by tt on 27/11/17.
 */

public interface PresenterContract {

    public void fetchPullRequests(String user, String repo);
    public void loadMorePulls(String user, String repo, int page);
}
