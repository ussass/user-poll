package com.example.userPoll.api.response;

import com.example.userPoll.model.QuestionType;
import com.fasterxml.jackson.annotation.JsonProperty;

public class QuestionResponse {

    @JsonProperty(index = 0, value = "question_text")
    private String text;

    @JsonProperty(index = 1, value = "question_type")
    private QuestionType type;

    private AnswerResponse answer;

    public QuestionResponse(String text, QuestionType type, AnswerResponse answer) {
        this.text = text;
        this.type = type;
        this.answer = answer;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    public AnswerResponse getAnswer() {
        return answer;
    }

    public void setAnswer(AnswerResponse answer) {
        this.answer = answer;
    }
}
