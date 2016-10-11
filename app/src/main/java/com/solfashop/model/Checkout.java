package com.solfashop.model;

/**
 * Created by Ratri on 10/11/2016.
 */
public class Checkout {
    public int cototal, coharga, cojumlah;
    public String conama;

    public int getCototal() {
        return cototal;
    }

    public void setCototal(int cototal) {
        this.cototal = cototal;
    }

    public int getCoharga() {
        return coharga;
    }

    public void setCoharga(int coharga) {
        this.coharga = coharga;
    }

    public int getCojumlah() {
        return cojumlah;
    }

    public void setCojumlah(int cojumlah) {
        this.cojumlah = cojumlah;
    }

    public String getConama() {
        return conama;
    }

    public void setConama(String conama) {
        this.conama = conama;
    }

    public String getConominal() {
        return conominal;
    }

    public void setConominal(String conominal) {
        this.conominal = conominal;
    }

    public String conominal;
}
