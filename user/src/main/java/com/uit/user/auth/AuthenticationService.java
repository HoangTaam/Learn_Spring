package com.uit.user.auth;

import com.uit.common.auth.AuthenticationRequest;
import com.uit.common.auth.AuthenticationResponse;
import com.uit.common.auth.RegisterRequest;
import com.uit.common.service.JwtService;
import com.uit.user.model.UserDTO;
import com.uit.user.repository.UserDTORepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    @Autowired
    private final UserDTORepository userDTPRepository;
    @Autowired
    private JwtService jwtService;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request){
        var user = new UserDTO();
        user.setUserName(request.getUserName());
        user.setEmail(request.getEmail());
        user.setUserPassWord(passwordEncoder.encode(request.getPassWord()));
        user.setRole(request.getRole());
        userDTPRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
    public AuthenticationResponse authenticate(AuthenticationRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassWord()
                )
        );
        var user = userDTPRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
