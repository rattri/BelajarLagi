package com.solfashop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.solfashop.BaseActivity;
import com.solfashop.R;
import com.solfashop.adapter.OrderAdapter;
import com.solfashop.adapter.PricelistAdapter;
import com.solfashop.model.Order;
import com.solfashop.model.Pricelist;
import com.solfashop.model.Voucher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ratri on 9/30/2016.
 */
public class CheckoutFragment extends BaseFragment implements View.OnClickListener{

    private  int cojumlah, coharga, cototal;
    private int harga;
    TextView totalView, jumlahView, produkView;
    public String namaVoucher, nominalVoucher, hargaVoucher, title;
    Pricelist pricelist;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.checkout_fragment, container, false);
        baseActivity = (BaseActivity) getActivity();
        baseActivity.setBaseFragment(this);/*WAJIB ADA*/
        title = "Belanja";
        namaVoucher = "";
        nominalVoucher= pricelist.getNama();
        cojumlah=1;
        coharga= new Integer(hargaVoucher);
        hargaVoucher=pricelist.getHarga();
        namaVoucher=pricelist.getNama();


        setTitle(title);

        produkView = (TextView) v.findViewById(R.id.produk);
        jumlahView = (TextView) v.findViewById(R.id.jumlah);
        totalView = (TextView) v.findViewById(R.id.total);

        produkView.setText(namaVoucher);
        jumlahView.setText(String.valueOf(cojumlah));
        totalView.setText(String.valueOf(coharga));
        //        priceAdapter = new PriceAdapter(id);
//        recyclerView = (RecyclerView) v.findViewById(R.id.rv_order);
//        pricelistAdapter = new PricelistAdapter(getBaseActivity(), getContext());
//        PricelistAdapter pricelistAdapter;
//        pricelistAdapter = new PricelistAdapter(kategori);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerView.setAdapter(pricelistAdapter);

//        pricelistAdapter.initData();

        return v;
    }

    public void plusJumlah (View v ){
        cojumlah++;
        displayJumlah(cojumlah);
        hitungTotal(cojumlah);
    }

    public void minusJumlah (View v ){
        cojumlah--;

        displayJumlah(cojumlah);
    }
    public void hitungTotal(int total){
        total = coharga * cojumlah;
        displayTotal(total);
    }

    public void displayJumlah (int jumlah){
//        TextView jumlahView = (TextView) v.findViewById(R.id.jumlah);
        jumlahView.setText(String.valueOf(jumlah));

    }

    public void displayTotal (int total){
//        TextView totalView = (TextView) v.findViewById(R.id.total);
        totalView.setText(String.valueOf(total));

    }

//    public static PriceFragment newInstance(Order checkout_fragment) {
//        PriceFragment fragment = new PriceFragment();
//        fragment.checkout_fragment = checkout_fragment;
//        return fragment;
//    }

    public static CheckoutFragment newInstance(Pricelist pricelist) {
        CheckoutFragment fragment = new CheckoutFragment();
        fragment.pricelist = pricelist;
        return fragment;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_order:
//                action button checkout_fragment click
                getBaseActivity().startFragment(BaseActivity.FRAGMENT_ORDER,"ORDER FRAGMENT");
                break;
//            case R.id.btn_price:
////                action button price click
//                break;
        }
    }
    private View.OnClickListener homeOnClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getBaseActivity().startFragment(BaseActivity.FRAGMENT_HOME, "ORDER HOME");
            }
        };
    }

    class priceOnClick implements View.OnClickListener{
        String id;
        int order;

        public priceOnClick(String id, int order){
            this.id = id;
            this.order = order;
        }

        @Override
        public void onClick(View view) {
            getBaseActivity().startFragment(BaseActivity.FRAGMENT_PRICELIST, "PriceList FRAGMENT");
        }
    }


}
