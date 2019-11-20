package com.example.administrador.pvsegalmex.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.entity.ProviderEntity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

//Muestra en lista los proveedores registrados
public class RvProviderAdapter extends RecyclerView.Adapter<RvProviderAdapter.RvProviderHolder> {
    private static final String TAG = "RvProviderAdapter";
    private ArrayList<ProviderEntity> providerList;
    private Context context;

    public RvProviderAdapter(ArrayList<ProviderEntity> providerList, Context context) {
        this.providerList = providerList;
        this.context = context;
    }

    @NonNull
    @Override
    public RvProviderAdapter.RvProviderHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.provider_recylcer_view_adapter, parent, false);
        return new RvProviderHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvProviderAdapter.RvProviderHolder rvProviderHolder, int position) {
        ProviderEntity provider = providerList.get(position);
        String providerName = provider.getName();
        rvProviderHolder.tvProviderName.setText(providerName.toUpperCase());
        rvProviderHolder.tvProviderAlias.setText(provider.getAlias().toUpperCase());
        rvProviderHolder.tvProviderEmail.setText(provider.getEmail());
        rvProviderHolder.tvProviderPhone.setText(provider.getPhone());
    }

    @Override
    public int getItemCount() {
        return providerList.size();
    }

    public class RvProviderHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvProviderName)
        protected TextView tvProviderName;
        @BindView(R.id.tvProviderAlias)
        protected TextView tvProviderAlias;
        @BindView(R.id.tvProviderEmail)
        protected TextView tvProviderEmail;
        @BindView(R.id.tvProviderPhone)
        protected TextView tvProviderPhone;

        public RvProviderHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}