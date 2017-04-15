
package redeban.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TipoInfoMedioPagoIdCuenta complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TipoInfoMedioPagoIdCuenta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idCuenta" type="{http://www.rbm.com.co/esb/}TipoIdCuenta"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoInfoMedioPagoIdCuenta", namespace = "http://www.rbm.com.co/esb/comercio/compra/", propOrder = {
    "idCuenta"
})
public class TipoInfoMedioPagoIdCuenta {

    @XmlElement(required = true)
    protected TipoIdCuenta idCuenta;

    /**
     * Obtiene el valor de la propiedad idCuenta.
     * 
     * @return
     *     possible object is
     *     {@link TipoIdCuenta }
     *     
     */
    public TipoIdCuenta getIdCuenta() {
        return idCuenta;
    }

    /**
     * Define el valor de la propiedad idCuenta.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoIdCuenta }
     *     
     */
    public void setIdCuenta(TipoIdCuenta value) {
        this.idCuenta = value;
    }

}
