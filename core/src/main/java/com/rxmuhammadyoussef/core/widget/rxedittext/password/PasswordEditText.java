package com.rxmuhammadyoussef.core.widget.rxedittext.password;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.text.InputType;
import android.util.AttributeSet;

import com.jakewharton.rxbinding2.widget.RxTextView;
import com.rxmuhammadyoussef.core.util.Preconditions;
import com.rxmuhammadyoussef.core.widget.rxedittext.ValidityListener;

public class PasswordEditText extends AppCompatEditText {

    private PasswordPresenter presenter;

    public PasswordEditText(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        presenter = new PasswordPresenter(context);
        setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS | InputType.TYPE_TEXT_VARIATION_PASSWORD);
    }

    public PasswordEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PasswordEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void setValidityListener(ValidityListener validityListener) {
        presenter.onAfterTextChanged(
                RxTextView.afterTextChangeEvents(this),
                Preconditions.requireNonNull(validityListener, "validityListener required non null"));
    }

    @Override
    protected void onDetachedFromWindow() {
        presenter.onDetachedFromWindow();
        super.onDetachedFromWindow();
    }
}
