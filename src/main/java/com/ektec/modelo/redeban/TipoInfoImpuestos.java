
package com.ektec.modelo.redeban;


import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TipoInfoImpuestos complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TipoInfoImpuestos">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tipoImpuesto" type="{http://www.rbm.com.co/esb/}TipoTipoImpuesto"/>
 *         &lt;element name="monto" type="{http://www.rbm.com.co/esb/}TipoMonto"/>
 *         &lt;element name="baseImpuesto" type="{http://www.rbm.com.co/esb/}TipoMonto" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoInfoImpuestos", propOrder = {
    "tipoImpuesto",
    "monto",
    "baseImpuesto"
})
public class TipoInfoImpuestos {

    @XmlElement(required = true)
    protected TipoTipoImpuesto tipoImpuesto;
    @XmlElement(required = true)
    protected BigDecimal monto;
    protected BigDecimal baseImpuesto;

    /**
     * Obtiene el valor de la propiedad tipoImpuesto.
     * 
     * @return
     *     possible object is
     *     {@link TipoTipoImpuesto }
     *     
     */
    public TipoTipoImpuesto getTipoImpuesto() {
        return tipoImpuesto;
    }

    /**
     * Define el valor de la propiedad tipoImpuesto.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoTipoImpuesto }
     *     
     */
    public void setTipoImpuesto(TipoTipoImpuesto value) {
        this.tipoImpuesto = value;
    }

    /**
     * Obtiene el valor de la propiedad monto.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMonto() {
        return monto;
    }

    /**
     * Define el valor de la propiedad monto.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMonto(BigDecimal value) {
        this.monto = value;
    }

    /**
     * Obtiene el valor de la propiedad baseImpuesto.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBaseImpuesto() {
        return baseImpuesto;
    }

    /**
     * Define el valor de la propiedad baseImpuesto.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBaseImpuesto(BigDecimal value) {
        this.baseImpuesto = value;
    }

}
