package com.solfashop.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.solfashop.API.Interfaces.CheckoutService;
import com.solfashop.API.Interfaces.OrderService;
import com.solfashop.API.ServiceGenerator;
import com.solfashop.BaseActivity;
import com.solfashop.holder.OrderHolder;
import com.solfashop.model.Checkout;
import com.solfashop.model.CheckoutResponse;
import com.solfashop.model.Order;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ratri on 10/18/2016.
 */
public class CheckoutAdapter {

    Context context;
    BaseActivity activity;
    String produk, user;
    int ijumlah, itotal;

    public CheckoutAdapter(BaseActivity activity, String id_produk, String id_user, int jumlah, int total){
        context = activity.getBaseContext();
        this.activity = activity;
        produk = id_produk;
        user = id_user;
        ijumlah = jumlah;
        itotal = total;


    }

    public void initData(){
        CheckoutService checkoutService = ServiceGenerator.connect(CheckoutService.class);
        Call<CheckoutResponse> checkoutResponseCall = checkoutService.getCheckoutResponse(user, produk, ijumlah, itotal);
        checkoutResponseCall.enqueue(new Callback<CheckoutResponse>() {
            @Override
            public void onResponse(Call<CheckoutResponse> call, Response<CheckoutResponse> response) {
                if(response.isSuccess()){
                    System.out.println("sukses");
                }
            }

            @Override
            public void onFailure(Call<CheckoutResponse> call, Throwable t) {

            }
        });
    }
}
