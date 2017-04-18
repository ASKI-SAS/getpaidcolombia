
package com.ektec.modelo.redeban;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TipoInfoRefCancelacion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TipoInfoRefCancelacion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numAprobacion" type="{http://www.rbm.com.co/esb/}TipoNumAprobacion"/>
 *         &lt;element name="idTransaccionAutorizador" type="{http://www.rbm.com.co/esb/}TipoIdTransaccionAutorizador"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoInfoRefCancelacion", propOrder = {
    "numAprobacion",
    "idTransaccionAutorizador"
})
public class TipoInfoRefCancelacion {

    @XmlElement(required = true)
    protected String numAprobacion;
    protected long idTransaccionAutorizador;

    /**
     * Obtiene el valor de la propiedad numAprobacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumAprobacion() {
        return numAprobacion;
    }

    /**
     * Define el valor de la propiedad numAprobacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumAprobacion(String value) {
        this.numAprobacion = value;
    }

    /**
     * Obtiene el valor de la propiedad idTransaccionAutorizador.
     * 
     */
    public long getIdTransaccionAutorizador() {
        return idTransaccionAutorizador;
    }

    /**
     * Define el valor de la propiedad idTransaccionAutorizador.
     * 
     */
    public void setIdTransaccionAutorizador(long value) {
        this.idTransaccionAutorizador = value;
    }

}
