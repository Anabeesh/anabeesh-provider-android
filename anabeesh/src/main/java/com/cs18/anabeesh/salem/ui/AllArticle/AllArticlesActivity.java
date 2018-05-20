package com.cs18.anabeesh.salem.ui.AllArticle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.cs18.anabeesh.R;
import com.cs18.anabeesh.beshary.store.AuthRepo;
import com.cs18.anabeesh.salem.Adapters.ArticleAdapter;
import com.cs18.anabeesh.salem.model.Articles;
import com.rxmuhammadyoussef.core.util.PreferencesUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AllArticlesActivity extends AppCompatActivity implements AllArticlesScreen {
    @BindView(R.id.rv_all_articles)
    RecyclerView allArticlesRecyclerview;
    @BindView(R.id.tb_all_articles)
    Toolbar allArticlesToolbar;
    private ArticleAdapter articleAdapter;
    private AllArticlesPresenter allArticlesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_articles);
        ButterKnife.bind(this);
        allArticlesPresenter = new AllArticlesPresenter(this, new AuthRepo(new PreferencesUtil(this)));
        allArticlesPresenter.createUI();
    }

    @Override
    public void setUpToolbar() {
        setSupportActionBar(allArticlesToolbar);
        getSupportActionBar().setTitle(R.string.allarticles);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        allArticlesToolbar.setNavigationOnClickListener(view -> onBackPressed());
    }

    @Override
    public void setupRecyclerView(List<Articles> listOfArticles) {
        articleAdapter = new ArticleAdapter(this, listOfArticles);
        allArticlesRecyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        allArticlesRecyclerview.setItemAnimator(new DefaultItemAnimator());
        allArticlesRecyclerview.setAdapter(articleAdapter);
    }

    @Override
    public void ShowMassage(String responseMsg) {
        Toast.makeText(this, responseMsg, Toast.LENGTH_SHORT).show();
    }
}
