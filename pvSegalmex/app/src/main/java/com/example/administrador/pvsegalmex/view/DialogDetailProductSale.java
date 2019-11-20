package com.example.administrador.pvsegalmex.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrador.pvsegalmex.R;

public class DialogDetailProductSale {
    public DialogDetailProductSale(Context context) {
    }

    public interface setQuantityProduct {
        void resultQuantity(Integer quant, String code);
    }

    public int quantity = 0;
    public String codeP;
    public Double costP = 0.0;
    private setQuantityProduct interfaz;
    private Context context;

    public DialogDetailProductSale(Context context, setQuantityProduct actividad, String codeP, String descriptionP, Double costP, Integer quantityP) {

        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        interfaz = actividad;

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setLayout(600, 300);
        dialog.setContentView(R.layout.dialog_detail_product_sale);
        final EditText quantityText = (EditText) dialog.findViewById(R.id.quantityProductDetail);

        final Button btnOk = dialog.findViewById(R.id.dialogOk);
        final Button btnCancel = dialog.findViewById(R.id.dialogCancel);
        final Button btnPlus = dialog.findViewById(R.id.btnplus);
        final Button btnLess = dialog.findViewById(R.id.btnless);
        final TextView tvCode = dialog.findViewById(R.id.dialogCode);
        final TextView tvDescription = dialog.findViewById(R.id.dialogDescription);
        final TextView tvCost = dialog.findViewById(R.id.dialogCost);

        final TextView tvNameProduct, tvCodeProduct, tvPriceProduct;

        tvCode.setText(codeP);
        tvDescription.setText(descriptionP);
        tvCost.setText(costP.toString());
        quantityText.setText(quantityP.toString());
        quantity = quantityP;

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaz.resultQuantity(Integer.parseInt(quantityText.getText().toString()), tvCode.getText().toString());
                dialog.dismiss();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity++;
                quantityText.setText(String.valueOf(quantity));
            }
        });
        btnLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity > 0) {
                    quantity = quantity - 1;
                    quantityText.setText(String.valueOf(quantity));
                }
                if (quantity == 0) {
                    quantityText.setText(String.valueOf(1));
                }
            }
        });

        dialog.show();
    }
}
