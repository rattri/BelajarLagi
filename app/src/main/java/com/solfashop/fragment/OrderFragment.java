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
import com.solfashop.model.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ratri on 9/30/2016.
 */
public class OrderFragment extends BaseFragment implements View.OnClickListener{

    RecyclerView recyclerView;
    OrderAdapter orderAdapter;
    String message;
    Button btnHome, btnOrder, btnPrice;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.order_fragment, container, false);
        baseActivity = (BaseActivity) getActivity();
        baseActivity.setBaseFragment(this);/*WAJIB ADA*/
//        setTitle("Home");

        recyclerView = (RecyclerView) v.findViewById(R.id.rv_order);
        orderAdapter = new OrderAdapter(getBaseActivity(), getContext());

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(orderAdapter);

        orderAdapter.initData();

        return v;
    }

    public static OrderFragment newInstance(String message) {
        OrderFragment fragment = new OrderFragment();
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
