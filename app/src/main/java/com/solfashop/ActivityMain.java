package com.solfashop;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.solfashop.fragment.CheckoutFragment;
import com.solfashop.fragment.DetailorderFragment;
import com.solfashop.fragment.DetailtransaksiFragment;
import com.solfashop.fragment.HomeFragment;
import com.solfashop.fragment.LoginFragment;
import com.solfashop.fragment.OrderFragment;
import com.solfashop.fragment.PricelistFragment;
import com.solfashop.fragment.TransaksiFragment;
import com.solfashop.model.Pricelist;
import com.solfashop.model.Transaksi;
import com.solfashop.model.Voucher;

//import org.parceler.Parcels;

/**
 * Created by Ratri on 9/30/2016.
 */
public class ActivityMain extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener{
    Intent caller;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        baseActivity = this;
        caller = getIntent();
        if (caller != null && caller.getExtras() != null){
            currentFragment = caller.getExtras().getInt(KEY_FRAGMENT);
        } else currentFragment = FRAGMENT_HOME;

        FragmentManager manager = getSupportFragmentManager();
        switch (currentFragment){
            case FRAGMENT_HOME:
                manager.beginTransaction().replace(R.id.container, HomeFragment.newInstance("INI HOME")).commit();
                isParrentView = true;
                break;
//            case FRAGMENT_ORDER:
//                manager.beginTransaction().replace(R.id.container, OrderFragment.newInstance("INI ORDER")).commit();
//                isParrentView = false;
//                break;
            case FRAGMENT_LOGIN:
                manager.beginTransaction().replace(R.id.container, LoginFragment.newInstance("INI LOGIN")).commit();
                isParrentView = false;
                break;
            case FRAGMENT_CHECKOUT:
                    Pricelist pricelist = (Pricelist) caller.getSerializableExtra(BaseActivity.EXTRA_MODEL);
                    CheckoutFragment checkoutFragment = CheckoutFragment.newInstance(pricelist, caller.getExtras().getString(CheckoutFragment.KEY_KATEGORI));
                    manager.beginTransaction().replace(R.id.container, checkoutFragment).commit();
                    isParrentView = false;
                break;
            case FRAGMENT_PRICELIST:
                Voucher voucher = (Voucher) caller.getSerializableExtra(BaseActivity.EXTRA_MODEL);
                PricelistFragment pricelistFragment = PricelistFragment.newInstance(voucher);
                manager.beginTransaction().replace(R.id.container, pricelistFragment).commit();
                isParrentView = false;

                break;
            case FRAGMENT_ORDER:
                manager.beginTransaction().replace(R.id.container, DetailorderFragment.newInstance("INI ORDER")).commit();
                isParrentView = false;
                break;
            case FRAGMENT_TRANSAKSI:
                manager.beginTransaction().replace(R.id.container, TransaksiFragment.newInstance("INI ORDER")).commit();
                isParrentView = false;
                break;
            case FRAGMENT_DETAILTRANSAKSI  :
                Transaksi transaksi = (Transaksi) caller.getSerializableExtra(BaseActivity.EXTRA_MODEL);
                DetailtransaksiFragment detailtransaksiFragment = DetailtransaksiFragment.newInstance(transaksi);
                manager.beginTransaction().replace(R.id.container, detailtransaksiFragment).commit();
                isParrentView = false;
                break;

        }

        setupToolbar();
        setupNavabar();
        navigationView.setNavigationItemSelectedListener(this);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);

        if (!isParrentView) {
            toggle.setDrawerIndicatorEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   onBackPressed();
                }
            });
        }
        else toggle.syncState();

    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (item.getItemId()){
            case R.id.beranda :
                System.out.println("klik di "+item.getItemId());
                getBaseActivity().startFragment(BaseActivity.FRAGMENT_HOME, "HOME FRAGMENT");
                break;

            case R.id.login:
                getBaseActivity().startFragment(BaseActivity.FRAGMENT_LOGIN,"LOGIN FRAGMENT");
                break;
            case R.id.transaksi:
                getBaseActivity().startFragment(BaseActivity.FRAGMENT_TRANSAKSI,"TRANSAKSI FRAGMENT");
                break;
            case R.id.logout:
                SharedPreferences.Editor editor = pref.edit();
                editor.putBoolean(BaseActivity.IS_LOGGED_IN,false);
                editor.putString(BaseActivity.EMAIL,"");
                editor.putString(BaseActivity.NAME,"");
                editor.putString(BaseActivity.UNIQUE_ID,"");
                editor.apply();

                new AlertDialog.Builder(this)
                        .setTitle("Logout")
                        .setMessage("Kamu berhasil logout")
                        .show();
                getBaseActivity().startFragment(BaseActivity.FRAGMENT_HOME, "HOME FRAGMENT");
                break;
        }

        if (id == R.id.beranda) {
            getBaseActivity().startFragment(BaseActivity.FRAGMENT_HOME, "Home FRAGMENT");
            // Handle the camera action
        }
        else if (id == R.id.logout){
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean(BaseActivity.IS_LOGGED_IN,false);
            editor.putString(BaseActivity.EMAIL,"");
            editor.putString(BaseActivity.NAME,"");
            editor.putString(BaseActivity.UNIQUE_ID,"");
            editor.apply();

            new AlertDialog.Builder(this)
                    .setTitle("Logout")
                    .setMessage("Kamu berhasil logout")
                    .show();
            getBaseActivity().startFragment(BaseActivity.FRAGMENT_HOME, "Home FRAGMENT");

        }
        else if (id == R.id.login) {

            getBaseActivity().startFragment(BaseActivity.FRAGMENT_LOGIN, "Login FRAGMENT");
        }

        return super.onOptionsItemSelected(item);
    }

}
