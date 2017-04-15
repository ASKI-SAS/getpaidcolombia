
package redeban.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TipoCabeceraSolicitud complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TipoCabeceraSolicitud">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="infoPuntoInteraccion" type="{http://www.rbm.com.co/esb/comercio/}TipoInfoPuntoInteraccion"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoCabeceraSolicitud", namespace = "http://www.rbm.com.co/esb/comercio/compra/", propOrder = {
    "infoPuntoInteraccion"
})
public class TipoCabeceraSolicitud {

    @XmlElement(required = true)
    protected TipoInfoPuntoInteraccion infoPuntoInteraccion;

    /**
     * Obtiene el valor de la propiedad infoPuntoInteraccion.
     * 
     * @return
     *     possible object is
     *     {@link TipoInfoPuntoInteraccion }
     *     
     */
    public TipoInfoPuntoInteraccion getInfoPuntoInteraccion() {
        return infoPuntoInteraccion;
    }

    /**
     * Define el valor de la propiedad infoPuntoInteraccion.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoInfoPuntoInteraccion }
     *     
     */
    public void setInfoPuntoInteraccion(TipoInfoPuntoInteraccion value) {
        this.infoPuntoInteraccion = value;
    }

}
