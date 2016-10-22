package com.solfashop.API.Interfaces;


import com.solfashop.model.Transaksi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ratri on 10/20/2016.
 */
public interface TransaksiService {
    @GET("list_transaksi.php")
    Call<List<Transaksi>> getTransaksi(@Query("user" ) String iduser);
}
