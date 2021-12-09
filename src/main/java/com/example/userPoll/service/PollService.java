package com.example.userPoll.service;

import com.example.userPoll.api.request.QuestionRequest;
import com.example.userPoll.api.request.PollPassedRequest;
import com.example.userPoll.api.request.PollRequest;
import com.example.userPoll.api.response.ResultResponse;
import com.example.userPoll.api.response.PollResponse;
import com.example.userPoll.model.Poll;

import java.util.List;

public interface PollService {

    Poll getById(long id);

    ResultResponse addPoll(PollRequest request);

    ResultResponse updatePoll(long id, PollRequest request);

    ResultResponse deleteById(long id);

    List<PollResponse> getActivePollList();

    ResultResponse addQuestionToPoll(long pollId, QuestionRequest request);

    ResultResponse passPollByUser(PollPassedRequest request);

    List<PollResponse> getDetalizationByUserId(long userId);
}
