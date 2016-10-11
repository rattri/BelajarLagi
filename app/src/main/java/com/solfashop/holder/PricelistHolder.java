package com.solfashop.holder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.solfashop.R;

/**
 * Created by Ratri on 10/3/2016.
 */
public class PricelistHolder extends RecyclerView.ViewHolder{
    public TextView textNominal, textHarga ;
    public LinearLayout lin;

    public PricelistHolder(View itemView) {
        super(itemView);
        textNominal = (TextView)itemView.findViewById(R.id.text_nama);
        textHarga = (TextView) itemView.findViewById(R.id.text_harga);

        lin = (LinearLayout) itemView.findViewById(R.id.list_item);
        System.out.println("itemPricelist");
    }

    public PricelistHolder(ViewGroup parrent){
        this(LayoutInflater.from(parrent.getContext()).inflate(R.layout.price_list, parrent,false));
    }
}
