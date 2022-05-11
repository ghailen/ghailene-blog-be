package com.ghailene.myblog.controller;

import com.ghailene.myblog.dto.LoginRequest;
import com.ghailene.myblog.dto.RegisterRequest;
import com.ghailene.myblog.service.AuthService;
import com.ghailene.myblog.service.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;


    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody RegisterRequest registerRequest) {
        authService.signup(registerRequest);
        return ResponseEntity.ok().build();
    }


    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest registerRequest) {
        return authService.login(registerRequest);

    }
}
