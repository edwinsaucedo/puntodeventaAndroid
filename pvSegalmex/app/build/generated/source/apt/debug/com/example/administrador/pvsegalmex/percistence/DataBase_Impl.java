package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import android.arch.persistence.room.util.TableInfo.Index;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public class DataBase_Impl extends DataBase {
  private volatile ClienteDao _clienteDao;

  private volatile WayPayDao _wayPayDao;

  private volatile DepartmentDao _departmentDao;

  private volatile ProviderDao _providerDao;

  private volatile CategoryDao _categoryDao;

  private volatile ProductDao _productDao;

  private volatile WithdrawalDao _withdrawalDao;

  private volatile TypeDocumentsDao _typeDocumentsDao;

  private volatile ProductPriceDao _productPriceDao;

  private volatile CashShortDetailDao _cashShortDetailDao;

  private volatile StoreDao _storeDao;

  private volatile SalesDao _salesDao;

  private volatile CashIncomeDao _cashIncomeDao;

  private volatile SalesDetailDao _salesDetailDao;

  private volatile CashRegisterDao _cashRegisterDao;

  private volatile CollectionOfPaymentDao _collectionOfPaymentDao;

  private volatile ReceiptOfMerchandiseDao _receiptOfMerchandiseDao;

  private volatile ReceiptOfMerchandiseDetailDao _receiptOfMerchandiseDetailDao;

  private volatile ExistDao _existDao;

  private volatile KardexDao _kardexDao;

  private volatile KardexDetailDao _kardexDetailDao;

  private volatile BitacoraDao _bitacoraDao;

  private volatile UserDao _userDao;

  private volatile CashShortDao _cashShortDao;

  private volatile UnitMeasurementDao _unitMeasurementDao;

  private volatile WithdrawalDetailDao _withdrawalDetailDao;

  private volatile CashIncomeDetailDao _cashIncomeDetailDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(10) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Cliente` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT, `Nombre` TEXT, `ApellidoPaterno` TEXT, `ApellidoMaterno` TEXT, `LimiteCredito` REAL NOT NULL, `DiasCredito` INTEGER NOT NULL, `Genero` INTEGER NOT NULL, `Direccion` TEXT, `Curp` TEXT, `CadenaINE` TEXT, `FotoCliente` TEXT, `Estatus` INTEGER NOT NULL, `FotoINE` TEXT, `Email` TEXT, `Telefono` TEXT, `FechaUltimaVenta` TEXT, `UUID` TEXT, `UltimaActualizacion` TEXT, `Compania` INTEGER, `Fecha` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `FormaPago` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT, `Description` TEXT, `Image` TEXT, `Estus` INTEGER NOT NULL, `UltimaActualizacion` TEXT, `UUID` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Bitacora` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT, `Fecha` TEXT, `Estatus` INTEGER NOT NULL, `Tabla` TEXT, `IdTabla` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Departamentos` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT, `Descripcion` TEXT, `Estatus` INTEGER NOT NULL, `UUID` TEXT, `UltimaActualizacion` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Proveedores` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT, `Nombre` TEXT, `Rfc` TEXT, `FechaPago` TEXT, `Alias` TEXT, `Curp` TEXT, `Telefono` TEXT, `Email` TEXT, `Comentarios` TEXT, `LimiteCredito` REAL NOT NULL, `DiasCredito` INTEGER NOT NULL, `Diconsa` INTEGER NOT NULL, `Estatus` INTEGER NOT NULL, `UltimaActualizacion` TEXT, `UUID` TEXT, `Fecha` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Categorias` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT, `Departamento` INTEGER, `Descripcion` TEXT, `Estatus` INTEGER NOT NULL, `UUID` TEXT, `UltimaActualizacion` TEXT, FOREIGN KEY(`Departamento`) REFERENCES `Departamentos`(`Id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `KardexDetalle` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT, `Producto` INTEGER, `UnidadMedida` INTEGER, `Kardex` INTEGER, `Cantidad` REAL, `Factor` REAL, `Costo` REAL, `Valor` REAL, `Estatus` INTEGER NOT NULL, `UUID` TEXT, `Fecha` TEXT, `UUIDKardex` TEXT, `UUIDProduct` TEXT, FOREIGN KEY(`Producto`) REFERENCES `Productos`(`Id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`Kardex`) REFERENCES `Kardex`(`Id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Usuario` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT, `IdWs` INTEGER, `Nombre` TEXT, `TipoUsuario` INTEGER, `Compania` INTEGER, `Usuario` INTEGER, `Password` TEXT, `Email` TEXT, `ClaveAcceso` TEXT, `UsuarioPV` INTEGER NOT NULL, `Estatus` INTEGER NOT NULL, `UUID` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `CorteCaja` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT, `Usuario` INTEGER, `Fecha` TEXT, `TotalCalculado` REAL, `MontoCapturado` REAL, `Diferencia` REAL, `UUID` TEXT, `UUIDUser` TEXT, `Estatus` INTEGER NOT NULL, FOREIGN KEY(`Usuario`) REFERENCES `Usuario`(`Id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `RetiroCaja` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT, `Usuario` INTEGER, `Fecha` TEXT, `Comentarios` TEXT, `Monto` REAL, `CorteCaja` INTEGER, `Estatus` INTEGER NOT NULL, `UUID` TEXT, `UUIDCorteCaja` TEXT, FOREIGN KEY(`CorteCaja`) REFERENCES `CorteCaja`(`Id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`Usuario`) REFERENCES `Usuario`(`Id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Existencia` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT, `Producto` INTEGER, `Disponible` REAL, `Transito` REAL, `Existencia` REAL, `Comprometida` REAL, `Sicroniza` INTEGER, `FechaActualizacion` TEXT, `UUID` TEXT, `Estatus` INTEGER NOT NULL, `Fecha` TEXT, `UUIDProducto` TEXT, FOREIGN KEY(`Producto`) REFERENCES `Productos`(`Id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Kardex` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT, `TipoDocumento` INTEGER, `NumeroDocumento` INTEGER, `Fecha` TEXT, `Usuario` INTEGER, `Estatus` INTEGER NOT NULL, `UUID` TEXT, `UUIDTipoDocumento` TEXT, `UUIDUser` TEXT, FOREIGN KEY(`TipoDocumento`) REFERENCES `TipoDocumentoVta`(`Id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`Usuario`) REFERENCES `Usuario`(`Id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ReciboMercancia` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT, `Diconsa` INTEGER NOT NULL, `Fecha` TEXT, `Consecutivo` INTEGER NOT NULL, `Articulos` INTEGER NOT NULL, `Subtotal` REAL, `Total` REAL, `Folio` TEXT, `Comentario` TEXT, `Proveedor` INTEGER, `Estatus` INTEGER NOT NULL, `UUID` TEXT, `UUIDProveedor` TEXT, FOREIGN KEY(`Proveedor`) REFERENCES `Proveedores`(`Id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ReciboMercanciaDetalle` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT, `ReciboMercancia` INTEGER, `UnidadMedida` INTEGER, `Producto` INTEGER, `Partida` INTEGER NOT NULL, `Cantidad` REAL, `Precio` REAL, `Subtotal` REAL, `Total` REAL, `Factor` REAL, `Estatus` INTEGER NOT NULL, `UUID` TEXT, `Fecha` TEXT, `UUIDReciboMercancia` TEXT, `UUIDProduct` TEXT, FOREIGN KEY(`ReciboMercancia`) REFERENCES `ReciboMercancia`(`Id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`Producto`) REFERENCES `Productos`(`Id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`UnidadMedida`) REFERENCES `UnidadMedida`(`Id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `VentaCobro` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT, `Venta` INTEGER, `FormaPago` INTEGER, `CorteCaja` INTEGER, `Monto` REAL, `Estatus` INTEGER NOT NULL, `Fecha` TEXT, `UUID` TEXT, `UUIDVenta` TEXT, `UUIDFormaPago` TEXT, `UUIDCorteCaja` TEXT, FOREIGN KEY(`Venta`) REFERENCES `Venta`(`Id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`FormaPago`) REFERENCES `FormaPago`(`Id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`CorteCaja`) REFERENCES `CorteCaja`(`Id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `CajaRegistradora` (`Id` INTEGER, `TotalVentas` REAL, `TotalRetiros` REAL, `TotalIngresos` REAL, `TotalCaja` REAL, `Estatus` INTEGER NOT NULL, PRIMARY KEY(`Id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Tienda` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT, `NumeroTelefono` TEXT, `NombreTienda` TEXT, `Longitud` REAL, `Latitud` REAL, `Direccion` TEXT, `Propietario` TEXT, `Imagen` TEXT, `Nombre` TEXT, `RFC` TEXT, `Regimen` TEXT, `Password` TEXT, `ArchivoCSD` INTEGER, `ArchivoKey` INTEGER, `Facturar` INTEGER, `DireccionLocal` TEXT, `Estatus` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Ingresos` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT, `Fecha` TEXT, `Comentarios` TEXT, `Monto` REAL, `Estatus` INTEGER NOT NULL, `UUID` TEXT, `CorteCaja` INTEGER, `UUIDCorteCaja` TEXT, FOREIGN KEY(`CorteCaja`) REFERENCES `CorteCaja`(`Id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Productos` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT, `Codigo` TEXT, `CodigoAlterno` TEXT, `Descripcion` TEXT, `Maximo` REAL NOT NULL, `Minimo` REAL NOT NULL, `PuntoDeReorden` REAL NOT NULL, `UnidadMedida` INTEGER NOT NULL, `UnidadMedidaCompra` INTEGER NOT NULL, `Factor` REAL NOT NULL, `Servicio` INTEGER NOT NULL, `Diconsa` INTEGER NOT NULL, `Categoria` INTEGER, `Granel` INTEGER NOT NULL, `Estatus` INTEGER NOT NULL, `RowId` TEXT, `Costo` REAL NOT NULL, `CostoUC` REAL NOT NULL, `FechaUC` TEXT, `Imagen` TEXT, `UltimaActualizacion` TEXT, `UUID` TEXT, FOREIGN KEY(`Categoria`) REFERENCES `Categorias`(`Id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Venta` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT, `Fecha` TEXT, `NoArticles` INTEGER NOT NULL, `Total` REAL, `Estatus` INTEGER NOT NULL, `FormaPago` INTEGER, `TipoDocumentoVta` INTEGER, `Cliente` INTEGER, `EstatusVenta` TEXT, `CorteCaja` INTEGER, `DocumentFolio` INTEGER NOT NULL, `UUID` TEXT, `UUIDCorteCaja` TEXT, `UUIDTipoDocumento` TEXT, `UUIDCliente` TEXT, `UUIDWayPay` TEXT, `Monto_Utilidad` REAL, `Porcentaje_Utilidad` REAL, FOREIGN KEY(`Cliente`) REFERENCES `Cliente`(`Id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`FormaPago`) REFERENCES `FormaPago`(`Id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`TipoDocumentoVta`) REFERENCES `TipoDocumentoVta`(`Id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`CorteCaja`) REFERENCES `CorteCaja`(`Id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `CorteCajaDetalle` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT, `CorteCaja` INTEGER, `FormaPago` INTEGER, `MontoCalculado` REAL, `MontoCapturado` REAL, `Diference` REAL, `Estatus` INTEGER NOT NULL, `Fecha` TEXT, `UUID` TEXT, `UUIDCorteCaja` TEXT, `UUIDFormaPago` TEXT, FOREIGN KEY(`CorteCaja`) REFERENCES `CorteCaja`(`Id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`FormaPago`) REFERENCES `FormaPago`(`Id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `TipoDocumentoVta` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT, `Descripcion` TEXT, `Consecutivo` INTEGER NOT NULL, `Estus` INTEGER NOT NULL, `Modulo` TEXT, `UUID` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ProductoPrecio` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT, `Nivel` INTEGER, `Precio` REAL NOT NULL, `PorcentajeUtilidad` REAL NOT NULL, `Costo` REAL NOT NULL, `Cantidad` REAL NOT NULL, `Producto` INTEGER NOT NULL, `UUID` TEXT, `UUIDProducto` TEXT, `Monto_Utilidad` REAL, FOREIGN KEY(`Producto`) REFERENCES `Productos`(`Id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `VentaDetalle` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT, `Venta` INTEGER, `Producto` INTEGER, `Cantidad` REAL, `PrecioUnitario` REAL, `DescuentoPorcentaje` REAL, `DescuentoMontoUnitario` REAL, `Subtotal` REAL, `Impuestos` REAL, `Total` REAL, `Estatus` INTEGER, `Fecha` TEXT, `UUID` TEXT, `UUIDSale` TEXT, `UUIDProducto` TEXT, `Porcentaje_Utilidad` REAL, `Monto_Utilidad` REAL, `Costo_Producto` REAL, `Monto_Unitario_Utilidad` REAL, FOREIGN KEY(`Venta`) REFERENCES `Venta`(`Id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`Producto`) REFERENCES `Productos`(`Id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `UnidadMedida` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT, `Clave` TEXT, `Descripcion` TEXT, `ClaveSAT` TEXT, `UUID` TEXT, `UltimaActualizacion` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `RetiroCajaDetalle` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT, `FormaPago` INTEGER, `RetiroCaja` INTEGER, `Monto` REAL, `UltimaActualizacion` TEXT, `UUID` TEXT, FOREIGN KEY(`RetiroCaja`) REFERENCES `RetiroCaja`(`Id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`FormaPago`) REFERENCES `FormaPago`(`Id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `IngresosDetalle` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT, `FormaPago` INTEGER, `Ingresos` INTEGER, `Monto` REAL, `UltimaActualizacion` TEXT, `UUID` TEXT, FOREIGN KEY(`Ingresos`) REFERENCES `Ingresos`(`Id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`FormaPago`) REFERENCES `FormaPago`(`Id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"90cd68fa9ad56a89f8632e55d7174ed1\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Cliente`");
        _db.execSQL("DROP TABLE IF EXISTS `FormaPago`");
        _db.execSQL("DROP TABLE IF EXISTS `Bitacora`");
        _db.execSQL("DROP TABLE IF EXISTS `Departamentos`");
        _db.execSQL("DROP TABLE IF EXISTS `Proveedores`");
        _db.execSQL("DROP TABLE IF EXISTS `Categorias`");
        _db.execSQL("DROP TABLE IF EXISTS `KardexDetalle`");
        _db.execSQL("DROP TABLE IF EXISTS `Usuario`");
        _db.execSQL("DROP TABLE IF EXISTS `CorteCaja`");
        _db.execSQL("DROP TABLE IF EXISTS `RetiroCaja`");
        _db.execSQL("DROP TABLE IF EXISTS `Existencia`");
        _db.execSQL("DROP TABLE IF EXISTS `Kardex`");
        _db.execSQL("DROP TABLE IF EXISTS `ReciboMercancia`");
        _db.execSQL("DROP TABLE IF EXISTS `ReciboMercanciaDetalle`");
        _db.execSQL("DROP TABLE IF EXISTS `VentaCobro`");
        _db.execSQL("DROP TABLE IF EXISTS `CajaRegistradora`");
        _db.execSQL("DROP TABLE IF EXISTS `Tienda`");
        _db.execSQL("DROP TABLE IF EXISTS `Ingresos`");
        _db.execSQL("DROP TABLE IF EXISTS `Productos`");
        _db.execSQL("DROP TABLE IF EXISTS `Venta`");
        _db.execSQL("DROP TABLE IF EXISTS `CorteCajaDetalle`");
        _db.execSQL("DROP TABLE IF EXISTS `TipoDocumentoVta`");
        _db.execSQL("DROP TABLE IF EXISTS `ProductoPrecio`");
        _db.execSQL("DROP TABLE IF EXISTS `VentaDetalle`");
        _db.execSQL("DROP TABLE IF EXISTS `UnidadMedida`");
        _db.execSQL("DROP TABLE IF EXISTS `RetiroCajaDetalle`");
        _db.execSQL("DROP TABLE IF EXISTS `IngresosDetalle`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        _db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsCliente = new HashMap<String, TableInfo.Column>(20);
        _columnsCliente.put("Id", new TableInfo.Column("Id", "INTEGER", false, 1));
        _columnsCliente.put("Nombre", new TableInfo.Column("Nombre", "TEXT", false, 0));
        _columnsCliente.put("ApellidoPaterno", new TableInfo.Column("ApellidoPaterno", "TEXT", false, 0));
        _columnsCliente.put("ApellidoMaterno", new TableInfo.Column("ApellidoMaterno", "TEXT", false, 0));
        _columnsCliente.put("LimiteCredito", new TableInfo.Column("LimiteCredito", "REAL", true, 0));
        _columnsCliente.put("DiasCredito", new TableInfo.Column("DiasCredito", "INTEGER", true, 0));
        _columnsCliente.put("Genero", new TableInfo.Column("Genero", "INTEGER", true, 0));
        _columnsCliente.put("Direccion", new TableInfo.Column("Direccion", "TEXT", false, 0));
        _columnsCliente.put("Curp", new TableInfo.Column("Curp", "TEXT", false, 0));
        _columnsCliente.put("CadenaINE", new TableInfo.Column("CadenaINE", "TEXT", false, 0));
        _columnsCliente.put("FotoCliente", new TableInfo.Column("FotoCliente", "TEXT", false, 0));
        _columnsCliente.put("Estatus", new TableInfo.Column("Estatus", "INTEGER", true, 0));
        _columnsCliente.put("FotoINE", new TableInfo.Column("FotoINE", "TEXT", false, 0));
        _columnsCliente.put("Email", new TableInfo.Column("Email", "TEXT", false, 0));
        _columnsCliente.put("Telefono", new TableInfo.Column("Telefono", "TEXT", false, 0));
        _columnsCliente.put("FechaUltimaVenta", new TableInfo.Column("FechaUltimaVenta", "TEXT", false, 0));
        _columnsCliente.put("UUID", new TableInfo.Column("UUID", "TEXT", false, 0));
        _columnsCliente.put("UltimaActualizacion", new TableInfo.Column("UltimaActualizacion", "TEXT", false, 0));
        _columnsCliente.put("Compania", new TableInfo.Column("Compania", "INTEGER", false, 0));
        _columnsCliente.put("Fecha", new TableInfo.Column("Fecha", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCliente = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCliente = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCliente = new TableInfo("Cliente", _columnsCliente, _foreignKeysCliente, _indicesCliente);
        final TableInfo _existingCliente = TableInfo.read(_db, "Cliente");
        if (! _infoCliente.equals(_existingCliente)) {
          throw new IllegalStateException("Migration didn't properly handle Cliente(com.example.administrador.pvsegalmex.entity.ClienteEntity).\n"
                  + " Expected:\n" + _infoCliente + "\n"
                  + " Found:\n" + _existingCliente);
        }
        final HashMap<String, TableInfo.Column> _columnsFormaPago = new HashMap<String, TableInfo.Column>(6);
        _columnsFormaPago.put("Id", new TableInfo.Column("Id", "INTEGER", false, 1));
        _columnsFormaPago.put("Description", new TableInfo.Column("Description", "TEXT", false, 0));
        _columnsFormaPago.put("Image", new TableInfo.Column("Image", "TEXT", false, 0));
        _columnsFormaPago.put("Estus", new TableInfo.Column("Estus", "INTEGER", true, 0));
        _columnsFormaPago.put("UltimaActualizacion", new TableInfo.Column("UltimaActualizacion", "TEXT", false, 0));
        _columnsFormaPago.put("UUID", new TableInfo.Column("UUID", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFormaPago = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFormaPago = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFormaPago = new TableInfo("FormaPago", _columnsFormaPago, _foreignKeysFormaPago, _indicesFormaPago);
        final TableInfo _existingFormaPago = TableInfo.read(_db, "FormaPago");
        if (! _infoFormaPago.equals(_existingFormaPago)) {
          throw new IllegalStateException("Migration didn't properly handle FormaPago(com.example.administrador.pvsegalmex.entity.WayPayEntity).\n"
                  + " Expected:\n" + _infoFormaPago + "\n"
                  + " Found:\n" + _existingFormaPago);
        }
        final HashMap<String, TableInfo.Column> _columnsBitacora = new HashMap<String, TableInfo.Column>(5);
        _columnsBitacora.put("Id", new TableInfo.Column("Id", "INTEGER", false, 1));
        _columnsBitacora.put("Fecha", new TableInfo.Column("Fecha", "TEXT", false, 0));
        _columnsBitacora.put("Estatus", new TableInfo.Column("Estatus", "INTEGER", true, 0));
        _columnsBitacora.put("Tabla", new TableInfo.Column("Tabla", "TEXT", false, 0));
        _columnsBitacora.put("IdTabla", new TableInfo.Column("IdTabla", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBitacora = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBitacora = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBitacora = new TableInfo("Bitacora", _columnsBitacora, _foreignKeysBitacora, _indicesBitacora);
        final TableInfo _existingBitacora = TableInfo.read(_db, "Bitacora");
        if (! _infoBitacora.equals(_existingBitacora)) {
          throw new IllegalStateException("Migration didn't properly handle Bitacora(com.example.administrador.pvsegalmex.entity.BitacoraEntity).\n"
                  + " Expected:\n" + _infoBitacora + "\n"
                  + " Found:\n" + _existingBitacora);
        }
        final HashMap<String, TableInfo.Column> _columnsDepartamentos = new HashMap<String, TableInfo.Column>(5);
        _columnsDepartamentos.put("Id", new TableInfo.Column("Id", "INTEGER", false, 1));
        _columnsDepartamentos.put("Descripcion", new TableInfo.Column("Descripcion", "TEXT", false, 0));
        _columnsDepartamentos.put("Estatus", new TableInfo.Column("Estatus", "INTEGER", true, 0));
        _columnsDepartamentos.put("UUID", new TableInfo.Column("UUID", "TEXT", false, 0));
        _columnsDepartamentos.put("UltimaActualizacion", new TableInfo.Column("UltimaActualizacion", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDepartamentos = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesDepartamentos = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDepartamentos = new TableInfo("Departamentos", _columnsDepartamentos, _foreignKeysDepartamentos, _indicesDepartamentos);
        final TableInfo _existingDepartamentos = TableInfo.read(_db, "Departamentos");
        if (! _infoDepartamentos.equals(_existingDepartamentos)) {
          throw new IllegalStateException("Migration didn't properly handle Departamentos(com.example.administrador.pvsegalmex.entity.DepartmentEntity).\n"
                  + " Expected:\n" + _infoDepartamentos + "\n"
                  + " Found:\n" + _existingDepartamentos);
        }
        final HashMap<String, TableInfo.Column> _columnsProveedores = new HashMap<String, TableInfo.Column>(16);
        _columnsProveedores.put("Id", new TableInfo.Column("Id", "INTEGER", false, 1));
        _columnsProveedores.put("Nombre", new TableInfo.Column("Nombre", "TEXT", false, 0));
        _columnsProveedores.put("Rfc", new TableInfo.Column("Rfc", "TEXT", false, 0));
        _columnsProveedores.put("FechaPago", new TableInfo.Column("FechaPago", "TEXT", false, 0));
        _columnsProveedores.put("Alias", new TableInfo.Column("Alias", "TEXT", false, 0));
        _columnsProveedores.put("Curp", new TableInfo.Column("Curp", "TEXT", false, 0));
        _columnsProveedores.put("Telefono", new TableInfo.Column("Telefono", "TEXT", false, 0));
        _columnsProveedores.put("Email", new TableInfo.Column("Email", "TEXT", false, 0));
        _columnsProveedores.put("Comentarios", new TableInfo.Column("Comentarios", "TEXT", false, 0));
        _columnsProveedores.put("LimiteCredito", new TableInfo.Column("LimiteCredito", "REAL", true, 0));
        _columnsProveedores.put("DiasCredito", new TableInfo.Column("DiasCredito", "INTEGER", true, 0));
        _columnsProveedores.put("Diconsa", new TableInfo.Column("Diconsa", "INTEGER", true, 0));
        _columnsProveedores.put("Estatus", new TableInfo.Column("Estatus", "INTEGER", true, 0));
        _columnsProveedores.put("UltimaActualizacion", new TableInfo.Column("UltimaActualizacion", "TEXT", false, 0));
        _columnsProveedores.put("UUID", new TableInfo.Column("UUID", "TEXT", false, 0));
        _columnsProveedores.put("Fecha", new TableInfo.Column("Fecha", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysProveedores = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesProveedores = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoProveedores = new TableInfo("Proveedores", _columnsProveedores, _foreignKeysProveedores, _indicesProveedores);
        final TableInfo _existingProveedores = TableInfo.read(_db, "Proveedores");
        if (! _infoProveedores.equals(_existingProveedores)) {
          throw new IllegalStateException("Migration didn't properly handle Proveedores(com.example.administrador.pvsegalmex.entity.ProviderEntity).\n"
                  + " Expected:\n" + _infoProveedores + "\n"
                  + " Found:\n" + _existingProveedores);
        }
        final HashMap<String, TableInfo.Column> _columnsCategorias = new HashMap<String, TableInfo.Column>(6);
        _columnsCategorias.put("Id", new TableInfo.Column("Id", "INTEGER", false, 1));
        _columnsCategorias.put("Departamento", new TableInfo.Column("Departamento", "INTEGER", false, 0));
        _columnsCategorias.put("Descripcion", new TableInfo.Column("Descripcion", "TEXT", false, 0));
        _columnsCategorias.put("Estatus", new TableInfo.Column("Estatus", "INTEGER", true, 0));
        _columnsCategorias.put("UUID", new TableInfo.Column("UUID", "TEXT", false, 0));
        _columnsCategorias.put("UltimaActualizacion", new TableInfo.Column("UltimaActualizacion", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCategorias = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysCategorias.add(new TableInfo.ForeignKey("Departamentos", "NO ACTION", "NO ACTION",Arrays.asList("Departamento"), Arrays.asList("Id")));
        final HashSet<TableInfo.Index> _indicesCategorias = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCategorias = new TableInfo("Categorias", _columnsCategorias, _foreignKeysCategorias, _indicesCategorias);
        final TableInfo _existingCategorias = TableInfo.read(_db, "Categorias");
        if (! _infoCategorias.equals(_existingCategorias)) {
          throw new IllegalStateException("Migration didn't properly handle Categorias(com.example.administrador.pvsegalmex.entity.CategoryEntity).\n"
                  + " Expected:\n" + _infoCategorias + "\n"
                  + " Found:\n" + _existingCategorias);
        }
        final HashMap<String, TableInfo.Column> _columnsKardexDetalle = new HashMap<String, TableInfo.Column>(13);
        _columnsKardexDetalle.put("Id", new TableInfo.Column("Id", "INTEGER", false, 1));
        _columnsKardexDetalle.put("Producto", new TableInfo.Column("Producto", "INTEGER", false, 0));
        _columnsKardexDetalle.put("UnidadMedida", new TableInfo.Column("UnidadMedida", "INTEGER", false, 0));
        _columnsKardexDetalle.put("Kardex", new TableInfo.Column("Kardex", "INTEGER", false, 0));
        _columnsKardexDetalle.put("Cantidad", new TableInfo.Column("Cantidad", "REAL", false, 0));
        _columnsKardexDetalle.put("Factor", new TableInfo.Column("Factor", "REAL", false, 0));
        _columnsKardexDetalle.put("Costo", new TableInfo.Column("Costo", "REAL", false, 0));
        _columnsKardexDetalle.put("Valor", new TableInfo.Column("Valor", "REAL", false, 0));
        _columnsKardexDetalle.put("Estatus", new TableInfo.Column("Estatus", "INTEGER", true, 0));
        _columnsKardexDetalle.put("UUID", new TableInfo.Column("UUID", "TEXT", false, 0));
        _columnsKardexDetalle.put("Fecha", new TableInfo.Column("Fecha", "TEXT", false, 0));
        _columnsKardexDetalle.put("UUIDKardex", new TableInfo.Column("UUIDKardex", "TEXT", false, 0));
        _columnsKardexDetalle.put("UUIDProduct", new TableInfo.Column("UUIDProduct", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysKardexDetalle = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysKardexDetalle.add(new TableInfo.ForeignKey("Productos", "NO ACTION", "NO ACTION",Arrays.asList("Producto"), Arrays.asList("Id")));
        _foreignKeysKardexDetalle.add(new TableInfo.ForeignKey("Kardex", "NO ACTION", "NO ACTION",Arrays.asList("Kardex"), Arrays.asList("Id")));
        final HashSet<TableInfo.Index> _indicesKardexDetalle = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoKardexDetalle = new TableInfo("KardexDetalle", _columnsKardexDetalle, _foreignKeysKardexDetalle, _indicesKardexDetalle);
        final TableInfo _existingKardexDetalle = TableInfo.read(_db, "KardexDetalle");
        if (! _infoKardexDetalle.equals(_existingKardexDetalle)) {
          throw new IllegalStateException("Migration didn't properly handle KardexDetalle(com.example.administrador.pvsegalmex.entity.KardexDetailEntity).\n"
                  + " Expected:\n" + _infoKardexDetalle + "\n"
                  + " Found:\n" + _existingKardexDetalle);
        }
        final HashMap<String, TableInfo.Column> _columnsUsuario = new HashMap<String, TableInfo.Column>(12);
        _columnsUsuario.put("Id", new TableInfo.Column("Id", "INTEGER", false, 1));
        _columnsUsuario.put("IdWs", new TableInfo.Column("IdWs", "INTEGER", false, 0));
        _columnsUsuario.put("Nombre", new TableInfo.Column("Nombre", "TEXT", false, 0));
        _columnsUsuario.put("TipoUsuario", new TableInfo.Column("TipoUsuario", "INTEGER", false, 0));
        _columnsUsuario.put("Compania", new TableInfo.Column("Compania", "INTEGER", false, 0));
        _columnsUsuario.put("Usuario", new TableInfo.Column("Usuario", "INTEGER", false, 0));
        _columnsUsuario.put("Password", new TableInfo.Column("Password", "TEXT", false, 0));
        _columnsUsuario.put("Email", new TableInfo.Column("Email", "TEXT", false, 0));
        _columnsUsuario.put("ClaveAcceso", new TableInfo.Column("ClaveAcceso", "TEXT", false, 0));
        _columnsUsuario.put("UsuarioPV", new TableInfo.Column("UsuarioPV", "INTEGER", true, 0));
        _columnsUsuario.put("Estatus", new TableInfo.Column("Estatus", "INTEGER", true, 0));
        _columnsUsuario.put("UUID", new TableInfo.Column("UUID", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUsuario = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUsuario = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUsuario = new TableInfo("Usuario", _columnsUsuario, _foreignKeysUsuario, _indicesUsuario);
        final TableInfo _existingUsuario = TableInfo.read(_db, "Usuario");
        if (! _infoUsuario.equals(_existingUsuario)) {
          throw new IllegalStateException("Migration didn't properly handle Usuario(com.example.administrador.pvsegalmex.entity.UserEntity).\n"
                  + " Expected:\n" + _infoUsuario + "\n"
                  + " Found:\n" + _existingUsuario);
        }
        final HashMap<String, TableInfo.Column> _columnsCorteCaja = new HashMap<String, TableInfo.Column>(9);
        _columnsCorteCaja.put("Id", new TableInfo.Column("Id", "INTEGER", false, 1));
        _columnsCorteCaja.put("Usuario", new TableInfo.Column("Usuario", "INTEGER", false, 0));
        _columnsCorteCaja.put("Fecha", new TableInfo.Column("Fecha", "TEXT", false, 0));
        _columnsCorteCaja.put("TotalCalculado", new TableInfo.Column("TotalCalculado", "REAL", false, 0));
        _columnsCorteCaja.put("MontoCapturado", new TableInfo.Column("MontoCapturado", "REAL", false, 0));
        _columnsCorteCaja.put("Diferencia", new TableInfo.Column("Diferencia", "REAL", false, 0));
        _columnsCorteCaja.put("UUID", new TableInfo.Column("UUID", "TEXT", false, 0));
        _columnsCorteCaja.put("UUIDUser", new TableInfo.Column("UUIDUser", "TEXT", false, 0));
        _columnsCorteCaja.put("Estatus", new TableInfo.Column("Estatus", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCorteCaja = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysCorteCaja.add(new TableInfo.ForeignKey("Usuario", "NO ACTION", "NO ACTION",Arrays.asList("Usuario"), Arrays.asList("Id")));
        final HashSet<TableInfo.Index> _indicesCorteCaja = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCorteCaja = new TableInfo("CorteCaja", _columnsCorteCaja, _foreignKeysCorteCaja, _indicesCorteCaja);
        final TableInfo _existingCorteCaja = TableInfo.read(_db, "CorteCaja");
        if (! _infoCorteCaja.equals(_existingCorteCaja)) {
          throw new IllegalStateException("Migration didn't properly handle CorteCaja(com.example.administrador.pvsegalmex.entity.CashShortEntity).\n"
                  + " Expected:\n" + _infoCorteCaja + "\n"
                  + " Found:\n" + _existingCorteCaja);
        }
        final HashMap<String, TableInfo.Column> _columnsRetiroCaja = new HashMap<String, TableInfo.Column>(9);
        _columnsRetiroCaja.put("Id", new TableInfo.Column("Id", "INTEGER", false, 1));
        _columnsRetiroCaja.put("Usuario", new TableInfo.Column("Usuario", "INTEGER", false, 0));
        _columnsRetiroCaja.put("Fecha", new TableInfo.Column("Fecha", "TEXT", false, 0));
        _columnsRetiroCaja.put("Comentarios", new TableInfo.Column("Comentarios", "TEXT", false, 0));
        _columnsRetiroCaja.put("Monto", new TableInfo.Column("Monto", "REAL", false, 0));
        _columnsRetiroCaja.put("CorteCaja", new TableInfo.Column("CorteCaja", "INTEGER", false, 0));
        _columnsRetiroCaja.put("Estatus", new TableInfo.Column("Estatus", "INTEGER", true, 0));
        _columnsRetiroCaja.put("UUID", new TableInfo.Column("UUID", "TEXT", false, 0));
        _columnsRetiroCaja.put("UUIDCorteCaja", new TableInfo.Column("UUIDCorteCaja", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysRetiroCaja = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysRetiroCaja.add(new TableInfo.ForeignKey("CorteCaja", "NO ACTION", "NO ACTION",Arrays.asList("CorteCaja"), Arrays.asList("Id")));
        _foreignKeysRetiroCaja.add(new TableInfo.ForeignKey("Usuario", "NO ACTION", "NO ACTION",Arrays.asList("Usuario"), Arrays.asList("Id")));
        final HashSet<TableInfo.Index> _indicesRetiroCaja = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoRetiroCaja = new TableInfo("RetiroCaja", _columnsRetiroCaja, _foreignKeysRetiroCaja, _indicesRetiroCaja);
        final TableInfo _existingRetiroCaja = TableInfo.read(_db, "RetiroCaja");
        if (! _infoRetiroCaja.equals(_existingRetiroCaja)) {
          throw new IllegalStateException("Migration didn't properly handle RetiroCaja(com.example.administrador.pvsegalmex.entity.WithdrawalEntity).\n"
                  + " Expected:\n" + _infoRetiroCaja + "\n"
                  + " Found:\n" + _existingRetiroCaja);
        }
        final HashMap<String, TableInfo.Column> _columnsExistencia = new HashMap<String, TableInfo.Column>(12);
        _columnsExistencia.put("Id", new TableInfo.Column("Id", "INTEGER", false, 1));
        _columnsExistencia.put("Producto", new TableInfo.Column("Producto", "INTEGER", false, 0));
        _columnsExistencia.put("Disponible", new TableInfo.Column("Disponible", "REAL", false, 0));
        _columnsExistencia.put("Transito", new TableInfo.Column("Transito", "REAL", false, 0));
        _columnsExistencia.put("Existencia", new TableInfo.Column("Existencia", "REAL", false, 0));
        _columnsExistencia.put("Comprometida", new TableInfo.Column("Comprometida", "REAL", false, 0));
        _columnsExistencia.put("Sicroniza", new TableInfo.Column("Sicroniza", "INTEGER", false, 0));
        _columnsExistencia.put("FechaActualizacion", new TableInfo.Column("FechaActualizacion", "TEXT", false, 0));
        _columnsExistencia.put("UUID", new TableInfo.Column("UUID", "TEXT", false, 0));
        _columnsExistencia.put("Estatus", new TableInfo.Column("Estatus", "INTEGER", true, 0));
        _columnsExistencia.put("Fecha", new TableInfo.Column("Fecha", "TEXT", false, 0));
        _columnsExistencia.put("UUIDProducto", new TableInfo.Column("UUIDProducto", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysExistencia = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysExistencia.add(new TableInfo.ForeignKey("Productos", "NO ACTION", "NO ACTION",Arrays.asList("Producto"), Arrays.asList("Id")));
        final HashSet<TableInfo.Index> _indicesExistencia = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoExistencia = new TableInfo("Existencia", _columnsExistencia, _foreignKeysExistencia, _indicesExistencia);
        final TableInfo _existingExistencia = TableInfo.read(_db, "Existencia");
        if (! _infoExistencia.equals(_existingExistencia)) {
          throw new IllegalStateException("Migration didn't properly handle Existencia(com.example.administrador.pvsegalmex.entity.ExistEntity).\n"
                  + " Expected:\n" + _infoExistencia + "\n"
                  + " Found:\n" + _existingExistencia);
        }
        final HashMap<String, TableInfo.Column> _columnsKardex = new HashMap<String, TableInfo.Column>(9);
        _columnsKardex.put("Id", new TableInfo.Column("Id", "INTEGER", false, 1));
        _columnsKardex.put("TipoDocumento", new TableInfo.Column("TipoDocumento", "INTEGER", false, 0));
        _columnsKardex.put("NumeroDocumento", new TableInfo.Column("NumeroDocumento", "INTEGER", false, 0));
        _columnsKardex.put("Fecha", new TableInfo.Column("Fecha", "TEXT", false, 0));
        _columnsKardex.put("Usuario", new TableInfo.Column("Usuario", "INTEGER", false, 0));
        _columnsKardex.put("Estatus", new TableInfo.Column("Estatus", "INTEGER", true, 0));
        _columnsKardex.put("UUID", new TableInfo.Column("UUID", "TEXT", false, 0));
        _columnsKardex.put("UUIDTipoDocumento", new TableInfo.Column("UUIDTipoDocumento", "TEXT", false, 0));
        _columnsKardex.put("UUIDUser", new TableInfo.Column("UUIDUser", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysKardex = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysKardex.add(new TableInfo.ForeignKey("TipoDocumentoVta", "NO ACTION", "NO ACTION",Arrays.asList("TipoDocumento"), Arrays.asList("Id")));
        _foreignKeysKardex.add(new TableInfo.ForeignKey("Usuario", "NO ACTION", "NO ACTION",Arrays.asList("Usuario"), Arrays.asList("Id")));
        final HashSet<TableInfo.Index> _indicesKardex = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoKardex = new TableInfo("Kardex", _columnsKardex, _foreignKeysKardex, _indicesKardex);
        final TableInfo _existingKardex = TableInfo.read(_db, "Kardex");
        if (! _infoKardex.equals(_existingKardex)) {
          throw new IllegalStateException("Migration didn't properly handle Kardex(com.example.administrador.pvsegalmex.entity.KardexEntity).\n"
                  + " Expected:\n" + _infoKardex + "\n"
                  + " Found:\n" + _existingKardex);
        }
        final HashMap<String, TableInfo.Column> _columnsReciboMercancia = new HashMap<String, TableInfo.Column>(13);
        _columnsReciboMercancia.put("Id", new TableInfo.Column("Id", "INTEGER", false, 1));
        _columnsReciboMercancia.put("Diconsa", new TableInfo.Column("Diconsa", "INTEGER", true, 0));
        _columnsReciboMercancia.put("Fecha", new TableInfo.Column("Fecha", "TEXT", false, 0));
        _columnsReciboMercancia.put("Consecutivo", new TableInfo.Column("Consecutivo", "INTEGER", true, 0));
        _columnsReciboMercancia.put("Articulos", new TableInfo.Column("Articulos", "INTEGER", true, 0));
        _columnsReciboMercancia.put("Subtotal", new TableInfo.Column("Subtotal", "REAL", false, 0));
        _columnsReciboMercancia.put("Total", new TableInfo.Column("Total", "REAL", false, 0));
        _columnsReciboMercancia.put("Folio", new TableInfo.Column("Folio", "TEXT", false, 0));
        _columnsReciboMercancia.put("Comentario", new TableInfo.Column("Comentario", "TEXT", false, 0));
        _columnsReciboMercancia.put("Proveedor", new TableInfo.Column("Proveedor", "INTEGER", false, 0));
        _columnsReciboMercancia.put("Estatus", new TableInfo.Column("Estatus", "INTEGER", true, 0));
        _columnsReciboMercancia.put("UUID", new TableInfo.Column("UUID", "TEXT", false, 0));
        _columnsReciboMercancia.put("UUIDProveedor", new TableInfo.Column("UUIDProveedor", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysReciboMercancia = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysReciboMercancia.add(new TableInfo.ForeignKey("Proveedores", "NO ACTION", "NO ACTION",Arrays.asList("Proveedor"), Arrays.asList("Id")));
        final HashSet<TableInfo.Index> _indicesReciboMercancia = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoReciboMercancia = new TableInfo("ReciboMercancia", _columnsReciboMercancia, _foreignKeysReciboMercancia, _indicesReciboMercancia);
        final TableInfo _existingReciboMercancia = TableInfo.read(_db, "ReciboMercancia");
        if (! _infoReciboMercancia.equals(_existingReciboMercancia)) {
          throw new IllegalStateException("Migration didn't properly handle ReciboMercancia(com.example.administrador.pvsegalmex.entity.ReceiptOfMerchandiseEntity).\n"
                  + " Expected:\n" + _infoReciboMercancia + "\n"
                  + " Found:\n" + _existingReciboMercancia);
        }
        final HashMap<String, TableInfo.Column> _columnsReciboMercanciaDetalle = new HashMap<String, TableInfo.Column>(15);
        _columnsReciboMercanciaDetalle.put("Id", new TableInfo.Column("Id", "INTEGER", false, 1));
        _columnsReciboMercanciaDetalle.put("ReciboMercancia", new TableInfo.Column("ReciboMercancia", "INTEGER", false, 0));
        _columnsReciboMercanciaDetalle.put("UnidadMedida", new TableInfo.Column("UnidadMedida", "INTEGER", false, 0));
        _columnsReciboMercanciaDetalle.put("Producto", new TableInfo.Column("Producto", "INTEGER", false, 0));
        _columnsReciboMercanciaDetalle.put("Partida", new TableInfo.Column("Partida", "INTEGER", true, 0));
        _columnsReciboMercanciaDetalle.put("Cantidad", new TableInfo.Column("Cantidad", "REAL", false, 0));
        _columnsReciboMercanciaDetalle.put("Precio", new TableInfo.Column("Precio", "REAL", false, 0));
        _columnsReciboMercanciaDetalle.put("Subtotal", new TableInfo.Column("Subtotal", "REAL", false, 0));
        _columnsReciboMercanciaDetalle.put("Total", new TableInfo.Column("Total", "REAL", false, 0));
        _columnsReciboMercanciaDetalle.put("Factor", new TableInfo.Column("Factor", "REAL", false, 0));
        _columnsReciboMercanciaDetalle.put("Estatus", new TableInfo.Column("Estatus", "INTEGER", true, 0));
        _columnsReciboMercanciaDetalle.put("UUID", new TableInfo.Column("UUID", "TEXT", false, 0));
        _columnsReciboMercanciaDetalle.put("Fecha", new TableInfo.Column("Fecha", "TEXT", false, 0));
        _columnsReciboMercanciaDetalle.put("UUIDReciboMercancia", new TableInfo.Column("UUIDReciboMercancia", "TEXT", false, 0));
        _columnsReciboMercanciaDetalle.put("UUIDProduct", new TableInfo.Column("UUIDProduct", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysReciboMercanciaDetalle = new HashSet<TableInfo.ForeignKey>(3);
        _foreignKeysReciboMercanciaDetalle.add(new TableInfo.ForeignKey("ReciboMercancia", "NO ACTION", "NO ACTION",Arrays.asList("ReciboMercancia"), Arrays.asList("Id")));
        _foreignKeysReciboMercanciaDetalle.add(new TableInfo.ForeignKey("Productos", "NO ACTION", "NO ACTION",Arrays.asList("Producto"), Arrays.asList("Id")));
        _foreignKeysReciboMercanciaDetalle.add(new TableInfo.ForeignKey("UnidadMedida", "NO ACTION", "NO ACTION",Arrays.asList("UnidadMedida"), Arrays.asList("Id")));
        final HashSet<TableInfo.Index> _indicesReciboMercanciaDetalle = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoReciboMercanciaDetalle = new TableInfo("ReciboMercanciaDetalle", _columnsReciboMercanciaDetalle, _foreignKeysReciboMercanciaDetalle, _indicesReciboMercanciaDetalle);
        final TableInfo _existingReciboMercanciaDetalle = TableInfo.read(_db, "ReciboMercanciaDetalle");
        if (! _infoReciboMercanciaDetalle.equals(_existingReciboMercanciaDetalle)) {
          throw new IllegalStateException("Migration didn't properly handle ReciboMercanciaDetalle(com.example.administrador.pvsegalmex.entity.ReceiptOfMerchandiseDetailEntity).\n"
                  + " Expected:\n" + _infoReciboMercanciaDetalle + "\n"
                  + " Found:\n" + _existingReciboMercanciaDetalle);
        }
        final HashMap<String, TableInfo.Column> _columnsVentaCobro = new HashMap<String, TableInfo.Column>(11);
        _columnsVentaCobro.put("Id", new TableInfo.Column("Id", "INTEGER", false, 1));
        _columnsVentaCobro.put("Venta", new TableInfo.Column("Venta", "INTEGER", false, 0));
        _columnsVentaCobro.put("FormaPago", new TableInfo.Column("FormaPago", "INTEGER", false, 0));
        _columnsVentaCobro.put("CorteCaja", new TableInfo.Column("CorteCaja", "INTEGER", false, 0));
        _columnsVentaCobro.put("Monto", new TableInfo.Column("Monto", "REAL", false, 0));
        _columnsVentaCobro.put("Estatus", new TableInfo.Column("Estatus", "INTEGER", true, 0));
        _columnsVentaCobro.put("Fecha", new TableInfo.Column("Fecha", "TEXT", false, 0));
        _columnsVentaCobro.put("UUID", new TableInfo.Column("UUID", "TEXT", false, 0));
        _columnsVentaCobro.put("UUIDVenta", new TableInfo.Column("UUIDVenta", "TEXT", false, 0));
        _columnsVentaCobro.put("UUIDFormaPago", new TableInfo.Column("UUIDFormaPago", "TEXT", false, 0));
        _columnsVentaCobro.put("UUIDCorteCaja", new TableInfo.Column("UUIDCorteCaja", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysVentaCobro = new HashSet<TableInfo.ForeignKey>(3);
        _foreignKeysVentaCobro.add(new TableInfo.ForeignKey("Venta", "NO ACTION", "NO ACTION",Arrays.asList("Venta"), Arrays.asList("Id")));
        _foreignKeysVentaCobro.add(new TableInfo.ForeignKey("FormaPago", "NO ACTION", "NO ACTION",Arrays.asList("FormaPago"), Arrays.asList("Id")));
        _foreignKeysVentaCobro.add(new TableInfo.ForeignKey("CorteCaja", "NO ACTION", "NO ACTION",Arrays.asList("CorteCaja"), Arrays.asList("Id")));
        final HashSet<TableInfo.Index> _indicesVentaCobro = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoVentaCobro = new TableInfo("VentaCobro", _columnsVentaCobro, _foreignKeysVentaCobro, _indicesVentaCobro);
        final TableInfo _existingVentaCobro = TableInfo.read(_db, "VentaCobro");
        if (! _infoVentaCobro.equals(_existingVentaCobro)) {
          throw new IllegalStateException("Migration didn't properly handle VentaCobro(com.example.administrador.pvsegalmex.entity.CollectionOfPaymentEntity).\n"
                  + " Expected:\n" + _infoVentaCobro + "\n"
                  + " Found:\n" + _existingVentaCobro);
        }
        final HashMap<String, TableInfo.Column> _columnsCajaRegistradora = new HashMap<String, TableInfo.Column>(6);
        _columnsCajaRegistradora.put("Id", new TableInfo.Column("Id", "INTEGER", false, 1));
        _columnsCajaRegistradora.put("TotalVentas", new TableInfo.Column("TotalVentas", "REAL", false, 0));
        _columnsCajaRegistradora.put("TotalRetiros", new TableInfo.Column("TotalRetiros", "REAL", false, 0));
        _columnsCajaRegistradora.put("TotalIngresos", new TableInfo.Column("TotalIngresos", "REAL", false, 0));
        _columnsCajaRegistradora.put("TotalCaja", new TableInfo.Column("TotalCaja", "REAL", false, 0));
        _columnsCajaRegistradora.put("Estatus", new TableInfo.Column("Estatus", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCajaRegistradora = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCajaRegistradora = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCajaRegistradora = new TableInfo("CajaRegistradora", _columnsCajaRegistradora, _foreignKeysCajaRegistradora, _indicesCajaRegistradora);
        final TableInfo _existingCajaRegistradora = TableInfo.read(_db, "CajaRegistradora");
        if (! _infoCajaRegistradora.equals(_existingCajaRegistradora)) {
          throw new IllegalStateException("Migration didn't properly handle CajaRegistradora(com.example.administrador.pvsegalmex.entity.CashRegisterEntity).\n"
                  + " Expected:\n" + _infoCajaRegistradora + "\n"
                  + " Found:\n" + _existingCajaRegistradora);
        }
        final HashMap<String, TableInfo.Column> _columnsTienda = new HashMap<String, TableInfo.Column>(17);
        _columnsTienda.put("Id", new TableInfo.Column("Id", "INTEGER", false, 1));
        _columnsTienda.put("NumeroTelefono", new TableInfo.Column("NumeroTelefono", "TEXT", false, 0));
        _columnsTienda.put("NombreTienda", new TableInfo.Column("NombreTienda", "TEXT", false, 0));
        _columnsTienda.put("Longitud", new TableInfo.Column("Longitud", "REAL", false, 0));
        _columnsTienda.put("Latitud", new TableInfo.Column("Latitud", "REAL", false, 0));
        _columnsTienda.put("Direccion", new TableInfo.Column("Direccion", "TEXT", false, 0));
        _columnsTienda.put("Propietario", new TableInfo.Column("Propietario", "TEXT", false, 0));
        _columnsTienda.put("Imagen", new TableInfo.Column("Imagen", "TEXT", false, 0));
        _columnsTienda.put("Nombre", new TableInfo.Column("Nombre", "TEXT", false, 0));
        _columnsTienda.put("RFC", new TableInfo.Column("RFC", "TEXT", false, 0));
        _columnsTienda.put("Regimen", new TableInfo.Column("Regimen", "TEXT", false, 0));
        _columnsTienda.put("Password", new TableInfo.Column("Password", "TEXT", false, 0));
        _columnsTienda.put("ArchivoCSD", new TableInfo.Column("ArchivoCSD", "INTEGER", false, 0));
        _columnsTienda.put("ArchivoKey", new TableInfo.Column("ArchivoKey", "INTEGER", false, 0));
        _columnsTienda.put("Facturar", new TableInfo.Column("Facturar", "INTEGER", false, 0));
        _columnsTienda.put("DireccionLocal", new TableInfo.Column("DireccionLocal", "TEXT", false, 0));
        _columnsTienda.put("Estatus", new TableInfo.Column("Estatus", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTienda = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTienda = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTienda = new TableInfo("Tienda", _columnsTienda, _foreignKeysTienda, _indicesTienda);
        final TableInfo _existingTienda = TableInfo.read(_db, "Tienda");
        if (! _infoTienda.equals(_existingTienda)) {
          throw new IllegalStateException("Migration didn't properly handle Tienda(com.example.administrador.pvsegalmex.entity.StoreEntity).\n"
                  + " Expected:\n" + _infoTienda + "\n"
                  + " Found:\n" + _existingTienda);
        }
        final HashMap<String, TableInfo.Column> _columnsIngresos = new HashMap<String, TableInfo.Column>(8);
        _columnsIngresos.put("Id", new TableInfo.Column("Id", "INTEGER", false, 1));
        _columnsIngresos.put("Fecha", new TableInfo.Column("Fecha", "TEXT", false, 0));
        _columnsIngresos.put("Comentarios", new TableInfo.Column("Comentarios", "TEXT", false, 0));
        _columnsIngresos.put("Monto", new TableInfo.Column("Monto", "REAL", false, 0));
        _columnsIngresos.put("Estatus", new TableInfo.Column("Estatus", "INTEGER", true, 0));
        _columnsIngresos.put("UUID", new TableInfo.Column("UUID", "TEXT", false, 0));
        _columnsIngresos.put("CorteCaja", new TableInfo.Column("CorteCaja", "INTEGER", false, 0));
        _columnsIngresos.put("UUIDCorteCaja", new TableInfo.Column("UUIDCorteCaja", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysIngresos = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysIngresos.add(new TableInfo.ForeignKey("CorteCaja", "NO ACTION", "NO ACTION",Arrays.asList("CorteCaja"), Arrays.asList("Id")));
        final HashSet<TableInfo.Index> _indicesIngresos = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoIngresos = new TableInfo("Ingresos", _columnsIngresos, _foreignKeysIngresos, _indicesIngresos);
        final TableInfo _existingIngresos = TableInfo.read(_db, "Ingresos");
        if (! _infoIngresos.equals(_existingIngresos)) {
          throw new IllegalStateException("Migration didn't properly handle Ingresos(com.example.administrador.pvsegalmex.entity.CashIncomeEntity).\n"
                  + " Expected:\n" + _infoIngresos + "\n"
                  + " Found:\n" + _existingIngresos);
        }
        final HashMap<String, TableInfo.Column> _columnsProductos = new HashMap<String, TableInfo.Column>(22);
        _columnsProductos.put("Id", new TableInfo.Column("Id", "INTEGER", false, 1));
        _columnsProductos.put("Codigo", new TableInfo.Column("Codigo", "TEXT", false, 0));
        _columnsProductos.put("CodigoAlterno", new TableInfo.Column("CodigoAlterno", "TEXT", false, 0));
        _columnsProductos.put("Descripcion", new TableInfo.Column("Descripcion", "TEXT", false, 0));
        _columnsProductos.put("Maximo", new TableInfo.Column("Maximo", "REAL", true, 0));
        _columnsProductos.put("Minimo", new TableInfo.Column("Minimo", "REAL", true, 0));
        _columnsProductos.put("PuntoDeReorden", new TableInfo.Column("PuntoDeReorden", "REAL", true, 0));
        _columnsProductos.put("UnidadMedida", new TableInfo.Column("UnidadMedida", "INTEGER", true, 0));
        _columnsProductos.put("UnidadMedidaCompra", new TableInfo.Column("UnidadMedidaCompra", "INTEGER", true, 0));
        _columnsProductos.put("Factor", new TableInfo.Column("Factor", "REAL", true, 0));
        _columnsProductos.put("Servicio", new TableInfo.Column("Servicio", "INTEGER", true, 0));
        _columnsProductos.put("Diconsa", new TableInfo.Column("Diconsa", "INTEGER", true, 0));
        _columnsProductos.put("Categoria", new TableInfo.Column("Categoria", "INTEGER", false, 0));
        _columnsProductos.put("Granel", new TableInfo.Column("Granel", "INTEGER", true, 0));
        _columnsProductos.put("Estatus", new TableInfo.Column("Estatus", "INTEGER", true, 0));
        _columnsProductos.put("RowId", new TableInfo.Column("RowId", "TEXT", false, 0));
        _columnsProductos.put("Costo", new TableInfo.Column("Costo", "REAL", true, 0));
        _columnsProductos.put("CostoUC", new TableInfo.Column("CostoUC", "REAL", true, 0));
        _columnsProductos.put("FechaUC", new TableInfo.Column("FechaUC", "TEXT", false, 0));
        _columnsProductos.put("Imagen", new TableInfo.Column("Imagen", "TEXT", false, 0));
        _columnsProductos.put("UltimaActualizacion", new TableInfo.Column("UltimaActualizacion", "TEXT", false, 0));
        _columnsProductos.put("UUID", new TableInfo.Column("UUID", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysProductos = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysProductos.add(new TableInfo.ForeignKey("Categorias", "NO ACTION", "NO ACTION",Arrays.asList("Categoria"), Arrays.asList("Id")));
        final HashSet<TableInfo.Index> _indicesProductos = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoProductos = new TableInfo("Productos", _columnsProductos, _foreignKeysProductos, _indicesProductos);
        final TableInfo _existingProductos = TableInfo.read(_db, "Productos");
        if (! _infoProductos.equals(_existingProductos)) {
          throw new IllegalStateException("Migration didn't properly handle Productos(com.example.administrador.pvsegalmex.entity.ProductEntity).\n"
                  + " Expected:\n" + _infoProductos + "\n"
                  + " Found:\n" + _existingProductos);
        }
        final HashMap<String, TableInfo.Column> _columnsVenta = new HashMap<String, TableInfo.Column>(18);
        _columnsVenta.put("Id", new TableInfo.Column("Id", "INTEGER", false, 1));
        _columnsVenta.put("Fecha", new TableInfo.Column("Fecha", "TEXT", false, 0));
        _columnsVenta.put("NoArticles", new TableInfo.Column("NoArticles", "INTEGER", true, 0));
        _columnsVenta.put("Total", new TableInfo.Column("Total", "REAL", false, 0));
        _columnsVenta.put("Estatus", new TableInfo.Column("Estatus", "INTEGER", true, 0));
        _columnsVenta.put("FormaPago", new TableInfo.Column("FormaPago", "INTEGER", false, 0));
        _columnsVenta.put("TipoDocumentoVta", new TableInfo.Column("TipoDocumentoVta", "INTEGER", false, 0));
        _columnsVenta.put("Cliente", new TableInfo.Column("Cliente", "INTEGER", false, 0));
        _columnsVenta.put("EstatusVenta", new TableInfo.Column("EstatusVenta", "TEXT", false, 0));
        _columnsVenta.put("CorteCaja", new TableInfo.Column("CorteCaja", "INTEGER", false, 0));
        _columnsVenta.put("DocumentFolio", new TableInfo.Column("DocumentFolio", "INTEGER", true, 0));
        _columnsVenta.put("UUID", new TableInfo.Column("UUID", "TEXT", false, 0));
        _columnsVenta.put("UUIDCorteCaja", new TableInfo.Column("UUIDCorteCaja", "TEXT", false, 0));
        _columnsVenta.put("UUIDTipoDocumento", new TableInfo.Column("UUIDTipoDocumento", "TEXT", false, 0));
        _columnsVenta.put("UUIDCliente", new TableInfo.Column("UUIDCliente", "TEXT", false, 0));
        _columnsVenta.put("UUIDWayPay", new TableInfo.Column("UUIDWayPay", "TEXT", false, 0));
        _columnsVenta.put("Monto_Utilidad", new TableInfo.Column("Monto_Utilidad", "REAL", false, 0));
        _columnsVenta.put("Porcentaje_Utilidad", new TableInfo.Column("Porcentaje_Utilidad", "REAL", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysVenta = new HashSet<TableInfo.ForeignKey>(4);
        _foreignKeysVenta.add(new TableInfo.ForeignKey("Cliente", "NO ACTION", "NO ACTION",Arrays.asList("Cliente"), Arrays.asList("Id")));
        _foreignKeysVenta.add(new TableInfo.ForeignKey("FormaPago", "NO ACTION", "NO ACTION",Arrays.asList("FormaPago"), Arrays.asList("Id")));
        _foreignKeysVenta.add(new TableInfo.ForeignKey("TipoDocumentoVta", "NO ACTION", "NO ACTION",Arrays.asList("TipoDocumentoVta"), Arrays.asList("Id")));
        _foreignKeysVenta.add(new TableInfo.ForeignKey("CorteCaja", "NO ACTION", "NO ACTION",Arrays.asList("CorteCaja"), Arrays.asList("Id")));
        final HashSet<TableInfo.Index> _indicesVenta = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoVenta = new TableInfo("Venta", _columnsVenta, _foreignKeysVenta, _indicesVenta);
        final TableInfo _existingVenta = TableInfo.read(_db, "Venta");
        if (! _infoVenta.equals(_existingVenta)) {
          throw new IllegalStateException("Migration didn't properly handle Venta(com.example.administrador.pvsegalmex.entity.SalesEntity).\n"
                  + " Expected:\n" + _infoVenta + "\n"
                  + " Found:\n" + _existingVenta);
        }
        final HashMap<String, TableInfo.Column> _columnsCorteCajaDetalle = new HashMap<String, TableInfo.Column>(11);
        _columnsCorteCajaDetalle.put("Id", new TableInfo.Column("Id", "INTEGER", false, 1));
        _columnsCorteCajaDetalle.put("CorteCaja", new TableInfo.Column("CorteCaja", "INTEGER", false, 0));
        _columnsCorteCajaDetalle.put("FormaPago", new TableInfo.Column("FormaPago", "INTEGER", false, 0));
        _columnsCorteCajaDetalle.put("MontoCalculado", new TableInfo.Column("MontoCalculado", "REAL", false, 0));
        _columnsCorteCajaDetalle.put("MontoCapturado", new TableInfo.Column("MontoCapturado", "REAL", false, 0));
        _columnsCorteCajaDetalle.put("Diference", new TableInfo.Column("Diference", "REAL", false, 0));
        _columnsCorteCajaDetalle.put("Estatus", new TableInfo.Column("Estatus", "INTEGER", true, 0));
        _columnsCorteCajaDetalle.put("Fecha", new TableInfo.Column("Fecha", "TEXT", false, 0));
        _columnsCorteCajaDetalle.put("UUID", new TableInfo.Column("UUID", "TEXT", false, 0));
        _columnsCorteCajaDetalle.put("UUIDCorteCaja", new TableInfo.Column("UUIDCorteCaja", "TEXT", false, 0));
        _columnsCorteCajaDetalle.put("UUIDFormaPago", new TableInfo.Column("UUIDFormaPago", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCorteCajaDetalle = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysCorteCajaDetalle.add(new TableInfo.ForeignKey("CorteCaja", "NO ACTION", "NO ACTION",Arrays.asList("CorteCaja"), Arrays.asList("Id")));
        _foreignKeysCorteCajaDetalle.add(new TableInfo.ForeignKey("FormaPago", "NO ACTION", "NO ACTION",Arrays.asList("FormaPago"), Arrays.asList("Id")));
        final HashSet<TableInfo.Index> _indicesCorteCajaDetalle = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCorteCajaDetalle = new TableInfo("CorteCajaDetalle", _columnsCorteCajaDetalle, _foreignKeysCorteCajaDetalle, _indicesCorteCajaDetalle);
        final TableInfo _existingCorteCajaDetalle = TableInfo.read(_db, "CorteCajaDetalle");
        if (! _infoCorteCajaDetalle.equals(_existingCorteCajaDetalle)) {
          throw new IllegalStateException("Migration didn't properly handle CorteCajaDetalle(com.example.administrador.pvsegalmex.entity.CashShortDetailEntity).\n"
                  + " Expected:\n" + _infoCorteCajaDetalle + "\n"
                  + " Found:\n" + _existingCorteCajaDetalle);
        }
        final HashMap<String, TableInfo.Column> _columnsTipoDocumentoVta = new HashMap<String, TableInfo.Column>(6);
        _columnsTipoDocumentoVta.put("Id", new TableInfo.Column("Id", "INTEGER", false, 1));
        _columnsTipoDocumentoVta.put("Descripcion", new TableInfo.Column("Descripcion", "TEXT", false, 0));
        _columnsTipoDocumentoVta.put("Consecutivo", new TableInfo.Column("Consecutivo", "INTEGER", true, 0));
        _columnsTipoDocumentoVta.put("Estus", new TableInfo.Column("Estus", "INTEGER", true, 0));
        _columnsTipoDocumentoVta.put("Modulo", new TableInfo.Column("Modulo", "TEXT", false, 0));
        _columnsTipoDocumentoVta.put("UUID", new TableInfo.Column("UUID", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTipoDocumentoVta = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTipoDocumentoVta = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTipoDocumentoVta = new TableInfo("TipoDocumentoVta", _columnsTipoDocumentoVta, _foreignKeysTipoDocumentoVta, _indicesTipoDocumentoVta);
        final TableInfo _existingTipoDocumentoVta = TableInfo.read(_db, "TipoDocumentoVta");
        if (! _infoTipoDocumentoVta.equals(_existingTipoDocumentoVta)) {
          throw new IllegalStateException("Migration didn't properly handle TipoDocumentoVta(com.example.administrador.pvsegalmex.entity.TypeDocumentsEntity).\n"
                  + " Expected:\n" + _infoTipoDocumentoVta + "\n"
                  + " Found:\n" + _existingTipoDocumentoVta);
        }
        final HashMap<String, TableInfo.Column> _columnsProductoPrecio = new HashMap<String, TableInfo.Column>(10);
        _columnsProductoPrecio.put("Id", new TableInfo.Column("Id", "INTEGER", false, 1));
        _columnsProductoPrecio.put("Nivel", new TableInfo.Column("Nivel", "INTEGER", false, 0));
        _columnsProductoPrecio.put("Precio", new TableInfo.Column("Precio", "REAL", true, 0));
        _columnsProductoPrecio.put("PorcentajeUtilidad", new TableInfo.Column("PorcentajeUtilidad", "REAL", true, 0));
        _columnsProductoPrecio.put("Costo", new TableInfo.Column("Costo", "REAL", true, 0));
        _columnsProductoPrecio.put("Cantidad", new TableInfo.Column("Cantidad", "REAL", true, 0));
        _columnsProductoPrecio.put("Producto", new TableInfo.Column("Producto", "INTEGER", true, 0));
        _columnsProductoPrecio.put("UUID", new TableInfo.Column("UUID", "TEXT", false, 0));
        _columnsProductoPrecio.put("UUIDProducto", new TableInfo.Column("UUIDProducto", "TEXT", false, 0));
        _columnsProductoPrecio.put("Monto_Utilidad", new TableInfo.Column("Monto_Utilidad", "REAL", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysProductoPrecio = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysProductoPrecio.add(new TableInfo.ForeignKey("Productos", "NO ACTION", "NO ACTION",Arrays.asList("Producto"), Arrays.asList("Id")));
        final HashSet<TableInfo.Index> _indicesProductoPrecio = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoProductoPrecio = new TableInfo("ProductoPrecio", _columnsProductoPrecio, _foreignKeysProductoPrecio, _indicesProductoPrecio);
        final TableInfo _existingProductoPrecio = TableInfo.read(_db, "ProductoPrecio");
        if (! _infoProductoPrecio.equals(_existingProductoPrecio)) {
          throw new IllegalStateException("Migration didn't properly handle ProductoPrecio(com.example.administrador.pvsegalmex.entity.ProductPriceEntity).\n"
                  + " Expected:\n" + _infoProductoPrecio + "\n"
                  + " Found:\n" + _existingProductoPrecio);
        }
        final HashMap<String, TableInfo.Column> _columnsVentaDetalle = new HashMap<String, TableInfo.Column>(19);
        _columnsVentaDetalle.put("Id", new TableInfo.Column("Id", "INTEGER", false, 1));
        _columnsVentaDetalle.put("Venta", new TableInfo.Column("Venta", "INTEGER", false, 0));
        _columnsVentaDetalle.put("Producto", new TableInfo.Column("Producto", "INTEGER", false, 0));
        _columnsVentaDetalle.put("Cantidad", new TableInfo.Column("Cantidad", "REAL", false, 0));
        _columnsVentaDetalle.put("PrecioUnitario", new TableInfo.Column("PrecioUnitario", "REAL", false, 0));
        _columnsVentaDetalle.put("DescuentoPorcentaje", new TableInfo.Column("DescuentoPorcentaje", "REAL", false, 0));
        _columnsVentaDetalle.put("DescuentoMontoUnitario", new TableInfo.Column("DescuentoMontoUnitario", "REAL", false, 0));
        _columnsVentaDetalle.put("Subtotal", new TableInfo.Column("Subtotal", "REAL", false, 0));
        _columnsVentaDetalle.put("Impuestos", new TableInfo.Column("Impuestos", "REAL", false, 0));
        _columnsVentaDetalle.put("Total", new TableInfo.Column("Total", "REAL", false, 0));
        _columnsVentaDetalle.put("Estatus", new TableInfo.Column("Estatus", "INTEGER", false, 0));
        _columnsVentaDetalle.put("Fecha", new TableInfo.Column("Fecha", "TEXT", false, 0));
        _columnsVentaDetalle.put("UUID", new TableInfo.Column("UUID", "TEXT", false, 0));
        _columnsVentaDetalle.put("UUIDSale", new TableInfo.Column("UUIDSale", "TEXT", false, 0));
        _columnsVentaDetalle.put("UUIDProducto", new TableInfo.Column("UUIDProducto", "TEXT", false, 0));
        _columnsVentaDetalle.put("Porcentaje_Utilidad", new TableInfo.Column("Porcentaje_Utilidad", "REAL", false, 0));
        _columnsVentaDetalle.put("Monto_Utilidad", new TableInfo.Column("Monto_Utilidad", "REAL", false, 0));
        _columnsVentaDetalle.put("Costo_Producto", new TableInfo.Column("Costo_Producto", "REAL", false, 0));
        _columnsVentaDetalle.put("Monto_Unitario_Utilidad", new TableInfo.Column("Monto_Unitario_Utilidad", "REAL", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysVentaDetalle = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysVentaDetalle.add(new TableInfo.ForeignKey("Venta", "NO ACTION", "NO ACTION",Arrays.asList("Venta"), Arrays.asList("Id")));
        _foreignKeysVentaDetalle.add(new TableInfo.ForeignKey("Productos", "NO ACTION", "NO ACTION",Arrays.asList("Producto"), Arrays.asList("Id")));
        final HashSet<TableInfo.Index> _indicesVentaDetalle = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoVentaDetalle = new TableInfo("VentaDetalle", _columnsVentaDetalle, _foreignKeysVentaDetalle, _indicesVentaDetalle);
        final TableInfo _existingVentaDetalle = TableInfo.read(_db, "VentaDetalle");
        if (! _infoVentaDetalle.equals(_existingVentaDetalle)) {
          throw new IllegalStateException("Migration didn't properly handle VentaDetalle(com.example.administrador.pvsegalmex.entity.SalesDetailEntity).\n"
                  + " Expected:\n" + _infoVentaDetalle + "\n"
                  + " Found:\n" + _existingVentaDetalle);
        }
        final HashMap<String, TableInfo.Column> _columnsUnidadMedida = new HashMap<String, TableInfo.Column>(6);
        _columnsUnidadMedida.put("Id", new TableInfo.Column("Id", "INTEGER", false, 1));
        _columnsUnidadMedida.put("Clave", new TableInfo.Column("Clave", "TEXT", false, 0));
        _columnsUnidadMedida.put("Descripcion", new TableInfo.Column("Descripcion", "TEXT", false, 0));
        _columnsUnidadMedida.put("ClaveSAT", new TableInfo.Column("ClaveSAT", "TEXT", false, 0));
        _columnsUnidadMedida.put("UUID", new TableInfo.Column("UUID", "TEXT", false, 0));
        _columnsUnidadMedida.put("UltimaActualizacion", new TableInfo.Column("UltimaActualizacion", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUnidadMedida = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUnidadMedida = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUnidadMedida = new TableInfo("UnidadMedida", _columnsUnidadMedida, _foreignKeysUnidadMedida, _indicesUnidadMedida);
        final TableInfo _existingUnidadMedida = TableInfo.read(_db, "UnidadMedida");
        if (! _infoUnidadMedida.equals(_existingUnidadMedida)) {
          throw new IllegalStateException("Migration didn't properly handle UnidadMedida(com.example.administrador.pvsegalmex.entity.UnitMeasurementEntity).\n"
                  + " Expected:\n" + _infoUnidadMedida + "\n"
                  + " Found:\n" + _existingUnidadMedida);
        }
        final HashMap<String, TableInfo.Column> _columnsRetiroCajaDetalle = new HashMap<String, TableInfo.Column>(6);
        _columnsRetiroCajaDetalle.put("Id", new TableInfo.Column("Id", "INTEGER", false, 1));
        _columnsRetiroCajaDetalle.put("FormaPago", new TableInfo.Column("FormaPago", "INTEGER", false, 0));
        _columnsRetiroCajaDetalle.put("RetiroCaja", new TableInfo.Column("RetiroCaja", "INTEGER", false, 0));
        _columnsRetiroCajaDetalle.put("Monto", new TableInfo.Column("Monto", "REAL", false, 0));
        _columnsRetiroCajaDetalle.put("UltimaActualizacion", new TableInfo.Column("UltimaActualizacion", "TEXT", false, 0));
        _columnsRetiroCajaDetalle.put("UUID", new TableInfo.Column("UUID", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysRetiroCajaDetalle = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysRetiroCajaDetalle.add(new TableInfo.ForeignKey("RetiroCaja", "NO ACTION", "NO ACTION",Arrays.asList("RetiroCaja"), Arrays.asList("Id")));
        _foreignKeysRetiroCajaDetalle.add(new TableInfo.ForeignKey("FormaPago", "NO ACTION", "NO ACTION",Arrays.asList("FormaPago"), Arrays.asList("Id")));
        final HashSet<TableInfo.Index> _indicesRetiroCajaDetalle = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoRetiroCajaDetalle = new TableInfo("RetiroCajaDetalle", _columnsRetiroCajaDetalle, _foreignKeysRetiroCajaDetalle, _indicesRetiroCajaDetalle);
        final TableInfo _existingRetiroCajaDetalle = TableInfo.read(_db, "RetiroCajaDetalle");
        if (! _infoRetiroCajaDetalle.equals(_existingRetiroCajaDetalle)) {
          throw new IllegalStateException("Migration didn't properly handle RetiroCajaDetalle(com.example.administrador.pvsegalmex.entity.WithdrawalDetailEntity).\n"
                  + " Expected:\n" + _infoRetiroCajaDetalle + "\n"
                  + " Found:\n" + _existingRetiroCajaDetalle);
        }
        final HashMap<String, TableInfo.Column> _columnsIngresosDetalle = new HashMap<String, TableInfo.Column>(6);
        _columnsIngresosDetalle.put("Id", new TableInfo.Column("Id", "INTEGER", false, 1));
        _columnsIngresosDetalle.put("FormaPago", new TableInfo.Column("FormaPago", "INTEGER", false, 0));
        _columnsIngresosDetalle.put("Ingresos", new TableInfo.Column("Ingresos", "INTEGER", false, 0));
        _columnsIngresosDetalle.put("Monto", new TableInfo.Column("Monto", "REAL", false, 0));
        _columnsIngresosDetalle.put("UltimaActualizacion", new TableInfo.Column("UltimaActualizacion", "TEXT", false, 0));
        _columnsIngresosDetalle.put("UUID", new TableInfo.Column("UUID", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysIngresosDetalle = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysIngresosDetalle.add(new TableInfo.ForeignKey("Ingresos", "NO ACTION", "NO ACTION",Arrays.asList("Ingresos"), Arrays.asList("Id")));
        _foreignKeysIngresosDetalle.add(new TableInfo.ForeignKey("FormaPago", "NO ACTION", "NO ACTION",Arrays.asList("FormaPago"), Arrays.asList("Id")));
        final HashSet<TableInfo.Index> _indicesIngresosDetalle = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoIngresosDetalle = new TableInfo("IngresosDetalle", _columnsIngresosDetalle, _foreignKeysIngresosDetalle, _indicesIngresosDetalle);
        final TableInfo _existingIngresosDetalle = TableInfo.read(_db, "IngresosDetalle");
        if (! _infoIngresosDetalle.equals(_existingIngresosDetalle)) {
          throw new IllegalStateException("Migration didn't properly handle IngresosDetalle(com.example.administrador.pvsegalmex.entity.CashIncomeDetailEntity).\n"
                  + " Expected:\n" + _infoIngresosDetalle + "\n"
                  + " Found:\n" + _existingIngresosDetalle);
        }
      }
    }, "90cd68fa9ad56a89f8632e55d7174ed1", "a629c88d6ba536b046f44b007ae58346");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "Cliente","FormaPago","Bitacora","Departamentos","Proveedores","Categorias","KardexDetalle","Usuario","CorteCaja","RetiroCaja","Existencia","Kardex","ReciboMercancia","ReciboMercanciaDetalle","VentaCobro","CajaRegistradora","Tienda","Ingresos","Productos","Venta","CorteCajaDetalle","TipoDocumentoVta","ProductoPrecio","VentaDetalle","UnidadMedida","RetiroCajaDetalle","IngresosDetalle");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `Cliente`");
      _db.execSQL("DELETE FROM `FormaPago`");
      _db.execSQL("DELETE FROM `Bitacora`");
      _db.execSQL("DELETE FROM `Departamentos`");
      _db.execSQL("DELETE FROM `Proveedores`");
      _db.execSQL("DELETE FROM `Categorias`");
      _db.execSQL("DELETE FROM `KardexDetalle`");
      _db.execSQL("DELETE FROM `RetiroCaja`");
      _db.execSQL("DELETE FROM `Ingresos`");
      _db.execSQL("DELETE FROM `Venta`");
      _db.execSQL("DELETE FROM `CorteCajaDetalle`");
      _db.execSQL("DELETE FROM `CorteCaja`");
      _db.execSQL("DELETE FROM `Usuario`");
      _db.execSQL("DELETE FROM `Existencia`");
      _db.execSQL("DELETE FROM `Kardex`");
      _db.execSQL("DELETE FROM `ReciboMercanciaDetalle`");
      _db.execSQL("DELETE FROM `ReciboMercancia`");
      _db.execSQL("DELETE FROM `VentaCobro`");
      _db.execSQL("DELETE FROM `CajaRegistradora`");
      _db.execSQL("DELETE FROM `Tienda`");
      _db.execSQL("DELETE FROM `ProductoPrecio`");
      _db.execSQL("DELETE FROM `Productos`");
      _db.execSQL("DELETE FROM `TipoDocumentoVta`");
      _db.execSQL("DELETE FROM `VentaDetalle`");
      _db.execSQL("DELETE FROM `UnidadMedida`");
      _db.execSQL("DELETE FROM `RetiroCajaDetalle`");
      _db.execSQL("DELETE FROM `IngresosDetalle`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public ClienteDao clientDao() {
    if (_clienteDao != null) {
      return _clienteDao;
    } else {
      synchronized(this) {
        if(_clienteDao == null) {
          _clienteDao = new ClienteDao_Impl(this);
        }
        return _clienteDao;
      }
    }
  }

  @Override
  public WayPayDao formaPagoDao() {
    if (_wayPayDao != null) {
      return _wayPayDao;
    } else {
      synchronized(this) {
        if(_wayPayDao == null) {
          _wayPayDao = new WayPayDao_Impl(this);
        }
        return _wayPayDao;
      }
    }
  }

  @Override
  public DepartmentDao departamentoDao() {
    if (_departmentDao != null) {
      return _departmentDao;
    } else {
      synchronized(this) {
        if(_departmentDao == null) {
          _departmentDao = new DepartmentDao_Impl(this);
        }
        return _departmentDao;
      }
    }
  }

  @Override
  public ProviderDao providerDao() {
    if (_providerDao != null) {
      return _providerDao;
    } else {
      synchronized(this) {
        if(_providerDao == null) {
          _providerDao = new ProviderDao_Impl(this);
        }
        return _providerDao;
      }
    }
  }

  @Override
  public CategoryDao categoryDao() {
    if (_categoryDao != null) {
      return _categoryDao;
    } else {
      synchronized(this) {
        if(_categoryDao == null) {
          _categoryDao = new CategoryDao_Impl(this);
        }
        return _categoryDao;
      }
    }
  }

  @Override
  public ProductDao productDao() {
    if (_productDao != null) {
      return _productDao;
    } else {
      synchronized(this) {
        if(_productDao == null) {
          _productDao = new ProductDao_Impl(this);
        }
        return _productDao;
      }
    }
  }

  @Override
  public WithdrawalDao withdrawalDao() {
    if (_withdrawalDao != null) {
      return _withdrawalDao;
    } else {
      synchronized(this) {
        if(_withdrawalDao == null) {
          _withdrawalDao = new WithdrawalDao_Impl(this);
        }
        return _withdrawalDao;
      }
    }
  }

  @Override
  public TypeDocumentsDao typeDocumentsDao() {
    if (_typeDocumentsDao != null) {
      return _typeDocumentsDao;
    } else {
      synchronized(this) {
        if(_typeDocumentsDao == null) {
          _typeDocumentsDao = new TypeDocumentsDao_Impl(this);
        }
        return _typeDocumentsDao;
      }
    }
  }

  @Override
  public ProductPriceDao productPriceDao() {
    if (_productPriceDao != null) {
      return _productPriceDao;
    } else {
      synchronized(this) {
        if(_productPriceDao == null) {
          _productPriceDao = new ProductPriceDao_Impl(this);
        }
        return _productPriceDao;
      }
    }
  }

  @Override
  public CashShortDetailDao cashShortDetailDao() {
    if (_cashShortDetailDao != null) {
      return _cashShortDetailDao;
    } else {
      synchronized(this) {
        if(_cashShortDetailDao == null) {
          _cashShortDetailDao = new CashShortDetailDao_Impl(this);
        }
        return _cashShortDetailDao;
      }
    }
  }

  @Override
  public StoreDao storeDao() {
    if (_storeDao != null) {
      return _storeDao;
    } else {
      synchronized(this) {
        if(_storeDao == null) {
          _storeDao = new StoreDao_Impl(this);
        }
        return _storeDao;
      }
    }
  }

  @Override
  public SalesDao salesDao() {
    if (_salesDao != null) {
      return _salesDao;
    } else {
      synchronized(this) {
        if(_salesDao == null) {
          _salesDao = new SalesDao_Impl(this);
        }
        return _salesDao;
      }
    }
  }

  @Override
  public CashIncomeDao cashIncomeDao() {
    if (_cashIncomeDao != null) {
      return _cashIncomeDao;
    } else {
      synchronized(this) {
        if(_cashIncomeDao == null) {
          _cashIncomeDao = new CashIncomeDao_Impl(this);
        }
        return _cashIncomeDao;
      }
    }
  }

  @Override
  public SalesDetailDao salesDetailDao() {
    if (_salesDetailDao != null) {
      return _salesDetailDao;
    } else {
      synchronized(this) {
        if(_salesDetailDao == null) {
          _salesDetailDao = new SalesDetailDao_Impl(this);
        }
        return _salesDetailDao;
      }
    }
  }

  @Override
  public CashRegisterDao cashRegisterDao() {
    if (_cashRegisterDao != null) {
      return _cashRegisterDao;
    } else {
      synchronized(this) {
        if(_cashRegisterDao == null) {
          _cashRegisterDao = new CashRegisterDao_Impl(this);
        }
        return _cashRegisterDao;
      }
    }
  }

  @Override
  public CollectionOfPaymentDao collectionOfPaymentDao() {
    if (_collectionOfPaymentDao != null) {
      return _collectionOfPaymentDao;
    } else {
      synchronized(this) {
        if(_collectionOfPaymentDao == null) {
          _collectionOfPaymentDao = new CollectionOfPaymentDao_Impl(this);
        }
        return _collectionOfPaymentDao;
      }
    }
  }

  @Override
  public ReceiptOfMerchandiseDao receiptOfMerchandiseDao() {
    if (_receiptOfMerchandiseDao != null) {
      return _receiptOfMerchandiseDao;
    } else {
      synchronized(this) {
        if(_receiptOfMerchandiseDao == null) {
          _receiptOfMerchandiseDao = new ReceiptOfMerchandiseDao_Impl(this);
        }
        return _receiptOfMerchandiseDao;
      }
    }
  }

  @Override
  public ReceiptOfMerchandiseDetailDao receiptOfMerchandiseDetailDao() {
    if (_receiptOfMerchandiseDetailDao != null) {
      return _receiptOfMerchandiseDetailDao;
    } else {
      synchronized(this) {
        if(_receiptOfMerchandiseDetailDao == null) {
          _receiptOfMerchandiseDetailDao = new ReceiptOfMerchandiseDetailDao_Impl(this);
        }
        return _receiptOfMerchandiseDetailDao;
      }
    }
  }

  @Override
  public ExistDao existDao() {
    if (_existDao != null) {
      return _existDao;
    } else {
      synchronized(this) {
        if(_existDao == null) {
          _existDao = new ExistDao_Impl(this);
        }
        return _existDao;
      }
    }
  }

  @Override
  public KardexDao kardexDao() {
    if (_kardexDao != null) {
      return _kardexDao;
    } else {
      synchronized(this) {
        if(_kardexDao == null) {
          _kardexDao = new KardexDao_Impl(this);
        }
        return _kardexDao;
      }
    }
  }

  @Override
  public KardexDetailDao kardexDetailDao() {
    if (_kardexDetailDao != null) {
      return _kardexDetailDao;
    } else {
      synchronized(this) {
        if(_kardexDetailDao == null) {
          _kardexDetailDao = new KardexDetailDao_Impl(this);
        }
        return _kardexDetailDao;
      }
    }
  }

  @Override
  public BitacoraDao bitacoraDao() {
    if (_bitacoraDao != null) {
      return _bitacoraDao;
    } else {
      synchronized(this) {
        if(_bitacoraDao == null) {
          _bitacoraDao = new BitacoraDao_Impl(this);
        }
        return _bitacoraDao;
      }
    }
  }

  @Override
  public UserDao userDao() {
    if (_userDao != null) {
      return _userDao;
    } else {
      synchronized(this) {
        if(_userDao == null) {
          _userDao = new UserDao_Impl(this);
        }
        return _userDao;
      }
    }
  }

  @Override
  public CashShortDao cashShortDao() {
    if (_cashShortDao != null) {
      return _cashShortDao;
    } else {
      synchronized(this) {
        if(_cashShortDao == null) {
          _cashShortDao = new CashShortDao_Impl(this);
        }
        return _cashShortDao;
      }
    }
  }

  @Override
  public UnitMeasurementDao unitMeasurementDao() {
    if (_unitMeasurementDao != null) {
      return _unitMeasurementDao;
    } else {
      synchronized(this) {
        if(_unitMeasurementDao == null) {
          _unitMeasurementDao = new UnitMeasurementDao_Impl(this);
        }
        return _unitMeasurementDao;
      }
    }
  }

  @Override
  public WithdrawalDetailDao withdrawalDetailDao() {
    if (_withdrawalDetailDao != null) {
      return _withdrawalDetailDao;
    } else {
      synchronized(this) {
        if(_withdrawalDetailDao == null) {
          _withdrawalDetailDao = new WithdrawalDetailDao_Impl(this);
        }
        return _withdrawalDetailDao;
      }
    }
  }

  @Override
  public CashIncomeDetailDao cashIncomeDetailDao() {
    if (_cashIncomeDetailDao != null) {
      return _cashIncomeDetailDao;
    } else {
      synchronized(this) {
        if(_cashIncomeDetailDao == null) {
          _cashIncomeDetailDao = new CashIncomeDetailDao_Impl(this);
        }
        return _cashIncomeDetailDao;
      }
    }
  }
}
