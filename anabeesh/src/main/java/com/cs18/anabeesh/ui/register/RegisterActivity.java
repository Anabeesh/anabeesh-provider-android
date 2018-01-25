package com.cs18.anabeesh.ui.register;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.cs18.anabeesh.AnabeeshApplication;
import com.cs18.anabeesh.R;
import com.cs18.anabeesh.di.activity.ActivityModule;
import com.cs18.anabeesh.di.activity.ActivityScope;

import javax.inject.Inject;

/**
 This class represents the View layer of the registration process which handles all the UI interaction
 */

@ActivityScope
public class RegisterActivity extends Activity implements RegisterScreen{

    @Inject
    RegisterPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        AnabeeshApplication.getComponent(this)
                .plus(new ActivityModule(this))
                .inject(this);
        presenter.onCreate();
    }

    @Override
    public void setupToolbar() {
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void setFragment(Fragment fragment) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.email_pass_fragment, fragment);
        ft.commit();
    }
}
