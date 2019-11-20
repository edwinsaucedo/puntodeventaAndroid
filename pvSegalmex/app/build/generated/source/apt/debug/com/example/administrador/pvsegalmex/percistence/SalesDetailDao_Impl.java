package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.RxRoom;
import android.database.Cursor;
import com.example.administrador.pvsegalmex.entity.SalesDetailEntity;
import com.example.administrador.pvsegalmex.pojo.SalesDetailProductPojo;
import io.reactivex.Flowable;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings("unchecked")
public class SalesDetailDao_Impl implements SalesDetailDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfSalesDetailEntity;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfSalesDetailEntity;

  public SalesDetailDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSalesDetailEntity = new EntityInsertionAdapter<SalesDetailEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `VentaDetalle`(`Id`,`Venta`,`Producto`,`Cantidad`,`PrecioUnitario`,`DescuentoPorcentaje`,`DescuentoMontoUnitario`,`Subtotal`,`Impuestos`,`Total`,`Estatus`,`Fecha`,`UUID`,`UUIDSale`,`UUIDProducto`,`Porcentaje_Utilidad`,`Monto_Utilidad`,`Costo_Producto`,`Monto_Unitario_Utilidad`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SalesDetailEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getSale() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getSale());
        }
        if (value.getProduct() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getProduct());
        }
        if (value.getQuantity() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindDouble(4, value.getQuantity());
        }
        if (value.getUnitPrice() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindDouble(5, value.getUnitPrice());
        }
        if (value.getPercentageDiscount() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindDouble(6, value.getPercentageDiscount());
        }
        if (value.getUnitAmountDiscount() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindDouble(7, value.getUnitAmountDiscount());
        }
        if (value.getSubtotal() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindDouble(8, value.getSubtotal());
        }
        if (value.getTaxes() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindDouble(9, value.getTaxes());
        }
        if (value.getTotal() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindDouble(10, value.getTotal());
        }
        if (value.getStatus() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, value.getStatus());
        }
        if (value.getDate() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getDate());
        }
        if (value.getUuid() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getUuid());
        }
        if (value.getUuidSale() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getUuidSale());
        }
        if (value.getUuidProduct() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getUuidProduct());
        }
        if (value.getPercentage() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindDouble(16, value.getPercentage());
        }
        if (value.getUtilityAmount() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindDouble(17, value.getUtilityAmount());
        }
        if (value.getProductCost() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindDouble(18, value.getProductCost());
        }
        if (value.getUtilityUnitAmount() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindDouble(19, value.getUtilityUnitAmount());
        }
      }
    };
    this.__updateAdapterOfSalesDetailEntity = new EntityDeletionOrUpdateAdapter<SalesDetailEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `VentaDetalle` SET `Id` = ?,`Venta` = ?,`Producto` = ?,`Cantidad` = ?,`PrecioUnitario` = ?,`DescuentoPorcentaje` = ?,`DescuentoMontoUnitario` = ?,`Subtotal` = ?,`Impuestos` = ?,`Total` = ?,`Estatus` = ?,`Fecha` = ?,`UUID` = ?,`UUIDSale` = ?,`UUIDProducto` = ?,`Porcentaje_Utilidad` = ?,`Monto_Utilidad` = ?,`Costo_Producto` = ?,`Monto_Unitario_Utilidad` = ? WHERE `Id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SalesDetailEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getSale() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getSale());
        }
        if (value.getProduct() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getProduct());
        }
        if (value.getQuantity() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindDouble(4, value.getQuantity());
        }
        if (value.getUnitPrice() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindDouble(5, value.getUnitPrice());
        }
        if (value.getPercentageDiscount() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindDouble(6, value.getPercentageDiscount());
        }
        if (value.getUnitAmountDiscount() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindDouble(7, value.getUnitAmountDiscount());
        }
        if (value.getSubtotal() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindDouble(8, value.getSubtotal());
        }
        if (value.getTaxes() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindDouble(9, value.getTaxes());
        }
        if (value.getTotal() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindDouble(10, value.getTotal());
        }
        if (value.getStatus() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, value.getStatus());
        }
        if (value.getDate() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getDate());
        }
        if (value.getUuid() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getUuid());
        }
        if (value.getUuidSale() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getUuidSale());
        }
        if (value.getUuidProduct() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getUuidProduct());
        }
        if (value.getPercentage() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindDouble(16, value.getPercentage());
        }
        if (value.getUtilityAmount() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindDouble(17, value.getUtilityAmount());
        }
        if (value.getProductCost() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindDouble(18, value.getProductCost());
        }
        if (value.getUtilityUnitAmount() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindDouble(19, value.getUtilityUnitAmount());
        }
        if (value.getId() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindLong(20, value.getId());
        }
      }
    };
  }

  @Override
  public Long insertSalesDetail(SalesDetailEntity salesDetailEntity) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfSalesDetailEntity.insertAndReturnId(salesDetailEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateSalesDetail(SalesDetailEntity salesDetailEntity) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfSalesDetailEntity.handle(salesDetailEntity);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Flowable<List<SalesDetailProductPojo>> getFilterDetail(Integer idVenta) {
    final String _sql = "SELECT p.Descripcion productDescription ,p.Granel granel, p.UUID uuid,  p.Id idProduct, p.Codigo code, p.UnidadMedida saleUnit, p.Costo cost,d.Cantidad quantity, d.Id idSaleDetail, d.Subtotal subtotal, d.PrecioUnitario unitPrice,  d.Venta idSale, d.Porcentaje_Utilidad percentage, d.Monto_Unitario_Utilidad amount,d.Porcentaje_Utilidad percentage, d.Monto_Utilidad amount, d.Costo_Producto costProduct, v.Id saleId from Productos p INNER JOIN VentaDetalle d on p.Id = d.Producto INNER JOIN Venta v on d.Venta=v.Id where v.Id=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (idVenta == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, idVenta);
    }
    return RxRoom.createFlowable(__db, new String[]{"Productos","VentaDetalle","Venta"}, new Callable<List<SalesDetailProductPojo>>() {
      @Override
      public List<SalesDetailProductPojo> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfProductDescription = _cursor.getColumnIndexOrThrow("productDescription");
          final int _cursorIndexOfGranel = _cursor.getColumnIndexOrThrow("granel");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("uuid");
          final int _cursorIndexOfIdProduct = _cursor.getColumnIndexOrThrow("idProduct");
          final int _cursorIndexOfCode = _cursor.getColumnIndexOrThrow("code");
          final int _cursorIndexOfSaleUnit = _cursor.getColumnIndexOrThrow("saleUnit");
          final int _cursorIndexOfCost = _cursor.getColumnIndexOrThrow("cost");
          final int _cursorIndexOfQuantity = _cursor.getColumnIndexOrThrow("quantity");
          final int _cursorIndexOfIdSaleDetail = _cursor.getColumnIndexOrThrow("idSaleDetail");
          final int _cursorIndexOfSubtotal = _cursor.getColumnIndexOrThrow("subtotal");
          final int _cursorIndexOfUnitPrice = _cursor.getColumnIndexOrThrow("unitPrice");
          final int _cursorIndexOfIdSale = _cursor.getColumnIndexOrThrow("idSale");
          final int _cursorIndexOfPercentage = _cursor.getColumnIndexOrThrow("percentage");
          final int _cursorIndexOfAmount = _cursor.getColumnIndexOrThrow("amount");
          final int _cursorIndexOfPercentage_1 = _cursor.getColumnIndexOrThrow("percentage");
          final int _cursorIndexOfAmount_1 = _cursor.getColumnIndexOrThrow("amount");
          final int _cursorIndexOfCostProduct = _cursor.getColumnIndexOrThrow("costProduct");
          final int _cursorIndexOfSaleId = _cursor.getColumnIndexOrThrow("saleId");
          final List<SalesDetailProductPojo> _result = new ArrayList<SalesDetailProductPojo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final SalesDetailProductPojo _item;
            _item = new SalesDetailProductPojo();
            final String _tmpProductDescription;
            _tmpProductDescription = _cursor.getString(_cursorIndexOfProductDescription);
            _item.setProductDescription(_tmpProductDescription);
            final String _tmpGranel;
            _tmpGranel = _cursor.getString(_cursorIndexOfGranel);
            _item.setGranel(_tmpGranel);
            final String _tmpUuid;
            _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            _item.setUuid(_tmpUuid);
            final String _tmpIdProduct;
            _tmpIdProduct = _cursor.getString(_cursorIndexOfIdProduct);
            _item.setIdProduct(_tmpIdProduct);
            final String _tmpCode;
            _tmpCode = _cursor.getString(_cursorIndexOfCode);
            _item.setCode(_tmpCode);
            final String _tmpSaleUnit;
            _tmpSaleUnit = _cursor.getString(_cursorIndexOfSaleUnit);
            _item.setSaleUnit(_tmpSaleUnit);
            final String _tmpCost;
            _tmpCost = _cursor.getString(_cursorIndexOfCost);
            _item.setCost(_tmpCost);
            final String _tmpQuantity;
            _tmpQuantity = _cursor.getString(_cursorIndexOfQuantity);
            _item.setQuantity(_tmpQuantity);
            final String _tmpIdSaleDetail;
            _tmpIdSaleDetail = _cursor.getString(_cursorIndexOfIdSaleDetail);
            _item.setIdSaleDetail(_tmpIdSaleDetail);
            final String _tmpSubtotal;
            _tmpSubtotal = _cursor.getString(_cursorIndexOfSubtotal);
            _item.setSubtotal(_tmpSubtotal);
            final String _tmpUnitPrice;
            _tmpUnitPrice = _cursor.getString(_cursorIndexOfUnitPrice);
            _item.setUnitPrice(_tmpUnitPrice);
            final String _tmpIdSale;
            _tmpIdSale = _cursor.getString(_cursorIndexOfIdSale);
            _item.setIdSale(_tmpIdSale);
            final String _tmpPercentage;
            _tmpPercentage = _cursor.getString(_cursorIndexOfPercentage);
            _item.setPercentage(_tmpPercentage);
            final String _tmpAmount;
            _tmpAmount = _cursor.getString(_cursorIndexOfAmount);
            _item.setAmount(_tmpAmount);
            final String _tmpPercentage_1;
            _tmpPercentage_1 = _cursor.getString(_cursorIndexOfPercentage_1);
            _item.setPercentage(_tmpPercentage_1);
            final String _tmpAmount_1;
            _tmpAmount_1 = _cursor.getString(_cursorIndexOfAmount_1);
            _item.setAmount(_tmpAmount_1);
            final String _tmpCostProduct;
            _tmpCostProduct = _cursor.getString(_cursorIndexOfCostProduct);
            _item.setCostProduct(_tmpCostProduct);
            final String _tmpSaleId;
            _tmpSaleId = _cursor.getString(_cursorIndexOfSaleId);
            _item.setSaleId(_tmpSaleId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flowable<List<SalesDetailEntity>> getRegisterSalesDetailSync() {
    final String _sql = "SELECT * FROM VentaDetalle d INNER JOIN Bitacora b ON b.Tabla='DetalleVenta' INNER JOIN Venta v ON d.Venta=v.Id WHERE d.Fecha<=b.Fecha and v.EstatusVenta = 'CERRADA'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"VentaDetalle","Bitacora","Venta"}, new Callable<List<SalesDetailEntity>>() {
      @Override
      public List<SalesDetailEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfSale = _cursor.getColumnIndexOrThrow("Venta");
          final int _cursorIndexOfProduct = _cursor.getColumnIndexOrThrow("Producto");
          final int _cursorIndexOfQuantity = _cursor.getColumnIndexOrThrow("Cantidad");
          final int _cursorIndexOfUnitPrice = _cursor.getColumnIndexOrThrow("PrecioUnitario");
          final int _cursorIndexOfPercentageDiscount = _cursor.getColumnIndexOrThrow("DescuentoPorcentaje");
          final int _cursorIndexOfUnitAmountDiscount = _cursor.getColumnIndexOrThrow("DescuentoMontoUnitario");
          final int _cursorIndexOfSubtotal = _cursor.getColumnIndexOrThrow("Subtotal");
          final int _cursorIndexOfTaxes = _cursor.getColumnIndexOrThrow("Impuestos");
          final int _cursorIndexOfTotal = _cursor.getColumnIndexOrThrow("Total");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final int _cursorIndexOfUuidSale = _cursor.getColumnIndexOrThrow("UUIDSale");
          final int _cursorIndexOfUuidProduct = _cursor.getColumnIndexOrThrow("UUIDProducto");
          final int _cursorIndexOfPercentage = _cursor.getColumnIndexOrThrow("Porcentaje_Utilidad");
          final int _cursorIndexOfUtilityAmount = _cursor.getColumnIndexOrThrow("Monto_Utilidad");
          final int _cursorIndexOfProductCost = _cursor.getColumnIndexOrThrow("Costo_Producto");
          final int _cursorIndexOfUtilityUnitAmount = _cursor.getColumnIndexOrThrow("Monto_Unitario_Utilidad");
          final int _cursorIndexOfId_1 = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfDate_1 = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfStatus_1 = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfId_2 = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfDate_2 = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfTotal_1 = _cursor.getColumnIndexOrThrow("Total");
          final int _cursorIndexOfStatus_2 = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfUuid_1 = _cursor.getColumnIndexOrThrow("UUID");
          final int _cursorIndexOfUtilityAmount_1 = _cursor.getColumnIndexOrThrow("Monto_Utilidad");
          final int _cursorIndexOfPercentage_1 = _cursor.getColumnIndexOrThrow("Porcentaje_Utilidad");
          final List<SalesDetailEntity> _result = new ArrayList<SalesDetailEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final SalesDetailEntity _item;
            _item = new SalesDetailEntity();
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final Integer _tmpSale;
            if (_cursor.isNull(_cursorIndexOfSale)) {
              _tmpSale = null;
            } else {
              _tmpSale = _cursor.getInt(_cursorIndexOfSale);
            }
            _item.setSale(_tmpSale);
            final Integer _tmpProduct;
            if (_cursor.isNull(_cursorIndexOfProduct)) {
              _tmpProduct = null;
            } else {
              _tmpProduct = _cursor.getInt(_cursorIndexOfProduct);
            }
            _item.setProduct(_tmpProduct);
            final Double _tmpQuantity;
            if (_cursor.isNull(_cursorIndexOfQuantity)) {
              _tmpQuantity = null;
            } else {
              _tmpQuantity = _cursor.getDouble(_cursorIndexOfQuantity);
            }
            _item.setQuantity(_tmpQuantity);
            final Double _tmpUnitPrice;
            if (_cursor.isNull(_cursorIndexOfUnitPrice)) {
              _tmpUnitPrice = null;
            } else {
              _tmpUnitPrice = _cursor.getDouble(_cursorIndexOfUnitPrice);
            }
            _item.setUnitPrice(_tmpUnitPrice);
            final Double _tmpPercentageDiscount;
            if (_cursor.isNull(_cursorIndexOfPercentageDiscount)) {
              _tmpPercentageDiscount = null;
            } else {
              _tmpPercentageDiscount = _cursor.getDouble(_cursorIndexOfPercentageDiscount);
            }
            _item.setPercentageDiscount(_tmpPercentageDiscount);
            final Double _tmpUnitAmountDiscount;
            if (_cursor.isNull(_cursorIndexOfUnitAmountDiscount)) {
              _tmpUnitAmountDiscount = null;
            } else {
              _tmpUnitAmountDiscount = _cursor.getDouble(_cursorIndexOfUnitAmountDiscount);
            }
            _item.setUnitAmountDiscount(_tmpUnitAmountDiscount);
            final Double _tmpSubtotal;
            if (_cursor.isNull(_cursorIndexOfSubtotal)) {
              _tmpSubtotal = null;
            } else {
              _tmpSubtotal = _cursor.getDouble(_cursorIndexOfSubtotal);
            }
            _item.setSubtotal(_tmpSubtotal);
            final Double _tmpTaxes;
            if (_cursor.isNull(_cursorIndexOfTaxes)) {
              _tmpTaxes = null;
            } else {
              _tmpTaxes = _cursor.getDouble(_cursorIndexOfTaxes);
            }
            _item.setTaxes(_tmpTaxes);
            final Double _tmpTotal;
            if (_cursor.isNull(_cursorIndexOfTotal)) {
              _tmpTotal = null;
            } else {
              _tmpTotal = _cursor.getDouble(_cursorIndexOfTotal);
            }
            _item.setTotal(_tmpTotal);
            final Integer _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            }
            _item.setStatus(_tmpStatus);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            _item.setDate(_tmpDate);
            final String _tmpUuid;
            _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            _item.setUuid(_tmpUuid);
            final String _tmpUuidSale;
            _tmpUuidSale = _cursor.getString(_cursorIndexOfUuidSale);
            _item.setUuidSale(_tmpUuidSale);
            final String _tmpUuidProduct;
            _tmpUuidProduct = _cursor.getString(_cursorIndexOfUuidProduct);
            _item.setUuidProduct(_tmpUuidProduct);
            final Double _tmpPercentage;
            if (_cursor.isNull(_cursorIndexOfPercentage)) {
              _tmpPercentage = null;
            } else {
              _tmpPercentage = _cursor.getDouble(_cursorIndexOfPercentage);
            }
            _item.setPercentage(_tmpPercentage);
            final Double _tmpUtilityAmount;
            if (_cursor.isNull(_cursorIndexOfUtilityAmount)) {
              _tmpUtilityAmount = null;
            } else {
              _tmpUtilityAmount = _cursor.getDouble(_cursorIndexOfUtilityAmount);
            }
            _item.setUtilityAmount(_tmpUtilityAmount);
            final Double _tmpProductCost;
            if (_cursor.isNull(_cursorIndexOfProductCost)) {
              _tmpProductCost = null;
            } else {
              _tmpProductCost = _cursor.getDouble(_cursorIndexOfProductCost);
            }
            _item.setProductCost(_tmpProductCost);
            final Double _tmpUtilityUnitAmount;
            if (_cursor.isNull(_cursorIndexOfUtilityUnitAmount)) {
              _tmpUtilityUnitAmount = null;
            } else {
              _tmpUtilityUnitAmount = _cursor.getDouble(_cursorIndexOfUtilityUnitAmount);
            }
            _item.setUtilityUnitAmount(_tmpUtilityUnitAmount);
            final Integer _tmpId_1;
            if (_cursor.isNull(_cursorIndexOfId_1)) {
              _tmpId_1 = null;
            } else {
              _tmpId_1 = _cursor.getInt(_cursorIndexOfId_1);
            }
            _item.setId(_tmpId_1);
            final String _tmpDate_1;
            _tmpDate_1 = _cursor.getString(_cursorIndexOfDate_1);
            _item.setDate(_tmpDate_1);
            final Integer _tmpStatus_1;
            if (_cursor.isNull(_cursorIndexOfStatus_1)) {
              _tmpStatus_1 = null;
            } else {
              _tmpStatus_1 = _cursor.getInt(_cursorIndexOfStatus_1);
            }
            _item.setStatus(_tmpStatus_1);
            final Integer _tmpId_2;
            if (_cursor.isNull(_cursorIndexOfId_2)) {
              _tmpId_2 = null;
            } else {
              _tmpId_2 = _cursor.getInt(_cursorIndexOfId_2);
            }
            _item.setId(_tmpId_2);
            final String _tmpDate_2;
            _tmpDate_2 = _cursor.getString(_cursorIndexOfDate_2);
            _item.setDate(_tmpDate_2);
            final Double _tmpTotal_1;
            if (_cursor.isNull(_cursorIndexOfTotal_1)) {
              _tmpTotal_1 = null;
            } else {
              _tmpTotal_1 = _cursor.getDouble(_cursorIndexOfTotal_1);
            }
            _item.setTotal(_tmpTotal_1);
            final Integer _tmpStatus_2;
            if (_cursor.isNull(_cursorIndexOfStatus_2)) {
              _tmpStatus_2 = null;
            } else {
              _tmpStatus_2 = _cursor.getInt(_cursorIndexOfStatus_2);
            }
            _item.setStatus(_tmpStatus_2);
            final String _tmpUuid_1;
            _tmpUuid_1 = _cursor.getString(_cursorIndexOfUuid_1);
            _item.setUuid(_tmpUuid_1);
            final Double _tmpUtilityAmount_1;
            if (_cursor.isNull(_cursorIndexOfUtilityAmount_1)) {
              _tmpUtilityAmount_1 = null;
            } else {
              _tmpUtilityAmount_1 = _cursor.getDouble(_cursorIndexOfUtilityAmount_1);
            }
            _item.setUtilityAmount(_tmpUtilityAmount_1);
            final Double _tmpPercentage_1;
            if (_cursor.isNull(_cursorIndexOfPercentage_1)) {
              _tmpPercentage_1 = null;
            } else {
              _tmpPercentage_1 = _cursor.getDouble(_cursorIndexOfPercentage_1);
            }
            _item.setPercentage(_tmpPercentage_1);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flowable<List<SalesDetailEntity>> getSalesDetail(Integer id) {
    final String _sql = "SELECT * FROM VentaDetalle d WHERE d.Venta=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, id);
    }
    return RxRoom.createFlowable(__db, new String[]{"VentaDetalle"}, new Callable<List<SalesDetailEntity>>() {
      @Override
      public List<SalesDetailEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfSale = _cursor.getColumnIndexOrThrow("Venta");
          final int _cursorIndexOfProduct = _cursor.getColumnIndexOrThrow("Producto");
          final int _cursorIndexOfQuantity = _cursor.getColumnIndexOrThrow("Cantidad");
          final int _cursorIndexOfUnitPrice = _cursor.getColumnIndexOrThrow("PrecioUnitario");
          final int _cursorIndexOfPercentageDiscount = _cursor.getColumnIndexOrThrow("DescuentoPorcentaje");
          final int _cursorIndexOfUnitAmountDiscount = _cursor.getColumnIndexOrThrow("DescuentoMontoUnitario");
          final int _cursorIndexOfSubtotal = _cursor.getColumnIndexOrThrow("Subtotal");
          final int _cursorIndexOfTaxes = _cursor.getColumnIndexOrThrow("Impuestos");
          final int _cursorIndexOfTotal = _cursor.getColumnIndexOrThrow("Total");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final int _cursorIndexOfUuidSale = _cursor.getColumnIndexOrThrow("UUIDSale");
          final int _cursorIndexOfUuidProduct = _cursor.getColumnIndexOrThrow("UUIDProducto");
          final int _cursorIndexOfPercentage = _cursor.getColumnIndexOrThrow("Porcentaje_Utilidad");
          final int _cursorIndexOfUtilityAmount = _cursor.getColumnIndexOrThrow("Monto_Utilidad");
          final int _cursorIndexOfProductCost = _cursor.getColumnIndexOrThrow("Costo_Producto");
          final int _cursorIndexOfUtilityUnitAmount = _cursor.getColumnIndexOrThrow("Monto_Unitario_Utilidad");
          final List<SalesDetailEntity> _result = new ArrayList<SalesDetailEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final SalesDetailEntity _item;
            _item = new SalesDetailEntity();
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final Integer _tmpSale;
            if (_cursor.isNull(_cursorIndexOfSale)) {
              _tmpSale = null;
            } else {
              _tmpSale = _cursor.getInt(_cursorIndexOfSale);
            }
            _item.setSale(_tmpSale);
            final Integer _tmpProduct;
            if (_cursor.isNull(_cursorIndexOfProduct)) {
              _tmpProduct = null;
            } else {
              _tmpProduct = _cursor.getInt(_cursorIndexOfProduct);
            }
            _item.setProduct(_tmpProduct);
            final Double _tmpQuantity;
            if (_cursor.isNull(_cursorIndexOfQuantity)) {
              _tmpQuantity = null;
            } else {
              _tmpQuantity = _cursor.getDouble(_cursorIndexOfQuantity);
            }
            _item.setQuantity(_tmpQuantity);
            final Double _tmpUnitPrice;
            if (_cursor.isNull(_cursorIndexOfUnitPrice)) {
              _tmpUnitPrice = null;
            } else {
              _tmpUnitPrice = _cursor.getDouble(_cursorIndexOfUnitPrice);
            }
            _item.setUnitPrice(_tmpUnitPrice);
            final Double _tmpPercentageDiscount;
            if (_cursor.isNull(_cursorIndexOfPercentageDiscount)) {
              _tmpPercentageDiscount = null;
            } else {
              _tmpPercentageDiscount = _cursor.getDouble(_cursorIndexOfPercentageDiscount);
            }
            _item.setPercentageDiscount(_tmpPercentageDiscount);
            final Double _tmpUnitAmountDiscount;
            if (_cursor.isNull(_cursorIndexOfUnitAmountDiscount)) {
              _tmpUnitAmountDiscount = null;
            } else {
              _tmpUnitAmountDiscount = _cursor.getDouble(_cursorIndexOfUnitAmountDiscount);
            }
            _item.setUnitAmountDiscount(_tmpUnitAmountDiscount);
            final Double _tmpSubtotal;
            if (_cursor.isNull(_cursorIndexOfSubtotal)) {
              _tmpSubtotal = null;
            } else {
              _tmpSubtotal = _cursor.getDouble(_cursorIndexOfSubtotal);
            }
            _item.setSubtotal(_tmpSubtotal);
            final Double _tmpTaxes;
            if (_cursor.isNull(_cursorIndexOfTaxes)) {
              _tmpTaxes = null;
            } else {
              _tmpTaxes = _cursor.getDouble(_cursorIndexOfTaxes);
            }
            _item.setTaxes(_tmpTaxes);
            final Double _tmpTotal;
            if (_cursor.isNull(_cursorIndexOfTotal)) {
              _tmpTotal = null;
            } else {
              _tmpTotal = _cursor.getDouble(_cursorIndexOfTotal);
            }
            _item.setTotal(_tmpTotal);
            final Integer _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            }
            _item.setStatus(_tmpStatus);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            _item.setDate(_tmpDate);
            final String _tmpUuid;
            _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            _item.setUuid(_tmpUuid);
            final String _tmpUuidSale;
            _tmpUuidSale = _cursor.getString(_cursorIndexOfUuidSale);
            _item.setUuidSale(_tmpUuidSale);
            final String _tmpUuidProduct;
            _tmpUuidProduct = _cursor.getString(_cursorIndexOfUuidProduct);
            _item.setUuidProduct(_tmpUuidProduct);
            final Double _tmpPercentage;
            if (_cursor.isNull(_cursorIndexOfPercentage)) {
              _tmpPercentage = null;
            } else {
              _tmpPercentage = _cursor.getDouble(_cursorIndexOfPercentage);
            }
            _item.setPercentage(_tmpPercentage);
            final Double _tmpUtilityAmount;
            if (_cursor.isNull(_cursorIndexOfUtilityAmount)) {
              _tmpUtilityAmount = null;
            } else {
              _tmpUtilityAmount = _cursor.getDouble(_cursorIndexOfUtilityAmount);
            }
            _item.setUtilityAmount(_tmpUtilityAmount);
            final Double _tmpProductCost;
            if (_cursor.isNull(_cursorIndexOfProductCost)) {
              _tmpProductCost = null;
            } else {
              _tmpProductCost = _cursor.getDouble(_cursorIndexOfProductCost);
            }
            _item.setProductCost(_tmpProductCost);
            final Double _tmpUtilityUnitAmount;
            if (_cursor.isNull(_cursorIndexOfUtilityUnitAmount)) {
              _tmpUtilityUnitAmount = null;
            } else {
              _tmpUtilityUnitAmount = _cursor.getDouble(_cursorIndexOfUtilityUnitAmount);
            }
            _item.setUtilityUnitAmount(_tmpUtilityUnitAmount);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
