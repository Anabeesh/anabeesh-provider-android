package com.cs18.anabeesh.salem.ui.SendAnswer;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.EditText;

import com.cs18.anabeesh.R;
import com.cs18.anabeesh.beshary.store.AuthRepo;
import com.cs18.anabeesh.salem.Retrofit.RetrofitClint;
import com.cs18.anabeesh.salem.Retrofit.UserService;
import com.cs18.anabeesh.salem.model.AllAnswers;
import com.cs18.anabeesh.salem.model.PostAnswers;

import java.net.SocketTimeoutException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 TODO: Add class header
 */

public class SendAnswerPressnter {
    private final SendAnswerView sendAnswerView;
    private final AuthRepo authRepo;

    private final String Q_Id = "1";

    public SendAnswerPressnter(SendAnswerView mSendAnswerView, AuthRepo authRepo) {
        sendAnswerView = mSendAnswerView;
        this.authRepo = authRepo;
    }

    public void CreateUI() {
        sendAnswerView.setupToolBar();
        fetchAllAnswers();
    }

    void fetchAllAnswers() {
        RetrofitClint.getInstance()
                .create(UserService.class)
                .getAllAnswers(Q_Id)
                .enqueue(new Callback<List<AllAnswers>>() {
                    @Override
                    public void onResponse(Call<List<AllAnswers>> call, Response<List<AllAnswers>> response) {

                        if (response.code() == 200) {
                            List<AllAnswers> answersList = response.body();
                            sendAnswerView.setUpAnswerRecyclerView(answersList);
                            sendAnswerView.showResponseMsg("تم");
                        } else {
                            sendAnswerView.showResponseMsg("خطأ");
                        }
                    }

                    @Override
                    public void onFailure(Call<List<AllAnswers>> call, Throwable t) {
                        sendAnswerView.showResponseMsg("خطأ في الشبكه");

                        if (t instanceof SocketTimeoutException) {
                            sendAnswerView.showResponseMsg(" تحققك من اتصال الشبكه");
                        }
                    }
                });
    }

    public void inisializeCutomDailog(Context context,String questionId) {
        String userId=  authRepo.getCurrentUser().getUserId();
        View customView = View.inflate(context, R.layout.layout_custom_dailog, null);
        EditText answerBody = customView.findViewById(R.id.et_comment);
        AlertDialog.Builder customBuilder = new AlertDialog.Builder(context);
        customView.findViewById(R.id.bt_yes).setOnClickListener(v -> {
            SendAnswer(userId, questionId, answerBody.getText().toString());
        });
        customView.findViewById(R.id.bt_no).setOnClickListener(v -> {
            customBuilder.setCancelable(true);
        });
        customBuilder.setView(customView);
        customBuilder.show();
    }

    void SendAnswer(String userId, String questionId, String answerBody) {
        RetrofitClint
                .getInstance()
                .create(UserService.class)
                .PostUserAnswer(new PostAnswers(userId, Integer.valueOf(questionId), answerBody))
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.code() == 200) {
                            sendAnswerView.showResponseMsg("شكرا لك");
                        } else {
                            sendAnswerView.showResponseMsg("خطأ");
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        sendAnswerView.showResponseMsg("خطأ في الشبكه ");
                    }
                });
    }
}
