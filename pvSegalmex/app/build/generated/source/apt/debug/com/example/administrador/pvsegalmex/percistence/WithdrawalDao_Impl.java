package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.RxRoom;
import android.database.Cursor;
import com.example.administrador.pvsegalmex.entity.WithdrawalEntity;
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
public class WithdrawalDao_Impl implements WithdrawalDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfWithdrawalEntity;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfWithdrawalEntity;

  public WithdrawalDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfWithdrawalEntity = new EntityInsertionAdapter<WithdrawalEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `RetiroCaja`(`Id`,`Usuario`,`Fecha`,`Comentarios`,`Monto`,`CorteCaja`,`Estatus`,`UUID`,`UUIDCorteCaja`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WithdrawalEntity value) {
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
        if (value.getComments() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getComments());
        }
        if (value.getAmount() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindDouble(5, value.getAmount());
        }
        if (value.getCashShort() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getCashShort());
        }
        stmt.bindLong(7, value.getStatus());
        if (value.getUuid() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getUuid());
        }
        if (value.getUuidCashShort() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getUuidCashShort());
        }
      }
    };
    this.__updateAdapterOfWithdrawalEntity = new EntityDeletionOrUpdateAdapter<WithdrawalEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `RetiroCaja` SET `Id` = ?,`Usuario` = ?,`Fecha` = ?,`Comentarios` = ?,`Monto` = ?,`CorteCaja` = ?,`Estatus` = ?,`UUID` = ?,`UUIDCorteCaja` = ? WHERE `Id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WithdrawalEntity value) {
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
        if (value.getComments() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getComments());
        }
        if (value.getAmount() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindDouble(5, value.getAmount());
        }
        if (value.getCashShort() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getCashShort());
        }
        stmt.bindLong(7, value.getStatus());
        if (value.getUuid() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getUuid());
        }
        if (value.getUuidCashShort() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getUuidCashShort());
        }
        if (value.getId() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getId());
        }
      }
    };
  }

  @Override
  public Long insertWithdrawal(WithdrawalEntity withdrawal) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfWithdrawalEntity.insertAndReturnId(withdrawal);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateWithdrawal(WithdrawalEntity withdrawal) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfWithdrawalEntity.handle(withdrawal);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Flowable<List<WithdrawalEntity>> getFilterWithdrawal(String date) {
    final String _sql = "SELECT * FROM RetiroCaja r where Fecha glob '*'||?||'*'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (date == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, date);
    }
    return RxRoom.createFlowable(__db, new String[]{"RetiroCaja"}, new Callable<List<WithdrawalEntity>>() {
      @Override
      public List<WithdrawalEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfUser = _cursor.getColumnIndexOrThrow("Usuario");
          final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfComments = _cursor.getColumnIndexOrThrow("Comentarios");
          final int _cursorIndexOfAmount = _cursor.getColumnIndexOrThrow("Monto");
          final int _cursorIndexOfCashShort = _cursor.getColumnIndexOrThrow("CorteCaja");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final int _cursorIndexOfUuidCashShort = _cursor.getColumnIndexOrThrow("UUIDCorteCaja");
          final List<WithdrawalEntity> _result = new ArrayList<WithdrawalEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final WithdrawalEntity _item;
            _item = new WithdrawalEntity();
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
            final String _tmpComments;
            _tmpComments = _cursor.getString(_cursorIndexOfComments);
            _item.setComments(_tmpComments);
            final Double _tmpAmount;
            if (_cursor.isNull(_cursorIndexOfAmount)) {
              _tmpAmount = null;
            } else {
              _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            }
            _item.setAmount(_tmpAmount);
            final Integer _tmpCashShort;
            if (_cursor.isNull(_cursorIndexOfCashShort)) {
              _tmpCashShort = null;
            } else {
              _tmpCashShort = _cursor.getInt(_cursorIndexOfCashShort);
            }
            _item.setCashShort(_tmpCashShort);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
            final String _tmpUuid;
            _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            _item.setUuid(_tmpUuid);
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
  public Flowable<List<WithdrawalEntity>> getsSum() {
    final String _sql = "SELECT * FROM RetiroCaja r";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"RetiroCaja"}, new Callable<List<WithdrawalEntity>>() {
      @Override
      public List<WithdrawalEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfUser = _cursor.getColumnIndexOrThrow("Usuario");
          final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfComments = _cursor.getColumnIndexOrThrow("Comentarios");
          final int _cursorIndexOfAmount = _cursor.getColumnIndexOrThrow("Monto");
          final int _cursorIndexOfCashShort = _cursor.getColumnIndexOrThrow("CorteCaja");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final int _cursorIndexOfUuidCashShort = _cursor.getColumnIndexOrThrow("UUIDCorteCaja");
          final List<WithdrawalEntity> _result = new ArrayList<WithdrawalEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final WithdrawalEntity _item;
            _item = new WithdrawalEntity();
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
            final String _tmpComments;
            _tmpComments = _cursor.getString(_cursorIndexOfComments);
            _item.setComments(_tmpComments);
            final Double _tmpAmount;
            if (_cursor.isNull(_cursorIndexOfAmount)) {
              _tmpAmount = null;
            } else {
              _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            }
            _item.setAmount(_tmpAmount);
            final Integer _tmpCashShort;
            if (_cursor.isNull(_cursorIndexOfCashShort)) {
              _tmpCashShort = null;
            } else {
              _tmpCashShort = _cursor.getInt(_cursorIndexOfCashShort);
            }
            _item.setCashShort(_tmpCashShort);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
            final String _tmpUuid;
            _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            _item.setUuid(_tmpUuid);
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
  public Flowable<List<WithdrawalEntity>> getRegisterWithdrawalSync() {
    final String _sql = "SELECT * FROM RetiroCaja r INNER JOIN Bitacora b ON b.Tabla='RetiroCaja' WHERE r.Fecha<=b.Fecha";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"RetiroCaja","Bitacora"}, new Callable<List<WithdrawalEntity>>() {
      @Override
      public List<WithdrawalEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfUser = _cursor.getColumnIndexOrThrow("Usuario");
          final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfComments = _cursor.getColumnIndexOrThrow("Comentarios");
          final int _cursorIndexOfAmount = _cursor.getColumnIndexOrThrow("Monto");
          final int _cursorIndexOfCashShort = _cursor.getColumnIndexOrThrow("CorteCaja");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final int _cursorIndexOfUuidCashShort = _cursor.getColumnIndexOrThrow("UUIDCorteCaja");
          final int _cursorIndexOfId_1 = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfDate_1 = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfStatus_1 = _cursor.getColumnIndexOrThrow("Estatus");
          final List<WithdrawalEntity> _result = new ArrayList<WithdrawalEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final WithdrawalEntity _item;
            _item = new WithdrawalEntity();
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
            final String _tmpComments;
            _tmpComments = _cursor.getString(_cursorIndexOfComments);
            _item.setComments(_tmpComments);
            final Double _tmpAmount;
            if (_cursor.isNull(_cursorIndexOfAmount)) {
              _tmpAmount = null;
            } else {
              _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            }
            _item.setAmount(_tmpAmount);
            final Integer _tmpCashShort;
            if (_cursor.isNull(_cursorIndexOfCashShort)) {
              _tmpCashShort = null;
            } else {
              _tmpCashShort = _cursor.getInt(_cursorIndexOfCashShort);
            }
            _item.setCashShort(_tmpCashShort);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
            final String _tmpUuid;
            _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            _item.setUuid(_tmpUuid);
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
