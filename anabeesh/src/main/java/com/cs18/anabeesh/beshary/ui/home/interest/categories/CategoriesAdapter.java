package com.cs18.anabeesh.beshary.ui.home.interest.categories;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.cs18.anabeesh.R;
import com.cs18.anabeesh.beshary.store.model.user.UserCategories;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.MyViewHolder> implements  CategoriesItemScreen{

    private ArrayList<UserCategories> userCategoriesList;
    private CategoryPresenter presenter;
    private Context mContext;
    private String userId;
    private int currentIndex;
    private boolean state;

    CategoriesAdapter(ArrayList<UserCategories> userCategoriesList,CategoryPresenter presenter,Context context,String userId) {
        this.userCategoriesList = userCategoriesList;
        this.presenter = presenter;
        mContext = context;
        this.userId = userId;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_list,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        currentIndex = position;
        UserCategories userCategories = userCategoriesList.get(position);
        state = userCategories.getState().equals("true")? true : false;
        final String CategoryId = userCategories.getCategoryId();

        holder.categoryName.setText(userCategories.getCategoryName());
        holder.categoryFollowingState.setText
                (state ? mContext.getString(R.string.user_following) : mContext.getString(R.string.user_not_following) );
        holder.categoryFollowingState.setOnClickListener(view -> {
            if(state)
                presenter.unFollowCategory(userId,CategoryId,this);
            else
                presenter.followCategory(userId,CategoryId,this);
        });
    }

    @Override
    public int getItemCount() {
        return userCategoriesList.size();
    }

    @Override
    public void onSuccess() {
        state = state ? false : true;
        userCategoriesList.get(currentIndex).isFollowing =
                   state ? mContext.getString(R.string.user_following) : mContext.getString(R.string.user_not_following);
        userCategoriesList.get(currentIndex).isFollowing = state ? "true" : "false";
        notifyItemChanged(currentIndex);
    }

    @Override
    public void onFailure() {

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_category_name)
        TextView categoryName;
        @BindView(R.id.btn_follow)
        TextView categoryFollowingState;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
