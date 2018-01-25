package com.cs18.anabeesh.salem.ui.expertHome;

import com.cs18.anabeesh.beshary.store.AuthRepo;
import com.cs18.anabeesh.salem.Retrofit.RetrofitClint;
import com.cs18.anabeesh.salem.Retrofit.UserService;
import com.cs18.anabeesh.salem.model.GetArticales;
import com.cs18.anabeesh.salem.model.GetPosts;

import java.net.SocketTimeoutException;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 TODO: Add class header
 */

public class ExpertPresenter {

    private final AuthRepo authRepo;
    private final ExpertScreen expertScreen;

    public ExpertPresenter(AuthRepo authRepo, ExpertScreen expertScreen) {
        this.expertScreen = expertScreen;
        this.authRepo = authRepo;
    }

    public void Create() {
        FetchArticles()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((expertScreen::UpdateArticlesForExpertUi), expertScreen::ShowError);
        FetchPostes()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((expertScreen::UpdatePostsForExpertUi), expertScreen::ShowError);
    }
    //TODO for both methods remove the fake list and get an id  from omar beshary

    private Single<List<GetPosts>> FetchPostes() {
        //static ID,page and Page size
        String Userid = authRepo.getCurrentUser().getUserId();
        String Page = "1";
        String PageSize = "50";
        return Single.create((SingleEmitter<List<GetPosts>> emitter) -> RetrofitClint.getInstance()
                .create(UserService.class)
                .getPosts(Userid)
                .enqueue(new Callback<List<GetPosts>>() {
                    @Override
                    public void onResponse(Call<List<GetPosts>> call, Response<List<GetPosts>> response) {

                        if (response.code() == 200) {
                            //response.body();
                            expertScreen.setUpPostRecyclerView(response.body());
                        } else {
                            emitter.onError(new Exception("المستخدم غير موجود"));
                        }
                    }

                    @Override
                    public void onFailure(Call<List<GetPosts>> call, Throwable t) {

                        emitter.onError(new Exception("خطأ في الشبكه"));

                        if (t instanceof SocketTimeoutException) {
                            emitter.onError(new Exception(" تحققك من اتصال الشبكه"));
                        }
                    }
                }));
    }

    private Single<List<GetArticales>> FetchArticles() {
        String Userid = authRepo.getCurrentUser().getUserId();
        String Page = "1";
        String PageSize = "50";
        return Single.create((SingleEmitter<List<GetArticales>> emitter) -> RetrofitClint.getInstance()
                .create(UserService.class)
                .getArticles(Userid, Page, PageSize)
                .enqueue(new Callback<List<GetArticales>>() {
                    @Override
                    public void onResponse(Call<List<GetArticales>> call, Response<List<GetArticales>> response) {
                        if (response.code() == 200) {
                            expertScreen.setUpArticleRecyclerView(response.body());
                        } else {
                            emitter.onError(new Exception("المستخدم غير موجود"));
                        }
                    }

                    @Override
                    public void onFailure(Call<List<GetArticales>> call, Throwable t) {
                        emitter.onError(new Exception("خطأ في الشبكه"));

                        if (t instanceof SocketTimeoutException) {
                            emitter.onError(new Exception(" تحققك من اتصال الشبكه"));
                        }
                    }
                }));
    }
}
