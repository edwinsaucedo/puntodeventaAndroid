package com.example.administrador.pvsegalmex.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.entity.ClienteEntity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

//Muestra en lista los clientes registrados
public class RvClientAdapter extends RecyclerView.Adapter<RvClientAdapter.RvClientHolder> {
    private static final String TAG = "RvClientAdapter";
    private ArrayList<ClienteEntity> clientList;
    private Context context;
    private Bitmap bmClient;

    public RvClientAdapter(ArrayList<ClienteEntity> clientList, Context context) {
        this.clientList = clientList;
        this.context = context;
    }

    @NonNull
    @Override
    public RvClientHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.client_recycler_view_adapter, parent, false);
        return new RvClientHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvClientHolder rvClientHolder, int position) {
        ClienteEntity client = clientList.get(position);
        if (client.getPhotoClient().isEmpty() || client.getPhotoClient() == "") {
            rvClientHolder.imgClient.setImageResource(R.drawable.sinproducto);
        } else {
            Picasso.get().load(client.getPhotoClient()).into(rvClientHolder.imgClient);
        }
        String clientName = client.getName() + " " + client.getLastName1() + " " + client.getLastName2();
        rvClientHolder.tvClientName.setText(clientName.toUpperCase());
        rvClientHolder.tvClientCurp.setText(client.getCurp().toUpperCase());
    }

    @Override
    public int getItemCount() {
        return clientList.size();
    }

    public class RvClientHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imvClient)
        protected ImageView imgClient;
        @BindView(R.id.tvClientName)
        protected TextView tvClientName;
        @BindView(R.id.tvClientCurp)
        protected TextView tvClientCurp;

        private RvClientHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}