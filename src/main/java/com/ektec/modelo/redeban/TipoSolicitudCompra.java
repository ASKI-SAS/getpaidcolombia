
package com.ektec.modelo.redeban;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TipoSolicitudCompra complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TipoSolicitudCompra">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cabeceraSolicitud" type="{http://www.rbm.com.co/esb/comercio/compra/}TipoCabeceraSolicitud"/>
 *         &lt;element name="idPersona" type="{http://www.rbm.com.co/esb/}TipoIdPersona" minOccurs="0"/>
 *         &lt;element name="infoMedioPago" type="{http://www.rbm.com.co/esb/comercio/compra/}TipoInfoMedioPago"/>
 *         &lt;element name="infoCompra" type="{http://www.rbm.com.co/esb/comercio/compra/}TipoInfoCompra"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoSolicitudCompra", namespace = "http://www.rbm.com.co/esb/comercio/compra/", propOrder = {
    "cabeceraSolicitud",
    "idPersona",
    "infoMedioPago",
    "infoCompra"
})
public class TipoSolicitudCompra {

    @XmlElement(required = true)
    protected TipoCabeceraSolicitud cabeceraSolicitud;
    protected TipoIdPersona idPersona;
    @XmlElement(required = true)
    protected TipoInfoMedioPago infoMedioPago;
    @XmlElement(required = true)
    protected TipoInfoCompra infoCompra;

    /**
     * Obtiene el valor de la propiedad cabeceraSolicitud.
     * 
     * @return
     *     possible object is
     *     {@link TipoCabeceraSolicitud }
     *     
     */
    public TipoCabeceraSolicitud getCabeceraSolicitud() {
        return cabeceraSolicitud;
    }

    /**
     * Define el valor de la propiedad cabeceraSolicitud.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoCabeceraSolicitud }
     *     
     */
    public void setCabeceraSolicitud(TipoCabeceraSolicitud value) {
        this.cabeceraSolicitud = value;
    }

    /**
     * Obtiene el valor de la propiedad idPersona.
     * 
     * @return
     *     possible object is
     *     {@link TipoIdPersona }
     *     
     */
    public TipoIdPersona getIdPersona() {
        return idPersona;
    }

    /**
     * Define el valor de la propiedad idPersona.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoIdPersona }
     *     
     */
    public void setIdPersona(TipoIdPersona value) {
        this.idPersona = value;
    }

    /**
     * Obtiene el valor de la propiedad infoMedioPago.
     * 
     * @return
     *     possible object is
     *     {@link TipoInfoMedioPago }
     *     
     */
    public TipoInfoMedioPago getInfoMedioPago() {
        return infoMedioPago;
    }

    /**
     * Define el valor de la propiedad infoMedioPago.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoInfoMedioPago }
     *     
     */
    public void setInfoMedioPago(TipoInfoMedioPago value) {
        this.infoMedioPago = value;
    }

    /**
     * Obtiene el valor de la propiedad infoCompra.
     * 
     * @return
     *     possible object is
     *     {@link TipoInfoCompra }
     *     
     */
    public TipoInfoCompra getInfoCompra() {
        return infoCompra;
    }

    /**
     * Define el valor de la propiedad infoCompra.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoInfoCompra }
     *     
     */
    public void setInfoCompra(TipoInfoCompra value) {
        this.infoCompra = value;
    }

}
