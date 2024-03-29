package com.vitaapp.backend.tesis.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/any")
public class TokenValidController {
    @GetMapping("/valid")
    public ResponseEntity<Boolean> validateToken() {
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
