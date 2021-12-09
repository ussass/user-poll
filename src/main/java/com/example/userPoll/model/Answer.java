package com.example.userPoll.model;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private long userId;

    private String text;

    @Enumerated(EnumType.STRING)
    private QuestionType type;

    @OneToOne
    @JoinColumn(name = "poll_id")
    private Poll pollId;

    @OneToOne
    @JoinColumn(name = "question_id")
    private Question questionId;

    public Answer() {
    }

    public Answer(long userId, String text, QuestionType type, Poll pollId, Question questionId) {
        this.userId = userId;
        this.text = text;
        this.type = type;
        this.pollId = pollId;
        this.questionId = questionId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    public Poll getPollId() {
        return pollId;
    }

    public void setPollId(Poll pollId) {
        this.pollId = pollId;
    }

    public Question getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Question questionId) {
        this.questionId = questionId;
    }
}
