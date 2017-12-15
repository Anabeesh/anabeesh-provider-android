package com.cs18.anabeesh.ui.login.core

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.cs18.anabeesh.R
import com.cs18.anabeesh.application.AnabeeshApplication
import com.cs18.anabeesh.ui.login.di.LoginModule
import com.cs18.anabeesh.ui.login.di.LoginScope
import com.jakewharton.rxbinding2.widget.RxTextView
import timber.log.Timber
import javax.inject.Inject

/**
 * This class represents the View layer of the login process which handles all the UI interaction
 */

@LoginScope
class LoginActivity : Activity(), LoginScreen {

    @BindView(R.id.layout_container_login)
    internal lateinit var layoutContainer: LinearLayout

    @BindView(R.id.et_email)
    internal lateinit var emailEditText: EditText

    @BindView(R.id.et_password)
    internal lateinit var passwordEditText: EditText

    @BindView(R.id.btn_login)
    internal lateinit var loginButton: Button

    @Inject
    internal lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        AnabeeshApplication.getComponent(this)
                .plus(LoginModule(this))
                .inject(this)
        ButterKnife.bind(this)
        presenter.onCreate()
    }

    override fun setupLayout() {
        actionBar.setDisplayHomeAsUpEnabled(true)
        presenter.onAfterTextChanged(
                RxTextView.afterTextChangeEvents(emailEditText),
                RxTextView.afterTextChangeEvents(passwordEditText))
        presenter.observeIfLoginButtonShouldBeEnabled()
                .subscribe({ isEnabled -> loginButton.isEnabled = isEnabled }, Timber::e)
    }

    @OnClick(R.id.btn_login)
    internal fun login() {
        presenter.login()
    }

    @OnClick(R.id.tv_forgot_password)
    internal fun forgotPassword() {
        presenter.forgotPassword()
    }
}
