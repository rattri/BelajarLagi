package com.solfashop.model;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;

import com.solfashop.ActivityMain;
import com.solfashop.BaseActivity;

import java.io.Serializable;

/**
 * Created by Ratri on 10/3/2016.
 */
public class Order implements Serializable {
    String produk;
    int harga;
    int jumlah;
    int total;
    String picture;

    public String getProduk() {
        return produk;
    }

    public void setProduk(String produk) {
        this.produk = produk;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void cardOnClock(final BaseActivity activity){
        Intent i = new Intent(activity, ActivityMain.class);
        i.putExtra(BaseActivity.EXTRA_MODEL, this);
        i.putExtra(BaseActivity.KEY_FRAGMENT, BaseActivity.FRAGMENT_PRICELIST);
        i.putExtra("judul", "Price");
        activity.startFragment(i);
    }
}
