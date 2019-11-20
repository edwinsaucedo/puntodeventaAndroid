package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.administrador.pvsegalmex.entity.KardexDetailEntity;
import com.example.administrador.pvsegalmex.pojo.KardexProductPojo;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface KardexDetailDao {

    @Insert
    Long insertKardexDetail(KardexDetailEntity kardexDetail);

    @Update
    int updateKardexDetail(KardexDetailEntity kardexDetail);

    @Query("SELECT * FROM KardexDetalle kd where kd.Estatus>-1")
    Flowable<List<KardexDetailEntity>> getFilterKardexDetail();

    @Query("SELECT k.Id idKardex, k.Estatus statusKardex, k.Producto productoKardex, k.Factor factorKardex, k.Cantidad quantityKardex, k.Costo costKardex, k.Kardex kardex, k.Valor valueKardex, p.Descripcion description, p.Imagen image,p.Id idProduct,p.Estatus status,p.Categoria idCategory, p.Codigo code, p.CodigoAlterno alternateCode, p.Costo cost,p.CostoUC costUC, p.Diconsa diconsa, p.Factor factor, p.FechaUC dateUC,p.Granel granel, p.Maximo maximmn, p.Minimo minimumn,p.PuntoDeReorden reorderPoint,p.Servicio service, p.UnidadMedida measuereUnit, p.UnidadMedidaCompra unitMeasurePurchase FROM KardexDetalle k INNER JOIN Productos p ON p.Id = k.Producto where p.Id=:idProduct")
    Flowable<List<KardexProductPojo>> getKardexProductFilter(Integer idProduct);

    @Query("SELECT * FROM KardexDetalle k INNER JOIN Bitacora b ON b.Tabla='KardexDetalle' WHERE k.Fecha<=b.Fecha")
    Flowable<List<KardexDetailEntity>> getRegisterKardexDetailSync();
}

