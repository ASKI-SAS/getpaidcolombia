
package com.ektec.modelo.redeban;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TipoIdCuenta complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TipoIdCuenta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tipoCuenta" type="{http://www.rbm.com.co/esb/}TipoTipoCuenta"/>
 *         &lt;element name="numCuenta" type="{http://www.rbm.com.co/esb/}TipoNumCuenta"/>
 *         &lt;element name="codBanco" type="{http://www.rbm.com.co/esb/}TipoCodBanco"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoIdCuenta", propOrder = {
    "tipoCuenta",
    "numCuenta",
    "codBanco"
})
public class TipoIdCuenta {

    @XmlElement(required = true)
    protected TipoTipoCuenta tipoCuenta;
    @XmlElement(required = true)
    protected String numCuenta;
    @XmlElement(required = true)
    protected String codBanco;

    /**
     * Obtiene el valor de la propiedad tipoCuenta.
     * 
     * @return
     *     possible object is
     *     {@link TipoTipoCuenta }
     *     
     */
    public TipoTipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    /**
     * Define el valor de la propiedad tipoCuenta.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoTipoCuenta }
     *     
     */
    public void setTipoCuenta(TipoTipoCuenta value) {
        this.tipoCuenta = value;
    }

    /**
     * Obtiene el valor de la propiedad numCuenta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumCuenta() {
        return numCuenta;
    }

    /**
     * Define el valor de la propiedad numCuenta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumCuenta(String value) {
        this.numCuenta = value;
    }

    /**
     * Obtiene el valor de la propiedad codBanco.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodBanco() {
        return codBanco;
    }

    /**
     * Define el valor de la propiedad codBanco.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodBanco(String value) {
        this.codBanco = value;
    }

}
