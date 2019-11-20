package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.RxRoom;
import android.database.Cursor;
import com.example.administrador.pvsegalmex.entity.ExistEntity;
import com.example.administrador.pvsegalmex.pojo.ExistProductPojo;
import io.reactivex.Flowable;
import java.lang.Boolean;
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
public class ExistDao_Impl implements ExistDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfExistEntity;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfExistEntity;

  public ExistDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfExistEntity = new EntityInsertionAdapter<ExistEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Existencia`(`Id`,`Producto`,`Disponible`,`Transito`,`Existencia`,`Comprometida`,`Sicroniza`,`FechaActualizacion`,`UUID`,`Estatus`,`Fecha`,`UUIDProducto`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ExistEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getProduct() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getProduct());
        }
        if (value.getEnable() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindDouble(3, value.getEnable());
        }
        if (value.getTraffic() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindDouble(4, value.getTraffic());
        }
        if (value.getExist() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindDouble(5, value.getExist());
        }
        if (value.getCommitted() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindDouble(6, value.getCommitted());
        }
        final Integer _tmp;
        _tmp = value.getSynced() == null ? null : (value.getSynced() ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, _tmp);
        }
        if (value.getLastDate() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getLastDate());
        }
        if (value.getUuid() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getUuid());
        }
        stmt.bindLong(10, value.getStatus());
        if (value.getDate() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getDate());
        }
        if (value.getUuidProduct() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getUuidProduct());
        }
      }
    };
    this.__updateAdapterOfExistEntity = new EntityDeletionOrUpdateAdapter<ExistEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Existencia` SET `Id` = ?,`Producto` = ?,`Disponible` = ?,`Transito` = ?,`Existencia` = ?,`Comprometida` = ?,`Sicroniza` = ?,`FechaActualizacion` = ?,`UUID` = ?,`Estatus` = ?,`Fecha` = ?,`UUIDProducto` = ? WHERE `Id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ExistEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getProduct() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getProduct());
        }
        if (value.getEnable() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindDouble(3, value.getEnable());
        }
        if (value.getTraffic() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindDouble(4, value.getTraffic());
        }
        if (value.getExist() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindDouble(5, value.getExist());
        }
        if (value.getCommitted() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindDouble(6, value.getCommitted());
        }
        final Integer _tmp;
        _tmp = value.getSynced() == null ? null : (value.getSynced() ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, _tmp);
        }
        if (value.getLastDate() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getLastDate());
        }
        if (value.getUuid() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getUuid());
        }
        stmt.bindLong(10, value.getStatus());
        if (value.getDate() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getDate());
        }
        if (value.getUuidProduct() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getUuidProduct());
        }
        if (value.getId() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindLong(13, value.getId());
        }
      }
    };
  }

  @Override
  public Long insertExist(ExistEntity existEntity) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfExistEntity.insertAndReturnId(existEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateExist(ExistEntity existEntity) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfExistEntity.handle(existEntity);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Flowable<List<ExistEntity>> getFilterExist() {
    final String _sql = "SELECT * FROM Existencia e";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"Existencia"}, new Callable<List<ExistEntity>>() {
      @Override
      public List<ExistEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfProduct = _cursor.getColumnIndexOrThrow("Producto");
          final int _cursorIndexOfEnable = _cursor.getColumnIndexOrThrow("Disponible");
          final int _cursorIndexOfTraffic = _cursor.getColumnIndexOrThrow("Transito");
          final int _cursorIndexOfExist = _cursor.getColumnIndexOrThrow("Existencia");
          final int _cursorIndexOfCommitted = _cursor.getColumnIndexOrThrow("Comprometida");
          final int _cursorIndexOfSynced = _cursor.getColumnIndexOrThrow("Sicroniza");
          final int _cursorIndexOfLastDate = _cursor.getColumnIndexOrThrow("FechaActualizacion");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfUuidProduct = _cursor.getColumnIndexOrThrow("UUIDProducto");
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
            final Integer _tmpProduct;
            if (_cursor.isNull(_cursorIndexOfProduct)) {
              _tmpProduct = null;
            } else {
              _tmpProduct = _cursor.getInt(_cursorIndexOfProduct);
            }
            _item.setProduct(_tmpProduct);
            final Double _tmpEnable;
            if (_cursor.isNull(_cursorIndexOfEnable)) {
              _tmpEnable = null;
            } else {
              _tmpEnable = _cursor.getDouble(_cursorIndexOfEnable);
            }
            _item.setEnable(_tmpEnable);
            final Double _tmpTraffic;
            if (_cursor.isNull(_cursorIndexOfTraffic)) {
              _tmpTraffic = null;
            } else {
              _tmpTraffic = _cursor.getDouble(_cursorIndexOfTraffic);
            }
            _item.setTraffic(_tmpTraffic);
            final Double _tmpExist;
            if (_cursor.isNull(_cursorIndexOfExist)) {
              _tmpExist = null;
            } else {
              _tmpExist = _cursor.getDouble(_cursorIndexOfExist);
            }
            _item.setExist(_tmpExist);
            final Double _tmpCommitted;
            if (_cursor.isNull(_cursorIndexOfCommitted)) {
              _tmpCommitted = null;
            } else {
              _tmpCommitted = _cursor.getDouble(_cursorIndexOfCommitted);
            }
            _item.setCommitted(_tmpCommitted);
            final Boolean _tmpSynced;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfSynced)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfSynced);
            }
            _tmpSynced = _tmp == null ? null : _tmp != 0;
            _item.setSynced(_tmpSynced);
            final String _tmpLastDate;
            _tmpLastDate = _cursor.getString(_cursorIndexOfLastDate);
            _item.setLastDate(_tmpLastDate);
            final String _tmpUuid;
            _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            _item.setUuid(_tmpUuid);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            _item.setDate(_tmpDate);
            final String _tmpUuidProduct;
            _tmpUuidProduct = _cursor.getString(_cursorIndexOfUuidProduct);
            _item.setUuidProduct(_tmpUuidProduct);
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
  public Flowable<List<ExistProductPojo>> getFilterExistPojo() {
    final String _sql = "SELECT e.Existencia exist, e.Producto product, e.Id id, p.Id idproduct, p.Descripcion description FROM Existencia e INNER JOIN Productos p ON e.Producto=p.Id";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"Existencia","Productos"}, new Callable<List<ExistProductPojo>>() {
      @Override
      public List<ExistProductPojo> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfExist = _cursor.getColumnIndexOrThrow("exist");
          final int _cursorIndexOfProduct = _cursor.getColumnIndexOrThrow("product");
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfIdproduct = _cursor.getColumnIndexOrThrow("idproduct");
          final int _cursorIndexOfDescription = _cursor.getColumnIndexOrThrow("description");
          final List<ExistProductPojo> _result = new ArrayList<ExistProductPojo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ExistProductPojo _item;
            _item = new ExistProductPojo();
            final Double _tmpExist;
            if (_cursor.isNull(_cursorIndexOfExist)) {
              _tmpExist = null;
            } else {
              _tmpExist = _cursor.getDouble(_cursorIndexOfExist);
            }
            _item.setExist(_tmpExist);
            final Integer _tmpProduct;
            if (_cursor.isNull(_cursorIndexOfProduct)) {
              _tmpProduct = null;
            } else {
              _tmpProduct = _cursor.getInt(_cursorIndexOfProduct);
            }
            _item.setProduct(_tmpProduct);
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final Integer _tmpIdproduct;
            if (_cursor.isNull(_cursorIndexOfIdproduct)) {
              _tmpIdproduct = null;
            } else {
              _tmpIdproduct = _cursor.getInt(_cursorIndexOfIdproduct);
            }
            _item.setIdproduct(_tmpIdproduct);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            _item.setDescription(_tmpDescription);
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
  public Flowable<List<ExistEntity>> getRegisterExistSync() {
    final String _sql = "SELECT * FROM Existencia e INNER JOIN Bitacora b ON b.Tabla='Existencia' WHERE e.Fecha<=b.Fecha";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"Existencia","Bitacora"}, new Callable<List<ExistEntity>>() {
      @Override
      public List<ExistEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfProduct = _cursor.getColumnIndexOrThrow("Producto");
          final int _cursorIndexOfEnable = _cursor.getColumnIndexOrThrow("Disponible");
          final int _cursorIndexOfTraffic = _cursor.getColumnIndexOrThrow("Transito");
          final int _cursorIndexOfExist = _cursor.getColumnIndexOrThrow("Existencia");
          final int _cursorIndexOfCommitted = _cursor.getColumnIndexOrThrow("Comprometida");
          final int _cursorIndexOfSynced = _cursor.getColumnIndexOrThrow("Sicroniza");
          final int _cursorIndexOfLastDate = _cursor.getColumnIndexOrThrow("FechaActualizacion");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfUuidProduct = _cursor.getColumnIndexOrThrow("UUIDProducto");
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
            final Integer _tmpProduct;
            if (_cursor.isNull(_cursorIndexOfProduct)) {
              _tmpProduct = null;
            } else {
              _tmpProduct = _cursor.getInt(_cursorIndexOfProduct);
            }
            _item.setProduct(_tmpProduct);
            final Double _tmpEnable;
            if (_cursor.isNull(_cursorIndexOfEnable)) {
              _tmpEnable = null;
            } else {
              _tmpEnable = _cursor.getDouble(_cursorIndexOfEnable);
            }
            _item.setEnable(_tmpEnable);
            final Double _tmpTraffic;
            if (_cursor.isNull(_cursorIndexOfTraffic)) {
              _tmpTraffic = null;
            } else {
              _tmpTraffic = _cursor.getDouble(_cursorIndexOfTraffic);
            }
            _item.setTraffic(_tmpTraffic);
            final Double _tmpExist;
            if (_cursor.isNull(_cursorIndexOfExist)) {
              _tmpExist = null;
            } else {
              _tmpExist = _cursor.getDouble(_cursorIndexOfExist);
            }
            _item.setExist(_tmpExist);
            final Double _tmpCommitted;
            if (_cursor.isNull(_cursorIndexOfCommitted)) {
              _tmpCommitted = null;
            } else {
              _tmpCommitted = _cursor.getDouble(_cursorIndexOfCommitted);
            }
            _item.setCommitted(_tmpCommitted);
            final Boolean _tmpSynced;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfSynced)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfSynced);
            }
            _tmpSynced = _tmp == null ? null : _tmp != 0;
            _item.setSynced(_tmpSynced);
            final String _tmpLastDate;
            _tmpLastDate = _cursor.getString(_cursorIndexOfLastDate);
            _item.setLastDate(_tmpLastDate);
            final String _tmpUuid;
            _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            _item.setUuid(_tmpUuid);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            _item.setDate(_tmpDate);
            final String _tmpUuidProduct;
            _tmpUuidProduct = _cursor.getString(_cursorIndexOfUuidProduct);
            _item.setUuidProduct(_tmpUuidProduct);
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

  @Override
  public Flowable<List<ExistProductPojo>> getFilterExistProductPojo(String productDescription) {
    final String _sql = "SELECT e.Existencia exist, e.Producto product, e.Id id, p.Id idproduct, p.Descripcion description FROM Existencia e INNER JOIN Productos p ON e.Producto=p.Id WHERE p.Descripcion glob '*'||?||'*'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (productDescription == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, productDescription);
    }
    return RxRoom.createFlowable(__db, new String[]{"Existencia","Productos"}, new Callable<List<ExistProductPojo>>() {
      @Override
      public List<ExistProductPojo> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfExist = _cursor.getColumnIndexOrThrow("exist");
          final int _cursorIndexOfProduct = _cursor.getColumnIndexOrThrow("product");
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfIdproduct = _cursor.getColumnIndexOrThrow("idproduct");
          final int _cursorIndexOfDescription = _cursor.getColumnIndexOrThrow("description");
          final List<ExistProductPojo> _result = new ArrayList<ExistProductPojo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ExistProductPojo _item;
            _item = new ExistProductPojo();
            final Double _tmpExist;
            if (_cursor.isNull(_cursorIndexOfExist)) {
              _tmpExist = null;
            } else {
              _tmpExist = _cursor.getDouble(_cursorIndexOfExist);
            }
            _item.setExist(_tmpExist);
            final Integer _tmpProduct;
            if (_cursor.isNull(_cursorIndexOfProduct)) {
              _tmpProduct = null;
            } else {
              _tmpProduct = _cursor.getInt(_cursorIndexOfProduct);
            }
            _item.setProduct(_tmpProduct);
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final Integer _tmpIdproduct;
            if (_cursor.isNull(_cursorIndexOfIdproduct)) {
              _tmpIdproduct = null;
            } else {
              _tmpIdproduct = _cursor.getInt(_cursorIndexOfIdproduct);
            }
            _item.setIdproduct(_tmpIdproduct);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            _item.setDescription(_tmpDescription);
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
