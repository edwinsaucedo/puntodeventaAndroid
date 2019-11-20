package com.example.administrador.pvsegalmex.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseUnitMeasurement {
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("unidadesMedida")
    @Expose
    private List<UnitMeasurement> unidadesMedida = null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<UnitMeasurement> getUnidadesMedida() {
        return unidadesMedida;
    }

    public void setUnidadesMedida(List<UnitMeasurement> unidadesMedida) {
        this.unidadesMedida = unidadesMedida;
    }
}
