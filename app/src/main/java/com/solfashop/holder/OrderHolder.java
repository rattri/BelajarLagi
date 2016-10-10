package com.solfashop.holder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.solfashop.R;

/**
 * Created by Ratri on 10/3/2016.
 */
public class OrderHolder extends RecyclerView.ViewHolder{
    public TextView textProduk, textHarga, textJumlah, textTotal;
    public  ImageView imgCover;
    public View card;
    public OrderHolder(View itemView) {
        super(itemView);
        textProduk = (TextView) itemView.findViewById(R.id.text_produk);
        textHarga = (TextView) itemView.findViewById(R.id.text_harga);
        textJumlah = (TextView) itemView.findViewById(R.id.text_jumlah);
        textTotal = (TextView) itemView.findViewById(R.id.text_total);
        imgCover = (ImageView) itemView.findViewById(R.id.img_cover);
        card = (View) itemView.findViewById(R.id.card_order);
        System.out.println("itemView");
    }

    public OrderHolder(ViewGroup parrent){
        this(LayoutInflater.from(parrent.getContext()).inflate(R.layout.row_order, parrent,false));
    }
}
