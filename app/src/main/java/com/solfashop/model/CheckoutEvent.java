package com.solfashop.model;

/**
 * Created by Ratri on 10/18/2016.
 */


public class CheckoutEvent {
    private CheckoutResponse checkoutResponse;

    public CheckoutEvent(CheckoutResponse checkoutResponse) {
        this.checkoutResponse = checkoutResponse;
    }

    public CheckoutResponse getCheckoutResponse() {
        return checkoutResponse;
    }

    public void setCheckoutResponse(CheckoutResponse checkoutResponse) {
        this.checkoutResponse = checkoutResponse;
    }
}

