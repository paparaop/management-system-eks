package com.ms.managementsystemeks.security.service;


import com.ms.managementsystemeks.security.dao.request.SignUpRequest;
import com.ms.managementsystemeks.security.dao.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SignUpRequest request);
}
