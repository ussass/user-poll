package com.example.userPoll.api.request;

import com.example.userPoll.model.QuestionType;

public class QuestionRequest {

    private final long id;

    private final String text;

    private final QuestionType type;

    private final AnswerRequest answer;

    public QuestionRequest(long id, String text, QuestionType type, AnswerRequest answer) {
        this.id = id;
        this.text = text;
        this.type = type;
        this.answer = answer;
    }

    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public QuestionType getType() {
        return type;
    }

    public AnswerRequest getAnswer() {
        return answer;
    }
}
