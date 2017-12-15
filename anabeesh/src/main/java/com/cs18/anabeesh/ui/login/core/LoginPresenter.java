package com.cs18.anabeesh.ui.login.core;

import com.cs18.anabeesh.application.schedulers.ThreadSchedulers;
import com.cs18.anabeesh.application.schedulers.qualifier.ComputationalThread;
import com.cs18.anabeesh.ui.login.di.LoginScope;
import com.cs18.anabeesh.util.TextUtil;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.widget.TextViewAfterTextChangeEvent;
import com.jakewharton.rxrelay2.BehaviorRelay;

import javax.inject.Inject;

import io.reactivex.Observable;
import timber.log.Timber;

/**
 This class represents the Presenter layer of the login process which handles all the logic
 */

@LoginScope
class LoginPresenter {

    private final TextUtil textUtil;
    private final LoginScreen loginScreen;
    private final ThreadSchedulers threadSchedulers;
    private final BehaviorRelay<Boolean> buttonStateRelay;

    @Inject
    LoginPresenter(@ComputationalThread ThreadSchedulers threadSchedulers, LoginScreen loginScreen, TextUtil textUtil) {
        buttonStateRelay = BehaviorRelay.create();
        this.threadSchedulers = threadSchedulers;
        this.loginScreen = loginScreen;
        this.textUtil = textUtil;
    }

    void onCreate() {
        loginScreen.setupLayout();
    }

    void onAfterTextChanged(InitialValueObservable<TextViewAfterTextChangeEvent> afterEmailChangeObservable,
                            InitialValueObservable<TextViewAfterTextChangeEvent> afterPasswordChangeObservable) {
        Observable<Boolean> emailObservable = afterEmailChangeObservable
                .flatMap(this::observeIfValidEmail);

        Observable<Boolean> passwordObservable = afterPasswordChangeObservable
                .flatMap(this::observeIfValidPassword);

        Observable.combineLatest(
                emailObservable,
                passwordObservable,
                this::shouldEnableButton)
                .subscribeOn(threadSchedulers.subscribeOn())
                .observeOn(threadSchedulers.observeOn())
                .subscribe(buttonStateRelay::accept, Timber::e);
    }

    Observable<Boolean> observeIfLoginButtonShouldBeEnabled() {
        return buttonStateRelay.hide()
                .subscribeOn(threadSchedulers.subscribeOn())
                .observeOn(threadSchedulers.observeOn());
    }

    private Observable<Boolean> observeIfValidEmail(TextViewAfterTextChangeEvent textViewAfterTextChangeEvent) {
        return Observable.just(textViewAfterTextChangeEvent)
                .map(TextViewAfterTextChangeEvent::editable)
                .map(CharSequence::toString)
                .map(String::trim)
                .map(textUtil::isValidEmail);
    }

    private Observable<Boolean> observeIfValidPassword(TextViewAfterTextChangeEvent textViewAfterTextChangeEvent) {
        return Observable.just(textViewAfterTextChangeEvent)
                .map(TextViewAfterTextChangeEvent::editable)
                .map(CharSequence::toString)
                .map(String::trim)
                .map(textUtil::isValidPassword);
    }

    private boolean shouldEnableButton(boolean hasValidEmail, boolean hasValidPassword) {
        return hasValidEmail && hasValidPassword;
    }

    void login() {
    }

    void forgotPassword() {
    }
}
