package com.solfashop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.solfashop.BaseActivity;
import com.solfashop.R;
import com.solfashop.model.Order;
import com.solfashop.model.Pricelist;

/**
 * Created by Ratri on 9/30/2016.
 */
public class CheckoutFragment extends BaseFragment{
    public static final String KEY_KATEGORI = "solfa.kategori";
    public TextView textProduk, textHarga, textJumlah, textTotal;
    public int iharga,itotal,ijumlah;
    String kategori;
    public View v;
    private Pricelist pricelist;
    Button btntambah, btnkurang;

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
        btnkurang.setOnClickListener(onKurang());
        btntambah.setOnClickListener(onTambah());

        ijumlah= 1;


        baseActivity.setBaseFragment(this); /*WAJIB ADA*/

        setTitle("Checkout");

        textProduk.setText(kategori+" "+pricelist.getNama());
        textHarga.setText("Harga : " +pricelist.getHarga());
        textJumlah.setText(String.valueOf(ijumlah));
        textTotal.setText(""+pricelist.getHarga());

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


//    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.tambah:
//                 ijumlah++;
//                displayJumlah(ijumlah);
//                hitungTotal(ijumlah);
//                break;
//           case R.id.kurang:
//               ijumlah--;
//               displayJumlah(ijumlah);
//               hitungTotal(ijumlah);
//                break;
//        }
//    }


//    public void plus (View v ){
//        ijumlah++;
//        displayJumlah(ijumlah);
//        hitungTotal(ijumlah);
//    }
//
//    public void min (View v ){
//        ijumlah--;
//        displayJumlah(ijumlah);
//        hitungTotal(ijumlah);
//    }
    public void hitungTotal(int total){

        iharga = Integer.parseInt(pricelist.getHarga());
        total = iharga * ijumlah;
        displayTotal(total);
    }

    public void displayJumlah (int jumlah){
        textJumlah.setText(String.valueOf(jumlah));

    }

    public void displayTotal (int total){
        textTotal.setText(String.valueOf(total));
    }

}
