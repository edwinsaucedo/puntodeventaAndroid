package com.example.administrador.pvsegalmex.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.entity.WithdrawalEntity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

//Muiestra en lista retiros de caja registrados
public class RvWithdrawalAdapter extends RecyclerView.Adapter<RvWithdrawalAdapter.RvWithdrawalHolder> implements View.OnClickListener {
    private static final String TAG = "RvWithdrawalAdapter";
    private ArrayList<WithdrawalEntity> withdrawalList;
    private Context context;
    private View.OnClickListener listener;

    public RvWithdrawalAdapter(ArrayList<WithdrawalEntity> withdrawalList, Context context) {
        this.withdrawalList = withdrawalList;
        this.context = context;
    }

    @NonNull
    @Override
    public RvWithdrawalHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.whiddrawal_recycler_view_adapter, parent, false);
        view.setOnClickListener(this);
        RvWithdrawalHolder rvWithdrawalHolder = new RvWithdrawalHolder(view);
        return rvWithdrawalHolder;
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull RvWithdrawalHolder rvWithdrawalHolder, int position) {
        WithdrawalEntity withdrawal = withdrawalList.get(position);
        rvWithdrawalHolder.tvAmountWildrawal.setText("$ " + String.valueOf(withdrawal.getAmount()));
        rvWithdrawalHolder.tvDateWithdrawal.setText(withdrawal.getDate());
    }

    @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onClick(view);
        }
    }

    @Override
    public int getItemCount() {
        return withdrawalList.size();
    }

    public class RvWithdrawalHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvAmountWildrawal)
        protected TextView tvAmountWildrawal;
        @BindView(R.id.tvDateWithdrawal)
        protected TextView tvDateWithdrawal;

        public RvWithdrawalHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}