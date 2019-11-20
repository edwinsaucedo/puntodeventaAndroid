package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.RxRoom;
import android.database.Cursor;
import com.example.administrador.pvsegalmex.entity.DepartmentEntity;
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
public class DepartmentDao_Impl implements DepartmentDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfDepartmentEntity;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfDepartmentEntity;

  public DepartmentDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfDepartmentEntity = new EntityInsertionAdapter<DepartmentEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Departamentos`(`Id`,`Descripcion`,`Estatus`,`UUID`,`UltimaActualizacion`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DepartmentEntity value) {
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
        stmt.bindLong(3, value.getStatus());
        if (value.getUuid() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getUuid());
        }
        if (value.getLastDateSync() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLastDateSync());
        }
      }
    };
    this.__updateAdapterOfDepartmentEntity = new EntityDeletionOrUpdateAdapter<DepartmentEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Departamentos` SET `Id` = ?,`Descripcion` = ?,`Estatus` = ?,`UUID` = ?,`UltimaActualizacion` = ? WHERE `Id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DepartmentEntity value) {
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
        stmt.bindLong(3, value.getStatus());
        if (value.getUuid() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getUuid());
        }
        if (value.getLastDateSync() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLastDateSync());
        }
        if (value.getId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getId());
        }
      }
    };
  }

  @Override
  public Long insertDepartamento(DepartmentEntity departamento) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfDepartmentEntity.insertAndReturnId(departamento);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Long> insertDepartmentDefault(ArrayList<DepartmentEntity> departmentList) {
    __db.beginTransaction();
    try {
      List<Long> _result = __insertionAdapterOfDepartmentEntity.insertAndReturnIdsList(departmentList);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateDepartamento(DepartmentEntity departamento) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfDepartmentEntity.handle(departamento);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Flowable<List<DepartmentEntity>> getFilterDepartamentos(String description) {
    final String _sql = "SELECT*FROM Departamentos d where d.Estatus>-1 and d.Descripcion glob '*'||?||'*' ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (description == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, description);
    }
    return RxRoom.createFlowable(__db, new String[]{"Departamentos"}, new Callable<List<DepartmentEntity>>() {
      @Override
      public List<DepartmentEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfDescription = _cursor.getColumnIndexOrThrow("Descripcion");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final int _cursorIndexOfLastDateSync = _cursor.getColumnIndexOrThrow("UltimaActualizacion");
          final List<DepartmentEntity> _result = new ArrayList<DepartmentEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DepartmentEntity _item;
            _item = new DepartmentEntity();
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
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
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
  public Flowable<List<DepartmentEntity>> getFilterCategory() {
    final String _sql = "SELECT*FROM Departamentos d where d.Estatus>-1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"Departamentos"}, new Callable<List<DepartmentEntity>>() {
      @Override
      public List<DepartmentEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfDescription = _cursor.getColumnIndexOrThrow("Descripcion");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final int _cursorIndexOfLastDateSync = _cursor.getColumnIndexOrThrow("UltimaActualizacion");
          final List<DepartmentEntity> _result = new ArrayList<DepartmentEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DepartmentEntity _item;
            _item = new DepartmentEntity();
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
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
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
  public int getCountDepartment(String departmentUUID) {
    final String _sql = "SELECT COUNT(*) FROM Departamentos d where d.UUID=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (departmentUUID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, departmentUUID);
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
