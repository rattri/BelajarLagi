package com.solfashop.model;

/**
 * Created by Ratri on 10/25/2016.
 */
public class Cart {
    int id;
    String id_produk;
    int jumlah;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public Cart(int i, String string, int parseInt){}

    public String getId_produk() {
        return id_produk;
    }

    public void setId_produk(String id_produk) {
        this.id_produk = id_produk;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }


}
