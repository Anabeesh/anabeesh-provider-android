package com.cs18.anabeesh.salem.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cs18.anabeesh.R;
import com.cs18.anabeesh.salem.model.GetArticales;
import com.cs18.anabeesh.salem.ui.ArticleDetailsActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 TODO: Add class header
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.MyViewHolder> {
    private final Context mContext;
    private List<GetArticales> articlesList;

    public ArticleAdapter(Context context, List<GetArticales> articlesList) {
        mContext = context;
        this.articlesList = articlesList;
    }

    @Override
    public ArticleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View articleView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_article, parent, false);
        return new MyViewHolder(articleView);
    }

    @Override
    public void onBindViewHolder(ArticleAdapter.MyViewHolder holder, int position) {
        //TODO Bind data when the list is  ready
        holder.articleDesc.setText(articlesList.get(position).getBody());
        holder.articleName.setText(articlesList.get(position).getHeading());
        holder.expertName.setText(articlesList.get(position).getUserName());
        Glide.with(mContext)
                .load(articlesList.get(position).getImageUrl())
                .into(holder.articleImage);
    }

    @Override
    public int getItemCount() {
        return articlesList.size();
    }

    public void Update(List<GetArticales> mArticlesList) {
        articlesList = mArticlesList;
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.article_img_id)
        ImageView articleImage;
        @BindView(R.id.tv_expert_name_id)
        TextView expertName;
        @BindView(R.id.tv_Description_id)
        TextView articleDesc;
        @BindView(R.id.tv_article_name_id)
        TextView articleName;

        MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> {
                Intent ArticalDetails = new Intent(mContext, ArticleDetailsActivity.class);
                ArticalDetails.putExtra("Article_img", String.valueOf(articleImage));
                ArticalDetails.putExtra("Expert_Name", expertName.getText().toString());
                ArticalDetails.putExtra("Article_Desc", articleDesc.getText().toString());
                ArticalDetails.putExtra("Article_name", articleName.getText().toString());
                mContext.startActivity(ArticalDetails);
            });
        }
    }
}
