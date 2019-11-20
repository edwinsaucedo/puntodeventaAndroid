package com.example.administrador.pvsegalmex.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.administrador.pvsegalmex.pojo.ConstantesRestApi.ROOT_URL;

public class ServiceProvider {
    private static ApiService apiService;

    public static ApiService getApiServiceInstance(){
        if(apiService == null){
            apiService = new Retrofit.Builder()
                    .baseUrl(ROOT_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService.class);
        }
        return apiService;
    }
}
