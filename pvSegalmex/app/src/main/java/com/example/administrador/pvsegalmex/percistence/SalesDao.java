package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.database.Cursor;

import com.example.administrador.pvsegalmex.entity.SalesEntity;
import com.example.administrador.pvsegalmex.pojo.SalesClientPojo;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface SalesDao {

    @Insert
    Long insertSales(SalesEntity sales);

    @Update
    int updateSales(SalesEntity sales);

    @Query("SELECT w.Description wayPay,v.Fecha date,v.EstatusVenta status ,v.Porcentaje_Utilidad utilityPercentage, v.Monto_Utilidad utilityAmount ,v.TipoDocumentoVta idTypeDocument , v.Total amount,v.Id idSale, c.Id idClient,(c.Nombre||' '||c.ApellidoPaterno||' '||c.ApellidoMaterno)client FROM Venta v INNER JOIN Cliente c ON v.Cliente=c.Id INNER JOIN FormaPago w ON v.FormaPago=w.Id where v.EstatusVenta = 'CERRADA' and v.Estatus>-1 and v.Fecha glob '*'||:saleDate||'*'")
    Flowable<List<SalesClientPojo>> getFilterSale(String saleDate);

    @Query("SELECT * FROM Venta v where v.EstatusVenta = 'ABIERTA' and v.Estatus>-1 ORDER BY v.Fecha DESC")
    Flowable<List<SalesEntity>> getFilterSaleIncomplete();

    @Query("SELECT * FROM Venta v WHERE v.EstatusVenta='CERRADA'")
    Flowable<List<SalesEntity>> getsSum();

    @Query("SELECT * FROM Venta v")
    Cursor selectAll();

    @Query("SELECT * FROM Venta v INNER JOIN Bitacora b ON b.Tabla='Venta' WHERE v.Fecha<=b.Fecha and v.EstatusVenta = 'CERRADA'")
    Flowable<List<SalesEntity>> getRegisterSalesSync();

    @Query("SELECT * FROM Venta v WHERE v.Id = :id")
    Cursor selectById(long id);
}
