package com.cs18.anabeesh.ui.register.core;

import com.cs18.anabeesh.R;
import com.cs18.anabeesh.application.schedulers.ThreadSchedulers;
import com.cs18.anabeesh.application.schedulers.qualifier.ComputationalThread;
import com.cs18.anabeesh.ui.register.di.RegisterScope;
import com.cs18.anabeesh.util.TextUtil;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.widget.TextViewAfterTextChangeEvent;
import com.jakewharton.rxrelay2.BehaviorRelay;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import io.reactivex.Observable;
import timber.log.Timber;

/**
 This class represents the Presenter layer of the registration process which handles all the logic
 */

@RegisterScope
public class RegisterPresenter {

    private final ThreadSchedulers threadSchedulers;
    private final TextUtil textUtil;
    private final BehaviorRelay<Boolean> buttonStateRelay;
    private final BehaviorRelay<Boolean> passwordStateRelay;

    @Inject
    RegisterPresenter(@ComputationalThread ThreadSchedulers threadSchedulers, TextUtil textUtil) {
        this.threadSchedulers = threadSchedulers;
        this.textUtil = textUtil;
        buttonStateRelay = BehaviorRelay.create();
        passwordStateRelay = BehaviorRelay.create();
    }

    void onAfterTextChanged(@NotNull InitialValueObservable<TextViewAfterTextChangeEvent> afterEmailChangeObservable,
                            @NotNull InitialValueObservable<TextViewAfterTextChangeEvent> afterPasswordChangeObservable) {
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

    Observable<Integer> observeIfPasswordShouldBeMarkedAsDone() {
        return passwordStateRelay.hide()
                .map(aBoolean -> {
                    if (aBoolean) {
                        return R.drawable.ic_done_register;
                    }
                    return 0;
                })
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
                .map(textUtil::isValidPassword)
                .doOnNext(passwordStateRelay::accept);
    }

    private boolean shouldEnableButton(boolean hasValidEmail, boolean hasValidPassword) {
        return hasValidEmail && hasValidPassword;
    }

    void next() {

    }
}
