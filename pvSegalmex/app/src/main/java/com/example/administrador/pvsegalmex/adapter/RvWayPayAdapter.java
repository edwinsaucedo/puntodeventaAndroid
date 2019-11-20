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
import com.example.administrador.pvsegalmex.entity.WayPayEntity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

//Muestra en lista formas de pago registradas
public class RvWayPayAdapter extends RecyclerView.Adapter<RvWayPayAdapter.RvWayPayHolder> {
    private static final String TAG = "RvWayPayAdapter";
    private ArrayList<WayPayEntity> wayPayList;
    private Context context;
    private String imWayPay;

    public RvWayPayAdapter(ArrayList<WayPayEntity> wayPayList, Context context) {
        this.wayPayList = wayPayList;
        this.context = context;
    }

    @NonNull
    @Override
    public RvWayPayAdapter.RvWayPayHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.waypay_recycler_view_adapter, parent, false);
        return new RvWayPayHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvWayPayHolder rvWayPayHolder, int position) {
        WayPayEntity wayPay = wayPayList.get(position);
        String waPayDescription = wayPay.getDescription();
        rvWayPayHolder.tvWayPayDescription.setText(waPayDescription);
        if (wayPay.getImage().isEmpty() || wayPay.getImage() == null) {
            rvWayPayHolder.imgWayPay.setImageResource(R.drawable.sinproducto);
        } else {
            Picasso.get().load(wayPay.getImage()).into(rvWayPayHolder.imgWayPay);
        }

    }

    @Override
    public int getItemCount() {
        return wayPayList.size();
    }

    public class RvWayPayHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imvWayPay)
        protected ImageView imgWayPay;
        @BindView(R.id.tvWayPayDescription)
        protected TextView tvWayPayDescription;

        private RvWayPayHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}