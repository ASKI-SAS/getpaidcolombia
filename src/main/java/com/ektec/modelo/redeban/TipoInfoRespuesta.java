
package com.ektec.modelo.redeban;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TipoInfoRespuesta complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TipoInfoRespuesta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codRespuesta" type="{http://www.rbm.com.co/esb/}TipoCodRespuesta"/>
 *         &lt;element name="descRespuesta" type="{http://www.rbm.com.co/esb/}TipoDescripcion"/>
 *         &lt;element name="estado" type="{http://www.rbm.com.co/esb/}TipoEstado"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoInfoRespuesta", propOrder = {
    "codRespuesta",
    "descRespuesta",
    "estado"
})
public class TipoInfoRespuesta {

    @XmlElement(required = true)
    protected String codRespuesta;
    @XmlElement(required = true)
    protected String descRespuesta;
    @XmlElement(required = true)
    protected String estado;

    /**
     * Obtiene el valor de la propiedad codRespuesta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodRespuesta() {
        return codRespuesta;
    }

    /**
     * Define el valor de la propiedad codRespuesta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodRespuesta(String value) {
        this.codRespuesta = value;
    }

    /**
     * Obtiene el valor de la propiedad descRespuesta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescRespuesta() {
        return descRespuesta;
    }

    /**
     * Define el valor de la propiedad descRespuesta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescRespuesta(String value) {
        this.descRespuesta = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstado(String value) {
        this.estado = value;
    }

}
