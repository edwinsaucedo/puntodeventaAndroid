package com.example.administrador.pvsegalmex.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.entity.WayPayEntity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

//Muestra formas de pago en corte de caja
public class RvWayPayInCashShortAdapter extends RecyclerView.Adapter<RvWayPayInCashShortAdapter.RvWayPayInCashShortHolder> {
    private static final String TAG = "RvWayPayInCashShortAdapter";
    private ArrayList<WayPayEntity> wayPayList;
    private Context context;
    private String imWayPay;
    private OnEditTextChanged onEditTextChanged;

    public RvWayPayInCashShortAdapter(ArrayList<WayPayEntity> wayPayList, OnEditTextChanged onEditTextChanged, Context context) {
        this.wayPayList = wayPayList;
        this.context = context;
        this.onEditTextChanged = onEditTextChanged;
    }

    public RvWayPayInCashShortAdapter(ArrayList<WayPayEntity> wayPayList, Context context) {
        this.wayPayList = wayPayList;
        this.context = context;
    }

    @NonNull
    @Override
    public RvWayPayInCashShortAdapter.RvWayPayInCashShortHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_waypay_in_cashshort_adapter, parent, false);
        return new RvWayPayInCashShortAdapter.RvWayPayInCashShortHolder(view);
    }

    @Override
    public void onBindViewHolder(RvWayPayInCashShortHolder rvWayPayHolder, final int position) {
        WayPayEntity wayPay = wayPayList.get(position);
        String waPayDescription = wayPay.getDescription();
        rvWayPayHolder.tvWayPayInCasShortDescription.setText(waPayDescription);
        if (wayPay.getImage().isEmpty()) {
            rvWayPayHolder.imvWayPayInCashShort.setImageResource(R.drawable.sinproducto);
        } else {
            Picasso.get().load(wayPay.getImage()).into(rvWayPayHolder.imvWayPayInCashShort);
        }
        rvWayPayHolder.idWayPayCashShort.setText(String.valueOf(wayPay.getId()));
        rvWayPayHolder.edt_WayPayInCashShort.setHint("0.0");

        rvWayPayHolder.edt_WayPayInCashShort.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                onEditTextChanged.onTextChanged(position, charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    @Override
    public int getItemCount() {
        return wayPayList.size();
    }

    public class RvWayPayInCashShortHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imvWayPayInCashShort)
        protected ImageView imvWayPayInCashShort;
        @BindView(R.id.tvWayPayInCasShortDescription)
        protected TextView tvWayPayInCasShortDescription;
        @BindView(R.id.edt_WayPayInCashShort)
        protected EditText edt_WayPayInCashShort;
        @BindView(R.id.idWayPayCashShort)
        protected TextView idWayPayCashShort;

        private RvWayPayInCashShortHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}