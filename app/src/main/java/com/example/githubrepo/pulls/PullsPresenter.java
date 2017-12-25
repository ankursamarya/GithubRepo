package com.example.githubrepo.pulls;

import android.util.Log;

import com.example.githubrepo.pojo.PullRequest;

import java.util.List;

import rx.Subscriber;

/**
 * Created by tt on 27/11/17.
 */

public class PullsPresenter implements PresenterContract {
    public static final String TAG = "PullsPresenter";

    private ViewContract viewContract;
    private ModelContract modelContract;

    public PullsPresenter(ViewContract viewContract) {
        this.viewContract = viewContract;
        modelContract = new PullsModel();
    }
    @Override
    public void fetchPullRequests(String user, String repo) {

        modelContract.fetchPullRequest(user,repo,1, new Subscriber<List<PullRequest>>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: " + e);
                e.printStackTrace();
                viewContract.showError();
            }

            @Override
            public void onNext(List<PullRequest> pulls) {
                Log.d(TAG, "onNext: " + pulls);

                viewContract.showPullRequests(pulls);

            }
        });

    }

    @Override
    public void loadMorePulls(String user,String repo, int page) {

        modelContract.fetchPullRequest(user,repo, page, new Subscriber<List<PullRequest>>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: " + e);
                e.printStackTrace();
                viewContract.showError();
            }

            @Override
            public void onNext(List<PullRequest> pullRequests) {
                Log.d(TAG, "onNext: " + pullRequests);

                viewContract.showMore(pullRequests);

            }
        });

    }

}
