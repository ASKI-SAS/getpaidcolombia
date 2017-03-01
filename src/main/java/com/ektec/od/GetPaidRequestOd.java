package com.ektec.od;

import java.io.Serializable;

/**
 * Created by mserrano on 23/04/2016.
 */
public class GetPaidRequestOd implements Serializable {
    private SeguridadOd seguridad;
    private PeticionOd peticion;


    public PeticionOd getPeticion() {
        return peticion;
    }

    public void setPeticion(PeticionOd peticion) {
        this.peticion = peticion;
    }

    public SeguridadOd getSeguridad() {
        return seguridad;
    }

    public void setSeguridad(SeguridadOd seguridad) {
        this.seguridad = seguridad;
    }


}
