package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.RxRoom;
import android.database.Cursor;
import com.example.administrador.pvsegalmex.entity.UnitMeasurementEntity;
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
public class UnitMeasurementDao_Impl implements UnitMeasurementDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfUnitMeasurementEntity;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfUnitMeasurementEntity;

  public UnitMeasurementDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUnitMeasurementEntity = new EntityInsertionAdapter<UnitMeasurementEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `UnidadMedida`(`Id`,`Clave`,`Descripcion`,`ClaveSAT`,`UUID`,`UltimaActualizacion`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UnitMeasurementEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getKey() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getKey());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescription());
        }
        if (value.getKaySAT() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getKaySAT());
        }
        if (value.getUuid() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getUuid());
        }
        if (value.getLastDateSync() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getLastDateSync());
        }
      }
    };
    this.__updateAdapterOfUnitMeasurementEntity = new EntityDeletionOrUpdateAdapter<UnitMeasurementEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `UnidadMedida` SET `Id` = ?,`Clave` = ?,`Descripcion` = ?,`ClaveSAT` = ?,`UUID` = ?,`UltimaActualizacion` = ? WHERE `Id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UnitMeasurementEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getKey() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getKey());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescription());
        }
        if (value.getKaySAT() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getKaySAT());
        }
        if (value.getUuid() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getUuid());
        }
        if (value.getLastDateSync() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getLastDateSync());
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
  public Long insertUnitMeasurement(UnitMeasurementEntity unitMeasurementEntity) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfUnitMeasurementEntity.insertAndReturnId(unitMeasurementEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Long> insertUnitMeasurementDefault(ArrayList<UnitMeasurementEntity> unitMeasurementList) {
    __db.beginTransaction();
    try {
      List<Long> _result = __insertionAdapterOfUnitMeasurementEntity.insertAndReturnIdsList(unitMeasurementList);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateUnitMeasurement(UnitMeasurementEntity unitMeasurementEntity) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfUnitMeasurementEntity.handle(unitMeasurementEntity);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Flowable<List<UnitMeasurementEntity>> getUnitMeasurement() {
    final String _sql = "SELECT * FROM UnidadMedida u";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"UnidadMedida"}, new Callable<List<UnitMeasurementEntity>>() {
      @Override
      public List<UnitMeasurementEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfKey = _cursor.getColumnIndexOrThrow("Clave");
          final int _cursorIndexOfDescription = _cursor.getColumnIndexOrThrow("Descripcion");
          final int _cursorIndexOfKaySAT = _cursor.getColumnIndexOrThrow("ClaveSAT");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final int _cursorIndexOfLastDateSync = _cursor.getColumnIndexOrThrow("UltimaActualizacion");
          final List<UnitMeasurementEntity> _result = new ArrayList<UnitMeasurementEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final UnitMeasurementEntity _item;
            _item = new UnitMeasurementEntity();
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final String _tmpKey;
            _tmpKey = _cursor.getString(_cursorIndexOfKey);
            _item.setKey(_tmpKey);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            _item.setDescription(_tmpDescription);
            final String _tmpKaySAT;
            _tmpKaySAT = _cursor.getString(_cursorIndexOfKaySAT);
            _item.setKaySAT(_tmpKaySAT);
            final String _tmpUuid;
            _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            _item.setUuid(_tmpUuid);
            final String _tmpLastDateSync;
            _tmpLastDateSync = _cursor.getString(_cursorIndexOfLastDateSync);
            _item.setLastDateSync(_tmpLastDateSync);
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
  public int getCountUnitMeasure(String unitMeasureUUID) {
    final String _sql = "SELECT COUNT(*) FROM UnidadMedida u where u.UUID=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (unitMeasureUUID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, unitMeasureUUID);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
