package com.solfashop.holder;

import android.support.v7.widget.CardView;
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
public class VoucherHolder extends RecyclerView.ViewHolder{
    public TextView textNama;
    public ImageView thumbnail;
    public CardView card;

    public VoucherHolder(View itemView) {
        super(itemView);
        textNama = (TextView) itemView.findViewById(R.id.nama);
        thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
        card = (CardView) itemView.findViewById(R.id.card_view);
        System.out.println("itemView");
    }

    public VoucherHolder(ViewGroup parrent){
        this(LayoutInflater.from(parrent.getContext()).inflate(R.layout.voucher_card, parrent,false));
    }
}
