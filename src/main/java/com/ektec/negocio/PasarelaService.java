package com.ektec.negocio;

import com.ektec.dao.IColaDao;
import com.ektec.od.GetPaidRequestOd;
import com.ektec.od.GetPaidResponseOd;
import com.ektec.utilidades.ConsumerClientRest;
import com.ektec.utilidades.Utilidades;
import com.ektec.utilidades.ws.SoapConsumer;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import redeban.modelo.TipoRespuesta;
import redeban.modelo.TipoSolicitudCompra;

import java.util.ResourceBundle;

/*
 * Copyright @2017. ASKI, S.A.S. Todos los derechos reservados.
 *
 * @author SERRANO, Manuel
 * @author RIVAS, Ronel
 * @version 1, 2017-03-04
 * @since 1.0
 */
@Service("pasarelaService")
public class PasarelaService {
    private static Logger LOGGER = Logger.getLogger(PasarelaService.class.getName());

    private IColaDao colaCobroDao;

    private IColaDao colaReversoDao;

    public PasarelaService() {
    }

    // Procesar Cobro
    public void getPaid() throws Exception {
        TipoRespuesta respuesta = null;
        TipoSolicitudCompra getPaidRequestOd;
        try {
            // Desencolar un cobro
            Object obj = this.colaCobroDao.desencolar();
            if (obj != null) {
                getPaidRequestOd = (TipoSolicitudCompra) obj;

                // Envío a cobrar
                respuesta = this.consumirCobro(getPaidRequestOd);

                // Actualizo y guardo la respuesta
                //respuesta.setFolioTransaccion(getPaidRequestOd.getPeticion().getFolioTransaccion());
                //respuesta.setFechaHoraSolicitud(getPaidRequestOd.getSeguridad().getFechaHora());
                this.colaCobroDao.encolar(respuesta);

                if (LOGGER.isDebugEnabled())
                    LOGGER.debug("\tServicio de cobro procesado satisfactoriamente. ID Servicio: " + getPaidRequestOd.getInfoCompra().getReferencia());
            }

        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
        }

    }

    // Consumir WS de Cobro
    private TipoRespuesta consumirCobro(TipoSolicitudCompra GetPaidRequestOd) {
        long time;
        TipoRespuesta getPaidResponseOd = null;

        try {
            SoapConsumer consumer=new SoapConsumer();

            if (LOGGER.isDebugEnabled())
                LOGGER.debug("**** Consumo WS Cobro: INICIADO...");

            time = System.currentTimeMillis();
            getPaidResponseOd = consumer.compraProcesar(GetPaidRequestOd);

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("**** Consumo WS Cobro:" + getPaidResponseOd.getInfoRespuesta().getEstado());
                time = System.currentTimeMillis() - time;
                LOGGER.debug("**** Consumo WS Cobro: FINALIZADO. (" + time + " milisegundos)");
            }

        } catch (Exception e) {
            LOGGER.error(ResourceBundle.getBundle("log").getString("log.error") + e.getMessage());
        }

        return getPaidResponseOd;
    }

    // Procesar Reverso
    public GetPaidResponseOd getReverso() throws Exception {
        GetPaidResponseOd respuesta = null;
        GetPaidRequestOd getPaidRequestOd;
        try {
            // Desencolar un cobro
            Object obj = this.colaReversoDao.desencolar();
            if (obj != null) {
                getPaidRequestOd = (GetPaidRequestOd) obj;

                // Envío a cobrar
                respuesta = this.consumirReverso(getPaidRequestOd);

                // Actualizo y guardo la respuesta
                respuesta.setFolioTransaccion(getPaidRequestOd.getPeticion().getFolioTransaccion());
                respuesta.setFechaHoraSolicitud(getPaidRequestOd.getSeguridad().getFechaHora());
                respuesta = (GetPaidResponseOd) this.colaReversoDao.encolar(respuesta);

                if (LOGGER.isDebugEnabled())
                    LOGGER.debug("\tServicio reversado satisfactoriamente. ID Servicio: " + getPaidRequestOd.getPeticion().getIdServicio());
            }

        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
        }

        return respuesta;
    }

    // Consumir WS de Reverso
    private GetPaidResponseOd consumirReverso(GetPaidRequestOd GetPaidRequestOd) {
        long time;
        GetPaidResponseOd getPaidResponseOd = null;

        try {
            ConsumerClientRest consumer = new ConsumerClientRest();

            if (LOGGER.isDebugEnabled())
                LOGGER.debug("**** Consumo WS Reverso: INICIADO...");

            time = System.currentTimeMillis();
            if (GetPaidRequestOd.getPeticion().getTlv() != null) {
                if (LOGGER.isDebugEnabled())
                    LOGGER.debug("\tReverso por CHIP - " + new Gson().toJson(getPaidResponseOd));

                getPaidResponseOd = (GetPaidResponseOd) consumer.consume(Utilidades.getPropiedadConfig("servicio.url.getReverseChip"), GetPaidRequestOd, GetPaidResponseOd.class);

            } else {
                if (LOGGER.isDebugEnabled())
                    LOGGER.debug("\tReverso por BANDA - " + new Gson().toJson(getPaidResponseOd));

                getPaidResponseOd = (GetPaidResponseOd) consumer.consume(Utilidades.getPropiedadConfig("servicio.url.getReverseBanda"), GetPaidRequestOd, GetPaidResponseOd.class);
            }

            if (LOGGER.isDebugEnabled()) {
                time = System.currentTimeMillis() - time;
                LOGGER.debug("**** Consumo WS Reverso: FINALIZADO. (" + time + " milisegundos)");
            }

        } catch (Exception e) {
            LOGGER.error(ResourceBundle.getBundle("log").getString("log.error") + e.getMessage());
        }

        return getPaidResponseOd;
    }


    // Setter
    public IColaDao getColaCobroDao() {
        return colaCobroDao;
    }

    public void setColaCobroDao(IColaDao colaCobroDao) {
        this.colaCobroDao = colaCobroDao;
    }

    public IColaDao getColaReversoDao() {
        return colaReversoDao;
    }

    public void setColaReversoDao(IColaDao colaReversoDao) {
        this.colaReversoDao = colaReversoDao;
    }
}