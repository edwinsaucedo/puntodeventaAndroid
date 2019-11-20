package com.example.administrador.pvsegalmex.api;

import android.support.annotation.NonNull;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    @POST("Login")
    @FormUrlEncoded
    @NonNull
    Call<JSONLogin> login(@FieldMap @NonNull Map<String, String> login);

    @POST("getUnidadesMedida")
    @FormUrlEncoded
    @NonNull
    Call<JSONUnitMeasurement> getUnidadesMedida(@FieldMap @NonNull Map<String, String> login);

    @POST("getBitacoraActividades")
    @FormUrlEncoded
    @NonNull
    Call<JSONBitacora> getBitacoraActividades(@FieldMap @NonNull Map<String, String> login);

    @POST("getDepartamentos")
    @FormUrlEncoded
    @NonNull
    Call<JSONDepartment> getDepartamentos(@FieldMap @NonNull Map<String, String> login);

    @POST("getCategorias")
    @FormUrlEncoded
    @NonNull
    Call<JSONCategory> getCategorias(@FieldMap @NonNull Map<String, String> login);

    @POST("getProductos")
    @FormUrlEncoded
    @NonNull
    Call<JSONProduct> getProductos(@FieldMap @NonNull Map<String, String> login);

    @POST("getFormasPago")
    @FormUrlEncoded
    @NonNull
    Call<JSONWayPay> getFormasPago(@FieldMap @NonNull Map<String, String> login);

    @POST("getClientes")
    @FormUrlEncoded
    @NonNull
    Call<JSONClient> getClientes(@FieldMap @NonNull Map<String, String> login);

    @POST("syncVenta")
    @FormUrlEncoded
    @NonNull
    Call<SaleApi> postSale(@FieldMap @NonNull Map<String, String> login);

    @POST("syncVentaDetalle")
    @FormUrlEncoded
    @NonNull
    Call<SaleDetailApi> postSaleDetail(@FieldMap @NonNull Map<String, String> login);

    @POST("syncVentaCobro")
    @FormUrlEncoded
    @NonNull
    Call<CollectionPaymentApi> postColectionPayment(@FieldMap @NonNull Map<String, String> login);

    @POST("syncProveedores")
    @FormUrlEncoded
    @NonNull
    Call<ProviderApi> postProvider(@FieldMap @NonNull Map<String, String> login);

    @POST("syncClientes")
    @FormUrlEncoded
    @NonNull
    Call<ClientApi> postClient(@FieldMap @NonNull Map<String, String> login);

    @POST("syncCorteCaja")
    @FormUrlEncoded
    @NonNull
    Call<CashShortApi> postCashShort(@FieldMap @NonNull Map<String, String> login);

    @POST("syncCorteCajaDetalle")
    @FormUrlEncoded
    @NonNull
    Call<CashShortDetailApi> postCashShortDetail(@FieldMap @NonNull Map<String, String> login);

    @POST("syncExistencia")
    @FormUrlEncoded
    @NonNull
    Call<ExistApi> postExist(@FieldMap @NonNull Map<String, String> login);

    @POST("syncIngreso")
    @FormUrlEncoded
    @NonNull
    Call<IncomeApi> postIncome(@FieldMap @NonNull Map<String, String> login);

    @POST("syncKardex")
    @FormUrlEncoded
    @NonNull
    Call<KardexApi> postKardex(@FieldMap @NonNull Map<String, String> login);

    @POST("syncKardexDetalle")
    @FormUrlEncoded
    @NonNull
    Call<KardexDetailApi> postKardexDetail(@FieldMap @NonNull Map<String, String> login);

    @POST("syncRecepcionMercancia")
    @FormUrlEncoded
    @NonNull
    Call<ReceiptMerchandiseApi> postReceiptMerchandise(@FieldMap @NonNull Map<String, String> login);

    @POST("syncRecepcionMercanciaDetalle")
    @FormUrlEncoded
    @NonNull
    Call<ReceiptMerchandiseDetailApi> postReceiptMerchandiseDetail(@FieldMap @NonNull Map<String, String> login);

    @POST("syncRetiroCaja")
    @FormUrlEncoded
    @NonNull
    Call<WithdrawalApi> postWithdrawal(@FieldMap @NonNull Map<String, String> login);
}
