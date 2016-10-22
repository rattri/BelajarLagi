package com.solfashop.API.form;

import com.solfashop.BaseActivity;

import retrofit2.http.Query;

/**
 * Created by Ratri on 10/18/2016.
 */
public class CheckoutForm {
    String user;
    String produk;
    String jumlah;
    String total;

     public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getProduk() {
        return produk;
    }

    public void setProduk(String produk) {
        this.produk = produk;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public static void goToDetail(BaseActivity activity, CheckoutForm mCheckoutForm) {
    }


    }



