package com.example.administrador.pvsegalmex.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.adapter.IncompleteSaleAdapter;
import com.example.administrador.pvsegalmex.controller.SwipeControllerActions;
import com.example.administrador.pvsegalmex.controller.SwipeControllerRV;
import com.example.administrador.pvsegalmex.entity.SalesEntity;
import com.example.administrador.pvsegalmex.viewEntity.SalesViewEntity;
import com.example.administrador.pvsegalmex.viewEntityFactory.SalesViewEntityFactory;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class DialogIncompleteSale extends DialogFragment {

    public interface setIdSale {
        void getSaleDetail(Integer id);
    }

    setIdSale interfaz;
    SalesViewEntity salesViewEntity;
    SalesViewEntityFactory salesFactory;
    ArrayList<SalesEntity> salesEntityList;
    IncompleteSaleAdapter rvIncompleteSaleAdapter;
    CompositeDisposable compositeDisposable;
    RecyclerView rvIncompleteSale;
    SwipeControllerRV swipe;
    AppCompatButton btncancel;
    ItemTouchHelper touchHelper;
    Boolean saleDetail = false;

    public void searchSaleIncomplete() {
        compositeDisposable.add(salesViewEntity.getFilterSaleIncomplete()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<SalesEntity>>) saleListSearch -> {
                            salesEntityList = (ArrayList<SalesEntity>) saleListSearch;
                            rvIncompleteSaleAdapter = new IncompleteSaleAdapter(salesEntityList, getActivity());
                            rvIncompleteSaleAdapter.setOnClickListener(onClick);
                            rvIncompleteSale.setAdapter(rvIncompleteSaleAdapter);
                        }, throwable -> {
                            Toast.makeText(getActivity(), "Ocurrio un error al consultar las categorias", Toast.LENGTH_SHORT).show();
                            Log.e("PV SEGALMEX error en:", "");
                        }
                ));
    }

    private void deleteSaleIncomplete(SalesEntity salesEntity) {
        salesEntity.setStatus(-1);
        compositeDisposable.add(salesViewEntity.updateSales(salesEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe());
    }

    private void goToEditSale(SalesEntity sales) {
        SalesEntity.instance.setClient(sales.getClient());
        SalesEntity.instance.setWayPay(sales.getWayPay());
        SalesEntity.instance.setNoAticles(sales.getNoAticles());
        SalesEntity.instance.setSalesStatus(sales.getSalesStatus());
        SalesEntity.instance.setDate(sales.getDate());
        SalesEntity.instance.setTotal(sales.getTotal());
        SalesEntity.instance.setTypeDocumentVta(sales.getTypeDocumentVta());
        SalesEntity.instance.setSumaTotal(sales.getSumaTotal());
        SalesEntity.instance.setId(sales.getId());
        SalesEntity.instance.setStatus(sales.getStatus());

        int idClient = SalesEntity.instance.getClient();
        int idWayPay = SalesEntity.instance.getWayPay();
        int noArticles = SalesEntity.instance.getNoAticles();
        String salesStatus = SalesEntity.instance.getSalesStatus();
        String date = SalesEntity.instance.getDate();
        Double total = SalesEntity.instance.getTotal();
        int typeDocument = SalesEntity.instance.getTypeDocumentVta();
        Double sumTotal = SalesEntity.instance.getSumaTotal();
        int id = SalesEntity.instance.getId();
        int status = SalesEntity.instance.getStatus();
        saleDetail = true;

        Intent intent = new Intent(getActivity(), PointOfSaleView.class);
        intent.putExtra("idClient", idClient);
        intent.putExtra("idWayPay", idWayPay);
        intent.putExtra("noArticles", noArticles);
        intent.putExtra("salesStatus", salesStatus);
        intent.putExtra("date", date);
        intent.putExtra("total", total);
        intent.putExtra("typeDocument", typeDocument);
        intent.putExtra("sumTotal", sumTotal);
        intent.putExtra("id", id);
        intent.putExtra("status", status);
        intent.putExtra("saleDetail", saleDetail);
        startActivity(intent);
    }

    @NonNull
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        compositeDisposable = new CompositeDisposable();
        salesEntityList = new ArrayList<>();
        View rootView = inflater.inflate(R.layout.dialog_incomplete_sales, container);
        rvIncompleteSale = (RecyclerView) rootView.findViewById(R.id.rvIncompleteSale);
        rvIncompleteSale.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        rvIncompleteSaleAdapter = new IncompleteSaleAdapter(salesEntityList, this.getActivity());
        rvIncompleteSale.setAdapter(rvIncompleteSaleAdapter);
        salesFactory = Injection.providerSaleViewModelFactory(this.getActivity());
        salesViewEntity = ViewModelProviders.of(this, salesFactory).get(SalesViewEntity.class);
        searchSaleIncomplete();

        this.getDialog().setTitle("Ventas incompletas");

        swipe = new SwipeControllerRV(new SwipeControllerActions() {
            @Override
            public void onRightClicked(int position) {
                SalesEntity salesClicked = salesEntityList.get(position);
                deleteSaleIncomplete(salesClicked);
            }
        });

        touchHelper = new ItemTouchHelper(swipe);
        touchHelper.attachToRecyclerView(rvIncompleteSale);

        rvIncompleteSale.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                swipe.onDraw(c);
            }
        });
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        salesFactory = Injection.providerSaleViewModelFactory(this.getActivity());
        salesViewEntity = ViewModelProviders.of(this, salesFactory).get(SalesViewEntity.class);
        searchSaleIncomplete();
    }

    private View.OnClickListener onClick = v -> {
        addItem(v);
    };

    public void addItem(View v) {
        SalesEntity salesClicked = salesEntityList.get(rvIncompleteSale.getChildAdapterPosition(v));
        goToEditSale(salesClicked);
    }
}
