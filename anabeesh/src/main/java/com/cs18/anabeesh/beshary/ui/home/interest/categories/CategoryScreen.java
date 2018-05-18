package com.cs18.anabeesh.beshary.ui.home.interest.categories;

import com.cs18.anabeesh.beshary.store.model.user.UserCategories;

import java.util.ArrayList;

public interface CategoryScreen {

    void showLoadingAnimation();
    void hideLoadingAnimation();
    void initializeComponents();
    void toCategoriesAdapter(ArrayList<UserCategories> userCategories);
    void showErrorMessage(String errorMessage);
}
