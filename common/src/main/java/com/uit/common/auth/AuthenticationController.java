package com.uit.common.auth;

import com.uit.common.dto.GeneralApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;
    @PostMapping("/register")
    public GeneralApiResponse<AuthenticationResponse> register(
            @RequestBody RegisterRequest registerRequest){
        return new GeneralApiResponse<>(authenticationService.register(registerRequest));
    }
    @PostMapping("/authenticate")
    public GeneralApiResponse<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest authenticationRequest){
        return new GeneralApiResponse<>(authenticationService.authenticate(authenticationRequest));
    }
}
