package com.ektec.utilidades.ws;

/*
 * Copyright @2017. ASKI, S.A.S. Todos los derechos reservados.
 *
 * @author RIVAS, Ronel
 * @version 1, 2017-03-04
 * @since 1.0
 */
public interface IConsumerWS {

    // Permite delvolver el resultado de consumir un WebService
    Object consume(String url, Object request, Class cls);

}
