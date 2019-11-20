package com.example.administrador.pvsegalmex.view;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.entity.ProductEntity;
import com.example.administrador.pvsegalmex.entity.ProductPriceEntity;
import com.example.administrador.pvsegalmex.viewEntity.ProductPriceViewEntity;
import com.example.administrador.pvsegalmex.viewEntityFactory.ProductPriceViewEntityFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class FramgmentProductPrice extends Fragment {

    //region VARS
    View view;
    private CompositeDisposable compositeDisposable;
    private ProductPriceViewEntityFactory productPriceFactory;
    private final int percentage = 100;
    private ProductPriceViewEntity productPriceViewEntity;
    private int idPriceProduct = -1;
    private int idPriceProductMayoreo = -1;
    double porcentageCal = 0.0;
    double porcentageCalMayoreo = 0.0;
    double cost;
    private ArrayList<ProductPriceEntity> productPriceList;

    double priceFinal = 0.0;
    double priceFinalMayoreo = 0.0;
    //endregion

    //region VIEWS
    private EditText edtPrice, edtPercentage, edtCost;
    private EditText edtPriceMayoreo, edtPercentageMayoreo, edtCostMayoreo, edtQuantityMayoreo;
    private TextView tvId;
    private AppCompatButton btnSave;
    private Button btnShowMayoreo;

    //endregion

    //region PRIVATE METHODS
    private void initializeViews(View view) {
        edtPrice = view.findViewById(R.id.edtProductPricePrice);
        edtCost = view.findViewById(R.id.edtProductPriceCost);
        edtPercentage = view.findViewById(R.id.edtProductPricePercentage);
        btnSave = view.findViewById(R.id.btnSaveProductPrice);
        tvId = view.findViewById(R.id.testId);
        btnShowMayoreo = view.findViewById(R.id.btnShowdataMayoreo);
        edtCostMayoreo = view.findViewById(R.id.edtProductPriceCostMayoreo);
        edtQuantityMayoreo = view.findViewById(R.id.edtProductPriceQuantityMayoreo);
        edtPriceMayoreo = view.findViewById(R.id.edtProductPricePriceMayoreo);
        edtPercentageMayoreo = view.findViewById(R.id.edtProductPricePercentageMayoreo);
    }

    private void updateUid() {
        if (ProductEntity.instance.getCostUC() == 0.0) {
            edtCost.setText(String.valueOf(ProductEntity.instance.getCost()));
            edtCostMayoreo.setText(String.valueOf(ProductEntity.instance.getCost()));
        } else {
            edtCost.setText(String.valueOf(ProductEntity.instance.getCostUC()));
            edtCostMayoreo.setText(String.valueOf(ProductEntity.instance.getCostUC()));
        }
    }

    public FramgmentProductPrice() {
    }

    public static FramgmentProductPrice ewInstance(String param1, String param2) {
        FramgmentProductPrice fragment = new FramgmentProductPrice();
        return fragment;
    }

    private void saveProductPrice() {
        ProductPriceEntity productPrice = new ProductPriceEntity();
        Double cost = Double.parseDouble(edtCost.getText().toString());
        Double price = Double.parseDouble(edtPrice.getText().toString());
        Double utility = price - cost;
        if (edtPrice.getText().toString().isEmpty() || edtPrice.getText() == null) {
            edtPrice.setError(getString(R.string.fieldRequired));
            return;
        }
        if (edtPercentage.getText().toString().isEmpty() || edtPercentage.getText() == null) {
            productPrice.setPercentage(0.0);
        }
        if (edtCost.getText().toString().isEmpty() || edtCost.getText() == null) {
            productPrice.setCost(0.0);
        }
        productPrice.setUtilityAmount(utility);
        productPrice.setProduct(ProductEntity.instance.getId());
        productPrice.setPrice(Double.parseDouble(edtPrice.getText().toString().trim()));
        productPrice.setCost(Double.parseDouble(edtCost.getText().toString().trim()));
        productPrice.setQuantity(0.0);
        productPrice.setPercentage(Double.parseDouble(edtPercentage.getText().toString().trim()));
        productPrice.setLevel(0);

        if (idPriceProduct == -1) {
            insertProductPrice(productPrice);
            Toast.makeText(getActivity(), "Precio base guardado correctamente", Toast.LENGTH_SHORT).show();
        } else {
            productPrice.setId(idPriceProduct);
            updateProductPrice(productPrice);
            Toast.makeText(getActivity(), "Precio base Actualizado correctamente", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveProductPriceWholeSale() {
        ProductPriceEntity productPrice2 = new ProductPriceEntity();
        Double cost = Double.parseDouble(edtCostMayoreo.getText().toString());
        Double price = Double.parseDouble(edtPriceMayoreo.getText().toString());
        Double utility = price - cost;
        if (edtPriceMayoreo.getText().toString().isEmpty() || edtPriceMayoreo.getText() == null) {
            edtPriceMayoreo.setError(getString(R.string.fieldRequired));
            return;
        }
        if (edtPercentageMayoreo.getText().toString().isEmpty() || edtPercentageMayoreo.getText() == null) {
            productPrice2.setPercentage(0.0);
        }
        if (edtCostMayoreo.getText().toString().isEmpty() || edtCostMayoreo.getText() == null) {
            productPrice2.setCost(0.0);
        }
        if (edtQuantityMayoreo.getText().toString().isEmpty() || edtQuantityMayoreo.getText() == null) {
            edtQuantityMayoreo.setError("Campo requerido");

        } else {
            productPrice2.setQuantity(Double.parseDouble(edtQuantityMayoreo.getText().toString()));
        }
        productPrice2.setProduct(ProductEntity.instance.getId());
        productPrice2.setUtilityAmount(utility);
        productPrice2.setPrice(Double.parseDouble(edtPriceMayoreo.getText().toString().trim()));
        productPrice2.setCost(Double.parseDouble(edtCostMayoreo.getText().toString().trim()));
        productPrice2.setPercentage(Double.parseDouble(edtPercentageMayoreo.getText().toString().trim()));

        productPrice2.setLevel(1);

        if (idPriceProductMayoreo == -1) {

            if (productPriceList.isEmpty()) {
                Toast.makeText(getActivity(), "Primero debes ingresar precio base", Toast.LENGTH_SHORT).show();
            } else {
                insertProductPrice(productPrice2);
                Toast.makeText(getActivity(), "Precio Mayoreo guardado correctamente", Toast.LENGTH_SHORT).show();
            }
        } else {
            productPrice2.setId(idPriceProductMayoreo);
            updateProductPrice(productPrice2);
            Toast.makeText(getActivity(), "Precio Mayoreo Actualizado correctamente", Toast.LENGTH_SHORT).show();
        }

    }

    private void insertProductPrice(ProductPriceEntity productPrice) {
        compositeDisposable.add(productPriceViewEntity.insertProductPrice(productPrice)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                })
        );
    }

    private void updateProductPrice(ProductPriceEntity productPrice) {
        compositeDisposable.add(productPriceViewEntity.updateProductPrice(productPrice)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(//getActivity()::finish
                )
        );
    }

    private void searchProductPrice() {
        if (productPriceViewEntity == null) {
            productPriceViewEntity = ViewModelProviders.of(this, productPriceFactory).get(ProductPriceViewEntity.class);
        }
        Integer idProdcuto = ProductEntity.instance.getId();

        compositeDisposable.add(productPriceViewEntity.getFilterProductPrice(idProdcuto)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<ProductPriceEntity>>) productPriceListSearch -> {
                            productPriceList = (ArrayList<ProductPriceEntity>) productPriceListSearch;
                            if (!productPriceList.isEmpty()) {
                                showData();
                                if (productPriceList.size() > 1) {
                                    showDataMayoreo();
                                }
                            } else {
                                if (ProductEntity.instance.getCostUC() == 0.0) {
                                    edtCost.setText(String.valueOf(ProductEntity.instance.getCost()));
                                } else {
                                    edtCost.setText(String.valueOf(ProductEntity.instance.getCostUC()));
                                }
                            }

                        }, throwable -> {
                            Toast.makeText(getActivity(), "Ocurrio un error al consultar", Toast.LENGTH_LONG).show();
                            Log.e("PV SEGALMEX error en:", "");
                        }
                ));
    }

    //endregion

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_productprice, container, false);
        initializeViews(view);

        compositeDisposable = new CompositeDisposable();
        productPriceFactory = Injection.providerProductPriceViewModelFactory(getActivity());
        productPriceViewEntity = ViewModelProviders.of(this, productPriceFactory).get(ProductPriceViewEntity.class);
        updateUid();

        btnSave.setOnClickListener(v -> saveProductPrice());
        btnShowMayoreo.setOnClickListener(v -> saveProductPriceWholeSale());
        return view;
    }

    private void showData() {
        idPriceProduct = productPriceList.get(0).getId();

        edtPercentage.setText(String.valueOf(productPriceList.get(0).getPercentage()));
        edtPrice.setText(String.valueOf(productPriceList.get(0).getPrice()));
        if (ProductEntity.instance.getCostUC() == 0.0) {
            edtCost.setText(String.valueOf(ProductEntity.instance.getCost()));
        } else {
            edtCost.setText(String.valueOf(ProductEntity.instance.getCostUC()));
        }
    }

    private void showDataMayoreo() {
        idPriceProductMayoreo = productPriceList.get(1).getId();
        edtQuantityMayoreo.setText(String.valueOf(productPriceList.get(1).getQuantity()));
        edtPercentageMayoreo.setText(String.valueOf(productPriceList.get(1).getPercentage()));
        edtPriceMayoreo.setText(String.valueOf(productPriceList.get(1).getPrice()));
        if (ProductEntity.instance.getCostUC() == 0.0) {
            edtCostMayoreo.setText(String.valueOf(ProductEntity.instance.getCost()));
        } else {
            edtCostMayoreo.setText(String.valueOf(ProductEntity.instance.getCostUC()));
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        productPriceFactory = Injection.providerProductPriceViewModelFactory(getActivity());
        productPriceViewEntity = ViewModelProviders.of(this, productPriceFactory).get(ProductPriceViewEntity.class);
        searchProductPrice();

        edtPriceMayoreo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (ProductEntity.instance.getCostUC() == 0.0) {
                    cost = ProductEntity.instance.getCost();
                } else {
                    cost = ProductEntity.instance.getCostUC();
                }

                if (edtPriceMayoreo.length() == 0) {
                    edtPriceMayoreo.setHint("0");
                    edtPercentageMayoreo.setHint("0");
                    edtPercentageMayoreo.setText(String.valueOf(0.0));

                } else {
                    porcentageCalMayoreo = Double.parseDouble(edtPriceMayoreo.getText().toString()) - cost;
                    priceFinalMayoreo = porcentageCalMayoreo * percentage / (cost);
                    edtPercentageMayoreo.setText(String.valueOf(String.format(Locale.ENGLISH, "%.2f", priceFinalMayoreo)));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        edtPrice.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (ProductEntity.instance.getCostUC() == 0.0) {
                    cost = ProductEntity.instance.getCost();
                } else {
                    cost = ProductEntity.instance.getCostUC();
                }

                if (edtPrice.length() == 0) {
                    edtPrice.setHint("0");
                    edtPercentage.setHint("0");
                    edtPercentage.setText(String.valueOf(0.0));

                } else {
                    porcentageCal = Double.parseDouble(edtPrice.getText().toString()) - cost;
                    priceFinal = porcentageCal * percentage / (cost);
                    edtPercentage.setText(String.valueOf(String.format(Locale.ENGLISH, "%.2f", priceFinal)));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
