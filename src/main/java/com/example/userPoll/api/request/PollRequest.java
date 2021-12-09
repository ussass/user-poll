package com.example.userPoll.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PollRequest {

    private final long id;

    private final String name;

    private final String description;

    @JsonProperty(value = "expiration_date")
    private final long timestampEndDate;

    private final List<QuestionRequest> questions;

    public PollRequest(long id, String name, String description, long timestampEndDate, List<QuestionRequest> questions) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.timestampEndDate = timestampEndDate;
        this.questions = questions;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public long getTimestampEndDate() {
        return timestampEndDate;
    }

    public List<QuestionRequest> getQuestions() {
        return questions;
    }
}
