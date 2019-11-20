package com.example.administrador.pvsegalmex.sync;

import android.content.ContentResolver;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.entity.BitacoraEntity;
import com.example.administrador.pvsegalmex.entity.ProductEntity;
import com.example.administrador.pvsegalmex.viewEntity.BitacoraViewEntity;
import com.example.administrador.pvsegalmex.viewEntityFactory.BitacoraViewEntityFactory;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static com.example.administrador.pvsegalmex.pojo.ConstantesRestApi.VERSION_ADMINISTRADOR;


public class Synchronization {

    CompositeDisposable compositeDisposable;
    BitacoraViewEntityFactory bitacoraViewEntityFactory;
    BitacoraViewEntity bitacoraViewEntity;
    ArrayList<BitacoraEntity> bitacoraList;
    private static final String LOGTAG = "PVApi-Sync";
    private static ContentResolver resolvedor;
    private static Context context;
    private static boolean response = false;

    public Synchronization(Context context) {
        this.resolvedor = context.getContentResolver();
        this.context = context;
    }

    public synchronized static boolean waitingServerResponse() {
        return response;
    }

    public synchronized static void setWaitingServerResponse(boolean response) {
        Synchronization.response = response;
    }

    public synchronized boolean sync() {
        Log.i("synchronitation", "SYNCHRONITATION");

        if (waitingServerResponse()) {
            return true;
        }

        if (VERSION_ADMINISTRADOR) {
            sendUpdateServer();
        } else {
            getUpdateServer();
        }
        return true;
    }


   /* private void searchBitacora(){
        compositeDisposable.add(bitacoraViewEntity.getFilterBitacora()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<BitacoraEntity>>) bitacoraListSearch -> {

                            bitacoraList = (ArrayList<BitacoraEntity>) bitacoraListSearch;
                            if (bitacoraList.isEmpty()) {
                                //Toast.makeText(getApplicationContext(), "No hay productos", Toast.LENGTH_SHORT).show();
                            }

                        }, throwable -> {
                        }
                ));
    }*/

    private static void sendUpdateServer() {
        ArrayList<BitacoraEntity> bitacoraEntities = new ArrayList<>();




        for (BitacoraEntity bitacoraEntity : bitacoraEntities) {

        }
    }

    private static void getUpdateServer() {
    }

    public static void doUpdateServer(JSONArray jsonArray) {
        Log.i("sync", "getUpdates");

        try {
            ArrayList<Integer> idUpdate = new ArrayList<Integer>();
            ArrayList<Integer> idOld = new ArrayList<Integer>();
            ArrayList<ProductEntity> newRegistry = new ArrayList<>();
            ArrayList<ProductEntity> oldRegistry = new ArrayList<>();

            for (ProductEntity i : oldRegistry) idUpdate.add(i.getId());

            JSONObject object = null;
            for (int i = 0; i < jsonArray.length(); i++) {
                object = jsonArray.getJSONObject(i);
                newRegistry.add(new ProductEntity(/*
                        object.getInt("Id"),
                        object.getString("Codigo"),
                        object.getString("CodigoAlterno"),
                        object.getString("Descripcion"),
                        object.getDouble("Maximo"),
                        object.getDouble("Minimo"),
                        object.getDouble("PuntoDeReorden"),
                        object.getInt("UnidadMedida"),
                        object.getInt("UnidadMedidaCompra"),
                        object.getDouble("Factor"),
                        object.getInt("Servicio"),
                        object.getInt("Diconsa"),
                        object.getInt("Categoria"),
                        object.getInt("Granel"),
                        object.getInt("Estatus"),
                        object.getString("RowId"),
                        object.getDouble("Costo"),
                        object.getDouble("CostoUC"),
                        object.getString("FechaUC"),
                        object.getString("Imagen"),
                        object.getString("UltimaActualizacion"),
                        object.getString("UUID")*/));
            }

            for (ProductEntity productEntity : newRegistry) {
                try {

                } catch (Exception e) {
                    Log.i("sincronizacion",
                            "Probablemente el registro ya existía en la BD." + "" +
                                    " Esto se podría controlar mejor con una Bitácora.");
                }
            }

            for (ProductEntity productEntity : oldRegistry) {

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
