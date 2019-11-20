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
import com.example.administrador.pvsegalmex.entity.DepartmentEntity;

import java.util.ArrayList;

import io.reactivex.annotations.NonNull;

//Permite visualizar la descripcion de departamentos en un spinner en CrudCategory
public class RvCDSpinnerAdapter extends BaseAdapter implements SpinnerAdapter {
    private Context context;
    private ArrayList<DepartmentEntity> departmentList;

    public RvCDSpinnerAdapter(ArrayList<DepartmentEntity> departmentList, Context context) {
        this.context = context;
        this.departmentList = departmentList;
    }

    @Override
    public int getCount() {
        return departmentList.size();
    }

    @Override
    public Object getItem(int position) {
        return departmentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return departmentList.get(position).getId();
    }

    @SuppressLint("ViewHolder")
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.rv_spinner_categoria_departamento, parent, false);
        DepartmentEntity department = (DepartmentEntity) getItem(position);
        TextView txt = row.findViewById(R.id.tvCategoryDepartment);
        txt.setText(department.getDescription());
        return row;
    }

    public View getDropDownView(int position, View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.rv_spinner_categoria_departamento, parent, false);
        TextView txt = row.findViewById(R.id.tvCategoryDepartment);
        DepartmentEntity department = (DepartmentEntity) getItem(position);
        txt.setText(department.getDescription());
        if (position == 0) {
            txt.setBackgroundColor(context.getResources().getColor(R.color.light_gray));
            txt.setTextColor(context.getResources().getColor(R.color.black));
        }
        txt.setText(department.getDescription());
        return row;
    }
}
