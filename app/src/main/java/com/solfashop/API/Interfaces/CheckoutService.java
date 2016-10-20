package com.solfashop.API.Interfaces;

import com.solfashop.API.form.CheckoutForm;
import com.solfashop.model.CheckoutResponse;
import com.solfashop.model.Pricelist;
import com.solfashop.model.test;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Ratri on 10/18/2016.
 */
public interface CheckoutService {
    @POST("transaksi.php")
    Call<CheckoutForm> getCheckoutResponse(@Body CheckoutForm checkoutForm);
}

