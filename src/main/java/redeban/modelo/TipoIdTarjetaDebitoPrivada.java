
package redeban.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TipoIdTarjetaDebitoPrivada complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TipoIdTarjetaDebitoPrivada">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="franquicia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="numTarjeta" type="{http://www.rbm.com.co/esb/}TipoNumTarjeta"/>
 *         &lt;element name="tipoBolsillo" type="{http://www.rbm.com.co/esb/}TipoTipoBolsillo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoIdTarjetaDebitoPrivada", propOrder = {
    "franquicia",
    "numTarjeta",
    "tipoBolsillo"
})
public class TipoIdTarjetaDebitoPrivada {

    @XmlElement(required = true)
    protected String franquicia;
    @XmlElement(required = true)
    protected String numTarjeta;
    @XmlElement(required = true)
    protected TipoTipoBolsillo tipoBolsillo;

    /**
     * Obtiene el valor de la propiedad franquicia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFranquicia() {
        return franquicia;
    }

    /**
     * Define el valor de la propiedad franquicia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFranquicia(String value) {
        this.franquicia = value;
    }

    /**
     * Obtiene el valor de la propiedad numTarjeta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumTarjeta() {
        return numTarjeta;
    }

    /**
     * Define el valor de la propiedad numTarjeta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumTarjeta(String value) {
        this.numTarjeta = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoBolsillo.
     * 
     * @return
     *     possible object is
     *     {@link TipoTipoBolsillo }
     *     
     */
    public TipoTipoBolsillo getTipoBolsillo() {
        return tipoBolsillo;
    }

    /**
     * Define el valor de la propiedad tipoBolsillo.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoTipoBolsillo }
     *     
     */
    public void setTipoBolsillo(TipoTipoBolsillo value) {
        this.tipoBolsillo = value;
    }

}
