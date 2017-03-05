package com.ektec.negocio;

import com.ektec.dao.IColaDao;
import com.ektec.od.GetPaidRequestOd;
import com.ektec.od.GetPaidResponseOd;
import com.ektec.utilidades.ConsumerClient;
import com.ektec.utilidades.Utilidades;
import com.google.gson.Gson;
import org.apache.log4j.Logger;

import java.util.ResourceBundle;


/*
 * Copyright @2017. ASKI, S.A.S. Todos los derechos reservados.
 *
 * @author SERRANO, Manuel
 * @author RIVAS, Ronel
 * @version 1, 2017-03-04
 * @since 1.0
 */
public class GetPaid {
    private static Logger LOGGER = Logger.getLogger(GetPaid.class.getName());

    private IColaDao colaDao;

    public GetPaid() {
    }

    public void setColaDao(IColaDao colaDao) {
        this.colaDao = colaDao;
    }

    public GetPaidResponseOd getPaid() throws Exception {
        GetPaidResponseOd respuesta = null;
        GetPaidRequestOd getPaidRequestOd;
        try {
            // Desencolar un cobro
            getPaidRequestOd = (GetPaidRequestOd) this.colaDao.desencolar();

            // Envío a cobrar
            respuesta = this.getServiceExterno(getPaidRequestOd);

            // Actualizo y guardo la respuesta
            respuesta.setFolioTransaccion(getPaidRequestOd.getPeticion().getFolioTransaccion());
            respuesta.setFechaHoraSolicitud(getPaidRequestOd.getSeguridad().getFechaHora());
            respuesta = this.setResponse(respuesta);

            if (LOGGER.isDebugEnabled())
                LOGGER.debug("\tServicio procesado satisfactoriamente. ID Servicio: " + getPaidRequestOd.getPeticion().getIdServicio());

        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
        }

        return (respuesta);
    }

    private GetPaidResponseOd getServiceExterno(GetPaidRequestOd GetPaidRequestOd) {
        final String origen = "GetPaid.getServiceExterno";
        long time;
        GetPaidResponseOd getPaidResponseOd = null;

        try {
            ConsumerClient consumer = new ConsumerClient();

            if (Utilidades.getPropiedadConfig("LOG_ENABLED").equalsIgnoreCase("true"))
                LOGGER.info(ResourceBundle.getBundle("log").getString("log.servicios") + GetPaid.class + " | " + origen);

            time = System.currentTimeMillis();
            if (GetPaidRequestOd.getPeticion().getTlv() != null) {
                getPaidResponseOd = (GetPaidResponseOd) consumer.consume(Utilidades.getPropiedadConfig("servicio.url.getPaidChip"), GetPaidRequestOd, GetPaidResponseOd.class);
                if (Utilidades.getPropiedadConfig("LOG_ENABLED").equalsIgnoreCase("true"))
                    LOGGER.info(ResourceBundle.getBundle("log").getString("log.servicios") + GetPaid.class + " | " + origen + " | " + " Servicio por CHIP - " + new Gson().toJson(getPaidResponseOd));
            } else {
                getPaidResponseOd = (GetPaidResponseOd) consumer.consume(Utilidades.getPropiedadConfig("servicio.url.getPaidBanda"), GetPaidRequestOd, GetPaidResponseOd.class);
                if (Utilidades.getPropiedadConfig("LOG_ENABLED").equalsIgnoreCase("true"))
                    LOGGER.info(ResourceBundle.getBundle("log").getString("log.servicios") + GetPaid.class + " | " + origen + " | " + " Servicio por BANDA - " + new Gson().toJson(getPaidResponseOd));
            }

            time = System.currentTimeMillis() - time;
            if (Utilidades.getPropiedadConfig("LOG_ENABLED").equalsIgnoreCase("true"))
                LOGGER.info(ResourceBundle.getBundle("log").getString("log.servicios") + GetPaid.class + " | " + origen + " | " + time);

        } catch (Exception e) {
            LOGGER.error(ResourceBundle.getBundle("log").getString("log.error") + e.getMessage());
        }

        return getPaidResponseOd;

    }

    private GetPaidResponseOd setResponse(GetPaidResponseOd getPaidResponseOd) throws Exception {
        GetPaidResponseOd getPaidResponseOd1 = null;

        try {
            // Encolar la respuesta
            getPaidResponseOd1 = (GetPaidResponseOd) this.colaDao.encolar(getPaidResponseOd);

        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
        }

        return (getPaidResponseOd1);
    }

}