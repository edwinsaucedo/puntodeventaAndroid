package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.RxRoom;
import android.database.Cursor;
import com.example.administrador.pvsegalmex.entity.WayPayEntity;
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
public class WayPayDao_Impl implements WayPayDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfWayPayEntity;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfWayPayEntity;

  public WayPayDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfWayPayEntity = new EntityInsertionAdapter<WayPayEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `FormaPago`(`Id`,`Description`,`Image`,`Estus`,`UltimaActualizacion`,`UUID`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WayPayEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDescription());
        }
        if (value.getImage() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getImage());
        }
        stmt.bindLong(4, value.getStatus());
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
    this.__updateAdapterOfWayPayEntity = new EntityDeletionOrUpdateAdapter<WayPayEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `FormaPago` SET `Id` = ?,`Description` = ?,`Image` = ?,`Estus` = ?,`UltimaActualizacion` = ?,`UUID` = ? WHERE `Id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WayPayEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDescription());
        }
        if (value.getImage() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getImage());
        }
        stmt.bindLong(4, value.getStatus());
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
  public Long insertWayPay(WayPayEntity wayPay) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfWayPayEntity.insertAndReturnId(wayPay);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Long> insertWayPayDefault(ArrayList<WayPayEntity> wayPayList) {
    __db.beginTransaction();
    try {
      List<Long> _result = __insertionAdapterOfWayPayEntity.insertAndReturnIdsList(wayPayList);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateWayPay(WayPayEntity wayPay) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfWayPayEntity.handle(wayPay);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Flowable<List<WayPayEntity>> getFilterWayPay(String wayPayDescription) {
    final String _sql = "SELECT*FROM FormaPago w where w.Estus>-1 and w.Description glob '*'||?||'*'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (wayPayDescription == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, wayPayDescription);
    }
    return RxRoom.createFlowable(__db, new String[]{"FormaPago"}, new Callable<List<WayPayEntity>>() {
      @Override
      public List<WayPayEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfDescription = _cursor.getColumnIndexOrThrow("Description");
          final int _cursorIndexOfImage = _cursor.getColumnIndexOrThrow("Image");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estus");
          final int _cursorIndexOfLastDateSync = _cursor.getColumnIndexOrThrow("UltimaActualizacion");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final List<WayPayEntity> _result = new ArrayList<WayPayEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final WayPayEntity _item;
            _item = new WayPayEntity();
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            _item.setDescription(_tmpDescription);
            final String _tmpImage;
            _tmpImage = _cursor.getString(_cursorIndexOfImage);
            _item.setImage(_tmpImage);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
            final String _tmpLastDateSync;
            _tmpLastDateSync = _cursor.getString(_cursorIndexOfLastDateSync);
            _item.setLastDateSync(_tmpLastDateSync);
            final String _tmpUuid;
            _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            _item.setUuid(_tmpUuid);
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
  public Flowable<List<WayPayEntity>> getFilterWayPayinCashShort() {
    final String _sql = "SELECT*FROM FormaPago w where w.Estus>-1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"FormaPago"}, new Callable<List<WayPayEntity>>() {
      @Override
      public List<WayPayEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfDescription = _cursor.getColumnIndexOrThrow("Description");
          final int _cursorIndexOfImage = _cursor.getColumnIndexOrThrow("Image");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estus");
          final int _cursorIndexOfLastDateSync = _cursor.getColumnIndexOrThrow("UltimaActualizacion");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final List<WayPayEntity> _result = new ArrayList<WayPayEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final WayPayEntity _item;
            _item = new WayPayEntity();
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            _item.setDescription(_tmpDescription);
            final String _tmpImage;
            _tmpImage = _cursor.getString(_cursorIndexOfImage);
            _item.setImage(_tmpImage);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
            final String _tmpLastDateSync;
            _tmpLastDateSync = _cursor.getString(_cursorIndexOfLastDateSync);
            _item.setLastDateSync(_tmpLastDateSync);
            final String _tmpUuid;
            _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            _item.setUuid(_tmpUuid);
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
  public Flowable<List<WayPayEntity>> getUUIDWayPay(String wayPayUUID) {
    final String _sql = "SELECT*FROM FormaPago w where w.UUID=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (wayPayUUID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, wayPayUUID);
    }
    return RxRoom.createFlowable(__db, new String[]{"FormaPago"}, new Callable<List<WayPayEntity>>() {
      @Override
      public List<WayPayEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfDescription = _cursor.getColumnIndexOrThrow("Description");
          final int _cursorIndexOfImage = _cursor.getColumnIndexOrThrow("Image");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estus");
          final int _cursorIndexOfLastDateSync = _cursor.getColumnIndexOrThrow("UltimaActualizacion");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final List<WayPayEntity> _result = new ArrayList<WayPayEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final WayPayEntity _item;
            _item = new WayPayEntity();
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            _item.setDescription(_tmpDescription);
            final String _tmpImage;
            _tmpImage = _cursor.getString(_cursorIndexOfImage);
            _item.setImage(_tmpImage);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
            final String _tmpLastDateSync;
            _tmpLastDateSync = _cursor.getString(_cursorIndexOfLastDateSync);
            _item.setLastDateSync(_tmpLastDateSync);
            final String _tmpUuid;
            _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            _item.setUuid(_tmpUuid);
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
  public int getCountWayPay(String wayPayUUID) {
    final String _sql = "SELECT COUNT(*) FROM FormaPago w where w.UUID=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (wayPayUUID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, wayPayUUID);
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
