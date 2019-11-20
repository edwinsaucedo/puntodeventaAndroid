package com.example.administrador.pvsegalmex.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.entity.CashIncomeEntity;
import com.example.administrador.pvsegalmex.entity.CashShortDetailEntity;
import com.example.administrador.pvsegalmex.entity.ProductEntity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.annotations.NonNull;

public class ArrayAdapterProduct extends ArrayAdapter<ProductEntity> {
    private Context context;
    private ArrayList<ProductEntity> productList;
    int textViewResourceId;

    public ArrayAdapterProduct(Context context, int textViewResourceId, ArrayList<ProductEntity> productList) {
        super(context, textViewResourceId, productList);
        this.context = context;
        this.textViewResourceId = textViewResourceId;
        this.productList = productList;
    }

    @Override
    public ProductEntity getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return productList.get(position).getId();
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.spinner_provider, parent, false);
        ProductEntity product = (ProductEntity) getItem(position);
        TextView txv = row.findViewById(R.id.tvProviderReceiptMerchandise);
        txv.setText(product.getDescription());
        return row;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.spinner_provider, parent, false);
        ProductEntity product = (ProductEntity) getItem(position);
        TextView txv = row.findViewById(R.id.tvProviderReceiptMerchandise);
        txv.setText(product.getDescription());
        return row;
    }

    //Muestra los cortes de caja registrados
    public static class RvCashShortDetailAdapter extends RecyclerView.Adapter<RvCashShortDetailAdapter.RvCashShortDetailHolder> implements View.OnClickListener {
        public static final String TAG = "RvCashShortDetailAdapter";
        private ArrayList<CashShortDetailEntity> cashShortDetailList;
        private Context context;
        private View.OnClickListener listener;

        public RvCashShortDetailAdapter(ArrayList<CashShortDetailEntity> cashShortDetailList, Context context) {
            this.cashShortDetailList = cashShortDetailList;
            this.context = context;
        }

        @NonNull
        @Override
        public RvCashShortDetailHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
            View view = LayoutInflater.from(context).inflate(R.layout.cash_short_detail_recycler_view_adapter, parent, false);
            view.setOnClickListener(this);
            RvCashShortDetailHolder rvCashShortDetailHolder = new RvCashShortDetailHolder(view);
            return rvCashShortDetailHolder;
        }

        public void setOnClickListener(View.OnClickListener listener) {
            this.listener = listener;
        }

        @Override
        public void onBindViewHolder(@NonNull RvCashShortDetailHolder rvCashShortDetailHolder, int position) {
            CashShortDetailEntity cashShortDetail = cashShortDetailList.get(position);
            rvCashShortDetailHolder.tvAmountCashShortDetail.setText(String.valueOf(cashShortDetail.getAmountCap()));

            java.util.Date utilDate = new java.util.Date();
            Calendar cal = Calendar.getInstance(); // locale-specific
            cal.setTime(utilDate);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            long time = cal.getTimeInMillis();
            java.sql.Timestamp sqlTimestamp = new Timestamp(time);
            rvCashShortDetailHolder.tvDateCashShortDetail.setText(String.valueOf(sqlTimestamp));
        }

        @Override
        public void onClick(View view) {
            if (listener != null) {
                listener.onClick(view);
            }
        }

        @Override
        public int getItemCount() {
            return cashShortDetailList.size();
        }

        public class RvCashShortDetailHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.tvAmountCashShortDetail)
            protected TextView tvAmountCashShortDetail;
            @BindView(R.id.tvDateCashShortDetail)
            protected TextView tvDateCashShortDetail;

            public RvCashShortDetailHolder(@android.support.annotation.NonNull View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }
        }
    }

    //Muestra en lista los ingresos registrados
    public static class RvCashIncomeAdapter extends RecyclerView.Adapter<RvCashIncomeAdapter.RvCashIncomeHolder> implements View.OnClickListener {
        private static final String TAG = "RvCashIncomeAdapter";
        private ArrayList<CashIncomeEntity> incomeList;
        private Context context;
        private View.OnClickListener listener;

        public RvCashIncomeAdapter(ArrayList<CashIncomeEntity> incomeList, Context context) {
            this.incomeList = incomeList;
            this.context = context;
        }

        @android.support.annotation.NonNull
        @Override
        public RvCashIncomeHolder onCreateViewHolder(@android.support.annotation.NonNull ViewGroup parent, int i) {
            View view = LayoutInflater.from(context).inflate(R.layout.rv_cash_income_adapter, parent, false);
            view.setOnClickListener(this);
            RvCashIncomeHolder rvCashIncomeHolder = new RvCashIncomeHolder(view);
            return rvCashIncomeHolder;
        }

        public void setOnClickListener(View.OnClickListener listener) {
            this.listener = listener;
        }

        @Override
        public void onBindViewHolder(@android.support.annotation.NonNull RvCashIncomeHolder rvCashIncomeHolder, int position) {
            CashIncomeEntity cashIncomeEntity = incomeList.get(position);
            rvCashIncomeHolder.tvDateIncome.setText(cashIncomeEntity.getDate());
            rvCashIncomeHolder.tvAmountIncome.setText(String.valueOf("$" + cashIncomeEntity.getAmount()));
        }

        @Override
        public int getItemCount() {
            return incomeList.size();
        }

        @Override
        public void onClick(View view) {

            if (listener != null) {
                listener.onClick(view);
            }
        }

        public class RvCashIncomeHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.tvAmountIncome)
            protected TextView tvAmountIncome;
            @BindView(R.id.tvDateIncome)
            protected TextView tvDateIncome;

            public RvCashIncomeHolder(@android.support.annotation.NonNull View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }
        }
    }
}
