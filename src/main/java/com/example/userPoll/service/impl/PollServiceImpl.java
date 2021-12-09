package com.example.userPoll.service.impl;

import com.example.userPoll.api.request.QuestionRequest;
import com.example.userPoll.api.request.PollPassedRequest;
import com.example.userPoll.api.request.PollRequest;
import com.example.userPoll.api.response.AnswerResponse;
import com.example.userPoll.api.response.QuestionResponse;
import com.example.userPoll.api.response.ResultResponse;
import com.example.userPoll.api.response.PollResponse;
import com.example.userPoll.exception.ApplicationException;
import com.example.userPoll.model.Answer;
import com.example.userPoll.model.Poll;
import com.example.userPoll.repositories.AnswerRepository;
import com.example.userPoll.repositories.PollRepository;
import com.example.userPoll.service.AnswerService;
import com.example.userPoll.service.QuestionService;
import com.example.userPoll.service.PollService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PollServiceImpl implements PollService {

    private final PollRepository pollRepository;

    private final QuestionService questionService;

    private final AnswerService answerService;

    private final AnswerRepository answerRepository;

    public PollServiceImpl(PollRepository pollRepository, QuestionService questionService, AnswerService answerService, AnswerRepository answerRepository) {
        this.pollRepository = pollRepository;
        this.questionService = questionService;
        this.answerService = answerService;
        this.answerRepository = answerRepository;
    }

    @Override
    public ResultResponse addPoll(PollRequest request) {

        Poll Poll = new Poll(request.getName(),
                request.getDescription(),
                request.getTimestampEndDate());

        return new ResultResponse(true, pollRepository.save(Poll));
    }

    @Override
    public ResultResponse updatePoll(long id, PollRequest request) {
        Poll newPoll = new Poll(request.getName(),
                request.getDescription(),
                request.getTimestampEndDate());
        Poll oldPoll = getById(id);

        oldPoll.setName(newPoll.getName());
        oldPoll.setDescription(newPoll.getDescription());
        oldPoll.setEndDate(newPoll.getEndDate());
        return new ResultResponse(true, pollRepository.save(oldPoll));
    }

    @Override
    public ResultResponse deleteById(long id) {
        answerService.deleteByPoll(getById(id));
        pollRepository.delete(getById(id));
        return new ResultResponse(true);
    }

    @Override
    public List<PollResponse> getActivePollList() {
        List<Poll> pollList = StreamSupport.stream(pollRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return pollList.stream()
                .map(poll -> new PollResponse(
                        poll.getName(),
                        poll.getDescription(),
                        poll.getStartDate(),
                        poll.getEndDate()))
                .collect(Collectors.toList());
    }

    @Override
    public ResultResponse addQuestionToPoll(long PollId, QuestionRequest request) {
        return new ResultResponse(true, questionService.addQuestionToPoll(getById(PollId), request));
    }

    @Override
    public Poll getById(long id) {
        return pollRepository.findById(id).orElseThrow(
                () -> new ApplicationException(String.format("Опроса с id = %d не существует", id)));
    }

    @Override
    public ResultResponse passPollByUser(PollPassedRequest request) {
        request.getPollPassedList().forEach(
                poll -> poll.getQuestions()
                        .forEach(question -> answerService.save(
                                new Answer(
                                        request.getUserId(),
                                        question.getAnswer().getText(),
                                        question.getAnswer().getType(),
                                        getById(poll.getId()),
                                        questionService.getById(question.getId())))));
        return new ResultResponse(true);
    }

    @Override
    public List<PollResponse> getDetalizationByUserId(long userId) {

        List<Answer> answerList = answerRepository.finAllByUserId(userId);

        Map<Poll, List<QuestionResponse>> map = new HashMap<>();

        for (Answer a : answerList) {
            Poll key = a.getPollId();
            QuestionResponse questionResponse =
                    new QuestionResponse(
                            a.getQuestionId().getText(),
                            a.getQuestionId().getType(),
                            new AnswerResponse(a.getText(), a.getType()));

            if (map.containsKey(key)) {
                map.get(key).add(questionResponse);
            } else {
                map.put(key, new ArrayList<>(List.of(questionResponse)));
            }
        }

        return map.keySet().stream()
                .map(key -> new PollResponse(key.getName(), key.getDescription(), map.get(key)))
                .collect(Collectors.toList());
    }
}
