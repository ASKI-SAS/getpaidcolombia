
package redeban.modelo;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TipoMontoDetallado complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TipoMontoDetallado">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tipoMontoDetallado" type="{http://www.rbm.com.co/esb/}TipoTipoMontoDetallado"/>
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
@XmlType(name = "TipoMontoDetallado", propOrder = {
    "tipoMontoDetallado",
    "monto"
})
public class TipoMontoDetallado {

    @XmlElement(required = true)
    protected TipoTipoMontoDetallado tipoMontoDetallado;
    @XmlElement(required = true)
    protected BigDecimal monto;

    /**
     * Obtiene el valor de la propiedad tipoMontoDetallado.
     * 
     * @return
     *     possible object is
     *     {@link TipoTipoMontoDetallado }
     *     
     */
    public TipoTipoMontoDetallado getTipoMontoDetallado() {
        return tipoMontoDetallado;
    }

    /**
     * Define el valor de la propiedad tipoMontoDetallado.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoTipoMontoDetallado }
     *     
     */
    public void setTipoMontoDetallado(TipoTipoMontoDetallado value) {
        this.tipoMontoDetallado = value;
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
