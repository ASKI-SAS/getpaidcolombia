
package com.ektec.modelo.redeban;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TipoRespuesta complex type.
 * <p>
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;complexType name="TipoRespuesta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cabeceraRespuesta" type="{http://www.rbm.com.co/esb/comercio/compra/}TipoCabeceraSolicitud"/>
 *         &lt;element name="infoRespuesta" type="{http://www.rbm.com.co/esb/}TipoInfoRespuesta"/>
 *         &lt;element name="infoCompraResp" type="{http://www.rbm.com.co/esb/comercio/compra/}TipoInfoCompraResp" minOccurs="0"/>
 *         &lt;element name="idTransaccionAutorizador" type="{http://www.rbm.com.co/esb/}TipoIdTransaccionAutorizador" minOccurs="0"/>
 *         &lt;element name="infoTerminal" type="{http://www.rbm.com.co/esb/comercio/}TipoInfoTerminal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoRespuesta", namespace = "http://www.rbm.com.co/esb/comercio/redeban/", propOrder = {
        "cabeceraRespuesta",
        "infoRespuesta",
        "infoCompraResp",
        "idTransaccionAutorizador",
        "infoTerminal"
})
public class TipoRespuesta {

    @XmlElement(required = true)
    protected TipoCabeceraSolicitud cabeceraRespuesta;
    @XmlElement(required = true)
    protected TipoInfoRespuesta infoRespuesta;
    protected TipoInfoCompraResp infoCompraResp;
    protected Long idTransaccionAutorizador;
    protected TipoInfoTerminal infoTerminal;

    /**
     * Obtiene el valor de la propiedad cabeceraRespuesta.
     *
     * @return possible object is
     * {@link TipoCabeceraSolicitud }
     */
    public TipoCabeceraSolicitud getCabeceraRespuesta() {
        return cabeceraRespuesta;
    }

    /**
     * Define el valor de la propiedad cabeceraRespuesta.
     *
     * @param value allowed object is
     *              {@link TipoCabeceraSolicitud }
     */
    public void setCabeceraRespuesta(TipoCabeceraSolicitud value) {
        this.cabeceraRespuesta = value;
    }

    /**
     * Obtiene el valor de la propiedad infoRespuesta.
     *
     * @return possible object is
     * {@link TipoInfoRespuesta }
     */
    public TipoInfoRespuesta getInfoRespuesta() {
        return infoRespuesta;
    }

    /**
     * Define el valor de la propiedad infoRespuesta.
     *
     * @param value allowed object is
     *              {@link TipoInfoRespuesta }
     */
    public void setInfoRespuesta(TipoInfoRespuesta value) {
        this.infoRespuesta = value;
    }

    /**
     * Obtiene el valor de la propiedad infoCompraResp.
     *
     * @return possible object is
     * {@link TipoInfoCompraResp }
     */
    public TipoInfoCompraResp getInfoCompraResp() {
        return infoCompraResp;
    }

    /**
     * Define el valor de la propiedad infoCompraResp.
     *
     * @param value allowed object is
     *              {@link TipoInfoCompraResp }
     */
    public void setInfoCompraResp(TipoInfoCompraResp value) {
        this.infoCompraResp = value;
    }

    /**
     * Obtiene el valor de la propiedad idTransaccionAutorizador.
     *
     * @return possible object is
     * {@link Long }
     */
    public Long getIdTransaccionAutorizador() {
        return idTransaccionAutorizador;
    }

    /**
     * Define el valor de la propiedad idTransaccionAutorizador.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setIdTransaccionAutorizador(Long value) {
        this.idTransaccionAutorizador = value;
    }

    /**
     * Obtiene el valor de la propiedad infoTerminal.
     *
     * @return possible object is
     * {@link TipoInfoTerminal }
     */
    public TipoInfoTerminal getInfoTerminal() {
        return infoTerminal;
    }

    /**
     * Define el valor de la propiedad infoTerminal.
     *
     * @param value allowed object is
     *              {@link TipoInfoTerminal }
     */
    public void setInfoTerminal(TipoInfoTerminal value) {
        this.infoTerminal = value;
    }

}
