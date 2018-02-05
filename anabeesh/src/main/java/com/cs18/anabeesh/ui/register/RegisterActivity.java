package com.cs18.anabeesh.ui.register;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;

import com.cs18.anabeesh.AnabeeshApplication;
import com.cs18.anabeesh.R;
import com.cs18.anabeesh.di.activity.ActivityModule;
//import android.app.Fragment;
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
        /*String userEmail = emailEditText.getText().toString();
        String userPassword = passwordEditText.getText().toString();

        if (TextUtil.isEmpty(userEmail)) {
            // TODO : Handling empty e-mail field .
            return;
        }
        if (TextUtil.isEmpty(userPassword)) {
            // TODO : Handling empty password field .
            return;
        }
        if (userPassword.length() < TextUtil.PASS_LENGTH) {
            // TODO : Handling short password .
            return;
        }
        Bundle bundle = new Bundle();

        bundle.putString(TextUtil.USER_MAIL,userEmail);
        bundle.putString(TextUtil.USER_PASS,userPassword);

    /**
         TODO : pass data to fragment

        // Begin the fragment transaction
        FragmentTransaction ft = getFragmentManager().beginTransaction();

        // Replace the contents of the container with the new fragment ,
        // and add the transaction to back stack
        ft.replace(R.id.frag_holder,new FirstAndLastNameFragment());
        ft.addToBackStack(null);

        // Complete the changes added above
        ft.commit();
   */
    }
}
