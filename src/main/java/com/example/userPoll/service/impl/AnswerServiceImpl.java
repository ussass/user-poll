package com.example.userPoll.service.impl;

import com.example.userPoll.model.Answer;
import com.example.userPoll.model.Question;
import com.example.userPoll.model.Poll;
import com.example.userPoll.repositories.AnswerRepository;
import com.example.userPoll.service.AnswerService;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;

    public AnswerServiceImpl(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public Answer save(Answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public void deleteByPoll(Poll poll) {
        answerRepository.deleteByPollId(poll);
    }

    @Override
    public void deleteByQuestion(Question question) {
        answerRepository.deleteByQuestionId(question);
    }
}
