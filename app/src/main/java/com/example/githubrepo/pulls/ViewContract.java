package com.example.githubrepo.pulls;


import com.example.githubrepo.pojo.PullRequest;

import java.util.List;



public interface ViewContract {

    public void showPullRequests(List<PullRequest> pullRequests);

    public void showError();

    void showMore(List<PullRequest> pullRequests);

}
