package com.example.administrador.pvsegalmex.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.pojo.ProductPricePojo;
import com.example.administrador.pvsegalmex.utils.Utils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GridProductAdapter extends BaseAdapter {
    private static final String TAG = "RvProductAdapter";
    private ArrayList<ProductPricePojo> productList;
    private Context context;

    public GridProductAdapter(ArrayList<ProductPricePojo> productList, Context context) {
        this.productList = productList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return productList.get(position).getIdProduct();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (Utils.visualizacion == Utils.LIST) {
                view = inflater.inflate(R.layout.productcatalog_list_view_adapter, viewGroup, false);
            } else {
                view = inflater.inflate(R.layout.productcatalog_grid_view_adapter, viewGroup, false);
            }
        }

        TextView tvProductName = view.findViewById(R.id.tvProductName);
        TextView tvProductPrice = view.findViewById(R.id.tvProductPrice);
        ImageView imvProductGrid = view.findViewById(R.id.imvProductGrid);
        TextView tvProductGranel = view.findViewById(R.id.tvProductGranel);
        TextView tvProductUnit = view.findViewById(R.id.tvProductUnit);
        TextView tvProductUUID = view.findViewById(R.id.tvProductUUID);

        ProductPricePojo product = productList.get(position);
        tvProductName.setText(product.getDescription());
        tvProductUnit.setText(product.getUnitMeasurePurchase());
        tvProductUUID.setText(product.getUuid());
        if (product.getImage().isEmpty()) {
            imvProductGrid.setImageResource(R.drawable.sinproducto);
        } else {
            Picasso.get().load(product.getImage()).into(imvProductGrid);
        }
        if (productList.get(position).getPrice() == null) {
            tvProductPrice.setText(String.valueOf(product.getCost()));

        } else {
            tvProductPrice.setText(String.valueOf(product.getPrice()));
        }
        if (product.getGranel() == 1) {
            tvProductGranel.setText("GRANEL");
        } else {
            tvProductGranel.setText("*");
        }
        return view;
    }

   /* @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onClick(view);
        }
    }*/
}
