package com.solfashop.API.Interfaces;


import com.solfashop.model.Voucher;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ratri on 10/3/2016.
 */
public interface VoucherService {
    @GET("voucherlist.php")
    Call<List<Voucher>> getVoucher(@Query("name") String a);
}
