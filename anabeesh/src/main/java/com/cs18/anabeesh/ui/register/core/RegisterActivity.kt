package com.cs18.anabeesh.ui.register.core

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.cs18.anabeesh.R
import com.cs18.anabeesh.application.AnabeeshApplication
import com.cs18.anabeesh.ui.register.di.RegisterModule
import com.cs18.anabeesh.ui.register.di.RegisterScope
import com.jakewharton.rxbinding2.widget.RxTextView
import timber.log.Timber
import javax.inject.Inject

/**
 * This class represents the View layer of the registration process which handles all the UI interaction
 */

@RegisterScope
class RegisterActivity : Activity() {

    @BindView(R.id.et_email)
    internal lateinit var emailEditText: EditText

    @BindView(R.id.et_password)
    internal lateinit var passwordEditText: EditText

    @BindView(R.id.tv_password_description)
    internal lateinit var passwordDecription: TextView

    @BindView(R.id.btn_next)
    internal lateinit var nextButton: Button

    @Inject
    internal lateinit var presenter: RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        AnabeeshApplication.getComponent(this)
                .plus(RegisterModule(this))
                .inject(this)
        ButterKnife.bind(this)
        setupLayout()
    }

    private fun setupLayout() {
        actionBar.setDisplayHomeAsUpEnabled(true)
        presenter.onAfterTextChanged(
                RxTextView.afterTextChangeEvents(emailEditText),
                RxTextView.afterTextChangeEvents(passwordEditText))
        presenter.observeIfPasswordShouldBeMarkedAsDone()
                .subscribe({ drawableID -> passwordDecription.setCompoundDrawablesWithIntrinsicBounds(drawableID, 0, 0, 0) })
        presenter.observeIfLoginButtonShouldBeEnabled()
                .subscribe({ isEnabled -> nextButton.isEnabled = isEnabled }, Timber::e)
    }

    @OnClick(R.id.btn_next)
    internal fun login() {
        presenter.next()
    }
}
