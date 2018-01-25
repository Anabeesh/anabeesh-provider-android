package com.cs18.anabeesh.muhammad.ui.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cs18.anabeesh.R;
import com.cs18.anabeesh.muhammad.di.activity.ActivityScope;
import com.cs18.anabeesh.muhammad.di.activity.ForActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@ActivityScope
class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int SEARCH = 0;
    private static final int CATEGORY = 1;
    private static final int QUESTION = 2;

    private final Context context;
    private final HomePresenter presenter;
    private final LayoutInflater layoutInflater;

    @Inject
    RecyclerAdapter(@ForActivity Context context, HomePresenter presenter) {
        this.presenter = presenter;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == QUESTION) {
            return new QuestionViewHolder(layoutInflater.inflate(R.layout.item_question, parent, false));
        } else if (viewType == CATEGORY) {
            return new CategoryViewHolder(layoutInflater.inflate(R.layout.item_category, parent, false));
        } else {
            return new SearchViewHolder(layoutInflater.inflate(R.layout.item_header, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemCount() == 0 || position == getItemCount() - 1) {
            presenter.loadMoreQuestions();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return SEARCH;
        } else if (position == 1 || position == 9) {
            return CATEGORY;
        }
        return QUESTION;
    }

    @Override
    public int getItemCount() {
        return 15;
    }

    void updateUi() {
        notifyDataSetChanged();
    }

    class SearchViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_greeting)
        TextView greetingTextView;

        SearchViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            bind();
        }

        void bind() {
            greetingTextView.setText(context.getString(R.string.good_morning).concat(" Muhammad."));
        }

        @OnClick(R.id.tv_search)
        void onSearchClick() {
        }
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {

        CategoryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind() {
        }
    }

    class QuestionViewHolder extends RecyclerView.ViewHolder {

        QuestionViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind() {
        }
    }
}
