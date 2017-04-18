
package com.ektec.modelo.redeban;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TipoInfoMedioPago complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TipoInfoMedioPago">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="idTrack" type="{http://www.rbm.com.co/esb/}TipoIdTrack"/>
 *           &lt;element name="idTarjetaDebitoPrivada" type="{http://www.rbm.com.co/esb/}TipoIdTarjetaDebitoPrivada"/>
 *           &lt;element name="idTarjetaCreditoPrivada" type="{http://www.rbm.com.co/esb/}TipoIdTarjetaCreditoPrivada"/>
 *           &lt;element name="idTarjetaCredito" type="{http://www.rbm.com.co/esb/}TipoIdTarjetaCredito"/>
 *           &lt;element name="idCuenta" type="{http://www.rbm.com.co/esb/}TipoIdCuenta"/>
 *         &lt;/choice>
 *         &lt;element name="infoCHIP" type="{http://www.rbm.com.co/esb/}TipoInfoCHIP" minOccurs="0"/>
 *         &lt;element name="infoAutenticacion" type="{http://www.rbm.com.co/esb/}TipoInfoAutenticacion" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoInfoMedioPago", namespace = "http://www.rbm.com.co/esb/comercio/compra/", propOrder = {
    "idTrack",
    "idTarjetaDebitoPrivada",
    "idTarjetaCreditoPrivada",
    "idTarjetaCredito",
    "idCuenta",
    "infoCHIP",
    "infoAutenticacion"
})
public class TipoInfoMedioPago {

    protected TipoIdTrack idTrack;
    protected TipoIdTarjetaDebitoPrivada idTarjetaDebitoPrivada;
    protected TipoIdTarjetaCreditoPrivada idTarjetaCreditoPrivada;
    protected TipoIdTarjetaCredito idTarjetaCredito;
    protected TipoIdCuenta idCuenta;
    protected TipoInfoCHIP infoCHIP;
    protected TipoInfoAutenticacion infoAutenticacion;

    /**
     * Obtiene el valor de la propiedad idTrack.
     * 
     * @return
     *     possible object is
     *     {@link TipoIdTrack }
     *     
     */
    public TipoIdTrack getIdTrack() {
        return idTrack;
    }

    /**
     * Define el valor de la propiedad idTrack.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoIdTrack }
     *     
     */
    public void setIdTrack(TipoIdTrack value) {
        this.idTrack = value;
    }

    /**
     * Obtiene el valor de la propiedad idTarjetaDebitoPrivada.
     * 
     * @return
     *     possible object is
     *     {@link TipoIdTarjetaDebitoPrivada }
     *     
     */
    public TipoIdTarjetaDebitoPrivada getIdTarjetaDebitoPrivada() {
        return idTarjetaDebitoPrivada;
    }

    /**
     * Define el valor de la propiedad idTarjetaDebitoPrivada.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoIdTarjetaDebitoPrivada }
     *     
     */
    public void setIdTarjetaDebitoPrivada(TipoIdTarjetaDebitoPrivada value) {
        this.idTarjetaDebitoPrivada = value;
    }

    /**
     * Obtiene el valor de la propiedad idTarjetaCreditoPrivada.
     * 
     * @return
     *     possible object is
     *     {@link TipoIdTarjetaCreditoPrivada }
     *     
     */
    public TipoIdTarjetaCreditoPrivada getIdTarjetaCreditoPrivada() {
        return idTarjetaCreditoPrivada;
    }

    /**
     * Define el valor de la propiedad idTarjetaCreditoPrivada.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoIdTarjetaCreditoPrivada }
     *     
     */
    public void setIdTarjetaCreditoPrivada(TipoIdTarjetaCreditoPrivada value) {
        this.idTarjetaCreditoPrivada = value;
    }

    /**
     * Obtiene el valor de la propiedad idTarjetaCredito.
     * 
     * @return
     *     possible object is
     *     {@link TipoIdTarjetaCredito }
     *     
     */
    public TipoIdTarjetaCredito getIdTarjetaCredito() {
        return idTarjetaCredito;
    }

    /**
     * Define el valor de la propiedad idTarjetaCredito.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoIdTarjetaCredito }
     *     
     */
    public void setIdTarjetaCredito(TipoIdTarjetaCredito value) {
        this.idTarjetaCredito = value;
    }

    /**
     * Obtiene el valor de la propiedad idCuenta.
     * 
     * @return
     *     possible object is
     *     {@link TipoIdCuenta }
     *     
     */
    public TipoIdCuenta getIdCuenta() {
        return idCuenta;
    }

    /**
     * Define el valor de la propiedad idCuenta.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoIdCuenta }
     *     
     */
    public void setIdCuenta(TipoIdCuenta value) {
        this.idCuenta = value;
    }

    /**
     * Obtiene el valor de la propiedad infoCHIP.
     * 
     * @return
     *     possible object is
     *     {@link TipoInfoCHIP }
     *     
     */
    public TipoInfoCHIP getInfoCHIP() {
        return infoCHIP;
    }

    /**
     * Define el valor de la propiedad infoCHIP.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoInfoCHIP }
     *     
     */
    public void setInfoCHIP(TipoInfoCHIP value) {
        this.infoCHIP = value;
    }

    /**
     * Obtiene el valor de la propiedad infoAutenticacion.
     * 
     * @return
     *     possible object is
     *     {@link TipoInfoAutenticacion }
     *     
     */
    public TipoInfoAutenticacion getInfoAutenticacion() {
        return infoAutenticacion;
    }

    /**
     * Define el valor de la propiedad infoAutenticacion.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoInfoAutenticacion }
     *     
     */
    public void setInfoAutenticacion(TipoInfoAutenticacion value) {
        this.infoAutenticacion = value;
    }

}
