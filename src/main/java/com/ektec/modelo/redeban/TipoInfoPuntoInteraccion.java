
package com.ektec.modelo.redeban;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TipoInfoPuntoInteraccion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TipoInfoPuntoInteraccion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tipoTerminal" type="{http://www.rbm.com.co/esb/comercio/}TipoTipoTerminal"/>
 *         &lt;element name="idTerminal" type="{http://www.rbm.com.co/esb/comercio/}TipoIdTerminal"/>
 *         &lt;element name="idAdquiriente" type="{http://www.rbm.com.co/esb/comercio/}TipoIdAdquiriente"/>
 *         &lt;element name="idTransaccionTerminal" type="{http://www.rbm.com.co/esb/comercio/}TipoIdTransaccionTerminal"/>
 *         &lt;element name="modoCapturaPAN" type="{http://www.rbm.com.co/esb/comercio/}TipoModoCapturaPAN"/>
 *         &lt;element name="capacidadPIN" type="{http://www.rbm.com.co/esb/comercio/}TipoCapacidadPIN"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoInfoPuntoInteraccion", namespace = "http://www.rbm.com.co/esb/comercio/", propOrder = {
    "tipoTerminal",
    "idTerminal",
    "idAdquiriente",
    "idTransaccionTerminal",
    "modoCapturaPAN",
    "capacidadPIN"
})
public class TipoInfoPuntoInteraccion {

    @XmlElement(required = true)
    protected TipoTipoTerminal tipoTerminal;
    @XmlElement(required = true)
    protected String idTerminal;
    @XmlElement(required = true)
    protected String idAdquiriente;
    protected long idTransaccionTerminal;
    @XmlElement(required = true)
    protected TipoModoCapturaPAN modoCapturaPAN;
    @XmlElement(required = true)
    protected TipoCapacidadPIN capacidadPIN;

    /**
     * Obtiene el valor de la propiedad tipoTerminal.
     * 
     * @return
     *     possible object is
     *     {@link TipoTipoTerminal }
     *     
     */
    public TipoTipoTerminal getTipoTerminal() {
        return tipoTerminal;
    }

    /**
     * Define el valor de la propiedad tipoTerminal.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoTipoTerminal }
     *     
     */
    public void setTipoTerminal(TipoTipoTerminal value) {
        this.tipoTerminal = value;
    }

    /**
     * Obtiene el valor de la propiedad idTerminal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdTerminal() {
        return idTerminal;
    }

    /**
     * Define el valor de la propiedad idTerminal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdTerminal(String value) {
        this.idTerminal = value;
    }

    /**
     * Obtiene el valor de la propiedad idAdquiriente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdAdquiriente() {
        return idAdquiriente;
    }

    /**
     * Define el valor de la propiedad idAdquiriente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdAdquiriente(String value) {
        this.idAdquiriente = value;
    }

    /**
     * Obtiene el valor de la propiedad idTransaccionTerminal.
     * 
     */
    public long getIdTransaccionTerminal() {
        return idTransaccionTerminal;
    }

    /**
     * Define el valor de la propiedad idTransaccionTerminal.
     * 
     */
    public void setIdTransaccionTerminal(long value) {
        this.idTransaccionTerminal = value;
    }

    /**
     * Obtiene el valor de la propiedad modoCapturaPAN.
     * 
     * @return
     *     possible object is
     *     {@link TipoModoCapturaPAN }
     *     
     */
    public TipoModoCapturaPAN getModoCapturaPAN() {
        return modoCapturaPAN;
    }

    /**
     * Define el valor de la propiedad modoCapturaPAN.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoModoCapturaPAN }
     *     
     */
    public void setModoCapturaPAN(TipoModoCapturaPAN value) {
        this.modoCapturaPAN = value;
    }

    /**
     * Obtiene el valor de la propiedad capacidadPIN.
     * 
     * @return
     *     possible object is
     *     {@link TipoCapacidadPIN }
     *     
     */
    public TipoCapacidadPIN getCapacidadPIN() {
        return capacidadPIN;
    }

    /**
     * Define el valor de la propiedad capacidadPIN.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoCapacidadPIN }
     *     
     */
    public void setCapacidadPIN(TipoCapacidadPIN value) {
        this.capacidadPIN = value;
    }

}
