package com.solfashop.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.solfashop.API.Interfaces.CheckOut;
import com.solfashop.API.Interfaces.CheckoutService;
import com.solfashop.API.Interfaces.OrderService;
import com.solfashop.API.ServiceGenerator;
import com.solfashop.API.form.CheckoutForm;
import com.solfashop.BaseActivity;
import com.solfashop.holder.OrderHolder;
import com.solfashop.model.Checkout;
import com.solfashop.model.CheckoutResponse;
import com.solfashop.model.Order;
import com.solfashop.model.test;

import java.io.IOException;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ratri on 10/18/2016.
 */
public class CheckoutAdapter {

    Context context;
    BaseActivity activity;

    CheckoutForm mCheckoutForm;

    String produk, user, kategori;
    int ijumlah, itotal;

    public CheckoutAdapter(BaseActivity activity, CheckoutForm checkoutForm){
        context = activity.getBaseContext();
        this.activity = activity;
//        produk = id_produk;
//        user = id_user;
//        ijumlah = jumlah;
//        itotal = total;
        //kategori=ikategori;
        mCheckoutForm = checkoutForm;


    }

    public void initData(){
        System.out.println(mCheckoutForm);

        CheckoutService checkoutService = ServiceGenerator.testCnc(CheckoutService.class);
        Call<CheckoutForm> checkoutResponseCall = checkoutService.getCheckoutResponse(mCheckoutForm);
        checkoutResponseCall.enqueue(new Callback<CheckoutForm>() {
            @Override
            public void onResponse(Call<CheckoutForm> call, Response<CheckoutForm> response) {
                if(response.isSuccess()){

                    System.out.println("....................sukses");
                    System.out.println(response.raw().toString());
//                    System.out.println("produk = "+response.body().getProduk());
                    System.out.println(new Gson().toJson(response.body()));
                    CheckoutForm.goToDetail(activity, mCheckoutForm);
                }
                else System.out.println("....................else");
            }

            @Override
            public void onFailure(Call<CheckoutForm> call, Throwable t) {
                System.out.println("...................."+t.toString());
            }
        });
    }
}
