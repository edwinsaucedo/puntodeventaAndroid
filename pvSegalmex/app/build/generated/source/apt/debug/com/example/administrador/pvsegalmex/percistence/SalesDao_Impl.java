package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.RxRoom;
import android.database.Cursor;
import com.example.administrador.pvsegalmex.entity.SalesEntity;
import com.example.administrador.pvsegalmex.pojo.SalesClientPojo;
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
public class SalesDao_Impl implements SalesDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfSalesEntity;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfSalesEntity;

  public SalesDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSalesEntity = new EntityInsertionAdapter<SalesEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Venta`(`Id`,`Fecha`,`NoArticles`,`Total`,`Estatus`,`FormaPago`,`TipoDocumentoVta`,`Cliente`,`EstatusVenta`,`CorteCaja`,`DocumentFolio`,`UUID`,`UUIDCorteCaja`,`UUIDTipoDocumento`,`UUIDCliente`,`UUIDWayPay`,`Monto_Utilidad`,`Porcentaje_Utilidad`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SalesEntity value) {
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
        stmt.bindLong(3, value.getNoAticles());
        if (value.getTotal() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindDouble(4, value.getTotal());
        }
        stmt.bindLong(5, value.getStatus());
        if (value.getWayPay() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getWayPay());
        }
        if (value.getTypeDocumentVta() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getTypeDocumentVta());
        }
        if (value.getClient() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.getClient());
        }
        if (value.getSalesStatus() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getSalesStatus());
        }
        if (value.getCashShort() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getCashShort());
        }
        stmt.bindLong(11, value.getDocumentFolio());
        if (value.getUuid() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getUuid());
        }
        if (value.getUuidCashShort() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getUuidCashShort());
        }
        if (value.getUuidTypeDocument() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getUuidTypeDocument());
        }
        if (value.getUuidClient() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getUuidClient());
        }
        if (value.getUuidWayPay() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getUuidWayPay());
        }
        if (value.getUtilityAmount() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindDouble(17, value.getUtilityAmount());
        }
        if (value.getUtilityPercentage() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindDouble(18, value.getUtilityPercentage());
        }
      }
    };
    this.__updateAdapterOfSalesEntity = new EntityDeletionOrUpdateAdapter<SalesEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Venta` SET `Id` = ?,`Fecha` = ?,`NoArticles` = ?,`Total` = ?,`Estatus` = ?,`FormaPago` = ?,`TipoDocumentoVta` = ?,`Cliente` = ?,`EstatusVenta` = ?,`CorteCaja` = ?,`DocumentFolio` = ?,`UUID` = ?,`UUIDCorteCaja` = ?,`UUIDTipoDocumento` = ?,`UUIDCliente` = ?,`UUIDWayPay` = ?,`Monto_Utilidad` = ?,`Porcentaje_Utilidad` = ? WHERE `Id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SalesEntity value) {
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
        stmt.bindLong(3, value.getNoAticles());
        if (value.getTotal() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindDouble(4, value.getTotal());
        }
        stmt.bindLong(5, value.getStatus());
        if (value.getWayPay() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getWayPay());
        }
        if (value.getTypeDocumentVta() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getTypeDocumentVta());
        }
        if (value.getClient() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.getClient());
        }
        if (value.getSalesStatus() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getSalesStatus());
        }
        if (value.getCashShort() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getCashShort());
        }
        stmt.bindLong(11, value.getDocumentFolio());
        if (value.getUuid() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getUuid());
        }
        if (value.getUuidCashShort() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getUuidCashShort());
        }
        if (value.getUuidTypeDocument() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getUuidTypeDocument());
        }
        if (value.getUuidClient() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getUuidClient());
        }
        if (value.getUuidWayPay() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getUuidWayPay());
        }
        if (value.getUtilityAmount() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindDouble(17, value.getUtilityAmount());
        }
        if (value.getUtilityPercentage() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindDouble(18, value.getUtilityPercentage());
        }
        if (value.getId() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindLong(19, value.getId());
        }
      }
    };
  }

  @Override
  public Long insertSales(SalesEntity sales) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfSalesEntity.insertAndReturnId(sales);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateSales(SalesEntity sales) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfSalesEntity.handle(sales);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Flowable<List<SalesClientPojo>> getFilterSale(String saleDate) {
    final String _sql = "SELECT w.Description wayPay,v.Fecha date,v.EstatusVenta status ,v.Porcentaje_Utilidad utilityPercentage, v.Monto_Utilidad utilityAmount ,v.TipoDocumentoVta idTypeDocument , v.Total amount,v.Id idSale, c.Id idClient,(c.Nombre||' '||c.ApellidoPaterno||' '||c.ApellidoMaterno)client FROM Venta v INNER JOIN Cliente c ON v.Cliente=c.Id INNER JOIN FormaPago w ON v.FormaPago=w.Id where v.EstatusVenta = 'CERRADA' and v.Estatus>-1 and v.Fecha glob '*'||?||'*'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (saleDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, saleDate);
    }
    return RxRoom.createFlowable(__db, new String[]{"Venta","Cliente","FormaPago"}, new Callable<List<SalesClientPojo>>() {
      @Override
      public List<SalesClientPojo> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfWayPay = _cursor.getColumnIndexOrThrow("wayPay");
          final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("date");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("status");
          final int _cursorIndexOfUtilityPercentage = _cursor.getColumnIndexOrThrow("utilityPercentage");
          final int _cursorIndexOfUtilityAmount = _cursor.getColumnIndexOrThrow("utilityAmount");
          final int _cursorIndexOfIdTypeDocument = _cursor.getColumnIndexOrThrow("idTypeDocument");
          final int _cursorIndexOfAmount = _cursor.getColumnIndexOrThrow("amount");
          final int _cursorIndexOfIdSale = _cursor.getColumnIndexOrThrow("idSale");
          final int _cursorIndexOfIdClient = _cursor.getColumnIndexOrThrow("idClient");
          final int _cursorIndexOfClient = _cursor.getColumnIndexOrThrow("client");
          final List<SalesClientPojo> _result = new ArrayList<SalesClientPojo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final SalesClientPojo _item;
            _item = new SalesClientPojo();
            final String _tmpWayPay;
            _tmpWayPay = _cursor.getString(_cursorIndexOfWayPay);
            _item.setWayPay(_tmpWayPay);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            _item.setDate(_tmpDate);
            final String _tmpStatus;
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
            final String _tmpUtilityPercentage;
            _tmpUtilityPercentage = _cursor.getString(_cursorIndexOfUtilityPercentage);
            _item.setUtilityPercentage(_tmpUtilityPercentage);
            final String _tmpUtilityAmount;
            _tmpUtilityAmount = _cursor.getString(_cursorIndexOfUtilityAmount);
            _item.setUtilityAmount(_tmpUtilityAmount);
            final String _tmpIdTypeDocument;
            _tmpIdTypeDocument = _cursor.getString(_cursorIndexOfIdTypeDocument);
            _item.setIdTypeDocument(_tmpIdTypeDocument);
            final String _tmpAmount;
            _tmpAmount = _cursor.getString(_cursorIndexOfAmount);
            _item.setAmount(_tmpAmount);
            final String _tmpIdSale;
            _tmpIdSale = _cursor.getString(_cursorIndexOfIdSale);
            _item.setIdSale(_tmpIdSale);
            final String _tmpIdClient;
            _tmpIdClient = _cursor.getString(_cursorIndexOfIdClient);
            _item.setIdClient(_tmpIdClient);
            final String _tmpClient;
            _tmpClient = _cursor.getString(_cursorIndexOfClient);
            _item.setClient(_tmpClient);
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
  public Flowable<List<SalesEntity>> getFilterSaleIncomplete() {
    final String _sql = "SELECT * FROM Venta v where v.EstatusVenta = 'ABIERTA' and v.Estatus>-1 ORDER BY v.Fecha DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"Venta"}, new Callable<List<SalesEntity>>() {
      @Override
      public List<SalesEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfNoAticles = _cursor.getColumnIndexOrThrow("NoArticles");
          final int _cursorIndexOfTotal = _cursor.getColumnIndexOrThrow("Total");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfWayPay = _cursor.getColumnIndexOrThrow("FormaPago");
          final int _cursorIndexOfTypeDocumentVta = _cursor.getColumnIndexOrThrow("TipoDocumentoVta");
          final int _cursorIndexOfClient = _cursor.getColumnIndexOrThrow("Cliente");
          final int _cursorIndexOfSalesStatus = _cursor.getColumnIndexOrThrow("EstatusVenta");
          final int _cursorIndexOfCashShort = _cursor.getColumnIndexOrThrow("CorteCaja");
          final int _cursorIndexOfDocumentFolio = _cursor.getColumnIndexOrThrow("DocumentFolio");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final int _cursorIndexOfUuidCashShort = _cursor.getColumnIndexOrThrow("UUIDCorteCaja");
          final int _cursorIndexOfUuidTypeDocument = _cursor.getColumnIndexOrThrow("UUIDTipoDocumento");
          final int _cursorIndexOfUuidClient = _cursor.getColumnIndexOrThrow("UUIDCliente");
          final int _cursorIndexOfUuidWayPay = _cursor.getColumnIndexOrThrow("UUIDWayPay");
          final int _cursorIndexOfUtilityAmount = _cursor.getColumnIndexOrThrow("Monto_Utilidad");
          final int _cursorIndexOfUtilityPercentage = _cursor.getColumnIndexOrThrow("Porcentaje_Utilidad");
          final List<SalesEntity> _result = new ArrayList<SalesEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final SalesEntity _item;
            _item = new SalesEntity();
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
            final int _tmpNoAticles;
            _tmpNoAticles = _cursor.getInt(_cursorIndexOfNoAticles);
            _item.setNoAticles(_tmpNoAticles);
            final Double _tmpTotal;
            if (_cursor.isNull(_cursorIndexOfTotal)) {
              _tmpTotal = null;
            } else {
              _tmpTotal = _cursor.getDouble(_cursorIndexOfTotal);
            }
            _item.setTotal(_tmpTotal);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
            final Integer _tmpWayPay;
            if (_cursor.isNull(_cursorIndexOfWayPay)) {
              _tmpWayPay = null;
            } else {
              _tmpWayPay = _cursor.getInt(_cursorIndexOfWayPay);
            }
            _item.setWayPay(_tmpWayPay);
            final Integer _tmpTypeDocumentVta;
            if (_cursor.isNull(_cursorIndexOfTypeDocumentVta)) {
              _tmpTypeDocumentVta = null;
            } else {
              _tmpTypeDocumentVta = _cursor.getInt(_cursorIndexOfTypeDocumentVta);
            }
            _item.setTypeDocumentVta(_tmpTypeDocumentVta);
            final Integer _tmpClient;
            if (_cursor.isNull(_cursorIndexOfClient)) {
              _tmpClient = null;
            } else {
              _tmpClient = _cursor.getInt(_cursorIndexOfClient);
            }
            _item.setClient(_tmpClient);
            final String _tmpSalesStatus;
            _tmpSalesStatus = _cursor.getString(_cursorIndexOfSalesStatus);
            _item.setSalesStatus(_tmpSalesStatus);
            final Integer _tmpCashShort;
            if (_cursor.isNull(_cursorIndexOfCashShort)) {
              _tmpCashShort = null;
            } else {
              _tmpCashShort = _cursor.getInt(_cursorIndexOfCashShort);
            }
            _item.setCashShort(_tmpCashShort);
            final int _tmpDocumentFolio;
            _tmpDocumentFolio = _cursor.getInt(_cursorIndexOfDocumentFolio);
            _item.setDocumentFolio(_tmpDocumentFolio);
            final String _tmpUuid;
            _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            _item.setUuid(_tmpUuid);
            final String _tmpUuidCashShort;
            _tmpUuidCashShort = _cursor.getString(_cursorIndexOfUuidCashShort);
            _item.setUuidCashShort(_tmpUuidCashShort);
            final String _tmpUuidTypeDocument;
            _tmpUuidTypeDocument = _cursor.getString(_cursorIndexOfUuidTypeDocument);
            _item.setUuidTypeDocument(_tmpUuidTypeDocument);
            final String _tmpUuidClient;
            _tmpUuidClient = _cursor.getString(_cursorIndexOfUuidClient);
            _item.setUuidClient(_tmpUuidClient);
            final String _tmpUuidWayPay;
            _tmpUuidWayPay = _cursor.getString(_cursorIndexOfUuidWayPay);
            _item.setUuidWayPay(_tmpUuidWayPay);
            final Double _tmpUtilityAmount;
            if (_cursor.isNull(_cursorIndexOfUtilityAmount)) {
              _tmpUtilityAmount = null;
            } else {
              _tmpUtilityAmount = _cursor.getDouble(_cursorIndexOfUtilityAmount);
            }
            _item.setUtilityAmount(_tmpUtilityAmount);
            final Double _tmpUtilityPercentage;
            if (_cursor.isNull(_cursorIndexOfUtilityPercentage)) {
              _tmpUtilityPercentage = null;
            } else {
              _tmpUtilityPercentage = _cursor.getDouble(_cursorIndexOfUtilityPercentage);
            }
            _item.setUtilityPercentage(_tmpUtilityPercentage);
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
  public Flowable<List<SalesEntity>> getsSum() {
    final String _sql = "SELECT * FROM Venta v WHERE v.EstatusVenta='CERRADA'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"Venta"}, new Callable<List<SalesEntity>>() {
      @Override
      public List<SalesEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfNoAticles = _cursor.getColumnIndexOrThrow("NoArticles");
          final int _cursorIndexOfTotal = _cursor.getColumnIndexOrThrow("Total");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfWayPay = _cursor.getColumnIndexOrThrow("FormaPago");
          final int _cursorIndexOfTypeDocumentVta = _cursor.getColumnIndexOrThrow("TipoDocumentoVta");
          final int _cursorIndexOfClient = _cursor.getColumnIndexOrThrow("Cliente");
          final int _cursorIndexOfSalesStatus = _cursor.getColumnIndexOrThrow("EstatusVenta");
          final int _cursorIndexOfCashShort = _cursor.getColumnIndexOrThrow("CorteCaja");
          final int _cursorIndexOfDocumentFolio = _cursor.getColumnIndexOrThrow("DocumentFolio");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final int _cursorIndexOfUuidCashShort = _cursor.getColumnIndexOrThrow("UUIDCorteCaja");
          final int _cursorIndexOfUuidTypeDocument = _cursor.getColumnIndexOrThrow("UUIDTipoDocumento");
          final int _cursorIndexOfUuidClient = _cursor.getColumnIndexOrThrow("UUIDCliente");
          final int _cursorIndexOfUuidWayPay = _cursor.getColumnIndexOrThrow("UUIDWayPay");
          final int _cursorIndexOfUtilityAmount = _cursor.getColumnIndexOrThrow("Monto_Utilidad");
          final int _cursorIndexOfUtilityPercentage = _cursor.getColumnIndexOrThrow("Porcentaje_Utilidad");
          final List<SalesEntity> _result = new ArrayList<SalesEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final SalesEntity _item;
            _item = new SalesEntity();
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
            final int _tmpNoAticles;
            _tmpNoAticles = _cursor.getInt(_cursorIndexOfNoAticles);
            _item.setNoAticles(_tmpNoAticles);
            final Double _tmpTotal;
            if (_cursor.isNull(_cursorIndexOfTotal)) {
              _tmpTotal = null;
            } else {
              _tmpTotal = _cursor.getDouble(_cursorIndexOfTotal);
            }
            _item.setTotal(_tmpTotal);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
            final Integer _tmpWayPay;
            if (_cursor.isNull(_cursorIndexOfWayPay)) {
              _tmpWayPay = null;
            } else {
              _tmpWayPay = _cursor.getInt(_cursorIndexOfWayPay);
            }
            _item.setWayPay(_tmpWayPay);
            final Integer _tmpTypeDocumentVta;
            if (_cursor.isNull(_cursorIndexOfTypeDocumentVta)) {
              _tmpTypeDocumentVta = null;
            } else {
              _tmpTypeDocumentVta = _cursor.getInt(_cursorIndexOfTypeDocumentVta);
            }
            _item.setTypeDocumentVta(_tmpTypeDocumentVta);
            final Integer _tmpClient;
            if (_cursor.isNull(_cursorIndexOfClient)) {
              _tmpClient = null;
            } else {
              _tmpClient = _cursor.getInt(_cursorIndexOfClient);
            }
            _item.setClient(_tmpClient);
            final String _tmpSalesStatus;
            _tmpSalesStatus = _cursor.getString(_cursorIndexOfSalesStatus);
            _item.setSalesStatus(_tmpSalesStatus);
            final Integer _tmpCashShort;
            if (_cursor.isNull(_cursorIndexOfCashShort)) {
              _tmpCashShort = null;
            } else {
              _tmpCashShort = _cursor.getInt(_cursorIndexOfCashShort);
            }
            _item.setCashShort(_tmpCashShort);
            final int _tmpDocumentFolio;
            _tmpDocumentFolio = _cursor.getInt(_cursorIndexOfDocumentFolio);
            _item.setDocumentFolio(_tmpDocumentFolio);
            final String _tmpUuid;
            _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            _item.setUuid(_tmpUuid);
            final String _tmpUuidCashShort;
            _tmpUuidCashShort = _cursor.getString(_cursorIndexOfUuidCashShort);
            _item.setUuidCashShort(_tmpUuidCashShort);
            final String _tmpUuidTypeDocument;
            _tmpUuidTypeDocument = _cursor.getString(_cursorIndexOfUuidTypeDocument);
            _item.setUuidTypeDocument(_tmpUuidTypeDocument);
            final String _tmpUuidClient;
            _tmpUuidClient = _cursor.getString(_cursorIndexOfUuidClient);
            _item.setUuidClient(_tmpUuidClient);
            final String _tmpUuidWayPay;
            _tmpUuidWayPay = _cursor.getString(_cursorIndexOfUuidWayPay);
            _item.setUuidWayPay(_tmpUuidWayPay);
            final Double _tmpUtilityAmount;
            if (_cursor.isNull(_cursorIndexOfUtilityAmount)) {
              _tmpUtilityAmount = null;
            } else {
              _tmpUtilityAmount = _cursor.getDouble(_cursorIndexOfUtilityAmount);
            }
            _item.setUtilityAmount(_tmpUtilityAmount);
            final Double _tmpUtilityPercentage;
            if (_cursor.isNull(_cursorIndexOfUtilityPercentage)) {
              _tmpUtilityPercentage = null;
            } else {
              _tmpUtilityPercentage = _cursor.getDouble(_cursorIndexOfUtilityPercentage);
            }
            _item.setUtilityPercentage(_tmpUtilityPercentage);
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
  public Cursor selectAll() {
    final String _sql = "SELECT * FROM Venta v";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _tmpResult = __db.query(_statement);
    return _tmpResult;
  }

  @Override
  public Flowable<List<SalesEntity>> getRegisterSalesSync() {
    final String _sql = "SELECT * FROM Venta v INNER JOIN Bitacora b ON b.Tabla='Venta' WHERE v.Fecha<=b.Fecha and v.EstatusVenta = 'CERRADA'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"Venta","Bitacora"}, new Callable<List<SalesEntity>>() {
      @Override
      public List<SalesEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfNoAticles = _cursor.getColumnIndexOrThrow("NoArticles");
          final int _cursorIndexOfTotal = _cursor.getColumnIndexOrThrow("Total");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfWayPay = _cursor.getColumnIndexOrThrow("FormaPago");
          final int _cursorIndexOfTypeDocumentVta = _cursor.getColumnIndexOrThrow("TipoDocumentoVta");
          final int _cursorIndexOfClient = _cursor.getColumnIndexOrThrow("Cliente");
          final int _cursorIndexOfSalesStatus = _cursor.getColumnIndexOrThrow("EstatusVenta");
          final int _cursorIndexOfCashShort = _cursor.getColumnIndexOrThrow("CorteCaja");
          final int _cursorIndexOfDocumentFolio = _cursor.getColumnIndexOrThrow("DocumentFolio");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final int _cursorIndexOfUuidCashShort = _cursor.getColumnIndexOrThrow("UUIDCorteCaja");
          final int _cursorIndexOfUuidTypeDocument = _cursor.getColumnIndexOrThrow("UUIDTipoDocumento");
          final int _cursorIndexOfUuidClient = _cursor.getColumnIndexOrThrow("UUIDCliente");
          final int _cursorIndexOfUuidWayPay = _cursor.getColumnIndexOrThrow("UUIDWayPay");
          final int _cursorIndexOfUtilityAmount = _cursor.getColumnIndexOrThrow("Monto_Utilidad");
          final int _cursorIndexOfUtilityPercentage = _cursor.getColumnIndexOrThrow("Porcentaje_Utilidad");
          final int _cursorIndexOfId_1 = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfDate_1 = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfStatus_1 = _cursor.getColumnIndexOrThrow("Estatus");
          final List<SalesEntity> _result = new ArrayList<SalesEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final SalesEntity _item;
            _item = new SalesEntity();
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
            final int _tmpNoAticles;
            _tmpNoAticles = _cursor.getInt(_cursorIndexOfNoAticles);
            _item.setNoAticles(_tmpNoAticles);
            final Double _tmpTotal;
            if (_cursor.isNull(_cursorIndexOfTotal)) {
              _tmpTotal = null;
            } else {
              _tmpTotal = _cursor.getDouble(_cursorIndexOfTotal);
            }
            _item.setTotal(_tmpTotal);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
            final Integer _tmpWayPay;
            if (_cursor.isNull(_cursorIndexOfWayPay)) {
              _tmpWayPay = null;
            } else {
              _tmpWayPay = _cursor.getInt(_cursorIndexOfWayPay);
            }
            _item.setWayPay(_tmpWayPay);
            final Integer _tmpTypeDocumentVta;
            if (_cursor.isNull(_cursorIndexOfTypeDocumentVta)) {
              _tmpTypeDocumentVta = null;
            } else {
              _tmpTypeDocumentVta = _cursor.getInt(_cursorIndexOfTypeDocumentVta);
            }
            _item.setTypeDocumentVta(_tmpTypeDocumentVta);
            final Integer _tmpClient;
            if (_cursor.isNull(_cursorIndexOfClient)) {
              _tmpClient = null;
            } else {
              _tmpClient = _cursor.getInt(_cursorIndexOfClient);
            }
            _item.setClient(_tmpClient);
            final String _tmpSalesStatus;
            _tmpSalesStatus = _cursor.getString(_cursorIndexOfSalesStatus);
            _item.setSalesStatus(_tmpSalesStatus);
            final Integer _tmpCashShort;
            if (_cursor.isNull(_cursorIndexOfCashShort)) {
              _tmpCashShort = null;
            } else {
              _tmpCashShort = _cursor.getInt(_cursorIndexOfCashShort);
            }
            _item.setCashShort(_tmpCashShort);
            final int _tmpDocumentFolio;
            _tmpDocumentFolio = _cursor.getInt(_cursorIndexOfDocumentFolio);
            _item.setDocumentFolio(_tmpDocumentFolio);
            final String _tmpUuid;
            _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            _item.setUuid(_tmpUuid);
            final String _tmpUuidCashShort;
            _tmpUuidCashShort = _cursor.getString(_cursorIndexOfUuidCashShort);
            _item.setUuidCashShort(_tmpUuidCashShort);
            final String _tmpUuidTypeDocument;
            _tmpUuidTypeDocument = _cursor.getString(_cursorIndexOfUuidTypeDocument);
            _item.setUuidTypeDocument(_tmpUuidTypeDocument);
            final String _tmpUuidClient;
            _tmpUuidClient = _cursor.getString(_cursorIndexOfUuidClient);
            _item.setUuidClient(_tmpUuidClient);
            final String _tmpUuidWayPay;
            _tmpUuidWayPay = _cursor.getString(_cursorIndexOfUuidWayPay);
            _item.setUuidWayPay(_tmpUuidWayPay);
            final Double _tmpUtilityAmount;
            if (_cursor.isNull(_cursorIndexOfUtilityAmount)) {
              _tmpUtilityAmount = null;
            } else {
              _tmpUtilityAmount = _cursor.getDouble(_cursorIndexOfUtilityAmount);
            }
            _item.setUtilityAmount(_tmpUtilityAmount);
            final Double _tmpUtilityPercentage;
            if (_cursor.isNull(_cursorIndexOfUtilityPercentage)) {
              _tmpUtilityPercentage = null;
            } else {
              _tmpUtilityPercentage = _cursor.getDouble(_cursorIndexOfUtilityPercentage);
            }
            _item.setUtilityPercentage(_tmpUtilityPercentage);
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
  public Cursor selectById(long id) {
    final String _sql = "SELECT * FROM Venta v WHERE v.Id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final Cursor _tmpResult = __db.query(_statement);
    return _tmpResult;
  }
}
