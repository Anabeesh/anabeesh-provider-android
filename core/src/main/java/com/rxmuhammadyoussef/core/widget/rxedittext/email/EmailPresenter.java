package com.rxmuhammadyoussef.core.widget.rxedittext.email;

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

class EmailPresenter {

    private final TextUtil textUtil;
    private final CompositeDisposable disposable;

    EmailPresenter(Context context) {
        textUtil = new TextUtil(context);
        disposable = new CompositeDisposable();
    }

    void onAfterTextChanged(InitialValueObservable<TextViewAfterTextChangeEvent> emailAfterTextChangeObservable, ValidityListener validityListener) {
        disposable.add(
                emailAfterTextChangeObservable
                        .flatMap(this::observeIfValidEmail)
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(validityListener::onAfterTextChange, Timber::e));
    }

    private Observable<TextUtil.Result> observeIfValidEmail(TextViewAfterTextChangeEvent textViewAfterTextChangeEvent) {
        return Observable.just(textViewAfterTextChangeEvent)
                .filter(et -> et.view().isFocused())
                .map(TextViewAfterTextChangeEvent::editable)
                .map(CharSequence::toString)
                .map(String::trim)
                .map(textUtil::checkIfValidEmail);
    }

    void onDetachedFromWindow() {
        disposable.dispose();
    }
}