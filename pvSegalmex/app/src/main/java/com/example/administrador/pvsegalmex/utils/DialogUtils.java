package com.example.administrador.pvsegalmex.utils;

import android.app.AlertDialog;
import android.content.Context;


import com.example.administrador.pvsegalmex.R;

public class DialogUtils {

    public interface OnOkayNoEvent {
        void onYes();
        void onNo();
    }
    public static void showOkayNoDialog(String message,String title, Context context,final OnOkayNoEvent fun)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        builder.setTitle(title)
               .setMessage(message)
               .setCancelable(false)
               .setPositiveButton("Si", (dialog, which) -> {
                   if(fun!=null)fun.onYes();
               }
               )
                .setNegativeButton("No",((dialog, which) -> {
                    if(fun!=null)fun.onNo();
                }
                )
                ).setIcon(R.drawable.advertencia);
        builder.show();
    }

    public static void showOkayDialog(Context context,String title,String message,String typeMessage){

        int icon;
        icon=typeMessage.equals("success")?R.drawable.exito:R.drawable.error;
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        builder.setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton("Ok", (dialog, which) -> { })
                 .setIcon(icon);
        builder.show();
    }

}
