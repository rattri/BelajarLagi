package com.solfashop.holder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.solfashop.R;

/**
 * Created by Ratri on 10/21/2016.
 */
public class DetailorderHolder extends RecyclerView.ViewHolder{

    public TextView textId, textTanggal, textVoucher, textNominal, textStatus,
            textJumlah, textTotal, textHarga, textSubtotal;

        public DetailorderHolder(View itemView) {
            super(itemView);
            textId = (TextView) itemView.findViewById(R.id.order);
            textTanggal = (TextView) itemView.findViewById(R.id.text_tanggal);
            textVoucher = (TextView) itemView.findViewById(R.id.voucher);
            textNominal = (TextView) itemView.findViewById(R.id.nominal);
            textStatus = (TextView) itemView.findViewById(R.id.status);
            textJumlah = (TextView) itemView.findViewById(R.id.jumlah);
            textTotal = (TextView) itemView.findViewById(R.id.total);
            textHarga = (TextView) itemView.findViewById(R.id.harga);
            textSubtotal =(TextView) itemView.findViewById(R.id.subtotal);
            System.out.println("itemView");
        }

        public DetailorderHolder(ViewGroup parrent){
            this(LayoutInflater.from(parrent.getContext()).inflate(R.layout.transaksi_detail, parrent,false));
        }
    }


