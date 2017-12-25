
package com.example.githubrepo.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Head {

    @SerializedName("label")
    @Expose
    public String label;
    @SerializedName("ref")
    @Expose
    public String ref;
    @SerializedName("sha")
    @Expose
    public String sha;
    @SerializedName("user")
    @Expose
    public User_ user;
    @SerializedName("repo")
    @Expose
    public Repo repo;

}
