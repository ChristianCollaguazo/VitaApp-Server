package com.vitaapp.backend.tesis.web.controller;

import com.vitaapp.backend.tesis.domain.Admin;
import com.vitaapp.backend.tesis.domain.dto.AuthenticationRequest;
import com.vitaapp.backend.tesis.domain.dto.AuthenticationResponse;
import com.vitaapp.backend.tesis.domain.services.AdminService;
import com.vitaapp.backend.tesis.web.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AuthAdminController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AdminService adminService;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/auth")
    public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest request) {
        Admin admin = adminService.getByEmail(request.getUsername());
        if(admin == null) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            UserDetails userDetails = adminService.loadUserByUsername(request.getUsername());
            String jwt = jwtUtil.generateToken(userDetails);
            return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
        } catch (BadCredentialsException exception) {
            return  new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/valid")
    public ResponseEntity<Boolean> validateToken() {
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
