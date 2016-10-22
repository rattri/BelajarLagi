package com.solfashop.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.solfashop.API.Interfaces.DetailorderService;
import com.solfashop.API.ServiceGenerator;
import com.solfashop.BaseActivity;
import com.solfashop.holder.DetailorderHolder;
import com.solfashop.model.DetailOrder;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ratri on 10/21/2016.
 */
public class DetailorderAdapter extends ListAdapter<DetailOrder, DetailorderHolder> {
    Context context;
    BaseActivity activity;
    String iuser;


    public DetailorderAdapter(BaseActivity activity, String user){
        iuser = user;
        context = activity.getBaseContext();
        this.activity = activity;
    }

    @Override
    public DetailorderHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        System.out.println("on create holder");
        DetailorderHolder detailorderHolder = new DetailorderHolder(parent);
        return detailorderHolder;
    }

    @Override
    public void onBindViewHolder(DetailorderHolder holder, int position) {
        final DetailOrder detailOrder = get(position);
        holder.textId.setText("ORDER #" + detailOrder.getId() + " (" + detailOrder.getTanggal() + " " + detailOrder.getJam() + ")");
        holder.textStatus.setText("Status : " + detailOrder.getStatus());
        holder.textVoucher.setText(detailOrder.getVoucher());
        holder.textNominal.setText(detailOrder.getNominal());
        holder.textJumlah.setText(detailOrder.getJumlah());
        holder.textHarga.setText(detailOrder.getHarga());
        holder.textTotal.setText(detailOrder.getTotal());
        holder.textSubtotal.setText(""+Integer.parseInt(detailOrder.getHarga())*Integer.parseInt(detailOrder.getJumlah()));
            }

    public void initData(){
        DetailorderService detailorderService = ServiceGenerator.connect(DetailorderService.class);
        Call<List<DetailOrder>> detailOrderCall = detailorderService.getDetailOrder(iuser);
        detailOrderCall.enqueue(new Callback<List<DetailOrder>>() {
            @Override
            public void onResponse(Call<List<DetailOrder>> call, Response<List<DetailOrder>> response) {
                if(response.isSuccess()){
                    addAll(response.body());
                    System.out.println(response.raw().toString());
                }
            }

            @Override
            public void onFailure(Call<List<DetailOrder>> call, Throwable t) {

            }
        });
    }
}
