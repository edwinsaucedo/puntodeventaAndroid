package com.example.administrador.pvsegalmex.pojo;

import static com.example.administrador.pvsegalmex.pojo.ConstantesRestApi.SINVALOR_INT;

public class BitacoraLocal {
    int ID;
    int Id_Ciclo;
    int operacion;

    public BitacoraLocal(){
        this.ID = SINVALOR_INT;
        this.Id_Ciclo = SINVALOR_INT;
        this.operacion = SINVALOR_INT;
    }

    public BitacoraLocal(int ID, int id_Ciclo, int operacion) {
        this.ID = ID;
        Id_Ciclo = id_Ciclo;
        this.operacion = operacion;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getId_Ciclo() {
        return Id_Ciclo;
    }

    public void setId_Ciclo(int id_Ciclo) {
        Id_Ciclo = id_Ciclo;
    }

    public int getOperacion() {
        return operacion;
    }

    public void setOperacion(int operacion) {
        this.operacion = operacion;
    }
}
