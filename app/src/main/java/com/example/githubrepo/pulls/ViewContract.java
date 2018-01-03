package com.example.githubrepo.pulls;


import com.example.githubrepo.pojo.PullRequest;

import java.util.List;

public interface ViewContract {

    void showPullRequests(List<PullRequest> pullRequests);

    void showError();

    void showMore(List<PullRequest> pullRequests);

}
