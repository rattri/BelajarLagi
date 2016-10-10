package com.solfashop.adapter;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ratri on 10/3/2016.
 */
public abstract class ListAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    List<T> items;

    public ListAdapter(){
        items = new ArrayList<>();
    }

    public ListAdapter(List<T> tList){
        items = tList;
    }

    public void add(T item){
        items.add(item);
        notifyDataSetChanged();
    }

    public void addAll(List<T> list){
        System.out.println("add all");
        items.addAll(list);
        notifyDataSetChanged();
    }

    public void remove(int position){
        items.remove(position);
        notifyDataSetChanged();
    }

    public void clearAll(){
        items.clear();
        notifyDataSetChanged();
    }

    public T get(int position){
        return items.get(position);
    }

    public List<T> getAll(){
        return items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
