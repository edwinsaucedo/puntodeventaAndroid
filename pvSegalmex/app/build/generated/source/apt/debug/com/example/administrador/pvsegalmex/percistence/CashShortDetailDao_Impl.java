package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.RxRoom;
import android.database.Cursor;
import com.example.administrador.pvsegalmex.entity.CashShortDetailEntity;
import com.example.administrador.pvsegalmex.pojo.CashShortDetailWayPayPojo;
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
public class CashShortDetailDao_Impl implements CashShortDetailDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfCashShortDetailEntity;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfCashShortDetailEntity;

  public CashShortDetailDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCashShortDetailEntity = new EntityInsertionAdapter<CashShortDetailEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `CorteCajaDetalle`(`Id`,`CorteCaja`,`FormaPago`,`MontoCalculado`,`MontoCapturado`,`Diference`,`Estatus`,`Fecha`,`UUID`,`UUIDCorteCaja`,`UUIDFormaPago`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CashShortDetailEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getCashShort() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getCashShort());
        }
        if (value.getWayPay() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getWayPay());
        }
        if (value.getAmountCal() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindDouble(4, value.getAmountCal());
        }
        if (value.getAmountCap() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindDouble(5, value.getAmountCap());
        }
        if (value.getDiference() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindDouble(6, value.getDiference());
        }
        stmt.bindLong(7, value.getStatus());
        if (value.getDate() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getDate());
        }
        if (value.getUuid() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getUuid());
        }
        if (value.getUuidCashShort() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getUuidCashShort());
        }
        if (value.getUuidWayPay() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getUuidWayPay());
        }
      }
    };
    this.__updateAdapterOfCashShortDetailEntity = new EntityDeletionOrUpdateAdapter<CashShortDetailEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `CorteCajaDetalle` SET `Id` = ?,`CorteCaja` = ?,`FormaPago` = ?,`MontoCalculado` = ?,`MontoCapturado` = ?,`Diference` = ?,`Estatus` = ?,`Fecha` = ?,`UUID` = ?,`UUIDCorteCaja` = ?,`UUIDFormaPago` = ? WHERE `Id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CashShortDetailEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getCashShort() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getCashShort());
        }
        if (value.getWayPay() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getWayPay());
        }
        if (value.getAmountCal() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindDouble(4, value.getAmountCal());
        }
        if (value.getAmountCap() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindDouble(5, value.getAmountCap());
        }
        if (value.getDiference() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindDouble(6, value.getDiference());
        }
        stmt.bindLong(7, value.getStatus());
        if (value.getDate() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getDate());
        }
        if (value.getUuid() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getUuid());
        }
        if (value.getUuidCashShort() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getUuidCashShort());
        }
        if (value.getUuidWayPay() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getUuidWayPay());
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
  public Long insertCashShortDetail(CashShortDetailEntity cashShortDetail) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfCashShortDetailEntity.insertAndReturnId(cashShortDetail);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateCashShortDetail(CashShortDetailEntity cashShortDetail) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfCashShortDetailEntity.handle(cashShortDetail);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Flowable<List<CashShortDetailEntity>> getFilterCashShortDetail() {
    final String _sql = "SELECT*FROM CorteCajaDetalle d where d.Estatus>-1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"CorteCajaDetalle"}, new Callable<List<CashShortDetailEntity>>() {
      @Override
      public List<CashShortDetailEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfCashShort = _cursor.getColumnIndexOrThrow("CorteCaja");
          final int _cursorIndexOfWayPay = _cursor.getColumnIndexOrThrow("FormaPago");
          final int _cursorIndexOfAmountCal = _cursor.getColumnIndexOrThrow("MontoCalculado");
          final int _cursorIndexOfAmountCap = _cursor.getColumnIndexOrThrow("MontoCapturado");
          final int _cursorIndexOfDiference = _cursor.getColumnIndexOrThrow("Diference");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final int _cursorIndexOfUuidCashShort = _cursor.getColumnIndexOrThrow("UUIDCorteCaja");
          final int _cursorIndexOfUuidWayPay = _cursor.getColumnIndexOrThrow("UUIDFormaPago");
          final List<CashShortDetailEntity> _result = new ArrayList<CashShortDetailEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final CashShortDetailEntity _item;
            _item = new CashShortDetailEntity();
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final Integer _tmpCashShort;
            if (_cursor.isNull(_cursorIndexOfCashShort)) {
              _tmpCashShort = null;
            } else {
              _tmpCashShort = _cursor.getInt(_cursorIndexOfCashShort);
            }
            _item.setCashShort(_tmpCashShort);
            final Integer _tmpWayPay;
            if (_cursor.isNull(_cursorIndexOfWayPay)) {
              _tmpWayPay = null;
            } else {
              _tmpWayPay = _cursor.getInt(_cursorIndexOfWayPay);
            }
            _item.setWayPay(_tmpWayPay);
            final Double _tmpAmountCal;
            if (_cursor.isNull(_cursorIndexOfAmountCal)) {
              _tmpAmountCal = null;
            } else {
              _tmpAmountCal = _cursor.getDouble(_cursorIndexOfAmountCal);
            }
            _item.setAmountCal(_tmpAmountCal);
            final Double _tmpAmountCap;
            if (_cursor.isNull(_cursorIndexOfAmountCap)) {
              _tmpAmountCap = null;
            } else {
              _tmpAmountCap = _cursor.getDouble(_cursorIndexOfAmountCap);
            }
            _item.setAmountCap(_tmpAmountCap);
            final Double _tmpDiference;
            if (_cursor.isNull(_cursorIndexOfDiference)) {
              _tmpDiference = null;
            } else {
              _tmpDiference = _cursor.getDouble(_cursorIndexOfDiference);
            }
            _item.setDiference(_tmpDiference);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            _item.setDate(_tmpDate);
            final String _tmpUuid;
            _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            _item.setUuid(_tmpUuid);
            final String _tmpUuidCashShort;
            _tmpUuidCashShort = _cursor.getString(_cursorIndexOfUuidCashShort);
            _item.setUuidCashShort(_tmpUuidCashShort);
            final String _tmpUuidWayPay;
            _tmpUuidWayPay = _cursor.getString(_cursorIndexOfUuidWayPay);
            _item.setUuidWayPay(_tmpUuidWayPay);
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
  public Flowable<List<CashShortDetailEntity>> getRegisterCashShortDetailSync() {
    final String _sql = "SELECT * FROM CorteCajaDetalle c INNER JOIN Bitacora b ON b.Tabla='CorteCajaDetalle' WHERE c.Fecha<=b.Fecha";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"CorteCajaDetalle","Bitacora"}, new Callable<List<CashShortDetailEntity>>() {
      @Override
      public List<CashShortDetailEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfCashShort = _cursor.getColumnIndexOrThrow("CorteCaja");
          final int _cursorIndexOfWayPay = _cursor.getColumnIndexOrThrow("FormaPago");
          final int _cursorIndexOfAmountCal = _cursor.getColumnIndexOrThrow("MontoCalculado");
          final int _cursorIndexOfAmountCap = _cursor.getColumnIndexOrThrow("MontoCapturado");
          final int _cursorIndexOfDiference = _cursor.getColumnIndexOrThrow("Diference");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final int _cursorIndexOfUuidCashShort = _cursor.getColumnIndexOrThrow("UUIDCorteCaja");
          final int _cursorIndexOfUuidWayPay = _cursor.getColumnIndexOrThrow("UUIDFormaPago");
          final int _cursorIndexOfId_1 = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfDate_1 = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfStatus_1 = _cursor.getColumnIndexOrThrow("Estatus");
          final List<CashShortDetailEntity> _result = new ArrayList<CashShortDetailEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final CashShortDetailEntity _item;
            _item = new CashShortDetailEntity();
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final Integer _tmpCashShort;
            if (_cursor.isNull(_cursorIndexOfCashShort)) {
              _tmpCashShort = null;
            } else {
              _tmpCashShort = _cursor.getInt(_cursorIndexOfCashShort);
            }
            _item.setCashShort(_tmpCashShort);
            final Integer _tmpWayPay;
            if (_cursor.isNull(_cursorIndexOfWayPay)) {
              _tmpWayPay = null;
            } else {
              _tmpWayPay = _cursor.getInt(_cursorIndexOfWayPay);
            }
            _item.setWayPay(_tmpWayPay);
            final Double _tmpAmountCal;
            if (_cursor.isNull(_cursorIndexOfAmountCal)) {
              _tmpAmountCal = null;
            } else {
              _tmpAmountCal = _cursor.getDouble(_cursorIndexOfAmountCal);
            }
            _item.setAmountCal(_tmpAmountCal);
            final Double _tmpAmountCap;
            if (_cursor.isNull(_cursorIndexOfAmountCap)) {
              _tmpAmountCap = null;
            } else {
              _tmpAmountCap = _cursor.getDouble(_cursorIndexOfAmountCap);
            }
            _item.setAmountCap(_tmpAmountCap);
            final Double _tmpDiference;
            if (_cursor.isNull(_cursorIndexOfDiference)) {
              _tmpDiference = null;
            } else {
              _tmpDiference = _cursor.getDouble(_cursorIndexOfDiference);
            }
            _item.setDiference(_tmpDiference);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            _item.setDate(_tmpDate);
            final String _tmpUuid;
            _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            _item.setUuid(_tmpUuid);
            final String _tmpUuidCashShort;
            _tmpUuidCashShort = _cursor.getString(_cursorIndexOfUuidCashShort);
            _item.setUuidCashShort(_tmpUuidCashShort);
            final String _tmpUuidWayPay;
            _tmpUuidWayPay = _cursor.getString(_cursorIndexOfUuidWayPay);
            _item.setUuidWayPay(_tmpUuidWayPay);
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

  @Override
  public Flowable<List<CashShortDetailWayPayPojo>> getCashShortDetailWayPay(Integer idCashShort) {
    final String _sql = "SELECT c.FormaPago wayPay,c.MontoCalculado amountCalculate, c.MontoCapturado amountCapturate, c.Diference amoutDiference, f.Description wayPayDescription FROM CorteCajaDetalle c INNER JOIN FormaPago f ON c.FormaPago=f.Id WHERE c.CorteCaja=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (idCashShort == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, idCashShort);
    }
    return RxRoom.createFlowable(__db, new String[]{"CorteCajaDetalle","FormaPago"}, new Callable<List<CashShortDetailWayPayPojo>>() {
      @Override
      public List<CashShortDetailWayPayPojo> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfWayPay = _cursor.getColumnIndexOrThrow("wayPay");
          final int _cursorIndexOfAmountCalculate = _cursor.getColumnIndexOrThrow("amountCalculate");
          final int _cursorIndexOfAmountCapturate = _cursor.getColumnIndexOrThrow("amountCapturate");
          final int _cursorIndexOfAmoutDiference = _cursor.getColumnIndexOrThrow("amoutDiference");
          final int _cursorIndexOfWayPayDescription = _cursor.getColumnIndexOrThrow("wayPayDescription");
          final List<CashShortDetailWayPayPojo> _result = new ArrayList<CashShortDetailWayPayPojo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final CashShortDetailWayPayPojo _item;
            _item = new CashShortDetailWayPayPojo();
            final Integer _tmpWayPay;
            if (_cursor.isNull(_cursorIndexOfWayPay)) {
              _tmpWayPay = null;
            } else {
              _tmpWayPay = _cursor.getInt(_cursorIndexOfWayPay);
            }
            _item.setWayPay(_tmpWayPay);
            final Double _tmpAmountCalculate;
            if (_cursor.isNull(_cursorIndexOfAmountCalculate)) {
              _tmpAmountCalculate = null;
            } else {
              _tmpAmountCalculate = _cursor.getDouble(_cursorIndexOfAmountCalculate);
            }
            _item.setAmountCalculate(_tmpAmountCalculate);
            final Double _tmpAmountCapturate;
            if (_cursor.isNull(_cursorIndexOfAmountCapturate)) {
              _tmpAmountCapturate = null;
            } else {
              _tmpAmountCapturate = _cursor.getDouble(_cursorIndexOfAmountCapturate);
            }
            _item.setAmountCapturate(_tmpAmountCapturate);
            final Double _tmpAmoutDiference;
            if (_cursor.isNull(_cursorIndexOfAmoutDiference)) {
              _tmpAmoutDiference = null;
            } else {
              _tmpAmoutDiference = _cursor.getDouble(_cursorIndexOfAmoutDiference);
            }
            _item.setAmoutDiference(_tmpAmoutDiference);
            final String _tmpWayPayDescription;
            _tmpWayPayDescription = _cursor.getString(_cursorIndexOfWayPayDescription);
            _item.setWayPayDescription(_tmpWayPayDescription);
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
