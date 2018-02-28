package com.example.oauth.pojo;

import org.springframework.security.core.userdetails.User;

import java.util.Collections;


/**
 * 自定义UserDetails类 携带User实例
 */
public class MyUserDetails extends User {

    private com.example.oauth.pojo.User user;

    public MyUserDetails(com.example.oauth.pojo.User user) {
        super(user.getUserName(), user.getPassword(), true, true, true, true, Collections.EMPTY_SET);
        this.user = user;
    }

    public com.example.oauth.pojo.User getUser() {
        return user;
    }

    public void setUser(com.example.oauth.pojo.User user) {
        this.user = user;
    }
}
