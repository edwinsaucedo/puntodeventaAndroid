package com.example.administrador.pvsegalmex.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.entity.ProviderEntity;

import java.util.ArrayList;

import io.reactivex.annotations.NonNull;

//Muestra en un sppiner los proveedores en ReceiptOfMerchandise
public class SimpleSpinnerProviderAdapter extends BaseAdapter implements SpinnerAdapter {
    private Context context;
    private ArrayList<ProviderEntity> providerList;

    public SimpleSpinnerProviderAdapter(ArrayList<ProviderEntity> providerList, Context context) {
        this.context = context;
        this.providerList = providerList;
    }

    @Override
    public int getCount() {
        return providerList.size();
    }

    @Override
    public Object getItem(int position) {
        return providerList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return providerList.get(position).getId();
    }

    @SuppressLint("ViewHolder")
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.spinner_provider, parent, false);
        ProviderEntity provider = (ProviderEntity) getItem(position);
        TextView txt = row.findViewById(R.id.tvProviderReceiptMerchandise);
        txt.setText(provider.getName());
        return row;
    }

    public View getDropDownView(int position, View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.spinner_provider, parent, false);
        TextView txt = row.findViewById(R.id.tvProviderReceiptMerchandise);
        ProviderEntity provider = (ProviderEntity) getItem(position);
        txt.setText(provider.getName());
        if (position == 0) {
            txt.setBackgroundColor(context.getResources().getColor(R.color.light_gray));
            txt.setTextColor(context.getResources().getColor(R.color.black));
        }
        txt.setText(provider.getName());
        return row;
    }
}
