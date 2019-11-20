package com.example.administrador.pvsegalmex.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrador.pvsegalmex.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

//Muestra en lista el detalle de venta por producto en el Punto de venta
public class RvProductSaleAdapter extends RecyclerView.Adapter<RvProductSaleAdapter.ViewHolder> implements View.OnClickListener, View.OnLongClickListener {
    private ArrayList<ProductSale> productSalesList;
    private View.OnClickListener listener;
    private View.OnLongClickListener longClickListener;
    Context context;

    public RvProductSaleAdapter(Context context, ArrayList<ProductSale> productSalesList) {
        this.productSalesList = productSalesList;
        this.context = context;
    }

    @NonNull
    @Override
    public RvProductSaleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.productsale_recycler_view_adapter, viewGroup, false);
        v.setOnClickListener(this);
        return new ViewHolder(v);
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.longClickListener = onLongClickListener;
    }

    @Override
    public void onBindViewHolder(@NonNull RvProductSaleAdapter.ViewHolder viewHolder, int i) {
        viewHolder.tvProductSaleQuantity.setText(String.valueOf(productSalesList.get(i).getProductQuantity()));
        viewHolder.tvProductSaleDescription.setText(productSalesList.get(i).getProductSaleDescription().toUpperCase());
        viewHolder.tvProductSaleCost.setText(context.getString(R.string.txvUnitPrice) + " " + String.valueOf(productSalesList.get(i).getProductSaleCost()));
        viewHolder.tvProductSaleCostQuantity.setText(String.valueOf(productSalesList.get(i).getProductSaleCostQuantity()));
    }

    @Override
    public int getItemCount() {
        return productSalesList.size();
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onClick(v);
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if (longClickListener != null) {
            longClickListener.onLongClick(v);
        }
        return true;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvProductSaleCant)
        protected TextView tvProductSaleQuantity;
        @BindView(R.id.tvbtvProductSaleDesc)
        protected TextView tvProductSaleDescription;
        @BindView(R.id.tvProductSaleCost)
        protected TextView tvProductSaleCost;
        @BindView(R.id.tvProductSaleCostQuantity)
        TextView tvProductSaleCostQuantity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}