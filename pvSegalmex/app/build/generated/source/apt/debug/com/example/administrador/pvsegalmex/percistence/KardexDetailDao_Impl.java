package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.RxRoom;
import android.database.Cursor;
import com.example.administrador.pvsegalmex.entity.KardexDetailEntity;
import com.example.administrador.pvsegalmex.pojo.KardexProductPojo;
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
public class KardexDetailDao_Impl implements KardexDetailDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfKardexDetailEntity;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfKardexDetailEntity;

  public KardexDetailDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfKardexDetailEntity = new EntityInsertionAdapter<KardexDetailEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `KardexDetalle`(`Id`,`Producto`,`UnidadMedida`,`Kardex`,`Cantidad`,`Factor`,`Costo`,`Valor`,`Estatus`,`UUID`,`Fecha`,`UUIDKardex`,`UUIDProduct`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, KardexDetailEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getProduct() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getProduct());
        }
        if (value.getUnitOfMeasure() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getUnitOfMeasure());
        }
        if (value.getKardex() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getKardex());
        }
        if (value.getQuantity() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindDouble(5, value.getQuantity());
        }
        if (value.getFactor() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindDouble(6, value.getFactor());
        }
        if (value.getCost() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindDouble(7, value.getCost());
        }
        if (value.getValue() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindDouble(8, value.getValue());
        }
        stmt.bindLong(9, value.getStatus());
        if (value.getUuid() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getUuid());
        }
        if (value.getDate() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getDate());
        }
        if (value.getUuidKardex() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getUuidKardex());
        }
        if (value.getUuidProduct() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getUuidProduct());
        }
      }
    };
    this.__updateAdapterOfKardexDetailEntity = new EntityDeletionOrUpdateAdapter<KardexDetailEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `KardexDetalle` SET `Id` = ?,`Producto` = ?,`UnidadMedida` = ?,`Kardex` = ?,`Cantidad` = ?,`Factor` = ?,`Costo` = ?,`Valor` = ?,`Estatus` = ?,`UUID` = ?,`Fecha` = ?,`UUIDKardex` = ?,`UUIDProduct` = ? WHERE `Id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, KardexDetailEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getProduct() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getProduct());
        }
        if (value.getUnitOfMeasure() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getUnitOfMeasure());
        }
        if (value.getKardex() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getKardex());
        }
        if (value.getQuantity() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindDouble(5, value.getQuantity());
        }
        if (value.getFactor() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindDouble(6, value.getFactor());
        }
        if (value.getCost() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindDouble(7, value.getCost());
        }
        if (value.getValue() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindDouble(8, value.getValue());
        }
        stmt.bindLong(9, value.getStatus());
        if (value.getUuid() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getUuid());
        }
        if (value.getDate() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getDate());
        }
        if (value.getUuidKardex() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getUuidKardex());
        }
        if (value.getUuidProduct() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getUuidProduct());
        }
        if (value.getId() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindLong(14, value.getId());
        }
      }
    };
  }

  @Override
  public Long insertKardexDetail(KardexDetailEntity kardexDetail) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfKardexDetailEntity.insertAndReturnId(kardexDetail);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateKardexDetail(KardexDetailEntity kardexDetail) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfKardexDetailEntity.handle(kardexDetail);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Flowable<List<KardexDetailEntity>> getFilterKardexDetail() {
    final String _sql = "SELECT * FROM KardexDetalle kd where kd.Estatus>-1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"KardexDetalle"}, new Callable<List<KardexDetailEntity>>() {
      @Override
      public List<KardexDetailEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfProduct = _cursor.getColumnIndexOrThrow("Producto");
          final int _cursorIndexOfUnitOfMeasure = _cursor.getColumnIndexOrThrow("UnidadMedida");
          final int _cursorIndexOfKardex = _cursor.getColumnIndexOrThrow("Kardex");
          final int _cursorIndexOfQuantity = _cursor.getColumnIndexOrThrow("Cantidad");
          final int _cursorIndexOfFactor = _cursor.getColumnIndexOrThrow("Factor");
          final int _cursorIndexOfCost = _cursor.getColumnIndexOrThrow("Costo");
          final int _cursorIndexOfValue = _cursor.getColumnIndexOrThrow("Valor");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfUuidKardex = _cursor.getColumnIndexOrThrow("UUIDKardex");
          final int _cursorIndexOfUuidProduct = _cursor.getColumnIndexOrThrow("UUIDProduct");
          final List<KardexDetailEntity> _result = new ArrayList<KardexDetailEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final KardexDetailEntity _item;
            _item = new KardexDetailEntity();
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final Integer _tmpProduct;
            if (_cursor.isNull(_cursorIndexOfProduct)) {
              _tmpProduct = null;
            } else {
              _tmpProduct = _cursor.getInt(_cursorIndexOfProduct);
            }
            _item.setProduct(_tmpProduct);
            final Integer _tmpUnitOfMeasure;
            if (_cursor.isNull(_cursorIndexOfUnitOfMeasure)) {
              _tmpUnitOfMeasure = null;
            } else {
              _tmpUnitOfMeasure = _cursor.getInt(_cursorIndexOfUnitOfMeasure);
            }
            _item.setUnitOfMeasure(_tmpUnitOfMeasure);
            final Integer _tmpKardex;
            if (_cursor.isNull(_cursorIndexOfKardex)) {
              _tmpKardex = null;
            } else {
              _tmpKardex = _cursor.getInt(_cursorIndexOfKardex);
            }
            _item.setKardex(_tmpKardex);
            final Double _tmpQuantity;
            if (_cursor.isNull(_cursorIndexOfQuantity)) {
              _tmpQuantity = null;
            } else {
              _tmpQuantity = _cursor.getDouble(_cursorIndexOfQuantity);
            }
            _item.setQuantity(_tmpQuantity);
            final Double _tmpFactor;
            if (_cursor.isNull(_cursorIndexOfFactor)) {
              _tmpFactor = null;
            } else {
              _tmpFactor = _cursor.getDouble(_cursorIndexOfFactor);
            }
            _item.setFactor(_tmpFactor);
            final Double _tmpCost;
            if (_cursor.isNull(_cursorIndexOfCost)) {
              _tmpCost = null;
            } else {
              _tmpCost = _cursor.getDouble(_cursorIndexOfCost);
            }
            _item.setCost(_tmpCost);
            final Double _tmpValue;
            if (_cursor.isNull(_cursorIndexOfValue)) {
              _tmpValue = null;
            } else {
              _tmpValue = _cursor.getDouble(_cursorIndexOfValue);
            }
            _item.setValue(_tmpValue);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
            final String _tmpUuid;
            _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            _item.setUuid(_tmpUuid);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            _item.setDate(_tmpDate);
            final String _tmpUuidKardex;
            _tmpUuidKardex = _cursor.getString(_cursorIndexOfUuidKardex);
            _item.setUuidKardex(_tmpUuidKardex);
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
  public Flowable<List<KardexProductPojo>> getKardexProductFilter(Integer idProduct) {
    final String _sql = "SELECT k.Id idKardex, k.Estatus statusKardex, k.Producto productoKardex, k.Factor factorKardex, k.Cantidad quantityKardex, k.Costo costKardex, k.Kardex kardex, k.Valor valueKardex, p.Descripcion description, p.Imagen image,p.Id idProduct,p.Estatus status,p.Categoria idCategory, p.Codigo code, p.CodigoAlterno alternateCode, p.Costo cost,p.CostoUC costUC, p.Diconsa diconsa, p.Factor factor, p.FechaUC dateUC,p.Granel granel, p.Maximo maximmn, p.Minimo minimumn,p.PuntoDeReorden reorderPoint,p.Servicio service, p.UnidadMedida measuereUnit, p.UnidadMedidaCompra unitMeasurePurchase FROM KardexDetalle k INNER JOIN Productos p ON p.Id = k.Producto where p.Id=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (idProduct == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, idProduct);
    }
    return RxRoom.createFlowable(__db, new String[]{"KardexDetalle","Productos"}, new Callable<List<KardexProductPojo>>() {
      @Override
      public List<KardexProductPojo> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfIdKardex = _cursor.getColumnIndexOrThrow("idKardex");
          final int _cursorIndexOfStatusKardex = _cursor.getColumnIndexOrThrow("statusKardex");
          final int _cursorIndexOfFactorKardex = _cursor.getColumnIndexOrThrow("factorKardex");
          final int _cursorIndexOfQuantityKardex = _cursor.getColumnIndexOrThrow("quantityKardex");
          final int _cursorIndexOfCostKardex = _cursor.getColumnIndexOrThrow("costKardex");
          final int _cursorIndexOfKardex = _cursor.getColumnIndexOrThrow("kardex");
          final int _cursorIndexOfValueKardex = _cursor.getColumnIndexOrThrow("valueKardex");
          final int _cursorIndexOfDescription = _cursor.getColumnIndexOrThrow("description");
          final int _cursorIndexOfImage = _cursor.getColumnIndexOrThrow("image");
          final int _cursorIndexOfIdProduct = _cursor.getColumnIndexOrThrow("idProduct");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("status");
          final int _cursorIndexOfIdCategory = _cursor.getColumnIndexOrThrow("idCategory");
          final int _cursorIndexOfCode = _cursor.getColumnIndexOrThrow("code");
          final int _cursorIndexOfAlternateCode = _cursor.getColumnIndexOrThrow("alternateCode");
          final int _cursorIndexOfCost = _cursor.getColumnIndexOrThrow("cost");
          final int _cursorIndexOfCostUC = _cursor.getColumnIndexOrThrow("costUC");
          final int _cursorIndexOfDiconsa = _cursor.getColumnIndexOrThrow("diconsa");
          final int _cursorIndexOfFactor = _cursor.getColumnIndexOrThrow("factor");
          final int _cursorIndexOfDateUC = _cursor.getColumnIndexOrThrow("dateUC");
          final int _cursorIndexOfGranel = _cursor.getColumnIndexOrThrow("granel");
          final int _cursorIndexOfMaximmn = _cursor.getColumnIndexOrThrow("maximmn");
          final int _cursorIndexOfMinimumn = _cursor.getColumnIndexOrThrow("minimumn");
          final int _cursorIndexOfReorderPoint = _cursor.getColumnIndexOrThrow("reorderPoint");
          final int _cursorIndexOfService = _cursor.getColumnIndexOrThrow("service");
          final int _cursorIndexOfMeasuereUnit = _cursor.getColumnIndexOrThrow("measuereUnit");
          final int _cursorIndexOfUnitMeasurePurchase = _cursor.getColumnIndexOrThrow("unitMeasurePurchase");
          final List<KardexProductPojo> _result = new ArrayList<KardexProductPojo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final KardexProductPojo _item;
            _item = new KardexProductPojo();
            final Integer _tmpIdKardex;
            if (_cursor.isNull(_cursorIndexOfIdKardex)) {
              _tmpIdKardex = null;
            } else {
              _tmpIdKardex = _cursor.getInt(_cursorIndexOfIdKardex);
            }
            _item.setIdKardex(_tmpIdKardex);
            final int _tmpStatusKardex;
            _tmpStatusKardex = _cursor.getInt(_cursorIndexOfStatusKardex);
            _item.setStatusKardex(_tmpStatusKardex);
            final Double _tmpFactorKardex;
            if (_cursor.isNull(_cursorIndexOfFactorKardex)) {
              _tmpFactorKardex = null;
            } else {
              _tmpFactorKardex = _cursor.getDouble(_cursorIndexOfFactorKardex);
            }
            _item.setFactorKardex(_tmpFactorKardex);
            final Double _tmpQuantityKardex;
            if (_cursor.isNull(_cursorIndexOfQuantityKardex)) {
              _tmpQuantityKardex = null;
            } else {
              _tmpQuantityKardex = _cursor.getDouble(_cursorIndexOfQuantityKardex);
            }
            _item.setQuantityKardex(_tmpQuantityKardex);
            final Double _tmpCostKardex;
            if (_cursor.isNull(_cursorIndexOfCostKardex)) {
              _tmpCostKardex = null;
            } else {
              _tmpCostKardex = _cursor.getDouble(_cursorIndexOfCostKardex);
            }
            _item.setCostKardex(_tmpCostKardex);
            final Integer _tmpKardex;
            if (_cursor.isNull(_cursorIndexOfKardex)) {
              _tmpKardex = null;
            } else {
              _tmpKardex = _cursor.getInt(_cursorIndexOfKardex);
            }
            _item.setKardex(_tmpKardex);
            final Double _tmpValueKardex;
            if (_cursor.isNull(_cursorIndexOfValueKardex)) {
              _tmpValueKardex = null;
            } else {
              _tmpValueKardex = _cursor.getDouble(_cursorIndexOfValueKardex);
            }
            _item.setValueKardex(_tmpValueKardex);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            _item.setDescription(_tmpDescription);
            final String _tmpImage;
            _tmpImage = _cursor.getString(_cursorIndexOfImage);
            _item.setImage(_tmpImage);
            final Integer _tmpIdProduct;
            if (_cursor.isNull(_cursorIndexOfIdProduct)) {
              _tmpIdProduct = null;
            } else {
              _tmpIdProduct = _cursor.getInt(_cursorIndexOfIdProduct);
            }
            _item.setIdProduct(_tmpIdProduct);
            final Integer _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            }
            _item.setStatus(_tmpStatus);
            final Integer _tmpIdCategory;
            if (_cursor.isNull(_cursorIndexOfIdCategory)) {
              _tmpIdCategory = null;
            } else {
              _tmpIdCategory = _cursor.getInt(_cursorIndexOfIdCategory);
            }
            _item.setIdCategory(_tmpIdCategory);
            final String _tmpCode;
            _tmpCode = _cursor.getString(_cursorIndexOfCode);
            _item.setCode(_tmpCode);
            final String _tmpAlternateCode;
            _tmpAlternateCode = _cursor.getString(_cursorIndexOfAlternateCode);
            _item.setAlternateCode(_tmpAlternateCode);
            final Double _tmpCost;
            if (_cursor.isNull(_cursorIndexOfCost)) {
              _tmpCost = null;
            } else {
              _tmpCost = _cursor.getDouble(_cursorIndexOfCost);
            }
            _item.setCost(_tmpCost);
            final Double _tmpCostUC;
            if (_cursor.isNull(_cursorIndexOfCostUC)) {
              _tmpCostUC = null;
            } else {
              _tmpCostUC = _cursor.getDouble(_cursorIndexOfCostUC);
            }
            _item.setCostUC(_tmpCostUC);
            final Boolean _tmpDiconsa;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfDiconsa)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfDiconsa);
            }
            _tmpDiconsa = _tmp == null ? null : _tmp != 0;
            _item.setDiconsa(_tmpDiconsa);
            final Double _tmpFactor;
            if (_cursor.isNull(_cursorIndexOfFactor)) {
              _tmpFactor = null;
            } else {
              _tmpFactor = _cursor.getDouble(_cursorIndexOfFactor);
            }
            _item.setFactor(_tmpFactor);
            final String _tmpDateUC;
            _tmpDateUC = _cursor.getString(_cursorIndexOfDateUC);
            _item.setDateUC(_tmpDateUC);
            final Boolean _tmpGranel;
            final Integer _tmp_1;
            if (_cursor.isNull(_cursorIndexOfGranel)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getInt(_cursorIndexOfGranel);
            }
            _tmpGranel = _tmp_1 == null ? null : _tmp_1 != 0;
            _item.setGranel(_tmpGranel);
            final Double _tmpMaximmn;
            if (_cursor.isNull(_cursorIndexOfMaximmn)) {
              _tmpMaximmn = null;
            } else {
              _tmpMaximmn = _cursor.getDouble(_cursorIndexOfMaximmn);
            }
            _item.setMaximmn(_tmpMaximmn);
            final Double _tmpMinimumn;
            if (_cursor.isNull(_cursorIndexOfMinimumn)) {
              _tmpMinimumn = null;
            } else {
              _tmpMinimumn = _cursor.getDouble(_cursorIndexOfMinimumn);
            }
            _item.setMinimumn(_tmpMinimumn);
            final Double _tmpReorderPoint;
            if (_cursor.isNull(_cursorIndexOfReorderPoint)) {
              _tmpReorderPoint = null;
            } else {
              _tmpReorderPoint = _cursor.getDouble(_cursorIndexOfReorderPoint);
            }
            _item.setReorderPoint(_tmpReorderPoint);
            final Boolean _tmpService;
            final Integer _tmp_2;
            if (_cursor.isNull(_cursorIndexOfService)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getInt(_cursorIndexOfService);
            }
            _tmpService = _tmp_2 == null ? null : _tmp_2 != 0;
            _item.setService(_tmpService);
            final Integer _tmpMeasuereUnit;
            if (_cursor.isNull(_cursorIndexOfMeasuereUnit)) {
              _tmpMeasuereUnit = null;
            } else {
              _tmpMeasuereUnit = _cursor.getInt(_cursorIndexOfMeasuereUnit);
            }
            _item.setMeasuereUnit(_tmpMeasuereUnit);
            final Integer _tmpUnitMeasurePurchase;
            if (_cursor.isNull(_cursorIndexOfUnitMeasurePurchase)) {
              _tmpUnitMeasurePurchase = null;
            } else {
              _tmpUnitMeasurePurchase = _cursor.getInt(_cursorIndexOfUnitMeasurePurchase);
            }
            _item.setUnitMeasurePurchase(_tmpUnitMeasurePurchase);
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
  public Flowable<List<KardexDetailEntity>> getRegisterKardexDetailSync() {
    final String _sql = "SELECT * FROM KardexDetalle k INNER JOIN Bitacora b ON b.Tabla='KardexDetalle' WHERE k.Fecha<=b.Fecha";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"KardexDetalle","Bitacora"}, new Callable<List<KardexDetailEntity>>() {
      @Override
      public List<KardexDetailEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfProduct = _cursor.getColumnIndexOrThrow("Producto");
          final int _cursorIndexOfUnitOfMeasure = _cursor.getColumnIndexOrThrow("UnidadMedida");
          final int _cursorIndexOfKardex = _cursor.getColumnIndexOrThrow("Kardex");
          final int _cursorIndexOfQuantity = _cursor.getColumnIndexOrThrow("Cantidad");
          final int _cursorIndexOfFactor = _cursor.getColumnIndexOrThrow("Factor");
          final int _cursorIndexOfCost = _cursor.getColumnIndexOrThrow("Costo");
          final int _cursorIndexOfValue = _cursor.getColumnIndexOrThrow("Valor");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfUuidKardex = _cursor.getColumnIndexOrThrow("UUIDKardex");
          final int _cursorIndexOfUuidProduct = _cursor.getColumnIndexOrThrow("UUIDProduct");
          final int _cursorIndexOfId_1 = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfDate_1 = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfStatus_1 = _cursor.getColumnIndexOrThrow("Estatus");
          final List<KardexDetailEntity> _result = new ArrayList<KardexDetailEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final KardexDetailEntity _item;
            _item = new KardexDetailEntity();
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final Integer _tmpProduct;
            if (_cursor.isNull(_cursorIndexOfProduct)) {
              _tmpProduct = null;
            } else {
              _tmpProduct = _cursor.getInt(_cursorIndexOfProduct);
            }
            _item.setProduct(_tmpProduct);
            final Integer _tmpUnitOfMeasure;
            if (_cursor.isNull(_cursorIndexOfUnitOfMeasure)) {
              _tmpUnitOfMeasure = null;
            } else {
              _tmpUnitOfMeasure = _cursor.getInt(_cursorIndexOfUnitOfMeasure);
            }
            _item.setUnitOfMeasure(_tmpUnitOfMeasure);
            final Integer _tmpKardex;
            if (_cursor.isNull(_cursorIndexOfKardex)) {
              _tmpKardex = null;
            } else {
              _tmpKardex = _cursor.getInt(_cursorIndexOfKardex);
            }
            _item.setKardex(_tmpKardex);
            final Double _tmpQuantity;
            if (_cursor.isNull(_cursorIndexOfQuantity)) {
              _tmpQuantity = null;
            } else {
              _tmpQuantity = _cursor.getDouble(_cursorIndexOfQuantity);
            }
            _item.setQuantity(_tmpQuantity);
            final Double _tmpFactor;
            if (_cursor.isNull(_cursorIndexOfFactor)) {
              _tmpFactor = null;
            } else {
              _tmpFactor = _cursor.getDouble(_cursorIndexOfFactor);
            }
            _item.setFactor(_tmpFactor);
            final Double _tmpCost;
            if (_cursor.isNull(_cursorIndexOfCost)) {
              _tmpCost = null;
            } else {
              _tmpCost = _cursor.getDouble(_cursorIndexOfCost);
            }
            _item.setCost(_tmpCost);
            final Double _tmpValue;
            if (_cursor.isNull(_cursorIndexOfValue)) {
              _tmpValue = null;
            } else {
              _tmpValue = _cursor.getDouble(_cursorIndexOfValue);
            }
            _item.setValue(_tmpValue);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
            final String _tmpUuid;
            _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            _item.setUuid(_tmpUuid);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            _item.setDate(_tmpDate);
            final String _tmpUuidKardex;
            _tmpUuidKardex = _cursor.getString(_cursorIndexOfUuidKardex);
            _item.setUuidKardex(_tmpUuidKardex);
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
