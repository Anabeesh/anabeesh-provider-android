package com.cs18.anabeesh.salem.ui.writeArticle;

import android.text.TextUtils;
import android.widget.EditText;

import com.cs18.anabeesh.beshary.store.AuthRepo;
import com.cs18.anabeesh.beshary.store.api.APIsUtil;
import com.cs18.anabeesh.salem.model.Article;
import com.cs18.anabeesh.salem.model.PostArticles;
import com.rxmuhammadyoussef.core.util.PreferencesUtil;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 TODO: Add class header
 */

public class WriteArticlePresenter {

    private final Integer DefultcategoryId = 2;
    private final String DefultUserId = "jsdvnjnnv";
    private final WriteArticleScreen writeArticleScreen;
    private PostArticles articles;
    private   final AuthRepo authRepo;

    public WriteArticlePresenter(WriteArticleScreen writeArticleScreen,PreferencesUtil preferencesUtil) {
        this.writeArticleScreen = writeArticleScreen;
        authRepo = new AuthRepo(preferencesUtil);
    }

    //TODO GET UserID and  CategoryId from login screen;
    public void CreateUI() {
        writeArticleScreen.setUpToolBarForWriteArticle();
    }

    public void SendTo(String HeadLing, String Body) {

        int CatagroyId = 1;
        String UserId = authRepo.getCurrentUser().getUserId();
        APIsUtil.getAPIService()
                .PostArticle(new PostArticles(new Article(HeadLing, Body), CatagroyId, UserId))
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.code() == 200) {
                            writeArticleScreen.showSuccessMessage();
                        } else {
                            writeArticleScreen.showErrorMessage("هذا المستخدم غير موجود");
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        writeArticleScreen.showErrorMessage("خطأ في الشبكه");
                        Timber.tag("onFailure").e(t);
                    }
                });
    }

    public boolean CheckValidation(EditText Tittle, EditText Headline) {
        if (TextUtils.isEmpty(Tittle.getText().toString())) {
            Tittle.setError("ادخل عنوان ");
            return false;
        } else if (TextUtils.isEmpty(Headline.getText().toString())) {
            Headline.setError("ادخل محتواي ");
            return false;
        }
        return true;
    }
}
