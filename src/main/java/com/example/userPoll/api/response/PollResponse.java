package com.example.userPoll.api.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PollResponse {

    @JsonProperty(index = 0, value = "poll_name")
    private final String name;

    @JsonProperty(index = 1, value = "poll_description")
    private final String description;

    @JsonProperty(index = 2, value = "start_date")
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    private LocalDateTime startDate;

    @JsonProperty(index = 3, value = "end_date")
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    private LocalDateTime endDate;

    private List<QuestionResponse> questions;

    public PollResponse(String name, String description, long startDate, long endDate) {
        this.name = name;
        this.description = description;
        this.startDate = LocalDateTime.ofInstant(Instant.ofEpochMilli(startDate), ZoneId.systemDefault());
        this.endDate = LocalDateTime.ofInstant(Instant.ofEpochSecond(endDate), ZoneId.systemDefault());
    }

    public PollResponse(String name, String description, List<QuestionResponse> questions) {
        this.name = name;
        this.description = description;
        this.questions = questions;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public List<QuestionResponse> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionResponse> questions) {
        this.questions = questions;
    }
}