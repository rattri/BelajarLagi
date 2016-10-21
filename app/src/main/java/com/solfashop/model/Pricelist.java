package com.solfashop.model;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;

import com.solfashop.ActivityMain;
import com.solfashop.BaseActivity;
import com.solfashop.fragment.CheckoutFragment;

import java.io.Serializable;

/**
 * Created by Ratri on 10/3/2016.
 */
public class Pricelist implements Serializable {
    String id, nama, harga, id_kategori;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getId_kategori() {
        return id_kategori;
    }

    public void setId_kategori(String id_kategori) {
        this.id_kategori = id_kategori;
    }

    public void cardOnClock(final BaseActivity activity, String kategori){
        Intent i = new Intent(activity, ActivityMain.class);
        i.putExtra(BaseActivity.EXTRA_MODEL, this);
        i.putExtra(BaseActivity.KEY_FRAGMENT, BaseActivity.FRAGMENT_CHECKOUT);
        i.putExtra("judul", "Price");
        i.putExtra(CheckoutFragment.KEY_KATEGORI, kategori);
        activity.startFragment(i);
        System.out.println("tes");
    }
}
