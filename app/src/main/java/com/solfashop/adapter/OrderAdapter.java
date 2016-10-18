package com.solfashop.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.solfashop.API.Interfaces.OrderService;
import com.solfashop.API.ServiceGenerator;
import com.solfashop.BaseActivity;
import com.solfashop.holder.OrderHolder;
import com.solfashop.model.Order;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ratri on 10/3/2016.
 */
public class OrderAdapter extends ListAdapter<Order, OrderHolder> {
    Context context;
    BaseActivity activity;

    public OrderAdapter(BaseActivity activity, Context ctx){
        context = ctx;
        this.activity = activity;
    }

    @Override
    public OrderHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        System.out.println("on create holder");
        OrderHolder orderHolder = new OrderHolder(parent);
        return orderHolder;
    }

    @Override
    public void onBindViewHolder(OrderHolder holder, int position) {
        final Order order = get(position);
        holder.textProduk.setText(order.getProduk());
        holder.textHarga.setText(""+order.getHarga());
        holder.textJumlah.setText(""+order.getJumlah());
        holder.textTotal.setText(""+order.getTotal());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                order.cardOnClock(activity);
            }
        });
        Glide.with(context).load(order.getPicture()).override(100, 100).into(holder.imgCover);
    }

    public void initData(){
        OrderService orderService = ServiceGenerator.connect(OrderService.class);
        Call<List<Order>> orderCall = orderService.getOrder();
        orderCall.enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
                if(response.isSuccess()){
                    addAll(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Order>> call, Throwable t) {

            }
        });
    }
}
