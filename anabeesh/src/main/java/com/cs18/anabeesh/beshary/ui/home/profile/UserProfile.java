package com.cs18.anabeesh.beshary.ui.home.profile;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cs18.anabeesh.beshary.TextUtil;

import com.cs18.anabeesh.R;

import com.cs18.anabeesh.beshary.store.AuthRepo;
import com.cs18.anabeesh.beshary.store.model.user.User;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.rxmuhammadyoussef.core.util.PreferencesUtil;
import com.rxmuhammadyoussef.core.util.ResourcesUtil;
import com.rxmuhammadyoussef.core.util.UiUtil;

import org.jetbrains.annotations.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;

public class UserProfile extends AppCompatActivity implements UserProfileScreen{

    @BindView(R.id.et_email)
    EditText emailEditText;
    @BindView(R.id.tv_email_description)
    TextView emailHint;
    @BindView(R.id.et_first_name)
    EditText firstNameEditText;
    @BindView(R.id.tv_first_name_description)
    TextView firstNameDescription;
    @BindView(R.id.et_last_name)
    EditText lastNameEditText;
    @BindView(R.id.tv_last_name_description)
    TextView lastNameDescription;
    @BindView(R.id.btn_save_changes)
    Button saveChangesButton;

    private User currentUser;
    private UiUtil uiUtil;
    private UserProfilePresenter userProfilePresenter;
    private Observable<CharSequence> userEmailObservable;
    private Observable<CharSequence> userFirstNameObservable;
    private Observable<CharSequence> userLastNameObservable;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        ButterKnife.bind(this);
        uiUtil = new UiUtil(this);
        userProfilePresenter = new UserProfilePresenter(this,new ResourcesUtil(this));
        showCurrentUserInfo();
        userProfilePresenter.configureEditText();
    }


    @Override
    public void setUpEmailEditText() {
        userEmailObservable = RxTextView.textChanges(emailEditText)
                .skip(2);
        userEmailObservable.subscribe(charSequence -> {

            emailHint.setText(TextUtil.isValidEmail(charSequence.toString()) ? "" : "البريد الالكتروني غير صحيح.");
            emailHint.setTextColor(getResources().getColor(R.color.colorError));
            if (charSequence.toString().length() != 0)
                saveChangesButton.setEnabled(true);
        });
    }

    @Override
    public void setUpFirstNameEditText() {
        userFirstNameObservable = RxTextView.textChanges(firstNameEditText)
                .skip(2);
        userFirstNameObservable.subscribe(charSequence -> {

            firstNameDescription.setText(TextUtil.isValidName(charSequence.toString()) ? "" : "هذا الإسم غير صحيح.");
            firstNameDescription.setTextColor(getResources().getColor(R.color.colorError));
            if (charSequence.toString().length() != 0)
                saveChangesButton.setEnabled(true);
        });
    }

    @Override
    public void setUpLastNameEditText() {
        userLastNameObservable = RxTextView.textChanges(lastNameEditText)
                .skip(2);
        userLastNameObservable.subscribe(charSequence -> {

            lastNameDescription.setText(TextUtil.isValidName(charSequence.toString()) ? "" : "هذا الإسم غير صحيح.");
            lastNameDescription.setTextColor(getResources().getColor(R.color.colorError));
            if (charSequence.toString().length() != 0)
                saveChangesButton.setEnabled(true);
        });
    }

    @Override
    public void showLoadingAnimation() {
        uiUtil.getProgressDialog(getString(R.string.loading))
                .show();
    }


    @Override
    public void hideLoadingAnimation() {
        uiUtil.getProgressDialog()
                .dismiss();
    }

    @Override
    public void showSuccessMessage(String message) {
        uiUtil.getSuccessToast(message)
                .show();
    }

    @Override
    public void showErrorMessage(String message) {
        uiUtil.getErrorToast(message)
                .show();
    }

    @Override
    public void showCurrentUserInfo() {
        currentUser = new AuthRepo(new PreferencesUtil(this)).getCurrentUser();
        emailEditText.setText
                (currentUser.getUserEmail());
        firstNameEditText.setText
                (currentUser.getUserFirstName());
        lastNameEditText.setText
                (currentUser.getUserLastName());
        saveChangesButton.setEnabled(false);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && saveChangesButton.isEnabled()) {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setCancelable(false)
                    .setTitle(R.string.logout_message)
                    .setMessage(R.string.notify_of_changes)
                    .setPositiveButton(R.string.yes, (dialogInterface, i) ->
                            finish())
                    .setNegativeButton(R.string.no, (dialogInterface, i) -> {
                    })
                    .show();
        }
        return super.onKeyDown(keyCode, event);
    }

    @OnClick(R.id.btn_save_changes)
    void onButtonSaveChangesClicked () {

        String userChangedEmail = emailEditText.getText().toString(),
                userChangedFirstName = firstNameEditText.getText().toString(),
                userChangedLastName  = lastNameEditText.getText().toString();
        if(TextUtil.isValidEmail(userChangedEmail) && TextUtil.isValidName(userChangedFirstName) && TextUtil.isValidName(userChangedLastName))
        {
            currentUser.setUserEmail(userChangedEmail);
            currentUser.setUserFirstName(userChangedFirstName);
            currentUser.setUserLastName(userChangedLastName);
            new AuthRepo(new PreferencesUtil(this)).UpdateCurrentUser(currentUser);
            userProfilePresenter.updateCurrentUser(currentUser);
        }else
                new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setCancelable(false)
                    .setTitle(R.string.notify)
                    .setMessage(R.string.not_valid_fields)
                    .setPositiveButton(R.string.ok, (dialogInterface, i) -> {
                    })
                    .show();
    }

}
