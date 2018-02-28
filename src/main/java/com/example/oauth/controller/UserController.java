package com.example.oauth.controller;

import com.example.oauth.pojo.MyUserDetails;
import com.example.oauth.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ManagementFactory;

@RestController
public class UserController {

    @Autowired
    private TokenStore tokenStore;

    @PostMapping("/bar")
    public String bar(@RequestHeader("Authorization") String auth) {
        MyUserDetails userDetails = (MyUserDetails) tokenStore.readAuthentication(auth.split(" ")[1]).getPrincipal();
        User user = userDetails.getUser();
        return user.getUserName() + ":" + user.getPassword();

    }
}
