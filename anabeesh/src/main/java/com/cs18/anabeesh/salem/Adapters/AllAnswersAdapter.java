package com.cs18.anabeesh.salem.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cs18.anabeesh.R;
import com.cs18.anabeesh.salem.model.AllAnswers;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 TODO: Add class header
 */

public class AllAnswersAdapter extends RecyclerView.Adapter<AllAnswersAdapter.MyViewHolder> {
    private final List<AllAnswers> allAnswersList;
    private final Context context;

    public AllAnswersAdapter(List<AllAnswers> allAnswersList, Context mContext) {
        this.allAnswersList = allAnswersList;
        context = mContext;
    }

    @Override
    public AllAnswersAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View allAnswersView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_comment, parent, false);
        return new AllAnswersAdapter.MyViewHolder(allAnswersView);
    }

    @Override
    public void onBindViewHolder(AllAnswersAdapter.MyViewHolder holder, int position) {
        holder.commentDesc.setText(allAnswersList.get(position).getAnswerBody());
        //Static Img and Name not  from Response
        holder.commenterName.setText("عمر سالم");
        holder.commenterImage.setImageResource(R.mipmap.ic_launcher_round);
    }

    @Override
    public int getItemCount() {
        return allAnswersList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_comment_desc_id)
        TextView commentDesc;
        @BindView(R.id.tv_commenter_name)
        TextView commenterName;
        @BindView(R.id.iv_commenter_img)
        ImageView commenterImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
