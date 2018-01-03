package com.example.githubrepo.pulls;

import rx.Observer;


public interface ModelContract {

    void fetchPullRequest(String user, String repo, final int page, Observer observer);
}
