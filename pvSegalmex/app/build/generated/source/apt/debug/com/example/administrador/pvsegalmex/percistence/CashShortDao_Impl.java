package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.RxRoom;
import android.database.Cursor;
import com.example.administrador.pvsegalmex.entity.CashShortEntity;
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
public class CashShortDao_Impl implements CashShortDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfCashShortEntity;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfCashShortEntity;

  public CashShortDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCashShortEntity = new EntityInsertionAdapter<CashShortEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `CorteCaja`(`Id`,`Usuario`,`Fecha`,`TotalCalculado`,`MontoCapturado`,`Diferencia`,`UUID`,`UUIDUser`,`Estatus`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CashShortEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getUser() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getUser());
        }
        if (value.getDate() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDate());
        }
        if (value.getTotalCal() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindDouble(4, value.getTotalCal());
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
        if (value.getUuid() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getUuid());
        }
        if (value.getUuidUser() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getUuidUser());
        }
        stmt.bindLong(9, value.getStatus());
      }
    };
    this.__updateAdapterOfCashShortEntity = new EntityDeletionOrUpdateAdapter<CashShortEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `CorteCaja` SET `Id` = ?,`Usuario` = ?,`Fecha` = ?,`TotalCalculado` = ?,`MontoCapturado` = ?,`Diferencia` = ?,`UUID` = ?,`UUIDUser` = ?,`Estatus` = ? WHERE `Id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CashShortEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getUser() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getUser());
        }
        if (value.getDate() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDate());
        }
        if (value.getTotalCal() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindDouble(4, value.getTotalCal());
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
        if (value.getUuid() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getUuid());
        }
        if (value.getUuidUser() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getUuidUser());
        }
        stmt.bindLong(9, value.getStatus());
        if (value.getId() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getId());
        }
      }
    };
  }

  @Override
  public Long insertCashShort(CashShortEntity cashShort) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfCashShortEntity.insertAndReturnId(cashShort);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateCashShort(CashShortEntity cashShort) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfCashShortEntity.handle(cashShort);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Flowable<List<CashShortEntity>> getFilterCashShort() {
    final String _sql = "SELECT*FROM CorteCaja d WHERE d.Id>1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"CorteCaja"}, new Callable<List<CashShortEntity>>() {
      @Override
      public List<CashShortEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfUser = _cursor.getColumnIndexOrThrow("Usuario");
          final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfTotalCal = _cursor.getColumnIndexOrThrow("TotalCalculado");
          final int _cursorIndexOfAmountCap = _cursor.getColumnIndexOrThrow("MontoCapturado");
          final int _cursorIndexOfDiference = _cursor.getColumnIndexOrThrow("Diferencia");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final int _cursorIndexOfUuidUser = _cursor.getColumnIndexOrThrow("UUIDUser");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final List<CashShortEntity> _result = new ArrayList<CashShortEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final CashShortEntity _item;
            _item = new CashShortEntity();
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final Integer _tmpUser;
            if (_cursor.isNull(_cursorIndexOfUser)) {
              _tmpUser = null;
            } else {
              _tmpUser = _cursor.getInt(_cursorIndexOfUser);
            }
            _item.setUser(_tmpUser);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            _item.setDate(_tmpDate);
            final Double _tmpTotalCal;
            if (_cursor.isNull(_cursorIndexOfTotalCal)) {
              _tmpTotalCal = null;
            } else {
              _tmpTotalCal = _cursor.getDouble(_cursorIndexOfTotalCal);
            }
            _item.setTotalCal(_tmpTotalCal);
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
            final String _tmpUuid;
            _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            _item.setUuid(_tmpUuid);
            final String _tmpUuidUser;
            _tmpUuidUser = _cursor.getString(_cursorIndexOfUuidUser);
            _item.setUuidUser(_tmpUuidUser);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
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
  public Flowable<List<CashShortEntity>> getAllCashShort() {
    final String _sql = "SELECT*FROM CorteCaja d";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"CorteCaja"}, new Callable<List<CashShortEntity>>() {
      @Override
      public List<CashShortEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfUser = _cursor.getColumnIndexOrThrow("Usuario");
          final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfTotalCal = _cursor.getColumnIndexOrThrow("TotalCalculado");
          final int _cursorIndexOfAmountCap = _cursor.getColumnIndexOrThrow("MontoCapturado");
          final int _cursorIndexOfDiference = _cursor.getColumnIndexOrThrow("Diferencia");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final int _cursorIndexOfUuidUser = _cursor.getColumnIndexOrThrow("UUIDUser");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final List<CashShortEntity> _result = new ArrayList<CashShortEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final CashShortEntity _item;
            _item = new CashShortEntity();
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final Integer _tmpUser;
            if (_cursor.isNull(_cursorIndexOfUser)) {
              _tmpUser = null;
            } else {
              _tmpUser = _cursor.getInt(_cursorIndexOfUser);
            }
            _item.setUser(_tmpUser);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            _item.setDate(_tmpDate);
            final Double _tmpTotalCal;
            if (_cursor.isNull(_cursorIndexOfTotalCal)) {
              _tmpTotalCal = null;
            } else {
              _tmpTotalCal = _cursor.getDouble(_cursorIndexOfTotalCal);
            }
            _item.setTotalCal(_tmpTotalCal);
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
            final String _tmpUuid;
            _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            _item.setUuid(_tmpUuid);
            final String _tmpUuidUser;
            _tmpUuidUser = _cursor.getString(_cursorIndexOfUuidUser);
            _item.setUuidUser(_tmpUuidUser);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
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
  public Flowable<List<CashShortEntity>> getRegisterCashShortSync() {
    final String _sql = "SELECT * FROM CorteCaja c INNER JOIN Bitacora b ON b.Tabla='CorteCaja' WHERE c.Fecha<=b.Fecha";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"CorteCaja","Bitacora"}, new Callable<List<CashShortEntity>>() {
      @Override
      public List<CashShortEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfUser = _cursor.getColumnIndexOrThrow("Usuario");
          final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfTotalCal = _cursor.getColumnIndexOrThrow("TotalCalculado");
          final int _cursorIndexOfAmountCap = _cursor.getColumnIndexOrThrow("MontoCapturado");
          final int _cursorIndexOfDiference = _cursor.getColumnIndexOrThrow("Diferencia");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final int _cursorIndexOfUuidUser = _cursor.getColumnIndexOrThrow("UUIDUser");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfId_1 = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfDate_1 = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfStatus_1 = _cursor.getColumnIndexOrThrow("Estatus");
          final List<CashShortEntity> _result = new ArrayList<CashShortEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final CashShortEntity _item;
            _item = new CashShortEntity();
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final Integer _tmpUser;
            if (_cursor.isNull(_cursorIndexOfUser)) {
              _tmpUser = null;
            } else {
              _tmpUser = _cursor.getInt(_cursorIndexOfUser);
            }
            _item.setUser(_tmpUser);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            _item.setDate(_tmpDate);
            final Double _tmpTotalCal;
            if (_cursor.isNull(_cursorIndexOfTotalCal)) {
              _tmpTotalCal = null;
            } else {
              _tmpTotalCal = _cursor.getDouble(_cursorIndexOfTotalCal);
            }
            _item.setTotalCal(_tmpTotalCal);
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
            final String _tmpUuid;
            _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            _item.setUuid(_tmpUuid);
            final String _tmpUuidUser;
            _tmpUuidUser = _cursor.getString(_cursorIndexOfUuidUser);
            _item.setUuidUser(_tmpUuidUser);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
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
