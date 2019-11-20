package com.example.administrador.pvsegalmex.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.entity.ProviderEntity;

import java.util.ArrayList;

//Adaptador que permite la busqueda de la entidad Proveedores en un SpinnerSearchable
public class ArrayAdapterProviderSpinner extends ArrayAdapter<ProviderEntity> {
    private Context context;
    private ArrayList<ProviderEntity> providerList;
    int textViewResourceId;

    public ArrayAdapterProviderSpinner(Context context, int textViewResourceId, ArrayList<ProviderEntity> providerList) {
        super(context, textViewResourceId, providerList);
        this.context = context;
        this.providerList = providerList;
        this.textViewResourceId = textViewResourceId;
    }

    @Override
    public ProviderEntity getItem(int position) {
        return providerList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return providerList.get(position).getId();
    }

    @Override
    public int getCount() {
        return providerList.size();
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.spinner_provider, parent, false);
        ProviderEntity provider = (ProviderEntity) getItem(position);
        TextView txv = row.findViewById(R.id.tvProviderReceiptMerchandise);
        txv.setText(provider.getName());
        return row;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.spinner_provider, parent, false);
        ProviderEntity provider = (ProviderEntity) getItem(position);
        TextView txv = row.findViewById(R.id.tvProviderReceiptMerchandise);
        txv.setText(provider.getName());
        return row;
    }
}