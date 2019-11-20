package com.example.administrador.pvsegalmex.view;

import android.content.Context;

import com.example.administrador.pvsegalmex.percistence.BitacoraDao;
import com.example.administrador.pvsegalmex.percistence.CashIncomeDao;
import com.example.administrador.pvsegalmex.percistence.CashIncomeDetailDao;
import com.example.administrador.pvsegalmex.percistence.CashRegisterDao;
import com.example.administrador.pvsegalmex.percistence.CashShortDao;
import com.example.administrador.pvsegalmex.percistence.CashShortDetailDao;
import com.example.administrador.pvsegalmex.percistence.CategoryDao;
import com.example.administrador.pvsegalmex.percistence.ClienteDao;
import com.example.administrador.pvsegalmex.percistence.CollectionOfPaymentDao;
import com.example.administrador.pvsegalmex.percistence.DataBase;
import com.example.administrador.pvsegalmex.percistence.DepartmentDao;
import com.example.administrador.pvsegalmex.percistence.ExistDao;
import com.example.administrador.pvsegalmex.percistence.KardexDao;
import com.example.administrador.pvsegalmex.percistence.KardexDetailDao;
import com.example.administrador.pvsegalmex.percistence.ProductDao;
import com.example.administrador.pvsegalmex.percistence.ProductPriceDao;
import com.example.administrador.pvsegalmex.percistence.ProviderDao;
import com.example.administrador.pvsegalmex.percistence.ReceiptOfMerchandiseDao;
import com.example.administrador.pvsegalmex.percistence.ReceiptOfMerchandiseDetailDao;
import com.example.administrador.pvsegalmex.percistence.SalesDao;
import com.example.administrador.pvsegalmex.percistence.SalesDetailDao;
import com.example.administrador.pvsegalmex.percistence.StoreDao;
import com.example.administrador.pvsegalmex.percistence.TypeDocumentsDao;
import com.example.administrador.pvsegalmex.percistence.UnitMeasurementDao;
import com.example.administrador.pvsegalmex.percistence.UserDao;
import com.example.administrador.pvsegalmex.percistence.WayPayDao;
import com.example.administrador.pvsegalmex.percistence.WithdrawalDao;
import com.example.administrador.pvsegalmex.percistence.WithdrawalDetailDao;
import com.example.administrador.pvsegalmex.viewEntityFactory.BitacoraViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.CashIncomeDetailViewEntitiyFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.CashIncomeViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.CashRegistrerViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.CashShortDetailViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.CashShortViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.CategoryViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.ClienteViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.CollectionOfPaymentViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.DepartmentViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.ExistViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.KardexDetailViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.KardexViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.ProductPriceViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.ProductViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.ProviderViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.ReceiptOfMerchandiseDetailViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.ReceiptOfMerchandiseViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.SalesDetailViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.SalesViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.StoreViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.TypeDocumentsViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.UnitMeasurementViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.UserViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.WayPayViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.WithdrawalDetailViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.WithdrawalViewEntityFactory;

public class Injection {


    private Injection() {
    }

    private static ClienteDao providerClientDataSource(Context context) {
        DataBase dataBase = DataBase.getDataBase(context);
        return dataBase.clientDao();
    }

    public static ClienteViewEntityFactory providerClientViewModelFactory(Context context) {
        ClienteDao dataSource = providerClientDataSource(context);
        return new ClienteViewEntityFactory(dataSource);
    }

    private static WayPayDao providerWayPayDataSource(Context context) {
        DataBase dataBase = DataBase.getDataBase(context);
        return dataBase.formaPagoDao();
    }

    public static WayPayViewEntityFactory providerWayPayViewModelFactory(Context context) {
        WayPayDao dataSource = providerWayPayDataSource(context);
        return new WayPayViewEntityFactory(dataSource);
    }

    private static DepartmentDao providerDepartamentoDataSource(Context context) {
        DataBase dataBase = DataBase.getDataBase(context);
        return dataBase.departamentoDao();
    }

    public static DepartmentViewEntityFactory providerDepartamentoViewModelFactory(Context context) {
        DepartmentDao dataSource = providerDepartamentoDataSource(context);
        return new DepartmentViewEntityFactory(dataSource);
    }

    private static ProviderDao providerProviderDataSource(Context context) {
        DataBase dataBase = DataBase.getDataBase(context);
        return dataBase.providerDao();
    }

    public static ProviderViewEntityFactory providerProviderViewModelFactory(Context context) {
        ProviderDao dataSource = providerProviderDataSource(context);
        return new ProviderViewEntityFactory(dataSource);
    }

    private static CategoryDao providerCategoryDataSource(Context context) {
        DataBase dataBase = DataBase.getDataBase(context);
        return dataBase.categoryDao();
    }

    public static CategoryViewEntityFactory providerCategoryViewModelFactory(Context context) {
        CategoryDao dataSource = providerCategoryDataSource(context);
        return new CategoryViewEntityFactory(dataSource);
    }

    private static ProductDao providerProductDataSource(Context context) {
        DataBase dataBase = DataBase.getDataBase(context);
        return dataBase.productDao();
    }

    public static ProductViewEntityFactory providerProductViewModelFactory(Context context) {
        ProductDao dataSource = providerProductDataSource(context);
        return new ProductViewEntityFactory(dataSource);
    }

    private static TypeDocumentsDao providerTypeDocumentsDataSource(Context context) {
        DataBase dataBase = DataBase.getDataBase(context);
        return dataBase.typeDocumentsDao();
    }

    public static TypeDocumentsViewEntityFactory providerTypeDocumentsViewModelFactory(Context context) {
        TypeDocumentsDao dataSource = providerTypeDocumentsDataSource(context);
        return new TypeDocumentsViewEntityFactory(dataSource);
    }

    private static ProductPriceDao providerProductPriceDataSource(Context context) {
        DataBase dataBase = DataBase.getDataBase(context);
        return dataBase.productPriceDao();
    }

    public static ProductPriceViewEntityFactory providerProductPriceViewModelFactory(Context context) {
        ProductPriceDao dataSource = providerProductPriceDataSource(context);
        return new ProductPriceViewEntityFactory(dataSource);
    }

    private static CashShortDetailDao providerCashShortDetailDataSource(Context context) {
        DataBase dataBase = DataBase.getDataBase(context);
        return dataBase.cashShortDetailDao();
    }

    public static CashShortDetailViewEntityFactory providerCashShortDetailViewModelFactory(Context context) {
        CashShortDetailDao dataSource = providerCashShortDetailDataSource(context);
        return new CashShortDetailViewEntityFactory(dataSource);
    }

    private static CashShortDao providerCashShortDataSource(Context context) {
        DataBase dataBase = DataBase.getDataBase(context);
        return dataBase.cashShortDao();
    }

    public static CashShortViewEntityFactory providerCashShortViewModelFactory(Context context) {
        CashShortDao dataSource = providerCashShortDataSource(context);
        return new CashShortViewEntityFactory(dataSource);
    }

    private static WithdrawalDao providerWithdrawalDataSource(Context context) {
        DataBase dataBase = DataBase.getDataBase(context);
        return dataBase.withdrawalDao();
    }

    public static WithdrawalViewEntityFactory providerWithdrawalViewModelFactory(Context context) {
        WithdrawalDao dataSource = providerWithdrawalDataSource(context);
        return new WithdrawalViewEntityFactory(dataSource);
    }

    private static StoreDao providerStoreDataSource(Context context) {
        DataBase dataBase = DataBase.getDataBase(context);
        return dataBase.storeDao();
    }

    public static StoreViewEntityFactory providerStoreViewModelFactory(Context context) {
        StoreDao dataSource = providerStoreDataSource(context);
        return new StoreViewEntityFactory(dataSource);
    }

    private static SalesDao providerSaleDataSource(Context context) {
        DataBase dataBase = DataBase.getDataBase(context);
        return dataBase.salesDao();
    }

    public static SalesViewEntityFactory providerSaleViewModelFactory(Context context) {
        SalesDao dataSource = providerSaleDataSource(context);
        return new SalesViewEntityFactory(dataSource);
    }

    private static SalesDetailDao providerSaleDetailDataSource(Context context) {
        DataBase dataBase = DataBase.getDataBase(context);
        return dataBase.salesDetailDao();
    }

    public static SalesDetailViewEntityFactory providerSaleDetailViewModelFactory(Context context) {
        SalesDetailDao dataSource = providerSaleDetailDataSource(context);
        return new SalesDetailViewEntityFactory(dataSource);
    }

    private static CashIncomeDao providerCashIncomeDataSource(Context context) {
        DataBase dataBase = DataBase.getDataBase(context);
        return dataBase.cashIncomeDao();
    }

    public static CashIncomeViewEntityFactory providerCashIncomeViewModelFactory(Context context) {
        CashIncomeDao dataSource = providerCashIncomeDataSource(context);
        return new CashIncomeViewEntityFactory(dataSource);
    }

    private static CashRegisterDao providerCashRegisterDataSource(Context context) {
        DataBase dataBase = DataBase.getDataBase(context);
        return dataBase.cashRegisterDao();
    }

    public static CashRegistrerViewEntityFactory providerCashRegisterViewModelFactory(Context context) {
        CashRegisterDao dataSource = providerCashRegisterDataSource(context);
        return new CashRegistrerViewEntityFactory(dataSource);
    }

    private static CollectionOfPaymentDao providerCollectionOfPaymentDataSource(Context context) {
        DataBase dataBase = DataBase.getDataBase(context);
        return dataBase.collectionOfPaymentDao();
    }

    public static CollectionOfPaymentViewEntityFactory providerCollectionOfPaymentViewModelFactory(Context context) {
        CollectionOfPaymentDao dataSource = providerCollectionOfPaymentDataSource(context);
        return new CollectionOfPaymentViewEntityFactory(dataSource);
    }

    private static ReceiptOfMerchandiseDao providerReceiptMerchandiseDataSource(Context context) {
        DataBase dataBase = DataBase.getDataBase(context);
        return dataBase.receiptOfMerchandiseDao();
    }

    public static ReceiptOfMerchandiseViewEntityFactory providerReceiptMerchandiseViewModelFactory(Context context) {
        ReceiptOfMerchandiseDao dataSource = providerReceiptMerchandiseDataSource(context);
        return new ReceiptOfMerchandiseViewEntityFactory(dataSource);
    }

    private static ReceiptOfMerchandiseDetailDao providerReceiptMerchandiseDetailDataSource(Context context) {
        DataBase dataBase = DataBase.getDataBase(context);
        return dataBase.receiptOfMerchandiseDetailDao();
    }

    public static ReceiptOfMerchandiseDetailViewEntityFactory providerReceiptMerchandiseDetailViewModelFactory(Context context) {
        ReceiptOfMerchandiseDetailDao dataSource = providerReceiptMerchandiseDetailDataSource(context);
        return new ReceiptOfMerchandiseDetailViewEntityFactory(dataSource);
    }

    private static ExistDao providerExistDataSource(Context context) {
        DataBase dataBase = DataBase.getDataBase(context);
        return dataBase.existDao();
    }

    public static ExistViewEntityFactory providerExistViewModelFactory(Context context) {
        ExistDao dataSource = providerExistDataSource(context);
        return new ExistViewEntityFactory(dataSource);
    }

    private static KardexDao providerKardexDataSource(Context context) {
        DataBase dataBase = DataBase.getDataBase(context);
        return dataBase.kardexDao();
    }

    public static KardexViewEntityFactory providerKardexViewModelFactory(Context context) {
        KardexDao dataSource = providerKardexDataSource(context);
        return new KardexViewEntityFactory(dataSource);
    }

    private static KardexDetailDao providerKardexDetailDataSource(Context context) {
        DataBase dataBase = DataBase.getDataBase(context);
        return dataBase.kardexDetailDao();
    }

    public static KardexDetailViewEntityFactory providerKardexDetailModelFactory(Context context) {
        KardexDetailDao dataSource = providerKardexDetailDataSource(context);
        return new KardexDetailViewEntityFactory(dataSource);
    }

    public static BitacoraDao providerBitacoraDataSource(Context context) {
        DataBase dataBase = DataBase.getDataBase(context);
        return dataBase.bitacoraDao();
    }

    public static BitacoraViewEntityFactory providerBitacoraViewModelFactory(Context context) {
        BitacoraDao dataSource = providerBitacoraDataSource(context);
        return new BitacoraViewEntityFactory(dataSource);
    }

    public static UserDao providerUserDataSource(Context context) {
        DataBase dataBase = DataBase.getDataBase(context);
        return dataBase.userDao();
    }

    public static UserViewEntityFactory providerUserViewModelFactory(Context context) {
        UserDao dataSource = providerUserDataSource(context);
        return new UserViewEntityFactory(dataSource);
    }

    public static UnitMeasurementDao providerUnitMeasurementDataSource(Context context) {
        DataBase dataBase = DataBase.getDataBase(context);
        return dataBase.unitMeasurementDao();
    }

    public static UnitMeasurementViewEntityFactory providerUnitMeasurementViewModelFactory(Context context) {
        UnitMeasurementDao dataSource = providerUnitMeasurementDataSource(context);
        return new UnitMeasurementViewEntityFactory(dataSource);
    }

    public static CashIncomeDetailDao providerCashIncomeDetailDatasource(Context context) {
        DataBase dataBase = DataBase.getDataBase(context);
        return dataBase.cashIncomeDetailDao();
    }

    public static CashIncomeDetailViewEntitiyFactory providerCashIncomeDetailViewModelFactory(Context context) {
        CashIncomeDetailDao dataSource = providerCashIncomeDetailDatasource(context);
        return new CashIncomeDetailViewEntitiyFactory(dataSource);
    }

    public static WithdrawalDetailDao providerWithdrawalDetailDatasource(Context context) {
        DataBase dataBase = DataBase.getDataBase(context);
        return dataBase.withdrawalDetailDao();
    }

    public static WithdrawalDetailViewEntityFactory providerWithdrawalDetailViewModelFactory(Context context) {
        WithdrawalDetailDao dataSource = providerWithdrawalDetailDatasource(context);
        return new WithdrawalDetailViewEntityFactory(dataSource);
    }

}
