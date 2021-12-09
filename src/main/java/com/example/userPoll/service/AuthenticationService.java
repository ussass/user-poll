package com.example.userPoll.service;

import com.example.userPoll.api.request.LoginRequest;
import com.example.userPoll.api.response.ResultResponse;

public interface AuthenticationService {

    ResultResponse login(LoginRequest request);

    ResultResponse logout();
}
