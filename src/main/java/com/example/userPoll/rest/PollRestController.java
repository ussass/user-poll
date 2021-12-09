package com.example.userPoll.rest;

import com.example.userPoll.api.request.QuestionRequest;
import com.example.userPoll.api.request.PollPassedRequest;
import com.example.userPoll.api.request.PollRequest;
import com.example.userPoll.api.response.ResultResponse;
import com.example.userPoll.api.response.PollResponse;
import com.example.userPoll.model.Poll;
import com.example.userPoll.service.QuestionService;
import com.example.userPoll.service.PollService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/poll")
public class PollRestController {

    private final PollService pollService;

    private final QuestionService questionService;

    public PollRestController(PollService pollService, QuestionService questionService) {
        this.pollService = pollService;
        this.questionService = questionService;
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('user:moderate')")
    public ResponseEntity<ResultResponse> addPoll(@RequestBody PollRequest request) {

        return ResponseEntity.ok(pollService.addPoll(request));
    }

    @PutMapping("/{id}/update")
    @PreAuthorize("hasAuthority('user:moderate')")
    public ResponseEntity<ResultResponse> updatePoll(@PathVariable long id,
                                                       @RequestBody PollRequest request) {
        return ResponseEntity.ok(pollService.updatePoll(id, request));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('user:moderate')")
    public ResponseEntity<ResultResponse> deletePoll(@PathVariable long id) {
        return ResponseEntity.ok(pollService.deleteById(id));
    }


    @PostMapping("/{id}/question")
    @PreAuthorize("hasAuthority('user:moderate')")
    public ResponseEntity<ResultResponse> addQuestionToPoll(@PathVariable long id,
                                                              @RequestBody QuestionRequest request) {
        return ResponseEntity.ok(pollService.addQuestionToPoll(id, request));
    }

    @PutMapping("/question/{id}")
    @PreAuthorize("hasAuthority('user:moderate')")
    public ResponseEntity<ResultResponse> updateQuestionInPoll(@PathVariable long id,
                                                                 @RequestBody QuestionRequest request) {
        return ResponseEntity.ok(questionService.updateQuestion(id, request));
    }

    @DeleteMapping("/question/{id}")
    @PreAuthorize("hasAuthority('user:moderate')")
    public ResponseEntity<ResultResponse> deleteQuestionFromPoll(@PathVariable long id) {
        return ResponseEntity.ok(questionService.deleteById(id));
    }


    @GetMapping("/active")
    public ResponseEntity<List<PollResponse>> getActiveList() {
        return ResponseEntity.ok(pollService.getActivePollList());
    }

    @GetMapping("/active/{id}")
    public ResponseEntity<Poll> getActivePoll(@PathVariable long id) {
        return ResponseEntity.ok(pollService.getById(id));
    }

    @PostMapping("/pass")
    public ResponseEntity<ResultResponse> passPoll(@RequestBody PollPassedRequest request) {
        return ResponseEntity.ok(pollService.passPollByUser(request));
    }

    @GetMapping("/passed/{id}")
    public ResponseEntity<List<PollResponse>> getPassedPollByUserId(@PathVariable long id) {
        return ResponseEntity.ok(pollService.getDetalizationByUserId(id));
    }

}
