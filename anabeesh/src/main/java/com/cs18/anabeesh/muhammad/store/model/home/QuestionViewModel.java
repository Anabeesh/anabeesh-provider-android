package com.cs18.anabeesh.muhammad.store.model.home;

import java.util.ArrayList;

/**
 TODO: Add class header
 */

public class QuestionViewModel {

    //Question
    private final long questionId;
    private final String headline;
    private final String description;
    private final ArrayList<String> tags;
    private final long numberOfAnswers;
    private final long upVotes;
    private final String questionDate;
    private final String questionImagePreviewUrl;
    //User
    private final long userId;
    private final String userDisplayName;

    QuestionViewModel(long questionId,
                      String headline,
                      String description,
                      ArrayList<String> tags,
                      long numberOfAnswers,
                      long upVotes,
                      String questionDate,
                      String questionImagePreviewUrl,
                      long userId,
                      String userDisplayName) {
        this.questionId = questionId;
        this.headline = headline;
        this.description = description;
        this.tags = tags;
        this.numberOfAnswers = numberOfAnswers;
        this.upVotes = upVotes;
        this.questionDate = questionDate;
        this.questionImagePreviewUrl = questionImagePreviewUrl;
        this.userId = userId;
        this.userDisplayName = userDisplayName;
    }

    public long getQuestionId() {
        return questionId;
    }

    public String getHeadline() {
        return headline;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public long getNumberOfAnswers() {
        return numberOfAnswers;
    }

    public long getUpVotes() {
        return upVotes;
    }

    public String getQuestionDate() {
        return questionDate;
    }

    public String getQuestionImagePreviewUrl() {
        return questionImagePreviewUrl;
    }

    public long getUserId() {
        return userId;
    }

    public String getUserDisplayName() {
        return userDisplayName;
    }
}
