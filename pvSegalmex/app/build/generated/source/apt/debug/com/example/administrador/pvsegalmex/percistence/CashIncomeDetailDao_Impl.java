package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.RxRoom;
import android.database.Cursor;
import com.example.administrador.pvsegalmex.entity.CashIncomeDetailEntity;
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
public class CashIncomeDetailDao_Impl implements CashIncomeDetailDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfCashIncomeDetailEntity;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfCashIncomeDetailEntity;

  public CashIncomeDetailDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCashIncomeDetailEntity = new EntityInsertionAdapter<CashIncomeDetailEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `IngresosDetalle`(`Id`,`FormaPago`,`Ingresos`,`Monto`,`UltimaActualizacion`,`UUID`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CashIncomeDetailEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getIdWayPay() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getIdWayPay());
        }
        if (value.getIdIncome() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getIdIncome());
        }
        if (value.getAmount() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindDouble(4, value.getAmount());
        }
        if (value.getLastDateSync() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLastDateSync());
        }
        if (value.getUuid() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getUuid());
        }
      }
    };
    this.__updateAdapterOfCashIncomeDetailEntity = new EntityDeletionOrUpdateAdapter<CashIncomeDetailEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `IngresosDetalle` SET `Id` = ?,`FormaPago` = ?,`Ingresos` = ?,`Monto` = ?,`UltimaActualizacion` = ?,`UUID` = ? WHERE `Id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CashIncomeDetailEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getIdWayPay() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getIdWayPay());
        }
        if (value.getIdIncome() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getIdIncome());
        }
        if (value.getAmount() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindDouble(4, value.getAmount());
        }
        if (value.getLastDateSync() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLastDateSync());
        }
        if (value.getUuid() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getUuid());
        }
        if (value.getId() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getId());
        }
      }
    };
  }

  @Override
  public Long insertCashIncomeDetail(CashIncomeDetailEntity cashIncomeDetailEntity) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfCashIncomeDetailEntity.insertAndReturnId(cashIncomeDetailEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateCashIncomeDetail(CashIncomeDetailEntity cashIncomeDetailEntity) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfCashIncomeDetailEntity.handle(cashIncomeDetailEntity);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Flowable<List<CashIncomeDetailEntity>> getCashIncomeDetailSync() {
    final String _sql = "SELECT * FROM IngresosDetalle id INNER JOIN Bitacora b ON b.Tabla='IngresosDetalle' WHERE id.UltimaActualizacion<=b.Fecha";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"IngresosDetalle","Bitacora"}, new Callable<List<CashIncomeDetailEntity>>() {
      @Override
      public List<CashIncomeDetailEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfIdWayPay = _cursor.getColumnIndexOrThrow("FormaPago");
          final int _cursorIndexOfIdIncome = _cursor.getColumnIndexOrThrow("Ingresos");
          final int _cursorIndexOfAmount = _cursor.getColumnIndexOrThrow("Monto");
          final int _cursorIndexOfLastDateSync = _cursor.getColumnIndexOrThrow("UltimaActualizacion");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final int _cursorIndexOfId_1 = _cursor.getColumnIndexOrThrow("Id");
          final List<CashIncomeDetailEntity> _result = new ArrayList<CashIncomeDetailEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final CashIncomeDetailEntity _item;
            _item = new CashIncomeDetailEntity();
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final Integer _tmpIdWayPay;
            if (_cursor.isNull(_cursorIndexOfIdWayPay)) {
              _tmpIdWayPay = null;
            } else {
              _tmpIdWayPay = _cursor.getInt(_cursorIndexOfIdWayPay);
            }
            _item.setIdWayPay(_tmpIdWayPay);
            final Integer _tmpIdIncome;
            if (_cursor.isNull(_cursorIndexOfIdIncome)) {
              _tmpIdIncome = null;
            } else {
              _tmpIdIncome = _cursor.getInt(_cursorIndexOfIdIncome);
            }
            _item.setIdIncome(_tmpIdIncome);
            final Double _tmpAmount;
            if (_cursor.isNull(_cursorIndexOfAmount)) {
              _tmpAmount = null;
            } else {
              _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            }
            _item.setAmount(_tmpAmount);
            final String _tmpLastDateSync;
            _tmpLastDateSync = _cursor.getString(_cursorIndexOfLastDateSync);
            _item.setLastDateSync(_tmpLastDateSync);
            final String _tmpUuid;
            _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            _item.setUuid(_tmpUuid);
            final Integer _tmpId_1;
            if (_cursor.isNull(_cursorIndexOfId_1)) {
              _tmpId_1 = null;
            } else {
              _tmpId_1 = _cursor.getInt(_cursorIndexOfId_1);
            }
            _item.setId(_tmpId_1);
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
