package com.example.administrador.pvsegalmex.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.pojo.ExistProductPojo;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RvExistProductAdapter extends RecyclerView.Adapter<RvExistProductAdapter.RvExistProductHolder> {
    private static final String TAG = "RvExistProductAdapter";
    private ArrayList<ExistProductPojo> existList;
    private Context context;

    public RvExistProductAdapter(ArrayList<ExistProductPojo> existList, Context context) {
        this.existList = existList;
        this.context = context;
    }

    @NonNull
    @Override
    public RvExistProductHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_exist_product_adapter, viewGroup, false);
        RvExistProductHolder rvExistProductHolder = new RvExistProductHolder(view);
        return rvExistProductHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RvExistProductHolder rvExistProductHolder, int i) {
        ExistProductPojo existEntity = existList.get(i);
        rvExistProductHolder.tvExist.setText(String.valueOf(existEntity.getExist()));
        rvExistProductHolder.tvProductExist.setText(String.valueOf(existEntity.getDescription()));
    }

    @Override
    public int getItemCount() {
        return existList.size();
    }

    public class RvExistProductHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvExist)
        protected TextView tvExist;
        @BindView(R.id.tvProductExist)
        protected TextView tvProductExist;

        public RvExistProductHolder(@android.support.annotation.NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
