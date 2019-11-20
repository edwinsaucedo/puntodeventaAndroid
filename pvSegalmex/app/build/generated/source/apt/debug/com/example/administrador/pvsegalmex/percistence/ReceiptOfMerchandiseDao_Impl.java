package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.RxRoom;
import android.database.Cursor;
import com.example.administrador.pvsegalmex.entity.ReceiptOfMerchandiseEntity;
import com.example.administrador.pvsegalmex.pojo.ReceiptMerchandiseProviderPojo;
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
public class ReceiptOfMerchandiseDao_Impl implements ReceiptOfMerchandiseDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfReceiptOfMerchandiseEntity;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfReceiptOfMerchandiseEntity;

  public ReceiptOfMerchandiseDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfReceiptOfMerchandiseEntity = new EntityInsertionAdapter<ReceiptOfMerchandiseEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `ReciboMercancia`(`Id`,`Diconsa`,`Fecha`,`Consecutivo`,`Articulos`,`Subtotal`,`Total`,`Folio`,`Comentario`,`Proveedor`,`Estatus`,`UUID`,`UUIDProveedor`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ReceiptOfMerchandiseEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        final int _tmp;
        _tmp = value.isDiconsa() ? 1 : 0;
        stmt.bindLong(2, _tmp);
        if (value.getDate() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDate());
        }
        stmt.bindLong(4, value.getConsecutive());
        stmt.bindLong(5, value.getArticles());
        if (value.getSubtotal() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindDouble(6, value.getSubtotal());
        }
        if (value.getTotal() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindDouble(7, value.getTotal());
        }
        if (value.getFolio() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getFolio());
        }
        if (value.getComment() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getComment());
        }
        if (value.getProvider() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getProvider());
        }
        stmt.bindLong(11, value.getStatus());
        if (value.getUuid() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getUuid());
        }
        if (value.getUuidProvider() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getUuidProvider());
        }
      }
    };
    this.__updateAdapterOfReceiptOfMerchandiseEntity = new EntityDeletionOrUpdateAdapter<ReceiptOfMerchandiseEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `ReciboMercancia` SET `Id` = ?,`Diconsa` = ?,`Fecha` = ?,`Consecutivo` = ?,`Articulos` = ?,`Subtotal` = ?,`Total` = ?,`Folio` = ?,`Comentario` = ?,`Proveedor` = ?,`Estatus` = ?,`UUID` = ?,`UUIDProveedor` = ? WHERE `Id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ReceiptOfMerchandiseEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        final int _tmp;
        _tmp = value.isDiconsa() ? 1 : 0;
        stmt.bindLong(2, _tmp);
        if (value.getDate() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDate());
        }
        stmt.bindLong(4, value.getConsecutive());
        stmt.bindLong(5, value.getArticles());
        if (value.getSubtotal() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindDouble(6, value.getSubtotal());
        }
        if (value.getTotal() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindDouble(7, value.getTotal());
        }
        if (value.getFolio() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getFolio());
        }
        if (value.getComment() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getComment());
        }
        if (value.getProvider() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getProvider());
        }
        stmt.bindLong(11, value.getStatus());
        if (value.getUuid() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getUuid());
        }
        if (value.getUuidProvider() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getUuidProvider());
        }
        if (value.getId() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindLong(14, value.getId());
        }
      }
    };
  }

  @Override
  public Long insertReceiptOfMerchandise(ReceiptOfMerchandiseEntity receiptOfMerchandise) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfReceiptOfMerchandiseEntity.insertAndReturnId(receiptOfMerchandise);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateReceiptOfMerchandise(ReceiptOfMerchandiseEntity receiptOfMerchandise) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfReceiptOfMerchandiseEntity.handle(receiptOfMerchandise);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Flowable<List<ReceiptMerchandiseProviderPojo>> getFilterReceiptOfMerchandise(String date) {
    final String _sql = "SELECT rm.Id id, rm.Estatus status, rm.Diconsa diconsa, rm.Fecha date, rm.Total total, rm.Articulos articles, rm.Comentario comment, rm.Proveedor provider, p.Id idProvider, p.Nombre name FROM ReciboMercancia rm, Proveedores p where rm.Proveedor=p.Id and rm.Estatus>-1 and rm.Fecha glob '*'||?||'*'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (date == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, date);
    }
    return RxRoom.createFlowable(__db, new String[]{"ReciboMercancia","Proveedores"}, new Callable<List<ReceiptMerchandiseProviderPojo>>() {
      @Override
      public List<ReceiptMerchandiseProviderPojo> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("status");
          final int _cursorIndexOfDiconsa = _cursor.getColumnIndexOrThrow("diconsa");
          final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("date");
          final int _cursorIndexOfTotal = _cursor.getColumnIndexOrThrow("total");
          final int _cursorIndexOfArticles = _cursor.getColumnIndexOrThrow("articles");
          final int _cursorIndexOfComment = _cursor.getColumnIndexOrThrow("comment");
          final int _cursorIndexOfProvider = _cursor.getColumnIndexOrThrow("provider");
          final int _cursorIndexOfIdProvider = _cursor.getColumnIndexOrThrow("idProvider");
          final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
          final List<ReceiptMerchandiseProviderPojo> _result = new ArrayList<ReceiptMerchandiseProviderPojo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ReceiptMerchandiseProviderPojo _item;
            _item = new ReceiptMerchandiseProviderPojo();
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            _item.setId(_tmpId);
            final String _tmpStatus;
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
            final String _tmpDiconsa;
            _tmpDiconsa = _cursor.getString(_cursorIndexOfDiconsa);
            _item.setDiconsa(_tmpDiconsa);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            _item.setDate(_tmpDate);
            final String _tmpTotal;
            _tmpTotal = _cursor.getString(_cursorIndexOfTotal);
            _item.setTotal(_tmpTotal);
            final String _tmpArticles;
            _tmpArticles = _cursor.getString(_cursorIndexOfArticles);
            _item.setArticles(_tmpArticles);
            final String _tmpComment;
            _tmpComment = _cursor.getString(_cursorIndexOfComment);
            _item.setComment(_tmpComment);
            final String _tmpProvider;
            _tmpProvider = _cursor.getString(_cursorIndexOfProvider);
            _item.setProvider(_tmpProvider);
            final String _tmpIdProvider;
            _tmpIdProvider = _cursor.getString(_cursorIndexOfIdProvider);
            _item.setIdProvider(_tmpIdProvider);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            _item.setName(_tmpName);
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
  public Flowable<List<ReceiptOfMerchandiseEntity>> getFilter() {
    final String _sql = "SELECT*FROM ReciboMercancia d where d.Estatus>-1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"ReciboMercancia"}, new Callable<List<ReceiptOfMerchandiseEntity>>() {
      @Override
      public List<ReceiptOfMerchandiseEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfDiconsa = _cursor.getColumnIndexOrThrow("Diconsa");
          final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfConsecutive = _cursor.getColumnIndexOrThrow("Consecutivo");
          final int _cursorIndexOfArticles = _cursor.getColumnIndexOrThrow("Articulos");
          final int _cursorIndexOfSubtotal = _cursor.getColumnIndexOrThrow("Subtotal");
          final int _cursorIndexOfTotal = _cursor.getColumnIndexOrThrow("Total");
          final int _cursorIndexOfFolio = _cursor.getColumnIndexOrThrow("Folio");
          final int _cursorIndexOfComment = _cursor.getColumnIndexOrThrow("Comentario");
          final int _cursorIndexOfProvider = _cursor.getColumnIndexOrThrow("Proveedor");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final int _cursorIndexOfUuidProvider = _cursor.getColumnIndexOrThrow("UUIDProveedor");
          final List<ReceiptOfMerchandiseEntity> _result = new ArrayList<ReceiptOfMerchandiseEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ReceiptOfMerchandiseEntity _item;
            _item = new ReceiptOfMerchandiseEntity();
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final boolean _tmpDiconsa;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfDiconsa);
            _tmpDiconsa = _tmp != 0;
            _item.setDiconsa(_tmpDiconsa);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            _item.setDate(_tmpDate);
            final int _tmpConsecutive;
            _tmpConsecutive = _cursor.getInt(_cursorIndexOfConsecutive);
            _item.setConsecutive(_tmpConsecutive);
            final int _tmpArticles;
            _tmpArticles = _cursor.getInt(_cursorIndexOfArticles);
            _item.setArticles(_tmpArticles);
            final Double _tmpSubtotal;
            if (_cursor.isNull(_cursorIndexOfSubtotal)) {
              _tmpSubtotal = null;
            } else {
              _tmpSubtotal = _cursor.getDouble(_cursorIndexOfSubtotal);
            }
            _item.setSubtotal(_tmpSubtotal);
            final Double _tmpTotal;
            if (_cursor.isNull(_cursorIndexOfTotal)) {
              _tmpTotal = null;
            } else {
              _tmpTotal = _cursor.getDouble(_cursorIndexOfTotal);
            }
            _item.setTotal(_tmpTotal);
            final String _tmpFolio;
            _tmpFolio = _cursor.getString(_cursorIndexOfFolio);
            _item.setFolio(_tmpFolio);
            final String _tmpComment;
            _tmpComment = _cursor.getString(_cursorIndexOfComment);
            _item.setComment(_tmpComment);
            final Integer _tmpProvider;
            if (_cursor.isNull(_cursorIndexOfProvider)) {
              _tmpProvider = null;
            } else {
              _tmpProvider = _cursor.getInt(_cursorIndexOfProvider);
            }
            _item.setProvider(_tmpProvider);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
            final String _tmpUuid;
            _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            _item.setUuid(_tmpUuid);
            final String _tmpUuidProvider;
            _tmpUuidProvider = _cursor.getString(_cursorIndexOfUuidProvider);
            _item.setUuidProvider(_tmpUuidProvider);
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
  public Flowable<List<ReceiptOfMerchandiseEntity>> getRegisterReceiptOfMerchandiseDetailSync() {
    final String _sql = "SELECT * FROM ReciboMercancia r INNER JOIN Bitacora b ON b.Tabla='ReciboMercancia' WHERE r.Fecha<=b.Fecha";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"ReciboMercancia","Bitacora"}, new Callable<List<ReceiptOfMerchandiseEntity>>() {
      @Override
      public List<ReceiptOfMerchandiseEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfDiconsa = _cursor.getColumnIndexOrThrow("Diconsa");
          final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfConsecutive = _cursor.getColumnIndexOrThrow("Consecutivo");
          final int _cursorIndexOfArticles = _cursor.getColumnIndexOrThrow("Articulos");
          final int _cursorIndexOfSubtotal = _cursor.getColumnIndexOrThrow("Subtotal");
          final int _cursorIndexOfTotal = _cursor.getColumnIndexOrThrow("Total");
          final int _cursorIndexOfFolio = _cursor.getColumnIndexOrThrow("Folio");
          final int _cursorIndexOfComment = _cursor.getColumnIndexOrThrow("Comentario");
          final int _cursorIndexOfProvider = _cursor.getColumnIndexOrThrow("Proveedor");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final int _cursorIndexOfUuidProvider = _cursor.getColumnIndexOrThrow("UUIDProveedor");
          final int _cursorIndexOfId_1 = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfDate_1 = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfStatus_1 = _cursor.getColumnIndexOrThrow("Estatus");
          final List<ReceiptOfMerchandiseEntity> _result = new ArrayList<ReceiptOfMerchandiseEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ReceiptOfMerchandiseEntity _item;
            _item = new ReceiptOfMerchandiseEntity();
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final boolean _tmpDiconsa;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfDiconsa);
            _tmpDiconsa = _tmp != 0;
            _item.setDiconsa(_tmpDiconsa);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            _item.setDate(_tmpDate);
            final int _tmpConsecutive;
            _tmpConsecutive = _cursor.getInt(_cursorIndexOfConsecutive);
            _item.setConsecutive(_tmpConsecutive);
            final int _tmpArticles;
            _tmpArticles = _cursor.getInt(_cursorIndexOfArticles);
            _item.setArticles(_tmpArticles);
            final Double _tmpSubtotal;
            if (_cursor.isNull(_cursorIndexOfSubtotal)) {
              _tmpSubtotal = null;
            } else {
              _tmpSubtotal = _cursor.getDouble(_cursorIndexOfSubtotal);
            }
            _item.setSubtotal(_tmpSubtotal);
            final Double _tmpTotal;
            if (_cursor.isNull(_cursorIndexOfTotal)) {
              _tmpTotal = null;
            } else {
              _tmpTotal = _cursor.getDouble(_cursorIndexOfTotal);
            }
            _item.setTotal(_tmpTotal);
            final String _tmpFolio;
            _tmpFolio = _cursor.getString(_cursorIndexOfFolio);
            _item.setFolio(_tmpFolio);
            final String _tmpComment;
            _tmpComment = _cursor.getString(_cursorIndexOfComment);
            _item.setComment(_tmpComment);
            final Integer _tmpProvider;
            if (_cursor.isNull(_cursorIndexOfProvider)) {
              _tmpProvider = null;
            } else {
              _tmpProvider = _cursor.getInt(_cursorIndexOfProvider);
            }
            _item.setProvider(_tmpProvider);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
            final String _tmpUuid;
            _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            _item.setUuid(_tmpUuid);
            final String _tmpUuidProvider;
            _tmpUuidProvider = _cursor.getString(_cursorIndexOfUuidProvider);
            _item.setUuidProvider(_tmpUuidProvider);
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
