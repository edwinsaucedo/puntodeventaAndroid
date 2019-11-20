package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.RxRoom;
import android.database.Cursor;
import com.example.administrador.pvsegalmex.entity.BitacoraEntity;
import io.reactivex.Flowable;
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
public class BitacoraDao_Impl implements BitacoraDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfBitacoraEntity;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfBitacoraEntity;

  public BitacoraDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBitacoraEntity = new EntityInsertionAdapter<BitacoraEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Bitacora`(`Id`,`Fecha`,`Estatus`,`Tabla`,`IdTabla`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BitacoraEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getDate() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDate());
        }
        stmt.bindLong(3, value.getStatus());
        if (value.getTable() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTable());
        }
        stmt.bindLong(5, value.getIdTable());
      }
    };
    this.__updateAdapterOfBitacoraEntity = new EntityDeletionOrUpdateAdapter<BitacoraEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Bitacora` SET `Id` = ?,`Fecha` = ?,`Estatus` = ?,`Tabla` = ?,`IdTabla` = ? WHERE `Id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BitacoraEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getDate() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDate());
        }
        stmt.bindLong(3, value.getStatus());
        if (value.getTable() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTable());
        }
        stmt.bindLong(5, value.getIdTable());
        if (value.getId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getId());
        }
      }
    };
  }

  @Override
  public Long insertBitacora(BitacoraEntity bitacoraEntity) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfBitacoraEntity.insertAndReturnId(bitacoraEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateBitacora(BitacoraEntity bitacoraEntity) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfBitacoraEntity.handle(bitacoraEntity);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Flowable<BitacoraEntity> getFilterBitacoraTable(String table) {
    final String _sql = "SELECT * FROM Bitacora i WHERE i.Tabla='*'||?||'*'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (table == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, table);
    }
    return RxRoom.createFlowable(__db, new String[]{"Bitacora"}, new Callable<BitacoraEntity>() {
      @Override
      public BitacoraEntity call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfTable = _cursor.getColumnIndexOrThrow("Tabla");
          final int _cursorIndexOfIdTable = _cursor.getColumnIndexOrThrow("IdTabla");
          final BitacoraEntity _result;
          if(_cursor.moveToFirst()) {
            _result = new BitacoraEntity();
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _result.setId(_tmpId);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            _result.setDate(_tmpDate);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            _result.setStatus(_tmpStatus);
            final String _tmpTable;
            _tmpTable = _cursor.getString(_cursorIndexOfTable);
            _result.setTable(_tmpTable);
            final int _tmpIdTable;
            _tmpIdTable = _cursor.getInt(_cursorIndexOfIdTable);
            _result.setIdTable(_tmpIdTable);
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

  @Override
  public Flowable<List<BitacoraEntity>> getFilterBitacora() {
    final String _sql = "SELECT * FROM Bitacora i";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"Bitacora"}, new Callable<List<BitacoraEntity>>() {
      @Override
      public List<BitacoraEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfTable = _cursor.getColumnIndexOrThrow("Tabla");
          final int _cursorIndexOfIdTable = _cursor.getColumnIndexOrThrow("IdTabla");
          final List<BitacoraEntity> _result = new ArrayList<BitacoraEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final BitacoraEntity _item;
            _item = new BitacoraEntity();
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            _item.setDate(_tmpDate);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
            final String _tmpTable;
            _tmpTable = _cursor.getString(_cursorIndexOfTable);
            _item.setTable(_tmpTable);
            final int _tmpIdTable;
            _tmpIdTable = _cursor.getInt(_cursorIndexOfIdTable);
            _item.setIdTable(_tmpIdTable);
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
