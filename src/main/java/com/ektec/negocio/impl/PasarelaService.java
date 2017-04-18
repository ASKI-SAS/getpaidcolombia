package com.ektec.negocio.impl;

import com.ektec.dao.IColaDao;
import com.ektec.exception.NegocioException;
import com.ektec.modelo.redeban.TipoRespuesta;
import com.ektec.modelo.redeban.TipoSolicitudCompra;
import com.ektec.negocio.IPasarelaService;
import com.ektec.ws.IConsumerWS;
import com.ektec.ws.impl.CompraWS;
import com.ektec.ws.impl.ReversoWS;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/*
 * Copyright @2017. ASKI, S.A.S. Todos los derechos reservados.
 *
 * @author SERRANO, Manuel
 * @author RIVAS, Ronel
 * @version 1, 2017-03-04
 * @since 1.0
 */
@Service("pasarelaService")
public class PasarelaService implements IPasarelaService {

    private static Logger LOGGER = Logger.getLogger(PasarelaService.class.getName());

    private IColaDao colaCobroDao;

    private IColaDao colaReversoDao;

    public PasarelaService() {
    }

    public void setColaCobroDao(IColaDao colaCobroDao) {
        this.colaCobroDao = colaCobroDao;
    }

    public void setColaReversoDao(IColaDao colaReversoDao) {
        this.colaReversoDao = colaReversoDao;
    }


    // PROCESAR COBRO
    @Override
    public void getPaid() {
        TipoRespuesta respuesta;
        TipoSolicitudCompra getPaidRequestOd;
        try {
            // Desencolar un cobro
            Object obj = this.colaCobroDao.desencolar();
            if (obj != null) {

                // Envío a cobrar
                getPaidRequestOd = (TipoSolicitudCompra) obj;
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
    private TipoRespuesta consumirCobro(TipoSolicitudCompra getPaidRequestOd) throws NegocioException {
        long time;
        TipoRespuesta getPaidResponseOd;

        try {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("");
                LOGGER.debug("**** Consumo WS Cobro: INICIADO...");
            }

            // Invocar al WS
            time = System.currentTimeMillis();
            IConsumerWS consumer = new CompraWS();
            getPaidResponseOd = (TipoRespuesta) consumer.consume(null, getPaidRequestOd, null);
            LOGGER.debug("\t**** Consumo WS Cobro:" + getPaidResponseOd.getInfoRespuesta().getEstado());

            if (LOGGER.isDebugEnabled()) {
                time = System.currentTimeMillis() - time;
                LOGGER.debug("**** Consumo WS Cobro: FINALIZADO. (" + time + " milisegundos)");
                LOGGER.debug("");
            }

        } catch (Exception e) {
            throw new NegocioException(e.getMessage());
        }

        return getPaidResponseOd;
    }


    // PROCESAR REVERSO
    @Override
    public void getReverse() {
        TipoRespuesta respuesta;
        TipoSolicitudCompra getPaidRequestOd;
        try {
            // Desencolar un reverso
            Object obj = this.colaReversoDao.desencolar();
            if (obj != null) {
                // Envío a reversar
                getPaidRequestOd = (TipoSolicitudCompra) obj;
                respuesta = this.consumirReverso(getPaidRequestOd);

                // Actualizo y guardo la respuesta
                //respuesta.setFolioTransaccion(getPaidRequestOd.getPeticion().getFolioTransaccion());
                //respuesta.setFechaHoraSolicitud(getPaidRequestOd.getSeguridad().getFechaHora());
                this.colaReversoDao.encolar(respuesta);

                if (LOGGER.isDebugEnabled())
                    LOGGER.debug("\tServicio de reverso procesado satisfactoriamente. ID Servicio: " + getPaidRequestOd.getInfoCompra().getReferencia());
            }

        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
        }
    }

    // Consumir WS de Reverso
    private TipoRespuesta consumirReverso(TipoSolicitudCompra getPaidRequestOd) throws NegocioException {
        long time;
        TipoRespuesta getPaidResponseOd;

        try {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("");
                LOGGER.debug("**** Consumo WS Reverso: INICIADO...");
            }

            // Invocar al WS
            time = System.currentTimeMillis();
            IConsumerWS consumer = new ReversoWS();
            getPaidResponseOd = (TipoRespuesta) consumer.consume(null, getPaidRequestOd, null);
            LOGGER.debug("\t**** Consumo WS Reverso:" + getPaidResponseOd.getInfoRespuesta().getEstado());

            if (LOGGER.isDebugEnabled()) {
                time = System.currentTimeMillis() - time;
                LOGGER.debug("**** Consumo WS Reverso: FINALIZADO. (" + time + " milisegundos)");
                LOGGER.debug("");
            }

        } catch (Exception e) {
            throw new NegocioException(e.getMessage());
        }

        return getPaidResponseOd;
    }
}