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
import com.example.administrador.pvsegalmex.entity.CategoryEntity;

import java.util.ArrayList;

import io.reactivex.annotations.NonNull;

//Permite visualizar la categoria de producto en un spinner en FragmentProduct
public class RvPCSpinnerAdapter extends BaseAdapter implements SpinnerAdapter {
    private Context context;
    private ArrayList<CategoryEntity> categoryList;

    public RvPCSpinnerAdapter(Context context, ArrayList<CategoryEntity> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @Override
    public int getCount() {
        return categoryList.size();
    }

    @Override
    public Object getItem(int position) {
        return categoryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return categoryList.get(position).getId();
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.rv_spinner_product_category_adapter, parent, false);
        CategoryEntity category = (CategoryEntity) getItem(position);
        TextView txv = row.findViewById(R.id.tvProductCategory);
        txv.setText(category.getDescription());
        return row;
    }

    public View getDropDownView(int position, View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.rv_spinner_product_category_adapter, parent, false);
        CategoryEntity category = (CategoryEntity) getItem(position);
        TextView txv = row.findViewById(R.id.tvProductCategory);
        txv.setText(category.getDescription());
        if (position == 0) {
            txv.setBackgroundColor(context.getResources().getColor(R.color.light_gray));
            txv.setTextColor(context.getResources().getColor(R.color.black));
        }
        txv.setText(category.getDescription());
        return row;
    }
}
