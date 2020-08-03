package com.auth.jwt.controller;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import security.model.request.User;

import java.util.Date;

@RestController
public class LoginController {

    @GetMapping("hello")
    public String salutation() {
        return "Hello world!";
    }

    @PostMapping("usertoken")
    public User login(@RequestParam("user") String username, @RequestParam("password") String pwd) {

        String token = getJWTToken(username);
        User user = new User();
        user.setUsername(username);
        user.setToken(token);
        user.setPassword(pwd);

        return user;
    }

    private String getJWTToken(String username) {
        String secretKey = "VASS2020Key";
        String token = Jwts
                .builder()
                .setId("softeekJWT")
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                //.setExpiration(new Date(System.currentTimeMillis() + 999999999))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        System.out.println("TOKEN GENERADO :::: "  + token);

        return "Bearer " + token;

    }


}

