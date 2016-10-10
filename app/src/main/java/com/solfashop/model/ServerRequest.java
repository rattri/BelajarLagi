package com.solfashop.model;

/**
 * Created by Ratri on 10/5/2016.
 */
public class ServerRequest {

    private String operation;

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User user;
}
