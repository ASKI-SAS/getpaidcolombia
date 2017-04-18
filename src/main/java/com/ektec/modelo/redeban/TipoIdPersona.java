
package com.ektec.modelo.redeban;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TipoIdPersona complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TipoIdPersona">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tipoDocumento" type="{http://www.rbm.com.co/esb/}TipoTipoDocumento"/>
 *         &lt;element name="numDocumento" type="{http://www.rbm.com.co/esb/}TipoNumDocumento"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoIdPersona", propOrder = {
    "tipoDocumento",
    "numDocumento"
})
public class TipoIdPersona {

    @XmlElement(required = true)
    protected TipoTipoDocumento tipoDocumento;
    protected long numDocumento;

    /**
     * Obtiene el valor de la propiedad tipoDocumento.
     * 
     * @return
     *     possible object is
     *     {@link TipoTipoDocumento }
     *     
     */
    public TipoTipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * Define el valor de la propiedad tipoDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoTipoDocumento }
     *     
     */
    public void setTipoDocumento(TipoTipoDocumento value) {
        this.tipoDocumento = value;
    }

    /**
     * Obtiene el valor de la propiedad numDocumento.
     * 
     */
    public long getNumDocumento() {
        return numDocumento;
    }

    /**
     * Define el valor de la propiedad numDocumento.
     * 
     */
    public void setNumDocumento(long value) {
        this.numDocumento = value;
    }

}
