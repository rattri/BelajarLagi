package com.solfashop.API.Interfaces;

import com.solfashop.model.Order;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Ratri on 10/3/2016.
 */
public interface OrderService {
    @GET("rattri/Solfa-Shop/master/checkout_fragment.json")
    Call<List<Order>> getOrder();
}
