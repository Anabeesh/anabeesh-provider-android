package com.cs18.anabeesh.salem.ui.AllArticle;

import com.cs18.anabeesh.salem.model.GetArticales;

import java.util.List;

/**
 TODO: Add class header
 */

public interface AllArticlesScreen {
    void setUpToolbar();

    void setupRecyclerview(List<GetArticales> listOfArticles);

    void ShowMassage(String msg);
}
