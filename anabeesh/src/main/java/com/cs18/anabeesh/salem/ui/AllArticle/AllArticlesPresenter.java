package com.cs18.anabeesh.salem.ui.AllArticle;

import com.cs18.anabeesh.beshary.TextUtil;
import com.cs18.anabeesh.beshary.store.AuthRepo;
import com.cs18.anabeesh.beshary.store.api.APIsUtil;
import com.cs18.anabeesh.salem.model.Articles;

import java.net.SocketTimeoutException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllArticlesPresenter {

    private final AllArticlesScreen allArticlesScreen;
    private final AuthRepo authRepo;

    public AllArticlesPresenter(AllArticlesScreen allArticlesScreen, AuthRepo authRepo) {this.allArticlesScreen = allArticlesScreen;
        this.authRepo = authRepo;
    }

    public void createUI() {
        allArticlesScreen.setUpToolbar();
        fetchAllArticles();
    }

    private void fetchAllArticles() {
        final String userId = authRepo.getCurrentUser().getUserId();
        APIsUtil.getAPIService()
                .getArticles(userId, TextUtil.PAGE, TextUtil.PAGE_SIZE)
                .enqueue(new Callback<List<Articles>>() {
                    @Override
                    public void onResponse(Call<List<Articles>> call, Response<List<Articles>> response) {
                        switch (response.code())
                        {
                            case TextUtil.SUCCESS :
                                allArticlesScreen.setupRecyclerView(response.body());
                                allArticlesScreen.ShowMassage("تم");
                                break;
                            case TextUtil.FAILURE:
                                allArticlesScreen.ShowMassage("خطأ");
                                break;
                        }
                    }
                    @Override
                    public void onFailure(Call<List<Articles>> call, Throwable t) {
                        allArticlesScreen.ShowMassage("خطأ في الشبكه");
                        if (t instanceof SocketTimeoutException) {
                            allArticlesScreen.ShowMassage(" تحققك من اتصال الشبكه");
                        }
                    }
                });
    }
}
