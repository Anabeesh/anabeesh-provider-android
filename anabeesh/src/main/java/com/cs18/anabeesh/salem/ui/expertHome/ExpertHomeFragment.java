package com.cs18.anabeesh.salem.ui.expertHome;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cs18.anabeesh.R;
import com.cs18.anabeesh.beshary.store.AuthRepo;
import com.cs18.anabeesh.salem.Adapters.ArticleAdapter;
import com.cs18.anabeesh.salem.Adapters.PostAdapter;
import com.cs18.anabeesh.salem.model.GetArticales;
import com.cs18.anabeesh.salem.model.GetPosts;
import com.cs18.anabeesh.salem.ui.AllArticle.AllArticlesActivity;
import com.cs18.anabeesh.salem.ui.writeArticle.WriteActicleActivity;
import com.rxmuhammadyoussef.core.util.PreferencesUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;

public class ExpertHomeFragment extends Fragment implements ExpertScreen {

    @BindView(R.id.rv_article_id)
    RecyclerView articleRecyclerView;
    @BindView(R.id.rv_post_id)
    RecyclerView postRecyclerView;
    @BindView(R.id.fab_write_post_id)
    FloatingActionButton writrPost;
    private ExpertPresenter expertPresenter;
    private ArticleAdapter articleAdapter;
    private PostAdapter postAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        expertPresenter = new ExpertPresenter(new AuthRepo(new PreferencesUtil(getContext())), this);
        expertPresenter.Create();
    }

    @Override
    public void onResume() {
        super.onResume();
        expertPresenter.Create();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_expert_home, container, false);
        ButterKnife.bind(this, layout);
        return layout;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @OnClick(R.id.fab_write_post_id)
    void WriteArticle() {
        Intent WriteArticleIntent = new Intent(getContext(), WriteActicleActivity.class);
        startActivity(WriteArticleIntent);
    }

    @OnClick(R.id.iv_more)
    void showAllArticles() {
        Intent allArticles = new Intent(getContext(), AllArticlesActivity.class);
        startActivity(allArticles);
    }

    @Override
    public void setUpArticleRecyclerView(List<GetArticales> listOfArticles) {
        articleAdapter = new ArticleAdapter(getContext(), listOfArticles);
        articleRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        articleRecyclerView.setItemAnimator(new DefaultItemAnimator());
        articleRecyclerView.setAdapter(articleAdapter);
    }

    @Override
    public void setUpPostRecyclerView(List<GetPosts> listOfPosts) {
        postAdapter = new PostAdapter(getContext(), listOfPosts);
        postRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        postRecyclerView.setAdapter(postAdapter);
    }

    @Override
    public void UpdateArticlesForExpertUi(List<GetArticales> getArticalesList) {
        articleAdapter.Update(getArticalesList);
    }

    @Override
    public void ShowError(Throwable throwable) {
        Timber.e(throwable);
        Toast.makeText(getContext(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void UpdatePostsForExpertUi(List<GetPosts> getPosts) {
        postAdapter.Update(getPosts);
    }
}
