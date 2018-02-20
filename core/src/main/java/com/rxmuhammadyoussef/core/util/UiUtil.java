package com.rxmuhammadyoussef.core.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.rxmuhammadyoussef.core.R;

public class UiUtil {

    private final Context context;
    private ProgressDialog progressDialog;

    public UiUtil(Context context) {
        Preconditions.checkNonNull(context, "should not pass null context reference");
        this.context = context;
    }

    public ProgressDialog getProgressDialog(String message) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(context);
        }
        progressDialog.setCancelable(false);
        progressDialog.setMessage(Preconditions.requireStringNotEmpty(message));
        return progressDialog;
    }

    public ProgressDialog getProgressDialog() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(context);
        }
        return progressDialog;
    }

    public Toast getSuccessToast(String message) {
        return createToast(getLayoutInflater().inflate(R.layout.layout_success_toast, new FrameLayout(context)), message);
    }

    private Toast createToast(View view, String message) {
        Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_SHORT);
        ((TextView) view.findViewById(R.id.tv_message)).setText(message);
        toast.setView(view);
        return toast;
    }

    private LayoutInflater getLayoutInflater() {
        return LayoutInflater.from(context);
    }

    public Toast getWarningToast(String message) {
        return createToast(getLayoutInflater().inflate(R.layout.layout_warning_toast, new FrameLayout(context)), message);
    }

    public Toast getErrorToast(String message) {
        return createToast(getLayoutInflater().inflate(R.layout.layout_error_toast, new FrameLayout(context)), message);
    }

    public Toast getAnnouncementToast(String message) {
        return createToast(getLayoutInflater().inflate(R.layout.layout_announcement_toast, new FrameLayout(context)), message);
    }
}