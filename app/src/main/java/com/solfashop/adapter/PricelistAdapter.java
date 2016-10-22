package com.solfashop.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.solfashop.API.Interfaces.PricelistService;
import com.solfashop.API.ServiceGenerator;
import com.solfashop.BaseActivity;
import com.solfashop.holder.PricelistHolder;
import com.solfashop.model.Pricelist;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ratri on 10/3/2016.
 */
public class PricelistAdapter extends ListAdapter<Pricelist, PricelistHolder> {
    Context context;
    BaseActivity activity;

    String title;
    String mId;


    public PricelistAdapter(BaseActivity activity, String id, String kategori){
        context = activity.getBaseContext();
        this.activity = activity;
        mId = id;
        title = kategori;

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
        holder.textNominal.setText(pricelist.getNama());
        holder.textHarga.setText("Rp "+pricelist.getHarga());
        holder.lin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pricelist.cardOnClock(activity, title);
            }
        });

    }

    public void initData(){
        PricelistService pricelistService = ServiceGenerator.connect(PricelistService.class);
        Call<List<Pricelist>> pricelistCall = pricelistService.getPricelist(mId);
        pricelistCall.enqueue(new Callback<List<Pricelist>>() {
            @Override
            public void onResponse(Call<List<Pricelist>> call, Response<List<Pricelist>> response) {
                if(response.isSuccess()){
                    addAll(response.body());
                    System.out.println(response.raw().toString());
                }
            }

            @Override
            public void onFailure(Call<List<Pricelist>> call, Throwable t) {

            }
        });
    }
}
