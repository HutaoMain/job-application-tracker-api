package com.jobapplication.tracker.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobapplication.tracker.repository.UserRepository;
import com.jobapplication.tracker.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class SocialController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    private final static String redirectUrl = "http://localhost:4200";

    @GetMapping
    public Map<String, Object> currentUser(OAuth2AuthenticationToken oAuth2AuthenticationToken,
            HttpServletRequest request, HttpServletResponse response) throws IOException {

        Map<String, Object> attributes = oAuth2AuthenticationToken.getPrincipal().getAttributes();

        String email = (String) attributes.get("email");
        String name = (String) attributes.get("name");
        String pictureUrl = (String) attributes.get("picture");

        boolean emailExists = userRepository.existsByEmail(email);

        if (emailExists) {
            log.info("User with email {} already exists in the database, skipping save", email);
        } else {
            userService.createUser(email, name, pictureUrl);
            log.info("User saved to database with email {}", email);
        }

        response.sendRedirect(redirectUrl);

        return attributes;
    }
}