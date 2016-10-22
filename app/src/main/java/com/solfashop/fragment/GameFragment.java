package com.solfashop.fragment;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.solfashop.BaseActivity;
import com.solfashop.R;
import com.solfashop.adapter.OrderAdapter;
import com.solfashop.adapter.VoucherAdapter;
import com.solfashop.model.Order;
import com.solfashop.model.Voucher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ratri on 9/30/2016.
 */
public class GameFragment extends BaseFragment{

    RecyclerView recyclerView;
    VoucherAdapter voucherAdapter;
    String message, ivoucher;
    Button btnHome, btnOrder, btnPrice;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.order_fragment, container, false);
        baseActivity = (BaseActivity) getActivity();
        baseActivity.setBaseFragment(this);/*WAJIB ADA*/
//        setTitle("Home");
        ivoucher="1";
        recyclerView = (RecyclerView) v.findViewById(R.id.rv_order);
        voucherAdapter = new VoucherAdapter(getBaseActivity(), ivoucher);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(voucherAdapter);

        voucherAdapter.initData();

        return v;
    }

    public static GameFragment newInstance(String message, String ivoucher) {
        GameFragment fragment = new GameFragment();
        fragment.message = message;
        fragment.ivoucher =ivoucher;
        return fragment;
    }

//    @Override
//    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.btn_order:
////                action button checkout_fragment click
//                getBaseActivity().startFragment(BaseActivity.FRAGMENT_ORDER,"ORDER FRAGMENT");
//                break;
////            case R.id.btn_price:
//////                action button price click
////                break;
//        }
//    }
//    private View.OnClickListener homeOnClick() {
//        return new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getBaseActivity().startFragment(BaseActivity.FRAGMENT_HOME, "ORDER HOME");
//            }
//        };
//    }
//
//    class priceOnClick implements View.OnClickListener{
//        String id;
//        int order;
//
//        public priceOnClick(String id, int order){
//            this.id = id;
//            this.order = order;
//        }
//
//        @Override
//        public void onClick(View view) {
//            getBaseActivity().startFragment(BaseActivity.FRAGMENT_PRICELIST, "PriceList FRAGMENT");
//        }
//    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }



}
