package com.example.administrador.pvsegalmex.percistence;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import com.example.administrador.pvsegalmex.entity.ProductEntity;
import com.example.administrador.pvsegalmex.pojo.ProductPricePojo;
import java.util.ArrayList;
import java.util.List;
import io.reactivex.Flowable;

@Dao
public interface ProductDao {

    @Insert
    Long insertProduct(ProductEntity product);

    @Insert
    List<Long> insertProductDefault(ArrayList<ProductEntity> list);

    @Update
    int updateProduct(ProductEntity product);

    @Query("SELECT * FROM Productos p where  p.Estatus>-1 and p.Descripcion glob '*'||:productDescription||'*' COLLATE NOCASE")
    Flowable<List<ProductEntity>> getFilterProducts(String productDescription);

    @Query("SELECT COUNT(*) FROM Productos p where p.UUID=:productUUID")
    int getCountProduct(String productUUID);

    @Query("SELECT u.Descripcion unitMeasurePurchase, p.UUID uuid, p.Descripcion description, p.Imagen image,p.Id idProduct,p.Estatus status,p.Categoria idCategory, p.Codigo code, p.CodigoAlterno alternateCode, p.Costo cost,p.CostoUC costUC, p.Diconsa diconsa, p.Factor factor, p.FechaUC dateUC,p.Granel granel, p.Maximo maximmn, p.Minimo minimumn,p.PuntoDeReorden reorderPoint,p.Servicio service, p.UnidadMedida measuereUnit, p.UnidadMedidaCompra measuereUnitPurchase, pp.Precio price,pp.Producto product,pp.Nivel level, pp.Cantidad quantity, pp.PorcentajeUtilidad percentage, pp.Monto_Utilidad utility FROM Productos p LEFT JOIN ProductoPrecio pp ON pp.Producto = p.Id INNER JOIN UnidadMedida u ON u.Id = p.UnidadMedida where  p.Estatus>-1 and p.Descripcion  glob '*'||:productDescription||'*' COLLATE NOCASE")
    Flowable<List<ProductPricePojo>> getFilterProductsPrice(String productDescription);

    @Query("SELECT*FROM Productos p where p.Estatus>-1")
    Flowable<List<ProductEntity>> getFilterProductsCatalog();

    @Query("SELECT*FROM Productos p where p.Estatus>-1 and p.Codigo = '*'||:code||'*'")
    Flowable<List<ProductEntity>> getFilterProductsCode(String code);
}

