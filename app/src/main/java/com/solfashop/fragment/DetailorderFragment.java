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
import com.solfashop.BaseActivity;
import com.solfashop.R;
import com.solfashop.adapter.DetailorderAdapter;


/**
 * Created by Ratri on 10/22/2016.
 */
public class DetailorderFragment extends BaseFragment {

    RecyclerView recyclerView;
    DetailorderAdapter detailorderAdapter;
    String message, id_user;
    public String idKategori, title;
    public SharedPreferences pref;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.transaksi_fragment, container, false);
        baseActivity = (BaseActivity) getActivity();
        baseActivity.setBaseFragment(this);/*WAJIB ADA*/

        setTitle("Detail Order");
        pref = getActivity().getSharedPreferences(BaseActivity.LOGIN_OPERATION, Context.MODE_PRIVATE);
        id_user = pref.getString(BaseActivity.UNIQUE_ID, "");
        System.out.println(id_user +"id");
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        detailorderAdapter = new DetailorderAdapter(getBaseActivity(), id_user);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(detailorderAdapter);
        detailorderAdapter.initData();
        System.out.println("initdata");
        return v;
    }

    public static DetailorderFragment newInstance(String message) {
        DetailorderFragment fragment = new DetailorderFragment();
        fragment.message = message;
        return fragment;
    }
}
