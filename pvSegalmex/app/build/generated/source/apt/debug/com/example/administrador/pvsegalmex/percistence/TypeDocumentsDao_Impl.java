package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.RxRoom;
import android.database.Cursor;
import com.example.administrador.pvsegalmex.entity.TypeDocumentsEntity;
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
public class TypeDocumentsDao_Impl implements TypeDocumentsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfTypeDocumentsEntity;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfTypeDocumentsEntity;

  public TypeDocumentsDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTypeDocumentsEntity = new EntityInsertionAdapter<TypeDocumentsEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `TipoDocumentoVta`(`Id`,`Descripcion`,`Consecutivo`,`Estus`,`Modulo`,`UUID`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TypeDocumentsEntity value) {
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
        stmt.bindLong(3, value.getConsecutive());
        stmt.bindLong(4, value.getStatus());
        if (value.getModule() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getModule());
        }
        if (value.getUuid() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getUuid());
        }
      }
    };
    this.__updateAdapterOfTypeDocumentsEntity = new EntityDeletionOrUpdateAdapter<TypeDocumentsEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `TipoDocumentoVta` SET `Id` = ?,`Descripcion` = ?,`Consecutivo` = ?,`Estus` = ?,`Modulo` = ?,`UUID` = ? WHERE `Id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TypeDocumentsEntity value) {
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
        stmt.bindLong(3, value.getConsecutive());
        stmt.bindLong(4, value.getStatus());
        if (value.getModule() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getModule());
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
  public Long insertTypeDocuments(TypeDocumentsEntity typeDocument) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfTypeDocumentsEntity.insertAndReturnId(typeDocument);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Long> insertTypeDocumentDefault(ArrayList<TypeDocumentsEntity> list) {
    __db.beginTransaction();
    try {
      List<Long> _result = __insertionAdapterOfTypeDocumentsEntity.insertAndReturnIdsList(list);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateTypeDocuments(TypeDocumentsEntity typeDocuments) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfTypeDocumentsEntity.handle(typeDocuments);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Flowable<List<TypeDocumentsEntity>> getFilterTypeDocuments(String description) {
    final String _sql = "SELECT * FROM TipoDocumentoVta t where t.Estus>-1 and t.Descripcion glob '*'||?||'*'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (description == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, description);
    }
    return RxRoom.createFlowable(__db, new String[]{"TipoDocumentoVta"}, new Callable<List<TypeDocumentsEntity>>() {
      @Override
      public List<TypeDocumentsEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfDescription = _cursor.getColumnIndexOrThrow("Descripcion");
          final int _cursorIndexOfConsecutive = _cursor.getColumnIndexOrThrow("Consecutivo");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estus");
          final int _cursorIndexOfModule = _cursor.getColumnIndexOrThrow("Modulo");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final List<TypeDocumentsEntity> _result = new ArrayList<TypeDocumentsEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final TypeDocumentsEntity _item;
            _item = new TypeDocumentsEntity();
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
            final int _tmpConsecutive;
            _tmpConsecutive = _cursor.getInt(_cursorIndexOfConsecutive);
            _item.setConsecutive(_tmpConsecutive);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
            final String _tmpModule;
            _tmpModule = _cursor.getString(_cursorIndexOfModule);
            _item.setModule(_tmpModule);
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
  public Flowable<List<TypeDocumentsEntity>> getFilterTypeDoc() {
    final String _sql = "SELECT * FROM TipoDocumentoVta t where t.Estus>-1 and t.Descripcion = 'VENTA'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"TipoDocumentoVta"}, new Callable<List<TypeDocumentsEntity>>() {
      @Override
      public List<TypeDocumentsEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfDescription = _cursor.getColumnIndexOrThrow("Descripcion");
          final int _cursorIndexOfConsecutive = _cursor.getColumnIndexOrThrow("Consecutivo");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estus");
          final int _cursorIndexOfModule = _cursor.getColumnIndexOrThrow("Modulo");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final List<TypeDocumentsEntity> _result = new ArrayList<TypeDocumentsEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final TypeDocumentsEntity _item;
            _item = new TypeDocumentsEntity();
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
            final int _tmpConsecutive;
            _tmpConsecutive = _cursor.getInt(_cursorIndexOfConsecutive);
            _item.setConsecutive(_tmpConsecutive);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
            final String _tmpModule;
            _tmpModule = _cursor.getString(_cursorIndexOfModule);
            _item.setModule(_tmpModule);
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
}
