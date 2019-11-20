package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.RxRoom;
import android.database.Cursor;
import com.example.administrador.pvsegalmex.entity.ReceiptOfMerchandiseDetailEntity;
import com.example.administrador.pvsegalmex.pojo.ReceiptProductPojo;
import io.reactivex.Flowable;
import java.lang.Boolean;
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
public class ReceiptOfMerchandiseDetailDao_Impl implements ReceiptOfMerchandiseDetailDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfReceiptOfMerchandiseDetailEntity;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfReceiptOfMerchandiseDetailEntity;

  public ReceiptOfMerchandiseDetailDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfReceiptOfMerchandiseDetailEntity = new EntityInsertionAdapter<ReceiptOfMerchandiseDetailEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `ReciboMercanciaDetalle`(`Id`,`ReciboMercancia`,`UnidadMedida`,`Producto`,`Partida`,`Cantidad`,`Precio`,`Subtotal`,`Total`,`Factor`,`Estatus`,`UUID`,`Fecha`,`UUIDReciboMercancia`,`UUIDProduct`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ReceiptOfMerchandiseDetailEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getReceiptOfMerchandise() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getReceiptOfMerchandise());
        }
        if (value.getUnitMeasure() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getUnitMeasure());
        }
        if (value.getProduct() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getProduct());
        }
        stmt.bindLong(5, value.getDeparture());
        if (value.getQuantity() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindDouble(6, value.getQuantity());
        }
        if (value.getPrice() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindDouble(7, value.getPrice());
        }
        if (value.getSubtotal() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindDouble(8, value.getSubtotal());
        }
        if (value.getTotal() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindDouble(9, value.getTotal());
        }
        if (value.getFactor() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindDouble(10, value.getFactor());
        }
        stmt.bindLong(11, value.getStatus());
        if (value.getUuid() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getUuid());
        }
        if (value.getDate() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getDate());
        }
        if (value.getUuidReceiptOfMerchandise() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getUuidReceiptOfMerchandise());
        }
        if (value.getUuidProduct() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getUuidProduct());
        }
      }
    };
    this.__updateAdapterOfReceiptOfMerchandiseDetailEntity = new EntityDeletionOrUpdateAdapter<ReceiptOfMerchandiseDetailEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `ReciboMercanciaDetalle` SET `Id` = ?,`ReciboMercancia` = ?,`UnidadMedida` = ?,`Producto` = ?,`Partida` = ?,`Cantidad` = ?,`Precio` = ?,`Subtotal` = ?,`Total` = ?,`Factor` = ?,`Estatus` = ?,`UUID` = ?,`Fecha` = ?,`UUIDReciboMercancia` = ?,`UUIDProduct` = ? WHERE `Id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ReceiptOfMerchandiseDetailEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getReceiptOfMerchandise() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getReceiptOfMerchandise());
        }
        if (value.getUnitMeasure() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getUnitMeasure());
        }
        if (value.getProduct() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getProduct());
        }
        stmt.bindLong(5, value.getDeparture());
        if (value.getQuantity() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindDouble(6, value.getQuantity());
        }
        if (value.getPrice() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindDouble(7, value.getPrice());
        }
        if (value.getSubtotal() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindDouble(8, value.getSubtotal());
        }
        if (value.getTotal() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindDouble(9, value.getTotal());
        }
        if (value.getFactor() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindDouble(10, value.getFactor());
        }
        stmt.bindLong(11, value.getStatus());
        if (value.getUuid() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getUuid());
        }
        if (value.getDate() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getDate());
        }
        if (value.getUuidReceiptOfMerchandise() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getUuidReceiptOfMerchandise());
        }
        if (value.getUuidProduct() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getUuidProduct());
        }
        if (value.getId() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindLong(16, value.getId());
        }
      }
    };
  }

  @Override
  public List<Long> insertReceiptOfMerchandiseDefault(ArrayList<ReceiptOfMerchandiseDetailEntity> list) {
    __db.beginTransaction();
    try {
      List<Long> _result = __insertionAdapterOfReceiptOfMerchandiseDetailEntity.insertAndReturnIdsList(list);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Long insertReceiptOfMerchandiseDetail(ReceiptOfMerchandiseDetailEntity receiptOfMerchandiseDetail) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfReceiptOfMerchandiseDetailEntity.insertAndReturnId(receiptOfMerchandiseDetail);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateReceiptOfMerchandiseDetail(ReceiptOfMerchandiseDetailEntity receiptOfMerchandiseDetail) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfReceiptOfMerchandiseDetailEntity.handle(receiptOfMerchandiseDetail);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Flowable<List<ReceiptProductPojo>> getFilterReceiptOfMerchandiseDetailPojo(Integer idProduct) {
    final String _sql = "SELECT rmd.Id idReceiptDetail, rmd.Total totalReceiptDetail, rmd.ReciboMercancia receiptOfMerchandiseReceiptDetail, rmd.Producto productReceiptDetail, rmd.Partida departureReceiptDetail, rmd.Cantidad quantityReceiptDetail, rmd.Precio priceReceiptDetail, rmd.Subtotal subtotalReceiptDetail, rmd.Factor factorReceiptDetail, rmd.Estatus statusReceiptDetail, p.Id idProducto, p.Descripcion description, p.Costo cost, p.Factor factor, p.Estatus status, p.Diconsa diconsa, p.Imagen image, p.UnidadMedidaCompra unitMeasurePurchase, p.UnidadMedida measuereUnit, p.Servicio service, p.PuntoDeReorden reorderPoint, p.Minimo minimumn, p.Maximo maximmn, p.Granel granel, p.FechaUC dateUC, p.CostoUC costUC, p.CodigoAlterno alternateCode, p.Codigo code, p.Categoria idcategory FROM ReciboMercanciaDetalle rmd INNER JOIN Productos p ON p.Id = rmd.Producto where p.Id=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (idProduct == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, idProduct);
    }
    return RxRoom.createFlowable(__db, new String[]{"ReciboMercanciaDetalle","Productos"}, new Callable<List<ReceiptProductPojo>>() {
      @Override
      public List<ReceiptProductPojo> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfIdReceiptDetail = _cursor.getColumnIndexOrThrow("idReceiptDetail");
          final int _cursorIndexOfTotalReceiptDetail = _cursor.getColumnIndexOrThrow("totalReceiptDetail");
          final int _cursorIndexOfReceiptOfMerchandiseReceiptDetail = _cursor.getColumnIndexOrThrow("receiptOfMerchandiseReceiptDetail");
          final int _cursorIndexOfProductReceiptDetail = _cursor.getColumnIndexOrThrow("productReceiptDetail");
          final int _cursorIndexOfDepartureReceiptDetail = _cursor.getColumnIndexOrThrow("departureReceiptDetail");
          final int _cursorIndexOfQuantityReceiptDetail = _cursor.getColumnIndexOrThrow("quantityReceiptDetail");
          final int _cursorIndexOfPriceReceiptDetail = _cursor.getColumnIndexOrThrow("priceReceiptDetail");
          final int _cursorIndexOfSubtotalReceiptDetail = _cursor.getColumnIndexOrThrow("subtotalReceiptDetail");
          final int _cursorIndexOfFactorReceiptDetail = _cursor.getColumnIndexOrThrow("factorReceiptDetail");
          final int _cursorIndexOfStatusReceiptDetail = _cursor.getColumnIndexOrThrow("statusReceiptDetail");
          final int _cursorIndexOfDescription = _cursor.getColumnIndexOrThrow("description");
          final int _cursorIndexOfCost = _cursor.getColumnIndexOrThrow("cost");
          final int _cursorIndexOfFactor = _cursor.getColumnIndexOrThrow("factor");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("status");
          final int _cursorIndexOfDiconsa = _cursor.getColumnIndexOrThrow("diconsa");
          final int _cursorIndexOfImage = _cursor.getColumnIndexOrThrow("image");
          final int _cursorIndexOfUnitMeasurePurchase = _cursor.getColumnIndexOrThrow("unitMeasurePurchase");
          final int _cursorIndexOfMeasuereUnit = _cursor.getColumnIndexOrThrow("measuereUnit");
          final int _cursorIndexOfService = _cursor.getColumnIndexOrThrow("service");
          final int _cursorIndexOfReorderPoint = _cursor.getColumnIndexOrThrow("reorderPoint");
          final int _cursorIndexOfMinimumn = _cursor.getColumnIndexOrThrow("minimumn");
          final int _cursorIndexOfMaximmn = _cursor.getColumnIndexOrThrow("maximmn");
          final int _cursorIndexOfGranel = _cursor.getColumnIndexOrThrow("granel");
          final int _cursorIndexOfDateUC = _cursor.getColumnIndexOrThrow("dateUC");
          final int _cursorIndexOfCostUC = _cursor.getColumnIndexOrThrow("costUC");
          final int _cursorIndexOfAlternateCode = _cursor.getColumnIndexOrThrow("alternateCode");
          final int _cursorIndexOfCode = _cursor.getColumnIndexOrThrow("code");
          final List<ReceiptProductPojo> _result = new ArrayList<ReceiptProductPojo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ReceiptProductPojo _item;
            _item = new ReceiptProductPojo();
            final Integer _tmpIdReceiptDetail;
            if (_cursor.isNull(_cursorIndexOfIdReceiptDetail)) {
              _tmpIdReceiptDetail = null;
            } else {
              _tmpIdReceiptDetail = _cursor.getInt(_cursorIndexOfIdReceiptDetail);
            }
            _item.setIdReceiptDetail(_tmpIdReceiptDetail);
            final Double _tmpTotalReceiptDetail;
            if (_cursor.isNull(_cursorIndexOfTotalReceiptDetail)) {
              _tmpTotalReceiptDetail = null;
            } else {
              _tmpTotalReceiptDetail = _cursor.getDouble(_cursorIndexOfTotalReceiptDetail);
            }
            _item.setTotalReceiptDetail(_tmpTotalReceiptDetail);
            final Integer _tmpReceiptOfMerchandiseReceiptDetail;
            if (_cursor.isNull(_cursorIndexOfReceiptOfMerchandiseReceiptDetail)) {
              _tmpReceiptOfMerchandiseReceiptDetail = null;
            } else {
              _tmpReceiptOfMerchandiseReceiptDetail = _cursor.getInt(_cursorIndexOfReceiptOfMerchandiseReceiptDetail);
            }
            _item.setReceiptOfMerchandiseReceiptDetail(_tmpReceiptOfMerchandiseReceiptDetail);
            final Integer _tmpProductReceiptDetail;
            if (_cursor.isNull(_cursorIndexOfProductReceiptDetail)) {
              _tmpProductReceiptDetail = null;
            } else {
              _tmpProductReceiptDetail = _cursor.getInt(_cursorIndexOfProductReceiptDetail);
            }
            _item.setProductReceiptDetail(_tmpProductReceiptDetail);
            final int _tmpDepartureReceiptDetail;
            _tmpDepartureReceiptDetail = _cursor.getInt(_cursorIndexOfDepartureReceiptDetail);
            _item.setDepartureReceiptDetail(_tmpDepartureReceiptDetail);
            final Double _tmpQuantityReceiptDetail;
            if (_cursor.isNull(_cursorIndexOfQuantityReceiptDetail)) {
              _tmpQuantityReceiptDetail = null;
            } else {
              _tmpQuantityReceiptDetail = _cursor.getDouble(_cursorIndexOfQuantityReceiptDetail);
            }
            _item.setQuantityReceiptDetail(_tmpQuantityReceiptDetail);
            final Double _tmpPriceReceiptDetail;
            if (_cursor.isNull(_cursorIndexOfPriceReceiptDetail)) {
              _tmpPriceReceiptDetail = null;
            } else {
              _tmpPriceReceiptDetail = _cursor.getDouble(_cursorIndexOfPriceReceiptDetail);
            }
            _item.setPriceReceiptDetail(_tmpPriceReceiptDetail);
            final Double _tmpSubtotalReceiptDetail;
            if (_cursor.isNull(_cursorIndexOfSubtotalReceiptDetail)) {
              _tmpSubtotalReceiptDetail = null;
            } else {
              _tmpSubtotalReceiptDetail = _cursor.getDouble(_cursorIndexOfSubtotalReceiptDetail);
            }
            _item.setSubtotalReceiptDetail(_tmpSubtotalReceiptDetail);
            final Double _tmpFactorReceiptDetail;
            if (_cursor.isNull(_cursorIndexOfFactorReceiptDetail)) {
              _tmpFactorReceiptDetail = null;
            } else {
              _tmpFactorReceiptDetail = _cursor.getDouble(_cursorIndexOfFactorReceiptDetail);
            }
            _item.setFactorReceiptDetail(_tmpFactorReceiptDetail);
            final int _tmpStatusReceiptDetail;
            _tmpStatusReceiptDetail = _cursor.getInt(_cursorIndexOfStatusReceiptDetail);
            _item.setStatusReceiptDetail(_tmpStatusReceiptDetail);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            _item.setDescription(_tmpDescription);
            final Double _tmpCost;
            if (_cursor.isNull(_cursorIndexOfCost)) {
              _tmpCost = null;
            } else {
              _tmpCost = _cursor.getDouble(_cursorIndexOfCost);
            }
            _item.setCost(_tmpCost);
            final Double _tmpFactor;
            if (_cursor.isNull(_cursorIndexOfFactor)) {
              _tmpFactor = null;
            } else {
              _tmpFactor = _cursor.getDouble(_cursorIndexOfFactor);
            }
            _item.setFactor(_tmpFactor);
            final Integer _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            }
            _item.setStatus(_tmpStatus);
            final Boolean _tmpDiconsa;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfDiconsa)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfDiconsa);
            }
            _tmpDiconsa = _tmp == null ? null : _tmp != 0;
            _item.setDiconsa(_tmpDiconsa);
            final String _tmpImage;
            _tmpImage = _cursor.getString(_cursorIndexOfImage);
            _item.setImage(_tmpImage);
            final Integer _tmpUnitMeasurePurchase;
            if (_cursor.isNull(_cursorIndexOfUnitMeasurePurchase)) {
              _tmpUnitMeasurePurchase = null;
            } else {
              _tmpUnitMeasurePurchase = _cursor.getInt(_cursorIndexOfUnitMeasurePurchase);
            }
            _item.setUnitMeasurePurchase(_tmpUnitMeasurePurchase);
            final Integer _tmpMeasuereUnit;
            if (_cursor.isNull(_cursorIndexOfMeasuereUnit)) {
              _tmpMeasuereUnit = null;
            } else {
              _tmpMeasuereUnit = _cursor.getInt(_cursorIndexOfMeasuereUnit);
            }
            _item.setMeasuereUnit(_tmpMeasuereUnit);
            final Boolean _tmpService;
            final Integer _tmp_1;
            if (_cursor.isNull(_cursorIndexOfService)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getInt(_cursorIndexOfService);
            }
            _tmpService = _tmp_1 == null ? null : _tmp_1 != 0;
            _item.setService(_tmpService);
            final Double _tmpReorderPoint;
            if (_cursor.isNull(_cursorIndexOfReorderPoint)) {
              _tmpReorderPoint = null;
            } else {
              _tmpReorderPoint = _cursor.getDouble(_cursorIndexOfReorderPoint);
            }
            _item.setReorderPoint(_tmpReorderPoint);
            final Double _tmpMinimumn;
            if (_cursor.isNull(_cursorIndexOfMinimumn)) {
              _tmpMinimumn = null;
            } else {
              _tmpMinimumn = _cursor.getDouble(_cursorIndexOfMinimumn);
            }
            _item.setMinimumn(_tmpMinimumn);
            final Double _tmpMaximmn;
            if (_cursor.isNull(_cursorIndexOfMaximmn)) {
              _tmpMaximmn = null;
            } else {
              _tmpMaximmn = _cursor.getDouble(_cursorIndexOfMaximmn);
            }
            _item.setMaximmn(_tmpMaximmn);
            final Boolean _tmpGranel;
            final Integer _tmp_2;
            if (_cursor.isNull(_cursorIndexOfGranel)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getInt(_cursorIndexOfGranel);
            }
            _tmpGranel = _tmp_2 == null ? null : _tmp_2 != 0;
            _item.setGranel(_tmpGranel);
            final String _tmpDateUC;
            _tmpDateUC = _cursor.getString(_cursorIndexOfDateUC);
            _item.setDateUC(_tmpDateUC);
            final Double _tmpCostUC;
            if (_cursor.isNull(_cursorIndexOfCostUC)) {
              _tmpCostUC = null;
            } else {
              _tmpCostUC = _cursor.getDouble(_cursorIndexOfCostUC);
            }
            _item.setCostUC(_tmpCostUC);
            final String _tmpAlternateCode;
            _tmpAlternateCode = _cursor.getString(_cursorIndexOfAlternateCode);
            _item.setAlternateCode(_tmpAlternateCode);
            final String _tmpCode;
            _tmpCode = _cursor.getString(_cursorIndexOfCode);
            _item.setCode(_tmpCode);
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
  public Flowable<List<ReceiptOfMerchandiseDetailEntity>> getFilterReceiptOfMerchandiseDetail() {
    final String _sql = "SELECT * FROM ReciboMercanciaDetalle rmd WHERE rmd.Estatus>-1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"ReciboMercanciaDetalle"}, new Callable<List<ReceiptOfMerchandiseDetailEntity>>() {
      @Override
      public List<ReceiptOfMerchandiseDetailEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfReceiptOfMerchandise = _cursor.getColumnIndexOrThrow("ReciboMercancia");
          final int _cursorIndexOfUnitMeasure = _cursor.getColumnIndexOrThrow("UnidadMedida");
          final int _cursorIndexOfProduct = _cursor.getColumnIndexOrThrow("Producto");
          final int _cursorIndexOfDeparture = _cursor.getColumnIndexOrThrow("Partida");
          final int _cursorIndexOfQuantity = _cursor.getColumnIndexOrThrow("Cantidad");
          final int _cursorIndexOfPrice = _cursor.getColumnIndexOrThrow("Precio");
          final int _cursorIndexOfSubtotal = _cursor.getColumnIndexOrThrow("Subtotal");
          final int _cursorIndexOfTotal = _cursor.getColumnIndexOrThrow("Total");
          final int _cursorIndexOfFactor = _cursor.getColumnIndexOrThrow("Factor");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfUuidReceiptOfMerchandise = _cursor.getColumnIndexOrThrow("UUIDReciboMercancia");
          final int _cursorIndexOfUuidProduct = _cursor.getColumnIndexOrThrow("UUIDProduct");
          final List<ReceiptOfMerchandiseDetailEntity> _result = new ArrayList<ReceiptOfMerchandiseDetailEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ReceiptOfMerchandiseDetailEntity _item;
            _item = new ReceiptOfMerchandiseDetailEntity();
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final Integer _tmpReceiptOfMerchandise;
            if (_cursor.isNull(_cursorIndexOfReceiptOfMerchandise)) {
              _tmpReceiptOfMerchandise = null;
            } else {
              _tmpReceiptOfMerchandise = _cursor.getInt(_cursorIndexOfReceiptOfMerchandise);
            }
            _item.setReceiptOfMerchandise(_tmpReceiptOfMerchandise);
            final Integer _tmpUnitMeasure;
            if (_cursor.isNull(_cursorIndexOfUnitMeasure)) {
              _tmpUnitMeasure = null;
            } else {
              _tmpUnitMeasure = _cursor.getInt(_cursorIndexOfUnitMeasure);
            }
            _item.setUnitMeasure(_tmpUnitMeasure);
            final Integer _tmpProduct;
            if (_cursor.isNull(_cursorIndexOfProduct)) {
              _tmpProduct = null;
            } else {
              _tmpProduct = _cursor.getInt(_cursorIndexOfProduct);
            }
            _item.setProduct(_tmpProduct);
            final int _tmpDeparture;
            _tmpDeparture = _cursor.getInt(_cursorIndexOfDeparture);
            _item.setDeparture(_tmpDeparture);
            final Double _tmpQuantity;
            if (_cursor.isNull(_cursorIndexOfQuantity)) {
              _tmpQuantity = null;
            } else {
              _tmpQuantity = _cursor.getDouble(_cursorIndexOfQuantity);
            }
            _item.setQuantity(_tmpQuantity);
            final Double _tmpPrice;
            if (_cursor.isNull(_cursorIndexOfPrice)) {
              _tmpPrice = null;
            } else {
              _tmpPrice = _cursor.getDouble(_cursorIndexOfPrice);
            }
            _item.setPrice(_tmpPrice);
            final Double _tmpSubtotal;
            if (_cursor.isNull(_cursorIndexOfSubtotal)) {
              _tmpSubtotal = null;
            } else {
              _tmpSubtotal = _cursor.getDouble(_cursorIndexOfSubtotal);
            }
            _item.setSubtotal(_tmpSubtotal);
            final Double _tmpTotal;
            if (_cursor.isNull(_cursorIndexOfTotal)) {
              _tmpTotal = null;
            } else {
              _tmpTotal = _cursor.getDouble(_cursorIndexOfTotal);
            }
            _item.setTotal(_tmpTotal);
            final Double _tmpFactor;
            if (_cursor.isNull(_cursorIndexOfFactor)) {
              _tmpFactor = null;
            } else {
              _tmpFactor = _cursor.getDouble(_cursorIndexOfFactor);
            }
            _item.setFactor(_tmpFactor);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
            final String _tmpUuid;
            _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            _item.setUuid(_tmpUuid);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            _item.setDate(_tmpDate);
            final String _tmpUuidReceiptOfMerchandise;
            _tmpUuidReceiptOfMerchandise = _cursor.getString(_cursorIndexOfUuidReceiptOfMerchandise);
            _item.setUuidReceiptOfMerchandise(_tmpUuidReceiptOfMerchandise);
            final String _tmpUuidProduct;
            _tmpUuidProduct = _cursor.getString(_cursorIndexOfUuidProduct);
            _item.setUuidProduct(_tmpUuidProduct);
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
  public Flowable<List<ReceiptOfMerchandiseDetailEntity>> getRegisterReceiptOfMerchandiseDetailSync() {
    final String _sql = "SELECT * FROM ReciboMercanciaDetalle r INNER JOIN Bitacora b ON b.Tabla='ReciboMercanciaDetalle' WHERE r.Fecha<=b.Fecha";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"ReciboMercanciaDetalle","Bitacora"}, new Callable<List<ReceiptOfMerchandiseDetailEntity>>() {
      @Override
      public List<ReceiptOfMerchandiseDetailEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfReceiptOfMerchandise = _cursor.getColumnIndexOrThrow("ReciboMercancia");
          final int _cursorIndexOfUnitMeasure = _cursor.getColumnIndexOrThrow("UnidadMedida");
          final int _cursorIndexOfProduct = _cursor.getColumnIndexOrThrow("Producto");
          final int _cursorIndexOfDeparture = _cursor.getColumnIndexOrThrow("Partida");
          final int _cursorIndexOfQuantity = _cursor.getColumnIndexOrThrow("Cantidad");
          final int _cursorIndexOfPrice = _cursor.getColumnIndexOrThrow("Precio");
          final int _cursorIndexOfSubtotal = _cursor.getColumnIndexOrThrow("Subtotal");
          final int _cursorIndexOfTotal = _cursor.getColumnIndexOrThrow("Total");
          final int _cursorIndexOfFactor = _cursor.getColumnIndexOrThrow("Factor");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfUuidReceiptOfMerchandise = _cursor.getColumnIndexOrThrow("UUIDReciboMercancia");
          final int _cursorIndexOfUuidProduct = _cursor.getColumnIndexOrThrow("UUIDProduct");
          final int _cursorIndexOfId_1 = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfDate_1 = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfStatus_1 = _cursor.getColumnIndexOrThrow("Estatus");
          final List<ReceiptOfMerchandiseDetailEntity> _result = new ArrayList<ReceiptOfMerchandiseDetailEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ReceiptOfMerchandiseDetailEntity _item;
            _item = new ReceiptOfMerchandiseDetailEntity();
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final Integer _tmpReceiptOfMerchandise;
            if (_cursor.isNull(_cursorIndexOfReceiptOfMerchandise)) {
              _tmpReceiptOfMerchandise = null;
            } else {
              _tmpReceiptOfMerchandise = _cursor.getInt(_cursorIndexOfReceiptOfMerchandise);
            }
            _item.setReceiptOfMerchandise(_tmpReceiptOfMerchandise);
            final Integer _tmpUnitMeasure;
            if (_cursor.isNull(_cursorIndexOfUnitMeasure)) {
              _tmpUnitMeasure = null;
            } else {
              _tmpUnitMeasure = _cursor.getInt(_cursorIndexOfUnitMeasure);
            }
            _item.setUnitMeasure(_tmpUnitMeasure);
            final Integer _tmpProduct;
            if (_cursor.isNull(_cursorIndexOfProduct)) {
              _tmpProduct = null;
            } else {
              _tmpProduct = _cursor.getInt(_cursorIndexOfProduct);
            }
            _item.setProduct(_tmpProduct);
            final int _tmpDeparture;
            _tmpDeparture = _cursor.getInt(_cursorIndexOfDeparture);
            _item.setDeparture(_tmpDeparture);
            final Double _tmpQuantity;
            if (_cursor.isNull(_cursorIndexOfQuantity)) {
              _tmpQuantity = null;
            } else {
              _tmpQuantity = _cursor.getDouble(_cursorIndexOfQuantity);
            }
            _item.setQuantity(_tmpQuantity);
            final Double _tmpPrice;
            if (_cursor.isNull(_cursorIndexOfPrice)) {
              _tmpPrice = null;
            } else {
              _tmpPrice = _cursor.getDouble(_cursorIndexOfPrice);
            }
            _item.setPrice(_tmpPrice);
            final Double _tmpSubtotal;
            if (_cursor.isNull(_cursorIndexOfSubtotal)) {
              _tmpSubtotal = null;
            } else {
              _tmpSubtotal = _cursor.getDouble(_cursorIndexOfSubtotal);
            }
            _item.setSubtotal(_tmpSubtotal);
            final Double _tmpTotal;
            if (_cursor.isNull(_cursorIndexOfTotal)) {
              _tmpTotal = null;
            } else {
              _tmpTotal = _cursor.getDouble(_cursorIndexOfTotal);
            }
            _item.setTotal(_tmpTotal);
            final Double _tmpFactor;
            if (_cursor.isNull(_cursorIndexOfFactor)) {
              _tmpFactor = null;
            } else {
              _tmpFactor = _cursor.getDouble(_cursorIndexOfFactor);
            }
            _item.setFactor(_tmpFactor);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
            final String _tmpUuid;
            _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            _item.setUuid(_tmpUuid);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            _item.setDate(_tmpDate);
            final String _tmpUuidReceiptOfMerchandise;
            _tmpUuidReceiptOfMerchandise = _cursor.getString(_cursorIndexOfUuidReceiptOfMerchandise);
            _item.setUuidReceiptOfMerchandise(_tmpUuidReceiptOfMerchandise);
            final String _tmpUuidProduct;
            _tmpUuidProduct = _cursor.getString(_cursorIndexOfUuidProduct);
            _item.setUuidProduct(_tmpUuidProduct);
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
            final int _tmpStatus_1;
            _tmpStatus_1 = _cursor.getInt(_cursorIndexOfStatus_1);
            _item.setStatus(_tmpStatus_1);
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
