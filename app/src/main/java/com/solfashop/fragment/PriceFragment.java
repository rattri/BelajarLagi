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

/**
 * Created by Ratri on 9/30/2016.
 */
public class PriceFragment extends BaseFragment{
    public TextView textProduk, textHarga, textJumlah, textTotal;
    public ImageView imgCover;
    public View card;
    private Order order;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.price_fragment, container, false);
        baseActivity = (BaseActivity) getActivity();
        textProduk = (TextView) v.findViewById(R.id.text_produk);
        textHarga = (TextView) v.findViewById(R.id.text_harga);
        textJumlah = (TextView) v.findViewById(R.id.text_jumlah);
        textTotal = (TextView) v.findViewById(R.id.text_total);
        imgCover = (ImageView) v.findViewById(R.id.img_cover);
        card = (View) v.findViewById(R.id.card_order);

        baseActivity.setBaseFragment(this); /*WAJIB ADA*/

        setTitle("Price List");


        textProduk.setText(order.getProduk());
        textHarga.setText(""+order.getHarga());
        textJumlah.setText(""+order.getJumlah());
        textTotal.setText(""+order.getTotal());
        Glide.with(this).load(order.getPicture()).override(100, 100).into(imgCover);

        return v;
    }

    public static PriceFragment newInstance(Order order) {
        PriceFragment fragment = new PriceFragment();
        fragment.order = order;
        return fragment;
    }


}
