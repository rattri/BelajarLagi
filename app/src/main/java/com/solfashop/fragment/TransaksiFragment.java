package com.solfashop.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.solfashop.BaseActivity;
import com.solfashop.R;
import com.solfashop.adapter.OrderAdapter;
import com.solfashop.adapter.PricelistAdapter;
import com.solfashop.adapter.TransaksiAdapter;
import com.solfashop.model.Voucher;

/**
 * Created by Ratri on 10/20/2016.
 */
public class TransaksiFragment extends BaseFragment implements View.OnClickListener{

    RecyclerView recyclerView;
    TransaksiAdapter transaksiAdapter;
    String message, id_user;
    Voucher voucher;
    Button btnHome, btnOrder, btnPrice;
    public String idKategori, title;
    public SharedPreferences pref;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.transaksi_fragment, container, false);
        baseActivity = (BaseActivity) getActivity();
        baseActivity.setBaseFragment(this);/*WAJIB ADA*/

//        setTitle(title);
////        priceAdapter = new PriceAdapter(id);
//        recyclerView = (RecyclerView) v.findViewById(R.id.rv_order);
//        PricelistAdapter pricelistAdapter;
////        pricelistAdapter = new PricelistAdapter(kategori);

        title="Transaksi";
        setTitle(title);
        pref = getActivity().getSharedPreferences(BaseActivity.LOGIN_OPERATION, Context.MODE_PRIVATE);
        id_user = pref.getString(BaseActivity.UNIQUE_ID, "");
        System.out.println(id_user +"id");
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        transaksiAdapter = new TransaksiAdapter(getBaseActivity(), id_user);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(transaksiAdapter);
        transaksiAdapter.initData();
        System.out.println("initdata");

        return v;
    }


    public static TransaksiFragment newInstance(String message) {
        TransaksiFragment fragment = new TransaksiFragment();
        fragment.message = message;
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
