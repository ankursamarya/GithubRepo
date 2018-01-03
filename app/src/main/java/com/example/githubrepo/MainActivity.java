package com.example.githubrepo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.githubrepo.pulls.PullRequestListAdapter;
import com.example.githubrepo.pulls.PresenterContract;
import com.example.githubrepo.pojo.PullRequest;
import com.example.githubrepo.pulls.PullRequestPresenter;
import com.example.githubrepo.pulls.ViewContract;
import com.example.githubrepo.util.EndlessRecyclerViewScrollListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewContract, View.OnClickListener {

    private PresenterContract presenter;

    private RecyclerView mRecyclerView;
    private PullRequestListAdapter adapter;

    private EditText userNameInput;
    private EditText repo;

    private List<PullRequest> pullRequests = new ArrayList<>();
    private EndlessRecyclerViewScrollListener scrollListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new PullRequestPresenter(this);

        userNameInput = findViewById(R.id.userName);
        repo = findViewById(R.id.repo);

        adapter = new PullRequestListAdapter(this, pullRequests);

        mRecyclerView = findViewById(R.id.rvPulls);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);

        scrollListener = new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                presenter.loadMorePullRequests(userNameInput.getText().toString(), repo.getText().toString(), page + 1);
            }
        };
        // Adds the scroll listener to RecyclerView to load more request
        mRecyclerView.addOnScrollListener(scrollListener);

        findViewById(R.id.searchBtn).setOnClickListener(this);

    }

    /*
    * Show pull requests for new search
    */
    @Override
    public void showPullRequests(List<PullRequest> pullRequests) {
        this.pullRequests.clear();
        this.pullRequests.addAll(pullRequests);
        mRecyclerView.getAdapter().notifyDataSetChanged();
        scrollListener.resetState();
    }

    @Override
    public void showError() {
        Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
    }

    /*
    * Show more pull requests for last search
    */
    @Override
    public void showMore(List<PullRequest> pullRequests) {

        this.pullRequests.addAll(pullRequests);
        mRecyclerView.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.searchBtn:

                if (TextUtils.isEmpty(userNameInput.getText())) {
                    Toast.makeText(this, R.string.msg_please_enter_user_name, Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(repo.getText())) {
                    Toast.makeText(this, R.string.msg_please_enter_repo_name, Toast.LENGTH_SHORT).show();
                    return;
                }

                presenter.fetchPullRequests(userNameInput.getText().toString(), repo.getText().toString());
                break;
        }
    }
}
