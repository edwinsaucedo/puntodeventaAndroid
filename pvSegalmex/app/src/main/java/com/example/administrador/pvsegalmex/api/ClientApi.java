package com.example.administrador.pvsegalmex.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientApi {
    @SerializedName("NOMBRE")
    @Expose
    private String nOMBRE;
    @SerializedName("APELLIDO_PATERNO")
    @Expose
    private String aPELLIDOPATERNO;
    @SerializedName("APELLIDO_MATERNO")
    @Expose
    private String aPELLIDOMATERNO;
    @SerializedName("EDAD")
    @Expose
    private Integer eDAD;
    @SerializedName("LIMITE_CREDITO")
    @Expose
    private Integer lIMITECREDITO;
    @SerializedName("DIAS_CREDITO")
    @Expose
    private Integer dIASCREDITO;
    @SerializedName("CREDITO_DISPONIBLE")
    @Expose
    private Integer cREDITODISPONIBLE;
    @SerializedName("GENERO")
    @Expose
    private String gENERO;
    @SerializedName("DIRECCION")
    @Expose
    private String dIRECCION;
    @SerializedName("CURP")
    @Expose
    private String cURP;
    @SerializedName("FOTO_CLIENTE")
    @Expose
    private String fOTOCLIENTE;
    @SerializedName("FOTO_INE")
    @Expose
    private String fOTOINE;
    @SerializedName("EMAIL")
    @Expose
    private String eMAIL;
    @SerializedName("TELEFONO")
    @Expose
    private String tELEFONO;
    @SerializedName("COMPANIA")
    @Expose
    private Integer cOMPANIA;

    public String getNOMBRE() {
        return nOMBRE;
    }

    public void setNOMBRE(String nOMBRE) {
        this.nOMBRE = nOMBRE;
    }

    public String getAPELLIDOPATERNO() {
        return aPELLIDOPATERNO;
    }

    public void setAPELLIDOPATERNO(String aPELLIDOPATERNO) {
        this.aPELLIDOPATERNO = aPELLIDOPATERNO;
    }

    public String getAPELLIDOMATERNO() {
        return aPELLIDOMATERNO;
    }

    public void setAPELLIDOMATERNO(String aPELLIDOMATERNO) {
        this.aPELLIDOMATERNO = aPELLIDOMATERNO;
    }

    public Integer getEDAD() {
        return eDAD;
    }

    public void setEDAD(Integer eDAD) {
        this.eDAD = eDAD;
    }

    public Integer getLIMITECREDITO() {
        return lIMITECREDITO;
    }

    public void setLIMITECREDITO(Integer lIMITECREDITO) {
        this.lIMITECREDITO = lIMITECREDITO;
    }

    public Integer getDIASCREDITO() {
        return dIASCREDITO;
    }

    public void setDIASCREDITO(Integer dIASCREDITO) {
        this.dIASCREDITO = dIASCREDITO;
    }

    public Integer getCREDITODISPONIBLE() {
        return cREDITODISPONIBLE;
    }

    public void setCREDITODISPONIBLE(Integer cREDITODISPONIBLE) {
        this.cREDITODISPONIBLE = cREDITODISPONIBLE;
    }

    public String getGENERO() {
        return gENERO;
    }

    public void setGENERO(String gENERO) {
        this.gENERO = gENERO;
    }

    public String getDIRECCION() {
        return dIRECCION;
    }

    public void setDIRECCION(String dIRECCION) {
        this.dIRECCION = dIRECCION;
    }

    public String getCURP() {
        return cURP;
    }

    public void setCURP(String cURP) {
        this.cURP = cURP;
    }

    public String getFOTOCLIENTE() {
        return fOTOCLIENTE;
    }

    public void setFOTOCLIENTE(String fOTOCLIENTE) {
        this.fOTOCLIENTE = fOTOCLIENTE;
    }

    public String getFOTOINE() {
        return fOTOINE;
    }

    public void setFOTOINE(String fOTOINE) {
        this.fOTOINE = fOTOINE;
    }

    public String getEMAIL() {
        return eMAIL;
    }

    public void setEMAIL(String eMAIL) {
        this.eMAIL = eMAIL;
    }

    public String getTELEFONO() {
        return tELEFONO;
    }

    public void setTELEFONO(String tELEFONO) {
        this.tELEFONO = tELEFONO;
    }

    public Integer getCOMPANIA() {
        return cOMPANIA;
    }

    public void setCOMPANIA(Integer cOMPANIA) {
        this.cOMPANIA = cOMPANIA;
    }
}
