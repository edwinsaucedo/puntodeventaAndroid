package com.example.administrador.pvsegalmex.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.pojo.CashShortDetailWayPayPojo;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RvShowCashShortWayPay extends RecyclerView.Adapter<RvShowCashShortWayPay.RvShowCashShortWayPayHolder> {
    private static final String TAG = "RvShowCashShortWayPay";
    private ArrayList<CashShortDetailWayPayPojo> cashShortDetailWayPayList;
    private Context context;

    public RvShowCashShortWayPay(ArrayList<CashShortDetailWayPayPojo> cashShortDetailWayPayList, Context context) {
        this.cashShortDetailWayPayList = cashShortDetailWayPayList;
        this.context = context;
    }

    @NonNull
    @Override
    public RvShowCashShortWayPayHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_show_chashshort_waypay, viewGroup, false);
        RvShowCashShortWayPayHolder rvShowCashShortWayPayHolder = new RvShowCashShortWayPayHolder(view);
        return rvShowCashShortWayPayHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RvShowCashShortWayPayHolder rvShowCashShortWayPayHolder, int i) {
        CashShortDetailWayPayPojo cashShortDetailWayPayPojo = cashShortDetailWayPayList.get(i);
        rvShowCashShortWayPayHolder.tvWayPayDifferenceCashShort.setText(String.valueOf(cashShortDetailWayPayPojo.getAmoutDiference()));
        rvShowCashShortWayPayHolder.tvWayPayDescriptionCashShort.setText(cashShortDetailWayPayPojo.getWayPayDescription());
        rvShowCashShortWayPayHolder.tvWayPayAmountCapCashShort.setText(String.valueOf(cashShortDetailWayPayPojo.getAmountCapturate()));
        rvShowCashShortWayPayHolder.tvWayPayAmountCalCashShort.setText(String.valueOf(cashShortDetailWayPayPojo.getAmountCalculate()));
    }

    @Override
    public int getItemCount() {
        return cashShortDetailWayPayList.size();
    }

    public class RvShowCashShortWayPayHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvWayPayDescriptionCashShort)
        protected TextView tvWayPayDescriptionCashShort;
        @BindView(R.id.tvWayPayAmountCapCashShort)
        protected TextView tvWayPayAmountCapCashShort;
        @BindView(R.id.tvWayPayAmountCalCashShort)
        protected TextView tvWayPayAmountCalCashShort;
        @BindView(R.id.tvWayPayDifferenceCashShort)
        protected TextView tvWayPayDifferenceCashShort;

        public RvShowCashShortWayPayHolder(@android.support.annotation.NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
