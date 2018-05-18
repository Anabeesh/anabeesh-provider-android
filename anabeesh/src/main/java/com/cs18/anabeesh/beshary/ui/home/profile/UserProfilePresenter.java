package com.cs18.anabeesh.beshary.ui.home.profile;

import com.cs18.anabeesh.R;
import com.cs18.anabeesh.beshary.TextUtil;
import com.cs18.anabeesh.beshary.store.api.APIsUtil;
import com.cs18.anabeesh.beshary.store.model.user.User;
import com.rxmuhammadyoussef.core.util.ResourcesUtil;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserProfilePresenter {

    private UserProfileScreen userProfileScreen;
    private final ResourcesUtil resourcesUtil;

    UserProfilePresenter(UserProfileScreen userProfileScreen, ResourcesUtil resourcesUtil) {
        this.userProfileScreen = userProfileScreen;
        this.resourcesUtil = resourcesUtil;
    }

    void configureEditText () {
        userProfileScreen.
                setUpEmailEditText();
        userProfileScreen.
                setUpFirstNameEditText();
        userProfileScreen.
                setUpLastNameEditText();
    }

    void updateCurrentUser(final User currentUser) {
        userProfileScreen.showLoadingAnimation();
        APIsUtil.getAPIService()
                .updateUserProfile(currentUser.getUserId(),currentUser.getUserEmail(),
                currentUser.getUserFirstName(),currentUser.getUserLastName()).
                enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        switch (response.code())
                        {
                            case TextUtil.SUCCESS:
                                userProfileScreen.hideLoadingAnimation();
                                userProfileScreen.showSuccessMessage(resourcesUtil.getString(R.string.done));
                                userProfileScreen.showCurrentUserInfo();
                                break;
                            case TextUtil.FAILURE:
                                userProfileScreen.hideLoadingAnimation();
                                userProfileScreen.showErrorMessage(resourcesUtil.getString(R.string.not_valid_user));
                                break;
                        }
                    }
                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        userProfileScreen.hideLoadingAnimation();
                        userProfileScreen.showErrorMessage(resourcesUtil.getString(R.string.network_error));
                    }
                });
    }
}
