package com.ektec.od;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by mserrano on 23/04/2016.
 */
public class PeticionOd implements Serializable {
    private String idServicio;
    private String folioTransaccion;
    private String fechaHora;
    private String importeTransaccion;
    private String merchantType;
    private String tlv;
    private String terminalId;
    private TerminalLocationOd terminalLocation;
    private AdditionalDataOd additionalData;
    private String track;
    private String ksn;

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public String getKsn() {
        return ksn;
    }

    public void setKsn(String ksn) {
        this.ksn = ksn;
    }

    public AdditionalDataOd getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(AdditionalDataOd additionalData) {
        this.additionalData = additionalData;
    }

    public String getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }

    public String getFolioTransaccion() {
        return folioTransaccion;
    }

    public void setFolioTransaccion(String folioTransaccion) {
        this.folioTransaccion = folioTransaccion;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getImporteTransaccion() {
        Locale locale = new Locale("en", "US");
        String pattern = "#.00";

        DecimalFormat decimalFormat = (DecimalFormat)
                NumberFormat.getNumberInstance(locale);
        decimalFormat.applyPattern(pattern);
        return decimalFormat.format(importeTransaccion);
    }

    public void setImporteTransaccion(Double importeTransaccion) {
        Locale locale = new Locale("en", "US");
        String pattern = "#.00";

        DecimalFormat decimalFormat = (DecimalFormat)
                NumberFormat.getNumberInstance(locale);
        decimalFormat.applyPattern(pattern);
        this.importeTransaccion = decimalFormat.format(importeTransaccion);
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public TerminalLocationOd getTerminalLocation() {
        return terminalLocation;
    }

    public void setTerminalLocation(TerminalLocationOd terminalLocation) {
        this.terminalLocation = terminalLocation;
    }

    public String getMerchantType() {
        return merchantType;
    }

    public void setMerchantType(String merchantType) {
        this.merchantType = merchantType;
    }

    public String getTlv() {
        return tlv;
    }

    public void setTlv(String tlv) {
        this.tlv = tlv;
    }


}
