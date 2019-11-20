package com.example.administrador.pvsegalmex.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.entity.WayPayEntity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

//Adaptador para mostrar Formas de Pago para pagar
public class GridWayPaySales extends RecyclerView.Adapter<GridWayPaySales.GridWayPaySalesHolder> implements View.OnClickListener {
    private static final String TAG = "RvGridWayPayAdapter";
    private ArrayList<WayPayEntity> wayPayList;
    private Context context;
    private View.OnClickListener listener;
    int row_index = -1;

    public GridWayPaySales(ArrayList<WayPayEntity> wayPayList, Context context) {
        this.wayPayList = wayPayList;
        this.context = context;
    }

    @NonNull
    @Override
    public GridWayPaySales.GridWayPaySalesHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.sales_waypay_grid_view_adapter, parent, false);
        view.setOnClickListener(this);
        GridWayPaySalesHolder gwp = new GridWayPaySalesHolder(view);
        return gwp;
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull GridWayPaySales.GridWayPaySalesHolder rvWayPayHolder, int position) {
        WayPayEntity wayPay = wayPayList.get(position);

        if (wayPay.getImage().isEmpty()) {
            rvWayPayHolder.imvImageWayPaySales.setImageResource(R.drawable.sinproducto);
        } else {
            Picasso.get().load(wayPay.getImage()).into(rvWayPayHolder.imvImageWayPaySales);
        }
        rvWayPayHolder.tvWayPayDescriptionSales.setText(String.valueOf(wayPay.getDescription()));

        rvWayPayHolder.itemWayPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row_index = position;
                if (listener != null) {
                    listener.onClick(v);
                }
                notifyDataSetChanged();
            }
        });

        if (row_index == position) {
            rvWayPayHolder.itemWayPay.setCardBackgroundColor(Color.parseColor("#03A9F4"));
            rvWayPayHolder.tvWayPayDescriptionSales.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            rvWayPayHolder.itemWayPay.setCardBackgroundColor(Color.parseColor("#ffffff"));
            rvWayPayHolder.tvWayPayDescriptionSales.setTextColor(Color.parseColor("#686565"));
        }
    }

    @Override
    public int getItemCount() {
        return wayPayList.size();
    }

    @Override
    public void onClick(View view) {
    }

    public class GridWayPaySalesHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imvImageWayPaySales)
        protected ImageView imvImageWayPaySales;
        @BindView(R.id.tvWayPayDescriptionSales)
        protected TextView tvWayPayDescriptionSales;
        @BindView(R.id.itemWayPay)
        protected CardView itemWayPay;

        public GridWayPaySalesHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
