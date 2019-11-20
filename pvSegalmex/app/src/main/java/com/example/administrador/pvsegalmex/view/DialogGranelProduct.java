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

public class DialogGranelProduct {
    public DialogGranelProduct(Context context) {

    }

    public interface setQuantityGranel {
        void resultQuantity(Double quant, String code);
    }

    public Double quantity = 0.0;
    public String codeP;
    public Double costP = 0.0;
    private setQuantityGranel interfaz;
    private Context context;

    public DialogGranelProduct(Context context, setQuantityGranel actividad, String codeP, String descriptionP, Double costP, Double quantityP) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        interfaz = actividad;

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setLayout(600, 300);
        dialog.setContentView(R.layout.dialog_granel);
        final EditText quantityText = (EditText) dialog.findViewById(R.id.quantityProductDetailGranel);

        final Button btnOk = dialog.findViewById(R.id.dialogOkGranel);
        final Button btnCancel = dialog.findViewById(R.id.dialogCancelGranel);
        final TextView tvCode = dialog.findViewById(R.id.dialogCodeGranel);
        final TextView tvDescription = dialog.findViewById(R.id.dialogDescriptionGranel);
        final TextView tvCost = dialog.findViewById(R.id.dialogCostGranel);
        final TextView tvUnitMeasure = dialog.findViewById(R.id.tvUnitMeasure);

        tvCode.setText(codeP);
        tvDescription.setText(descriptionP);
        tvCost.setText(costP.toString());

        quantity = quantityP;

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaz.resultQuantity(Double.parseDouble(quantityText.getText().toString()), tvCode.getText().toString());
                dialog.dismiss();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
