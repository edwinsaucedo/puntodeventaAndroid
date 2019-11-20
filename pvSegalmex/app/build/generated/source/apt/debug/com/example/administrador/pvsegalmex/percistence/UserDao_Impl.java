package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.RxRoom;
import android.database.Cursor;
import com.example.administrador.pvsegalmex.entity.UserEntity;
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
public class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfUserEntity;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfUserEntity;

  public UserDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUserEntity = new EntityInsertionAdapter<UserEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Usuario`(`Id`,`IdWs`,`Nombre`,`TipoUsuario`,`Compania`,`Usuario`,`Password`,`Email`,`ClaveAcceso`,`UsuarioPV`,`Estatus`,`UUID`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UserEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getIdws() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getIdws());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        if (value.getTypeUser() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getTypeUser());
        }
        if (value.getCompany() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getCompany());
        }
        if (value.getUser() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getUser());
        }
        if (value.getPassword() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPassword());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getEmail());
        }
        if (value.getAccessKey() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getAccessKey());
        }
        stmt.bindLong(10, value.getUserPV());
        stmt.bindLong(11, value.getStatus());
        if (value.getUuid() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getUuid());
        }
      }
    };
    this.__updateAdapterOfUserEntity = new EntityDeletionOrUpdateAdapter<UserEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Usuario` SET `Id` = ?,`IdWs` = ?,`Nombre` = ?,`TipoUsuario` = ?,`Compania` = ?,`Usuario` = ?,`Password` = ?,`Email` = ?,`ClaveAcceso` = ?,`UsuarioPV` = ?,`Estatus` = ?,`UUID` = ? WHERE `Id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UserEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getIdws() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getIdws());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        if (value.getTypeUser() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getTypeUser());
        }
        if (value.getCompany() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getCompany());
        }
        if (value.getUser() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getUser());
        }
        if (value.getPassword() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPassword());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getEmail());
        }
        if (value.getAccessKey() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getAccessKey());
        }
        stmt.bindLong(10, value.getUserPV());
        stmt.bindLong(11, value.getStatus());
        if (value.getUuid() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getUuid());
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
  public Long insertUser(UserEntity userEntity) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfUserEntity.insertAndReturnId(userEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateUser(UserEntity userEntity) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfUserEntity.handle(userEntity);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Flowable<List<UserEntity>> getUsers() {
    final String _sql = "SELECT * FROM Usuario u WHERE u.Estatus>-1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"Usuario"}, new Callable<List<UserEntity>>() {
      @Override
      public List<UserEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfIdws = _cursor.getColumnIndexOrThrow("IdWs");
          final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("Nombre");
          final int _cursorIndexOfTypeUser = _cursor.getColumnIndexOrThrow("TipoUsuario");
          final int _cursorIndexOfCompany = _cursor.getColumnIndexOrThrow("Compania");
          final int _cursorIndexOfUser = _cursor.getColumnIndexOrThrow("Usuario");
          final int _cursorIndexOfPassword = _cursor.getColumnIndexOrThrow("Password");
          final int _cursorIndexOfEmail = _cursor.getColumnIndexOrThrow("Email");
          final int _cursorIndexOfAccessKey = _cursor.getColumnIndexOrThrow("ClaveAcceso");
          final int _cursorIndexOfUserPV = _cursor.getColumnIndexOrThrow("UsuarioPV");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final List<UserEntity> _result = new ArrayList<UserEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final UserEntity _item;
            _item = new UserEntity();
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final Integer _tmpIdws;
            if (_cursor.isNull(_cursorIndexOfIdws)) {
              _tmpIdws = null;
            } else {
              _tmpIdws = _cursor.getInt(_cursorIndexOfIdws);
            }
            _item.setIdws(_tmpIdws);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            _item.setName(_tmpName);
            final Integer _tmpTypeUser;
            if (_cursor.isNull(_cursorIndexOfTypeUser)) {
              _tmpTypeUser = null;
            } else {
              _tmpTypeUser = _cursor.getInt(_cursorIndexOfTypeUser);
            }
            _item.setTypeUser(_tmpTypeUser);
            final Integer _tmpCompany;
            if (_cursor.isNull(_cursorIndexOfCompany)) {
              _tmpCompany = null;
            } else {
              _tmpCompany = _cursor.getInt(_cursorIndexOfCompany);
            }
            _item.setCompany(_tmpCompany);
            final Integer _tmpUser;
            if (_cursor.isNull(_cursorIndexOfUser)) {
              _tmpUser = null;
            } else {
              _tmpUser = _cursor.getInt(_cursorIndexOfUser);
            }
            _item.setUser(_tmpUser);
            final String _tmpPassword;
            _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
            _item.setPassword(_tmpPassword);
            final String _tmpEmail;
            _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            _item.setEmail(_tmpEmail);
            final String _tmpAccessKey;
            _tmpAccessKey = _cursor.getString(_cursorIndexOfAccessKey);
            _item.setAccessKey(_tmpAccessKey);
            final int _tmpUserPV;
            _tmpUserPV = _cursor.getInt(_cursorIndexOfUserPV);
            _item.setUserPV(_tmpUserPV);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
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
  public Flowable<UserEntity> getUser(Integer id) {
    final String _sql = "SELECT * FROM Usuario u WHERE u.IdWs glob '*'||?||'*'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, id);
    }
    return RxRoom.createFlowable(__db, new String[]{"Usuario"}, new Callable<UserEntity>() {
      @Override
      public UserEntity call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfIdws = _cursor.getColumnIndexOrThrow("IdWs");
          final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("Nombre");
          final int _cursorIndexOfTypeUser = _cursor.getColumnIndexOrThrow("TipoUsuario");
          final int _cursorIndexOfCompany = _cursor.getColumnIndexOrThrow("Compania");
          final int _cursorIndexOfUser = _cursor.getColumnIndexOrThrow("Usuario");
          final int _cursorIndexOfPassword = _cursor.getColumnIndexOrThrow("Password");
          final int _cursorIndexOfEmail = _cursor.getColumnIndexOrThrow("Email");
          final int _cursorIndexOfAccessKey = _cursor.getColumnIndexOrThrow("ClaveAcceso");
          final int _cursorIndexOfUserPV = _cursor.getColumnIndexOrThrow("UsuarioPV");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final UserEntity _result;
          if(_cursor.moveToFirst()) {
            _result = new UserEntity();
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _result.setId(_tmpId);
            final Integer _tmpIdws;
            if (_cursor.isNull(_cursorIndexOfIdws)) {
              _tmpIdws = null;
            } else {
              _tmpIdws = _cursor.getInt(_cursorIndexOfIdws);
            }
            _result.setIdws(_tmpIdws);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            _result.setName(_tmpName);
            final Integer _tmpTypeUser;
            if (_cursor.isNull(_cursorIndexOfTypeUser)) {
              _tmpTypeUser = null;
            } else {
              _tmpTypeUser = _cursor.getInt(_cursorIndexOfTypeUser);
            }
            _result.setTypeUser(_tmpTypeUser);
            final Integer _tmpCompany;
            if (_cursor.isNull(_cursorIndexOfCompany)) {
              _tmpCompany = null;
            } else {
              _tmpCompany = _cursor.getInt(_cursorIndexOfCompany);
            }
            _result.setCompany(_tmpCompany);
            final Integer _tmpUser;
            if (_cursor.isNull(_cursorIndexOfUser)) {
              _tmpUser = null;
            } else {
              _tmpUser = _cursor.getInt(_cursorIndexOfUser);
            }
            _result.setUser(_tmpUser);
            final String _tmpPassword;
            _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
            _result.setPassword(_tmpPassword);
            final String _tmpEmail;
            _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            _result.setEmail(_tmpEmail);
            final String _tmpAccessKey;
            _tmpAccessKey = _cursor.getString(_cursorIndexOfAccessKey);
            _result.setAccessKey(_tmpAccessKey);
            final int _tmpUserPV;
            _tmpUserPV = _cursor.getInt(_cursorIndexOfUserPV);
            _result.setUserPV(_tmpUserPV);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            _result.setStatus(_tmpStatus);
            final String _tmpUuid;
            _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            _result.setUuid(_tmpUuid);
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
