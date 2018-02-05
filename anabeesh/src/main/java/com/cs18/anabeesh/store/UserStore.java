package com.cs18.anabeesh.store;

import com.cs18.ApiHelper;
import com.cs18.anabeesh.api.ApiClient;
import com.cs18.anabeesh.store.model.LogInUserResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 TODO: Add class header
 */

public class UserStore {

    public interface AuthListener{
        void onSuccess(LogInUserResponse body);

        void onFail(Throwable throwable);
    }
   public void login(String email, String password, AuthListener authListener){
        ApiClient.getClient()
                .create(ApiClient.UserLogInQueries.class)
                .getUserLogInResponse(email,password)
                .enqueue(new Callback<LogInUserResponse>() {
                    @Override
                    public void onResponse(Call<LogInUserResponse> call, Response<LogInUserResponse> response)
                    {
                        if  (response.code() == ApiHelper.SUCCESS) {
                            authListener.onSuccess(response.body());
                            LogInUserResponse userResponseObject = response.body();
                            String userId = userResponseObject.getUserId();
                            } else if(response.code() == ApiHelper.FAILURE) {
                            JSONObject jsonObject;
                            String errorMessage = null;
                            try {
                                jsonObject = new JSONObject(response.errorBody().string());
                                errorMessage = jsonObject.getString(ApiHelper.ERROR_MESSAGE);
                                authListener.onFail(new Exception(errorMessage));

                            } catch (JSONException | IOException e) {
                              authListener.onFail(e);
                            }if (errorMessage.equals(ApiHelper.IN_VALID_EMAIL)) {
                                //TODO : Handling invalid e-mail.
                            }
                            else
                            if(errorMessage.equals(ApiHelper.IN_VALID_PASS)) {
                                //TODO : Handling invalid password
                            }
                        }
                    }
                    @Override
                    public void onFailure(Call<LogInUserResponse> call, Throwable t) {
                        authListener.onFail(t);
                    }
                });
    }
}
