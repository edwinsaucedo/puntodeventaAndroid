package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.RxRoom;
import android.database.Cursor;
import com.example.administrador.pvsegalmex.entity.ProductPriceEntity;
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
public class ProductPriceDao_Impl implements ProductPriceDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfProductPriceEntity;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfProductPriceEntity;

  public ProductPriceDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfProductPriceEntity = new EntityInsertionAdapter<ProductPriceEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `ProductoPrecio`(`Id`,`Nivel`,`Precio`,`PorcentajeUtilidad`,`Costo`,`Cantidad`,`Producto`,`UUID`,`UUIDProducto`,`Monto_Utilidad`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ProductPriceEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getLevel() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getLevel());
        }
        stmt.bindDouble(3, value.getPrice());
        stmt.bindDouble(4, value.getPercentage());
        stmt.bindDouble(5, value.getCost());
        stmt.bindDouble(6, value.getQuantity());
        stmt.bindLong(7, value.getProduct());
        if (value.getUuid() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getUuid());
        }
        if (value.getUuidProduct() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getUuidProduct());
        }
        if (value.getUtilityAmount() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindDouble(10, value.getUtilityAmount());
        }
      }
    };
    this.__updateAdapterOfProductPriceEntity = new EntityDeletionOrUpdateAdapter<ProductPriceEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `ProductoPrecio` SET `Id` = ?,`Nivel` = ?,`Precio` = ?,`PorcentajeUtilidad` = ?,`Costo` = ?,`Cantidad` = ?,`Producto` = ?,`UUID` = ?,`UUIDProducto` = ?,`Monto_Utilidad` = ? WHERE `Id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ProductPriceEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getLevel() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getLevel());
        }
        stmt.bindDouble(3, value.getPrice());
        stmt.bindDouble(4, value.getPercentage());
        stmt.bindDouble(5, value.getCost());
        stmt.bindDouble(6, value.getQuantity());
        stmt.bindLong(7, value.getProduct());
        if (value.getUuid() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getUuid());
        }
        if (value.getUuidProduct() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getUuidProduct());
        }
        if (value.getUtilityAmount() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindDouble(10, value.getUtilityAmount());
        }
        if (value.getId() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, value.getId());
        }
      }
    };
  }

  @Override
  public Long insertProductPrice(ProductPriceEntity productPrice) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfProductPriceEntity.insertAndReturnId(productPrice);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateProductPrice(ProductPriceEntity productPrice) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfProductPriceEntity.handle(productPrice);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Flowable<List<ProductPriceEntity>> getFilterProductPrice(Integer idProducto) {
    final String _sql = "SELECT * FROM ProductoPrecio Where Producto =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (idProducto == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, idProducto);
    }
    return RxRoom.createFlowable(__db, new String[]{"ProductoPrecio"}, new Callable<List<ProductPriceEntity>>() {
      @Override
      public List<ProductPriceEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfLevel = _cursor.getColumnIndexOrThrow("Nivel");
          final int _cursorIndexOfPrice = _cursor.getColumnIndexOrThrow("Precio");
          final int _cursorIndexOfPercentage = _cursor.getColumnIndexOrThrow("PorcentajeUtilidad");
          final int _cursorIndexOfCost = _cursor.getColumnIndexOrThrow("Costo");
          final int _cursorIndexOfQuantity = _cursor.getColumnIndexOrThrow("Cantidad");
          final int _cursorIndexOfProduct = _cursor.getColumnIndexOrThrow("Producto");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final int _cursorIndexOfUuidProduct = _cursor.getColumnIndexOrThrow("UUIDProducto");
          final int _cursorIndexOfUtilityAmount = _cursor.getColumnIndexOrThrow("Monto_Utilidad");
          final List<ProductPriceEntity> _result = new ArrayList<ProductPriceEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ProductPriceEntity _item;
            _item = new ProductPriceEntity();
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final Integer _tmpLevel;
            if (_cursor.isNull(_cursorIndexOfLevel)) {
              _tmpLevel = null;
            } else {
              _tmpLevel = _cursor.getInt(_cursorIndexOfLevel);
            }
            _item.setLevel(_tmpLevel);
            final double _tmpPrice;
            _tmpPrice = _cursor.getDouble(_cursorIndexOfPrice);
            _item.setPrice(_tmpPrice);
            final double _tmpPercentage;
            _tmpPercentage = _cursor.getDouble(_cursorIndexOfPercentage);
            _item.setPercentage(_tmpPercentage);
            final double _tmpCost;
            _tmpCost = _cursor.getDouble(_cursorIndexOfCost);
            _item.setCost(_tmpCost);
            final double _tmpQuantity;
            _tmpQuantity = _cursor.getDouble(_cursorIndexOfQuantity);
            _item.setQuantity(_tmpQuantity);
            final int _tmpProduct;
            _tmpProduct = _cursor.getInt(_cursorIndexOfProduct);
            _item.setProduct(_tmpProduct);
            final String _tmpUuid;
            _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            _item.setUuid(_tmpUuid);
            final String _tmpUuidProduct;
            _tmpUuidProduct = _cursor.getString(_cursorIndexOfUuidProduct);
            _item.setUuidProduct(_tmpUuidProduct);
            final Double _tmpUtilityAmount;
            if (_cursor.isNull(_cursorIndexOfUtilityAmount)) {
              _tmpUtilityAmount = null;
            } else {
              _tmpUtilityAmount = _cursor.getDouble(_cursorIndexOfUtilityAmount);
            }
            _item.setUtilityAmount(_tmpUtilityAmount);
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
