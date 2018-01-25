package com.cs18.anabeesh.ui.register;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.cs18.anabeesh.R;
import com.cs18.anabeesh.di.fragment.FragmentScope;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 TODO: Add class header
 */

@FragmentScope
public class EmailPasswordFragment extends Fragment {

    @BindView(R.id.et_email)
    EditText emailEditText;
    @BindView(R.id.et_password)
    EditText passwordEditText;

    @Inject
    RegisterScreen registerScreen;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Get Activity component and Inject
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_email_pass, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @OnClick(R.id.btn_next)
    void next(){
        registerScreen.setFragment(new FirstLastNameFragment());
    }
}
