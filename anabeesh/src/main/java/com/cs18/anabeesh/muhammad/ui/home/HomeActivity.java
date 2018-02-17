package com.cs18.anabeesh.muhammad.ui.home;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.widget.Toolbar;

import com.cs18.anabeesh.AnabeeshApplication;
import com.cs18.anabeesh.R;
import com.cs18.anabeesh.muhammad.di.activity.ActivityModule;
import com.cs18.anabeesh.muhammad.di.activity.ActivityScope;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 This class represents the View layer of the home page which handles all the UI interaction
 */

@ActivityScope
public class HomeActivity extends Activity implements HomeScreen {

    @BindView(R.id.refresh_layout_home)
    SwipeRefreshLayout homeLayout;
    @BindView(R.id.rv_home)
    RecyclerView homeRecyclerView;
    @BindView(R.id.tb_home)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appBarLayout;

    @Inject
    RecyclerAdapter adapter;
    @Inject
    HomePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        AnabeeshApplication.getComponent(this)
                .plus(new ActivityModule(this))
                .inject(this);
        ButterKnife.bind(this);
        presenter.onCreate();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public void setupToolbar() {
        setActionBar(toolbar);
    }

    @Override
    public void setupRefreshListener() {
        homeLayout.setOnRefreshListener(() -> presenter.refreshHome());
    }

    @Override
    public void setupRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        homeRecyclerView.setLayoutManager(layoutManager);
        homeRecyclerView.setAdapter(adapter);
        homeRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (recyclerView.canScrollVertically(-1)) {
                    ViewCompat.setElevation(appBarLayout, 6);
                } else {
                    ViewCompat.setElevation(appBarLayout, 0);
                }
            }
        });
    }

    @Override
    public void showRefreshingAnimation() {
        homeLayout.setRefreshing(true);
    }

    @Override
    public void showLoadingMoreQuestionsAnimation() {
    }

    @Override
    public void hideLoadingAnimation() {
        homeLayout.setRefreshing(false);
    }

    @Override
    public void updateUi() {
        adapter.updateUi();
    }
}
