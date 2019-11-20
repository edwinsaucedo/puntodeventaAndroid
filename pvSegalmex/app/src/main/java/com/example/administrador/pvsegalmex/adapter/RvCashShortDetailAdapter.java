package com.example.administrador.pvsegalmex.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.entity.CashShortDetailEntity;
import com.example.administrador.pvsegalmex.entity.CashShortEntity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.annotations.NonNull;

//Muestra los cortes de caja registrados
public class RvCashShortDetailAdapter extends RecyclerView.Adapter<RvCashShortDetailAdapter.RvCashShortDetailHolder> implements View.OnClickListener {
    public static final String TAG = "RvCashShortDetailAdapter";
    private ArrayList<CashShortEntity> cashShortDetailList;
    private Context context;
    private View.OnClickListener listener;

    public RvCashShortDetailAdapter(ArrayList<CashShortEntity> cashShortDetailList, Context context) {
        this.cashShortDetailList = cashShortDetailList;
        this.context = context;
    }

    @NonNull
    @Override
    public RvCashShortDetailAdapter.RvCashShortDetailHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.cash_short_detail_recycler_view_adapter, parent, false);
        view.setOnClickListener(this);
        RvCashShortDetailHolder rvCashShortDetailHolder = new RvCashShortDetailHolder(view);
        return rvCashShortDetailHolder;
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull RvCashShortDetailHolder rvCashShortDetailHolder, int position) {
        CashShortEntity cashShortDetail = cashShortDetailList.get(position);
        rvCashShortDetailHolder.tvAmountCashShortDetail.setText(String.valueOf(cashShortDetail.getAmountCap()));

        java.util.Date utilDate = new java.util.Date();
        Calendar cal = Calendar.getInstance(); // locale-specific
        cal.setTime(utilDate);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        long time = cal.getTimeInMillis();
        java.sql.Timestamp sqlTimestamp = new Timestamp(time);
        rvCashShortDetailHolder.tvDateCashShortDetail.setText(String.valueOf(sqlTimestamp));
    }

    @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onClick(view);
        }
    }

    @Override
    public int getItemCount() {
        return cashShortDetailList.size();
    }

    public class RvCashShortDetailHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvAmountCashShortDetail)
        protected TextView tvAmountCashShortDetail;
        @BindView(R.id.tvDateCashShortDetail)
        protected TextView tvDateCashShortDetail;

        public RvCashShortDetailHolder(@android.support.annotation.NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}