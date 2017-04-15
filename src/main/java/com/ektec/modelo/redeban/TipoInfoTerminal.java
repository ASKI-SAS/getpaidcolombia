
package com.ektec.modelo.redeban;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TipoInfoTerminal complex type.
 * <p>
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;complexType name="TipoInfoTerminal">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nombreAdquiriente" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="infoUbicacion" type="{http://www.rbm.com.co/esb/}TipoInfoUbicacion"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoInfoTerminal", namespace = "http://www.rbm.com.co/esb/comercio/", propOrder = {
        "nombreAdquiriente",
        "infoUbicacion"
})
public class TipoInfoTerminal {

    @XmlElement(required = true)
    protected String nombreAdquiriente;
    @XmlElement(required = true)
    protected TipoInfoUbicacion infoUbicacion;

    /**
     * Obtiene el valor de la propiedad nombreAdquiriente.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNombreAdquiriente() {
        return nombreAdquiriente;
    }

    /**
     * Define el valor de la propiedad nombreAdquiriente.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNombreAdquiriente(String value) {
        this.nombreAdquiriente = value;
    }

    /**
     * Obtiene el valor de la propiedad infoUbicacion.
     *
     * @return possible object is
     * {@link TipoInfoUbicacion }
     */
    public TipoInfoUbicacion getInfoUbicacion() {
        return infoUbicacion;
    }

    /**
     * Define el valor de la propiedad infoUbicacion.
     *
     * @param value allowed object is
     *              {@link TipoInfoUbicacion }
     */
    public void setInfoUbicacion(TipoInfoUbicacion value) {
        this.infoUbicacion = value;
    }

}
