package com.example.githubrepo.pulls;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.githubrepo.R;
import com.example.githubrepo.pojo.PullRequest;

import java.util.ArrayList;
import java.util.List;


public class ListAdapter extends RecyclerView.Adapter<ListAdapter.CustomViewHolder> {

    private List<PullRequest> pullRequest = new ArrayList<PullRequest>();
    private final Context mContext;

    public ListAdapter(Context context, List<PullRequest> pullRequest) {
        this.mContext = context;
        this.pullRequest = pullRequest;
    }

    @Override
    public ListAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        final View sView = mInflater.inflate(R.layout.item, parent, false);
        return new CustomViewHolder(sView);
    }

    @Override
    public void onBindViewHolder(ListAdapter.CustomViewHolder holder, int position) {
        PullRequest pull = pullRequest.get(position);
        holder.name.setText(pull.title);
        Glide.with(mContext).load(pull.user.avatarUrl).error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return pullRequest.size();
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private ImageView image;

        public CustomViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.tvName);
            image = (ImageView) view.findViewById(R.id.UserImage);
        }
    }
}