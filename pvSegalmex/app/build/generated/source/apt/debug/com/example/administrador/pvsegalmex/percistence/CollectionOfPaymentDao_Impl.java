package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.RxRoom;
import android.database.Cursor;
import com.example.administrador.pvsegalmex.entity.CollectionOfPaymentEntity;
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
public class CollectionOfPaymentDao_Impl implements CollectionOfPaymentDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfCollectionOfPaymentEntity;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfCollectionOfPaymentEntity;

  public CollectionOfPaymentDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCollectionOfPaymentEntity = new EntityInsertionAdapter<CollectionOfPaymentEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `VentaCobro`(`Id`,`Venta`,`FormaPago`,`CorteCaja`,`Monto`,`Estatus`,`Fecha`,`UUID`,`UUIDVenta`,`UUIDFormaPago`,`UUIDCorteCaja`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CollectionOfPaymentEntity value) {
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
        if (value.getWayPay() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getWayPay());
        }
        if (value.getCashShort() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getCashShort());
        }
        if (value.getAmount() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindDouble(5, value.getAmount());
        }
        stmt.bindLong(6, value.getStatus());
        if (value.getDate() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getDate());
        }
        if (value.getUuid() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getUuid());
        }
        if (value.getUuidSale() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getUuidSale());
        }
        if (value.getUuidWayPay() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getUuidWayPay());
        }
        if (value.getUuidCashShort() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getUuidCashShort());
        }
      }
    };
    this.__updateAdapterOfCollectionOfPaymentEntity = new EntityDeletionOrUpdateAdapter<CollectionOfPaymentEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `VentaCobro` SET `Id` = ?,`Venta` = ?,`FormaPago` = ?,`CorteCaja` = ?,`Monto` = ?,`Estatus` = ?,`Fecha` = ?,`UUID` = ?,`UUIDVenta` = ?,`UUIDFormaPago` = ?,`UUIDCorteCaja` = ? WHERE `Id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CollectionOfPaymentEntity value) {
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
        if (value.getWayPay() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getWayPay());
        }
        if (value.getCashShort() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getCashShort());
        }
        if (value.getAmount() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindDouble(5, value.getAmount());
        }
        stmt.bindLong(6, value.getStatus());
        if (value.getDate() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getDate());
        }
        if (value.getUuid() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getUuid());
        }
        if (value.getUuidSale() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getUuidSale());
        }
        if (value.getUuidWayPay() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getUuidWayPay());
        }
        if (value.getUuidCashShort() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getUuidCashShort());
        }
        if (value.getId() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindLong(12, value.getId());
        }
      }
    };
  }

  @Override
  public Long insertCollectionOfPayment(CollectionOfPaymentEntity collectionOfPaymentEntity) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfCollectionOfPaymentEntity.insertAndReturnId(collectionOfPaymentEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateCollectionOfPayment(CollectionOfPaymentEntity collectionOfPaymentEntity) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfCollectionOfPaymentEntity.handle(collectionOfPaymentEntity);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Flowable<List<CollectionOfPaymentEntity>> getFilterCollection() {
    final String _sql = "SELECT * FROM VentaCobro v WHERE v.Estatus>-1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"VentaCobro"}, new Callable<List<CollectionOfPaymentEntity>>() {
      @Override
      public List<CollectionOfPaymentEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfSale = _cursor.getColumnIndexOrThrow("Venta");
          final int _cursorIndexOfWayPay = _cursor.getColumnIndexOrThrow("FormaPago");
          final int _cursorIndexOfCashShort = _cursor.getColumnIndexOrThrow("CorteCaja");
          final int _cursorIndexOfAmount = _cursor.getColumnIndexOrThrow("Monto");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final int _cursorIndexOfUuidSale = _cursor.getColumnIndexOrThrow("UUIDVenta");
          final int _cursorIndexOfUuidWayPay = _cursor.getColumnIndexOrThrow("UUIDFormaPago");
          final int _cursorIndexOfUuidCashShort = _cursor.getColumnIndexOrThrow("UUIDCorteCaja");
          final List<CollectionOfPaymentEntity> _result = new ArrayList<CollectionOfPaymentEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final CollectionOfPaymentEntity _item;
            _item = new CollectionOfPaymentEntity();
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
            final Integer _tmpWayPay;
            if (_cursor.isNull(_cursorIndexOfWayPay)) {
              _tmpWayPay = null;
            } else {
              _tmpWayPay = _cursor.getInt(_cursorIndexOfWayPay);
            }
            _item.setWayPay(_tmpWayPay);
            final Integer _tmpCashShort;
            if (_cursor.isNull(_cursorIndexOfCashShort)) {
              _tmpCashShort = null;
            } else {
              _tmpCashShort = _cursor.getInt(_cursorIndexOfCashShort);
            }
            _item.setCashShort(_tmpCashShort);
            final Double _tmpAmount;
            if (_cursor.isNull(_cursorIndexOfAmount)) {
              _tmpAmount = null;
            } else {
              _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            }
            _item.setAmount(_tmpAmount);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
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
            final String _tmpUuidWayPay;
            _tmpUuidWayPay = _cursor.getString(_cursorIndexOfUuidWayPay);
            _item.setUuidWayPay(_tmpUuidWayPay);
            final String _tmpUuidCashShort;
            _tmpUuidCashShort = _cursor.getString(_cursorIndexOfUuidCashShort);
            _item.setUuidCashShort(_tmpUuidCashShort);
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
  public Flowable<List<CollectionOfPaymentEntity>> getRegisterCollectionOfPaymentSync() {
    final String _sql = "SELECT * FROM VentaCobro c INNER JOIN Bitacora b ON b.Tabla='CobroVenta' INNER JOIN Venta v ON c.Venta=v.Id  WHERE c.Fecha<=b.Fecha and v.EstatusVenta = 'CERRADA'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"VentaCobro","Bitacora","Venta"}, new Callable<List<CollectionOfPaymentEntity>>() {
      @Override
      public List<CollectionOfPaymentEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfSale = _cursor.getColumnIndexOrThrow("Venta");
          final int _cursorIndexOfWayPay = _cursor.getColumnIndexOrThrow("FormaPago");
          final int _cursorIndexOfCashShort = _cursor.getColumnIndexOrThrow("CorteCaja");
          final int _cursorIndexOfAmount = _cursor.getColumnIndexOrThrow("Monto");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final int _cursorIndexOfUuidSale = _cursor.getColumnIndexOrThrow("UUIDVenta");
          final int _cursorIndexOfUuidWayPay = _cursor.getColumnIndexOrThrow("UUIDFormaPago");
          final int _cursorIndexOfUuidCashShort = _cursor.getColumnIndexOrThrow("UUIDCorteCaja");
          final int _cursorIndexOfId_1 = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfDate_1 = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfStatus_1 = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfId_2 = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfDate_2 = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfStatus_2 = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfWayPay_1 = _cursor.getColumnIndexOrThrow("FormaPago");
          final int _cursorIndexOfCashShort_1 = _cursor.getColumnIndexOrThrow("CorteCaja");
          final int _cursorIndexOfUuid_1 = _cursor.getColumnIndexOrThrow("UUID");
          final int _cursorIndexOfUuidCashShort_1 = _cursor.getColumnIndexOrThrow("UUIDCorteCaja");
          final List<CollectionOfPaymentEntity> _result = new ArrayList<CollectionOfPaymentEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final CollectionOfPaymentEntity _item;
            _item = new CollectionOfPaymentEntity();
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
            final Integer _tmpWayPay;
            if (_cursor.isNull(_cursorIndexOfWayPay)) {
              _tmpWayPay = null;
            } else {
              _tmpWayPay = _cursor.getInt(_cursorIndexOfWayPay);
            }
            _item.setWayPay(_tmpWayPay);
            final Integer _tmpCashShort;
            if (_cursor.isNull(_cursorIndexOfCashShort)) {
              _tmpCashShort = null;
            } else {
              _tmpCashShort = _cursor.getInt(_cursorIndexOfCashShort);
            }
            _item.setCashShort(_tmpCashShort);
            final Double _tmpAmount;
            if (_cursor.isNull(_cursorIndexOfAmount)) {
              _tmpAmount = null;
            } else {
              _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            }
            _item.setAmount(_tmpAmount);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
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
            final String _tmpUuidWayPay;
            _tmpUuidWayPay = _cursor.getString(_cursorIndexOfUuidWayPay);
            _item.setUuidWayPay(_tmpUuidWayPay);
            final String _tmpUuidCashShort;
            _tmpUuidCashShort = _cursor.getString(_cursorIndexOfUuidCashShort);
            _item.setUuidCashShort(_tmpUuidCashShort);
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
            final int _tmpStatus_2;
            _tmpStatus_2 = _cursor.getInt(_cursorIndexOfStatus_2);
            _item.setStatus(_tmpStatus_2);
            final Integer _tmpWayPay_1;
            if (_cursor.isNull(_cursorIndexOfWayPay_1)) {
              _tmpWayPay_1 = null;
            } else {
              _tmpWayPay_1 = _cursor.getInt(_cursorIndexOfWayPay_1);
            }
            _item.setWayPay(_tmpWayPay_1);
            final Integer _tmpCashShort_1;
            if (_cursor.isNull(_cursorIndexOfCashShort_1)) {
              _tmpCashShort_1 = null;
            } else {
              _tmpCashShort_1 = _cursor.getInt(_cursorIndexOfCashShort_1);
            }
            _item.setCashShort(_tmpCashShort_1);
            final String _tmpUuid_1;
            _tmpUuid_1 = _cursor.getString(_cursorIndexOfUuid_1);
            _item.setUuid(_tmpUuid_1);
            final String _tmpUuidCashShort_1;
            _tmpUuidCashShort_1 = _cursor.getString(_cursorIndexOfUuidCashShort_1);
            _item.setUuidCashShort(_tmpUuidCashShort_1);
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
  public Flowable<List<CollectionOfPaymentEntity>> getWayPayAmount(Integer id) {
    final String _sql = "SELECT * FROM VentaCobro c  WHERE c.FormaPago=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, id);
    }
    return RxRoom.createFlowable(__db, new String[]{"VentaCobro"}, new Callable<List<CollectionOfPaymentEntity>>() {
      @Override
      public List<CollectionOfPaymentEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfSale = _cursor.getColumnIndexOrThrow("Venta");
          final int _cursorIndexOfWayPay = _cursor.getColumnIndexOrThrow("FormaPago");
          final int _cursorIndexOfCashShort = _cursor.getColumnIndexOrThrow("CorteCaja");
          final int _cursorIndexOfAmount = _cursor.getColumnIndexOrThrow("Monto");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final int _cursorIndexOfUuidSale = _cursor.getColumnIndexOrThrow("UUIDVenta");
          final int _cursorIndexOfUuidWayPay = _cursor.getColumnIndexOrThrow("UUIDFormaPago");
          final int _cursorIndexOfUuidCashShort = _cursor.getColumnIndexOrThrow("UUIDCorteCaja");
          final List<CollectionOfPaymentEntity> _result = new ArrayList<CollectionOfPaymentEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final CollectionOfPaymentEntity _item;
            _item = new CollectionOfPaymentEntity();
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
            final Integer _tmpWayPay;
            if (_cursor.isNull(_cursorIndexOfWayPay)) {
              _tmpWayPay = null;
            } else {
              _tmpWayPay = _cursor.getInt(_cursorIndexOfWayPay);
            }
            _item.setWayPay(_tmpWayPay);
            final Integer _tmpCashShort;
            if (_cursor.isNull(_cursorIndexOfCashShort)) {
              _tmpCashShort = null;
            } else {
              _tmpCashShort = _cursor.getInt(_cursorIndexOfCashShort);
            }
            _item.setCashShort(_tmpCashShort);
            final Double _tmpAmount;
            if (_cursor.isNull(_cursorIndexOfAmount)) {
              _tmpAmount = null;
            } else {
              _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            }
            _item.setAmount(_tmpAmount);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
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
            final String _tmpUuidWayPay;
            _tmpUuidWayPay = _cursor.getString(_cursorIndexOfUuidWayPay);
            _item.setUuidWayPay(_tmpUuidWayPay);
            final String _tmpUuidCashShort;
            _tmpUuidCashShort = _cursor.getString(_cursorIndexOfUuidCashShort);
            _item.setUuidCashShort(_tmpUuidCashShort);
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
