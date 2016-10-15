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
import com.solfashop.model.Voucher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ratri on 9/30/2016.
 */
public class PricelistFragment extends BaseFragment implements View.OnClickListener{

    RecyclerView recyclerView;
    PricelistAdapter pricelistAdapter;
    String message;
    Voucher voucher;
    Button btnHome, btnOrder, btnPrice;
    public String idKategori, title;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.order_fragment, container, false);
        baseActivity = (BaseActivity) getActivity();
        baseActivity.setBaseFragment(this);/*WAJIB ADA*/

//        setTitle(title);
////        priceAdapter = new PriceAdapter(id);
//        recyclerView = (RecyclerView) v.findViewById(R.id.rv_order);
//        PricelistAdapter pricelistAdapter;
////        pricelistAdapter = new PricelistAdapter(kategori);


        setTitle(title);
//        priceAdapter = new PriceAdapter(id);
        recyclerView = (RecyclerView) v.findViewById(R.id.rv_order);
        pricelistAdapter = new PricelistAdapter(getBaseActivity(), idKategori, title);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(pricelistAdapter);

        pricelistAdapter.initData();

        return v;
    }


    public static PricelistFragment newInstance(Voucher voucher) {
        PricelistFragment fragment = new PricelistFragment();
        fragment.voucher = voucher;
        fragment.title = voucher.getNama();

//        fragment.kategori = voucher.getId_kategori();

        fragment.idKategori = voucher.getId_kategori();

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
