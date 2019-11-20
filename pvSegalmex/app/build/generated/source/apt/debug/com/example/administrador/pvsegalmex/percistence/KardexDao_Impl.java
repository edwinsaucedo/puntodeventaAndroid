package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.RxRoom;
import android.database.Cursor;
import com.example.administrador.pvsegalmex.entity.ExistEntity;
import com.example.administrador.pvsegalmex.entity.KardexEntity;
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
public class KardexDao_Impl implements KardexDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfKardexEntity;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfKardexEntity;

  public KardexDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfKardexEntity = new EntityInsertionAdapter<KardexEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Kardex`(`Id`,`TipoDocumento`,`NumeroDocumento`,`Fecha`,`Usuario`,`Estatus`,`UUID`,`UUIDTipoDocumento`,`UUIDUser`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, KardexEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getTypeDocument() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getTypeDocument());
        }
        if (value.getNumberDocument() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getNumberDocument());
        }
        if (value.getDate() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDate());
        }
        if (value.getUser() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getUser());
        }
        stmt.bindLong(6, value.getStatus());
        if (value.getUuid() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getUuid());
        }
        if (value.getUuidTypeDocument() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getUuidTypeDocument());
        }
        if (value.getUuidUser() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getUuidUser());
        }
      }
    };
    this.__updateAdapterOfKardexEntity = new EntityDeletionOrUpdateAdapter<KardexEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Kardex` SET `Id` = ?,`TipoDocumento` = ?,`NumeroDocumento` = ?,`Fecha` = ?,`Usuario` = ?,`Estatus` = ?,`UUID` = ?,`UUIDTipoDocumento` = ?,`UUIDUser` = ? WHERE `Id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, KardexEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getTypeDocument() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getTypeDocument());
        }
        if (value.getNumberDocument() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getNumberDocument());
        }
        if (value.getDate() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDate());
        }
        if (value.getUser() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getUser());
        }
        stmt.bindLong(6, value.getStatus());
        if (value.getUuid() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getUuid());
        }
        if (value.getUuidTypeDocument() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getUuidTypeDocument());
        }
        if (value.getUuidUser() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getUuidUser());
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
  public Long insertKardex(KardexEntity kardex) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfKardexEntity.insertAndReturnId(kardex);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateKardex(KardexEntity kardex) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfKardexEntity.handle(kardex);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Flowable<List<KardexEntity>> getFilterKardex() {
    final String _sql = "SELECT * FROM Kardex k where k.Estatus>-1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"Kardex"}, new Callable<List<KardexEntity>>() {
      @Override
      public List<KardexEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfTypeDocument = _cursor.getColumnIndexOrThrow("TipoDocumento");
          final int _cursorIndexOfNumberDocument = _cursor.getColumnIndexOrThrow("NumeroDocumento");
          final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfUser = _cursor.getColumnIndexOrThrow("Usuario");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final int _cursorIndexOfUuidTypeDocument = _cursor.getColumnIndexOrThrow("UUIDTipoDocumento");
          final int _cursorIndexOfUuidUser = _cursor.getColumnIndexOrThrow("UUIDUser");
          final List<KardexEntity> _result = new ArrayList<KardexEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final KardexEntity _item;
            _item = new KardexEntity();
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final Integer _tmpTypeDocument;
            if (_cursor.isNull(_cursorIndexOfTypeDocument)) {
              _tmpTypeDocument = null;
            } else {
              _tmpTypeDocument = _cursor.getInt(_cursorIndexOfTypeDocument);
            }
            _item.setTypeDocument(_tmpTypeDocument);
            final Integer _tmpNumberDocument;
            if (_cursor.isNull(_cursorIndexOfNumberDocument)) {
              _tmpNumberDocument = null;
            } else {
              _tmpNumberDocument = _cursor.getInt(_cursorIndexOfNumberDocument);
            }
            _item.setNumberDocument(_tmpNumberDocument);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            _item.setDate(_tmpDate);
            final Integer _tmpUser;
            if (_cursor.isNull(_cursorIndexOfUser)) {
              _tmpUser = null;
            } else {
              _tmpUser = _cursor.getInt(_cursorIndexOfUser);
            }
            _item.setUser(_tmpUser);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
            final String _tmpUuid;
            _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            _item.setUuid(_tmpUuid);
            final String _tmpUuidTypeDocument;
            _tmpUuidTypeDocument = _cursor.getString(_cursorIndexOfUuidTypeDocument);
            _item.setUuidTypeDocument(_tmpUuidTypeDocument);
            final String _tmpUuidUser;
            _tmpUuidUser = _cursor.getString(_cursorIndexOfUuidUser);
            _item.setUuidUser(_tmpUuidUser);
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
  public Flowable<List<ExistEntity>> getRegisterKardexSync() {
    final String _sql = "SELECT * FROM Kardex k INNER JOIN Bitacora b ON b.Tabla='Kardex' WHERE k.Fecha<=b.Fecha";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"Kardex","Bitacora"}, new Callable<List<ExistEntity>>() {
      @Override
      public List<ExistEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final int _cursorIndexOfId_1 = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfDate_1 = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfStatus_1 = _cursor.getColumnIndexOrThrow("Estatus");
          final List<ExistEntity> _result = new ArrayList<ExistEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ExistEntity _item;
            _item = new ExistEntity();
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
