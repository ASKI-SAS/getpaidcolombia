package com.ektec.utilidades.ws;

import org.apache.log4j.Logger;
import redeban.modelo.TipoRespuesta;
import redeban.modelo.TipoSolicitudCompra;

/*
 * Copyright @2017. ASKI, S.A.S. Todos los derechos reservados.
 *
 * @author RIVAS, Ronel
 * @version 1, 2017-03-04
 * @since 1.0
 */
public class RestConsumer implements IConsumerWS {
    private static Logger LOGGER = Logger.getLogger(RestConsumer.class.getName());

    @Override
    public Object consume(String url, Object request, Class cls) {
        return null;
    }

    @Override
    public TipoRespuesta compraProcesar(TipoSolicitudCompra compraProcesarSolicitud) {
        return null;
    }
}
