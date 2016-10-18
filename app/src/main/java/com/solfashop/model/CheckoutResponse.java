package com.solfashop.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import retrofit2.http.PUT;

/**
 * Created by Ratri on 10/18/2016.
 */
    public class CheckoutResponse implements Serializable {
        String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    String message;

    }


