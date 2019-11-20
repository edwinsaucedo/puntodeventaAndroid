package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.RxRoom;
import android.database.Cursor;
import com.example.administrador.pvsegalmex.entity.ProviderEntity;
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
public class ProviderDao_Impl implements ProviderDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfProviderEntity;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfProviderEntity;

  public ProviderDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfProviderEntity = new EntityInsertionAdapter<ProviderEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Proveedores`(`Id`,`Nombre`,`Rfc`,`FechaPago`,`Alias`,`Curp`,`Telefono`,`Email`,`Comentarios`,`LimiteCredito`,`DiasCredito`,`Diconsa`,`Estatus`,`UltimaActualizacion`,`UUID`,`Fecha`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ProviderEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getRfc() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getRfc());
        }
        if (value.getDatePay() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDatePay());
        }
        if (value.getAlias() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getAlias());
        }
        if (value.getCurp() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getCurp());
        }
        if (value.getPhone() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPhone());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getEmail());
        }
        if (value.getComments() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getComments());
        }
        stmt.bindDouble(10, value.getCreditLimit());
        stmt.bindLong(11, value.getCreditDays());
        final int _tmp;
        _tmp = value.isDiconsa() ? 1 : 0;
        stmt.bindLong(12, _tmp);
        stmt.bindLong(13, value.getStatus());
        if (value.getLastDateSync() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getLastDateSync());
        }
        if (value.getUuid() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getUuid());
        }
        if (value.getDate() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getDate());
        }
      }
    };
    this.__updateAdapterOfProviderEntity = new EntityDeletionOrUpdateAdapter<ProviderEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Proveedores` SET `Id` = ?,`Nombre` = ?,`Rfc` = ?,`FechaPago` = ?,`Alias` = ?,`Curp` = ?,`Telefono` = ?,`Email` = ?,`Comentarios` = ?,`LimiteCredito` = ?,`DiasCredito` = ?,`Diconsa` = ?,`Estatus` = ?,`UltimaActualizacion` = ?,`UUID` = ?,`Fecha` = ? WHERE `Id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ProviderEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getRfc() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getRfc());
        }
        if (value.getDatePay() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDatePay());
        }
        if (value.getAlias() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getAlias());
        }
        if (value.getCurp() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getCurp());
        }
        if (value.getPhone() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPhone());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getEmail());
        }
        if (value.getComments() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getComments());
        }
        stmt.bindDouble(10, value.getCreditLimit());
        stmt.bindLong(11, value.getCreditDays());
        final int _tmp;
        _tmp = value.isDiconsa() ? 1 : 0;
        stmt.bindLong(12, _tmp);
        stmt.bindLong(13, value.getStatus());
        if (value.getLastDateSync() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getLastDateSync());
        }
        if (value.getUuid() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getUuid());
        }
        if (value.getDate() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getDate());
        }
        if (value.getId() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindLong(17, value.getId());
        }
      }
    };
  }

  @Override
  public Long insertProvider(ProviderEntity provider) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfProviderEntity.insertAndReturnId(provider);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateProvider(ProviderEntity provider) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfProviderEntity.handle(provider);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Flowable<List<ProviderEntity>> getFilterProvider(String providerName) {
    final String _sql = "SELECT * FROM Proveedores p where p.Estatus>-1 and p.Nombre glob '*'||?||'*'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (providerName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, providerName);
    }
    return RxRoom.createFlowable(__db, new String[]{"Proveedores"}, new Callable<List<ProviderEntity>>() {
      @Override
      public List<ProviderEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("Nombre");
          final int _cursorIndexOfRfc = _cursor.getColumnIndexOrThrow("Rfc");
          final int _cursorIndexOfDatePay = _cursor.getColumnIndexOrThrow("FechaPago");
          final int _cursorIndexOfAlias = _cursor.getColumnIndexOrThrow("Alias");
          final int _cursorIndexOfCurp = _cursor.getColumnIndexOrThrow("Curp");
          final int _cursorIndexOfPhone = _cursor.getColumnIndexOrThrow("Telefono");
          final int _cursorIndexOfEmail = _cursor.getColumnIndexOrThrow("Email");
          final int _cursorIndexOfComments = _cursor.getColumnIndexOrThrow("Comentarios");
          final int _cursorIndexOfCreditLimit = _cursor.getColumnIndexOrThrow("LimiteCredito");
          final int _cursorIndexOfCreditDays = _cursor.getColumnIndexOrThrow("DiasCredito");
          final int _cursorIndexOfDiconsa = _cursor.getColumnIndexOrThrow("Diconsa");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfLastDateSync = _cursor.getColumnIndexOrThrow("UltimaActualizacion");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("Fecha");
          final List<ProviderEntity> _result = new ArrayList<ProviderEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ProviderEntity _item;
            _item = new ProviderEntity();
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            _item.setName(_tmpName);
            final String _tmpRfc;
            _tmpRfc = _cursor.getString(_cursorIndexOfRfc);
            _item.setRfc(_tmpRfc);
            final String _tmpDatePay;
            _tmpDatePay = _cursor.getString(_cursorIndexOfDatePay);
            _item.setDatePay(_tmpDatePay);
            final String _tmpAlias;
            _tmpAlias = _cursor.getString(_cursorIndexOfAlias);
            _item.setAlias(_tmpAlias);
            final String _tmpCurp;
            _tmpCurp = _cursor.getString(_cursorIndexOfCurp);
            _item.setCurp(_tmpCurp);
            final String _tmpPhone;
            _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            _item.setPhone(_tmpPhone);
            final String _tmpEmail;
            _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            _item.setEmail(_tmpEmail);
            final String _tmpComments;
            _tmpComments = _cursor.getString(_cursorIndexOfComments);
            _item.setComments(_tmpComments);
            final double _tmpCreditLimit;
            _tmpCreditLimit = _cursor.getDouble(_cursorIndexOfCreditLimit);
            _item.setCreditLimit(_tmpCreditLimit);
            final int _tmpCreditDays;
            _tmpCreditDays = _cursor.getInt(_cursorIndexOfCreditDays);
            _item.setCreditDays(_tmpCreditDays);
            final boolean _tmpDiconsa;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfDiconsa);
            _tmpDiconsa = _tmp != 0;
            _item.setDiconsa(_tmpDiconsa);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
            final String _tmpLastDateSync;
            _tmpLastDateSync = _cursor.getString(_cursorIndexOfLastDateSync);
            _item.setLastDateSync(_tmpLastDateSync);
            final String _tmpUuid;
            _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            _item.setUuid(_tmpUuid);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            _item.setDate(_tmpDate);
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
  public Flowable<List<ProviderEntity>> getFilterProviderReceiptMerchandise() {
    final String _sql = "SELECT * FROM Proveedores p where p.Estatus>-1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"Proveedores"}, new Callable<List<ProviderEntity>>() {
      @Override
      public List<ProviderEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("Nombre");
          final int _cursorIndexOfRfc = _cursor.getColumnIndexOrThrow("Rfc");
          final int _cursorIndexOfDatePay = _cursor.getColumnIndexOrThrow("FechaPago");
          final int _cursorIndexOfAlias = _cursor.getColumnIndexOrThrow("Alias");
          final int _cursorIndexOfCurp = _cursor.getColumnIndexOrThrow("Curp");
          final int _cursorIndexOfPhone = _cursor.getColumnIndexOrThrow("Telefono");
          final int _cursorIndexOfEmail = _cursor.getColumnIndexOrThrow("Email");
          final int _cursorIndexOfComments = _cursor.getColumnIndexOrThrow("Comentarios");
          final int _cursorIndexOfCreditLimit = _cursor.getColumnIndexOrThrow("LimiteCredito");
          final int _cursorIndexOfCreditDays = _cursor.getColumnIndexOrThrow("DiasCredito");
          final int _cursorIndexOfDiconsa = _cursor.getColumnIndexOrThrow("Diconsa");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfLastDateSync = _cursor.getColumnIndexOrThrow("UltimaActualizacion");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("Fecha");
          final List<ProviderEntity> _result = new ArrayList<ProviderEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ProviderEntity _item;
            _item = new ProviderEntity();
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            _item.setName(_tmpName);
            final String _tmpRfc;
            _tmpRfc = _cursor.getString(_cursorIndexOfRfc);
            _item.setRfc(_tmpRfc);
            final String _tmpDatePay;
            _tmpDatePay = _cursor.getString(_cursorIndexOfDatePay);
            _item.setDatePay(_tmpDatePay);
            final String _tmpAlias;
            _tmpAlias = _cursor.getString(_cursorIndexOfAlias);
            _item.setAlias(_tmpAlias);
            final String _tmpCurp;
            _tmpCurp = _cursor.getString(_cursorIndexOfCurp);
            _item.setCurp(_tmpCurp);
            final String _tmpPhone;
            _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            _item.setPhone(_tmpPhone);
            final String _tmpEmail;
            _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            _item.setEmail(_tmpEmail);
            final String _tmpComments;
            _tmpComments = _cursor.getString(_cursorIndexOfComments);
            _item.setComments(_tmpComments);
            final double _tmpCreditLimit;
            _tmpCreditLimit = _cursor.getDouble(_cursorIndexOfCreditLimit);
            _item.setCreditLimit(_tmpCreditLimit);
            final int _tmpCreditDays;
            _tmpCreditDays = _cursor.getInt(_cursorIndexOfCreditDays);
            _item.setCreditDays(_tmpCreditDays);
            final boolean _tmpDiconsa;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfDiconsa);
            _tmpDiconsa = _tmp != 0;
            _item.setDiconsa(_tmpDiconsa);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
            final String _tmpLastDateSync;
            _tmpLastDateSync = _cursor.getString(_cursorIndexOfLastDateSync);
            _item.setLastDateSync(_tmpLastDateSync);
            final String _tmpUuid;
            _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            _item.setUuid(_tmpUuid);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            _item.setDate(_tmpDate);
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
  public Flowable<List<ProviderEntity>> getRegisterReceiptOfMerchandiseDetailSync() {
    final String _sql = "SELECT * FROM Proveedores p INNER JOIN Bitacora b ON b.Tabla='Proveedores' WHERE p.Fecha<=b.Fecha";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"Proveedores","Bitacora"}, new Callable<List<ProviderEntity>>() {
      @Override
      public List<ProviderEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("Nombre");
          final int _cursorIndexOfRfc = _cursor.getColumnIndexOrThrow("Rfc");
          final int _cursorIndexOfDatePay = _cursor.getColumnIndexOrThrow("FechaPago");
          final int _cursorIndexOfAlias = _cursor.getColumnIndexOrThrow("Alias");
          final int _cursorIndexOfCurp = _cursor.getColumnIndexOrThrow("Curp");
          final int _cursorIndexOfPhone = _cursor.getColumnIndexOrThrow("Telefono");
          final int _cursorIndexOfEmail = _cursor.getColumnIndexOrThrow("Email");
          final int _cursorIndexOfComments = _cursor.getColumnIndexOrThrow("Comentarios");
          final int _cursorIndexOfCreditLimit = _cursor.getColumnIndexOrThrow("LimiteCredito");
          final int _cursorIndexOfCreditDays = _cursor.getColumnIndexOrThrow("DiasCredito");
          final int _cursorIndexOfDiconsa = _cursor.getColumnIndexOrThrow("Diconsa");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfLastDateSync = _cursor.getColumnIndexOrThrow("UltimaActualizacion");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfId_1 = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfDate_1 = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfStatus_1 = _cursor.getColumnIndexOrThrow("Estatus");
          final List<ProviderEntity> _result = new ArrayList<ProviderEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ProviderEntity _item;
            _item = new ProviderEntity();
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            _item.setName(_tmpName);
            final String _tmpRfc;
            _tmpRfc = _cursor.getString(_cursorIndexOfRfc);
            _item.setRfc(_tmpRfc);
            final String _tmpDatePay;
            _tmpDatePay = _cursor.getString(_cursorIndexOfDatePay);
            _item.setDatePay(_tmpDatePay);
            final String _tmpAlias;
            _tmpAlias = _cursor.getString(_cursorIndexOfAlias);
            _item.setAlias(_tmpAlias);
            final String _tmpCurp;
            _tmpCurp = _cursor.getString(_cursorIndexOfCurp);
            _item.setCurp(_tmpCurp);
            final String _tmpPhone;
            _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            _item.setPhone(_tmpPhone);
            final String _tmpEmail;
            _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            _item.setEmail(_tmpEmail);
            final String _tmpComments;
            _tmpComments = _cursor.getString(_cursorIndexOfComments);
            _item.setComments(_tmpComments);
            final double _tmpCreditLimit;
            _tmpCreditLimit = _cursor.getDouble(_cursorIndexOfCreditLimit);
            _item.setCreditLimit(_tmpCreditLimit);
            final int _tmpCreditDays;
            _tmpCreditDays = _cursor.getInt(_cursorIndexOfCreditDays);
            _item.setCreditDays(_tmpCreditDays);
            final boolean _tmpDiconsa;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfDiconsa);
            _tmpDiconsa = _tmp != 0;
            _item.setDiconsa(_tmpDiconsa);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
            final String _tmpLastDateSync;
            _tmpLastDateSync = _cursor.getString(_cursorIndexOfLastDateSync);
            _item.setLastDateSync(_tmpLastDateSync);
            final String _tmpUuid;
            _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            _item.setUuid(_tmpUuid);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            _item.setDate(_tmpDate);
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
