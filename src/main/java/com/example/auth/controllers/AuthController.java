package com.example.auth.controllers;

import com.example.auth.dtos.RegisterUserDto;
import com.example.auth.responses.LoginResponse;
import com.example.auth.services.AuthenticationService;
import com.example.auth.entities.User;
import com.example.auth.dtos.LoginUserDto;
import com.example.auth.services.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/auth")
@RestController
public class AuthController {
//    Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    public AuthController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
//        logger.info(String.valueOf(registerUserDto));
        User registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse().setToken(jwtToken).setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}