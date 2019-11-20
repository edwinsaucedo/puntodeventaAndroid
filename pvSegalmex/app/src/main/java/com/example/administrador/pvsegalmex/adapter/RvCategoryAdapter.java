package com.example.administrador.pvsegalmex.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.entity.CategoryEntity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.annotations.NonNull;

//Muestra en lista las cartegorias registrados
public class RvCategoryAdapter extends RecyclerView.Adapter<RvCategoryAdapter.RvCategoryHolder> {
    private static final String TAG = "RvCategoryAdapter";
    private ArrayList<CategoryEntity> categoryList;
    private Context context;

    public RvCategoryAdapter(ArrayList<CategoryEntity> categoryList, Context context) {
        this.categoryList = categoryList;
        this.context = context;
    }

    @NonNull
    @Override
    public RvCategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_recycler_view_adapter, parent, false);
        return new RvCategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvCategoryHolder rvCategoryHolder, int position) {
        CategoryEntity category = categoryList.get(position);
        String categoryDescription = category.getDescription();
        rvCategoryHolder.tvCategoryDescription.setText(categoryDescription);
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class RvCategoryHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvCategoryDescription)
        protected TextView tvCategoryDescription;


        public RvCategoryHolder(@android.support.annotation.NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
