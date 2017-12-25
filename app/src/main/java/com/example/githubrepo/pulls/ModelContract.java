package com.example.githubrepo.pulls;

import rx.Observer;

/**
 * Created by tt on 27/11/17.
 */

public interface ModelContract {

    public void fetchPullRequest(String user, String repo, final int page, Observer observer);
}
