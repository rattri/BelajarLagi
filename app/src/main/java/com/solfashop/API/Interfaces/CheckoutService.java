package com.solfashop.API.Interfaces;

import com.solfashop.model.CheckoutResponse;
import com.solfashop.model.Pricelist;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Ratri on 10/18/2016.
 */
public interface CheckoutService {

    @POST("transaksi.php")
    Call<CheckoutResponse> getCheckoutResponse(
            @Query("id_user") String id_user,
            @Query("id_produk") String id_produk,
            @Query("jumlah") int jumlah,
            @Query("total") int total);
}

