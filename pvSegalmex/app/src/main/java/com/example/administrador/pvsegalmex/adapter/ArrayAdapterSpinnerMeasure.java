package com.example.administrador.pvsegalmex.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.entity.UnitMeasurementEntity;

import java.util.ArrayList;

public class ArrayAdapterSpinnerMeasure extends ArrayAdapter<UnitMeasurementEntity> {
    private Context context;
    private ArrayList<UnitMeasurementEntity> unitMeasurementEntityList;
    int textViewResourceId;

    public ArrayAdapterSpinnerMeasure(Context context, int textViewResourceId, ArrayList<UnitMeasurementEntity> clienteEntities) {
        super(context, textViewResourceId, clienteEntities);
        this.context = context;
        this.unitMeasurementEntityList = clienteEntities;
        this.textViewResourceId = textViewResourceId;
    }

    @Override
    public UnitMeasurementEntity getItem(int position) {
        return unitMeasurementEntityList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return unitMeasurementEntityList.get(position).getId();
    }

    @Override
    public int getCount() {
        return unitMeasurementEntityList.size();
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.sp_client_sale, parent, false);
        UnitMeasurementEntity unitMeasurement = (UnitMeasurementEntity) getItem(position);
        TextView txv = row.findViewById(R.id.tvClientSale);
        String unitMeasurementDescription = unitMeasurement.getDescription();
        txv.setText(unitMeasurementDescription);
        return row;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.sp_client_sale, parent, false);
        UnitMeasurementEntity unitMeasurement = (UnitMeasurementEntity) getItem(position);
        TextView txv = row.findViewById(R.id.tvClientSale);
        String unitMeasurementDescription = unitMeasurement.getDescription();
        txv.setText(unitMeasurementDescription);
        return row;
    }
}
