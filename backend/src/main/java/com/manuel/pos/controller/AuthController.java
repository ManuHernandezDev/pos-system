package com.manuel.pos.controller;

import com.manuel.pos.dto.request.AuthRequest;
import com.manuel.pos.dto.response.AuthResponse;
import com.manuel.pos.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    public AuthController(AuthService authService){
        this.authService = authService;
    }
    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest authRequest){
        return authService.login(authRequest);
    }
}
