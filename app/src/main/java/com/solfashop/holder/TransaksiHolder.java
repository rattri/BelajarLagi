package com.solfashop.holder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.solfashop.R;

/**
 * Created by Ratri on 10/20/2016.
 */
public class TransaksiHolder extends RecyclerView.ViewHolder{

        public TextView textTanggal, textProduk, textJam, textNominal, textStatus ;
        public LinearLayout lin;

        public TransaksiHolder(View itemView) {
            super(itemView);
            textTanggal = (TextView)itemView.findViewById(R.id.text_tanggal);
            textProduk = (TextView) itemView.findViewById(R.id.text_produk);
            textJam =(TextView) itemView.findViewById(R.id.jam);
            textNominal= (TextView) itemView.findViewById(R.id.nominal) ;
            textStatus=(TextView) itemView.findViewById(R.id.status);



            lin = (LinearLayout) itemView.findViewById(R.id.list_item);
            System.out.println("itemPricelist");
        }

        public TransaksiHolder(ViewGroup parrent){
            this(LayoutInflater.from(parrent.getContext()).inflate(R.layout.transaksi_list, parrent,false));
        }
    }

