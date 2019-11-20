package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.RxRoom;
import android.database.Cursor;
import com.example.administrador.pvsegalmex.entity.CashRegisterEntity;
import io.reactivex.Flowable;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.concurrent.Callable;

@SuppressWarnings("unchecked")
public class CashRegisterDao_Impl implements CashRegisterDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfCashRegisterEntity;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfCashRegisterEntity;

  public CashRegisterDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCashRegisterEntity = new EntityInsertionAdapter<CashRegisterEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `CajaRegistradora`(`Id`,`TotalVentas`,`TotalRetiros`,`TotalIngresos`,`TotalCaja`,`Estatus`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CashRegisterEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getTotalSale() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindDouble(2, value.getTotalSale());
        }
        if (value.getTotalWithdrawal() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindDouble(3, value.getTotalWithdrawal());
        }
        if (value.getTotalIncome() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindDouble(4, value.getTotalIncome());
        }
        if (value.getTotalCashRegister() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindDouble(5, value.getTotalCashRegister());
        }
        stmt.bindLong(6, value.getStatus());
      }
    };
    this.__updateAdapterOfCashRegisterEntity = new EntityDeletionOrUpdateAdapter<CashRegisterEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `CajaRegistradora` SET `Id` = ?,`TotalVentas` = ?,`TotalRetiros` = ?,`TotalIngresos` = ?,`TotalCaja` = ?,`Estatus` = ? WHERE `Id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CashRegisterEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getTotalSale() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindDouble(2, value.getTotalSale());
        }
        if (value.getTotalWithdrawal() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindDouble(3, value.getTotalWithdrawal());
        }
        if (value.getTotalIncome() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindDouble(4, value.getTotalIncome());
        }
        if (value.getTotalCashRegister() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindDouble(5, value.getTotalCashRegister());
        }
        stmt.bindLong(6, value.getStatus());
        if (value.getId() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getId());
        }
      }
    };
  }

  @Override
  public Long insertCashRegister(CashRegisterEntity cashRegisterEntity) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfCashRegisterEntity.insertAndReturnId(cashRegisterEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateCashRester(CashRegisterEntity cashRegisterEntity) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfCashRegisterEntity.handle(cashRegisterEntity);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Flowable<CashRegisterEntity> getFilterCashRegister() {
    final String _sql = "SELECT * FROM CajaRegistradora c where c.Estatus>-1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"CajaRegistradora"}, new Callable<CashRegisterEntity>() {
      @Override
      public CashRegisterEntity call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfTotalSale = _cursor.getColumnIndexOrThrow("TotalVentas");
          final int _cursorIndexOfTotalWithdrawal = _cursor.getColumnIndexOrThrow("TotalRetiros");
          final int _cursorIndexOfTotalIncome = _cursor.getColumnIndexOrThrow("TotalIngresos");
          final int _cursorIndexOfTotalCashRegister = _cursor.getColumnIndexOrThrow("TotalCaja");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final CashRegisterEntity _result;
          if(_cursor.moveToFirst()) {
            _result = new CashRegisterEntity();
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _result.setId(_tmpId);
            final Double _tmpTotalSale;
            if (_cursor.isNull(_cursorIndexOfTotalSale)) {
              _tmpTotalSale = null;
            } else {
              _tmpTotalSale = _cursor.getDouble(_cursorIndexOfTotalSale);
            }
            _result.setTotalSale(_tmpTotalSale);
            final Double _tmpTotalWithdrawal;
            if (_cursor.isNull(_cursorIndexOfTotalWithdrawal)) {
              _tmpTotalWithdrawal = null;
            } else {
              _tmpTotalWithdrawal = _cursor.getDouble(_cursorIndexOfTotalWithdrawal);
            }
            _result.setTotalWithdrawal(_tmpTotalWithdrawal);
            final Double _tmpTotalIncome;
            if (_cursor.isNull(_cursorIndexOfTotalIncome)) {
              _tmpTotalIncome = null;
            } else {
              _tmpTotalIncome = _cursor.getDouble(_cursorIndexOfTotalIncome);
            }
            _result.setTotalIncome(_tmpTotalIncome);
            final Double _tmpTotalCashRegister;
            if (_cursor.isNull(_cursorIndexOfTotalCashRegister)) {
              _tmpTotalCashRegister = null;
            } else {
              _tmpTotalCashRegister = _cursor.getDouble(_cursorIndexOfTotalCashRegister);
            }
            _result.setTotalCashRegister(_tmpTotalCashRegister);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            _result.setStatus(_tmpStatus);
          } else {
            _result = null;
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
