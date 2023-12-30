package com.hotfoot.rapid.ai.security.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public ResponseEntity<String> handleError(HttpServletRequest request) {
        // Your custom error handling logic
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthenticated Request");
    }

    public String getErrorPath() {
        return "/error";
    }
}
