package com.example.userPoll.service;

import com.example.userPoll.api.request.QuestionRequest;
import com.example.userPoll.api.response.ResultResponse;
import com.example.userPoll.model.Question;
import com.example.userPoll.model.Poll;

import java.util.List;

public interface QuestionService {

    Question getById(long id);

    Question addQuestionToPoll(Poll Poll, QuestionRequest request);

    List<Question> getAll();

    ResultResponse updateQuestion(long id, QuestionRequest request);

    ResultResponse deleteById(long id);
}
