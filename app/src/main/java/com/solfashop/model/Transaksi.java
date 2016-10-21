package com.solfashop.model;

import android.content.Intent;

import com.solfashop.ActivityMain;
import com.solfashop.BaseActivity;

import java.io.Serializable;

/**
 * Created by Ratri on 10/20/2016.
 */
public class Transaksi implements Serializable {
    String id;
    String voucher;
    String nominal;
    String harga;
    String jumlah;
    String total;
    String tanggal;
    String jam;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    public String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
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

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    String status;

    public void transaksiOnClick (final BaseActivity activity){
        Intent i = new Intent(activity, ActivityMain.class);
        i.putExtra(BaseActivity.EXTRA_MODEL, this);
        i.putExtra(BaseActivity.KEY_FRAGMENT, BaseActivity.FRAGMENT_DETAILTRANSAKSI);
        i.putExtra("judul", "Detail Order");
        activity.startFragment(i);
    }


}
