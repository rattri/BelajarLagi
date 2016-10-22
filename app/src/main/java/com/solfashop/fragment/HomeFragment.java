package com.solfashop.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.solfashop.ActivityMain;
import com.solfashop.BaseActivity;
import com.solfashop.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ratri on 9/30/2016.
 */
public class HomeFragment extends BaseFragment{
    TextView textHome;
    String message;
    Button btnHome, btnOrder, btnPrice;
    private TabLayout tabLayout;
    private ViewPager viewPager;
   public static String VOUCHER_GAME="1";
    public static String VOUCHER_PULSA="2"  ;


    private Toolbar toolbar;
    private TextView welcome;
    NavigationView navigationView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_fragment, container, false);
        baseActivity = (BaseActivity) getActivity();


        textHome = (TextView) v.findViewById(R.id.text_home);
        btnHome = (Button) v.findViewById(R.id.btn_home);
        btnOrder = (Button) v.findViewById(R.id.btn_order);
        btnPrice = (Button) v.findViewById(R.id.btn_price);
        //textHome.setText(message);


        baseActivity.setBaseFragment(this);/*WAJIB ADA*/

        viewPager = (ViewPager) v.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) v.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        setTitle("Home");
        return v;
    }

    public static HomeFragment newInstance(String message) {
        HomeFragment fragment = new HomeFragment();
        fragment.message = message;
        return fragment;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
        adapter.addFragment(new GameFragment(), "GAME");
        adapter.addFragment(new PulsaFragment(), "PULSA");
        adapter.addFragment(new PlnFragments(), "PLN");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);

        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    }


