package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.administrador.pvsegalmex.entity.ReceiptOfMerchandiseDetailEntity;
import com.example.administrador.pvsegalmex.entity.ReceiptOfMerchandiseEntity;
import com.example.administrador.pvsegalmex.pojo.ReceiptMerchandiseProductPojo;
import com.example.administrador.pvsegalmex.pojo.ReceiptProductPojo;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface ReceiptOfMerchandiseDetailDao {

    @Insert
    List<Long> insertReceiptOfMerchandiseDefault(ArrayList<ReceiptOfMerchandiseDetailEntity> list);

    @Insert
    Long insertReceiptOfMerchandiseDetail(ReceiptOfMerchandiseDetailEntity receiptOfMerchandiseDetail);

    @Update
    int updateReceiptOfMerchandiseDetail(ReceiptOfMerchandiseDetailEntity receiptOfMerchandiseDetail);

    @Query("SELECT rmd.Id idReceiptDetail, rmd.Total totalReceiptDetail, rmd.ReciboMercancia receiptOfMerchandiseReceiptDetail, rmd.Producto productReceiptDetail, rmd.Partida departureReceiptDetail, rmd.Cantidad quantityReceiptDetail, rmd.Precio priceReceiptDetail, rmd.Subtotal subtotalReceiptDetail, rmd.Factor factorReceiptDetail, rmd.Estatus statusReceiptDetail, p.Id idProducto, p.Descripcion description, p.Costo cost, p.Factor factor, p.Estatus status, p.Diconsa diconsa, p.Imagen image, p.UnidadMedidaCompra unitMeasurePurchase, p.UnidadMedida measuereUnit, p.Servicio service, p.PuntoDeReorden reorderPoint, p.Minimo minimumn, p.Maximo maximmn, p.Granel granel, p.FechaUC dateUC, p.CostoUC costUC, p.CodigoAlterno alternateCode, p.Codigo code, p.Categoria idcategory FROM ReciboMercanciaDetalle rmd INNER JOIN Productos p ON p.Id = rmd.Producto where p.Id=:idProduct")
    Flowable<List<ReceiptProductPojo>> getFilterReceiptOfMerchandiseDetailPojo(Integer idProduct);

    @Query("SELECT * FROM ReciboMercanciaDetalle rmd WHERE rmd.Estatus>-1")
    Flowable<List<ReceiptOfMerchandiseDetailEntity>> getFilterReceiptOfMerchandiseDetail();

    @Query("SELECT * FROM ReciboMercanciaDetalle r INNER JOIN Bitacora b ON b.Tabla='ReciboMercanciaDetalle' WHERE r.Fecha<=b.Fecha")
    Flowable<List<ReceiptOfMerchandiseDetailEntity>> getRegisterReceiptOfMerchandiseDetailSync();
}
