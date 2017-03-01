package com.ektec.od;

import java.io.Serializable;

/**
 * Created by mserrano on 23/04/2016.
 */
public class SeguridadOd implements Serializable {
    private String fechaHora;
    private String usuario;
    private String key;


    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
