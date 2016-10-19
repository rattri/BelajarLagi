package com.solfashop.API.Interfaces;

import com.solfashop.API.form.CheckoutForm;
import com.solfashop.model.test;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Ratri on 10/19/2016.
 */
public interface CheckOut {
    @POST("transaksi.php")
    Call<test> checkout(@Body CheckoutForm checkoutForm);
}
