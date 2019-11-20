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
import com.example.administrador.pvsegalmex.entity.UnitMeasurementEntity;

import java.util.ArrayList;

import io.reactivex.annotations.NonNull;

public class SimpleSpinnerUnitMeasurementReceipt extends BaseAdapter implements SpinnerAdapter {
    private Context context;
    private ArrayList<UnitMeasurementEntity> unitMeasurementList;

    public SimpleSpinnerUnitMeasurementReceipt(ArrayList<UnitMeasurementEntity> unitMeasurementList, Context context) {
        this.context = context;
        this.unitMeasurementList = unitMeasurementList;
    }

    public SimpleSpinnerUnitMeasurementReceipt(Context applicationContext, int spinner_provider, ArrayList<UnitMeasurementEntity> unitMeasurementList) {
    }

    @Override
    public int getCount() {
        return unitMeasurementList.size();
    }

    @Override
    public Object getItem(int position) {
        return unitMeasurementList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return unitMeasurementList.get(position).getId();
    }

    @SuppressLint("ViewHolder")
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.spinner_provider, parent, false);
        UnitMeasurementEntity unitMeasurementEntity = (UnitMeasurementEntity) getItem(position);
        TextView txt = row.findViewById(R.id.tvProviderReceiptMerchandise);
        txt.setText(unitMeasurementEntity.getDescription());
        return row;
    }

    public View getDropDownView(int position, View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.spinner_provider, parent, false);
        TextView txt = row.findViewById(R.id.tvProviderReceiptMerchandise);
        UnitMeasurementEntity unitMeasurementEntity = (UnitMeasurementEntity) getItem(position);
        txt.setText(unitMeasurementEntity.getDescription());
        if (position == 0) {
            txt.setBackgroundColor(context.getResources().getColor(R.color.light_gray));
            txt.setTextColor(context.getResources().getColor(R.color.black));
        }
        txt.setText(unitMeasurementEntity.getDescription());
        return row;
    }
}
