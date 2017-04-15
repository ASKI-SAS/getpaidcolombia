
package redeban.modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para TipoInfoCompraResp complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TipoInfoCompraResp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fechaTransaccion" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="fechaPosteo" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="numAprobacion" type="{http://www.rbm.com.co/esb/}TipoNumAprobacion"/>
 *         &lt;element name="costoTransaccion" type="{http://www.rbm.com.co/esb/}TipoMonto" minOccurs="0"/>
 *         &lt;element name="infoAdicional" type="{http://www.rbm.com.co/esb/}TipoInfoAdicional" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoInfoCompraResp", namespace = "http://www.rbm.com.co/esb/comercio/compra/", propOrder = {
    "fechaTransaccion",
    "fechaPosteo",
    "numAprobacion",
    "costoTransaccion",
    "infoAdicional"
})
public class TipoInfoCompraResp {

    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaTransaccion;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaPosteo;
    @XmlElement(required = true)
    protected String numAprobacion;
    protected BigDecimal costoTransaccion;
    protected List<TipoInfoAdicional> infoAdicional;

    /**
     * Obtiene el valor de la propiedad fechaTransaccion.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaTransaccion() {
        return fechaTransaccion;
    }

    /**
     * Define el valor de la propiedad fechaTransaccion.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaTransaccion(XMLGregorianCalendar value) {
        this.fechaTransaccion = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaPosteo.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaPosteo() {
        return fechaPosteo;
    }

    /**
     * Define el valor de la propiedad fechaPosteo.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaPosteo(XMLGregorianCalendar value) {
        this.fechaPosteo = value;
    }

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
     * Obtiene el valor de la propiedad costoTransaccion.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCostoTransaccion() {
        return costoTransaccion;
    }

    /**
     * Define el valor de la propiedad costoTransaccion.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCostoTransaccion(BigDecimal value) {
        this.costoTransaccion = value;
    }

    /**
     * Gets the value of the infoAdicional property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the infoAdicional property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInfoAdicional().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TipoInfoAdicional }
     * 
     * 
     */
    public List<TipoInfoAdicional> getInfoAdicional() {
        if (infoAdicional == null) {
            infoAdicional = new ArrayList<TipoInfoAdicional>();
        }
        return this.infoAdicional;
    }

}
