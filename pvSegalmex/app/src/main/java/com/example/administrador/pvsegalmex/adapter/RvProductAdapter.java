package com.example.administrador.pvsegalmex.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.entity.ProductEntity;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

//Muestra en lista los productos registrados
public class RvProductAdapter extends RecyclerView.Adapter<RvProductAdapter.RvProductHolder> {
    private static final String TAG = "RvProductAdapter";
    private ArrayList<ProductEntity> productList;
    private Context context;

    public RvProductAdapter(ArrayList<ProductEntity> productList, Context context) {
        this.productList = productList;
        this.context = context;
    }

    @NonNull
    @Override
    public RvProductAdapter.RvProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_recycler_view_adapter, parent, false);
        return new RvProductHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvProductAdapter.RvProductHolder rvProductHolder, int position) {
        ProductEntity product = productList.get(position);
        rvProductHolder.tvProductDescription.setText(product.getDescription().toUpperCase());
        rvProductHolder.tvProductCode.setText(product.getCode().toUpperCase());
        rvProductHolder.tvProductCost.setText("$ " + String.valueOf(product.getCost()));
        if (product.getImage().isEmpty() || product.getImage().toString() == "") {
            rvProductHolder.imvProduct.setImageResource(R.drawable.sinproducto);
        } else {
            Picasso.get().load(new File("file://"+product.getImage())).into(rvProductHolder.imvProduct);
        }

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class RvProductHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvProductDescription)
        protected TextView tvProductDescription;
        @BindView(R.id.tvProductCode)
        protected TextView tvProductCode;
        @BindView(R.id.tvProductCost)
        protected TextView tvProductCost;
        @BindView(R.id.imvProduct)
        protected ImageView imvProduct;

        public RvProductHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}