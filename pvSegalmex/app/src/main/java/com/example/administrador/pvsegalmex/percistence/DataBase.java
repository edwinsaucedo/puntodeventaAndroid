package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.ContentProvider;
import android.content.Context;

import com.example.administrador.pvsegalmex.entity.BitacoraEntity;
import com.example.administrador.pvsegalmex.entity.CashIncomeDetailEntity;
import com.example.administrador.pvsegalmex.entity.CashIncomeEntity;
import com.example.administrador.pvsegalmex.entity.CashRegisterEntity;
import com.example.administrador.pvsegalmex.entity.CashShortDetailEntity;
import com.example.administrador.pvsegalmex.entity.CashShortEntity;
import com.example.administrador.pvsegalmex.entity.CategoryEntity;
import com.example.administrador.pvsegalmex.entity.ClienteEntity;
import com.example.administrador.pvsegalmex.entity.CollectionOfPaymentEntity;
import com.example.administrador.pvsegalmex.entity.DepartmentEntity;
import com.example.administrador.pvsegalmex.entity.ExistEntity;
import com.example.administrador.pvsegalmex.entity.KardexDetailEntity;
import com.example.administrador.pvsegalmex.entity.KardexEntity;
import com.example.administrador.pvsegalmex.entity.ProductEntity;
import com.example.administrador.pvsegalmex.entity.ProductPriceEntity;
import com.example.administrador.pvsegalmex.entity.ProviderEntity;
import com.example.administrador.pvsegalmex.entity.ReceiptOfMerchandiseDetailEntity;
import com.example.administrador.pvsegalmex.entity.ReceiptOfMerchandiseEntity;
import com.example.administrador.pvsegalmex.entity.SalesDetailEntity;
import com.example.administrador.pvsegalmex.entity.SalesEntity;
import com.example.administrador.pvsegalmex.entity.StoreEntity;
import com.example.administrador.pvsegalmex.entity.TypeDocumentsEntity;
import com.example.administrador.pvsegalmex.entity.UnitMeasurementEntity;
import com.example.administrador.pvsegalmex.entity.UserEntity;
import com.example.administrador.pvsegalmex.entity.WayPayEntity;
import com.example.administrador.pvsegalmex.entity.WithdrawalDetailEntity;
import com.example.administrador.pvsegalmex.entity.WithdrawalEntity;

@Database(entities = {ClienteEntity.class, WayPayEntity.class, BitacoraEntity.class, DepartmentEntity.class, ProviderEntity.class,
        CategoryEntity.class, KardexDetailEntity.class, UserEntity.class, CashShortEntity.class, WithdrawalEntity.class, ExistEntity.class,
        KardexEntity.class, ReceiptOfMerchandiseEntity.class, ReceiptOfMerchandiseDetailEntity.class, CollectionOfPaymentEntity.class, CashRegisterEntity.class,
        StoreEntity.class, CashIncomeEntity.class, ProductEntity.class, SalesEntity.class, CashShortDetailEntity.class, TypeDocumentsEntity.class, ProductPriceEntity.class,
        SalesDetailEntity.class, UnitMeasurementEntity.class, WithdrawalDetailEntity.class, CashIncomeDetailEntity.class}, version = 10, exportSchema = false)

public abstract class DataBase extends RoomDatabase {

    public abstract ClienteDao clientDao();

    public abstract WayPayDao formaPagoDao();

    public abstract DepartmentDao departamentoDao();

    public abstract ProviderDao providerDao();

    public abstract CategoryDao categoryDao();

    public abstract ProductDao productDao();

    public abstract WithdrawalDao withdrawalDao();

    public abstract TypeDocumentsDao typeDocumentsDao();

    public abstract ProductPriceDao productPriceDao();

    public abstract CashShortDetailDao cashShortDetailDao();

    public abstract StoreDao storeDao();

    public abstract SalesDao salesDao();

    public abstract CashIncomeDao cashIncomeDao();

    public abstract SalesDetailDao salesDetailDao();

    public abstract CashRegisterDao cashRegisterDao();

    public abstract CollectionOfPaymentDao collectionOfPaymentDao();

    public abstract ReceiptOfMerchandiseDao receiptOfMerchandiseDao();

    public abstract ReceiptOfMerchandiseDetailDao receiptOfMerchandiseDetailDao();

    public abstract ExistDao existDao();

    public abstract KardexDao kardexDao();

    public abstract KardexDetailDao kardexDetailDao();

    public abstract BitacoraDao bitacoraDao();

    public abstract UserDao userDao();

    public abstract CashShortDao cashShortDao();

    public abstract UnitMeasurementDao unitMeasurementDao();

    public abstract WithdrawalDetailDao withdrawalDetailDao();

    public abstract CashIncomeDetailDao cashIncomeDetailDao();

    private static DataBase dataBase = null;

    public static DataBase getDataBase(Context context) {
        if (dataBase == null) {
            synchronized (DataBase.class) {
                dataBase = Room.databaseBuilder(context.getApplicationContext(), DataBase.class, "pvSegalmex.db").build();
            }
        }
        return dataBase;
    }

    public static void destroyDataBase() {
        dataBase = null;
    }
}
