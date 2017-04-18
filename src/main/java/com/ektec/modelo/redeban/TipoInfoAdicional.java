
package com.ektec.modelo.redeban;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TipoInfoAdicional complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TipoInfoAdicional">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tipoInfo" type="{http://www.rbm.com.co/esb/}TipoTipoInfo"/>
 *         &lt;element name="descripcion" type="{http://www.rbm.com.co/esb/}TipoDescripcion"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoInfoAdicional", propOrder = {
    "tipoInfo",
    "descripcion"
})
public class TipoInfoAdicional {

    @XmlElement(required = true)
    protected String tipoInfo;
    @XmlElement(required = true)
    protected String descripcion;

    /**
     * Obtiene el valor de la propiedad tipoInfo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoInfo() {
        return tipoInfo;
    }

    /**
     * Define el valor de la propiedad tipoInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoInfo(String value) {
        this.tipoInfo = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Define el valor de la propiedad descripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

}
