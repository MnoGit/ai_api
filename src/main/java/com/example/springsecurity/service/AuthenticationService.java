package com.example.springsecurity.service;

import com.example.springsecurity.model.request.AuthenticationRequest;
import com.example.springsecurity.model.response.AuthenticationResponse;
import com.example.springsecurity.repository.UserRepository;
import com.example.springsecurity.security.JwtAuthenticationFilter;
import com.example.springsecurity.security.JwtUtil;
import com.example.springsecurity.service.seviceImp.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {    private final UserServiceImp userServiceImp;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getName(),
                        authenticationRequest.getPassword()
                )
        );
        var user = userRepository.getUserByUserName(authenticationRequest.getName());

        System.out.println("User information : " + user);
        var jwtToken = jwtUtil.generateToken(user);

        return AuthenticationResponse.builder().token(jwtToken).build();
    }

}
