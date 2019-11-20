package com.example.administrador.pvsegalmex.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.pojo.ReceiptMerchandiseProviderPojo;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.annotations.NonNull;

//Muestra en lista los recibos de mercancia registrados
public class RvReceiptMerchandiseProviderAdapter extends RecyclerView.Adapter<RvReceiptMerchandiseProviderAdapter.RvReceiptMerchandiseProviderHolder> implements View.OnClickListener {
    private static final String TAG = "RvReceiptMerchandiseProviderAdapter";
    private ArrayList<ReceiptMerchandiseProviderPojo> receiptMerchandiseList;
    private Context context;
    private View.OnClickListener listener;

    public RvReceiptMerchandiseProviderAdapter(ArrayList<ReceiptMerchandiseProviderPojo> receiptMerchandiseList, Context context) {
        this.receiptMerchandiseList = receiptMerchandiseList;
        this.context = context;
    }

    @NonNull
    @Override
    public RvReceiptMerchandiseProviderAdapter.RvReceiptMerchandiseProviderHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_receipt_merchandise_adapter, parent, false);
        view.setOnClickListener(this);
        RvReceiptMerchandiseProviderAdapter.RvReceiptMerchandiseProviderHolder rvReceiptMerchandiseProviderHolder = new RvReceiptMerchandiseProviderAdapter.RvReceiptMerchandiseProviderHolder(view);
        return rvReceiptMerchandiseProviderHolder;
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull RvReceiptMerchandiseProviderAdapter.RvReceiptMerchandiseProviderHolder rvReceiptMerchandiseProviderHolder, int position) {
        ReceiptMerchandiseProviderPojo receiptMerchandise = receiptMerchandiseList.get(position);
        rvReceiptMerchandiseProviderHolder.dateRM.setText(receiptMerchandise.getDate());
        rvReceiptMerchandiseProviderHolder.providerRM.setText(receiptMerchandise.getName());
        rvReceiptMerchandiseProviderHolder.totalRM.setText(receiptMerchandise.getTotal());
        rvReceiptMerchandiseProviderHolder.articlesRM.setText(receiptMerchandise.getArticles());
    }

    @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onClick(view);
        }
    }

    @Override
    public int getItemCount() {
        return receiptMerchandiseList.size();
    }

    public class RvReceiptMerchandiseProviderHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvDateReceiptMerchandise)
        protected TextView dateRM;
        @BindView(R.id.tvTotalReceiptMerchandise)
        protected TextView totalRM;
        @BindView(R.id.tvArticlesReceiptMerchandise)
        protected TextView articlesRM;
        @BindView(R.id.tvProviderMerchandise)
        protected TextView providerRM;

        public RvReceiptMerchandiseProviderHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}