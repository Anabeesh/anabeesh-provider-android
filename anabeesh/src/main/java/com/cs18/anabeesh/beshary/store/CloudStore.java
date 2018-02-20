package com.cs18.anabeesh.beshary.store;

import com.cs18.anabeesh.beshary.store.api.APIsUtil;
import com.cs18.anabeesh.beshary.store.api.ApiError;
import com.cs18.anabeesh.beshary.store.model.user.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 TODO: Add class header
 */

class CloudStore {
    private static final int SUCCESS = 200;
    private static final int FAILURE = 400;

    public void login(String email, String password, AuthApiCallback authListener) {
        APIsUtil.getAPIService()
                .login(email, password)
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.code() == SUCCESS) {
                            authListener.onSuccess(response.body());
                        } else {
                            authListener.onFail(new ApiError(getErrorMessage(response.errorBody())));
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        authListener.onFail(t);
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
}
