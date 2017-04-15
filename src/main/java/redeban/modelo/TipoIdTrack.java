
package redeban.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TipoIdTrack complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TipoIdTrack">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="track" type="{http://www.rbm.com.co/esb/}TipoTrack"/>
 *         &lt;element name="tipoCuenta" type="{http://www.rbm.com.co/esb/}TipoTipoBolsillo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoIdTrack", propOrder = {
    "track",
    "tipoCuenta"
})
public class TipoIdTrack {

    @XmlElement(required = true)
    protected String track;
    @XmlElement(required = true)
    protected TipoTipoBolsillo tipoCuenta;

    /**
     * Obtiene el valor de la propiedad track.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrack() {
        return track;
    }

    /**
     * Define el valor de la propiedad track.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrack(String value) {
        this.track = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoCuenta.
     * 
     * @return
     *     possible object is
     *     {@link TipoTipoBolsillo }
     *     
     */
    public TipoTipoBolsillo getTipoCuenta() {
        return tipoCuenta;
    }

    /**
     * Define el valor de la propiedad tipoCuenta.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoTipoBolsillo }
     *     
     */
    public void setTipoCuenta(TipoTipoBolsillo value) {
        this.tipoCuenta = value;
    }

}
