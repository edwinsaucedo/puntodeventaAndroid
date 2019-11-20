package com.example.administrador.pvsegalmex.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.entity.ClienteEntity;

import java.util.ArrayList;

//Adaptador que permite la busqueda de la entidad Clientes en un SpinnerSearchable
public class ArrayAdapterSpinner extends ArrayAdapter<ClienteEntity> {
    private Context context;
    private ArrayList<ClienteEntity> clienteList;
    int textViewResourceId;

    public ArrayAdapterSpinner(Context context, int textViewResourceId, ArrayList<ClienteEntity> clienteEntities) {
        super(context, textViewResourceId, clienteEntities);
        this.context = context;
        this.clienteList = clienteEntities;
        this.textViewResourceId = textViewResourceId;
    }

    @Override
    public ClienteEntity getItem(int position) {
        return clienteList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return clienteList.get(position).getId();
    }

    @Override
    public int getCount() {
        return clienteList.size();
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.sp_client_sale, parent, false);
        ClienteEntity client = (ClienteEntity) getItem(position);
        TextView txv = row.findViewById(R.id.tvClientSale);
        String clientName = client.getName() + " " + client.getLastName1() + " " + client.getLastName2();
        txv.setText(clientName);
        return row;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.sp_client_sale, parent, false);
        ClienteEntity client = (ClienteEntity) getItem(position);
        TextView txv = row.findViewById(R.id.tvClientSale);
        String clientName = client.getName() + " " + client.getLastName1() + " " + client.getLastName2();
        txv.setText(clientName);
        return row;
    }
}