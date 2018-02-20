package com.rxmuhammadyoussef.core.widget.rxedittext.email;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.text.InputType;
import android.util.AttributeSet;

import com.jakewharton.rxbinding2.widget.RxTextView;
import com.rxmuhammadyoussef.core.util.Preconditions;
import com.rxmuhammadyoussef.core.widget.rxedittext.ValidityListener;

public class EmailEditText extends AppCompatEditText {

    private EmailPresenter presenter;
    private ValidityListener validityListener;

    public EmailEditText(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        validityListener = result -> {};
        presenter = new EmailPresenter(context, validityListener);
        setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
    }

    public EmailEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public EmailEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void setValidityListener(ValidityListener validityListener) {
        this.validityListener = Preconditions.requireNonNull(validityListener, "validityListener required non null");
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        presenter.onAfterTextChanged(RxTextView.afterTextChangeEvents(this));
    }

    @Override
    protected void onDetachedFromWindow() {
        presenter.onDetachedFromWindow();
        super.onDetachedFromWindow();
    }
}
