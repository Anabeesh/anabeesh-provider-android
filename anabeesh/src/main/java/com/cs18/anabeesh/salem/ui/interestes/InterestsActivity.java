package com.cs18.anabeesh.salem.ui.interestes;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.cs18.anabeesh.R;
import com.cs18.anabeesh.salem.Adapters.InterestsAdapter;
import com.cs18.anabeesh.salem.model.InteresetsApiResponse;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class InterestsActivity extends Activity implements InterestsScreen {

    @BindView(R.id.interests_btn_id)
    Button nextButton;
    @BindView(R.id.interests_img_RV_id)
    RecyclerView interestsRecyclerView;
    @BindView(R.id.refresh_layout_interests)
    SwipeRefreshLayout swipeRefreshLayoutInterests;
    InterestsPresenter presenter = new InterestsPresenter(this);
    private InterestsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interestes);
        ButterKnife.bind(this);
        presenter.onCreate();
    }

    @Override
    public void setupToolbar() {
        if (getActionBar() != null) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void setupRecyclerView() {
        adapter = new InterestsAdapter();
        interestsRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        interestsRecyclerView.setAdapter(adapter);
    }

    @Override
    public void ShowError(Throwable throwable) {
        Timber.e(throwable);
        Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateUi(InteresetsApiResponse interesetsApiResponse) {
        Log.d("Omar", "updateUi");
        adapter.update(interesetsApiResponse);
    }

    @Override
    public void setupSwipLayout() {
        swipeRefreshLayoutInterests.setOnRefreshListener(() -> {
            swipeRefreshLayoutInterests.setRefreshing(true);
            setupRecyclerView();
        });
    }




  /*  @OnClick(R.id.intrastaing_btn_id)
    void ButtonEnable() {
        //TODO Send then To HomePage and show Toast
        if(adapter.getSelectedItems()==true)
        Toast.makeText(this, "مرحبا بك في انابييش", Toast.LENGTH_SHORT).show();
    }*/
}

