package com.cs18.anabeesh.salem.ui.AllArticle;

import com.cs18.anabeesh.salem.model.Articles;

import java.util.List;

public interface AllArticlesScreen {
    void setUpToolbar();
    void setupRecyclerView(List<Articles> listOfArticles);
    void ShowMassage(String msg);
}
