package com.example.userPoll.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PollPassedRequest {

    @JsonProperty(value = "user_id")
    private final long userId;

    @JsonProperty(value = "poll")
    private final List<PollRequest> pollPassedList;

    public PollPassedRequest(long userId, List<PollRequest> pollPassedList) {
        this.userId = userId;
        this.pollPassedList = pollPassedList;
    }

    public long getUserId() {
        return userId;
    }

    public List<PollRequest> getPollPassedList() {
        return pollPassedList;
    }
}
