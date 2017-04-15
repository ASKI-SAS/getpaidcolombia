package redeban.wsclient;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import redeban.modelo.*;

/**
 * Created by rodolfo.rivas on 7/04/17.
 */
public class ClientWs {

    static public  void main(String[] arg) throws DatatypeConfigurationException {
        TipoSolicitudCompra request = new TipoSolicitudCompra();
        TipoRespuesta respuesta = new TipoRespuesta();
// PARTE DE LA SOLICITUD
        TipoCabeceraSolicitud cabecera = new TipoCabeceraSolicitud();
        TipoIdPersona idPersona = new TipoIdPersona();
        TipoInfoMedioPago infoMedioPago = new TipoInfoMedioPago();
        TipoInfoCompra infoCompra = new TipoInfoCompra();


// SE ARMA LA SOLICITUD        
        /* infoPuntoInteraccion */
        cabecera.setInfoPuntoInteraccion(new TipoInfoPuntoInteraccion());
        cabecera.getInfoPuntoInteraccion().setTipoTerminal(TipoTipoTerminal.WEB);
        cabecera.getInfoPuntoInteraccion().setIdTerminal("ESB10718");
        cabecera.getInfoPuntoInteraccion().setIdAdquiriente("1");
        cabecera.getInfoPuntoInteraccion().setIdTransaccionTerminal(new Long("1900"));
        cabecera.getInfoPuntoInteraccion().setModoCapturaPAN(TipoModoCapturaPAN.MANUAL);
        cabecera.getInfoPuntoInteraccion().setCapacidadPIN(TipoCapacidadPIN.VIRTUAL);
        
        /* idPersona */
        idPersona.setTipoDocumento(TipoTipoDocumento.CC);
        idPersona.setNumDocumento(new Long("72130284"));
        
        /* infoMedioPago */
        infoMedioPago.setIdTarjetaCredito(new TipoIdTarjetaCredito());
        infoMedioPago.getIdTarjetaCredito().setFranquicia(TipoFranquicia.MASTER_CARD);
        infoMedioPago.getIdTarjetaCredito().setNumTarjeta("5303710409428783");
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(new Date());
        XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        infoMedioPago.getIdTarjetaCredito().setFechaExpiracion(date2);
        infoMedioPago.getIdTarjetaCredito().setCodVerificacion("115");
        
        /* infoCompra */
        infoCompra.setMontoTotal(new BigDecimal("250000"));
        infoCompra.setCantidadCuotas(1);
        infoCompra.setReferencia("Mensaje Adicional 123");
            /* infoImpuestos */
        TipoInfoImpuestos tipoImpuesto = new TipoInfoImpuestos();
        tipoImpuesto.setTipoImpuesto(TipoTipoImpuesto.IVA);
        tipoImpuesto.setMonto(new BigDecimal("3400.00"));
        infoCompra.getInfoImpuestos().add(tipoImpuesto);
            /* infoImpuestos */
        TipoMontoDetallado tipoMontoDetallado = new TipoMontoDetallado();
        tipoMontoDetallado.setMonto(new BigDecimal("17851.00"));
        tipoMontoDetallado.setTipoMontoDetallado(TipoTipoMontoDetallado.BASE_DEVOLUCION_IVA);
        infoCompra.getMontoDetallado().add(tipoMontoDetallado);
// SOLICITUD        
        request.setCabeceraSolicitud(cabecera);
        request.setIdPersona(idPersona);
        request.setInfoCompra(infoCompra);
        request.setInfoMedioPago(infoMedioPago);
        try{
            respuesta= compraProcesar(request);
            System.out.println(respuesta.getInfoRespuesta().getEstado());
        }catch(Exception e){
            System.out.println("err" + e.getMessage());
            e.printStackTrace();
        }

    }

    public static TipoRespuesta compraProcesar(TipoSolicitudCompra compraProcesarSolicitud) {
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
