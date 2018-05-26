package com.cs18.anabeesh.salem.ui.expertHome;

import com.cs18.anabeesh.beshary.TextUtil;
import com.cs18.anabeesh.beshary.store.AuthRepo;
import com.cs18.anabeesh.beshary.store.api.APIsUtil;
import com.cs18.anabeesh.salem.model.Articles;
import com.cs18.anabeesh.salem.model.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExpertPresenter {

    private final AuthRepo authRepo;
    private final ExpertScreen expertScreen;

    public ExpertPresenter(AuthRepo authRepo, ExpertScreen expertScreen) {
        this.expertScreen = expertScreen;
        this.authRepo = authRepo;
    }

    public void loadHomePage() {
        final String userId = authRepo.getCurrentUser().getUserId();
        fetchArticles(userId);
        fetchPosts(userId);
    }

     void fetchPosts(String userId) {
        APIsUtil.getAPIService()
                .getPosts(userId)
                .enqueue(new Callback<List<Posts>>() {
                    @Override
                    public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                        switch (response.code())
                        {
                            case TextUtil.SUCCESS :
                                expertScreen.setUpPostRecyclerView(response.body());
                                break;
                            // TODO : un-registered user .
                        }
                    }
                    @Override
                    public void onFailure(Call<List<Posts>> call, Throwable t) {

                    }
                });
    }

    public void fetchArticles(String userId) {
        APIsUtil.getAPIService()
                .getArticles(userId,TextUtil.PAGE,TextUtil.PAGE_SIZE)
                .enqueue(new Callback<List<Articles>>() {
                    @Override
                    public void onResponse(Call<List<Articles>> call, Response<List<Articles>> response) {
                        switch (response.code())
                        {
                            case TextUtil.SUCCESS :
                                expertScreen.setUpArticleRecyclerView(response.body());
                                break;
                            // TODO : un-registered user .
                        }
                    }
                    @Override
                    public void onFailure(Call<List<Articles>> call, Throwable t) {


                    }
                });
    }
}