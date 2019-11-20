package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.RxRoom;
import android.database.Cursor;
import com.example.administrador.pvsegalmex.entity.StoreEntity;
import io.reactivex.Flowable;
import java.lang.Boolean;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.concurrent.Callable;

@SuppressWarnings("unchecked")
public class StoreDao_Impl implements StoreDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfStoreEntity;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfStoreEntity;

  public StoreDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfStoreEntity = new EntityInsertionAdapter<StoreEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Tienda`(`Id`,`NumeroTelefono`,`NombreTienda`,`Longitud`,`Latitud`,`Direccion`,`Propietario`,`Imagen`,`Nombre`,`RFC`,`Regimen`,`Password`,`ArchivoCSD`,`ArchivoKey`,`Facturar`,`DireccionLocal`,`Estatus`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, StoreEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getPhonenumber() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPhonenumber());
        }
        if (value.getStoreName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getStoreName());
        }
        if (value.getLongitud() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindDouble(4, value.getLongitud());
        }
        if (value.getLatitud() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindDouble(5, value.getLatitud());
        }
        if (value.getDirection() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDirection());
        }
        if (value.getOwner() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getOwner());
        }
        if (value.getImage() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getImage());
        }
        if (value.getName() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getName());
        }
        if (value.getRfc() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getRfc());
        }
        if (value.getRegimen() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getRegimen());
        }
        if (value.getPassword() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getPassword());
        }
        final Integer _tmp;
        _tmp = value.getFileCsd() == null ? null : (value.getFileCsd() ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindLong(13, _tmp);
        }
        final Integer _tmp_1;
        _tmp_1 = value.getFileKey() == null ? null : (value.getFileKey() ? 1 : 0);
        if (_tmp_1 == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindLong(14, _tmp_1);
        }
        final Integer _tmp_2;
        _tmp_2 = value.getFacturar() == null ? null : (value.getFacturar() ? 1 : 0);
        if (_tmp_2 == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindLong(15, _tmp_2);
        }
        if (value.getLocalDirection() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getLocalDirection());
        }
        stmt.bindLong(17, value.getStatus());
      }
    };
    this.__updateAdapterOfStoreEntity = new EntityDeletionOrUpdateAdapter<StoreEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Tienda` SET `Id` = ?,`NumeroTelefono` = ?,`NombreTienda` = ?,`Longitud` = ?,`Latitud` = ?,`Direccion` = ?,`Propietario` = ?,`Imagen` = ?,`Nombre` = ?,`RFC` = ?,`Regimen` = ?,`Password` = ?,`ArchivoCSD` = ?,`ArchivoKey` = ?,`Facturar` = ?,`DireccionLocal` = ?,`Estatus` = ? WHERE `Id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, StoreEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getPhonenumber() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPhonenumber());
        }
        if (value.getStoreName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getStoreName());
        }
        if (value.getLongitud() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindDouble(4, value.getLongitud());
        }
        if (value.getLatitud() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindDouble(5, value.getLatitud());
        }
        if (value.getDirection() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDirection());
        }
        if (value.getOwner() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getOwner());
        }
        if (value.getImage() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getImage());
        }
        if (value.getName() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getName());
        }
        if (value.getRfc() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getRfc());
        }
        if (value.getRegimen() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getRegimen());
        }
        if (value.getPassword() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getPassword());
        }
        final Integer _tmp;
        _tmp = value.getFileCsd() == null ? null : (value.getFileCsd() ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindLong(13, _tmp);
        }
        final Integer _tmp_1;
        _tmp_1 = value.getFileKey() == null ? null : (value.getFileKey() ? 1 : 0);
        if (_tmp_1 == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindLong(14, _tmp_1);
        }
        final Integer _tmp_2;
        _tmp_2 = value.getFacturar() == null ? null : (value.getFacturar() ? 1 : 0);
        if (_tmp_2 == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindLong(15, _tmp_2);
        }
        if (value.getLocalDirection() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getLocalDirection());
        }
        stmt.bindLong(17, value.getStatus());
        if (value.getId() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindLong(18, value.getId());
        }
      }
    };
  }

  @Override
  public Long insertStore(StoreEntity store) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfStoreEntity.insertAndReturnId(store);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateStore(StoreEntity store) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfStoreEntity.handle(store);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Flowable<StoreEntity> getFilterStore() {
    final String _sql = "SELECT * FROM Tienda t where t.Estatus>-1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"Tienda"}, new Callable<StoreEntity>() {
      @Override
      public StoreEntity call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfPhonenumber = _cursor.getColumnIndexOrThrow("NumeroTelefono");
          final int _cursorIndexOfStoreName = _cursor.getColumnIndexOrThrow("NombreTienda");
          final int _cursorIndexOfLongitud = _cursor.getColumnIndexOrThrow("Longitud");
          final int _cursorIndexOfLatitud = _cursor.getColumnIndexOrThrow("Latitud");
          final int _cursorIndexOfDirection = _cursor.getColumnIndexOrThrow("Direccion");
          final int _cursorIndexOfOwner = _cursor.getColumnIndexOrThrow("Propietario");
          final int _cursorIndexOfImage = _cursor.getColumnIndexOrThrow("Imagen");
          final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("Nombre");
          final int _cursorIndexOfRfc = _cursor.getColumnIndexOrThrow("RFC");
          final int _cursorIndexOfRegimen = _cursor.getColumnIndexOrThrow("Regimen");
          final int _cursorIndexOfPassword = _cursor.getColumnIndexOrThrow("Password");
          final int _cursorIndexOfFileCsd = _cursor.getColumnIndexOrThrow("ArchivoCSD");
          final int _cursorIndexOfFileKey = _cursor.getColumnIndexOrThrow("ArchivoKey");
          final int _cursorIndexOfFacturar = _cursor.getColumnIndexOrThrow("Facturar");
          final int _cursorIndexOfLocalDirection = _cursor.getColumnIndexOrThrow("DireccionLocal");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final StoreEntity _result;
          if(_cursor.moveToFirst()) {
            _result = new StoreEntity();
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _result.setId(_tmpId);
            final String _tmpPhonenumber;
            _tmpPhonenumber = _cursor.getString(_cursorIndexOfPhonenumber);
            _result.setPhonenumber(_tmpPhonenumber);
            final String _tmpStoreName;
            _tmpStoreName = _cursor.getString(_cursorIndexOfStoreName);
            _result.setStoreName(_tmpStoreName);
            final Double _tmpLongitud;
            if (_cursor.isNull(_cursorIndexOfLongitud)) {
              _tmpLongitud = null;
            } else {
              _tmpLongitud = _cursor.getDouble(_cursorIndexOfLongitud);
            }
            _result.setLongitud(_tmpLongitud);
            final Double _tmpLatitud;
            if (_cursor.isNull(_cursorIndexOfLatitud)) {
              _tmpLatitud = null;
            } else {
              _tmpLatitud = _cursor.getDouble(_cursorIndexOfLatitud);
            }
            _result.setLatitud(_tmpLatitud);
            final String _tmpDirection;
            _tmpDirection = _cursor.getString(_cursorIndexOfDirection);
            _result.setDirection(_tmpDirection);
            final String _tmpOwner;
            _tmpOwner = _cursor.getString(_cursorIndexOfOwner);
            _result.setOwner(_tmpOwner);
            final String _tmpImage;
            _tmpImage = _cursor.getString(_cursorIndexOfImage);
            _result.setImage(_tmpImage);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            _result.setName(_tmpName);
            final String _tmpRfc;
            _tmpRfc = _cursor.getString(_cursorIndexOfRfc);
            _result.setRfc(_tmpRfc);
            final String _tmpRegimen;
            _tmpRegimen = _cursor.getString(_cursorIndexOfRegimen);
            _result.setRegimen(_tmpRegimen);
            final String _tmpPassword;
            _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
            _result.setPassword(_tmpPassword);
            final Boolean _tmpFileCsd;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfFileCsd)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfFileCsd);
            }
            _tmpFileCsd = _tmp == null ? null : _tmp != 0;
            _result.setFileCsd(_tmpFileCsd);
            final Boolean _tmpFileKey;
            final Integer _tmp_1;
            if (_cursor.isNull(_cursorIndexOfFileKey)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getInt(_cursorIndexOfFileKey);
            }
            _tmpFileKey = _tmp_1 == null ? null : _tmp_1 != 0;
            _result.setFileKey(_tmpFileKey);
            final Boolean _tmpFacturar;
            final Integer _tmp_2;
            if (_cursor.isNull(_cursorIndexOfFacturar)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getInt(_cursorIndexOfFacturar);
            }
            _tmpFacturar = _tmp_2 == null ? null : _tmp_2 != 0;
            _result.setFacturar(_tmpFacturar);
            final String _tmpLocalDirection;
            _tmpLocalDirection = _cursor.getString(_cursorIndexOfLocalDirection);
            _result.setLocalDirection(_tmpLocalDirection);
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
