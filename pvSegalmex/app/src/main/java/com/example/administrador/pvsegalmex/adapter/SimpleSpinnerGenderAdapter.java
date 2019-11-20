package com.example.administrador.pvsegalmex.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.administrador.pvsegalmex.R;


/**
 * Created by guoquan on 3/31/2017.
 */
//Muetra el genero en el catalogo Clientes
public class SimpleSpinnerGenderAdapter extends ArrayAdapter {
    private final Context context;
    private final String[] values;

    public SimpleSpinnerGenderAdapter(Context context, int resource, String[] objects) {
        super(context, resource, objects);
        this.context = context;
        this.values = objects;
    }

    @NonNull
    @SuppressLint("ViewHolder")
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.item_simple_spinner, parent, false);
        TextView txt = (TextView) row.findViewById(R.id.text1);
        txt.setText(values[position]);
        return row;
    }

    public View getDropDownView(int position, View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.item_simple_spinner, parent, false);
        TextView txt = (TextView) row.findViewById(R.id.text1);
        if (position == 0) {
            txt.setBackgroundColor(context.getResources().getColor(R.color.light_gray));
            txt.setTextColor(context.getResources().getColor(R.color.black));
        }
        txt.setText(values[position]);
        return row;
    }
}
