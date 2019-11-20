package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.RxRoom;
import android.database.Cursor;
import com.example.administrador.pvsegalmex.entity.CashShortDetailEntity;
import com.example.administrador.pvsegalmex.entity.ClienteEntity;
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
public class ClienteDao_Impl implements ClienteDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfClienteEntity;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfClienteEntity;

  public ClienteDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfClienteEntity = new EntityInsertionAdapter<ClienteEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Cliente`(`Id`,`Nombre`,`ApellidoPaterno`,`ApellidoMaterno`,`LimiteCredito`,`DiasCredito`,`Genero`,`Direccion`,`Curp`,`CadenaINE`,`FotoCliente`,`Estatus`,`FotoINE`,`Email`,`Telefono`,`FechaUltimaVenta`,`UUID`,`UltimaActualizacion`,`Compania`,`Fecha`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ClienteEntity value) {
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
        if (value.getLastName1() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getLastName1());
        }
        if (value.getLastName2() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getLastName2());
        }
        stmt.bindDouble(5, value.getCreditLimit());
        stmt.bindLong(6, value.getCreditDays());
        stmt.bindLong(7, value.getGenre());
        if (value.getAddress() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getAddress());
        }
        if (value.getCurp() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getCurp());
        }
        if (value.getIneString() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getIneString());
        }
        if (value.getPhotoClient() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getPhotoClient());
        }
        stmt.bindLong(12, value.getStatus());
        if (value.getPhotoIne() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getPhotoIne());
        }
        if (value.getMail() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getMail());
        }
        if (value.getPhone() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getPhone());
        }
        if (value.getLastSellDate() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getLastSellDate());
        }
        if (value.getUuid() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getUuid());
        }
        if (value.getLastDateSync() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getLastDateSync());
        }
        if (value.getCompany() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindLong(19, value.getCompany());
        }
        if (value.getDate() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getDate());
        }
      }
    };
    this.__updateAdapterOfClienteEntity = new EntityDeletionOrUpdateAdapter<ClienteEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Cliente` SET `Id` = ?,`Nombre` = ?,`ApellidoPaterno` = ?,`ApellidoMaterno` = ?,`LimiteCredito` = ?,`DiasCredito` = ?,`Genero` = ?,`Direccion` = ?,`Curp` = ?,`CadenaINE` = ?,`FotoCliente` = ?,`Estatus` = ?,`FotoINE` = ?,`Email` = ?,`Telefono` = ?,`FechaUltimaVenta` = ?,`UUID` = ?,`UltimaActualizacion` = ?,`Compania` = ?,`Fecha` = ? WHERE `Id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ClienteEntity value) {
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
        if (value.getLastName1() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getLastName1());
        }
        if (value.getLastName2() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getLastName2());
        }
        stmt.bindDouble(5, value.getCreditLimit());
        stmt.bindLong(6, value.getCreditDays());
        stmt.bindLong(7, value.getGenre());
        if (value.getAddress() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getAddress());
        }
        if (value.getCurp() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getCurp());
        }
        if (value.getIneString() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getIneString());
        }
        if (value.getPhotoClient() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getPhotoClient());
        }
        stmt.bindLong(12, value.getStatus());
        if (value.getPhotoIne() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getPhotoIne());
        }
        if (value.getMail() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getMail());
        }
        if (value.getPhone() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getPhone());
        }
        if (value.getLastSellDate() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getLastSellDate());
        }
        if (value.getUuid() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getUuid());
        }
        if (value.getLastDateSync() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getLastDateSync());
        }
        if (value.getCompany() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindLong(19, value.getCompany());
        }
        if (value.getDate() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getDate());
        }
        if (value.getId() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindLong(21, value.getId());
        }
      }
    };
  }

  @Override
  public Long insertClient(ClienteEntity client) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfClienteEntity.insertAndReturnId(client);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Long> insertClientDefault(ArrayList<ClienteEntity> clientList) {
    __db.beginTransaction();
    try {
      List<Long> _result = __insertionAdapterOfClienteEntity.insertAndReturnIdsList(clientList);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateClient(ClienteEntity client) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfClienteEntity.handle(client);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Flowable<List<ClienteEntity>> getFilterClientsSale() {
    final String _sql = "SELECT*FROM Cliente c where c.Estatus>-1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"Cliente"}, new Callable<List<ClienteEntity>>() {
      @Override
      public List<ClienteEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("Nombre");
          final int _cursorIndexOfLastName1 = _cursor.getColumnIndexOrThrow("ApellidoPaterno");
          final int _cursorIndexOfLastName2 = _cursor.getColumnIndexOrThrow("ApellidoMaterno");
          final int _cursorIndexOfCreditLimit = _cursor.getColumnIndexOrThrow("LimiteCredito");
          final int _cursorIndexOfCreditDays = _cursor.getColumnIndexOrThrow("DiasCredito");
          final int _cursorIndexOfGenre = _cursor.getColumnIndexOrThrow("Genero");
          final int _cursorIndexOfAddress = _cursor.getColumnIndexOrThrow("Direccion");
          final int _cursorIndexOfCurp = _cursor.getColumnIndexOrThrow("Curp");
          final int _cursorIndexOfIneString = _cursor.getColumnIndexOrThrow("CadenaINE");
          final int _cursorIndexOfPhotoClient = _cursor.getColumnIndexOrThrow("FotoCliente");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfPhotoIne = _cursor.getColumnIndexOrThrow("FotoINE");
          final int _cursorIndexOfMail = _cursor.getColumnIndexOrThrow("Email");
          final int _cursorIndexOfPhone = _cursor.getColumnIndexOrThrow("Telefono");
          final int _cursorIndexOfLastSellDate = _cursor.getColumnIndexOrThrow("FechaUltimaVenta");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final int _cursorIndexOfLastDateSync = _cursor.getColumnIndexOrThrow("UltimaActualizacion");
          final int _cursorIndexOfCompany = _cursor.getColumnIndexOrThrow("Compania");
          final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("Fecha");
          final List<ClienteEntity> _result = new ArrayList<ClienteEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ClienteEntity _item;
            _item = new ClienteEntity();
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
            final String _tmpLastName1;
            _tmpLastName1 = _cursor.getString(_cursorIndexOfLastName1);
            _item.setLastName1(_tmpLastName1);
            final String _tmpLastName2;
            _tmpLastName2 = _cursor.getString(_cursorIndexOfLastName2);
            _item.setLastName2(_tmpLastName2);
            final double _tmpCreditLimit;
            _tmpCreditLimit = _cursor.getDouble(_cursorIndexOfCreditLimit);
            _item.setCreditLimit(_tmpCreditLimit);
            final int _tmpCreditDays;
            _tmpCreditDays = _cursor.getInt(_cursorIndexOfCreditDays);
            _item.setCreditDays(_tmpCreditDays);
            final char _tmpGenre;
            _tmpGenre = (char) _cursor.getInt(_cursorIndexOfGenre);
            _item.setGenre(_tmpGenre);
            final String _tmpAddress;
            _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
            _item.setAddress(_tmpAddress);
            final String _tmpCurp;
            _tmpCurp = _cursor.getString(_cursorIndexOfCurp);
            _item.setCurp(_tmpCurp);
            final String _tmpIneString;
            _tmpIneString = _cursor.getString(_cursorIndexOfIneString);
            _item.setIneString(_tmpIneString);
            final String _tmpPhotoClient;
            _tmpPhotoClient = _cursor.getString(_cursorIndexOfPhotoClient);
            _item.setPhotoClient(_tmpPhotoClient);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
            final String _tmpPhotoIne;
            _tmpPhotoIne = _cursor.getString(_cursorIndexOfPhotoIne);
            _item.setPhotoIne(_tmpPhotoIne);
            final String _tmpMail;
            _tmpMail = _cursor.getString(_cursorIndexOfMail);
            _item.setMail(_tmpMail);
            final String _tmpPhone;
            _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            _item.setPhone(_tmpPhone);
            final String _tmpLastSellDate;
            _tmpLastSellDate = _cursor.getString(_cursorIndexOfLastSellDate);
            _item.setLastSellDate(_tmpLastSellDate);
            final String _tmpUuid;
            _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            _item.setUuid(_tmpUuid);
            final String _tmpLastDateSync;
            _tmpLastDateSync = _cursor.getString(_cursorIndexOfLastDateSync);
            _item.setLastDateSync(_tmpLastDateSync);
            final Integer _tmpCompany;
            if (_cursor.isNull(_cursorIndexOfCompany)) {
              _tmpCompany = null;
            } else {
              _tmpCompany = _cursor.getInt(_cursorIndexOfCompany);
            }
            _item.setCompany(_tmpCompany);
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
  public Flowable<List<ClienteEntity>> getFilterClients(String clientName) {
    final String _sql = "SELECT*FROM Cliente c where c.Estatus>-1  and c.Nombre glob '*'||?||'*'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (clientName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, clientName);
    }
    return RxRoom.createFlowable(__db, new String[]{"Cliente"}, new Callable<List<ClienteEntity>>() {
      @Override
      public List<ClienteEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("Nombre");
          final int _cursorIndexOfLastName1 = _cursor.getColumnIndexOrThrow("ApellidoPaterno");
          final int _cursorIndexOfLastName2 = _cursor.getColumnIndexOrThrow("ApellidoMaterno");
          final int _cursorIndexOfCreditLimit = _cursor.getColumnIndexOrThrow("LimiteCredito");
          final int _cursorIndexOfCreditDays = _cursor.getColumnIndexOrThrow("DiasCredito");
          final int _cursorIndexOfGenre = _cursor.getColumnIndexOrThrow("Genero");
          final int _cursorIndexOfAddress = _cursor.getColumnIndexOrThrow("Direccion");
          final int _cursorIndexOfCurp = _cursor.getColumnIndexOrThrow("Curp");
          final int _cursorIndexOfIneString = _cursor.getColumnIndexOrThrow("CadenaINE");
          final int _cursorIndexOfPhotoClient = _cursor.getColumnIndexOrThrow("FotoCliente");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfPhotoIne = _cursor.getColumnIndexOrThrow("FotoINE");
          final int _cursorIndexOfMail = _cursor.getColumnIndexOrThrow("Email");
          final int _cursorIndexOfPhone = _cursor.getColumnIndexOrThrow("Telefono");
          final int _cursorIndexOfLastSellDate = _cursor.getColumnIndexOrThrow("FechaUltimaVenta");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final int _cursorIndexOfLastDateSync = _cursor.getColumnIndexOrThrow("UltimaActualizacion");
          final int _cursorIndexOfCompany = _cursor.getColumnIndexOrThrow("Compania");
          final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("Fecha");
          final List<ClienteEntity> _result = new ArrayList<ClienteEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ClienteEntity _item;
            _item = new ClienteEntity();
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
            final String _tmpLastName1;
            _tmpLastName1 = _cursor.getString(_cursorIndexOfLastName1);
            _item.setLastName1(_tmpLastName1);
            final String _tmpLastName2;
            _tmpLastName2 = _cursor.getString(_cursorIndexOfLastName2);
            _item.setLastName2(_tmpLastName2);
            final double _tmpCreditLimit;
            _tmpCreditLimit = _cursor.getDouble(_cursorIndexOfCreditLimit);
            _item.setCreditLimit(_tmpCreditLimit);
            final int _tmpCreditDays;
            _tmpCreditDays = _cursor.getInt(_cursorIndexOfCreditDays);
            _item.setCreditDays(_tmpCreditDays);
            final char _tmpGenre;
            _tmpGenre = (char) _cursor.getInt(_cursorIndexOfGenre);
            _item.setGenre(_tmpGenre);
            final String _tmpAddress;
            _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
            _item.setAddress(_tmpAddress);
            final String _tmpCurp;
            _tmpCurp = _cursor.getString(_cursorIndexOfCurp);
            _item.setCurp(_tmpCurp);
            final String _tmpIneString;
            _tmpIneString = _cursor.getString(_cursorIndexOfIneString);
            _item.setIneString(_tmpIneString);
            final String _tmpPhotoClient;
            _tmpPhotoClient = _cursor.getString(_cursorIndexOfPhotoClient);
            _item.setPhotoClient(_tmpPhotoClient);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
            final String _tmpPhotoIne;
            _tmpPhotoIne = _cursor.getString(_cursorIndexOfPhotoIne);
            _item.setPhotoIne(_tmpPhotoIne);
            final String _tmpMail;
            _tmpMail = _cursor.getString(_cursorIndexOfMail);
            _item.setMail(_tmpMail);
            final String _tmpPhone;
            _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            _item.setPhone(_tmpPhone);
            final String _tmpLastSellDate;
            _tmpLastSellDate = _cursor.getString(_cursorIndexOfLastSellDate);
            _item.setLastSellDate(_tmpLastSellDate);
            final String _tmpUuid;
            _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            _item.setUuid(_tmpUuid);
            final String _tmpLastDateSync;
            _tmpLastDateSync = _cursor.getString(_cursorIndexOfLastDateSync);
            _item.setLastDateSync(_tmpLastDateSync);
            final Integer _tmpCompany;
            if (_cursor.isNull(_cursorIndexOfCompany)) {
              _tmpCompany = null;
            } else {
              _tmpCompany = _cursor.getInt(_cursorIndexOfCompany);
            }
            _item.setCompany(_tmpCompany);
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
  public Flowable<ClienteEntity> getFilterClientId(int idClient) {
    final String _sql = "SELECT*FROM Cliente c where c.Estatus>-1  and c.id glob '*'||?||'*'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, idClient);
    return RxRoom.createFlowable(__db, new String[]{"Cliente"}, new Callable<ClienteEntity>() {
      @Override
      public ClienteEntity call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("Nombre");
          final int _cursorIndexOfLastName1 = _cursor.getColumnIndexOrThrow("ApellidoPaterno");
          final int _cursorIndexOfLastName2 = _cursor.getColumnIndexOrThrow("ApellidoMaterno");
          final int _cursorIndexOfCreditLimit = _cursor.getColumnIndexOrThrow("LimiteCredito");
          final int _cursorIndexOfCreditDays = _cursor.getColumnIndexOrThrow("DiasCredito");
          final int _cursorIndexOfGenre = _cursor.getColumnIndexOrThrow("Genero");
          final int _cursorIndexOfAddress = _cursor.getColumnIndexOrThrow("Direccion");
          final int _cursorIndexOfCurp = _cursor.getColumnIndexOrThrow("Curp");
          final int _cursorIndexOfIneString = _cursor.getColumnIndexOrThrow("CadenaINE");
          final int _cursorIndexOfPhotoClient = _cursor.getColumnIndexOrThrow("FotoCliente");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfPhotoIne = _cursor.getColumnIndexOrThrow("FotoINE");
          final int _cursorIndexOfMail = _cursor.getColumnIndexOrThrow("Email");
          final int _cursorIndexOfPhone = _cursor.getColumnIndexOrThrow("Telefono");
          final int _cursorIndexOfLastSellDate = _cursor.getColumnIndexOrThrow("FechaUltimaVenta");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final int _cursorIndexOfLastDateSync = _cursor.getColumnIndexOrThrow("UltimaActualizacion");
          final int _cursorIndexOfCompany = _cursor.getColumnIndexOrThrow("Compania");
          final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("Fecha");
          final ClienteEntity _result;
          if(_cursor.moveToFirst()) {
            _result = new ClienteEntity();
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _result.setId(_tmpId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            _result.setName(_tmpName);
            final String _tmpLastName1;
            _tmpLastName1 = _cursor.getString(_cursorIndexOfLastName1);
            _result.setLastName1(_tmpLastName1);
            final String _tmpLastName2;
            _tmpLastName2 = _cursor.getString(_cursorIndexOfLastName2);
            _result.setLastName2(_tmpLastName2);
            final double _tmpCreditLimit;
            _tmpCreditLimit = _cursor.getDouble(_cursorIndexOfCreditLimit);
            _result.setCreditLimit(_tmpCreditLimit);
            final int _tmpCreditDays;
            _tmpCreditDays = _cursor.getInt(_cursorIndexOfCreditDays);
            _result.setCreditDays(_tmpCreditDays);
            final char _tmpGenre;
            _tmpGenre = (char) _cursor.getInt(_cursorIndexOfGenre);
            _result.setGenre(_tmpGenre);
            final String _tmpAddress;
            _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
            _result.setAddress(_tmpAddress);
            final String _tmpCurp;
            _tmpCurp = _cursor.getString(_cursorIndexOfCurp);
            _result.setCurp(_tmpCurp);
            final String _tmpIneString;
            _tmpIneString = _cursor.getString(_cursorIndexOfIneString);
            _result.setIneString(_tmpIneString);
            final String _tmpPhotoClient;
            _tmpPhotoClient = _cursor.getString(_cursorIndexOfPhotoClient);
            _result.setPhotoClient(_tmpPhotoClient);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            _result.setStatus(_tmpStatus);
            final String _tmpPhotoIne;
            _tmpPhotoIne = _cursor.getString(_cursorIndexOfPhotoIne);
            _result.setPhotoIne(_tmpPhotoIne);
            final String _tmpMail;
            _tmpMail = _cursor.getString(_cursorIndexOfMail);
            _result.setMail(_tmpMail);
            final String _tmpPhone;
            _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            _result.setPhone(_tmpPhone);
            final String _tmpLastSellDate;
            _tmpLastSellDate = _cursor.getString(_cursorIndexOfLastSellDate);
            _result.setLastSellDate(_tmpLastSellDate);
            final String _tmpUuid;
            _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            _result.setUuid(_tmpUuid);
            final String _tmpLastDateSync;
            _tmpLastDateSync = _cursor.getString(_cursorIndexOfLastDateSync);
            _result.setLastDateSync(_tmpLastDateSync);
            final Integer _tmpCompany;
            if (_cursor.isNull(_cursorIndexOfCompany)) {
              _tmpCompany = null;
            } else {
              _tmpCompany = _cursor.getInt(_cursorIndexOfCompany);
            }
            _result.setCompany(_tmpCompany);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            _result.setDate(_tmpDate);
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

  @Override
  public Flowable<List<CashShortDetailEntity>> getRegisterClienteSync() {
    final String _sql = "SELECT * FROM Cliente c INNER JOIN Bitacora b ON b.Tabla='Cliente' WHERE c.Fecha<=b.Fecha";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"Cliente","Bitacora"}, new Callable<List<CashShortDetailEntity>>() {
      @Override
      public List<CashShortDetailEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfId_1 = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfDate_1 = _cursor.getColumnIndexOrThrow("Fecha");
          final int _cursorIndexOfStatus_1 = _cursor.getColumnIndexOrThrow("Estatus");
          final List<CashShortDetailEntity> _result = new ArrayList<CashShortDetailEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final CashShortDetailEntity _item;
            _item = new CashShortDetailEntity();
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
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
