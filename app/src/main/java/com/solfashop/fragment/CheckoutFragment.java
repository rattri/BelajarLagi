package com.solfashop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.solfashop.BaseActivity;
import com.solfashop.R;
import com.solfashop.model.Order;
import com.solfashop.model.Pricelist;

/**
 * Created by Ratri on 9/30/2016.
 */
public class CheckoutFragment extends BaseFragment{
    public TextView textProduk, textHarga, textJumlah, textTotal;
    public int iharga,itotal,ijumlah;

    private Pricelist pricelist;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.checkout_fragment, container, false);
        baseActivity = (BaseActivity) getActivity();
        textProduk = (TextView) v.findViewById(R.id.produk);
        textHarga = (TextView) v.findViewById(R.id.harga);
        textJumlah = (TextView) v.findViewById(R.id.jumlah);
        textTotal = (TextView) v.findViewById(R.id.total);


        baseActivity.setBaseFragment(this); /*WAJIB ADA*/

        setTitle("Checkout");

        textProduk.setText(pricelist.getNama());
        textHarga.setText(""+pricelist.getHarga());
        textJumlah.setText("1");
        textTotal.setText(""+pricelist.getHarga());

        return v;
    }

    public static CheckoutFragment newInstance(Pricelist pricelist) {
        CheckoutFragment fragment = new CheckoutFragment();
        fragment.pricelist = pricelist;
        return fragment;
    }


}
