package com.example.administrador.pvsegalmex.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.entity.DepartmentEntity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

//Muestra en lista los departamentos registrados
public class RvDepartmentAdapter extends RecyclerView.Adapter<RvDepartmentAdapter.RvDepartmentHolder> {
    private static final String TAG = "RvDepartmentAdapter";
    private ArrayList<DepartmentEntity> departmentList;
    private Context context;

    public RvDepartmentAdapter(ArrayList<DepartmentEntity> departmentList, Context context) {
        this.departmentList = departmentList;
        this.context = context;
    }

    @NonNull
    @Override
    public RvDepartmentHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.departament_recycler_view_adapter, parent, false);
        return new RvDepartmentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvDepartmentAdapter.RvDepartmentHolder rvDepartmentHolder, int position) {
        DepartmentEntity department = departmentList.get(position);
        String departmentDescription = department.getDescription();
        rvDepartmentHolder.tvDepartamentDescription.setText(departmentDescription.toUpperCase());
    }

    @Override
    public int getItemCount() {
        return departmentList.size();
    }

    public class RvDepartmentHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvDepartamentDescription)
        protected TextView tvDepartamentDescription;

        public RvDepartmentHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}