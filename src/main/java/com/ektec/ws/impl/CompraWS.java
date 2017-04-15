package com.ektec.ws.impl;

import com.ektec.exception.NegocioException;
import com.ektec.modelo.redeban.CompraElectronicaHTTPService;
import com.ektec.modelo.redeban.CompraElectronicaMsgSetPortType;
import com.ektec.modelo.redeban.TipoSolicitudCompra;
import com.ektec.utilidades.Utilidades;
import com.ektec.ws.IConsumerWS;
import org.apache.log4j.Logger;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;
import java.util.ArrayList;
import java.util.List;

/*
 * Copyright @2017. ASKI, S.A.S. Todos los derechos reservados.
 *
 * @author RIVAS, Ronel
 * @version 1, 2017-03-04
 * @since 1.0
 */
public class CompraWS implements IConsumerWS {
    private static Logger LOGGER = Logger.getLogger(CompraWS.class.getName());

    @Override
    public Object consume(String url, Object request, Class cls) throws NegocioException {
        if (!(request instanceof TipoSolicitudCompra))
            throw new NegocioException("Parámetro inválido");

        TipoSolicitudCompra compraProcesarSolicitud = (TipoSolicitudCompra) request;

        // Instanciar el Servicio
        CompraElectronicaHTTPService service = new CompraElectronicaHTTPService();
        CompraElectronicaMsgSetPortType port = service.getCompraElectronicaHTTPPort();

        // Credenciales
        String user = Utilidades.getPropiedadConfig("servicio.seguridad.usuario");
        String passwd = Utilidades.getPropiedadConfig("servicio.seguridad.clave");

        // This is the block that apply the Ws Security to the request
        BindingProvider bindingProvider = (BindingProvider) port;
        List<Handler> handlerChain = new ArrayList<>();
        handlerChain.add(new WSSecurityHeaderSOAPHandler(user, passwd));
        bindingProvider.getBinding().setHandlerChain(handlerChain);

        // Consumir el servicio de COMPRA
        return port.compraProcesar(compraProcesarSolicitud);
    }
}
