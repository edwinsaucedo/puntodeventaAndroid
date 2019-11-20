package com.example.administrador.pvsegalmex.percistence;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.administrador.pvsegalmex.entity.SalesDetailEntity;
import com.example.administrador.pvsegalmex.entity.SalesEntity;
import com.example.administrador.pvsegalmex.pojo.SalesDetailProductPojo;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface SalesDetailDao {

    @Insert
    Long insertSalesDetail(SalesDetailEntity salesDetailEntity);

    @Update
    int updateSalesDetail(SalesDetailEntity salesDetailEntity);

    @Query("SELECT p.Descripcion productDescription ,p.Granel granel, p.UUID uuid,  p.Id idProduct, p.Codigo code, p.UnidadMedida saleUnit, p.Costo cost,d.Cantidad quantity, d.Id idSaleDetail, d.Subtotal subtotal, d.PrecioUnitario unitPrice,  d.Venta idSale, d.Porcentaje_Utilidad percentage, d.Monto_Unitario_Utilidad amount,d.Porcentaje_Utilidad percentage, d.Monto_Utilidad amount, d.Costo_Producto costProduct, v.Id saleId from Productos p INNER JOIN VentaDetalle d on p.Id = d.Producto INNER JOIN Venta v on d.Venta=v.Id where v.Id=:idVenta")
    Flowable<List<SalesDetailProductPojo>> getFilterDetail(Integer idVenta);

    @Query("SELECT * FROM VentaDetalle d INNER JOIN Bitacora b ON b.Tabla='DetalleVenta' INNER JOIN Venta v ON d.Venta=v.Id WHERE d.Fecha<=b.Fecha and v.EstatusVenta = 'CERRADA'")
    Flowable<List<SalesDetailEntity>> getRegisterSalesDetailSync();

    @Query("SELECT * FROM VentaDetalle d WHERE d.Venta=:id")
    Flowable<List<SalesDetailEntity>> getSalesDetail(Integer id);
}
