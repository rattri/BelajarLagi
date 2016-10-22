package com.solfashop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.solfashop.BaseActivity;
import com.solfashop.R;
import com.solfashop.model.Transaksi;

/**
 * Created by Ratri on 10/21/2016.
 */
public class DetailtransaksiFragment extends  BaseFragment {
    public TextView textId, textTanggal, textVoucher, textNominal, textStatus, textJumlah, textTotal, textHarga, textSubtotal;
    Transaksi transaksi;
    int subTotal;
    public View v;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.transaksi_detail, container, false);
        baseActivity = (BaseActivity) getActivity();

        baseActivity.setBaseFragment(this); /*WAJIB ADA*/

        setTitle("Detail Order");
        subTotal= Integer.parseInt(transaksi.getHarga())*Integer.parseInt(transaksi.getJumlah());

        textId = (TextView) v.findViewById(R.id.order);
        textTanggal = (TextView) v.findViewById(R.id.text_tanggal);
        textVoucher = (TextView) v.findViewById(R.id.voucher);
        textNominal = (TextView) v.findViewById(R.id.nominal);
        textStatus = (TextView) v.findViewById(R.id.status);
        textJumlah = (TextView) v.findViewById(R.id.jumlah);
        textTotal = (TextView) v.findViewById(R.id.total);
        textHarga = (TextView) v.findViewById(R.id.harga);
        textSubtotal =(TextView) v.findViewById(R.id.subtotal);


        textId.setText("ORDER #" + transaksi.getId() + " (" + transaksi.getTanggal() + " " + transaksi.getJam() + ")");
        textStatus.setText("Status : " + transaksi.getStatus());
        textVoucher.setText(transaksi.getVoucher());
        textNominal.setText(transaksi.getNominal());
        textJumlah.setText(transaksi.getJumlah());
        textHarga.setText(transaksi.getHarga());
        textTotal.setText(transaksi.getTotal());
        textSubtotal.setText(""+subTotal);


        return v;
    }

    public static DetailtransaksiFragment newInstance(Transaksi transaksi) {

        DetailtransaksiFragment fragment = new DetailtransaksiFragment();
        fragment.transaksi = transaksi;
        return fragment;
    }

}
