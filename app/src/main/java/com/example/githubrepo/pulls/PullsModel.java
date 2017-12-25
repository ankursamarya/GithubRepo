package com.example.githubrepo.pulls;



import com.example.githubrepo.api.RetrofitInterface;
import com.example.githubrepo.pojo.PullRequest;
import com.example.githubrepo.util.Util;

import java.util.List;

import rx.Observer;

public class PullsModel implements ModelContract {
    @Override
    public void fetchPullRequest(String user, String repo, final int page, Observer observer) {

        RetrofitInterface.getInstance().getApiInterface().getPullRequest(user,repo, page)
                .compose(Util.<List<PullRequest>>applySchedulers())
                .subscribe(observer);
    }
}
