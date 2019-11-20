package com.example.administrador.pvsegalmex.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.pojo.SalesDetailProductPojo;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

//Muestra el detalle de venta por cada producto de la venta en CashShortDetailView
public class RvDetailSaleAdapter extends RecyclerView.Adapter<RvDetailSaleAdapter.RvDetailSaleHolder> {
    private static final String TAG = "RvDetailSaleAdapter";
    private ArrayList<SalesDetailProductPojo> salesDetailList;
    Context context;

    public RvDetailSaleAdapter(ArrayList<SalesDetailProductPojo> salesDetailList, Context context) {
        this.salesDetailList = salesDetailList;
        this.context = context;
    }

    @NonNull
    @Override
    public RvDetailSaleAdapter.RvDetailSaleHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.detail_sale_view_adapter, parent, false);
        return new RvDetailSaleHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvDetailSaleAdapter.RvDetailSaleHolder rvDetailHolder, int position) {
        SalesDetailProductPojo salesDetail = salesDetailList.get(position);
        rvDetailHolder.tvProductDetailSaleCant.setText(String.valueOf(salesDetail.getQuantity().toUpperCase()));
        rvDetailHolder.tvProductDetailSaleName.setText(salesDetail.getProductDescription().toUpperCase());
        rvDetailHolder.tvProductDetailSaleCost.setText(context.getString(R.string.txvUnitPrice) + " " + String.valueOf(salesDetail.getUnitPrice().toUpperCase()));
        rvDetailHolder.tvProductDetailSaleCostQuantity.setText("$ " + String.valueOf(salesDetail.getSubtotal()));
        if (salesDetailList.get(position).getAmount() == null) {
            rvDetailHolder.tvProductDetailUtility.setText("$ 0.0");
        } else {
            rvDetailHolder.tvProductDetailUtility.setText(context.getString(R.string.txvUtility) + " $" + String.valueOf(salesDetail.getAmount().toUpperCase()));
        }
    }

    @Override
    public int getItemCount() {
        return salesDetailList.size();
    }

    static class RvDetailSaleHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvProductDetailSaleCant)
        protected TextView tvProductDetailSaleCant;
        @BindView(R.id.tvProductDetailSaleName)
        protected TextView tvProductDetailSaleName;
        @BindView(R.id.tvProductDetailSaleCost)
        protected TextView tvProductDetailSaleCost;
        @BindView(R.id.tvProductDetailSaleCostQuantity)
        TextView tvProductDetailSaleCostQuantity;
        @BindView(R.id.tvProductDetailUtility)
        TextView tvProductDetailUtility;

        public RvDetailSaleHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}