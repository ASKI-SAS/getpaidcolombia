package com.ektec.od;

import com.sun.org.apache.xml.internal.utils.StringVector;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by mserrano on 23/04/2016.
 */
public class GetPaidResponseOd implements Serializable {
    private String folioTransaccion;
    private String idRespuesta;
    private String descripcion;
    private String auditNumber;
    private String authorizationId;
    private String responseCode;
    private String fechaHora;
    private String fechaHoraSolicitud;


    public String getFechaHoraSolicitud() {
        return fechaHoraSolicitud;
    }

    public void setFechaHoraSolicitud(String fechaHoraSolicitud) {
        this.fechaHoraSolicitud = fechaHoraSolicitud;
    }

    public String getFolioTransaccion() {
        return folioTransaccion;
    }

    public void setFolioTransaccion(String folioTransaccion) {
        this.folioTransaccion = folioTransaccion;
    }

    private String estado;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(String idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAuditNumber() {
        return auditNumber;
    }

    public void setAuditNumber(String auditNumber) {
        this.auditNumber = auditNumber;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getAuthorizationId() {
        return authorizationId;
    }

    public void setAuthorizationId(String authorizationId) {
        this.authorizationId = authorizationId;
    }
}
