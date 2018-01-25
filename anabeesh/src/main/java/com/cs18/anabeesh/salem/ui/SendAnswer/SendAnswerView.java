package com.cs18.anabeesh.salem.ui.SendAnswer;

import com.cs18.anabeesh.salem.model.AllAnswers;

import java.util.List;

/**
 TODO: Add class header
 */

public interface SendAnswerView {
    void setupToolBar();

    void setUpAnswerRecyclerView(List<AllAnswers> list);

    void showResponseMsg(String Msg);
}
