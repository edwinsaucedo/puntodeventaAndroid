package com.example.administrador.pvsegalmex.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.view.DetailReceiptMerchandise;

import java.util.ArrayList;

//Muestra el detalle de recibos de mercansia por producto
public class RvReceiptMerchandiseDetailAdapter extends ArrayAdapter<DetailReceiptMerchandise> {
    public static final String TAG = "RvReceiptMerchandiseDetailAdapter";
    private Context context;
    int resource;

    public RvReceiptMerchandiseDetailAdapter(Context context, int resource, ArrayList<DetailReceiptMerchandise> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String nameProduct = getItem(position).getNameProduct();
        String price = getItem(position).getPrice();
        String subtotal = getItem(position).getSubtotal();
        String quantity = getItem(position).getQuantity();
        String idProduct = getItem(position).getIdProduct();
        String idUnit = getItem(position).getIdUnitMeasurement();
        String unitDescription = getItem(position).getDescrioptionUnitMeasurement();
        String uuidProduct = getItem(position).getUuidProduct();

        DetailReceiptMerchandise detailReceiptMerchandise = new DetailReceiptMerchandise(nameProduct, quantity, price, subtotal, idProduct, idUnit, unitDescription, uuidProduct);

        LayoutInflater inflater = LayoutInflater.from(context);

        convertView = inflater.inflate(resource, parent, false);

        TextView txwQuantity = (TextView) convertView.findViewById(R.id.tvProductQuantityReceiptMerchandise);
        TextView txwPrice = (TextView) convertView.findViewById(R.id.tvProductPriceReceiptMerchandise);
        TextView txwSubtotal = (TextView) convertView.findViewById(R.id.tvProductSubtotalReceiptMerchandise);
        TextView txwNameProduct = (TextView) convertView.findViewById(R.id.tvProductNameReceiptMerchandise);
        TextView txwUnit = (TextView) convertView.findViewById(R.id.tvUnitReceiptMerchandise);

        txwPrice.setText(price);
        txwQuantity.setText(quantity);
        txwSubtotal.setText(subtotal);
        txwNameProduct.setText(nameProduct);
        txwUnit.setText(unitDescription);

        return convertView;
    }
}
