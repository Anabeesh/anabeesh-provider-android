package com.cs18.anabeesh.muhammad.ui.register;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;

import com.cs18.anabeesh.AnabeeshApplication;
import com.cs18.anabeesh.R;
import com.cs18.anabeesh.muhammad.di.activity.ActivityModule;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 This class represents the View layer of the registration process which handles all the UI interaction
 */

public class RegisterActivity extends Activity {

    @BindView(R.id.et_email)
    EditText emailEditText;

    @BindView(R.id.et_password)
    EditText passwordEditText;

    @BindView(R.id.btn_next)
    Button nextButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        AnabeeshApplication.getComponent(this)
                .plus(new ActivityModule(this))
                .inject(this);
        ButterKnife.bind(this);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @OnClick(R.id.btn_next)
    void next() {
    }
}
