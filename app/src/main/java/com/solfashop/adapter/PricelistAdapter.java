package com.solfashop.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.solfashop.API.Interfaces.OrderService;
import com.solfashop.API.Interfaces.PricelistService;
import com.solfashop.API.Interfaces.VoucherService;
import com.solfashop.API.ServiceGenertor;
import com.solfashop.BaseActivity;
import com.solfashop.R;
import com.solfashop.fragment.PricelistFragment;
import com.solfashop.holder.OrderHolder;
import com.solfashop.holder.PricelistHolder;
import com.solfashop.holder.VoucherHolder;
import com.solfashop.model.Order;
import com.solfashop.model.Pricelist;
import com.solfashop.model.Voucher;

import java.util.ArrayList;
import java.util.List;

import retrofit2.BaseUrl;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Ratri on 10/3/2016.
 */
public class PricelistAdapter extends ListAdapter<Pricelist, PricelistHolder> {
    Context context;
    BaseActivity activity;

    public PricelistAdapter(BaseActivity activity, Context ctx){
        context = ctx;
        this.activity = activity;
    }

    @Override
    public PricelistHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        System.out.println("on create holder");
        PricelistHolder pricelistHolder = new PricelistHolder(parent);
        return pricelistHolder;
    }

    @Override
    public void onBindViewHolder(PricelistHolder holder, int position) {
        final Pricelist pricelist = get(position);
        holder.textNominal.setText(pricelist.getNominal());
        holder.textHarga.setText(pricelist.getHarga());
        holder.lin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                pricelist.cardOnClock(activity);
            }
        });

    }

    public void initData(){
        PricelistService pricelistService = ServiceGenertor.connect(PricelistService.class);
        Call<List<Pricelist>> pricelistCall = pricelistService.getPricelist(PricelistFragment.newInstance());
        pricelistCall.enqueue(new Callback<List<Pricelist>>() {
            @Override
            public void onResponse(Call<List<Pricelist>> call, Response<List<Pricelist>> response) {
                if(response.isSuccess()){
                    addAll(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Pricelist>> call, Throwable t) {

            }
        });
    }
}
