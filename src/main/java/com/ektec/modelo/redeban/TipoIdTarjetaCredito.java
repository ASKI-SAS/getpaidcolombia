
package com.ektec.modelo.redeban;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para TipoIdTarjetaCredito complex type.
 * <p>
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;complexType name="TipoIdTarjetaCredito">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="franquicia" type="{http://www.rbm.com.co/esb/}TipoFranquicia"/>
 *         &lt;element name="numTarjeta" type="{http://www.rbm.com.co/esb/}TipoNumTarjeta"/>
 *         &lt;element name="fechaExpiracion" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="codVerificacion" type="{http://www.rbm.com.co/esb/}TipoCodVerficacion" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoIdTarjetaCredito", propOrder = {
        "franquicia",
        "numTarjeta",
        "fechaExpiracion",
        "codVerificacion"
})
public class TipoIdTarjetaCredito {

    @XmlElement(required = true)
    protected TipoFranquicia franquicia;
    @XmlElement(required = true)
    protected String numTarjeta;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaExpiracion;
    protected String codVerificacion;

    /**
     * Obtiene el valor de la propiedad franquicia.
     *
     * @return possible object is
     * {@link TipoFranquicia }
     */
    public TipoFranquicia getFranquicia() {
        return franquicia;
    }

    /**
     * Define el valor de la propiedad franquicia.
     *
     * @param value allowed object is
     *              {@link TipoFranquicia }
     */
    public void setFranquicia(TipoFranquicia value) {
        this.franquicia = value;
    }

    /**
     * Obtiene el valor de la propiedad numTarjeta.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNumTarjeta() {
        return numTarjeta;
    }

    /**
     * Define el valor de la propiedad numTarjeta.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNumTarjeta(String value) {
        this.numTarjeta = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaExpiracion.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getFechaExpiracion() {
        return fechaExpiracion;
    }

    /**
     * Define el valor de la propiedad fechaExpiracion.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setFechaExpiracion(XMLGregorianCalendar value) {
        this.fechaExpiracion = value;
    }

    /**
     * Obtiene el valor de la propiedad codVerificacion.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCodVerificacion() {
        return codVerificacion;
    }

    /**
     * Define el valor de la propiedad codVerificacion.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCodVerificacion(String value) {
        this.codVerificacion = value;
    }

}
