package com.solfashop.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.solfashop.API.form.CheckoutForm;
import com.solfashop.BaseActivity;
import com.solfashop.R;
import com.solfashop.adapter.CheckoutAdapter;
import com.solfashop.adapter.PricelistAdapter;
import com.solfashop.model.Pricelist;

/**
 * Created by Ratri on 9/30/2016.
 */
public class CheckoutFragment extends BaseFragment {
    public static final String KEY_KATEGORI = "solfa.kategori";
    public TextView textProduk, textHarga, textJumlah, textTotal;
    public int iharga,itotal,ijumlah;
    String kategori;
    public View v;
    private Pricelist pricelist;
    Button btntambah, btnkurang, btnbeli;
    public SharedPreferences pref;
    CheckoutAdapter checkoutAdapter;
    public static String id_produk, id_user;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         v = inflater.inflate(R.layout.checkout_fragment, container, false);
        baseActivity = (BaseActivity) getActivity();
        textProduk = (TextView) v.findViewById(R.id.produk);
        textHarga = (TextView) v.findViewById(R.id.harga);
        textJumlah = (TextView) v.findViewById(R.id.jumlah);
        textTotal = (TextView) v.findViewById(R.id.total);
        btntambah = (Button) v.findViewById(R.id.tambah);
        btnkurang = (Button) v.findViewById(R.id.kurang);
        btnbeli = (Button) v.findViewById(R.id.beli);

        btnkurang.setOnClickListener(onKurang());
        btntambah.setOnClickListener(onTambah());
        btnbeli.setOnClickListener(onBeli());

        ijumlah= 1;
        hitungTotal(ijumlah);


        baseActivity.setBaseFragment(this); /*WAJIB ADA*/

        setTitle("Checkout");

        textProduk.setText(kategori+" "+pricelist.getNama());
        textHarga.setText("Harga : " +pricelist.getHarga());
        textJumlah.setText(String.valueOf(ijumlah));
        textTotal.setText( pricelist.getHarga());


//        pref = BaseActivity.pref;


        return v;
    }

    public static CheckoutFragment newInstance(Pricelist pricelist, String kategori) {
        CheckoutFragment fragment = new CheckoutFragment();
        fragment.pricelist = pricelist;
        fragment.kategori = kategori;
        return fragment;
    }



    private View.OnClickListener onKurang() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ijumlah==1){
                    ijumlah=1;
                }
                else{
                ijumlah--;}
                displayJumlah(ijumlah);
                hitungTotal(ijumlah);
            }
        };
    }

    private View.OnClickListener onTambah() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ijumlah++;
                displayJumlah(ijumlah);
                hitungTotal(ijumlah);
            }
        };
    }

    private View.OnClickListener onBeli( ){
        return new View.OnClickListener(){

            @Override
            public  void onClick (View view){
                pref = getActivity().getSharedPreferences(BaseActivity.LOGIN_OPERATION, Context.MODE_PRIVATE);
                if (!pref.getBoolean(BaseActivity.IS_LOGGED_IN, false)) {
                    id_user = pref.getString(BaseActivity.UNIQUE_ID, "");
                    System.out.println("user"+pref.getString(BaseActivity.UNIQUE_ID, ""));
                    System.out.println(pricelist.getId());
                    getBaseActivity().startFragment(BaseActivity.FRAGMENT_LOGIN, "Login FRAGMENT");
                } else {
                    id_user = pref.getString(BaseActivity.UNIQUE_ID, "");
                    System.out.println(id_user);
                    System.out.println(pricelist.getId());

                    CheckoutForm checkoutForm = new CheckoutForm();

                    checkoutForm.setJumlah(""+ijumlah);
                    checkoutForm.setTotal(""+itotal);
                    checkoutForm.setProduk(pricelist.getId());
                    checkoutForm.setUser(id_user);
                    checkoutAdapter = new CheckoutAdapter( getBaseActivity(), checkoutForm);
                    checkoutAdapter.initData();

                    getBaseActivity().startFragment(BaseActivity.FRAGMENT_ORDER,"DETAIL ORDER FRAGMENT");
                }

            }
        };
    }


    public void hitungTotal(int total){

        iharga = Integer.parseInt(pricelist.getHarga());
        total = iharga * ijumlah;
        displayTotal(total);
    }

    public void displayJumlah (int jumlah){
        textJumlah.setText(String.valueOf(jumlah));

    }

    public void displayTotal (int total){
        itotal = total;
        textTotal.setText(String.valueOf(total));
    }



}
