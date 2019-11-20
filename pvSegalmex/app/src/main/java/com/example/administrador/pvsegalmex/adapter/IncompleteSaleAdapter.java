package com.example.administrador.pvsegalmex.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.entity.SalesEntity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IncompleteSaleAdapter extends RecyclerView.Adapter<IncompleteSaleAdapter.IncompleteSaleHolder> implements View.OnClickListener {
    private static final String TAG = "IncompleteSaleAdapter";
    private ArrayList<SalesEntity> salesList;
    private Context context;
    private View.OnClickListener listener;

    public IncompleteSaleAdapter(ArrayList<SalesEntity> salesList, Context context) {
        this.salesList = salesList;
        this.context = context;
    }

    @NonNull
    @Override
    public IncompleteSaleHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_incomplete_sales_adapter, parent, false);
        view.setOnClickListener(this);
        IncompleteSaleHolder incompleteSaleHolder = new IncompleteSaleHolder(view);
        return incompleteSaleHolder;
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull IncompleteSaleHolder incompleteSaleHolder, int position) {
        SalesEntity sales = salesList.get(position);
        incompleteSaleHolder.tvNoSale.setText(String.valueOf(sales.getDocumentFolio()));
        incompleteSaleHolder.tvDateSaleDialog.setText(sales.getDate());
    }

    @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onClick(view);
        }
    }

    @Override
    public int getItemCount() {
        return salesList.size();
    }

    public class IncompleteSaleHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvNoSale)
        protected TextView tvNoSale;
        @BindView(R.id.tvDateSaleDialog)
        protected TextView tvDateSaleDialog;

        public IncompleteSaleHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
