package com.cs18.anabeesh.salem.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cs18.anabeesh.R;
import com.cs18.anabeesh.salem.model.Posts;
import com.cs18.anabeesh.salem.ui.SendAnswer.SendAnswerActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 TODO: Add class header
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder> {
    private final Context context;
    private List<Posts> postsList;

    public PostAdapter(Context mContext, List<Posts> postsList) {
        context = mContext;
        this.postsList = postsList;
    }

    @Override
    public PostAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View postView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_post, parent, false);
        return new MyViewHolder(postView);
    }

    @Override
    public void onBindViewHolder(PostAdapter.MyViewHolder holder, int position) {
        holder.postTittle.setText(postsList.get(position).getHeadline());
        holder.postDesc.setText(postsList.get(position).getDescription());
        holder.posterUserName.setText("عمر سالم");
        holder.posterImage.setImageResource(R.mipmap.ic_launcher_round);
    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public void Update(List<Posts> mPostsList) {
        postsList = mPostsList;
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_post_id)
        TextView postTittle;
        @BindView(R.id.tv_post_desc_id)
        TextView postDesc;
        @BindView(R.id.tv_poster_name)
        TextView posterUserName;
        @BindView(R.id.iv_poster_img)
        ImageView posterImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(view -> {
                Intent PosterDetailIntent = new Intent(context, SendAnswerActivity.class);
                PosterDetailIntent.putExtra("poster_user_name", posterUserName.getText().toString());
                PosterDetailIntent.putExtra("post_tittle", postTittle.getText().toString());
                PosterDetailIntent.putExtra("post_descr", postDesc.getText().toString());
                PosterDetailIntent.putExtra("poster_user_img", String.valueOf(posterImage));
                PosterDetailIntent.putExtra("postId", postsList.get(getAdapterPosition()).getpostId());
                //TODO ADD A  REAL ID when response has body
                //PosterDetailIntent.putExtra("postId", postsList.get(getAdapterPosition()).getpostId());
                context.startActivity(PosterDetailIntent);
            });
        }
    }
}
