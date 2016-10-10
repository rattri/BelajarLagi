package com.solfashop.model;

/**
 * Created by Ratri on 10/5/2016.
 */
public class ServerResponse {
    private String result;
    private String message;

    public String getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }

    private User user;
}
