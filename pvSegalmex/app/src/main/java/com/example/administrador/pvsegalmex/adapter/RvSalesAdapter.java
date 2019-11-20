package com.example.administrador.pvsegalmex.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.pojo.SalesClientPojo;

import java.text.DecimalFormat;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.annotations.NonNull;

//Muestra en lista las ventas registrados
public class RvSalesAdapter extends RecyclerView.Adapter<RvSalesAdapter.RvSalesHolder> implements View.OnClickListener {
    private static final String TAG = "RvSalesAdapter";
    private ArrayList<SalesClientPojo> salesList;
    private Context context;
    private View.OnClickListener listener;

    public RvSalesAdapter(ArrayList<SalesClientPojo> salesList, Context context) {
        this.salesList = salesList;
        this.context = context;
    }

    @NonNull
    @Override
    public RvSalesAdapter.RvSalesHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_sales_adapter, parent, false);
        view.setOnClickListener(this);
        RvSalesHolder rvSalesHolder = new RvSalesHolder(view);
        return rvSalesHolder;
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull RvSalesAdapter.RvSalesHolder rvSalesHolder, int position) {
        SalesClientPojo sales = salesList.get(position);
        DecimalFormat df = new DecimalFormat("#.00");
        Double amount = Double.parseDouble(sales.getAmount());
        Double percentage = Double.parseDouble(sales.getUtilityPercentage());

        rvSalesHolder.tvDateSale.setText(sales.getDate().toUpperCase());
        rvSalesHolder.tvTotalSale.setText("$ " + String.valueOf(df.format(amount)));
        rvSalesHolder.tvClienteSaleView.setText(String.valueOf(sales.getClient()).toUpperCase());
        rvSalesHolder.tvWayPaySale.setText(String.valueOf(sales.getWayPay()));
        rvSalesHolder.tvUtility.setText(String.valueOf(df.format(percentage)));
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

    public class RvSalesHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvDateSale)
        protected TextView tvDateSale;
        @BindView(R.id.tvTotalSale)
        protected TextView tvTotalSale;
        @BindView(R.id.tvClienteSaleView)
        protected TextView tvClienteSaleView;
        @BindView(R.id.tvWayPaySale)
        protected TextView tvWayPaySale;
        @BindView(R.id.tvUtility)
        protected TextView tvUtility;

        public RvSalesHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}