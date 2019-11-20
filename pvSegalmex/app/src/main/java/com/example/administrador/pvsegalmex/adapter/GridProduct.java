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
import com.example.administrador.pvsegalmex.pojo.ProductPricePojo;
import com.example.administrador.pvsegalmex.utils.Utils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

//Adaptador para mostrar Productos en el Punto de Venta
public class GridProduct extends RecyclerView.Adapter<GridProduct.GridProductHolder> implements View.OnClickListener {
    private static final String TAG = "RvProductAdapter";
    private ArrayList<ProductPricePojo> productList;
    private Context context;
    private View.OnClickListener listener;

    public GridProduct(ArrayList<ProductPricePojo> productList, Context context) {
        this.productList = productList;
        this.context = context;
    }

    @NonNull
    @Override
    public GridProduct.GridProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        int layout;

        if (Utils.visualizacion == Utils.LIST) {
            layout = R.layout.productcatalog_list_view_adapter;
        } else {
            layout = R.layout.productcatalog_grid_view_adapter;
        }

        View view = LayoutInflater.from(context).inflate(layout, parent, false);

        view.setOnClickListener(this);
        GridProductHolder gph = new GridProductHolder(view);

        return gph;
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull GridProduct.GridProductHolder rvProductHolder, int position) {
        ProductPricePojo product = productList.get(position);
        rvProductHolder.tvProductName.setText(product.getDescription());
        rvProductHolder.tvProductUnit.setText(product.getUnitMeasurePurchase());
        rvProductHolder.tvProductUUID.setText(product.getUuid());
        if (product.getImage().isEmpty()) {
            rvProductHolder.imvProductGrid.setImageResource(R.drawable.sinproducto);
        } else {
            Picasso.get().load(product.getImage()).into(rvProductHolder.imvProductGrid);
        }
        if (productList.get(position).getPrice() == null) {
            rvProductHolder.tvProductPrice.setText(String.valueOf(product.getCost()));

        } else {
            rvProductHolder.tvProductPrice.setText(String.valueOf(product.getPrice()));
        }
        if (product.getGranel() == 1) {
            rvProductHolder.tvProductGranel.setText("GRANEL");
        } else {
            rvProductHolder.tvProductGranel.setText("*");
        }
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onClick(view);
        }
    }

    public class GridProductHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvProductName)
        protected TextView tvProductName;
        @BindView(R.id.tvProductPrice)
        protected TextView tvProductPrice;
        @BindView(R.id.imvProductGrid)
        protected ImageView imvProductGrid;
        @BindView(R.id.tvProductGranel)
        protected TextView tvProductGranel;
        @BindView(R.id.tvProductUnit)
        protected TextView tvProductUnit;
        @BindView(R.id.tvProductUUID)
        protected TextView tvProductUUID;

        public GridProductHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}