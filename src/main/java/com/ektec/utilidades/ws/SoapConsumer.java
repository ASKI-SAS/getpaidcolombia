package com.ektec.utilidades.ws;

import org.apache.log4j.Logger;
import redeban.modelo.CompraElectronicaHTTPService;
import redeban.modelo.CompraElectronicaMsgSetPortType;
import redeban.modelo.TipoRespuesta;
import redeban.modelo.TipoSolicitudCompra;
import redeban.wsclient.WSSecurityHeaderSOAPHandler;

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
public class SoapConsumer implements IConsumerWS {
    private static Logger LOGGER = Logger.getLogger(SoapConsumer.class.getName());

    @Override
    public Object consume(String url, Object request, Class cls) {
        return null;
    }

    public TipoRespuesta compraProcesar(TipoSolicitudCompra compraProcesarSolicitud) {
        CompraElectronicaHTTPService service = new CompraElectronicaHTTPService();
        CompraElectronicaMsgSetPortType port = service.getCompraElectronicaHTTPPort();

        // This is the block that apply the Ws Security to the request
        BindingProvider bindingProvider = (BindingProvider) port;
        @SuppressWarnings("rawtypes")
        List<Handler> handlerChain = new ArrayList<>();
        handlerChain.add(new WSSecurityHeaderSOAPHandler("testEktec", "testEktec.2017"));
        bindingProvider.getBinding().setHandlerChain(handlerChain);

        return port.compraProcesar(compraProcesarSolicitud);
    }
}
