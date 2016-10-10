package com.solfashop.API.Interfaces;

import com.solfashop.fragment.PricelistFragment;
import com.solfashop.model.Pricelist;
import com.solfashop.model.Voucher;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ratri on 10/10/2016.
 */
public interface PricelistService {
    @GET("pricelist.php")
    Call<List<Pricelist>> getPricelist(@Query("" ) String kategori);

}
