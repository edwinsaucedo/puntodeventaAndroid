package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.RxRoom;
import android.database.Cursor;
import com.example.administrador.pvsegalmex.entity.ProductEntity;
import com.example.administrador.pvsegalmex.pojo.ProductPricePojo;
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
public class ProductDao_Impl implements ProductDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfProductEntity;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfProductEntity;

  public ProductDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfProductEntity = new EntityInsertionAdapter<ProductEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Productos`(`Id`,`Codigo`,`CodigoAlterno`,`Descripcion`,`Maximo`,`Minimo`,`PuntoDeReorden`,`UnidadMedida`,`UnidadMedidaCompra`,`Factor`,`Servicio`,`Diconsa`,`Categoria`,`Granel`,`Estatus`,`RowId`,`Costo`,`CostoUC`,`FechaUC`,`Imagen`,`UltimaActualizacion`,`UUID`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ProductEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getCode() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCode());
        }
        if (value.getAlternateCode() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAlternateCode());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDescription());
        }
        stmt.bindDouble(5, value.getMaximum());
        stmt.bindDouble(6, value.getMinimum());
        stmt.bindDouble(7, value.getReorderPoint());
        stmt.bindLong(8, value.getUnitMeasure());
        stmt.bindLong(9, value.getUnitMeasurePurchase());
        stmt.bindDouble(10, value.getFactor());
        stmt.bindLong(11, value.getService());
        stmt.bindLong(12, value.getDiconsa());
        if (value.getCategory() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindLong(13, value.getCategory());
        }
        stmt.bindLong(14, value.getGranel());
        stmt.bindLong(15, value.getStatus());
        if (value.getRowId() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getRowId());
        }
        stmt.bindDouble(17, value.getCost());
        stmt.bindDouble(18, value.getCostUC());
        if (value.getDateUC() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getDateUC());
        }
        if (value.getImage() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getImage());
        }
        if (value.getLastDateSync() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getLastDateSync());
        }
        if (value.getUuid() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getUuid());
        }
      }
    };
    this.__updateAdapterOfProductEntity = new EntityDeletionOrUpdateAdapter<ProductEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Productos` SET `Id` = ?,`Codigo` = ?,`CodigoAlterno` = ?,`Descripcion` = ?,`Maximo` = ?,`Minimo` = ?,`PuntoDeReorden` = ?,`UnidadMedida` = ?,`UnidadMedidaCompra` = ?,`Factor` = ?,`Servicio` = ?,`Diconsa` = ?,`Categoria` = ?,`Granel` = ?,`Estatus` = ?,`RowId` = ?,`Costo` = ?,`CostoUC` = ?,`FechaUC` = ?,`Imagen` = ?,`UltimaActualizacion` = ?,`UUID` = ? WHERE `Id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ProductEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getCode() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCode());
        }
        if (value.getAlternateCode() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAlternateCode());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDescription());
        }
        stmt.bindDouble(5, value.getMaximum());
        stmt.bindDouble(6, value.getMinimum());
        stmt.bindDouble(7, value.getReorderPoint());
        stmt.bindLong(8, value.getUnitMeasure());
        stmt.bindLong(9, value.getUnitMeasurePurchase());
        stmt.bindDouble(10, value.getFactor());
        stmt.bindLong(11, value.getService());
        stmt.bindLong(12, value.getDiconsa());
        if (value.getCategory() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindLong(13, value.getCategory());
        }
        stmt.bindLong(14, value.getGranel());
        stmt.bindLong(15, value.getStatus());
        if (value.getRowId() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getRowId());
        }
        stmt.bindDouble(17, value.getCost());
        stmt.bindDouble(18, value.getCostUC());
        if (value.getDateUC() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getDateUC());
        }
        if (value.getImage() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getImage());
        }
        if (value.getLastDateSync() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getLastDateSync());
        }
        if (value.getUuid() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getUuid());
        }
        if (value.getId() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindLong(23, value.getId());
        }
      }
    };
  }

  @Override
  public Long insertProduct(ProductEntity product) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfProductEntity.insertAndReturnId(product);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Long> insertProductDefault(ArrayList<ProductEntity> list) {
    __db.beginTransaction();
    try {
      List<Long> _result = __insertionAdapterOfProductEntity.insertAndReturnIdsList(list);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateProduct(ProductEntity product) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfProductEntity.handle(product);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Flowable<List<ProductEntity>> getFilterProducts(String productDescription) {
    final String _sql = "SELECT * FROM Productos p where  p.Estatus>-1 and p.Descripcion glob '*'||?||'*' COLLATE NOCASE";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (productDescription == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, productDescription);
    }
    return RxRoom.createFlowable(__db, new String[]{"Productos"}, new Callable<List<ProductEntity>>() {
      @Override
      public List<ProductEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfCode = _cursor.getColumnIndexOrThrow("Codigo");
          final int _cursorIndexOfAlternateCode = _cursor.getColumnIndexOrThrow("CodigoAlterno");
          final int _cursorIndexOfDescription = _cursor.getColumnIndexOrThrow("Descripcion");
          final int _cursorIndexOfMaximum = _cursor.getColumnIndexOrThrow("Maximo");
          final int _cursorIndexOfMinimum = _cursor.getColumnIndexOrThrow("Minimo");
          final int _cursorIndexOfReorderPoint = _cursor.getColumnIndexOrThrow("PuntoDeReorden");
          final int _cursorIndexOfUnitMeasure = _cursor.getColumnIndexOrThrow("UnidadMedida");
          final int _cursorIndexOfUnitMeasurePurchase = _cursor.getColumnIndexOrThrow("UnidadMedidaCompra");
          final int _cursorIndexOfFactor = _cursor.getColumnIndexOrThrow("Factor");
          final int _cursorIndexOfService = _cursor.getColumnIndexOrThrow("Servicio");
          final int _cursorIndexOfDiconsa = _cursor.getColumnIndexOrThrow("Diconsa");
          final int _cursorIndexOfCategory = _cursor.getColumnIndexOrThrow("Categoria");
          final int _cursorIndexOfGranel = _cursor.getColumnIndexOrThrow("Granel");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfRowId = _cursor.getColumnIndexOrThrow("RowId");
          final int _cursorIndexOfCost = _cursor.getColumnIndexOrThrow("Costo");
          final int _cursorIndexOfCostUC = _cursor.getColumnIndexOrThrow("CostoUC");
          final int _cursorIndexOfDateUC = _cursor.getColumnIndexOrThrow("FechaUC");
          final int _cursorIndexOfImage = _cursor.getColumnIndexOrThrow("Imagen");
          final int _cursorIndexOfLastDateSync = _cursor.getColumnIndexOrThrow("UltimaActualizacion");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final List<ProductEntity> _result = new ArrayList<ProductEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ProductEntity _item;
            _item = new ProductEntity();
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final String _tmpCode;
            _tmpCode = _cursor.getString(_cursorIndexOfCode);
            _item.setCode(_tmpCode);
            final String _tmpAlternateCode;
            _tmpAlternateCode = _cursor.getString(_cursorIndexOfAlternateCode);
            _item.setAlternateCode(_tmpAlternateCode);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            _item.setDescription(_tmpDescription);
            final double _tmpMaximum;
            _tmpMaximum = _cursor.getDouble(_cursorIndexOfMaximum);
            _item.setMaximum(_tmpMaximum);
            final double _tmpMinimum;
            _tmpMinimum = _cursor.getDouble(_cursorIndexOfMinimum);
            _item.setMinimum(_tmpMinimum);
            final double _tmpReorderPoint;
            _tmpReorderPoint = _cursor.getDouble(_cursorIndexOfReorderPoint);
            _item.setReorderPoint(_tmpReorderPoint);
            final int _tmpUnitMeasure;
            _tmpUnitMeasure = _cursor.getInt(_cursorIndexOfUnitMeasure);
            _item.setUnitMeasure(_tmpUnitMeasure);
            final int _tmpUnitMeasurePurchase;
            _tmpUnitMeasurePurchase = _cursor.getInt(_cursorIndexOfUnitMeasurePurchase);
            _item.setUnitMeasurePurchase(_tmpUnitMeasurePurchase);
            final double _tmpFactor;
            _tmpFactor = _cursor.getDouble(_cursorIndexOfFactor);
            _item.setFactor(_tmpFactor);
            final int _tmpService;
            _tmpService = _cursor.getInt(_cursorIndexOfService);
            _item.setService(_tmpService);
            final int _tmpDiconsa;
            _tmpDiconsa = _cursor.getInt(_cursorIndexOfDiconsa);
            _item.setDiconsa(_tmpDiconsa);
            final Integer _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getInt(_cursorIndexOfCategory);
            }
            _item.setCategory(_tmpCategory);
            final int _tmpGranel;
            _tmpGranel = _cursor.getInt(_cursorIndexOfGranel);
            _item.setGranel(_tmpGranel);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
            final String _tmpRowId;
            _tmpRowId = _cursor.getString(_cursorIndexOfRowId);
            _item.setRowId(_tmpRowId);
            final double _tmpCost;
            _tmpCost = _cursor.getDouble(_cursorIndexOfCost);
            _item.setCost(_tmpCost);
            final double _tmpCostUC;
            _tmpCostUC = _cursor.getDouble(_cursorIndexOfCostUC);
            _item.setCostUC(_tmpCostUC);
            final String _tmpDateUC;
            _tmpDateUC = _cursor.getString(_cursorIndexOfDateUC);
            _item.setDateUC(_tmpDateUC);
            final String _tmpImage;
            _tmpImage = _cursor.getString(_cursorIndexOfImage);
            _item.setImage(_tmpImage);
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
  public int getCountProduct(String productUUID) {
    final String _sql = "SELECT COUNT(*) FROM Productos p where p.UUID=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (productUUID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, productUUID);
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

  @Override
  public Flowable<List<ProductPricePojo>> getFilterProductsPrice(String productDescription) {
    final String _sql = "SELECT u.Descripcion unitMeasurePurchase, p.UUID uuid, p.Descripcion description, p.Imagen image,p.Id idProduct,p.Estatus status,p.Categoria idCategory, p.Codigo code, p.CodigoAlterno alternateCode, p.Costo cost,p.CostoUC costUC, p.Diconsa diconsa, p.Factor factor, p.FechaUC dateUC,p.Granel granel, p.Maximo maximmn, p.Minimo minimumn,p.PuntoDeReorden reorderPoint,p.Servicio service, p.UnidadMedida measuereUnit, p.UnidadMedidaCompra measuereUnitPurchase, pp.Precio price,pp.Producto product,pp.Nivel level, pp.Cantidad quantity, pp.PorcentajeUtilidad percentage, pp.Monto_Utilidad utility FROM Productos p LEFT JOIN ProductoPrecio pp ON pp.Producto = p.Id INNER JOIN UnidadMedida u ON u.Id = p.UnidadMedida where  p.Estatus>-1 and p.Descripcion  glob '*'||?||'*' COLLATE NOCASE";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (productDescription == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, productDescription);
    }
    return RxRoom.createFlowable(__db, new String[]{"Productos","ProductoPrecio","UnidadMedida"}, new Callable<List<ProductPricePojo>>() {
      @Override
      public List<ProductPricePojo> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfUnitMeasurePurchase = _cursor.getColumnIndexOrThrow("unitMeasurePurchase");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("uuid");
          final int _cursorIndexOfDescription = _cursor.getColumnIndexOrThrow("description");
          final int _cursorIndexOfImage = _cursor.getColumnIndexOrThrow("image");
          final int _cursorIndexOfIdProduct = _cursor.getColumnIndexOrThrow("idProduct");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("status");
          final int _cursorIndexOfIdCategory = _cursor.getColumnIndexOrThrow("idCategory");
          final int _cursorIndexOfCode = _cursor.getColumnIndexOrThrow("code");
          final int _cursorIndexOfAlternateCode = _cursor.getColumnIndexOrThrow("alternateCode");
          final int _cursorIndexOfCost = _cursor.getColumnIndexOrThrow("cost");
          final int _cursorIndexOfCostUC = _cursor.getColumnIndexOrThrow("costUC");
          final int _cursorIndexOfDiconsa = _cursor.getColumnIndexOrThrow("diconsa");
          final int _cursorIndexOfFactor = _cursor.getColumnIndexOrThrow("factor");
          final int _cursorIndexOfDateUC = _cursor.getColumnIndexOrThrow("dateUC");
          final int _cursorIndexOfGranel = _cursor.getColumnIndexOrThrow("granel");
          final int _cursorIndexOfMaximmn = _cursor.getColumnIndexOrThrow("maximmn");
          final int _cursorIndexOfMinimumn = _cursor.getColumnIndexOrThrow("minimumn");
          final int _cursorIndexOfReorderPoint = _cursor.getColumnIndexOrThrow("reorderPoint");
          final int _cursorIndexOfService = _cursor.getColumnIndexOrThrow("service");
          final int _cursorIndexOfMeasuereUnit = _cursor.getColumnIndexOrThrow("measuereUnit");
          final int _cursorIndexOfMeasuereUnitPurchase = _cursor.getColumnIndexOrThrow("measuereUnitPurchase");
          final int _cursorIndexOfPrice = _cursor.getColumnIndexOrThrow("price");
          final int _cursorIndexOfProduct = _cursor.getColumnIndexOrThrow("product");
          final int _cursorIndexOfLevel = _cursor.getColumnIndexOrThrow("level");
          final int _cursorIndexOfQuantity = _cursor.getColumnIndexOrThrow("quantity");
          final int _cursorIndexOfPercentage = _cursor.getColumnIndexOrThrow("percentage");
          final int _cursorIndexOfUtility = _cursor.getColumnIndexOrThrow("utility");
          final List<ProductPricePojo> _result = new ArrayList<ProductPricePojo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ProductPricePojo _item;
            _item = new ProductPricePojo();
            final String _tmpUnitMeasurePurchase;
            _tmpUnitMeasurePurchase = _cursor.getString(_cursorIndexOfUnitMeasurePurchase);
            _item.setUnitMeasurePurchase(_tmpUnitMeasurePurchase);
            final String _tmpUuid;
            _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            _item.setUuid(_tmpUuid);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            _item.setDescription(_tmpDescription);
            final String _tmpImage;
            _tmpImage = _cursor.getString(_cursorIndexOfImage);
            _item.setImage(_tmpImage);
            final Integer _tmpIdProduct;
            if (_cursor.isNull(_cursorIndexOfIdProduct)) {
              _tmpIdProduct = null;
            } else {
              _tmpIdProduct = _cursor.getInt(_cursorIndexOfIdProduct);
            }
            _item.setIdProduct(_tmpIdProduct);
            final Integer _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            }
            _item.setStatus(_tmpStatus);
            final Integer _tmpIdCategory;
            if (_cursor.isNull(_cursorIndexOfIdCategory)) {
              _tmpIdCategory = null;
            } else {
              _tmpIdCategory = _cursor.getInt(_cursorIndexOfIdCategory);
            }
            _item.setIdCategory(_tmpIdCategory);
            final String _tmpCode;
            _tmpCode = _cursor.getString(_cursorIndexOfCode);
            _item.setCode(_tmpCode);
            final String _tmpAlternateCode;
            _tmpAlternateCode = _cursor.getString(_cursorIndexOfAlternateCode);
            _item.setAlternateCode(_tmpAlternateCode);
            final Double _tmpCost;
            if (_cursor.isNull(_cursorIndexOfCost)) {
              _tmpCost = null;
            } else {
              _tmpCost = _cursor.getDouble(_cursorIndexOfCost);
            }
            _item.setCost(_tmpCost);
            final Double _tmpCostUC;
            if (_cursor.isNull(_cursorIndexOfCostUC)) {
              _tmpCostUC = null;
            } else {
              _tmpCostUC = _cursor.getDouble(_cursorIndexOfCostUC);
            }
            _item.setCostUC(_tmpCostUC);
            final int _tmpDiconsa;
            _tmpDiconsa = _cursor.getInt(_cursorIndexOfDiconsa);
            _item.setDiconsa(_tmpDiconsa);
            final Double _tmpFactor;
            if (_cursor.isNull(_cursorIndexOfFactor)) {
              _tmpFactor = null;
            } else {
              _tmpFactor = _cursor.getDouble(_cursorIndexOfFactor);
            }
            _item.setFactor(_tmpFactor);
            final String _tmpDateUC;
            _tmpDateUC = _cursor.getString(_cursorIndexOfDateUC);
            _item.setDateUC(_tmpDateUC);
            final int _tmpGranel;
            _tmpGranel = _cursor.getInt(_cursorIndexOfGranel);
            _item.setGranel(_tmpGranel);
            final Double _tmpMaximmn;
            if (_cursor.isNull(_cursorIndexOfMaximmn)) {
              _tmpMaximmn = null;
            } else {
              _tmpMaximmn = _cursor.getDouble(_cursorIndexOfMaximmn);
            }
            _item.setMaximmn(_tmpMaximmn);
            final Double _tmpMinimumn;
            if (_cursor.isNull(_cursorIndexOfMinimumn)) {
              _tmpMinimumn = null;
            } else {
              _tmpMinimumn = _cursor.getDouble(_cursorIndexOfMinimumn);
            }
            _item.setMinimumn(_tmpMinimumn);
            final Double _tmpReorderPoint;
            if (_cursor.isNull(_cursorIndexOfReorderPoint)) {
              _tmpReorderPoint = null;
            } else {
              _tmpReorderPoint = _cursor.getDouble(_cursorIndexOfReorderPoint);
            }
            _item.setReorderPoint(_tmpReorderPoint);
            final int _tmpService;
            _tmpService = _cursor.getInt(_cursorIndexOfService);
            _item.setService(_tmpService);
            final Integer _tmpMeasuereUnit;
            if (_cursor.isNull(_cursorIndexOfMeasuereUnit)) {
              _tmpMeasuereUnit = null;
            } else {
              _tmpMeasuereUnit = _cursor.getInt(_cursorIndexOfMeasuereUnit);
            }
            _item.setMeasuereUnit(_tmpMeasuereUnit);
            final Integer _tmpMeasuereUnitPurchase;
            if (_cursor.isNull(_cursorIndexOfMeasuereUnitPurchase)) {
              _tmpMeasuereUnitPurchase = null;
            } else {
              _tmpMeasuereUnitPurchase = _cursor.getInt(_cursorIndexOfMeasuereUnitPurchase);
            }
            _item.setMeasuereUnitPurchase(_tmpMeasuereUnitPurchase);
            final Double _tmpPrice;
            if (_cursor.isNull(_cursorIndexOfPrice)) {
              _tmpPrice = null;
            } else {
              _tmpPrice = _cursor.getDouble(_cursorIndexOfPrice);
            }
            _item.setPrice(_tmpPrice);
            final Integer _tmpProduct;
            if (_cursor.isNull(_cursorIndexOfProduct)) {
              _tmpProduct = null;
            } else {
              _tmpProduct = _cursor.getInt(_cursorIndexOfProduct);
            }
            _item.setProduct(_tmpProduct);
            final Integer _tmpLevel;
            if (_cursor.isNull(_cursorIndexOfLevel)) {
              _tmpLevel = null;
            } else {
              _tmpLevel = _cursor.getInt(_cursorIndexOfLevel);
            }
            _item.setLevel(_tmpLevel);
            final Double _tmpQuantity;
            if (_cursor.isNull(_cursorIndexOfQuantity)) {
              _tmpQuantity = null;
            } else {
              _tmpQuantity = _cursor.getDouble(_cursorIndexOfQuantity);
            }
            _item.setQuantity(_tmpQuantity);
            final Double _tmpPercentage;
            if (_cursor.isNull(_cursorIndexOfPercentage)) {
              _tmpPercentage = null;
            } else {
              _tmpPercentage = _cursor.getDouble(_cursorIndexOfPercentage);
            }
            _item.setPercentage(_tmpPercentage);
            final Double _tmpUtility;
            if (_cursor.isNull(_cursorIndexOfUtility)) {
              _tmpUtility = null;
            } else {
              _tmpUtility = _cursor.getDouble(_cursorIndexOfUtility);
            }
            _item.setUtility(_tmpUtility);
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
  public Flowable<List<ProductEntity>> getFilterProductsCatalog() {
    final String _sql = "SELECT*FROM Productos p where p.Estatus>-1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"Productos"}, new Callable<List<ProductEntity>>() {
      @Override
      public List<ProductEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfCode = _cursor.getColumnIndexOrThrow("Codigo");
          final int _cursorIndexOfAlternateCode = _cursor.getColumnIndexOrThrow("CodigoAlterno");
          final int _cursorIndexOfDescription = _cursor.getColumnIndexOrThrow("Descripcion");
          final int _cursorIndexOfMaximum = _cursor.getColumnIndexOrThrow("Maximo");
          final int _cursorIndexOfMinimum = _cursor.getColumnIndexOrThrow("Minimo");
          final int _cursorIndexOfReorderPoint = _cursor.getColumnIndexOrThrow("PuntoDeReorden");
          final int _cursorIndexOfUnitMeasure = _cursor.getColumnIndexOrThrow("UnidadMedida");
          final int _cursorIndexOfUnitMeasurePurchase = _cursor.getColumnIndexOrThrow("UnidadMedidaCompra");
          final int _cursorIndexOfFactor = _cursor.getColumnIndexOrThrow("Factor");
          final int _cursorIndexOfService = _cursor.getColumnIndexOrThrow("Servicio");
          final int _cursorIndexOfDiconsa = _cursor.getColumnIndexOrThrow("Diconsa");
          final int _cursorIndexOfCategory = _cursor.getColumnIndexOrThrow("Categoria");
          final int _cursorIndexOfGranel = _cursor.getColumnIndexOrThrow("Granel");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfRowId = _cursor.getColumnIndexOrThrow("RowId");
          final int _cursorIndexOfCost = _cursor.getColumnIndexOrThrow("Costo");
          final int _cursorIndexOfCostUC = _cursor.getColumnIndexOrThrow("CostoUC");
          final int _cursorIndexOfDateUC = _cursor.getColumnIndexOrThrow("FechaUC");
          final int _cursorIndexOfImage = _cursor.getColumnIndexOrThrow("Imagen");
          final int _cursorIndexOfLastDateSync = _cursor.getColumnIndexOrThrow("UltimaActualizacion");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final List<ProductEntity> _result = new ArrayList<ProductEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ProductEntity _item;
            _item = new ProductEntity();
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final String _tmpCode;
            _tmpCode = _cursor.getString(_cursorIndexOfCode);
            _item.setCode(_tmpCode);
            final String _tmpAlternateCode;
            _tmpAlternateCode = _cursor.getString(_cursorIndexOfAlternateCode);
            _item.setAlternateCode(_tmpAlternateCode);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            _item.setDescription(_tmpDescription);
            final double _tmpMaximum;
            _tmpMaximum = _cursor.getDouble(_cursorIndexOfMaximum);
            _item.setMaximum(_tmpMaximum);
            final double _tmpMinimum;
            _tmpMinimum = _cursor.getDouble(_cursorIndexOfMinimum);
            _item.setMinimum(_tmpMinimum);
            final double _tmpReorderPoint;
            _tmpReorderPoint = _cursor.getDouble(_cursorIndexOfReorderPoint);
            _item.setReorderPoint(_tmpReorderPoint);
            final int _tmpUnitMeasure;
            _tmpUnitMeasure = _cursor.getInt(_cursorIndexOfUnitMeasure);
            _item.setUnitMeasure(_tmpUnitMeasure);
            final int _tmpUnitMeasurePurchase;
            _tmpUnitMeasurePurchase = _cursor.getInt(_cursorIndexOfUnitMeasurePurchase);
            _item.setUnitMeasurePurchase(_tmpUnitMeasurePurchase);
            final double _tmpFactor;
            _tmpFactor = _cursor.getDouble(_cursorIndexOfFactor);
            _item.setFactor(_tmpFactor);
            final int _tmpService;
            _tmpService = _cursor.getInt(_cursorIndexOfService);
            _item.setService(_tmpService);
            final int _tmpDiconsa;
            _tmpDiconsa = _cursor.getInt(_cursorIndexOfDiconsa);
            _item.setDiconsa(_tmpDiconsa);
            final Integer _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getInt(_cursorIndexOfCategory);
            }
            _item.setCategory(_tmpCategory);
            final int _tmpGranel;
            _tmpGranel = _cursor.getInt(_cursorIndexOfGranel);
            _item.setGranel(_tmpGranel);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
            final String _tmpRowId;
            _tmpRowId = _cursor.getString(_cursorIndexOfRowId);
            _item.setRowId(_tmpRowId);
            final double _tmpCost;
            _tmpCost = _cursor.getDouble(_cursorIndexOfCost);
            _item.setCost(_tmpCost);
            final double _tmpCostUC;
            _tmpCostUC = _cursor.getDouble(_cursorIndexOfCostUC);
            _item.setCostUC(_tmpCostUC);
            final String _tmpDateUC;
            _tmpDateUC = _cursor.getString(_cursorIndexOfDateUC);
            _item.setDateUC(_tmpDateUC);
            final String _tmpImage;
            _tmpImage = _cursor.getString(_cursorIndexOfImage);
            _item.setImage(_tmpImage);
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
  public Flowable<List<ProductEntity>> getFilterProductsCode(String code) {
    final String _sql = "SELECT*FROM Productos p where p.Estatus>-1 and p.Codigo = '*'||?||'*'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (code == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, code);
    }
    return RxRoom.createFlowable(__db, new String[]{"Productos"}, new Callable<List<ProductEntity>>() {
      @Override
      public List<ProductEntity> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("Id");
          final int _cursorIndexOfCode = _cursor.getColumnIndexOrThrow("Codigo");
          final int _cursorIndexOfAlternateCode = _cursor.getColumnIndexOrThrow("CodigoAlterno");
          final int _cursorIndexOfDescription = _cursor.getColumnIndexOrThrow("Descripcion");
          final int _cursorIndexOfMaximum = _cursor.getColumnIndexOrThrow("Maximo");
          final int _cursorIndexOfMinimum = _cursor.getColumnIndexOrThrow("Minimo");
          final int _cursorIndexOfReorderPoint = _cursor.getColumnIndexOrThrow("PuntoDeReorden");
          final int _cursorIndexOfUnitMeasure = _cursor.getColumnIndexOrThrow("UnidadMedida");
          final int _cursorIndexOfUnitMeasurePurchase = _cursor.getColumnIndexOrThrow("UnidadMedidaCompra");
          final int _cursorIndexOfFactor = _cursor.getColumnIndexOrThrow("Factor");
          final int _cursorIndexOfService = _cursor.getColumnIndexOrThrow("Servicio");
          final int _cursorIndexOfDiconsa = _cursor.getColumnIndexOrThrow("Diconsa");
          final int _cursorIndexOfCategory = _cursor.getColumnIndexOrThrow("Categoria");
          final int _cursorIndexOfGranel = _cursor.getColumnIndexOrThrow("Granel");
          final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("Estatus");
          final int _cursorIndexOfRowId = _cursor.getColumnIndexOrThrow("RowId");
          final int _cursorIndexOfCost = _cursor.getColumnIndexOrThrow("Costo");
          final int _cursorIndexOfCostUC = _cursor.getColumnIndexOrThrow("CostoUC");
          final int _cursorIndexOfDateUC = _cursor.getColumnIndexOrThrow("FechaUC");
          final int _cursorIndexOfImage = _cursor.getColumnIndexOrThrow("Imagen");
          final int _cursorIndexOfLastDateSync = _cursor.getColumnIndexOrThrow("UltimaActualizacion");
          final int _cursorIndexOfUuid = _cursor.getColumnIndexOrThrow("UUID");
          final List<ProductEntity> _result = new ArrayList<ProductEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ProductEntity _item;
            _item = new ProductEntity();
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final String _tmpCode;
            _tmpCode = _cursor.getString(_cursorIndexOfCode);
            _item.setCode(_tmpCode);
            final String _tmpAlternateCode;
            _tmpAlternateCode = _cursor.getString(_cursorIndexOfAlternateCode);
            _item.setAlternateCode(_tmpAlternateCode);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            _item.setDescription(_tmpDescription);
            final double _tmpMaximum;
            _tmpMaximum = _cursor.getDouble(_cursorIndexOfMaximum);
            _item.setMaximum(_tmpMaximum);
            final double _tmpMinimum;
            _tmpMinimum = _cursor.getDouble(_cursorIndexOfMinimum);
            _item.setMinimum(_tmpMinimum);
            final double _tmpReorderPoint;
            _tmpReorderPoint = _cursor.getDouble(_cursorIndexOfReorderPoint);
            _item.setReorderPoint(_tmpReorderPoint);
            final int _tmpUnitMeasure;
            _tmpUnitMeasure = _cursor.getInt(_cursorIndexOfUnitMeasure);
            _item.setUnitMeasure(_tmpUnitMeasure);
            final int _tmpUnitMeasurePurchase;
            _tmpUnitMeasurePurchase = _cursor.getInt(_cursorIndexOfUnitMeasurePurchase);
            _item.setUnitMeasurePurchase(_tmpUnitMeasurePurchase);
            final double _tmpFactor;
            _tmpFactor = _cursor.getDouble(_cursorIndexOfFactor);
            _item.setFactor(_tmpFactor);
            final int _tmpService;
            _tmpService = _cursor.getInt(_cursorIndexOfService);
            _item.setService(_tmpService);
            final int _tmpDiconsa;
            _tmpDiconsa = _cursor.getInt(_cursorIndexOfDiconsa);
            _item.setDiconsa(_tmpDiconsa);
            final Integer _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getInt(_cursorIndexOfCategory);
            }
            _item.setCategory(_tmpCategory);
            final int _tmpGranel;
            _tmpGranel = _cursor.getInt(_cursorIndexOfGranel);
            _item.setGranel(_tmpGranel);
            final int _tmpStatus;
            _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
            final String _tmpRowId;
            _tmpRowId = _cursor.getString(_cursorIndexOfRowId);
            _item.setRowId(_tmpRowId);
            final double _tmpCost;
            _tmpCost = _cursor.getDouble(_cursorIndexOfCost);
            _item.setCost(_tmpCost);
            final double _tmpCostUC;
            _tmpCostUC = _cursor.getDouble(_cursorIndexOfCostUC);
            _item.setCostUC(_tmpCostUC);
            final String _tmpDateUC;
            _tmpDateUC = _cursor.getString(_cursorIndexOfDateUC);
            _item.setDateUC(_tmpDateUC);
            final String _tmpImage;
            _tmpImage = _cursor.getString(_cursorIndexOfImage);
            _item.setImage(_tmpImage);
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
}
