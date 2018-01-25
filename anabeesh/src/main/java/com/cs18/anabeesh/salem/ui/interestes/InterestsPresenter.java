package com.cs18.anabeesh.salem.ui.interestes;

import com.cs18.anabeesh.salem.Retrofit.RetrofitClint;
import com.cs18.anabeesh.salem.Retrofit.UserServic;
import com.cs18.anabeesh.salem.model.InteresetsApiResponse;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 TODO: Add class header
 */

class InterestsPresenter {

    private final InterestsScreen interestsScreen;

    InterestsPresenter(InterestsActivity interestsActivity) {
        interestsScreen = interestsActivity;
    }

    void onCreate() {
        interestsScreen.setupToolbar();
        interestsScreen.setupRecyclerView();
        fetchInterests()
                .map(InteresetsApiResponse::getMainInterestings)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(interestsScreen::updateUi, interestsScreen::ShowError);
    }

    private Single<InteresetsApiResponse> fetchInterests() {
        return Single.create(emitter -> RetrofitClint.getInstance()
                .create(UserServic.class)
                .SendMainUserInterstes()
                .enqueue(new Callback<InteresetsApiResponse>() {
                    @Override
                    public void onResponse(Call<InteresetsApiResponse> call, Response<InteresetsApiResponse> response) {
                        if (response.code() == 200) {
                            emitter.onSuccess(response.body());
                        } else {
                            emitter.onError(new Exception("network error"));
                        }
                    }

                    @Override
                    public void onFailure(Call<InteresetsApiResponse> call, Throwable t) {
                        emitter.onError(t);
                    }
                }));
    }
}
