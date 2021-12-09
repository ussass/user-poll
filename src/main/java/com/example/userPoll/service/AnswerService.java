package com.example.userPoll.service;

import com.example.userPoll.model.Answer;
import com.example.userPoll.model.Question;
import com.example.userPoll.model.Poll;

public interface AnswerService {

    Answer save(Answer answer);

    void deleteByPoll(Poll poll);

    void deleteByQuestion(Question question);
}
