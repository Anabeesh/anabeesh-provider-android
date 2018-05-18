package com.cs18.anabeesh.beshary.ui.home.interest.categories;

import com.cs18.anabeesh.beshary.TextUtil;
import com.cs18.anabeesh.beshary.store.api.APIsUtil;
import com.cs18.anabeesh.beshary.store.model.user.UserCategories;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class CategoryPresenter {
    private CategoryScreen categoryScreen;


    public CategoryPresenter(CategoryScreen categoryScreen) {
        this.categoryScreen = categoryScreen;
    }

    void onCreate () {
    }

    void loadCategoriesList(String userId) {
        categoryScreen.showLoadingAnimation();
        APIsUtil.getAPIService()
                .getCategories(userId)
                .enqueue(new Callback<ArrayList<UserCategories>>() {
                    @Override
                    public void onResponse(Call<ArrayList<UserCategories>> call, Response<ArrayList<UserCategories>> response) {
                        categoryScreen.hideLoadingAnimation();
                        switch (response.code())
                        {
                            case TextUtil.SUCCESS :
                                categoryScreen.toCategoriesAdapter(response.body());
                                break;
                            case TextUtil.FAILURE :
                                categoryScreen.showErrorMessage(getErrorMessage(response.errorBody()));
                                break;
                        }
                    }
                    @Override
                    public void onFailure(Call<ArrayList<UserCategories>> call, Throwable t) {
                                // TODO :
                        }
                });
    }
    private String getErrorMessage(ResponseBody responseBody) {
        try {
            JSONObject errorResponse = new JSONObject(responseBody.string());
            return errorResponse.getString("Message");
        } catch (JSONException | IOException e) {
            Timber.e(e);
        }
        return "";
    }

    void followCategory (String userId,String categoryId,CategoriesItemScreen categoriesItemScreen) {
        categoryScreen.showLoadingAnimation();
        APIsUtil.getAPIService()
                .followCategory(userId,categoryId)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        categoryScreen.hideLoadingAnimation();
                        switch (response.code())
                        {
                            case TextUtil.SUCCESS:
                                categoriesItemScreen.onSuccess();
                                categoryScreen.hideLoadingAnimation();
                                break;
                            case TextUtil.FAILURE:
                                categoriesItemScreen.onFailure();
                                categoryScreen.hideLoadingAnimation();
                                break;
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
    }

    void unFollowCategory(String userId,String categoryId,CategoriesItemScreen categoriesItemScreen) {
        categoryScreen.showLoadingAnimation();
        APIsUtil.getAPIService()
                .unFollowCategory(userId,categoryId)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        categoryScreen.hideLoadingAnimation();
                        switch (response.code())
                        {
                            case TextUtil.SUCCESS:
                                categoriesItemScreen.onSuccess();
                                categoryScreen.hideLoadingAnimation();
                                break;
                            case TextUtil.FAILURE:
                                categoriesItemScreen.onFailure();
                                categoryScreen.hideLoadingAnimation();
                                break;
                        }
                    }
                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        // TODO :
                    }
                });
    }
}