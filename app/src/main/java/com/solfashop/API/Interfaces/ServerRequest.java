package com.solfashop.API.Interfaces;

import com.solfashop.model.User;

/**
 * Created by Ratri on 10/5/2016.
 */
public class ServerRequest {

    private String operation;

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setUser(com.solfashop.model.User user) {
        this.user = user;
    }

    private User user;
}
