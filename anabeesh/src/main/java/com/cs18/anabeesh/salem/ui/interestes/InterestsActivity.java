package com.cs18.anabeesh.salem.ui.interestes;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.cs18.anabeesh.R;
import com.cs18.anabeesh.salem.Adapters.InterestsAdapter;
import com.cs18.anabeesh.salem.model.MainInteresting;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class InterestsActivity extends Activity implements InterestsScreen {

    @BindView(R.id.intrastaing_btn_id)
    Button nextButton;
    @BindView(R.id.intrasting_imgs_RV_id)
    RecyclerView interestsRecyclerView;

    private InterestsAdapter adapter;
    private InterestsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interestes);
        ButterKnife.bind(this);
        presenter = new InterestsPresenter(this);
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
    public void ShowError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ShowError(Throwable throwable) {
        Timber.e(throwable);
        Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateUi(List<MainInteresting> mainInterestings) {
        Log.d("Muhammad", "updateUi");
        adapter.update(mainInterestings);
    }
}

