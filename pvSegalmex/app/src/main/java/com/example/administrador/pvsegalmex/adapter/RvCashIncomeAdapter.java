package com.example.administrador.pvsegalmex.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.entity.CashIncomeEntity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

//Muestra en lista los ingresos registrados
public class RvCashIncomeAdapter extends RecyclerView.Adapter<RvCashIncomeAdapter.RvCashIncomeHolder> implements View.OnClickListener {
    private static final String TAG = "RvCashIncomeAdapter";
    private ArrayList<CashIncomeEntity> incomeList;
    private Context context;
    private View.OnClickListener listener;

    public RvCashIncomeAdapter(ArrayList<CashIncomeEntity> incomeList, Context context) {
        this.incomeList = incomeList;
        this.context = context;
    }

    @NonNull
    @Override
    public RvCashIncomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_cash_income_adapter, parent, false);
        view.setOnClickListener(this);
        RvCashIncomeHolder rvCashIncomeHolder = new RvCashIncomeHolder(view);
        return rvCashIncomeHolder;
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull RvCashIncomeHolder rvCashIncomeHolder, int position) {
        CashIncomeEntity cashIncomeEntity = incomeList.get(position);
        rvCashIncomeHolder.tvDateIncome.setText(cashIncomeEntity.getDate());
        rvCashIncomeHolder.tvAmountIncome.setText(String.valueOf("$" + cashIncomeEntity.getAmount()));
    }

    @Override
    public int getItemCount() {
        return incomeList.size();
    }

    @Override
    public void onClick(View view) {

        if (listener != null) {
            listener.onClick(view);
        }
    }

    public class RvCashIncomeHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvAmountIncome)
        protected TextView tvAmountIncome;
        @BindView(R.id.tvDateIncome)
        protected TextView tvDateIncome;

        public RvCashIncomeHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}