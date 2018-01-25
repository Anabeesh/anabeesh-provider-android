package com.cs18.anabeesh.salem.model;

import com.google.gson.annotations.SerializedName;

/**
 TODO: Add class header
 */

public class AllAnswers {
    @SerializedName("Id")
    public String Id;
    @SerializedName("Body")
    public String AnswerBody;
    @SerializedName("UserId")
    public String UserId;
    @SerializedName("QuestionId")
    public String QuestionId;



    public AllAnswers(String answerBody, String userId, String questionId) {
        AnswerBody = answerBody;
        UserId = userId;
        QuestionId = questionId;
    }

    public String getAnswerId() {
        return Id;
    }

    public String getAnswerBody() {
        return AnswerBody;
    }

    public String getUserId() {
        return UserId;
    }
    public String getQuestionId() {
        return QuestionId;
    }
}
