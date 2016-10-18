package com.solfashop;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.solfashop.fragment.BaseFragment;

/**
 * Created by Ratri on 9/30/2016.
 */
public abstract class BaseActivity extends AppCompatActivity {
    public static final int FRAGMENT_HOME = 0;
    public static final int FRAGMENT_ORDER = 1;
    public static final int FRAGMENT_PRICELIST = 2;
    public static final int FRAGMENT_LOGIN = 3;
    public static final int FRAGMENT_CHECKOUT= 4;
    public static final String EXTRA_MODEL = "extra.model";
    public static final String KEY_FRAGMENT = "solfa.fragment";
    protected int currentFragment = FRAGMENT_HOME;
    public static BaseActivity baseActivity;
    public BaseFragment fragment;
    public Toolbar toolbar;
    public NavigationView navigationView;
    public TextView welcome;
    DrawerLayout drawer;
    public boolean isParrentView = true;

    public static final String BASE_URL = "http://solfacell.solfagaming.com/";
    public static final String REGISTER_OPERATION = "register";
    public static final String LOGIN_OPERATION = "login";
    public static final String CHANGE_PASSWORD_OPERATION = "chgPass";
    public static final String RESET_PASSWORD_INITIATE = "resPassReq";
    public static final String RESET_PASSWORD_FINISH = "resPass";

    public static final String SUCCESS = "success";
    public static final String FAILURE = "failure";
    public static final String IS_LOGGED_IN = "isLoggedIn";

    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String UNIQUE_ID = "unique_id";

    public static final String TAG = "Learn2Crack";
    public SharedPreferences pref;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void setupToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void setTitle(String title){
        getSupportActionBar().setTitle(title);
    }

    protected void setupNavabar() {
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        View header = navigationView.getHeaderView(0);
        welcome = (TextView) header.findViewById(R.id.welcome);
        pref = getSharedPreferences(BaseActivity.LOGIN_OPERATION, Context.MODE_PRIVATE);
        if (!pref.getBoolean(IS_LOGGED_IN, false)) {
            navigationView.inflateMenu(R.menu.login);
            welcome.setText("Kamu belum login");
        } else {
            navigationView.inflateMenu(R.menu.activity_main_login);
            welcome.setText("Selamat Datang "+ pref.getString(NAME, ""));
        }


    }

    public static BaseActivity getBaseActivity() {
        return baseActivity;
    }

    public void startFragment(int TYPE, String judul) {
        Intent i = new Intent(this, ActivityMain.class);
        i.putExtra(KEY_FRAGMENT, TYPE);
        i.putExtra("judul", judul);
        startActivity(i);
    }

    public void startFragment(Intent i) {
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START))drawer.closeDrawer(GravityCompat.START);
        else super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void setBaseFragment(BaseFragment fragment){
        this.fragment = fragment;
    }
}