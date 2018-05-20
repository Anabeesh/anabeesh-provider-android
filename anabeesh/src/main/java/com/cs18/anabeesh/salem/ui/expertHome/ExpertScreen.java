package com.cs18.anabeesh.salem.ui.expertHome;

import com.cs18.anabeesh.salem.model.Articles;
import com.cs18.anabeesh.salem.model.Posts;

import java.util.List;

/**
 TODO: Add class header
 */

public interface ExpertScreen {
    void setUpArticleRecyclerView(List<Articles> listOfArticles);

    void setUpPostRecyclerView(List<Posts> listOfPosts);

    void UpdateArticlesForExpertUi(List<Articles> listOfArticles);

    void ShowError(Throwable throwable);

    void UpdatePostsForExpertUi(List<Posts> posts);
}
