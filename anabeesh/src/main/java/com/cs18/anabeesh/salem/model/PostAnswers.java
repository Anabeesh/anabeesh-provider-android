package com.cs18.anabeesh.salem.model;

import com.google.gson.annotations.SerializedName;

/**
 TODO: Add class header
 */

public class PostAnswers {
    @SerializedName("UserId")
    public String userId;
    @SerializedName("QuestionId")
    public Integer questionId;
    @SerializedName("Body")
    public String AnswerBody;

    public PostAnswers(String userId, Integer questionId, String answerBody) {
        this.userId = userId;
        this.questionId = questionId;
        AnswerBody = answerBody;
    }
}
