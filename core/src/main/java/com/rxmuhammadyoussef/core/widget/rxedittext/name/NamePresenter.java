package com.rxmuhammadyoussef.core.widget.rxedittext.name;

import android.content.Context;

import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.widget.TextViewAfterTextChangeEvent;
import com.rxmuhammadyoussef.core.util.TextUtil;
import com.rxmuhammadyoussef.core.widget.rxedittext.ValidityListener;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

class NamePresenter {

    private final TextUtil textUtil;
    private final CompositeDisposable disposable;
    private final ValidityListener validityListener;

    NamePresenter(Context context, ValidityListener validityListener) {
        this.validityListener = validityListener;
        textUtil = new TextUtil(context);
        disposable = new CompositeDisposable();
    }

    void onAfterTextChanged(InitialValueObservable<TextViewAfterTextChangeEvent> emailAfterTextChangeObservable) {
        disposable.add(
                emailAfterTextChangeObservable
                        .flatMap(this::observeIfValidEmail)
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(validityListener::onAfterTextChange, Timber::e));
    }

    private Observable<TextUtil.Result> observeIfValidEmail(TextViewAfterTextChangeEvent textViewAfterTextChangeEvent) {
        return Observable.just(textViewAfterTextChangeEvent)
                .map(TextViewAfterTextChangeEvent::editable)
                .map(CharSequence::toString)
                .map(String::trim)
                .map(textUtil::checkIfValidName);
    }

    void onDetachedFromWindow() {
        disposable.dispose();
    }
}