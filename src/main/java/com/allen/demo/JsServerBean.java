package com.allen.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by Allen on 2017/6/27.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsServerBean {
    private String password;
    private String userId;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "JsServerBean{" +
                "password='" + password + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
