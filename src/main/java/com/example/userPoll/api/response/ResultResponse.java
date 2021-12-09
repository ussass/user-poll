package com.example.userPoll.api.response;

import com.example.userPoll.model.Question;
import com.example.userPoll.model.Poll;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultResponse {

    private boolean result;

    private String message;

    private Poll poll;

    private Question question;

    public ResultResponse(boolean result) {
        this.result = result;
    }

    public ResultResponse(boolean result, String message) {
        this.result = result;
        this.message = message;
    }

    public ResultResponse(boolean result, Poll poll) {
        this.result = result;
        this.poll = poll;
    }

    public ResultResponse(boolean result, Question question) {
        this.result = result;
        this.question = question;
    }


    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}

