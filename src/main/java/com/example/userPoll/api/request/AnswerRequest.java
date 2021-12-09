package com.example.userPoll.api.request;

import com.example.userPoll.model.QuestionType;

public class AnswerRequest {

    private final String text;

    private final QuestionType type;

    public AnswerRequest(String text, QuestionType type) {
        this.text = text;
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public QuestionType getType() {
        return type;
    }
}
