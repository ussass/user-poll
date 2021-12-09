package com.example.userPoll.service.impl;

import com.example.userPoll.api.request.QuestionRequest;
import com.example.userPoll.api.response.ResultResponse;
import com.example.userPoll.exception.ApplicationException;
import com.example.userPoll.model.Question;
import com.example.userPoll.model.Poll;
import com.example.userPoll.repositories.QuestionRepository;
import com.example.userPoll.service.AnswerService;
import com.example.userPoll.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final AnswerService answerService;

    public QuestionServiceImpl(QuestionRepository questionRepository, AnswerService answerService) {
        this.questionRepository = questionRepository;
        this.answerService = answerService;
    }

    @Override
    public Question addQuestionToPoll(Poll poll, QuestionRequest request) {

        Question question = new Question(request.getText(), request.getType());
        question.setPollId(poll);
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getAll() {
        return null;
    }

    @Override
    public ResultResponse updateQuestion(long id, QuestionRequest request) {
        Question question = getById(id);

        question.setText(request.getText());
        question.setType(request.getType());
        return new ResultResponse(true, questionRepository.save(question));
    }

    @Override
    public Question getById(long id) {
        return questionRepository.findById(id).orElseThrow(
                () -> new ApplicationException(String.format("Вопроса с id = %d не существует", id))
        );
    }

    @Override
    public ResultResponse deleteById(long id) {
        answerService.deleteByQuestion(getById(id));   // удаляем все ответы для этого вопроса
        questionRepository.delete(getById(id));        // удаляем вопрос
        return new ResultResponse(true);
    }
}
