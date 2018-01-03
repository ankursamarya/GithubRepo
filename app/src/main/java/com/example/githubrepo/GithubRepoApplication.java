package com.example.githubrepo;

import android.app.Application;
import android.content.Context;

/**
 * Created by tt on 24/12/17.
 */

public class GithubRepoApplication extends Application {

    private static GithubRepoApplication mApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
    }

    public static Context getInstance() {
        return mApplication;
    }
}
