package com.example.administrador.pvsegalmex.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.entity.StoreEntity;
import com.example.administrador.pvsegalmex.viewEntity.StoreViewEntity;
import com.example.administrador.pvsegalmex.viewEntityFactory.StoreViewEntityFactory;
import com.squareup.picasso.Picasso;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class StoreView extends MenuView {

    //region VARS
    private StoreViewEntity storeViewEntity;
    StoreViewEntityFactory storeViewEntityFactory;
    private CompositeDisposable compositeDisposable;
    //endregion

    //region VIEWS
    private TextView tvNameOwner, tvNameStore, tvPhonestore, tvDirectionStore, tvLatitudeStore, tvLongitudeStore;
    private FloatingActionButton editStore;
    private ImageView imageViewStore;
    //endregion

    //region PRIVATE METHODS
    private void inizialiteViews() {
        tvDirectionStore = findViewById(R.id.tvDirectionStore);
        tvNameOwner = findViewById(R.id.tvNameOwnerView);
        tvNameStore = findViewById(R.id.tvNameStoreView);
        tvPhonestore = findViewById(R.id.tvPhoneNumberOwner);
        editStore = findViewById(R.id.btnEditStore);
        imageViewStore = findViewById(R.id.imageStore);
    }

    private void search() {
        compositeDisposable.add(storeViewEntity.getFilterStore()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<StoreEntity>) storeSearch -> {
                            if (storeSearch.getId() != null) {
                                StoreEntity.instance.setId(storeSearch.getId());
                                StoreEntity.instance.setDirection(storeSearch.getDirection());
                                StoreEntity.instance.setLatitud(storeSearch.getLatitud());
                                StoreEntity.instance.setLongitud(storeSearch.getLongitud());
                                StoreEntity.instance.setOwner(storeSearch.getOwner());
                                StoreEntity.instance.setPhonenumber(storeSearch.getPhonenumber());
                                StoreEntity.instance.setStoreName(storeSearch.getStoreName());
                                StoreEntity.instance.setImage(storeSearch.getImage());
                                showInformation();
                            }

                        }, throwable -> {
                            Toast.makeText(getApplicationContext(), "Ocurrio un error al consultar tienda", Toast.LENGTH_LONG).show();
                            Log.e(getString(R.string.errorSQLITE), "");
                        }
                )
        );
    }

    private void showInformation() {
        tvPhonestore.setText(StoreEntity.instance.getPhonenumber());
        tvNameStore.setText(StoreEntity.instance.getStoreName());
        tvNameOwner.setText(StoreEntity.instance.getOwner());
        tvDirectionStore.setText(StoreEntity.instance.getDirection());
        if (StoreEntity.instance.getImage() == null || StoreEntity.instance.getImage().isEmpty()) {
            imageViewStore.setImageURI(null);
        } else {
            Picasso.get().load(StoreEntity.instance.getImage()).into(imageViewStore);
        }
    }
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inizialiteViews();
        compositeDisposable = new CompositeDisposable();
        showInformation();

        editStore.setOnClickListener(v -> {
            if (StoreEntity.instance.getId() == null) {
                StoreEntity.instance.clear();
            }
            startActivity(EditStoreView.class);
        });
    }

    @Override
    protected int getPageLayoutId() {
        return R.layout.activity_store_view;
    }

    @Override
    protected String getScreenTitle() {
        return getString(R.string.itemMenu13);
    }

    @Override
    protected void onResume() {
        super.onResume();
        storeViewEntityFactory = Injection.providerStoreViewModelFactory(getApplicationContext());
        storeViewEntity = ViewModelProviders.of(this, storeViewEntityFactory).get(StoreViewEntity.class);
        search();
    }

    @Override
    public void onBackPressed() {
    }
}