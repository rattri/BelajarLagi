package com.solfashop.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.solfashop.API.Interfaces.PricelistService;
import com.solfashop.API.Interfaces.TransaksiService;
import com.solfashop.API.ServiceGenerator;
import com.solfashop.BaseActivity;
import com.solfashop.holder.TransaksiHolder;
import com.solfashop.model.Pricelist;
import com.solfashop.model.Transaksi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ratri on 10/20/2016.
 */
public class TransaksiAdapter extends ListAdapter<Transaksi, TransaksiHolder> {
    Context context;
    BaseActivity activity;
    String iuser;


    public TransaksiAdapter(BaseActivity activity, String user){
        iuser = user;
        context = activity.getBaseContext();
        this.activity = activity;
    }

    @Override
    public TransaksiHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        System.out.println("on create holder");
        TransaksiHolder transaksiHolder  = new TransaksiHolder(parent);
        return transaksiHolder;
    }

    @Override
    public void onBindViewHolder(TransaksiHolder holder, int position) {
        final Transaksi transaksi = get(position);
        holder.textTanggal.setText(transaksi.getTanggal());
        holder.textProduk.setText(transaksi.getVoucher());
        holder.textJam.setText((transaksi.getJam()));
        holder.textNominal.setText(transaksi.getNominal()+ " x " + transaksi.getJumlah());
        holder.textStatus.setText(transaksi.getStatus());
        holder.lin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaksi.transaksiOnClick(activity);
            }
        });

    }

//    public void initData(){
//        System.out.println(iuser);
//        TransaksiService transaksiService= ServiceGenerator.connect(TransaksiService.class);
//        Call<List<Transaksi>> transaksiCall = transaksiService.getTransaksi(iuser);
//        transaksiCall.enqueue(new Callback<List<Transaksi>>() {
//            @Override
//            public void onResponse(Call<List<Transaksi>> call, Response<List<Transaksi>> response) {
//                if(response.isSuccess()){
//                    addAll(response.body());
//                    System.out.println(response.raw().toString());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Transaksi>> call, Throwable t) {
//
//            }
//        });
//    }

    public void initData(){
        TransaksiService transaksiService = ServiceGenerator.connect(TransaksiService.class);
        Call<List<Transaksi>> transaksiCall = transaksiService.getTransaksi(iuser);
        transaksiCall.enqueue(new Callback<List<Transaksi>>() {
            @Override
            public void onResponse(Call<List<Transaksi>> call, Response<List<Transaksi>> response) {
                if(response.isSuccess()){
                    addAll(response.body());
                    System.out.println(response.raw().toString());
                }
            }

            @Override
            public void onFailure(Call<List<Transaksi>> call, Throwable t) {

            }
        });
    }
}
