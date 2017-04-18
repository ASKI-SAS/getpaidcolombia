
package com.ektec.modelo.redeban;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TipoInfoCompra complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TipoInfoCompra">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="montoTotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="infoImpuestos" type="{http://www.rbm.com.co/esb/}TipoInfoImpuestos" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="montoDetallado" type="{http://www.rbm.com.co/esb/}TipoMontoDetallado" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="referencia" type="{http://www.rbm.com.co/esb/comercio/compra/}TipoReferencia" minOccurs="0"/>
 *         &lt;element name="cantidadCuotas" type="{http://www.rbm.com.co/esb/comercio/compra/}TipoCantidadCuotas" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoInfoCompra", namespace = "http://www.rbm.com.co/esb/comercio/compra/", propOrder = {
    "montoTotal",
    "infoImpuestos",
    "montoDetallado",
    "referencia",
    "cantidadCuotas"
})
public class TipoInfoCompra {

    @XmlElement(required = true)
    protected BigDecimal montoTotal;
    protected List<TipoInfoImpuestos> infoImpuestos;
    protected List<TipoMontoDetallado> montoDetallado;
    protected String referencia;
    protected Integer cantidadCuotas;

    /**
     * Obtiene el valor de la propiedad montoTotal.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMontoTotal() {
        return montoTotal;
    }

    /**
     * Define el valor de la propiedad montoTotal.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMontoTotal(BigDecimal value) {
        this.montoTotal = value;
    }

    /**
     * Gets the value of the infoImpuestos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the infoImpuestos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInfoImpuestos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TipoInfoImpuestos }
     * 
     * 
     */
    public List<TipoInfoImpuestos> getInfoImpuestos() {
        if (infoImpuestos == null) {
            infoImpuestos = new ArrayList<TipoInfoImpuestos>();
        }
        return this.infoImpuestos;
    }

    /**
     * Gets the value of the montoDetallado property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the montoDetallado property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMontoDetallado().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TipoMontoDetallado }
     * 
     * 
     */
    public List<TipoMontoDetallado> getMontoDetallado() {
        if (montoDetallado == null) {
            montoDetallado = new ArrayList<TipoMontoDetallado>();
        }
        return this.montoDetallado;
    }

    /**
     * Obtiene el valor de la propiedad referencia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * Define el valor de la propiedad referencia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferencia(String value) {
        this.referencia = value;
    }

    /**
     * Obtiene el valor de la propiedad cantidadCuotas.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCantidadCuotas() {
        return cantidadCuotas;
    }

    /**
     * Define el valor de la propiedad cantidadCuotas.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCantidadCuotas(Integer value) {
        this.cantidadCuotas = value;
    }

}
