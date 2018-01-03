package com.example.githubrepo.pulls;

import com.example.githubrepo.pojo.PullRequest;

import java.util.List;

import rx.Subscriber;


public class PullRequestPresenter implements PresenterContract {

    public static final String TAG = "PullReqPre";

    private ViewContract viewContract;
    private ModelContract modelContract;

    public PullRequestPresenter(ViewContract viewContract) {
        this.viewContract = viewContract;
        modelContract = new PullRequestsModel();
    }

    @Override
    public void fetchPullRequests(String user, String repo) {

        modelContract.fetchPullRequest(user, repo, 1, new Subscriber<List<PullRequest>>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                viewContract.showError();
            }

            @Override
            public void onNext(List<PullRequest> pulls) {
                viewContract.showPullRequests(pulls);
            }
        });
    }

    @Override
    public void loadMorePullRequests(String user, String repo, int page) {

        modelContract.fetchPullRequest(user, repo, page, new Subscriber<List<PullRequest>>() {

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                viewContract.showError();
            }

            @Override
            public void onNext(List<PullRequest> pullRequests) {
                viewContract.showMore(pullRequests);
            }
        });
    }
}
