package com.example.userPoll.rest;

import com.example.userPoll.api.request.LoginRequest;
import com.example.userPoll.api.response.ResultResponse;
import com.example.userPoll.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthenticationService authenticationService;

    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<ResultResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authenticationService.login(request));
    }

    @GetMapping("/logout")
    @PreAuthorize("hasAuthority('user:moderate') and hasAuthority('user:write')")
    public ResponseEntity<ResultResponse> logout() {
        return ResponseEntity.ok(authenticationService.logout());
    }
}
