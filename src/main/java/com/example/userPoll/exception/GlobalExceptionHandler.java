package com.example.userPoll.exception;

import com.example.userPoll.api.response.ResultResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AccessDeniedException.class)
    public final ResponseEntity<ResultResponse> handleAccessDeniedException(AccessDeniedException ex) {
        return handleInternal(HttpStatus.FORBIDDEN, ex.getLocalizedMessage());
    }

    @ExceptionHandler(ApplicationException.class)
    public final ResponseEntity<ResultResponse> handleAccessDeniedException(ApplicationException ex) {
        return handleInternal(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage());
    }

    private ResponseEntity<ResultResponse> handleInternal(HttpStatus status, String message) {
        return new ResponseEntity<>(new ResultResponse(false, message), status);
    }
}
