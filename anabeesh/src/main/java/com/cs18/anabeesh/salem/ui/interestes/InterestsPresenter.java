package com.cs18.anabeesh.salem.ui.interestes;

import com.cs18.anabeesh.salem.Adapters.InterestsAdapter;
import com.cs18.anabeesh.salem.Retrofit.RetrofitClint;
import com.cs18.anabeesh.salem.Retrofit.UserServic;
import com.cs18.anabeesh.salem.model.InteresetsApiResponse;

import java.net.SocketTimeoutException;

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
    InterestsAdapter interestsAdapter;

    InterestsPresenter(InterestsActivity interestsActivity) {
        interestsScreen = interestsActivity;
    }

    //Creat UI commponanet and fetch data
    void onCreate() {
        interestsScreen.setupToolbar();
        interestsScreen.setupSwipLayout();
        interestsScreen.setupRecyclerView();
        //Change here
        fetchInterests()
                //  .map(apiResponse -> apiResponse.getMainInterestings())//Get Main catagroies
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(interestsScreen::updateUi, interestsScreen::ShowError);
    }

    // this  method  to fetch Our Intresting  to make  user  choose  from it
    private Single<InteresetsApiResponse> fetchInterests() {
        return Single.create(emitter -> RetrofitClint.getInstance()
                .create(UserServic.class)
                .getUserInterests()
                .enqueue(new Callback<InteresetsApiResponse>() {
                    @Override
                    public void onResponse(Call<InteresetsApiResponse> call, Response<InteresetsApiResponse> response) {

                        if (response.code() == 200) {
                            emitter.onSuccess(response.body());
                        } else {
                            emitter.onError(new Exception(" حاول مره اخري"));
                        }
                    }

                    @Override
                    public void onFailure(Call<InteresetsApiResponse> call, Throwable t) {
                        emitter.onError(new Exception("خطأ في الشبكه"));

                        if (t instanceof SocketTimeoutException) {
                            emitter.onError(new Exception(" تحققك من اتصال الشبكه"));
                        }
                    }
                }));
    }
}
