
package redeban.modelo;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TipoInfoPago complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TipoInfoPago">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FIIDEntidadAdquiriente" type="{http://www.rbm.com.co/esb/}TipoFIIDEntidad"/>
 *         &lt;element name="numAutorizacion" type="{http://www.rbm.com.co/esb/}TipoNumAutorizacion"/>
 *         &lt;element name="codConvenioRecaudo" type="{http://www.rbm.com.co/esb/}TipoCodConvenio"/>
 *         &lt;element name="numReferenciaPago" type="{http://www.rbm.com.co/esb/}TipoNumReferenciaPago"/>
 *         &lt;element name="monto" type="{http://www.rbm.com.co/esb/}TipoMonto"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoInfoPago", propOrder = {
    "fiidEntidadAdquiriente",
    "numAutorizacion",
    "codConvenioRecaudo",
    "numReferenciaPago",
    "monto"
})
public class TipoInfoPago {

    @XmlElement(name = "FIIDEntidadAdquiriente", required = true)
    protected String fiidEntidadAdquiriente;
    @XmlElement(required = true)
    protected String numAutorizacion;
    @XmlElement(required = true)
    protected String codConvenioRecaudo;
    @XmlElement(required = true)
    protected String numReferenciaPago;
    @XmlElement(required = true)
    protected BigDecimal monto;

    /**
     * Obtiene el valor de la propiedad fiidEntidadAdquiriente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFIIDEntidadAdquiriente() {
        return fiidEntidadAdquiriente;
    }

    /**
     * Define el valor de la propiedad fiidEntidadAdquiriente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFIIDEntidadAdquiriente(String value) {
        this.fiidEntidadAdquiriente = value;
    }

    /**
     * Obtiene el valor de la propiedad numAutorizacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumAutorizacion() {
        return numAutorizacion;
    }

    /**
     * Define el valor de la propiedad numAutorizacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumAutorizacion(String value) {
        this.numAutorizacion = value;
    }

    /**
     * Obtiene el valor de la propiedad codConvenioRecaudo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodConvenioRecaudo() {
        return codConvenioRecaudo;
    }

    /**
     * Define el valor de la propiedad codConvenioRecaudo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodConvenioRecaudo(String value) {
        this.codConvenioRecaudo = value;
    }

    /**
     * Obtiene el valor de la propiedad numReferenciaPago.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumReferenciaPago() {
        return numReferenciaPago;
    }

    /**
     * Define el valor de la propiedad numReferenciaPago.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumReferenciaPago(String value) {
        this.numReferenciaPago = value;
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

}
