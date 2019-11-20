package com.example.administrador.pvsegalmex;

import android.app.Service;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.example.administrador.pvsegalmex.api.ApiService;
import com.example.administrador.pvsegalmex.api.CategoryApi;
import com.example.administrador.pvsegalmex.api.ClientApi;
import com.example.administrador.pvsegalmex.api.DepartmentApi;
import com.example.administrador.pvsegalmex.api.JSONCategory;
import com.example.administrador.pvsegalmex.api.JSONClient;
import com.example.administrador.pvsegalmex.api.JSONDepartment;
import com.example.administrador.pvsegalmex.api.JSONProduct;
import com.example.administrador.pvsegalmex.api.JSONUnitMeasurement;
import com.example.administrador.pvsegalmex.api.JSONWayPay;
import com.example.administrador.pvsegalmex.api.LoginInfo;
import com.example.administrador.pvsegalmex.api.ProductApi;
import com.example.administrador.pvsegalmex.api.ServiceProvider;
import com.example.administrador.pvsegalmex.api.UnitMeasurement;
import com.example.administrador.pvsegalmex.api.WayPayApi;
import com.example.administrador.pvsegalmex.entity.CashShortEntity;
import com.example.administrador.pvsegalmex.entity.CategoryEntity;
import com.example.administrador.pvsegalmex.entity.ClienteEntity;
import com.example.administrador.pvsegalmex.entity.DepartmentEntity;
import com.example.administrador.pvsegalmex.entity.ProductEntity;
import com.example.administrador.pvsegalmex.entity.ProviderEntity;
import com.example.administrador.pvsegalmex.entity.ReceiptOfMerchandiseEntity;
import com.example.administrador.pvsegalmex.entity.UnitMeasurementEntity;
import com.example.administrador.pvsegalmex.entity.WayPayEntity;
import com.example.administrador.pvsegalmex.view.Injection;
import com.example.administrador.pvsegalmex.viewEntity.CashShortViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.CategoryViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.ClienteViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.DepartmentViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.ProductViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.ProviderViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.ReceiptOfMerchandiseViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.UnitMeasurementViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.WayPayViewEntity;
import com.example.administrador.pvsegalmex.viewEntityFactory.CashShortViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.CategoryViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.ClienteViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.DepartmentViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.ProductViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.ProviderViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.ReceiptOfMerchandiseViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.UnitMeasurementViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.WayPayViewEntityFactory;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
