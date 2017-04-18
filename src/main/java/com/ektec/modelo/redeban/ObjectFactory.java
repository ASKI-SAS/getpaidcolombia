
package com.ektec.modelo.redeban;


import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the wsclient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */

@XmlRegistry
public class ObjectFactory {

    private final static QName _CompraReversarSolicitud_QNAME = new QName("http://www.rbm.com.co/esb/comercio/compra/", "compraReversarSolicitud");
    private final static QName _CompraProcesarSolicitud_QNAME = new QName("http://www.rbm.com.co/esb/comercio/compra/", "compraProcesarSolicitud");
    private final static QName _CompraProcesarRespuesta_QNAME = new QName("http://www.rbm.com.co/esb/comercio/compra/", "compraProcesarRespuesta");
    private final static QName _CompraReversarRespuesta_QNAME = new QName("http://www.rbm.com.co/esb/comercio/compra/", "compraReversarRespuesta");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: wsclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TipoSolicitudCompra }
     * 
     */
    public TipoSolicitudCompra createTipoSolicitudCompra() {
        return new TipoSolicitudCompra();
    }

    /**
     * Create an instance of {@link TipoRespuesta }
     * 
     */
    public TipoRespuesta createTipoRespuesta() {
        return new TipoRespuesta();
    }

    /**
     * Create an instance of {@link TipoInfoCompraResp }
     * 
     */
    public TipoInfoCompraResp createTipoInfoCompraResp() {
        return new TipoInfoCompraResp();
    }

    /**
     * Create an instance of {@link TipoSolicitudCancelacion }
     * 
     */
    public TipoSolicitudCancelacion createTipoSolicitudCancelacion() {
        return new TipoSolicitudCancelacion();
    }

    /**
     * Create an instance of {@link TipoInfoMedioPago }
     * 
     */
    public TipoInfoMedioPago createTipoInfoMedioPago() {
        return new TipoInfoMedioPago();
    }

    /**
     * Create an instance of {@link TipoCabeceraSolicitud }
     * 
     */
    public TipoCabeceraSolicitud createTipoCabeceraSolicitud() {
        return new TipoCabeceraSolicitud();
    }

    /**
     * Create an instance of {@link TipoInfoMedioPagoIdCuenta }
     * 
     */
    public TipoInfoMedioPagoIdCuenta createTipoInfoMedioPagoIdCuenta() {
        return new TipoInfoMedioPagoIdCuenta();
    }

    /**
     * Create an instance of {@link TipoInfoCompra }
     * 
     */
    public TipoInfoCompra createTipoInfoCompra() {
        return new TipoInfoCompra();
    }

    /**
     * Create an instance of {@link TipoInfoPuntoInteraccion }
     * 
     */
    public TipoInfoPuntoInteraccion createTipoInfoPuntoInteraccion() {
        return new TipoInfoPuntoInteraccion();
    }

    /**
     * Create an instance of {@link TipoInfoTerminal }
     * 
     */
    public TipoInfoTerminal createTipoInfoTerminal() {
        return new TipoInfoTerminal();
    }

    /**
     * Create an instance of {@link TipoInfoPago }
     * 
     */
    public TipoInfoPago createTipoInfoPago() {
        return new TipoInfoPago();
    }

    /**
     * Create an instance of {@link TipoInfoAdicional }
     * 
     */
    public TipoInfoAdicional createTipoInfoAdicional() {
        return new TipoInfoAdicional();
    }

    /**
     * Create an instance of {@link TipoIdCuenta }
     * 
     */
    public TipoIdCuenta createTipoIdCuenta() {
        return new TipoIdCuenta();
    }

    /**
     * Create an instance of {@link TipoInfoAutenticacion }
     * 
     */
    public TipoInfoAutenticacion createTipoInfoAutenticacion() {
        return new TipoInfoAutenticacion();
    }

    /**
     * Create an instance of {@link TipoIdPersona }
     * 
     */
    public TipoIdPersona createTipoIdPersona() {
        return new TipoIdPersona();
    }

    /**
     * Create an instance of {@link TipoIdTrack }
     * 
     */
    public TipoIdTrack createTipoIdTrack() {
        return new TipoIdTrack();
    }

    /**
     * Create an instance of {@link TipoInfoRefCancelacion }
     * 
     */
    public TipoInfoRefCancelacion createTipoInfoRefCancelacion() {
        return new TipoInfoRefCancelacion();
    }

    /**
     * Create an instance of {@link TipoIdTarjetaCredito }
     * 
     */
    public TipoIdTarjetaCredito createTipoIdTarjetaCredito() {
        return new TipoIdTarjetaCredito();
    }

    /**
     * Create an instance of {@link TipoInfoRespuesta }
     * 
     */
    public TipoInfoRespuesta createTipoInfoRespuesta() {
        return new TipoInfoRespuesta();
    }

    /**
     * Create an instance of {@link TipoInfoUbicacion }
     * 
     */
    public TipoInfoUbicacion createTipoInfoUbicacion() {
        return new TipoInfoUbicacion();
    }

    /**
     * Create an instance of {@link TipoIdTarjetaCreditoPrivada }
     * 
     */
    public TipoIdTarjetaCreditoPrivada createTipoIdTarjetaCreditoPrivada() {
        return new TipoIdTarjetaCreditoPrivada();
    }

    /**
     * Create an instance of {@link TipoInfoImpuestos }
     * 
     */
    public TipoInfoImpuestos createTipoInfoImpuestos() {
        return new TipoInfoImpuestos();
    }

    /**
     * Create an instance of {@link TipoMontoDetallado }
     * 
     */
    public TipoMontoDetallado createTipoMontoDetallado() {
        return new TipoMontoDetallado();
    }

    /**
     * Create an instance of {@link TipoIdTarjetaDebitoPrivada }
     * 
     */
    public TipoIdTarjetaDebitoPrivada createTipoIdTarjetaDebitoPrivada() {
        return new TipoIdTarjetaDebitoPrivada();
    }

    /**
     * Create an instance of {@link TipoInfoCHIP }
     * 
     */
    public TipoInfoCHIP createTipoInfoCHIP() {
        return new TipoInfoCHIP();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoSolicitudCompra }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.rbm.com.co/esb/comercio/compra/", name = "compraReversarSolicitud")
    public JAXBElement<TipoSolicitudCompra> createCompraReversarSolicitud(TipoSolicitudCompra value) {
        return new JAXBElement<TipoSolicitudCompra>(_CompraReversarSolicitud_QNAME, TipoSolicitudCompra.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoSolicitudCompra }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.rbm.com.co/esb/comercio/compra/", name = "compraProcesarSolicitud")
    public JAXBElement<TipoSolicitudCompra> createCompraProcesarSolicitud(TipoSolicitudCompra value) {
        return new JAXBElement<TipoSolicitudCompra>(_CompraProcesarSolicitud_QNAME, TipoSolicitudCompra.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoRespuesta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.rbm.com.co/esb/comercio/compra/", name = "compraProcesarRespuesta")
    public JAXBElement<TipoRespuesta> createCompraProcesarRespuesta(TipoRespuesta value) {
        return new JAXBElement<TipoRespuesta>(_CompraProcesarRespuesta_QNAME, TipoRespuesta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoRespuesta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.rbm.com.co/esb/comercio/compra/", name = "compraReversarRespuesta")
    public JAXBElement<TipoRespuesta> createCompraReversarRespuesta(TipoRespuesta value) {
        return new JAXBElement<TipoRespuesta>(_CompraReversarRespuesta_QNAME, TipoRespuesta.class, null, value);
    }

}
