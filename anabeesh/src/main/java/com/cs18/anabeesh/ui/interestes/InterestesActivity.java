package com.cs18.anabeesh.ui.interestes;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.cs18.anabeesh.Adapters.IntrastesAdapter;
import com.cs18.anabeesh.AnabeeshApplication;
import com.cs18.anabeesh.R;
import com.cs18.anabeesh.di.activity.ActivityModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InterestesActivity extends Activity {
    @BindView(R.id.intrastaing_btn_id)
    Button Nextbutton;

    @BindView(R.id.intrasting_imgs_RV_id)
    RecyclerView imagesRecyclerView;
    @Inject
    interestesPresenter presenter;

    IntrastesAdapter intrastesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interestes);
        AnabeeshApplication.getComponent(this)
                .plus(new ActivityModule(this))
                .inject(this);
        ButterKnife.bind(this);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        Nextbutton.setClickable(false);
        presenter.BulidRecyclerView(this, imagesRecyclerView);
    }

   /* @OnClick(R.id.intrastaing_btn_id)
    void next() {
        presenter.MakeButtonCliackable(Nextbutton, this);
    }*/
}

