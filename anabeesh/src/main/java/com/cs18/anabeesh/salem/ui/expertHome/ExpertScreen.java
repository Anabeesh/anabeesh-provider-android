package com.cs18.anabeesh.salem.ui.expertHome;

import com.cs18.anabeesh.salem.model.GetArticales;
import com.cs18.anabeesh.salem.model.GetPosts;

import java.util.List;

/**
 TODO: Add class header
 */

public interface ExpertScreen {
    void setUpArticleRecyclerView(List<GetArticales> listOfArticles);

    void setUpPostRecyclerView(List<GetPosts> listOfPosts);

    void UpdateArticlesForExpertUi(List<GetArticales> listOfArticles);

    void ShowError(Throwable throwable);

    void UpdatePostsForExpertUi(List<GetPosts> getPosts);
}
