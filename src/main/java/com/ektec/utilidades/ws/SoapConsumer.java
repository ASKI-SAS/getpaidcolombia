package com.ektec.utilidades.ws;

import org.apache.log4j.Logger;

/*
 * Copyright @2017. ASKI, S.A.S. Todos los derechos reservados.
 *
 * @author RIVAS, Ronel
 * @version 1, 2017-03-04
 * @since 1.0
 */
public class SoapConsumer implements IConsumerWS {
    private static Logger LOGGER = Logger.getLogger(SoapConsumer.class.getName());

    @Override
    public Object consume(String url, Object request, Class cls) {
        return null;
    }
}
